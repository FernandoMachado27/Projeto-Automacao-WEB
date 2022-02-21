package br.com.fernando.advantagedemo.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriverWait wait;
	private WebDriver browser;
	
	public LoginPage(WebDriver browser) {
		this.browser = browser;
		this.wait = new WebDriverWait(browser, Duration.ofSeconds(10));
		PageFactory.initElements(browser, this);
	}
	
	@FindBy(how = How.CSS, using = "body > login-modal > div > div > div.login.ng-scope > a.create-new-account.ng-scope")
	private WebElement creatNewAccount;
	
	@FindBy(how = How.NAME, using = "username")
	private WebElement campoUsername;
	
	@FindBy(how = How.NAME, using = "password")
	private WebElement campoPassword;
	
	@FindBy(how = How.ID, using = "sign_in_btnundefined")
	private WebElement logar;
	
	@FindBy(how = How.CSS, using = "#signInResultMessage")
	private WebElement resultMessage;

	public RegisterPage criarNovoCadastro() throws IOException, InterruptedException {
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(creatNewAccount)).click();
		return new RegisterPage(browser);
	}
	
	public void preencherUsername(String username) {
		campoUsername.sendKeys(username);
	}

	public void preencherPassword(String password) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(campoPassword)).sendKeys(password);
	}
	
	public void logar() {
		wait.until(ExpectedConditions.elementToBeClickable(logar)).click();
	}

	public boolean contemMensagemDeErro() {
		String mensagemDeErro = resultMessage.getText();
	    return browser.getPageSource().contains(mensagemDeErro);
	}

	public boolean validarNomeDeUsuario() {
		String nomeUsuario = browser.findElement(By.cssSelector("#menuUserLink > span")).getText();
		return browser.getPageSource().contains(nomeUsuario);
	}
	
	public void fechar() {
		this.browser.quit();
	}

	}


