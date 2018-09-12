import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchHotelsTests {

    @Test
    public void searchByCity_SanAnto_Pass() {
        BrowserSingleton browser = BrowserSingleton.getInstance();
        browser.setDriver("Chrome");
        browser.getPage("https://www.phptravels.net/");
        String cityName = "San Antonio, United States";

        String cityCSS = "span.select2-chosen";
        String locationCSS = "input.select2-input";
        String resultXPath = "//*[@id=\"select2-drop\"]/ul/li/ul/li[3]";
        String dateTextXPath = "//*[@id=\"dpd1\"]/div/input";
        String startDayXPath = "/html/body/div[8]/div[1]/table/tbody/tr[5]/td[2]";
        String endDayXPath = "/html/body/div[9]/div[1]/table/tbody/tr[5]/td[6]";
        String adultChildXPath = "//*[@id=\"travellersInput\"]";
        String lessAdultXPath = "//*[@id=\"adultMinusBtn\"]";
        String moreChildXPath = "//*[@id=\"childPlusBtn\"]";
        String submitXPath = "//*[@id=\"HOTELS\"]/form/div[5]/button";

        //Search by City
        WebElement citySearchClick = browser.getElement(SearchType.CSSSelector, cityCSS);
        WebElement citySearchType = browser.getElement(SearchType.CSSSelector, locationCSS);
        citySearchClick.click();
        citySearchType.sendKeys("San Anto");

        browser.waitSeconds(4);

        WebElement resultClick = browser.getElement(SearchType.XPath, resultXPath);
        resultClick.click();

        //Start and End Date Textbox
        WebElement dateClick = browser.getElement(SearchType.XPath, dateTextXPath);
        dateClick.click();

        WebElement startDayClick = browser.getElement(SearchType.XPath, startDayXPath);
        startDayClick.click();

        WebElement endDayClick = browser.getElement(SearchType.XPath, endDayXPath);
        endDayClick.click();

        WebElement howManyClick = browser.getElement(SearchType.XPath, adultChildXPath);
        howManyClick.click();

        //Adult and Children Textbox
        WebElement lessAdultClick = browser.getElement(SearchType.XPath, lessAdultXPath);
        lessAdultClick.click();

        WebElement moreChildClick = browser.getElement(SearchType.XPath, moreChildXPath);
        moreChildClick.click();
        moreChildClick.click();
        moreChildClick.click();

        //Submit Search
        WebElement submitClick = browser.getElement(SearchType.XPath, submitXPath );
        submitClick.click();


        browser.close();
    }

    @Test
    public void searchByHotel_Sing_Pass(){
        BrowserSingleton browser = BrowserSingleton.getInstance();
        browser.setDriver("Chrome");
        browser.getPage("https://www.phptravels.net/");
        String hotelCSS = "span.select2-chosen";
        String locationCSS = "input.select2-input";
        String resultXPath = "//*[@id=\"select2-drop\"]/ul/li[1]/ul";
        String dateTextXPath = "//*[@id=\"dpd1\"]/div/input";
        String startDayXPath = "/html/body/div[8]/div[1]/table/tbody/tr[5]/td[3]";
        String endDayXPath = "/html/body/div[9]/div[1]/table/tbody/tr[5]/td[6]";
        String adultChildXPath = "//*[@id=\"travellersInput\"]";
        String lessAdultXPath = "//*[@id=\"adultMinusBtn\"]";
        String moreChildXPath = "//*[@id=\"childPlusBtn\"]";
        String submitXPath = "//*[@id=\"HOTELS\"]/form/div[5]/button";


        //Search by City
        WebElement hotelSearchClick = browser.getElement(SearchType.CSSSelector, hotelCSS);
        WebElement hotelSearchType = browser.getElement(SearchType.CSSSelector, locationCSS);
        hotelSearchClick.click();
        hotelSearchType.sendKeys("Sing");

        browser.waitSeconds(4);

        WebElement resultClick = browser.getElement(SearchType.XPath, resultXPath);
        resultClick.click();

        //Start and End Date Textbox
        WebElement dateClick = browser.getElement(SearchType.XPath, dateTextXPath);
        dateClick.click();

        WebElement startDayClick = browser.getElement(SearchType.XPath, startDayXPath);
        startDayClick.click();

        WebElement endDayClick = browser.getElement(SearchType.XPath, endDayXPath);
        endDayClick.click();

        //Adult and Children Textbox
        WebElement howManyClick = browser.getElement(SearchType.XPath, adultChildXPath);
        howManyClick.click();

        WebElement lessAdultClick = browser.getElement(SearchType.XPath, lessAdultXPath);
        lessAdultClick.click();

        WebElement moreChildClick = browser.getElement(SearchType.XPath, moreChildXPath);
        moreChildClick.click();
        moreChildClick.click();
        moreChildClick.click();

        //Submit Search
        WebElement submitClick = browser.getElement(SearchType.XPath, submitXPath );
        submitClick.click();


        browser.close();
    }



}
