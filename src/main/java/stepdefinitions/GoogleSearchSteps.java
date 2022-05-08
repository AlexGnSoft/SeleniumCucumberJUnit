package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static constants.Constants.TimeoutVariables.IMPLICITY_WAIT;
import static constants.Constants.TimeoutVariables.PAGE_LOAD_WAIT;
import static constants.Constants.Urls.GOOGLE_WEB_SITE;

public class GoogleSearchSteps {

    WebDriver driver = null;

//    @Given("Browser is opened")
//    public void browser_is_opened() {
//        String projectPath = System.getProperty("user.dir");
//        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/drivers/chromedriver");
//        driver = new ChromeDriver();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITY_WAIT));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_WAIT));
//        driver.manage().window().maximize();
//
//    }
    @And("User is on google search page")
    public void user_is_on_google_search_page() {
        driver.navigate().to(GOOGLE_WEB_SITE);
        driver.findElement(By.xpath("//button[@class='tHlp8d']/div[text()='I agree']")).click();

    }
    @When("User enters a text in google search box")
    public void user_enters_a_text_in_google_search_box() {
        driver.findElement(By.name("q")).sendKeys("beds for kids");
    }
    @And("User hits enter button")
    public void user_hits_enter_button() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
    @Then("User is navigated to the Search Results page")
    public void user_is_navigated_to_the_search_results_page() {
        driver.getPageSource().contains("Купить: beds for kids");
        driver.close();
        driver.quit();
    }


}
