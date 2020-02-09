package tests;

import models.HIS;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.*;
import java.util.Properties;

public class LoginPageTest extends BaseTest {
    LoginPage loginpage;
    HomePage homePage;
    private Properties properties;
    private User user;
    HIS his;

    @BeforeClass
    public void startClassTest() throws IOException {
        try (InputStream input = new FileInputStream("src/test/resources/application.properties")) {

            properties = new Properties();
            properties.load(input);
        }
        catch (Exception e){
            System.out.println("File not found");
        }
        user = new User(properties.getProperty("user.password"), properties.getProperty("user.name"));
    }

    @BeforeMethod
    public void openProjectsPage() {
        loginpage = new LoginPage(driver);
        loginpage.openPage();
        homePage = loginpage.login(user);
        his = HIS.builder()
                .assessmentDate("1/30/2020")
                .dateAssessorSigned("1/30/2020")
                .status("In Progress")
                .accessibilityConcerns("Yes")
                .assessmentType("Update")
                .dwellingType("Multi Dwelling Home/ apartment")
                .familyLivingOn("Multiple Floors/ Levels")
                .numberofBathrooms("2 Bathrooms")
                .numberofBedrooms("1 Bedroom")
                .stairsRequiredoConsumerBedroom("Yes")
                .stairsRequiredtoConsumerBathroom("No")
                .accessibilityConcernsExplained("Warm yourself by the fire, son")
                .homeDescriptionComments("And the morning will come soon")
                .homeMeaningComments("I'll tell you stories of a better time")
                .homeStabilityComments("In a place that we once knew")
                .homeStoryComments("Before we packed our bags\n And left all this behind us in the dust")
                .build();
    }

//    @Test
//    public void loginToApplication() {
//       loginpage = new LoginPage(driver);
//       loginpage.openPage();
//       homePage = loginpage.login(user);
//    }

    @Test
    public void formCreatingWithValidParameters() {
        homePage.openPage()
                .clickNewButton()
                .clickNextButton()
                .clickDuplicateButton()
                .completeForm(his)
                .clickSaveButton();
    }

}
