package ObjectPage;

import Control.BaseController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.fail;

public class ListaEmpleadoPage extends BaseController {
    private WebDriver driver;


    @FindBy(name = "username")
    private WebElement txtUsername;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private WebElement btnLogin;

    public void escribirUsuarioPass(String usuario, String password) {

        try {

            if (!visualizarElemento(txtUsername, 10)) {
                fail("No se encuentra el campo Nombre de Usuario");
            }

            txtUsername.clear();
            txtUsername.sendKeys(usuario);

            if (!visualizarElemento(txtPassword, 10)) {
                fail("No se encuentra el campo Contraseña");
            }

            txtPassword.clear();
            txtPassword.sendKeys(password);

            if (!visualizarElemento(btnLogin, 10)) {
                fail("No se encuentra el botón Login");
            }

            btnLogin.click();

        } catch (Exception e) {
            fail("Error durante el proceso de login: " + e.getMessage());
        }
    }

}