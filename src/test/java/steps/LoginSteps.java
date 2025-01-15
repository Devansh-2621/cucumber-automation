package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginSteps {

    private String username;
    private String password;
    private String resultMessage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("Navigating to the login page...");
    }

    @When("the user enters {string} as username and {string} as password")
    public void the_user_enters_as_username_and_password(String username, String password) {
        this.username = username;
        this.password = password;

        // Simulate server-side logic
        if ("user".equals(username) && "pass".equals(password)) {
            resultMessage = "Login successful!";
        } else {
            resultMessage = "Invalid credentials.";
        }
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        System.out.println("Login button clicked.");
    }

    @Then("the user should see {string}")
    public void the_user_should_see(String expectedMessage) {
        System.out.println("Verifying the result message...");
        Assert.assertEquals(expectedMessage, resultMessage);
    }
}
