import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class SearchVisaTests {

    @Test
    public void SearchVisa(){
        String visaXPath = "//*[@id=\"body-section\"]/section/div[2]/div/div[2]/ul/li[5]/a";
        String firstCountryXPath = "//*[@id=\"s2id_autogen4\"]/a";
        String firstCountryChoiceXPath = "//*[@id=\"select2-drop\"]/ul/li[78]";
        String desCountryXPath = "//*[@id=\"s2id_autogen6\"]/a";
        String desCountryChoiceXPath = "//*[@id=\"select2-drop\"]/ul/li[214]";
        String submitXPath = "//*[@id=\"VISA\"]/form/div[3]/button";

        BrowserSingleton browser = BrowserSingleton.getInstance();
        browser.setDriver("Chrome");
        browser.getPage("https://www.phptravels.net/");
        WebElement visaClick = browser.getElement(SearchType.XPath, visaXPath);
        visaClick.click();

        WebElement firstCountryClick = browser.getElement(SearchType.XPath, firstCountryXPath);
        firstCountryClick.click();

        WebElement firstCountryChoiceClick = browser.getElement(SearchType.XPath, firstCountryChoiceXPath);
        firstCountryChoiceClick.click();


        WebElement desCountryClick = browser.getElement(SearchType.XPath, desCountryXPath);
        desCountryClick.click();

        WebElement desCountryChoiceClick = browser.getElement(SearchType.XPath, desCountryChoiceXPath);
        desCountryChoiceClick.click();

        WebElement submitClick = browser.getElement(SearchType.XPath, submitXPath);
        submitClick.click();

        browser.waitSeconds(3);

        browser.close();
    }

}
