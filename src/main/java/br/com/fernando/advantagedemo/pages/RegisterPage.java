package br.com.fernando.advantagedemo.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fernando.advantagedemo.managers.FileReaderManager;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RegisterPage  {

	private  WebDriverWait wait;
	private WebDriver browser;
	protected static final String URL_INICIAL = "https://advantageonlineshopping.com/#/";
	protected static final String URL_CADASTRO = "https://advantageonlineshopping.com/#/register";
	
	public RegisterPage(WebDriver browser) throws IOException{
		this.browser = browser;
		this.wait = new WebDriverWait(browser, Duration.ofSeconds(20));
		PageFactory.initElements(browser, this); // inicializar todos os elementos da web localizados pela anotação @FindBy
	}
	
//	File file = new File("CadastroComDadosExcel.xlsx");
	File file = new File(FileReaderManager.getInstance().getConfigReader().getExcelUrl());
	FileInputStream inputStream = new FileInputStream(file);
	XSSFWorkbook wb = new XSSFWorkbook(inputStream);
	XSSFSheet sheet = wb.getSheet("Planilha1");
	int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	
	@FindBy(how = How.NAME, using = "usernameRegisterPage") 
	private WebElement campoUsername;
	
	@FindBy(how = How.NAME, using = "emailRegisterPage") 
	private WebElement campoEmail;
	
	@FindBy(how = How.NAME, using = "passwordRegisterPage") 
	private WebElement campoPass;
	
	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage") 
	private WebElement campoConfirmPass;
	
	@FindBy(how = How.NAME, using = "first_nameRegisterPage") 
	private WebElement campoFistName;
	
	@FindBy(how = How.NAME, using = "last_nameRegisterPage") 
	private WebElement campoLastName;
	
	@FindBy(how = How.NAME, using = "phone_numberRegisterPage") 
	private WebElement campoPhonNumber;
	
	@FindBy(how = How.CSS, using = "#formCover > div:nth-child(3) > div:nth-child(2) > sec-view:nth-child(1) > div > select") 
	private WebElement campoList;
	
	@FindBy(how = How.CSS, using = "#formCover > div:nth-child(3) > div:nth-child(2) > sec-view:nth-child(1) > div > select > option:nth-child(2)") 
	private WebElement campoEsperandoPrimeiroPaisAparecer;
	
	@FindBy(how = How.NAME, using = "cityRegisterPage") 
	private WebElement campoCity;
	
	@FindBy(how = How.NAME, using = "addressRegisterPage") 
	private WebElement campoAddress;
	
	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage") 
	private WebElement campoState;
	
	@FindBy(how = How.NAME, using = "postal_codeRegisterPage") 
	private WebElement campoPostalCode;
	
	@FindBy(how = How.NAME, using = "i_agree") 
	private WebElement campoTermosDeUso;
	
	@FindBy(how = How.ID, using = "register_btnundefined") 
	private WebElement campoEfetuarCadastro;
	
	public void concordaComOsTermosDeUso(boolean terms) {
		if (terms == true ) {
			campoTermosDeUso.click();
		}else {
			System.out.println("Não é possível realizar o cadastro sem aceitar os termos de uso");
		}
	}

	public HomePage efetuaCadastro() {
		campoEfetuarCadastro.click();
		return new HomePage(browser);
	}

	public boolean paginaContemMensagemDeEmailInvalido() throws InterruptedException {
		Thread.sleep(1000);
		return browser.getPageSource().contains("Your email address isn't formatted correctly");
	}

	public boolean isPaginaDeCadastro() {
		return browser.getCurrentUrl().equals(URL_CADASTRO);
	}

	public boolean isPaginaInicial() {
		return browser.getCurrentUrl().equals(URL_INICIAL);
	}
	
	public void fechar() {
		this.browser.quit();
	}

	public boolean paginaContemMensagemUserPassEConfirmPassInvalidos() {
		String pageSource = browser.getPageSource(); 
		String nomeInvalido = browser.findElement(By.cssSelector("#formCover > div:nth-child(1) > div:nth-child(2) > sec-view:nth-child(1) > div > label")).getText();
		String senhaInvalido = browser.findElement(By.cssSelector("#formCover > div:nth-child(1) > div:nth-child(3) > sec-view:nth-child(1) > div > label")).getText();
		String confirmInvalido = browser.findElement(By.cssSelector("#formCover > div:nth-child(1) > div:nth-child(3) > sec-view:nth-child(2) > div > label")).getText();
		return browser.getPageSource().contains(nomeInvalido)
				&& pageSource.contains(senhaInvalido)  
				&& pageSource.contains(confirmInvalido);
	}

	public void digiteEmail(String email) {
		Actions action = new Actions(browser);
		wait.until(ExpectedConditions.elementToBeClickable(campoUsername)).click();
		action.sendKeys(Keys.TAB);
		campoEmail.sendKeys(email);
		action.sendKeys(Keys.TAB);
		action.sendKeys(Keys.TAB);
	}

	public void preencherUsername(int numeroLinha) {
		wait.until(ExpectedConditions.elementToBeClickable(campoUsername)).sendKeys(sheet.getRow(numeroLinha).getCell(0).getStringCellValue());
	}

	public void preencherEmail(int numeroLinha) {
		campoEmail.sendKeys(sheet.getRow(numeroLinha).getCell(1).getStringCellValue());
	}

	public void preencherSenha(int numeroLinha) {
		campoPass.sendKeys(sheet.getRow(numeroLinha).getCell(2).getStringCellValue());
	}

	public void preencherConfirmSenha(int numeroLinha) {
		campoConfirmPass.sendKeys(sheet.getRow(numeroLinha).getCell(3).getStringCellValue());
	}

	public void preencherNome(int numeroLinha) {
		campoFistName.sendKeys(sheet.getRow(numeroLinha).getCell(4).getStringCellValue());
	}

	public void preencherSobrenome(int numeroLinha) {
		campoLastName.sendKeys(sheet.getRow(numeroLinha).getCell(5).getStringCellValue());
	}

	public void preencherCelular(int numeroLinha) {
		campoPhonNumber.sendKeys(sheet.getRow(numeroLinha).getCell(6).getStringCellValue());
	}

	public void preencherPais(int numeroLinha) {
		campoList.click();
		wait.until(ExpectedConditions.visibilityOf(campoEsperandoPrimeiroPaisAparecer));
		Select se = new Select(campoList);
		se.selectByVisibleText(sheet.getRow(numeroLinha).getCell(7).getStringCellValue());
	}

	public void preencherCidade(int numeroLinha) {
		campoCity.sendKeys(sheet.getRow(numeroLinha).getCell(8).getStringCellValue());
	}

	public void preencherEndereço(int numeroLinha) {
		campoAddress.sendKeys(sheet.getRow(numeroLinha).getCell(9).getStringCellValue());
	}

	public void preencherEstado(int numeroLinha) {
		campoState.sendKeys(sheet.getRow(numeroLinha).getCell(10).getStringCellValue());
	}

	public void preencherCodigoPostal(int numeroLinha) {
		campoPostalCode.sendKeys(sheet.getRow(numeroLinha).getCell(11).getStringCellValue());
	}

}
	
