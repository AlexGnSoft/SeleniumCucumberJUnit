package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagefactory.HomePage_PageFactory;
import pagefactory.LoginPage_PageFactory;

import java.time.Duration;

import static constants.Constants.TimeoutVariables.IMPLICITY_WAIT;
import static constants.Constants.TimeoutVariables.PAGE_LOAD_WAIT;
import static constants.Constants.Urls.TEST_PROJECT_WEB_SITE;

public class LoginSteps_PageFactory {

    WebDriver driver = null;
    LoginPage_PageFactory loginPagePF;
    HomePage_PageFactory homePage;

    @Given("Browser is opened")
    public void browser_is_opened() {

        System.out.println("====Page Factory 'LoginSteps_PageFactory 'is running=====");

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

        if(!driver.getTitle().equals("TestProject Demo")){
            throw new IllegalStateException("You're not at TestProject Demo. Your current Url is " + driver.getCurrentUrl());
        }
    }

    @When("^User enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String  password) {
        loginPagePF = new LoginPage_PageFactory(driver);
        loginPagePF.enterUserName(username);
        loginPagePF.enterPassword(password);

    }
    @And("User clicks on Login button")
    public void user_clicks_on_Login_button() {
        loginPagePF.clickLogIn();
    }

    @Then("User is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        homePage = new HomePage_PageFactory(driver);
        homePage.checkLogOutIsDisplayed();

        driver.close();
        driver.quit();
    }

    @Then("User see a system error message")
    public void user_see_a_system_error_message() {
        loginPagePF.checkErrorMessageIsDisplayed();

        driver.close();
        driver.quit();
    }
}
