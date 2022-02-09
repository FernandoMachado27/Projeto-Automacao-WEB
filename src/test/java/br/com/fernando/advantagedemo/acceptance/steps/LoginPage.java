package br.com.fernando.advantagedemo.acceptance.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.fernando.advantagedemo.Browser;
import br.com.fernando.advantagedemo.pages.CadastroPage;

public class LoginPage extends Browser{

	public LoginPage(WebDriver browser) {
		super(browser);
	}

	public CadastroPage criarNovoCadastro() throws InterruptedException {
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > login-modal > div > div > div.login.ng-scope > sec-form > sec-view:nth-child(1) > div > input")));
		wait.until(focusOfElement(usernameField));
		try {
			wait.withTimeout(Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("body > login-modal > div > div > div.login.ng-scope > sec-form > sec-view:nth-child(1) > div > label")));
		} catch (Exception e) {
			
		}
		wait.withTimeout(Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"))).click();
		return new CadastroPage(browser);
	}


}
