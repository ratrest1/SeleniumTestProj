import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LinkTests {

    @Test
    public void correctInternalLink_VirginGorda_Pass(){
        BrowserSingleton browser = BrowserSingleton.getInstance();
        browser.setDriver("Chrome");
        browser.getPage("https://www.phptravels.net/");
        WebElement e = browser.getElement(SearchType.ClassName,"text-muted");
        e.click();



        Assert.assertEquals("Virgin Gorda beaches and lobste", browser.getCurrPageTitle() );
        browser.close();
    }

    @Test
    public void correctExternalLink_iTunes_Pass(){
        BrowserSingleton browser = BrowserSingleton.getInstance();
        browser.setDriver("Chrome");
        browser.getPage("https://www.phptravels.net/");
        WebElement webE = browser.getElement(SearchType.ClassName,"footer__appStoreName");
        browser.moveToElement(webE);
        try {
            webE.click();
        }catch(ElementNotVisibleException e){ System.out.println("ElementNotVisibleException!"); }
        browser.getWindow( 1);
        Assert.assertEquals("Connecting to the iTunes Store.", browser.getCurrPageTitle() );
        browser.close();
    }

    @Test
    public void IncorrectLink_Fail(){

    }

}
