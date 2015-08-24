
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/a/code/github/guguncube/letsplay/conf/routes
// @DATE:Tue Aug 25 00:20:27 CEST 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:8
  CassApp_0: controllers.CassApp,
  // @LINE:12
  UsersApp_3: controllers.UsersApp,
  // @LINE:17
  Application_2: controllers.Application,
  // @LINE:31
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    CassApp_0: controllers.CassApp,
    // @LINE:12
    UsersApp_3: controllers.UsersApp,
    // @LINE:17
    Application_2: controllers.Application,
    // @LINE:31
    Assets_1: controllers.Assets
  ) = this(errorHandler, CassApp_0, UsersApp_3, Application_2, Assets_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, CassApp_0, UsersApp_3, Application_2, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """song""", """controllers.CassApp.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """song""", """controllers.CassApp.createSong"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """song/$id<[^/]+>""", """controllers.CassApp.songById(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UsersApp.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UsersApp.registerUsers"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/$id<[^/]+>""", """controllers.UsersApp.userById(id:String)"""),
    ("""GET""", this.prefix, """controllers.Application.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/$filename<.+>""", """controllers.Application.staticUrl(filename:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """url/$filename<.+>""", """controllers.Application.staticUrl(filename:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """file/$filename<.+>""", """controllers.Application.staticFile(filename:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """file/$filename<.+>""", """controllers.Application.staticFile(filename:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """file/$filename<.+>""", """controllers.Application.staticFile(filename:String)"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """file/$filename<.+>""", """controllers.Application.staticFile(filename:String)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """file/$filename<.+>""", """controllers.Application.staticFile(filename:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """base""", """controllers.Application.base"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """home""", """controllers.Application.home"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """json""", """controllers.Application.jsonMe"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search""", """controllers.Application.search(q:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:8
  private[this] lazy val controllers_CassApp_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("song")))
  )
  private[this] lazy val controllers_CassApp_index0_invoker = createInvoker(
    CassApp_0.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CassApp",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """song"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_CassApp_createSong1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("song")))
  )
  private[this] lazy val controllers_CassApp_createSong1_invoker = createInvoker(
    CassApp_0.createSong,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CassApp",
      "createSong",
      Nil,
      "POST",
      """""",
      this.prefix + """song"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_CassApp_songById2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("song/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CassApp_songById2_invoker = createInvoker(
    CassApp_0.songById(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CassApp",
      "songById",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """song/$id<[^/]+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UsersApp_index3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UsersApp_index3_invoker = createInvoker(
    UsersApp_3.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersApp",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """users"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UsersApp_registerUsers4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UsersApp_registerUsers4_invoker = createInvoker(
    UsersApp_3.registerUsers,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersApp",
      "registerUsers",
      Nil,
      "POST",
      """""",
      this.prefix + """users"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UsersApp_userById5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsersApp_userById5_invoker = createInvoker(
    UsersApp_3.userById(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsersApp",
      "userById",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """users/$id<[^/]+>"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Application_index6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index6_invoker = createInvoker(
    Application_2.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Application_staticUrl7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticUrl7_invoker = createInvoker(
    Application_2.staticUrl(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticUrl",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """v1/$filename<.+>"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_Application_staticUrl8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("url/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticUrl8_invoker = createInvoker(
    Application_2.staticUrl(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticUrl",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """url/$filename<.+>"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Application_staticFile9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("file/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticFile9_invoker = createInvoker(
    Application_2.staticFile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticFile",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """file/$filename<.+>"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Application_staticFile10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("file/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticFile10_invoker = createInvoker(
    Application_2.staticFile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticFile",
      Seq(classOf[String]),
      "POST",
      """""",
      this.prefix + """file/$filename<.+>"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Application_staticFile11_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("file/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticFile11_invoker = createInvoker(
    Application_2.staticFile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticFile",
      Seq(classOf[String]),
      "DELETE",
      """""",
      this.prefix + """file/$filename<.+>"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Application_staticFile12_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("file/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticFile12_invoker = createInvoker(
    Application_2.staticFile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticFile",
      Seq(classOf[String]),
      "PATCH",
      """""",
      this.prefix + """file/$filename<.+>"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_Application_staticFile13_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("file/"), DynamicPart("filename", """.+""",false)))
  )
  private[this] lazy val controllers_Application_staticFile13_invoker = createInvoker(
    Application_2.staticFile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "staticFile",
      Seq(classOf[String]),
      "PUT",
      """""",
      this.prefix + """file/$filename<.+>"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_Application_base14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("base")))
  )
  private[this] lazy val controllers_Application_base14_invoker = createInvoker(
    Application_2.base,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "base",
      Nil,
      "GET",
      """""",
      this.prefix + """base"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_Application_home15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("home")))
  )
  private[this] lazy val controllers_Application_home15_invoker = createInvoker(
    Application_2.home,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "home",
      Nil,
      "GET",
      """""",
      this.prefix + """home"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Application_jsonMe16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("json")))
  )
  private[this] lazy val controllers_Application_jsonMe16_invoker = createInvoker(
    Application_2.jsonMe,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "jsonMe",
      Nil,
      "GET",
      """""",
      this.prefix + """json"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_Application_search17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search")))
  )
  private[this] lazy val controllers_Application_search17_invoker = createInvoker(
    Application_2.search(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "search",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """search"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_Assets_versioned18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned18_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_CassApp_index0_route(params) =>
      call { 
        controllers_CassApp_index0_invoker.call(CassApp_0.index)
      }
  
    // @LINE:9
    case controllers_CassApp_createSong1_route(params) =>
      call { 
        controllers_CassApp_createSong1_invoker.call(CassApp_0.createSong)
      }
  
    // @LINE:10
    case controllers_CassApp_songById2_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_CassApp_songById2_invoker.call(CassApp_0.songById(id))
      }
  
    // @LINE:12
    case controllers_UsersApp_index3_route(params) =>
      call { 
        controllers_UsersApp_index3_invoker.call(UsersApp_3.index)
      }
  
    // @LINE:13
    case controllers_UsersApp_registerUsers4_route(params) =>
      call { 
        controllers_UsersApp_registerUsers4_invoker.call(UsersApp_3.registerUsers)
      }
  
    // @LINE:14
    case controllers_UsersApp_userById5_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UsersApp_userById5_invoker.call(UsersApp_3.userById(id))
      }
  
    // @LINE:17
    case controllers_Application_index6_route(params) =>
      call { 
        controllers_Application_index6_invoker.call(Application_2.index)
      }
  
    // @LINE:18
    case controllers_Application_staticUrl7_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticUrl7_invoker.call(Application_2.staticUrl(filename))
      }
  
    // @LINE:19
    case controllers_Application_staticUrl8_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticUrl8_invoker.call(Application_2.staticUrl(filename))
      }
  
    // @LINE:20
    case controllers_Application_staticFile9_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticFile9_invoker.call(Application_2.staticFile(filename))
      }
  
    // @LINE:21
    case controllers_Application_staticFile10_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticFile10_invoker.call(Application_2.staticFile(filename))
      }
  
    // @LINE:22
    case controllers_Application_staticFile11_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticFile11_invoker.call(Application_2.staticFile(filename))
      }
  
    // @LINE:23
    case controllers_Application_staticFile12_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticFile12_invoker.call(Application_2.staticFile(filename))
      }
  
    // @LINE:24
    case controllers_Application_staticFile13_route(params) =>
      call(params.fromPath[String]("filename", None)) { (filename) =>
        controllers_Application_staticFile13_invoker.call(Application_2.staticFile(filename))
      }
  
    // @LINE:25
    case controllers_Application_base14_route(params) =>
      call { 
        controllers_Application_base14_invoker.call(Application_2.base)
      }
  
    // @LINE:26
    case controllers_Application_home15_route(params) =>
      call { 
        controllers_Application_home15_invoker.call(Application_2.home)
      }
  
    // @LINE:27
    case controllers_Application_jsonMe16_route(params) =>
      call { 
        controllers_Application_jsonMe16_invoker.call(Application_2.jsonMe)
      }
  
    // @LINE:28
    case controllers_Application_search17_route(params) =>
      call(params.fromQuery[String]("q", None)) { (q) =>
        controllers_Application_search17_invoker.call(Application_2.search(q))
      }
  
    // @LINE:31
    case controllers_Assets_versioned18_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned18_invoker.call(Assets_1.versioned(path, file))
      }
  }
}