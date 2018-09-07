import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class SearchTests {

    @Test
    public void searchByCity(){
        BrowserSingleton browser = BrowserSingleton.getInstance();
        browser.setDriver("Chrome");
        browser.getPage("https://www.phptravels.net/");
        WebElement webE = browser.getElement(SearchType.ID,"li_myaccount");
        System.out.println(webE.isDisplayed());
    }
}
