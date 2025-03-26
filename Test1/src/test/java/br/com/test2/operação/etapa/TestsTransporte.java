package br.com.test2.operação.etapa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@DisplayName("Teste automatizado de cadastro número 1")
public class TestsTransporte {
    @SuppressWarnings("BusyWait")
    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {
        while (true) {
            WebDriver navegador = null;
            try {
                // Driver
                WebDriverManager.chromedriver().setup();
                navegador = new ChromeDriver();

                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha para entrar na conta da SEG.
                navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                        .sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                // Espera para aparecer novo campo.
                WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                WebElement campoDinamico = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("home.login.entidade")));
                campoDinamico.sendKeys("SEG");

                // Abrindo a janela de seleção de entidade
                navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text"))
                        .sendKeys(Keys.TAB);
                Actions actions = new Actions(navegador);

                // Entrar no SEG DESENVOLVIMENTO
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Pessoa).
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

                // Clicar em Transporte
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(140, -15).click().perform();

                //"Cadastro"\\
                // Clicar no botão "Novo"
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(200, 30).click().perform();

                // ETAPA
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(-350, -40).click().perform();

                // MOTORISTA
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(0, 30).click().perform();

                // PASSAGEIRO
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(0, 30).click().perform();

                // SALVAR CADASTRO
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(190, -150).click().perform();

                // Tirar screenshot no final da execução
                tirarScreenshot(navegador, "Cadastro_Transporte");
            } catch (Exception e) {
                System.out.println("Erro no processo: " + e.getMessage());
            } finally {
                // Pausa antes do próximo loop (ajustar conforme necessário)
                Thread.sleep(5000); // 5 segundos

                // Fechar o navegador ao final de cada interação
                if (navegador != null) {
                    navegador.quit();
                }
            }
        }
    }

    // Metodo para tirar screenshot
    private void tirarScreenshot(WebDriver navegador, String nomeArquivo) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Transporte//"
                    + nomeArquivo + "_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva em: " + destinoFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Erro ao salvar screenshot: " + e.getMessage());
        }
    }
}
