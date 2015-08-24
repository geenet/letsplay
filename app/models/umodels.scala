package models

import java.util.UUID
import scala.collection.convert.WrapAsScala
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.data.validation.ValidationError
import com.datastax.driver.core.utils.UUIDs
import com.datastax.driver.core.BoundStatement
import com.datastax.driver.core.ResultSet
import com.datastax.driver.core.querybuilder.QueryBuilder
import com.datastax.driver.core.Row
import java.util.UUID
import scala.util.Try


import java.util.UUID
import scala.util.Try

case class Users(id: UUID, email: String, firstname: String, lastname: String, password: String)

class UsersRepository(client: SimpleClient) {

  import Utils._

  def getAll(implicit ctxt: ExecutionContext): Future[List[Users]] = {

    import WrapAsScala.iterableAsScalaIterable

    client.getRows.toScalaFuture.map { rows =>
      rows.map(row => users(row)).toList
    }
  }

  private def users(row: Row): Users =
    Users(row.getUUID("id"), row.getString("email"), row.getString("firstname"),
         row.getString("lastname"), row.getString("password"))

  def getById(id: UUID)(implicit ctxt: ExecutionContext): Future[Users] = {
    val sql = "SELECT * FROM gee.users WHERE id = ?;"
    val stmt = new BoundStatement(client.session.prepare(sql))
    client.session.executeAsync(stmt.bind(id)).toScalaFuture.map(rs => users(rs.one))
  }

  def insert(email: String, firstname: String, lastname: String, password: String)(implicit ctxt: ExecutionContext): Future[UUID] = {
    val sql ="INSERT INTO gee.users (id, email, firstname, lastname, password) VALUES (?, ?, ?, ?, ?);"
    val stmt = new BoundStatement(client.session.prepare(sql))
    val id = UUIDs.timeBased
    client.session.executeAsync(stmt.bind(id, email, firstname,lastname, password)).toScalaFuture.map(rs => id)
  }
}


object JsonFormats2 {
  // Deserializer for java.util.UUID, from latest play Reads (was added on 2014-03-01 to master,
  // see https://github.com/playframework/playframework/pull/2428)

  private def uuidReader(checkUuuidValidity: Boolean = false): Reads[java.util.UUID] = new Reads[java.util.UUID] {
    def check(s: String)(u: UUID): Boolean = (u != null && s == u.toString())
    def parseUuid(s: String): Option[UUID] = {
      val uncheckedUuid = Try(UUID.fromString(s)).toOption

      if (checkUuuidValidity) {
        uncheckedUuid filter check(s)
      } else {
        uncheckedUuid
      }
    }

    def reads(json: JsValue) = json match {
      case JsString(s) => {
        parseUuid(s).map(JsSuccess(_)).getOrElse(JsError(Seq(JsPath() -> Seq(ValidationError("error.expected.uuid")))))
      }
      case _ => JsError(Seq(JsPath() -> Seq(ValidationError("error.expected.uuid"))))
    }
  }

  private implicit val uuidReads: Reads[java.util.UUID] = uuidReader()
  private implicit val uuidWrites: Writes[UUID] = Writes { uuid => JsString(uuid.toString) }

  implicit val usersFormat: Format[Users] = Json.format[Users]
  implicit val usersDataReads = (
    (__ \ 'email).read[String] and
      (__ \ 'firstname).read[String] and
      (__ \ 'lastname).read[String] and
    (__ \ 'password).read[String]) tupled
}

