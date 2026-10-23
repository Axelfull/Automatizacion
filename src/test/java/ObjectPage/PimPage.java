package ObjectPage;


import Control.BaseController;
import Control.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;


import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;


public class PimPage extends BaseController {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
    private WebElement btnPim;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    private WebElement txtEmpleado;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    private WebElement btnBuscar;
    @FindBy(xpath = "//span[contains(normalize-space(),'Records Found')]")
    private WebElement lblRecordsFound;
    @FindBy(xpath = "//div[contains(@class,'oxd-table-row--clickable')]/div[3]/div")
    private List<WebElement> nombresEncontrados;

    @FindBy(xpath = "//label[text()='Employee Id']/../following-sibling::div/input")
    private WebElement txtEmployeeId;
    @FindBy(xpath = "//span[contains(.,'Record')]")
    private WebElement lblResultadoBusqueda;

    @FindBy(xpath = "//label[text()='Employment Status']/../following-sibling::div")
    private WebElement cmbEmploymentStatus;

    @FindBy(xpath = "//span[contains(.,'Record') or contains(.,'Records')]")
    private WebElement lblResultadoBusqueda2;
    @FindBy(xpath = "//div[contains(@class,'oxd-table-row--clickable')]")
    private List<WebElement> filasResultado;

    @FindBy(xpath = "//label[text()='Include']/../following-sibling::div")
    private WebElement cmbInclude;
    @FindBy(xpath = "//label[text()='Job Title']/../following-sibling::div")
    private WebElement cmbJobTitle;
    @FindBy(xpath = "//label[text()='Sub Unit']/../following-sibling::div")
    private WebElement cmbSubUnit;
    @FindBy(xpath = "//label[text()='Supervisor Name']/../following-sibling::div//input")
    private WebElement txtSupervisor;
    @FindBy(xpath = "//span[contains(@class,'oxd-input-field-error-message')]")
    private WebElement lblInvalid;


    public void clickBtnPim() {
        try {
            if (!visualizarElemento(btnPim, 10)) {
                fail("No se encuentra el botón PIM");
            }
            btnPim.click();
            Thread.sleep(2000);
        } catch (Exception e) {
            fail("Error al hacer click en el botón PIM: " + e.getMessage());
        }
    }

    public void escribirNombreEmp(String nombreEmpleado) {
        try {
            if (!visualizarElemento(txtEmpleado, 10)) {
                fail("No se encuentra el campo Nombre del empleado");
            }
            txtEmpleado.clear();
            txtEmpleado.sendKeys(nombreEmpleado);
        } catch (Exception e) {
            fail("Error al escribir en el campo Nombre del empleado: " + e.getMessage());
        }
    }

    public void clickBtnBuscar() {
        try {
            if (!visualizarElemento(btnBuscar, 10)) {
                fail("No se encuentra el botón Buscar");
            }
            btnBuscar.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            fail("Error al hacer click en el botón Buscar: " + e.getMessage());
        }
    }

    public void validarResultados() {

        String texto = lblRecordsFound.getText();

        String numeroTexto = texto.replaceAll("[^0-9]", "");

        int cantidad = Integer.parseInt(numeroTexto);

        if (cantidad <= 0) {
            fail("La búsqueda no devolvió registros");
        }

        System.out.println("Registros encontrados: " + cantidad);
    }

    public void validarNombreResultados(String nombreEsperado) {

        for (WebElement nombre : nombresEncontrados) {

            String texto = nombre.getText().trim();

            if (!texto.equalsIgnoreCase(nombreEsperado)) {
                fail("Se esperaba '" + nombreEsperado +
                        "' pero se encontró '" + texto + "'");
            }
        }
    }

    public void escribirEmployeeId(String employeeId) {

        if (visualizarElemento(txtEmployeeId, 10)) {
            txtEmployeeId.clear();
            txtEmployeeId.sendKeys(employeeId);
        } else {
            fail("No se encontró el campo Employee Id");
        }
    }

    public void validarResultadoBusqueda(String resultadoEsperado) {

        if (!visualizarElemento(lblResultadoBusqueda, 10)) {
            fail("No se encontró el mensaje de resultados");
        }
        String resultadoActual = lblResultadoBusqueda.getText().trim();
        System.out.println("Resultado obtenido: " + resultadoActual);
        if (!resultadoActual.equals(resultadoEsperado)) {
            fail("Se esperaba: " + resultadoEsperado
                    + " pero se obtuvo: " + resultadoActual);
        }
    }

