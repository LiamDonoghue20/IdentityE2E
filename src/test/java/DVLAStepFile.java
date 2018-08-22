import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class DVLAStepFile {

   private WebDriver myWebDriver;
   private static ExtentReports extent;

   ExtentTest test = extent.startTest("Testing that the DVLA service is accessible");

    Vehicle vehicle = new Vehicle();

    @Before
    public void setUp(){

        //loading up a new instance of the chrome browser
        extent =  new ExtentReports("C:\\Users\\Liam\\Desktop\\ExtentDVLAAccessTest.html", true);
        myWebDriver = new ChromeDriver();
        myWebDriver.manage().window().maximize();
        String url = "https://www.gov.uk/get-vehicle-information-from-dvla";
        myWebDriver.get(url);

    }

    @Given("^I am on the webpage https://www\\.gov\\.uk/get-vehicle-information-from-dvla$")
    public void loadWebPage() {

        //assert the correct webpage has been loaded

        try {
            assertEquals("https://www.gov.uk/get-vehicle-information-from-dvla", myWebDriver.getCurrentUrl());
            test.log(LogStatus.PASS, "The webpage has loaded properly");
        } catch (AssertionError e) {
            test.log(LogStatus.FAIL, "The webpage could not be loaded");
        }
        StartPage startPage = PageFactory.initElements(myWebDriver, StartPage.class);
        //using the login method to enter login details
        startPage.clickButton();

    }

    @When("^I am on the vehicle details page$")
    public void detailsPageVerify() {


        //assert the vehicle details service is accessible
        try {
            assertEquals("https://vehicleenquiry.service.gov.uk/", myWebDriver.getCurrentUrl());
            test.log(LogStatus.PASS, "Vehicle service loaded");
        } catch  (AssertionError e ){
            test.log(LogStatus.FAIL, "Unable to load vehicle service");
        }


    }

    @Then("^the data on display should match the records on the csv file$")
    public void verifyData() throws IOException {

        //run

            SearchPage searchPage = PageFactory.initElements(myWebDriver, SearchPage.class);

            searchPage.enterSearchBar();
            searchPage.clickSearchAgain();
            searchPage.continueButton();
    }

}
