package se.thced.deploy;

import static org.junit.jupiter.api.Assertions.*;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.junit5.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;

@ExtendWith(VertxExtension.class)
class TestMainVerticle {

  @Test
  void deploymentTest(Vertx vertx, VertxTestContext testContext) {
    vertx
        .deployVerticle(MainVerticle::new, new DeploymentOptions())
        .mapEmpty()
        .onSuccess(v -> testContext.verify(() -> assertEquals(6, vertx.deploymentIDs().size())))
        .onComplete(testContext.succeedingThenComplete());
  }
}
