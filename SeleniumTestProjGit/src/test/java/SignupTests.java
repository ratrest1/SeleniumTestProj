import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SignupTests {
    static String firstName = "Dummy";
    static String lastName = "Account";
    static String mobileNum = "777-777-7777";
    static String email = "test22@gmail.com";
    static String pass = "password";




    @DisplayName("Tests for User information")
    @Test
    void signup(){
        BrowserSingleton browser = BrowserSingleton.getInstance(); //create instance of browser
        //browser.setDriver("Chrome");
        browser.getPage("https://phptravels.net/"); //go into browser into php travels
        List<WebElement> element = browser.getElements(SearchType.XPath,"//*[@id=\"li_myaccount\"]/a"); //search elements with xpath to find "MY ACCOUNT"
        for(int i=0; i<element.size(); i++){
            System.out.println(element.get(i).getText()+i);
        }
        element.get(1).click();  //This line should click the My Account button on index 1 on the element list.
        List<WebElement> element1 = element.get(1).findElements(By.xpath("//*[@id=\"li_myaccount\"]/ul/li/a")); //This list should have the options of the dropdown menu of MY ACCOUNT.
        /*for(int j=0; j<element1.size();j++){
            System.out.println(element1.get(j).getText() + " " + j);
        }*/
        element1.get(3).click(); //Index 3 has the button for sign up.
        assertEquals("https://www.phptravels.net/register", browser.getURL()); //Check to see that we advanced to the register page
        List<WebElement> formElements = browser.getElements(SearchType.ClassName, "form-control");
//        for(int j=0; j<formElements.size();j++){
//            System.out.println(formElements.get(j) + " " + j);
//        }
        formElements.get(0).sendKeys(firstName); //First Name
        formElements.get(1).sendKeys(lastName); //Last Name
        formElements.get(2).sendKeys(mobileNum); //Mobile Number
        formElements.get(3).sendKeys(email); //email needs to change everytime
        formElements.get(4).sendKeys(pass); //password
        formElements.get(5).sendKeys(pass); //confirm password
        WebElement signUpButton = browser.getElement(SearchType.XPath, "//*[@id=\"headersignupform\"]/div[9]/button");
        signUpButton.click();
       // browser.close();
    }

    @Test
    void logIn(){
        BrowserSingleton browser = BrowserSingleton.getInstance();
        browser.getPage("https://phptravels.net/"); //go into browser into php travels
        List<WebElement> element = browser.getElements(SearchType.XPath,"//*[@id=\"li_myaccount\"]/a");
        element.get(1).click(); // My account button
        List<WebElement> element1 = element.get(1).findElements(By.xpath("//*[@id=\"li_myaccount\"]/ul/li/a"));
        element1.get(2).click();

        WebElement inputFiller = browser.getElement(SearchType.Name, "username");
        inputFiller.sendKeys(email);
        WebElement inputFiller2 = browser.getElement(SearchType.Name, "password");
        inputFiller2.sendKeys(pass);

        //log in page
//        WebElement element2 = browser.getElement(SearchType.PartialLinkText,"LOGIN");
//        element2.click();

//        List<WebElement> loginForm = browser.getElements(SearchType.XPath,"//*[@id=\"loginfrm\"]");
//        for(int j=0; j<loginForm.size();j++)
//            System.out.println(loginForm.get(j).getText() + " " + j);
//      loginForm.get(0).sendKeys(email);
//      loginForm.get(1).sendKeys(pass);
//      loginForm.get(1).submit();
    }

}
