package se.thced.deploy;

import io.vertx.core.Verticle;

/**
 * Marker-interface for Verticles that gets deployed via SPI
 */
public interface Deployable extends Verticle {}
