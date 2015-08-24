
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/a/code/github/guguncube/letsplay/conf/routes
// @DATE:Tue Aug 25 00:20:27 CEST 2015

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseUsersApp UsersApp = new controllers.ReverseUsersApp(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCassApp CassApp = new controllers.ReverseCassApp(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseUsersApp UsersApp = new controllers.javascript.ReverseUsersApp(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCassApp CassApp = new controllers.javascript.ReverseCassApp(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
