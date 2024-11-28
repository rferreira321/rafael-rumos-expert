package Petstore;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
/**
 * Classe TestRunner que configura e executa os testes Cucumber com TestNG.
 */
@CucumberOptions(
        tags = "@petstore", // Tag para selecionar os cenários a serem executados
        features = "src/test/resources", // Caminho para os arquivos de feature
        glue = "Petstore.steps", // Pacote onde os passos (steps) do Cucumber estão implementados
        plugin = {
                "pretty", // Formata a saída no console de uma maneira mais legível
                "html:target/cucumber/report.html", // Gera um relatório HTML no diretório especificado
                "junit:target/reports/cucumber.xml", // Gera um relatório JUnit XML no diretório especificado
                "json:target/reports/cucumber.json", // Gera um relatório JSON no diretório especificado
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // Integração com ExtentReports para relatórios
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    /**
     * Configura o DataProvider para executar os cenários de teste em paralelo.
     *
     * @return Um array de objetos contendo os cenários de teste.
     */
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
