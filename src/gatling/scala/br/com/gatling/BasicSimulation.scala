package br.com.gatling

import io.gatling.http.Predef._
import io.gatling.core.Predef._

class BasicSimulation extends Simulation {
  val httpConf = http.baseURL("http://localhost:8080/")
  val scn = scenario("Basic Simulation")
    .exec(http("request_1")
      .get("webflux/reactive/placa/ILR1288"))
    .pause(5)
  setUp(
    scn.inject(rampUsers(10000) over(10))
  ).protocols(httpConf)
}