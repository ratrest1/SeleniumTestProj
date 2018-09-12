import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class SearchToursTest {

    @Test
    public void searchAll_Empty_Pass(){
        String toursXPath = "//*[@id=\"body-section\"]/section/div[2]/div/div[2]/ul/li[3]/a";
        String searchXPath = "//*[@id=\"TOURS\"]/form/div[5]/button";


        BrowserSingleton browser = BrowserSingleton.getInstance();
        browser.setDriver("Chrome");
        browser.getPage("https://www.phptravels.net/");
        WebElement toursClick = browser.getElement(SearchType.XPath, toursXPath);
        toursClick.click();

        WebElement searchClick = browser.getElement(SearchType.XPath, searchXPath);
        searchClick.click();

        browser.waitSeconds(3);

        browser.close();

    }



}
