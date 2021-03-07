package se.thced.deploy;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

public class SillyThree extends AbstractVerticle implements Deployable {

  private static final Logger log = LoggerFactory.getLogger(SillyThree.class);

  @Override
  public void start(Promise<Void> startPromise) {
    log.info("Started..");
    vertx.setTimer(200, id -> startPromise.complete());
  }
}
