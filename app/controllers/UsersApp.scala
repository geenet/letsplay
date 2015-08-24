package controllers

import play.api._
import play.api.mvc._
import models.SimpleClient
import models.UsersRepository
import play.api.libs.json.Json
import com.datastax.driver.core.utils.UUIDs
import models.Users
import play.api.libs.json.JsError
import scala.concurrent.Future
import java.util.UUID
import scala.util.Try
import play.api.Play.current
import play.api.i18n.Messages.Implicits._
//def getRepo{
  //var cassandra: SimpleClient = cassandra = new SimpleClient("127.0.0.1")
  //cassandra = new SimpleClient(app.configuration.getString("cassandra.node")
//  controller = new controllers.Application(new SongsRepository(cassandra))
//}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import models.JsonFormats._
import play.api.i18n.Messages

/*
http://localhost:9000/users
http://localhost:9000/users/6d26a6d0-4aaf-11e5-9c96-21b25660753d
{"email":"a@a.com",
"lastname":"John",
"firstname":"Smith",
"password":"12345"}
* */

//usersRepo: UsersRepository

class UsersApp extends Controller {

  def index = Action {implicit request =>
      //Ok(views.html.index("Your new application is ready."))
      import spray.json._
      import DefaultJsonProtocol._ // if you don't supply your own Protocol (see below)
      //and do one or more of the following:
      //Parse a JSON string into its Abstract Syntax Tree (AST) representation
      val source = """{ "some": "JSON source" }"""
      val jsonAst = source.parseJson // or JsonParser(source)
      Ok(Messages("alpha"))
  }

  def index2 = Action.async {
    var usersRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
    //import com.codahale.jerkson.Json._
    import org.json4s._
    import org.json4s.native.Serialization
    import org.json4s.native.Serialization.{read, write}
    implicit val formats = Serialization.formats(NoTypeHints)

    //usersRepo.getAll.map(users => Ok(users.toJson))
    usersRepo.getAll.map(users => Ok(write(users)))
    ///write(users)

     //val ser = write(Child("Mary", 5, None))
    // val ser = write(users)


    //usersRepo.getAll.map(users => Ok(Json.toJson(users)))

    //usersRepo.getAll.map(users => Ok(Json.toJson(users)))
  }

  def registerUsers = Action.async(parse.json) { implicit request =>
    // Json Format defined in models.JsonFormats.usersDataReads
    request.body.validate[(String, String, String, String)].map {
      case (email, firstname, lastname, password) => {
        var usersRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
        usersRepo.insert(email, firstname, lastname, password).map( id =>
          Created.withHeaders("Location" -> routes.UsersApp.userById(id.toString).absoluteURL(false))
        )
      }
    }.recoverTotal {
        e => Future.successful(BadRequest("Detected error:" + JsError.toFlatJson(e)))
    }
  }

  def userById(id: String) = Action.async {
      var usersRepo: UsersRepository = new UsersRepository(new SimpleClient("127.0.0.1"))
       usersRepo.getById(UUID.fromString(id)).map(users => Ok(Json.toJson(users)))
  }

}
