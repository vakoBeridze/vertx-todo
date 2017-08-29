package ge.vertx;

import ge.vertx.verticles.TodoVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class Main {
    public static void main(String[] args) {
        Verticle verticle = new TodoVerticle();

        Vertx vertx = Vertx.vertx();
        JsonObject config = new JsonObject()
          .put("service.type", "jdbc")
          .put("url", "jdbc:mysql://localhost/todo?characterEncoding=UTF-8&useSSL=false")
          .put("driver_class", "com.mysql.cj.jdbc.Driver")
          .put("user", "root")
          .put("password", "admin")
          .put("max_pool_size", 30);

        DeploymentOptions options = new DeploymentOptions().setConfig(config);
        vertx.deployVerticle(verticle, options);

    }
}

