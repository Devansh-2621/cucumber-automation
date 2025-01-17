package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.util.Map;

public class LoginSteps {

    private Map<String, Object> apiResponse;  // ✅ Stores API response as a Map (Object to allow flexibility)
    private Response response;  // ✅ Stores the full HTTP response
    private String actualMessage;  // ✅ Stores the validation message

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("User is on the login page.");
    }

    @When("the user enters {string} as username and {string} as password")
    public void user_logs_in(String username, String password) {
        System.out.println("API Request: Username = " + username + ", Password = " + password);

        // ✅ Send API Request to JSON Server
        response = given()
            .baseUri("http://localhost:3000")
            .when()
            .get("/users?username=" + username + "&password=" + password);

        System.out.println("Full API Response: " + response.asString());  // ✅ Print full API response for debugging

        // ✅ Extract Response Data
        if (!response.jsonPath().getList("$").isEmpty()) {
            apiResponse = response.jsonPath().getMap("[0]");  // ✅ Get first matching user
            actualMessage = apiResponse.get("statusMessage").toString(); // ✅ Extract statusMessage from API
        } else {
            actualMessage = "Invalid credentials."; // ✅ Default message when no user found
        }

        System.out.println("API Response Processed: " + apiResponse);
    }

    @And("clicks the login button")
    public void clicks_the_login_button() {
        System.out.println("User clicked the login button.");
    }

    @Then("the user should see {string}")
    public void login_should_be(String expectedMessage) {
        System.out.println("Expected: " + expectedMessage + ", Actual: " + actualMessage);
        assertEquals(expectedMessage, actualMessage);
    }
}
