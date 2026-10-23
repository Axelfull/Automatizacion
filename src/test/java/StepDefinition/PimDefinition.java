package StepDefinition;

import Constant.Navegador;
import Control.DriverContext;
import Control.NavSelector;
import ObjectPage.HomePage;
import ObjectPage.ListaEmpleadoPage;
import ObjectPage.LoginPage;
import ObjectPage.PimPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PimDefinition {
    private final PimPage pimPage = new PimPage();

    @And("que el usuario ingresa al módulo PIM")
    public void ingresarModuloPim() {

        pimPage.clickBtnPim();
    }

    @Given("el usuario ingresa {string} en el campo Nombre del empleado de PIM")
    public void ingresarNombreEmpleado(String employeeName) {

        pimPage.escribirNombreEmp(employeeName);
    }

    @And("hace clic en Buscar")
    public void clickBuscar() {

        pimPage.clickBtnBuscar();
    }

    @Then("se deben mostrar los resultados de la búsqueda")
    public void validarResultados() {

        pimPage.validarResultados();
    }

    @And("cada resultado debe contener {string}")
    public void validarNombreResultado(String expectedName) {

        pimPage.validarNombreResultados(expectedName);
    }

    @When("the user enters employee id {string}")
    public void ingresarEmployeeId(String employeeId) {
        pimPage.escribirEmployeeId(employeeId);
    }

    @And("clicks Search")
    public void clickSearch() {
        pimPage.clickBtnBuscar();
    }

    @Then("the system should return {string} record\\(s)")
    public void validarResultadoBusqueda(String expectedRecords) {
        pimPage.validarResultadoBusqueda(expectedRecords);
    }

    @When("the user selects employment status {string}")
    public void seleccionarEmploymentStatus(String status) {
        pimPage.seleccionarEmploymentStatus(status);
    }

    @Then("every result should have employment status {string}")
    public void validarEmploymentStatus(String status) {
        pimPage.validarEmploymentStatusResultados(status);
    }

    @When("the user enters employee name {string}")
    public void ingresarNombreEmployee(String employeeName) {
        pimPage.escribirNombreEmp(employeeName);
    }

    @And("the user selects include option {string}")
    public void seleccionarIncludeOption(String includeOption) {
        pimPage.seleccionarIncludeOption(includeOption);
    }

    @And("the user selects job title {string}")
    public void seleccionarJobTitle(String jobTitle) {
        pimPage.seleccionarJobTitle(jobTitle);
    }

    @And("the user selects sub unit {string}")
    public void seleccionarSubUnit(String subUnit) {
        pimPage.seleccionarSubUnit(subUnit);
    }

    @And("the user selects supervisor {string}")
    public void seleccionarSupervisor(String supervisor) {
        pimPage.seleccionarSupervisor(supervisor);
    }

    @Then("every result should match all selected criteria")
    public void validarResultadosFiltros() {
        //pimPage.validarResultadosConFiltros();
    }

}