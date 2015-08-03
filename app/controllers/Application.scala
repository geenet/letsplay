package controllers

import play.api.mvc._

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import play.api.libs.json._
import play.api.Play.current

import scala.collection.mutable.ListBuffer
import scala.io.Source

class Application extends Controller {

  def index = Action {
    Ok("Alpha")
  }

  def base = Action { request =>
    Ok("Got METHOD: " + request.method )
  }

  def home = Action {
      downloadJsonOk("https://api-mobile.home24.com/api/v1/search?query=Bettb%C3%A4nke")
  }

  def search(q: String) = Action {
      downloadJsonOk("https://api-mobile.home24.com/api/v1/search?query=" + q)
  }

  def staticUrl(path: String) = Action {
    val base: String = current.configuration.getString("json.url.base").get
    val url: String = base + "" + path
    println("url " + url)
    downloadJsonOk(url)
  }

  def articles(q: Option[String]) = Action {request =>
    q match {
      case Some(query) => downloadJsonOk("https://api-mobile.home24.com/api/v1/search?query=" + q)
      case None => staticJsonFile("articles/articles", request.uri, request.method)
    }
  }

  def article(sku: String) = Action {request =>
    staticJsonFile("articles/" + sku, request.uri, request.method)
  }

  def staticFile(filename: String) = Action { request =>
    staticJsonFile(filename, request.uri, request.method)
  }

  def staticJsonFile(filename: String, uri: String, method:String): Result =  {
    val root: String = current.configuration.getString("json.files.path").get
    var paramList: String = ""

    if (uri contains "?"){
      val paramString = uri.split("\\?")(1).mkString
      paramList = if(paramString == None ) "" else "?"+paramString
    }

    val filepath: String = root + "/" + method.toLowerCase + "/" + filename + paramList

    println("filepath " + filepath)
    val source = scala.io.Source.fromFile(filepath)
    val jsonText = try source.mkString finally source.close()
    val jsonObject: JsValue = Json.parse(jsonText)
    Ok(jsonObject).as("application/json")
  }
/**
  def staticActionFile(filename: String, uri: String, method:String) = Action {
    val root: String = current.configuration.getString("json.files.path").get
    var paramList: String = ""

    if (uri contains "?"){
      val paramString = uri.split("\\?")(1).mkString
      paramList = if(paramString == None ) "" else "?"+paramString
    }

    val filepath: String = root + "/" + method.toLowerCase + "/" + filename + paramList

    println("filepath " + filepath)
    val source = scala.io.Source.fromFile(filepath)
    val jsonText = try source.mkString finally source.close()
    val jsonObject: JsValue = Json.parse(jsonText)
    Ok(jsonObject).as("application/json")
  }
  */

  def downloadJsonOk(url: String) =  {
    val articles = ListBuffer.newBuilder[Map[String, JsValue]]
    val content = getRestContent(url)
    val jsonObject: JsValue = Json.parse(content)
    (jsonObject \ "_embedded" \ "results").as[List[JsValue]].foreach(
      h24article => {
        val price: JsValue = Json.toJson(
          Map[String, JsValue](
            ("format", Json.toJson("%P% €")),
            ("isoCode", (h24article \ "price" \ "currency").get),
            ("original", (h24article \ "price" \ "amount").get),
            ("current", (h24article \ "price" \ "amount").get),
            ("discountPercentage", Json.toJson(0))
          )
        )

        val images = ListBuffer.newBuilder[JsValue]
        (h24article \ "media").as[List[JsValue]].foreach(
          media => {
            images += Json.toJson(
              Map[String, JsValue](
                ("medium", (media \ "uri").get)
              )
            )
          }
        )
        val article: Map[String, JsValue] = Map[String, JsValue](
          ("id", (h24article \ "sku").get),
          ("title", (h24article \ "title").get),
          ("price", price),
          ("images", Json.toJson(images.result().toSeq))
        )
        articles += article
      }
    )
    Ok(
      Json.toJson(
        Map[String, JsValue](
          ("page", Json.toJson(1)),
          ("size", Json.toJson(25)),
          ("totalPages", Json.toJson(5000)),
          ("totalElements", Json.toJson(5000)),
          ("minPrice", Json.toJson(2)),
          ("maxPrice", Json.toJson(5000)),
          ("items", Json.toJson(articles.result().toSeq))
        )
      )
    ).as("application/json")
  }

  /**
   * Returns the text content from a REST URL. Returns a blank String if there
   * is a problem.
   */
  def getRestContent(url:String): String = {
    val httpClient = new DefaultHttpClient()
    val httpGet = new HttpGet(url)
    // set the desired header values
    httpGet.setHeader("Content-Type", "application/json")
    httpGet.setHeader("X-App-Domain", "1")
    httpGet.setHeader("Accept-Language", "de_DE")
    val httpResponse = httpClient.execute(httpGet)
    val entity = httpResponse.getEntity
    var content = ""
    if (entity != null) {
        val inputStream = entity.getContent
        content = Source.fromInputStream(inputStream).getLines().mkString
        inputStream.close()
    }
    httpClient.getConnectionManager.shutdown()
    content
  }

}
