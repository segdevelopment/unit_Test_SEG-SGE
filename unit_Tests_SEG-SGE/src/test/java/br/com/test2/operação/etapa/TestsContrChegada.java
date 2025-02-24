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
import java.util.Random;

@DisplayName("Teste automatizado de cadastro número 1")
public class TestsContrChegada {
    @SuppressWarnings("BusyWait")
    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {

        // Loop infinito para repetir o processo completo
        while (true) {
            WebDriver navegador = null;
            try {
                // Driver
                WebDriverManager.chromedriver().setup();
                navegador = new ChromeDriver();

                // Abrir o SEG
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
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

                // Gerar dados dinâmicos para a pessoa
                Random random = new Random();
                String[] justificativas = {"309", "310", "311", "312", "313", "314", "5527"};
                String justificativa = justificativas[random.nextInt(justificativas.length)];
                String[] etapas = {"?", "?", "?", "?", "?", "?", "?"};
                String etapa = etapas[random.nextInt(etapas.length)];
                String[] pessoas = {"?", "?", "?", "?", "?", "?", "?"};
                String pessoa = pessoas[random.nextInt(pessoas.length)];

                // CLICAR EM "CONTROLE DE CHEGADA"
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(280, -15).click().perform();

                // CLICAR EM "NOVO"
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(80, 25).click().perform();

                // ETAPA
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(-350, -10).click().perform();

                // PESSOA
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(-0, 35).click().sendKeys(Keys.TAB).perform();

                // PREVISÃO
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(0, 0).sendKeys("11112020").sendKeys(Keys.TAB).sendKeys("1611").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

                // CHEGADA
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(0, 0).sendKeys("11112020").sendKeys(Keys.TAB).sendKeys("1811").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

                // JUSTIFICATIVA
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(0, 0).sendKeys(justificativa).sendKeys(Keys.ENTER).perform();

                // SALVAR CADASTRO
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(235, -155).click().perform();

                // Tirar “screenshot” no final da execução
                tirarScreenshot(navegador, "ControleDeChegada");
            } catch (Exception e) {
                System.out.println("Erro no processo: " + e.getMessage());
            } finally {
                // Pausa antes do próximo “loop” (ajustar conforme necessário)
                Thread.sleep(5000); // 5 segundos

                // Fechar o navegador ao final de cada interação
                if (navegador != null) {
                    navegador.quit();
                }
            }
        }
    }

    // Metodo para tirar “screenshot”
    private void tirarScreenshot(WebDriver navegador, String nomeArquivo) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Controle de Chegada//"
                    + nomeArquivo + "_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva em: " + destinoFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Erro ao salvar screenshot: " + e.getMessage());
        }
    }
}
