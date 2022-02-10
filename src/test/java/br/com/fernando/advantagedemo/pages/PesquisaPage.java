package br.com.fernando.advantagedemo.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fernando.advantagedemo.Browser;

public class PesquisaPage extends Browser{
	
	private  WebDriverWait wait;

	public PesquisaPage(WebDriver browser) {
		super(browser);
		this.wait = new WebDriverWait(browser, Duration.ofSeconds(10));
	}

	public boolean contemProdutoPesquisado(String product) {
		return browser.getPageSource().contains(product);
	}

	public boolean mensagemDeProdutoNaoEncontrado() {
		return browser.getPageSource().contains("No results for \"watch\"");
	}

	public boolean isPaginaInicial() {
		return browser.getCurrentUrl().equals(URL_INICIAL);
	}

	public void pesquisarProduto(String produtoPesquisado) {
		browser.findElement(By.id("autoComplete")).sendKeys(produtoPesquisado, Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#output > div > div.top6Products > a.product.ng-scope > img")));
		browser.findElement(By.cssSelector("#output > div > div.top6Products > a.product.ng-scope")).click();
	}

	public void pesquisarProdutoInexistente(String produtoInexistente) {
		browser.findElement(By.id("autoComplete")).sendKeys(produtoInexistente, Keys.ENTER);
	}

}
