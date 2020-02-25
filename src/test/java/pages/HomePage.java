package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import models.HIS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {
    By WINDOW = By.id("window");
    By NEW_BUTTON = By.xpath("//div[@title = 'New']");
    By NEXT_BUTTON = By.xpath("//span[contains(text(), 'Next')]");
    By SAVE_BUTTON = By.xpath("//div[@class='windowViewMode-maximized active lafPageHost']//span[contains(text(), 'Save')]");
    By DUPLICATE = By.xpath("//button[contains(@class,'slds-button slds-button') and text()='Yes']");
    By IN_PROGRESS_RADIO = By.xpath("//section[@aria-expanded='true']//span[text()='In Progress']//preceding-sibling::span[contains(@class,'slds-radio')]");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
        driver.get("https://seniorlink--staging.lightning.force.com/lightning/r/0064F000006lAKhQAM/related/Home_Assessments__r/view?ws=%2Flightning%2Fr%2FOpportunity%2F0064F000006lAKhQAM%2Fview");
        isPageOpened();
        return this;
    }

    public HomePage clickNewButton() {
        driver.findElement(NEW_BUTTON).click();
        return this;
    }

    public HomePage clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();
        return this;
    }

    public HomePage clickDuplicateButton() {
        driver.findElement(DUPLICATE).click();
        return this;
    }

    public HomePage completeForm(HIS his){
        new Input().fillInField(driver, "Assessment Date", his.getAssessmentDate());
        new Input().fillInField(driver, "Date Assessor Signed", his.getDateAssessorSigned());
        new DropDown().selectValue(driver, "Status", his.getStatus());
        new DropDown().selectValue(driver, "Assessment Type", his.getAssessmentType());
        new DropDown().selectValue(driver, "Dwelling Type", his.getDwellingType());
        new DropDown().selectValue(driver, "Family Living On", his.getFamilyLivingOn());
        new DropDown().selectValue(driver, "Accessibility Concerns", his.getAccessibilityConcerns());
        new DropDown().selectValue(driver, "Number of Bedrooms", his.getNumberofBedrooms());
        new DropDown().selectValue(driver, "Stairs Required to Consumer Bedroom", his.getStairsRequiredoConsumerBedroom());
        new DropDown().selectValue(driver, "Number of Bathrooms", his.getNumberofBathrooms());
        new DropDown().selectValue(driver, "Stairs Required to Consumer Bathroom", his.getStairsRequiredtoConsumerBathroom());
        new TextArea().fillInTextArea(driver,"Home Story Comments", his.getHomeStoryComments());
        new TextArea().fillInTextArea(driver,"Home Meaning Comments", his.getHomeMeaningComments());
        new TextArea().fillInTextArea(driver,"Accessibility Concerns Explained", his.getAccessibilityConcernsExplained());
        new TextArea().fillInTextArea(driver,"Home Stability Comments", his.getHomeStabilityComments());
        new TextArea().fillInTextArea(driver,"Home Description Comments", his.getHomeDescriptionComments());
        return this;
    }

    public void clickSaveButton(){
        driver.findElement(SAVE_BUTTON).click();
    }
    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BUTTON));
    }


}
