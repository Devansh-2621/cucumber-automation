package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.restassured.RestAssured;

public class TestHooks {

    @Before
    public void setUp() {
        System.out.println("🔧 Setting up test environment...");
        RestAssured.baseURI = "http://localhost:3000"; // ✅ Fix: Set correct JSON Server URL
    }

    @After
    public void tearDown() {
        System.out.println("🧹 Cleaning up after test execution...");
    }
}
