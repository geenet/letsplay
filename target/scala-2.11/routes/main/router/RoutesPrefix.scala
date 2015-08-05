
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/a/code/github/guguncube/letsplay/conf/routes
// @DATE:Wed Aug 05 00:47:31 CEST 2015


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
