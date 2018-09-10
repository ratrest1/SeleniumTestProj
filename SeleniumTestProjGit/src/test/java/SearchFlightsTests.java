import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchFlightsTests {

    @Test
    public void searchByCity(){
        String flightXPath = "//*[@id=\"body-section\"]/section/div[2]/div/div[2]/ul/li[2]/a";
        String cityCSS = "a.select2-choice";
        String resultXPath = "//*[@id=\"select2-drop\"]/ul/li[2]/div";
        String resultAriXPath = "//*[@id=\"select2-drop\"]/ul/li[5]/div";
        String dateTextXPath = "//*[@id=\"flights\"]/form/div[3]/div/input";
        String departDayXPath = "/html/body/div[13]/div[1]/table/tbody/tr[5]/td[7]";
        String guestXPath = "//*[@id=\"flights\"]/form/div[5]/div/input";
        String adultXPath = "//*[@id=\"manual_flightTravelers\"]/div/div/div[2]/section/div/div[1]/div[1]/select/option[2]";

        BrowserSingleton browser = BrowserSingleton.getInstance();
        browser.setDriver("Chrome");
        browser.getPage("https://www.phptravels.net/");
        WebElement flightClick = browser.getElement(SearchType.XPath, flightXPath);
        flightClick.click();

        //Search Departure City
        List<WebElement> citySearchClick = browser.getElements(SearchType.CSSSelector, cityCSS);

        for(int i = 0; i < citySearchClick.size(); i++){
            if(citySearchClick.get(i).getText().equalsIgnoreCase("Enter City Or Airport")){
                citySearchClick.get(i).click();
                citySearchClick.get(i).sendKeys("Sing");
                break;
            }

        }

        browser.waitSeconds(1);
        WebElement resultClick = browser.getElement(SearchType.XPath, resultXPath);
        resultClick.click();

        //Search Arrival City
        List<WebElement> citySearchAriClick = browser.getElements(SearchType.CSSSelector, cityCSS);

        for(int i = 0; i < citySearchAriClick.size(); i++){
            if(citySearchAriClick.get(i).getText().equalsIgnoreCase("Enter City Or Airport")){
                citySearchAriClick.get(i).click();
                citySearchAriClick.get(i).sendKeys("Mos");
                break;
            }

        }

        browser.waitSeconds(1);
        WebElement resultAriClick = browser.getElement(SearchType.XPath, resultAriXPath);
        resultAriClick.click();

        //Depart time
        WebElement dateClick = browser.getElement(SearchType.XPath, dateTextXPath);
        dateClick.click();

        WebElement departDayClick = browser.getElement(SearchType.XPath, departDayXPath);
        departDayClick.click();

        //Guests
        WebElement guestClick = browser.getElement(SearchType.XPath, guestXPath);
        guestClick.click();
        WebElement adultClick = browser.getElement(SearchType.XPath, adultXPath);
        browser.waitSeconds(2);
        adultClick.click();

        //WebElement moreChildClick = browser.getElement(SearchType.XPath, moreChildXPath);
        //moreChildClick.click();
        //moreChildClick.click();
        //moreChildClick.click();

        //browser.close();
    }




}
