package br.com.fernando.advantagedemo.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage{
	
	private  WebDriverWait wait;
	private WebDriver browser;
	protected static final String URL_INICIAL = "https://advantageonlineshopping.com/#/";

	public SearchPage(WebDriver browser) {
		this.browser = browser;
		this.wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		PageFactory.initElements(browser, this); // inicializar todos os elementos da web localizados pela anotação @FindBy
	}

	public boolean contemProdutoPesquisado(String product) {
		return browser.getPageSource().contains(product);
	}

	public boolean mensagemDeProdutoNaoEncontrado() {
		String mensagemProdutoNaoEncontrado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchPage > div.noPromotedProductDiv > div > label > span"))).getText();
		return browser.getPageSource().contains(mensagemProdutoNaoEncontrado);
	}

	public boolean isPaginaInicial() {
		return browser.getCurrentUrl().equals(URL_INICIAL);
	}

	public void fechar() {
		this.browser.quit();
	}


}
