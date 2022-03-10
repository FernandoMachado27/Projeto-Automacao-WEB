package br.com.fernando.advantagedemo.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fernando.advantagedemo.dataProviders.ConfigFileReader;
import br.com.fernando.advantagedemo.managers.FileReaderManager;

public class HomePage {

	private WebDriverWait wait;
	private WebDriver browser;

	public HomePage(WebDriver browser) {
		this.browser = browser;
		this.wait = new WebDriverWait(browser, Duration.ofSeconds(20));
		PageFactory.initElements(browser, this); // inicializar todos os elementos da web localizados pela anotação
													// @FindBy
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

	public boolean validarNomeDeUsuario() {
		boolean nome = wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.cssSelector(".hi-user.containMiniTitle.ng-binding")))
				.isDisplayed();
		return nome;
	}

	public SearchPage pesquisarProduto(String produtoPesquisado) {
		browser.findElement(By.id("autoComplete")).sendKeys(produtoPesquisado, Keys.ENTER);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#\\31 6"))).click();
			return new SearchPage(browser);
		} catch (Exception e) {

		}
		return null;
	}
}
