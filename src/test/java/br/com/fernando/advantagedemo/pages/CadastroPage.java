package br.com.fernando.advantagedemo.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.fernando.advantagedemo.Browser;

public class CadastroPage extends Browser{

	private  WebDriverWait wait;
	
	File file = new File("CadastroComDadosExcel.xlsx");
	FileInputStream inputStream = new FileInputStream(file);
	XSSFWorkbook wb = new XSSFWorkbook(inputStream);
	XSSFSheet sheet = wb.getSheet("Planilha1");
	int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	
	public CadastroPage(WebDriver browser) throws IOException{
		super(browser); 
		this.wait = new WebDriverWait(browser, Duration.ofSeconds(10));
	}

	public void nomeEEmailDoNovoUsuario(String username, String email) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("usernameRegisterPage"))).sendKeys(username);
		browser.findElement(By.name("emailRegisterPage")).sendKeys(email);
	}

	public void digiteASenhaEConfirme(String password, String confirmPassword) {
		browser.findElement(By.name("passwordRegisterPage")).sendKeys(password);
		browser.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(confirmPassword);
	}

	public void digiteNomeESobrenome(String Firstname, String lastName) {
		browser.findElement(By.name("first_nameRegisterPage")).sendKeys(Firstname);
		browser.findElement(By.name("last_nameRegisterPage")).sendKeys(lastName);
	}

	public void digiteNumeroDeCelular(String phoneNumber) {
		browser.findElement(By.name("phone_numberRegisterPage")).sendKeys(phoneNumber);
	}

	public void digiteSeuPaisDeOrigem(String country) {
		WebElement countryList = browser.findElement(By.cssSelector("#formCover > div:nth-child(3) > div:nth-child(2) > sec-view:nth-child(1) > div > select"));
		countryList.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#formCover > div:nth-child(3) > div:nth-child(2) > sec-view:nth-child(1) > div > select > option:nth-child(2)")));
		Select se = new Select(countryList);
		se.selectByVisibleText(country);
	}

	public void digiteSuaCidade(String city) {
		browser.findElement(By.name("cityRegisterPage")).sendKeys(city);
	}

	public void digiteSeuEndereco(String address) {
		browser.findElement(By.name("addressRegisterPage")).sendKeys(address);
	}

	public void digiteSeuEstado(String state) {
		browser.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys(state);
	}

	public void digiteOCodigoPostal(String postalCode) {
		browser.findElement(By.name("postal_codeRegisterPage")).sendKeys(postalCode);
	}
	
	public void concordaComOsTermosDeUso(String conditions) {
		if (conditions == "Sim" || conditions == "sim") {
			browser.findElement(By.name("i_agree")).click();
		}else {
			System.out.println("Não é possível realizar o cadastro sem aceitar os termos de uso");
		}
	}

	public void efetuaCadastro() {
		browser.findElement(By.id("register_btnundefined")).click();
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
		WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.name("usernameRegisterPage")));
		WebElement email = browser.findElement(By.name("emailRegisterPage"));
		WebElement password = browser.findElement(By.name("passwordRegisterPage"));
		WebElement confirmPassword = browser.findElement(By.name("confirm_passwordRegisterPage"));
		WebElement firstName = browser.findElement(By.name("first_nameRegisterPage"));
		WebElement lastName = browser.findElement(By.name("last_nameRegisterPage"));
		WebElement phoneNumber = browser.findElement(By.name("phone_numberRegisterPage"));
		WebElement countryList = browser.findElement(By.cssSelector("#formCover > div:nth-child(3) > div:nth-child(2) > sec-view:nth-child(1) > div > select"));
		WebElement city = browser.findElement(By.name("cityRegisterPage"));
		WebElement address = browser.findElement(By.name("addressRegisterPage"));
		WebElement state = browser.findElement(By.name("state_/_province_/_regionRegisterPage"));
		WebElement postalCode = browser.findElement(By.name("postal_codeRegisterPage"));
		
		username.sendKeys(sheet.getRow(numeroLinha).getCell(0).getStringCellValue());
		email.sendKeys(sheet.getRow(numeroLinha).getCell(1).getStringCellValue());
		password.sendKeys(sheet.getRow(numeroLinha).getCell(2).getStringCellValue());
		confirmPassword.sendKeys(sheet.getRow(numeroLinha).getCell(3).getStringCellValue());
		firstName.sendKeys(sheet.getRow(numeroLinha).getCell(4).getStringCellValue());
		lastName.sendKeys(sheet.getRow(numeroLinha).getCell(5).getStringCellValue());
		phoneNumber.sendKeys(sheet.getRow(numeroLinha).getCell(6).getStringCellValue());
		countryList.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		"#formCover > div:nth-child(3) > div:nth-child(2) > sec-view:nth-child(1) > div > select > option:nth-child(2)")));
		Select se = new Select(countryList);
		se.selectByVisibleText(sheet.getRow(numeroLinha).getCell(7).getStringCellValue());
		city.sendKeys(sheet.getRow(numeroLinha).getCell(8).getStringCellValue());
		address.sendKeys(sheet.getRow(numeroLinha).getCell(9).getStringCellValue());
		state.sendKeys(sheet.getRow(numeroLinha).getCell(10).getStringCellValue());
		postalCode.sendKeys(sheet.getRow(numeroLinha).getCell(11).getStringCellValue());
	}

	public boolean paginaContemMensagemUserPassEConfirmPassInvalidos() {
		String pageSource = browser.getPageSource(); 
		return pageSource.contains("Username field is required") 
				&& pageSource.contains("Password field is required")  
				&& pageSource.contains("Confirm password field is required");
	}

}
	
