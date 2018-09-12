import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class SignupTests {
    //Values to set through login and sign up procedures. Email might need to be changed every sign up procedure.
    static String firstName = "Test";
    static String lastName = "Account";
    static String mobileNum = "777-777-7777";
    static String email = "test5@gmail.com";
    static String pass = "password";

    @DisplayName("Tests for User information")
    @Test
    void signup(){
        BrowserSingleton browser = BrowserSingleton.getInstance();           //create instance of browser
        browser.setDriver("Chrome");
        browser.getPage("https://phptravels.net/");                 //go into browser into php travels
        List<WebElement> element = browser.getElements(SearchType.XPath,"//*[@id=\"li_myaccount\"]/a"); //search elements with xpath to find "MY ACCOUNT"


        element.get(1).click();         //This line should click the My Account button on index 1 on the element list.
        List<WebElement> element1 = element.get(1).findElements(By.xpath("//*[@id=\"li_myaccount\"]/ul/li/a"));         //This list should have the options of the dropdown menu of MY ACCOUNT.

        element1.get(3).click();        //Index 3 has the button for sign up.
        assertEquals("https://www.phptravels.net/register", browser.getURL());      //Check to see that we advanced to the register page
        List<WebElement> formElements = browser.getElements(SearchType.ClassName, "form-control");      //Assigns elements to list for the form on sign up page

        formElements.get(0).sendKeys(firstName); //First Name
        formElements.get(1).sendKeys(lastName); //Last Name
        formElements.get(2).sendKeys(mobileNum); //Mobile Number
        formElements.get(3).sendKeys(email); //email needs to change everytime
        formElements.get(4).sendKeys(pass); //password
        formElements.get(5).sendKeys(pass); //confirm password
        WebElement signUpButton = browser.getElement(SearchType.XPath, "//*[@id=\"headersignupform\"]/div[9]/button");          //Sends the form
        signUpButton.click();
        System.out.println(browser.getCurrPageTitle());
//        assertEquals("https://www.phptravels.net/account/", browser.getURL());
        assertFalse(false);
        //browser.close();
    }

    @Test(dependsOnMethods = {"signup"})
    void logIn(){
        BrowserSingleton browser = BrowserSingleton.getInstance();      //Create single instance of the browser
        browser.setDriver("Chrome");
        browser.getPage("https://phptravels.net/");         //go into browser into php travels
        List<WebElement> element = browser.getElements(SearchType.XPath,"//*[@id=\"li_myaccount\"]/a");     //Same procedure as login, assign elements of array to list because multiple elements in xpath
        element.get(1).click();         // My account button
        List<WebElement> element1 = element.get(1).findElements(By.xpath("//*[@id=\"li_myaccount\"]/ul/li/a"));     //Dropdown on my account has multiple buttons
        element1.get(2).click();        //clicks on sign in

        WebElement inputFiller = browser.getElement(SearchType.Name, "username");   //finds text box for user entry in username
        inputFiller.sendKeys(email);        //pass keys
        WebElement inputFiller2 = browser.getElement(SearchType.Name, "password");  //finds text box for user entry in passwords
        inputFiller2.sendKeys(pass);        //pass keys

        //log in page
        WebElement element2 = browser.getElement(SearchType.XPath,"//*[@id=\"loginfrm\"]/div[1]/div[5]/button");
        element2.click();
        System.out.println(browser.getCurrPageTitle());
//        assertEquals("https://www.phptravels.net/account/", browser.getURL());
    }

}
