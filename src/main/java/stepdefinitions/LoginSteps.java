package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static constants.Constants.TimeoutVariables.IMPLICITY_WAIT;
import static constants.Constants.TimeoutVariables.PAGE_LOAD_WAIT;
import static constants.Constants.Urls.TEST_PROJECT_WEB_SITE;

public class LoginSteps {

    WebDriver driver = null;

    @Given("Browser is opened")
    public void browser_is_opened() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITY_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
        driver.manage().window().maximize();
    }

    @And("User is on login page")
    public void user_is_on_login_page() {
        driver.navigate().to(TEST_PROJECT_WEB_SITE);
    }

    @When("^User enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String  password) {
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

    }
    @And("User clicks on Login button")
    public void user_clicks_on_Login_button() {
        driver.findElement(By.id("login")).click();
    }

    @Then("User is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        driver.findElement(By.id("logout")).isDisplayed();

        driver.close();
        driver.quit();
    }
}
