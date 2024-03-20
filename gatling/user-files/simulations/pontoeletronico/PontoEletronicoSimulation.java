import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class PontoEletronicoSimulation extends Simulation {

  HttpProtocolBuilder httpProtocol =
    http.baseUrl("https://hkton-fiapi-pontoeletronico.azurewebsites.net")
      .header("Authorization","Bearer ??????")
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .acceptEncodingHeader("gzip, deflate")
      .userAgentHeader(
        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/119.0"
      );

  ScenarioBuilder baterPonto = scenario("Bater o ponto").exec(
    http("Criar")
      .get("/api/marcacao/agora")
      .check(status().in(200, 201))
  );

  {
    setUp(
      baterPonto.injectOpen(constantUsersPerSec(1000).during(5))
    ).protocols(httpProtocol);
  }
}