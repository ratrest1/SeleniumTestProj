import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchCarsTests {

    @Test
    public void Search(){
        String carsXPath = "//*[@id=\"body-section\"]/section/div[2]/div/div[2]/ul/li[4]/a";
        String pickupXPath = "select2-choice";
        String egyptXPath = "//*[@id=\"select2-drop\"]/ul/li[3]/div";
        String startDateXPath = "//*[@id=\"departcar\"]";
        String startDayXPath = "/html/body/div[11]/div[1]/table/tbody/tr[5]/td[6]";
        String endDayXPath = "/html/body/div[12]/div[1]/table/tbody/tr[6]/td[2]";
        String startTimeXpath = "//*[@id=\"CARS\"]/form/div[4]/div/select";
        String startTimeChoiceXpath = "//*[@id=\"CARS\"]/form/div[4]/div/select/option[14]";
        String endTimeXpath = "//*[@id=\"CARS\"]/form/div[6]/div/select";
        String endTimeChoiceXpath = "//*[@id=\"CARS\"]/form/div[6]/div/select/option[38]";
        String submitXPath = "//*[@id=\"CARS\"]/form/div[7]/button";

        BrowserSingleton browser = BrowserSingleton.getInstance();
        browser.setDriver("Chrome");
        browser.getPage("https://www.phptravels.net/");
        WebElement carsClick = browser.getElement(SearchType.XPath, carsXPath);
        carsClick.click();

        List<WebElement> pickupClick = browser.getElements(SearchType.ClassName, pickupXPath);
        for ( WebElement e : pickupClick) {
            if(e.getText().equalsIgnoreCase("Pick up Location")) {
                e.click();
                WebElement loc = browser.getElement(SearchType.XPath, egyptXPath);
                loc.click();
                break;
            }
        }

        WebElement startDateClick = browser.getElement(SearchType.XPath, startDateXPath);
        startDateClick.click();
        WebElement startDayClick = browser.getElement(SearchType.XPath, startDayXPath);
        startDayClick.click();

        WebElement endDayClick = browser.getElement(SearchType.XPath, endDayXPath);
        endDayClick.click();

        WebElement startTimeClick = browser.getElement(SearchType.XPath, startTimeXpath);
        startTimeClick.click();
        WebElement startTimeChoiceClick = browser.getElement(SearchType.XPath, startTimeChoiceXpath);
        startTimeChoiceClick.click();

        WebElement endTimeClick = browser.getElement(SearchType.XPath, endTimeXpath);
        endTimeClick.click();
        WebElement endTimeChoiceClick = browser.getElement(SearchType.XPath, endTimeChoiceXpath);
        endTimeChoiceClick.click();

        WebElement submitClick = browser.getElement(SearchType.XPath, submitXPath);
        submitClick.click();

    }
}