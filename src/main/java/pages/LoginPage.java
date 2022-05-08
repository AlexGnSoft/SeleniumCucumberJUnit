package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By txt_username = By.id("name");
    By txt_password = By.id("password");
    By btn_login = By.id("login");
    By btn_logout = By.id("logout");
    By txt_error_message = By.xpath("//div[text()='Password is invalid']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username){
        driver.findElement(txt_username).sendKeys(username);
    }

    public void enterPassword( String password){
        driver.findElement(txt_password).sendKeys(password);
    }

    public void clickLogIn(){
        driver.findElement(btn_login).click();
    }

    public void checkLogOutIsDisplayed(){
        driver.findElement(btn_logout).isDisplayed();
    }

    public void checkErrorMessageIsDisplayed(){
        driver.findElement(txt_error_message).isDisplayed();
    }

//    public void loginValidUser(String username, String password){
//        driver.findElement(txt_username).sendKeys(username);
//        driver.findElement(txt_password).sendKeys(password);
//        driver.findElement(btn_login).click();
//
//    }
}
