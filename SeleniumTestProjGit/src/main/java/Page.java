public class Page {

    String myLink = null;
    String title = null;
    BrowserSingleton browser;

    public Page( String pageLink ){
        myLink = pageLink;
        browser = BrowserSingleton.getInstance();
        openPage();
        title = browser.getCurrPageTitle();
    }

    public void openPage(){
        browser.getPage( myLink );
    }


}
