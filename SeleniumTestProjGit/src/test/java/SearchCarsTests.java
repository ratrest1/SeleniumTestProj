import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class SearchCarsTests {

    @Test
    public void Search(){
        String carsXPath = "//*[@id=\"body-section\"]/section/div[2]/div/div[2]/ul/li[4]/a";

        BrowserSingleton browser = BrowserSingleton.getInstance();
        browser.setDriver("Chrome");
        browser.getPage("https://www.phptravels.net/");
        WebElement carsClick = browser.getElement(SearchType.XPath, carsXPath);
        carsClick.click();
    }
}