package StepDefinition;

import Constant.Navegador;
import Control.DriverContext;
import Control.NavSelector;
import ObjectPage.HomePage;
import ObjectPage.ListaEmpleadoPage;
import ObjectPage.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeDefinition {
    private final ListaEmpleadoPage listaEmpleadoPage = new ListaEmpleadoPage();


        @And("que el usuario inicia sesión en OrangeHRM con el usuario {string} y la contraseña {string}")
        public void login(String username, String password) {
            listaEmpleadoPage.escribirUsuarioPass(username, password);
        }



}