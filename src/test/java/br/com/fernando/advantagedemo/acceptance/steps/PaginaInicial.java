package br.com.fernando.advantagedemo.acceptance.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fernando.advantagedemo.Browser;
import br.com.fernando.advantagedemo.pages.LoginPage;
import br.com.fernando.advantagedemo.pages.PesquisaPage;

public class PaginaInicial extends Browser{
	
	private WebDriverWait wait;

	public PaginaInicial() {
		super(null);
		System.out.println("inicializando");
		browser.navigate().to(URL_INICIAL);
		browser.manage().window().maximize();
		this.wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a\"]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"a\"]")));
	}

	public LoginPage acessarPaginaDeLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menuUser"))).click();
		return new LoginPage(browser);
	}

	public PesquisaPage acessarAreaDePesquisa() {
		browser.findElement(By.id("menuSearch")).click();
		return new PesquisaPage(browser);
	}


}
