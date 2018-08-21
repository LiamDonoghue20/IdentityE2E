import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertEquals;

public class DVLAStepFile {

    WebDriver myWebDriver;
    static ExtentReports extent;
    ExtentTest test = extent.startTest("Testing the DVLA Website");
    Vehicle vehicle = new Vehicle();

    @Given("^I am on the webpage https://www\\.gov\\.uk/get-vehicle-information-from-dvla$")
    public void loadWebPage() {

        //loading up a new instance of the chrome browser
        extent =  new ExtentReports("C:\\Users\\Admin\\Desktop\\ExtentDVLATest.html", true);
        myWebDriver = new ChromeDriver();
        myWebDriver.manage().window().maximize();
        String url = "https://www.gov.uk/get-vehicle-information-from-dvla";
        myWebDriver.get(url);
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


        try {
            assertEquals("https://vehicleenquiry.service.gov.uk/", myWebDriver.getCurrentUrl());
            test.log(LogStatus.PASS, "Vehicle service loaded");
        } catch  (AssertionError e ){
            test.log(LogStatus.FAIL, "Unable to load vehicle service");
        }


    }
    @When("^ And I can call the service bean$")
    public void callServiceBean(){

    }

    @Then("^the data on display should match the records on the csv file$")
    public void verifyData() {

        int vehiclesSearched = 0;

        do {

            SearchPage searchPage = PageFactory.initElements(myWebDriver, SearchPage.class);

            searchPage.enterSearchBar();

            try {
                assertEquals(vehicle.getVehicleColour(), searchPage.vehicleResultColour());
                test.log(LogStatus.PASS, "Vehicle is the correct colour");
            } catch (AssertionError e) {
                test.log(LogStatus.FAIL, "Vehicle colour does not match database from site");
            }

            try {
                assertEquals(vehicle.getVehicleMake(), searchPage.vehicleResultMake());
                test.log(LogStatus.PASS, "Vehicle is the correct make");
            } catch (AssertionError e) {
                test.log(LogStatus.FAIL, "Vehicle make does not match database from site");
            }
            searchPage.clickSearchAgain();
            searchPage.continueButton();
            vehiclesSearched++;
        } while (vehiclesSearched < 10);

    }

}
