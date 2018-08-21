import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    Vehicle vehicle = new Vehicle();

    public void enterSearchBar(){

        searchBar.click();
        searchBar.sendKeys(vehicle.getVehicleRegNumber());
        //A way to itterate through the excel document and automate each vehicle reg is needed
        searchButton.click();

    }

    public String vehicleResultColour(){
       String vehicleResultColour = vehicleColourDisplay.getText();
       return vehicleResultColour;
    }

    public String vehicleResultMake(){
       String vehicleResultMake = vehicleMakeDisplay.getText();
       return vehicleResultMake;
    }

    public void clickSearchAgain(){
        searchAgainOption.click();
    }

    public void continueButton(){
        continueButton.click();
    }
}
