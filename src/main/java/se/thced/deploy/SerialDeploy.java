package se.thced.deploy;

import static io.vertx.core.Future.succeededFuture;

import io.vertx.core.Future;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import java.util.Collection;
import java.util.function.Function;

public class SerialDeploy implements Function<Collection<? extends Verticle>, Future<Void>> {

  @Override
  public Future<Void> apply(Collection<? extends Verticle> verticles) {
    Future<String> fut = succeededFuture();
    for (Verticle v : verticles) {
      fut = fut.compose(id -> Vertx.currentContext().owner().deployVerticle(v));
    }
    return fut.mapEmpty();
  }
}
