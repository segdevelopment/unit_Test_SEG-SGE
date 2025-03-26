package br.com.test4.operação.contribuição;

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
import java.util.Random;

@DisplayName("Teste automatizado de cadastro número 1")
public class TestsContribuição {
    @SuppressWarnings("BusyWait")
    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {

        // Loop infinito para repetir o processo completo
        while (true) {  // Descomente esta linha para ativar o loop infinito
            WebDriverManager.chromedriver().setup();
            WebDriver navegador = new ChromeDriver();

            try {
                // Abrir o o SEG
                navegador.get("https://app.seg.inf.br/novo/");
                // Não tiraremos screenshot aqui, pois será no final

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
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_contribuicao");

                // GERAÇÃO DE DADOS DINÂMICOS
                Random random = new Random();
                String nome = "TestSeleniumWD" + random.nextInt(1000);
                String descricao = "TSTSWD" + random.nextInt(1000);
                String valor = "0" + random.nextInt(100);
                String[] gruposacao = {"?", "?", "?"};
                String grupoacao = gruposacao[random.nextInt(gruposacao.length)];

                // NOVO
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(500, 15).click().perform();

                // NOME
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(-300, -45).click().sendKeys(nome).perform();

                // DESCRIÇÃO
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(descricao).perform();

                // VALOR
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(valor).perform();

                // GRUPO AÇÃO
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).click().perform();

                // ETAPA
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).click().perform();

                // MARCAR A OPÇÃO "TODOS"
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).click().perform();

                // SALVAR CADASTRO
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, -230).click().perform();

                // **Captura de tela FINAL**, após todo o fluxo ser executado
                tirarScreenshot(navegador, "Cadastro_Contribuição");

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
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Contribuição//"
                    + nomeArquivo + "_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva em: " + destinoFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Erro ao salvar screenshot: " + e.getMessage());
        }
    }
}
