package br.com.fernando.advantagedemo.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.fernando.advantagedemo.enums.DriverType;
import br.com.fernando.advantagedemo.enums.EnvironmentType;

public class WebDriverManager { // gerente de web driver
	private WebDriver browser;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if(browser == null) browser = createDriver();
		return browser;
	}

	private WebDriver createDriver() {
		   switch (environmentType) {	    
	        case LOCAL : browser = createLocalDriver();
	        	break;
	        case REMOTE : browser = createRemoteDriver();
	        	break;
		   }
		   return browser;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX : browser = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	browser = new ChromeDriver();
    		break;
//        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
//    		break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) browser.manage().window().maximize();
//        browser.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return browser;
	}	

	public void closeDriver() {
		browser.close();
		browser.quit();
	}

}