package br.com.fernando.advantagedemo.acceptance.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fernando.advantagedemo.Browser;
import br.com.fernando.advantagedemo.pages.CadastroPage;
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

//	public void acessarPaginaDeCadastro() throws InterruptedException {
//		browser.findElement(By.id("menuUser")).click();
//		Thread.sleep(3000);
//	}
	
	public LoginPage acessarPaginaDeLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("menuUser"))).click();
		return new LoginPage(browser);
	}

//	public CadastroPage criarNovoCadastro() throws InterruptedException {
//		browser.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")).click();
//		Thread.sleep(3000);
//		return new CadastroPage(browser);
//	}

	public void acessarAreaDePesquisa() throws InterruptedException {
		Thread.sleep(2000);
		browser.findElement(By.xpath("/html/body/header/nav/ul/li[4]/a/div")).click();
	}

	public PesquisaPage pesquisarProduto(String produtoPesquisado) throws InterruptedException {
		browser.findElement(By.xpath("//*[@id=\"autoComplete\"]")).sendKeys(produtoPesquisado,Keys.ENTER);
		Thread.sleep(2000);
		browser.findElement(By.xpath("//*[@id=\"search\"]/div")).click();
		Thread.sleep(2000);
		return new PesquisaPage(browser);
	}


}
