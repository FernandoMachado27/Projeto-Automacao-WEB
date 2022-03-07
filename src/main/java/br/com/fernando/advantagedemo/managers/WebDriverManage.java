package br.com.fernando.advantagedemo.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.fernando.advantagedemo.enums.DriverType;
import br.com.fernando.advantagedemo.enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManage { // gerente de web driver
	private WebDriver browser;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManage() { // Única responsabilidade é fornecer o WebDriver
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
        case CHROME : 
//        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	WebDriverManager.chromedriver().driverVersion(FileReaderManager.getInstance().getConfigReader().getVersionChrome()).setup();
        	browser = new ChromeDriver();
    		break;
        case EDGE : 
        	WebDriverManager.edgedriver().setup();
        	browser = new EdgeDriver();
    		break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) browser.manage().window().maximize();
		return browser;
	}	

	public void closeDriver() {
		browser.close();
		browser.quit();
	}

}