    public void seleccionarEmploymentStatus(String status) {
        try {
            if (!visualizarElemento(cmbEmploymentStatus, 10)) {
                fail("No se encontró el combo Employment Status");
            }
            cmbEmploymentStatus.click();
            Thread.sleep(1000);
            WebElement opcion =
                    DriverContext.getDriver().findElement(
                            By.xpath("//span[normalize-space()='" + status + "']")
                    );
            opcion.click();
        } catch (Exception e) {
            fail("Error al seleccionar Employment Status: " + e.getMessage());
        }
    }

    public int obtenerCantidadResultados() {

        String texto = lblResultadoBusqueda2.getText().trim();

        if (texto.equalsIgnoreCase("No Records Found")) {
            return 0;
        }

        String numero = texto.replaceAll("[^0-9]", "");

        return Integer.parseInt(numero);
    }

    public void validarCantidadResultados(int esperado) {

        int obtenido = obtenerCantidadResultados();

        if (obtenido != esperado) {
            fail("Se esperaban "
                    + esperado
                    + " resultados pero se obtuvieron "
                    + obtenido);
        }

        System.out.println("Resultados encontrados: " + obtenido);
    }

    public void validarEmploymentStatusResultados(String statusEsperado) {

        String textoResultado = lblResultadoBusqueda2.getText().trim();

        if (textoResultado.equalsIgnoreCase("No Records Found")) {
            fail("No se encontraron registros para el estado: "
                    + statusEsperado);
        }

        String numeroTexto = textoResultado.replaceAll("[^0-9]", "");
        int cantidadResultados = Integer.parseInt(numeroTexto);

        System.out.println("Resultados encontrados: "
                + cantidadResultados);

        for (WebElement fila : filasResultado) {

            String textoFila = fila.getText();

            System.out.println(textoFila);

            if (!textoFila.contains(statusEsperado)) {

                fail("La fila no contiene el estado esperado: "
                        + statusEsperado
                        + "\nFila encontrada: "
                        + textoFila);
            }
        }
    }

    public void seleccionarIncludeOption(String includeOption) {
        try {
            if (!visualizarElemento(cmbInclude, 10)) {
                fail("No se encontró el combo Include");
            }
            cmbInclude.click();
            Thread.sleep(1000);
            WebElement opcion =
                    DriverContext.getDriver().findElement(
                            By.xpath("//span[normalize-space()='"
                                    + includeOption + "']")
                    );
            opcion.click();
        } catch (Exception e) {
            fail("Error al seleccionar Include: " + e.getMessage());
        }
    }

    public void seleccionarJobTitle(String jobTitle) {
        try {
            if (!visualizarElemento(cmbJobTitle, 10)) {
                fail("No se encontró el combo Job Title");
            }
            cmbJobTitle.click();
            Thread.sleep(1000);
            WebElement opcion =
                    DriverContext.getDriver().findElement(
                            By.xpath(
                                    "//div[@role='option'][normalize-space()='"
                                            + jobTitle +
                                            "']"
                            )
                    );
            opcion.click();
        } catch (Exception e) {
            fail("Error al seleccionar Job Title: " + e.getMessage());
        }
    }
    public void seleccionarSubUnit(String subUnit) {

        try {

            if (!visualizarElemento(cmbSubUnit, 10)) {
                fail("No se encontró el combo Sub Unit");
            }

            cmbSubUnit.click();

            Thread.sleep(1000);

            WebElement opcion =
                    DriverContext.getDriver().findElement(
                            By.xpath("//*[normalize-space()='"
                                    + subUnit + "']")
                    );

            opcion.click();

        } catch (Exception e) {

            fail("Error al seleccionar Sub Unit: "
                    + e.getMessage());
        }
    }
    public void seleccionarSupervisor(String supervisor) {

        try {

            if (!visualizarElemento(txtSupervisor, 10)) {
                fail("No se encontró el campo Supervisor");
            }

            txtSupervisor.clear();
            txtSupervisor.sendKeys(supervisor);

            Thread.sleep(2000);

            // Buscar sugerencia
            List<WebElement> opciones =
                    DriverContext.getDriver().findElements(
                            By.xpath("//div[contains(@class,'oxd-autocomplete-option')]")
                    );

            if (!opciones.isEmpty()) {
                opciones.get(0).click();
            }

            Thread.sleep(1000);

            // Validar después del intento de selección
            if (visualizarElemento(lblInvalid, 1)) {
                fail("Supervisor inválido: " + supervisor);
            }

        } catch (Exception e) {

            fail("Error al seleccionar Supervisor: "
                    + e.getMessage());
        }
    }

}
