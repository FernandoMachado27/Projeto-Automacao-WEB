package br.com.fernando.advantagedemo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	
	protected WebDriver browser;
	protected static final String URL_INICIAL = "https://advantageonlineshopping.com/#/";
	protected static final String URL_CADASTRO = "https://advantageonlineshopping.com/#/register";
	protected WebDriverWait wait;
	
	public Browser(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		if (browser == null) { 
			this.browser = new ChromeDriver();
		}else {
			this.browser = browser;
		}
	}
	
	public void fechar() {
		this.browser.quit();
	}
	
	public void acessarPaginaInicial() {
		this.browser.navigate().to(URL_INICIAL);
	}
	
	public void maximizarTela() {
		this.browser.manage().window().maximize();
	}
	
	public static ExpectedCondition<WebElement> focusOfElement(final WebElement element) {
        return new ExpectedCondition<WebElement>() {
          @Override
          public WebElement apply(WebDriver driver) {
            try {
                return (WebElement) ((JavascriptExecutor)driver).executeScript("return (document.activeElement == arguments[0]?document.activeElement:null) ", element);
            } catch (StaleElementReferenceException e) {
              return null;
            }
          }
        };
      }

}