package br.com.fernando.advantagedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
	protected WebDriver browser;
	protected static final String URL_INICIAL = "https://advantageonlineshopping.com/#/";
	protected static final String URL_CADASTRO = "https://advantageonlineshopping.com/#/register";
	
	public Browser(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		if (browser == null) { 
			this.browser = new ChromeDriver();
		}else {
			this.browser = browser;
		}
	}
	
	public void acessarPaginaInicial() {
		this.browser.navigate().to(URL_INICIAL);
	}
	
	public void maximizarTela() {
		this.browser.manage().window().maximize();
	}
	
	public void fechar() {
		this.browser.quit();
	}
	

}