package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Input {
    private static final String activePage = "//div[@class='windowViewMode-maximized active lafPageHost']";
    String inputLocator = activePage + "//span[text()= '%s']/../..//input";

    public Input(){
    }

    public void fillInField(WebDriver driver, String fieldName, String text) {
        if (null != text) {
            System.out.println(String.format("Writing %s into input with label %s", text, fieldName));
            try {
                By inputBy = By.xpath(String.format(inputLocator, fieldName));
                driver.findElement(inputBy).sendKeys(text);
            }
            catch (Exception e){
                Assert.fail(String.format("Cannot write %s into field with label %s", text, fieldName));
                e.printStackTrace();
            }
        }
    }
}
