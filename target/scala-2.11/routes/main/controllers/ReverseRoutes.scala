
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/a/code/github/guguncube/letsplay/conf/routes
// @DATE:Tue Aug 25 00:20:27 CEST 2015

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:8
package controllers {

  // @LINE:12
  class ReverseUsersApp(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def userById(id:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "users/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
    // @LINE:12
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:13
    def registerUsers(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "users")
    }
  
  }

  // @LINE:8
  class ReverseCassApp(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def createSong(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "song")
    }
  
    // @LINE:8
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "song")
    }
  
    // @LINE:10
    def songById(id:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "song/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
  }

  // @LINE:31
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def versioned(file:Asset): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:17
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def staticFile(filename:String): Call = {
    
      (filename: @unchecked) match {
      
        // @LINE:20
        case (filename)  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "file/" + implicitly[PathBindable[String]].unbind("filename", filename))
      
      }
    
    }
  
    // @LINE:25
    def base(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "base")
    }
  
    // @LINE:27
    def jsonMe(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "json")
    }
  
    // @LINE:28
    def search(q:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "search" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("q", q)))))
    }
  
    // @LINE:26
    def home(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "home")
    }
  
    // @LINE:18
    def staticUrl(filename:String): Call = {
    
      (filename: @unchecked) match {
      
        // @LINE:18
        case (filename)  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "v1/" + implicitly[PathBindable[String]].unbind("filename", filename))
      
      }
    
    }
  
    // @LINE:17
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
  }


}