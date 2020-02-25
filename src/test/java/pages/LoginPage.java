package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    WebElement emailField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "login_form")
    WebElement loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void openPage() {
        driver.get("https://seniorlink--staging.cs93.my.salesforce.com/");
        isPageOpened();
        PageFactory.initElements(driver, this); //LoginPage.this ?
    }

    public void isPageOpened() {
       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_form")));
    }

    public HomePage login(User user) {
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        loginForm.submit();
        HomePage homePage = new HomePage(driver);
        //homePage.isPageOpened();
        return homePage;
    }
}
