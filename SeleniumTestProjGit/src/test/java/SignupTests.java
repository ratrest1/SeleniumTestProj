import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;

public class SignupTests {

    @Test
    void signup(){
        BrowserSingleton browser = BrowserSingleton.getInstance();
        //browser.setDriver("Chrome");
        browser.getPage("https://phptravels.net/");
        WebElement element = browser.getElement(SearchType.XPath,"//*[@id=\"li_myaccount\"]/a");
        if(element==null)
            System.out.println("test");
        element.click();

        //browser.close();

    }

}
