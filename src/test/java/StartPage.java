import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage {


    @FindBy(xpath = "//*[@id=\"get-started\"]/a")
    WebElement startNowButton;


    public void clickButton(){

        startNowButton.click();

    }

}
