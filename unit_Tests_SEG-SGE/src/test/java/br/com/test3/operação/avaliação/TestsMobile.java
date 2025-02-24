package br.com.test3.operação.avaliação;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;

@DisplayName("Teste automatizado de cadastro número 1")
public class TestsMobile {
    @SuppressWarnings("BusyWait")
    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {

        // Loop infinito para repetir o processo completo
        while (true) {
            WebDriverManager.chromedriver().setup();
            WebDriver navegador = new ChromeDriver();

            try {
                // Abrir o o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha para entrar na conta da SEG
                navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                        .sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                // Espera para aparecer novo campo
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

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_aba_avaliacao");

                // CLICAR EM MOBILE
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(-150, -15).click().perform();

                // NOVO
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(810, 20).click().perform();

                // GRUPO AÇÃO
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(-100, 30).click().perform();

                // ETAPA
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).click().perform();

                // PESSOA
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).click().perform();

                // PERFIL
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).click().perform();

                // NOTA
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).click().perform();

                // SALVAR CADASTRO
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, -150).click().perform();

                // Tirar “screenshot” no final da execução
                tirarScreenshot(navegador, "Cadastro_Mobile");
            } catch (Exception e) {
                System.out.println("Erro no processo: " + e.getMessage());
            } finally {
                // Pausa antes do próximo “loop” (ajustar conforme necessário)
                Thread.sleep(5000); // 5 segundos

                // Fechar o navegador ao final de cada interação
                navegador.quit();
            }
        }
    }

    // Metodo para tirar ‘screenshot’
    private void tirarScreenshot(WebDriver navegador, String nomeArquivo) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Mobile//"
                    + nomeArquivo + "_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva em: " + destinoFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Erro ao salvar screenshot: " + e.getMessage());
        }
    }
}
