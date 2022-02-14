package br.com.fernando.advantagedemo.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fernando.advantagedemo.Browser;
import io.cucumber.datatable.DataTable;

public class LoginPage extends Browser {

	private WebDriverWait wait;

	public LoginPage(WebDriver browser) {
		super(browser);
		this.wait = new WebDriverWait(browser, Duration.ofSeconds(10));
	}

	public CadastroPage criarNovoCadastro() throws IOException, InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("body > login-modal > div > div > div.login.ng-scope > a.create-new-account.ng-scope")))
				.click();
		return new CadastroPage(browser);
	}

	public void preencherUsername(String username) {
		browser.findElement(By.name("username")).sendKeys(username);
	}

	public void preencherPassword(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys(password);
	}

	public void logar() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("sign_in_btnundefined"))).click();
	}

	public boolean contemMensagemDeErro() {
		String mensagemDeErro = browser.findElement(By.cssSelector("#signInResultMessage")).getText();
	    return browser.getPageSource().contains(mensagemDeErro);
	}

	}


