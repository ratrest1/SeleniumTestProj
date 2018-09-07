import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class BrowserSingleton
{
    //My Instance
    private static BrowserSingleton instance = null;
    public WebDriver driver = null;

    private BrowserSingleton(){
        driver = new ChromeDriver();
    }

    public static BrowserSingleton getInstance(){
        if(instance == null){
            instance = new BrowserSingleton();
        }
        return instance;
    }

    public void setDriver( String driverStr ){
        driver.quit();
        switch(driverStr){
            case "Chrome":
                driver = new ChromeDriver();
                break;
        }
    }

    public void getPage( String pageLink ){
        driver.get( pageLink );
    }

    public WebElement getElement(SearchType s, String condition ){
        WebElement returnElement = null;
        switch(s){
            case ClassName:
                returnElement = driver.findElement(By.className(condition));
                break;
            case CSSSelector:
                returnElement = driver.findElement(new By.ByCssSelector(condition));
                break;
            case ID:
                returnElement = driver.findElement(new By.ById(condition));
                break;
            case LinkText:
                returnElement = driver.findElement(new By.ByLinkText(condition));
                break;
            case Name:
                returnElement = driver.findElement(By.name(condition));
                break;
            case PartialLinkText:
                returnElement = driver.findElement(new By.ByPartialLinkText(condition));
                break;
            case TagName:
                returnElement = driver.findElement(new By.ByTagName(condition));
                break;
            case XPath:
                returnElement = driver.findElement(new By.ByXPath(condition));
                break;
            default:

                break;
        }

        return returnElement;
    }

    public String getCurrPageTitle(){
        return driver.getTitle();
    }

    public void getWindow( int index ){
        Set<String> handles =  driver.getWindowHandles();
        String[] handlesStr = handles.toArray( new String[handles.size()]);

        driver.switchTo().window( handlesStr[index] );
    }


    public void moveToElement(WebElement e){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", e);
    }

    public void close(){
        driver.close();
        driver.quit();
    }



}
