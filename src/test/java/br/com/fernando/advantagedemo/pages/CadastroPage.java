package br.com.fernando.advantagedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.fernando.advantagedemo.Browser;

public class CadastroPage extends Browser{

	public CadastroPage(WebDriver browser) {
		super(browser); 
	}

	public void nomeEEmailDoNovoUsuario(String username, String email) {
		browser.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[1]/sec-view[1]/div/input")).sendKeys(username);
		browser.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[1]/sec-view[2]/div/input")).sendKeys(email);
	}

	public void digiteASenhaEConfirme(String password, String confirmPassword) {
		browser.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[1]/div/input")).sendKeys(password);
		browser.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[2]/div/input")).sendKeys(confirmPassword);
	}

	public void digiteNomeESobrenome(String Firstname, String lastName) {
		browser.findElement(By.xpath("//*[@id=\"formCover\"]/div[2]/div[1]/sec-view[1]/div/input")).sendKeys(Firstname);
		browser.findElement(By.xpath("//*[@id=\"formCover\"]/div[2]/div[1]/sec-view[2]/div/input")).sendKeys(lastName);
	}

	public void digiteNumeroDeCelular(String phoneNumber) {
		browser.findElement(By.xpath("//*[@id=\"formCover\"]/div[2]/div[2]/sec-view/div/input")).sendKeys(phoneNumber);
	}

	public void digiteSeuPaisDeOrigem(String country) {
		browser.findElement(By.xpath("//*[@id=\"formCover\"]/div[3]/div[1]/sec-view[1]/div/select")).sendKeys(country);
	}

	public void digiteSuaCidade(String city) {
		browser.findElement(By.xpath("//*[@id=\"formCover\"]/div[3]/div[1]/sec-view[2]/div/input")).sendKeys(city);
	}

	public void digiteSeuEndereco(String address) {
		browser.findElement(By.xpath("//*[@id=\"formCover\"]/div[3]/div[2]/sec-view[1]/div/input")).sendKeys(address);
	}

	public void digiteSeuEstado(String state) {
		browser.findElement(By.xpath("//*[@id=\"formCover\"]/div[3]/div[2]/sec-view[2]/div/input")).sendKeys(state);
	}

	public void digiteOCodigoPostal(String postalCode) {
		browser.findElement(By.xpath("//*[@id=\"formCover\"]/div[3]/div[3]/sec-view/div/input")).sendKeys(postalCode);
	}
	
	public void concordaComOsTermosDeUso(String conditions) {
		if (conditions == "Sim" || conditions == "sim") {
			browser.findElement(By.xpath("//*[@id=\"formCover\"]/sec-view/div/input")).click();
		}else {
			System.out.println("Não é possível realizar o cadastro sem aceitar os termos de uso");
		}
	}

	public void efetuaCadastro() throws InterruptedException {
		browser.findElement(By.xpath("//*[@id=\"register_btnundefined\"]")).click();
		Thread.sleep(2000);
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

}
	
