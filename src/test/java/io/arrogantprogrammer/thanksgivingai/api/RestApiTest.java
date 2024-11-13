package io.arrogantprogrammer.thanksgivingai.api;


import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class RestApiTest {



    @Test
    public void testCreateMenu() {
        String requestBody = """
            {
                "email": "shrek@duloc.org",
                "stateCodes": null,
            }
        """;

        with()
            .body(requestBody)
            .header("Content-Type", MediaType.APPLICATION_JSON)
            .when()
            .body(new CreateMenuCommand("shrek@duloc.org", List.of("None")))
            .post("/thanksgivingai/menu")
            .then()
            .statusCode(200)
            .assertThat().body("email", equalTo("shrek@duloc.org"));
    }
}
