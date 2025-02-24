package br.com.test2.operação.etapa;

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
public class TestsGrupo {
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
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

                // Clicar em Grupo
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(80, -15).click().perform();


                //"Cadastro"\\
                // Clicar no botão "Novo"
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(460, 80).click().perform();

                // Etapa
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(-480, -80).click().perform();
                // Equipe
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 25).click().perform();
                // Nome
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 25).click().perform();
                // Slogan
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 25).click().perform();

                // Salvar Cadastro
                Thread.sleep(500); // RETROCEDER X170
                new Actions(navegador).moveByOffset(380, -180).click().perform();


                //"Pessoas"\\
                // Clicar em Pessoa
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(-640, 150).click().perform();

                // "NOVO"
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(770, 40).click().perform();

                // Grupo Etapa
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(-520, -100).click().perform();

                // Função
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(-20, 25).click().perform();

                // Pessoa
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(0, 25).click().perform();

                // Salvar Cadastro
                Thread.sleep(1000);//RETROCEDER X300
                new Actions(navegador).moveByOffset(430, -140).click().perform();


                //"Respostas"\\
                // Clicar em respostas
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(-570, 150).click().perform();

                // "NOVO"
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(600, 45).click().perform();

                // Grupo Etapa
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(-200, -100).click().perform();

                // Pergunta
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(0, 30).click().perform();

                // Resposta
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(0, 30).click().perform();


                // Salvar Cadastro
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(160, -140).click().perform();

                // Tirar “screenshot” no final da execução
                tirarScreenshot(navegador, "Cadastro_Grupo");
            } catch (Exception e) {
                System.out.println("Erro no processo: " + e.getMessage());
            } finally {
                // Pausa antes do próximo loop (ajustar conforme necessário)
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
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//"
                    + nomeArquivo + "_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva em: " + destinoFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Erro ao salvar screenshot: " + e.getMessage());
        }
    }
}

