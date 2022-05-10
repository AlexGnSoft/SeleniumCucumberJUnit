package stepdefinitions_for_hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static constants.Constants.TimeoutVariables.IMPLICITY_WAIT;
import static constants.Constants.TimeoutVariables.PAGE_LOAD_WAIT;

public class HooksExampleSteps {

    WebDriver driver = null;

    @Before
    public void browserSetUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITY_WAIT));
        driver.manage().window().maximize();

        System.out.println("I am inside before scenario");
    }

    @After
    public void tearDown(){
        System.out.println("I am inside after scenario");
        driver.close();
        driver.quit();
    }

    @BeforeStep
    public static void beforeSteps(){
        System.out.println("I am inside beforeSteps");
    }

    @AfterStep
    public static void afterSteps(){
        System.out.println("I am inside afterSteps");
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {

    }
    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {

    }
    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {

    }
    @Then("User is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {

    }
}
