package br.com.fernando.advantagedemo.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		PageFactory.initElements(browser, this);
	}
	
	File file = new File("CadastroComDadosExcel.xlsx");
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


	public void nomeEEmailDoNovoUsuario(String username, String email) {
		wait.until(ExpectedConditions.elementToBeClickable(campoUsername)).sendKeys(username);
		campoEmail.sendKeys(email);
	}

	public void digiteASenhaEConfirme(String password, String confirmPassword) {
		campoPass.sendKeys(password);
		campoConfirmPass.sendKeys(confirmPassword);
	}

	public void digiteNomeESobrenome(String Firstname, String lastName) {
		campoFistName.sendKeys(Firstname);
		campoLastName.sendKeys(lastName);
	}

	public void digiteNumeroDeCelular(String phoneNumber) {
		campoPhonNumber.sendKeys(phoneNumber);
	}

	public void digiteSeuPaisDeOrigem(String country) {
		campoList.click();
		wait.until(ExpectedConditions.visibilityOf(campoEsperandoPrimeiroPaisAparecer));
		Select se = new Select(campoList);
		se.selectByVisibleText(country);
	}

	public void digiteSuaCidade(String city) {
		campoCity.sendKeys(city);
	}

	public void digiteSeuEndereco(String address) {
		campoAddress.sendKeys(address);
	}

	public void digiteSeuEstado(String state) {
		campoState.sendKeys(state);
	}

	public void digiteOCodigoPostal(String postalCode) {
		campoPostalCode.sendKeys(postalCode);
	}
	
	public void concordaComOsTermosDeUso(boolean terms) {
		if (terms == true ) {
			campoTermosDeUso.click();
		}else {
			System.out.println("Não é possível realizar o cadastro sem aceitar os termos de uso");
		}
	}

	public void efetuaCadastro() {
		campoEfetuarCadastro.click();
	}

	public boolean paginaContemMensagemDeEmailInvalido() {
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

	public void preencheFormularioPeloExcel(int numeroLinha) {
		wait.until(ExpectedConditions.elementToBeClickable(campoUsername)).sendKeys(sheet.getRow(numeroLinha).getCell(0).getStringCellValue());
		campoEmail.sendKeys(sheet.getRow(numeroLinha).getCell(1).getStringCellValue());
		campoPass.sendKeys(sheet.getRow(numeroLinha).getCell(2).getStringCellValue());
		campoConfirmPass.sendKeys(sheet.getRow(numeroLinha).getCell(3).getStringCellValue());
		campoFistName.sendKeys(sheet.getRow(numeroLinha).getCell(4).getStringCellValue());
		campoLastName.sendKeys(sheet.getRow(numeroLinha).getCell(5).getStringCellValue());
		campoPhonNumber.sendKeys(sheet.getRow(numeroLinha).getCell(6).getStringCellValue());
		campoList.click();
		wait.until(ExpectedConditions.visibilityOf(campoEsperandoPrimeiroPaisAparecer));
		Select se = new Select(campoList);
		se.selectByVisibleText(sheet.getRow(numeroLinha).getCell(7).getStringCellValue());
		campoCity.sendKeys(sheet.getRow(numeroLinha).getCell(8).getStringCellValue());
		campoAddress.sendKeys(sheet.getRow(numeroLinha).getCell(9).getStringCellValue());
		campoState.sendKeys(sheet.getRow(numeroLinha).getCell(10).getStringCellValue());
		campoPostalCode.sendKeys(sheet.getRow(numeroLinha).getCell(11).getStringCellValue());
	}

	public boolean paginaContemMensagemUserPassEConfirmPassInvalidos() {
		String pageSource = browser.getPageSource(); 
		return pageSource.contains("Username field is required") 
				&& pageSource.contains("Password field is required")  
				&& pageSource.contains("Confirm password field is required");
	}

	public boolean validarNomeDeUsuario() {
		String nomeUsuario = browser.findElement(By.cssSelector("#menuUserLink > span")).getText();
		return browser.getPageSource().contains(nomeUsuario);
	}

}
	
