package StepDefinition;

import ObjectPage.HomePage;
import ObjectPage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginDefinition {
    private LoginPage loginPage = new LoginPage();

    @And("ingresar el usuario {string}")
    public void ingresarElUsuario(String nombreUsuario) {

        loginPage.escribirUsersname(nombreUsuario);
    }

}