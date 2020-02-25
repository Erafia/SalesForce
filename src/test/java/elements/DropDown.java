package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.JavascriptUtilities;

public class DropDown {
    private static final String activePage = "//div[@class='windowViewMode-maximized active lafPageHost']";
    private static final String dropdownLocator = activePage + "//span[text() = '%s']/../..//a";
    private static final String dropdownOptionLocator = "//div[contains(@class,'uiMenuList') and contains(@class, 'visible')]//a[text() = '%s']";

    public void selectValue(WebDriver driver, String dropDownName, String visibleOption) {
        if (null != visibleOption) {
            By selectByLocator = By.xpath(String.format(dropdownLocator, dropDownName));
            new JavascriptUtilities().clickJs(driver, driver.findElement(selectByLocator));
            //driver.findElement(selectByLocator).click();
            By optionLocator = By.xpath(String.format(dropdownOptionLocator, visibleOption));
            new JavascriptUtilities().clickJs(driver, driver.findElement(optionLocator));
            //driver.findElement(optionLocator).click();
        }
    }
}
