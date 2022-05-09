package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage_PageFactory {

    WebDriver driver;

    @FindBy(id = "name")
    @CacheLookup
    WebElement txt_username;

    @FindBy(id = "password")
    WebElement txt_password;

    @FindBy(id = "login")
    WebElement btn_login;

    @FindBy(xpath = "//div[text()='Password is invalid']")
    WebElement txt_error_message;


    public LoginPage_PageFactory(WebDriver driver){
        this.driver = driver;
//        PageFactory.initElements(driver, this);

        /**
         * Better method to wait for ajax web page elements.So, for all elements, we will wait for 30 sec
         */
        AjaxElementLocatorFactory ajaxFactory = new AjaxElementLocatorFactory(driver, 30);
        PageFactory.initElements(ajaxFactory, this);
    }

    public void enterUserName(String username){
        txt_username.sendKeys(username);
    }

    public void enterPassword(String password){
        txt_password.sendKeys(password);
    }

    public void clickLogIn(){
        btn_login.click();
    }

    public void checkErrorMessageIsDisplayed(){
        txt_error_message.isDisplayed();
    }
}
