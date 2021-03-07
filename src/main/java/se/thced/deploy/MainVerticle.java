package se.thced.deploy;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.ServiceHelper;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) {
    // Static in size as we add more verticles -- $$$
    new SerialDeploy()
        .apply(ServiceHelper.loadFactories(Deployable.class))
        .<Void>mapEmpty()
        .onComplete(startPromise);
  }
}
