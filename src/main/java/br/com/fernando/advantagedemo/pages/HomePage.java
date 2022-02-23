package br.com.fernando.advantagedemo.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fernando.advantagedemo.dataProviders.ConfigFileReader;
import br.com.fernando.advantagedemo.managers.FileReaderManager;

public class HomePage{
	
	private WebDriverWait wait;
	private WebDriver browser;
	private ConfigFileReader configFileReader;
	
	public HomePage(WebDriver browser) {
		this.browser = browser;
		this.wait = new WebDriverWait(browser, Duration.ofSeconds(20));
		PageFactory.initElements(browser, this);
		configFileReader= new ConfigFileReader();
	}
	
	@FindBy(how = How.ID, using = "menuUser")
	private WebElement menuUser;
	
	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement menuSearch;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"a\"]")
	private WebElement loading;
	
	public LoginPage acessarPaginaDeLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(menuUser)).click();
		return new LoginPage(browser);
	}

	public SearchPage acessarAreaDePesquisa() {
		menuSearch.click();
		return new SearchPage(browser);
	}
	
	public void paginaInicial() {
		browser.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		wait.until(ExpectedConditions.visibilityOf(loading));
		wait.until(ExpectedConditions.invisibilityOf(loading));
	}


}
