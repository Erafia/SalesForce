package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TextArea {
    private static final String activePage = "//div[@class='windowViewMode-maximized active lafPageHost']";
    String textAreaLocator = activePage + "//span[text()= '%s']/../..//textarea";

    public TextArea(){
    }

    public void fillInTextArea(WebDriver driver, String textAreaName, String text) {
        if (null != text) {
            System.out.println(String.format("Writing %s into text area with label %s", text, textAreaName));
            try {
                By areaBy = By.xpath(String.format(textAreaLocator, textAreaName));
                driver.findElement(areaBy).sendKeys(text);
            }
            catch (Exception e){
                Assert.fail(String.format("Cannot write %s into text area with label %s", text, textAreaName));
                e.printStackTrace();
            }
        }
    }
}
