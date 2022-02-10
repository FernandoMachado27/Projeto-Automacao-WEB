package br.com.fernando.advantagedemo.acceptance.steps;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fernando.advantagedemo.Browser;
import br.com.fernando.advantagedemo.pages.CadastroPage;

public class LoginPage extends Browser{

	private WebDriverWait wait;

	public LoginPage(WebDriver browser) {
		super(browser);
		this.wait = new WebDriverWait(browser, Duration.ofSeconds(10));
	}

	public CadastroPage criarNovoCadastro() throws IOException, InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > login-modal > div > div > div.login.ng-scope > a.create-new-account.ng-scope"))).click();
		return new CadastroPage(browser);
	}


}
