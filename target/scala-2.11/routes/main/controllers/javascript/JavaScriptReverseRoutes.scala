
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/a/code/github/guguncube/letsplay/conf/routes
// @DATE:Tue Aug 25 00:20:27 CEST 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:8
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:12
  class ReverseUsersApp(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def userById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersApp.userById",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
    // @LINE:12
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersApp.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
    // @LINE:13
    def registerUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsersApp.registerUsers",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseCassApp(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def createSong: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CassApp.createSong",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "song"})
        }
      """
    )
  
    // @LINE:8
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CassApp.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "song"})
        }
      """
    )
  
    // @LINE:10
    def songById: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CassApp.songById",
      """
        function(id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "song/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
        }
      """
    )
  
  }

  // @LINE:31
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def staticFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.staticFile",
      """
        function(filename) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "file/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("filename", filename)})
          }
        
        }
      """
    )
  
    // @LINE:25
    def base: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.base",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "base"})
        }
      """
    )
  
    // @LINE:27
    def jsonMe: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.jsonMe",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "json"})
        }
      """
    )
  
    // @LINE:28
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.search",
      """
        function(q) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("q", q)])})
        }
      """
    )
  
    // @LINE:26
    def home: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.home",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "home"})
        }
      """
    )
  
    // @LINE:18
    def staticUrl: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.staticUrl",
      """
        function(filename) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("filename", filename)})
          }
        
        }
      """
    )
  
    // @LINE:17
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}