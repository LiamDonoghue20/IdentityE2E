import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.media.sound.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static junit.framework.TestCase.assertEquals;

public class SearchPage {

    @FindBy(xpath = "//*[@id=\"Vrm\"]")
    WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/div[2]/fieldset/button")
    WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"pr3\"]/div/ul/li[3]/span[2]/strong")
    WebElement vehicleColourDisplay;

    @FindBy(xpath = "//*[@id=\"pr3\"]/div/ul/li[2]/span[2]/strong")
    WebElement vehicleMakeDisplay;

    @FindBy(xpath = "//*[@id=\"Correct_False\"]")
    WebElement searchAgainOption;

    @FindBy(xpath = "//*[@id=\"pr3\"]/div/button")
    WebElement continueButton;

    FileInputStream file = null;
    XSSFWorkbook workbook = null;
    XSSFCell registration;
    XSSFCell vehicleMake;
    XSSFCell vehicleColour;

    VehicleAssigner vehicleAssigner = new VehicleAssigner();
    Vehicle vehicle = new Vehicle();

    private static ExtentReports extent;


    public String vehicleResultColour(){
        String vehicleResultColour = vehicleColourDisplay.getText();
        return vehicleResultColour;
    }

    public String vehicleResultMake(){
        String vehicleResultMake = vehicleMakeDisplay.getText();
        return vehicleResultMake;
    }

    public void enterSearchBar() throws EncryptedDocumentException, InvalidFormatException, IOException {

        extent =  new ExtentReports("C:\\Users\\Liam\\Desktop\\ExtentDVLADataAssertTest.html", true);
        ExtentTest test = extent.startTest("Testing that the database data matches the DVLA site");


            searchBar.click();
            searchBar.sendKeys(vehicle.getVehicleRegNumber());
            searchButton.click();
            vehicleAssigner.assignVehicles();

    try {
        assertEquals(vehicle.getVehicleMake(), vehicleResultMake());
        test.log(LogStatus.PASS,"Vehicle make matches the record in the database");
    } catch (AssertionError e){
        test.log(LogStatus.FAIL, "Vehicle make does not match the record in the database");
    }

    try {
            assertEquals(vehicle.getVehicleColour(), vehicleResultColour());
            test.log(LogStatus.PASS,"Vehicle make matches the record in the database");
    } catch (AssertionError e){
            test.log(LogStatus.FAIL, "Vehicle colour does not match the record in the database");
             }
    }



    public void clickSearchAgain() {
        searchAgainOption.click();
    }

    public void continueButton(){
        continueButton.click();
    }
}
