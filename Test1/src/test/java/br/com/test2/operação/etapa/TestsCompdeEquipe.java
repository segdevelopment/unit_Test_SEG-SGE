package br.com.test2.operação.etapa;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;
import java.util.Random;

@DisplayName("Teste automatizado de cadastro com looping")
public class TestsCompdeEquipe {
    @SuppressWarnings("BusyWait")
    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {

        // Configurar o WebDriver
        WebDriverManager.chromedriver().setup();

        // Iniciar o loop
        while (true) { // Loop infinito
            WebDriver navegador = new ChromeDriver();
            try {
                // Abrir o sistema
                navegador.get("https://app.seg.inf.br/novo/");

                // Login no sistema
                navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                        .sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                // Esperar campo de entidade aparecer e preencher
                WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                WebElement campoDinamico = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("home.login.entidade")));
                campoDinamico.sendKeys("SEG");
                navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir a página de composição de equipes
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");


                // GERAÇÃO DE DADOS DINÂMICOS
                Random random = new Random();
                String[] pessoas = {"15534","15535","15536","15537","15538","15539","15540","15542","15544"};
                String pessoa = pessoas[random.nextInt(pessoas.length)];
                String[] gruposacao = {"134","136","140","142","143","146","147"};
                String grupoacao = gruposacao[random.nextInt(gruposacao.length)];
                String[] funcoesequipe = {"AMARELO","AZUL","VERDE","VERMELHO"};
                String funcaoequipe = funcoesequipe[random.nextInt(funcoesequipe.length)];

                // Clicar no botão "Novo"
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(190, 15).click().perform();

                // Preencher campos (exemplo de cliques e ações)
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(-110, 50).click().sendKeys("EQUIPE FUNÇÃO TESTE 1").perform(); // Modelo Equipe Função
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 60).click().sendKeys("TESTETAPA820").perform(); // Etapa
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, -30).click().sendKeys(grupoacao).perform(); // Grupo Ação
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 70).click().sendKeys(funcaoequipe).perform(); // Função Equipes
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(pessoa).perform(); // Pessoas

                // Salvar Cadastro
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[3]")).click();
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[3]")).click();
                Thread.sleep(500);

                // Tirar “screenshot” no final da execução
                tirarScreenshot(navegador, "Cadastro_Composicao_Equipes");}
            catch (Exception e) {System.out.println("Erro no processo: " + e.getMessage());}
            finally {Thread.sleep(1000); // 3 segundos

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(1000); // Pausa de 1 segundos (ajuste conforme necessário)
                // Finalizar navegador ao final de cada execução
                if (navegador != null) {
                    navegador.quit();}
                }
        }
    }
    // Metodo para tirar ‘screenshot’
    private void tirarScreenshot(WebDriver navegador, String nomeArquivo) throws InterruptedException {
        try {String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Composição de Equipes//"
                    + nomeArquivo + "_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva em: " + destinoFile.getAbsolutePath());}
        catch (Exception e) {System.out.println("Erro ao salvar screenshot: " + e.getMessage());}




        // ABRIR CONFERENCIA
        // Reabrir o navegador para conferência
        try {Thread.sleep(2000);} catch (InterruptedException e) {throw new RuntimeException(e);}
        navegador = new ChromeDriver();

        // Configurar o WebDriver
        WebDriverManager.chromedriver().setup();

        // Abrir o SEG
        navegador.get("https://app.seg.inf.br/novo/");

        // Login e senha
        navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                .sendKeys("JOAO.VICTOR");
        navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
        navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

        // Espera até o campo de entidade estar visível
        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
        WebElement campoDinamico = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("home.login.entidade")));
        campoDinamico.sendKeys("SEG");
        navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
        new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

        // Abrir SGE (Cadastro de Pessoa)
        navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

        // Clicar no cadastro da Composição de Equipe
        Thread.sleep(1000);
        new Actions(navegador).moveByOffset(0, 180).click().perform();


        Thread.sleep(10000000);

        // Selecionar "Alterar"
        Thread.sleep(1500);
        Actions actions2 = new Actions(navegador);
        new Actions(navegador).moveByOffset(0, 0).click().perform();


        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
        JavascriptExecutor js = (JavascriptExecutor) navegador;
        StringBuilder mensagensErro = new StringBuilder();


        // Modelo Equipe Função
        new Actions(navegador).moveByOffset(0, 0).click().sendKeys().perform();
        // Espera para garantir que o campo foi clicado
        Thread.sleep(500);
        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
        String valorCampoMEF = (String) js.executeScript("return document.activeElement.value;");
        // Verificar se o campo Modelo Equipe Função está vazio
        if (valorCampoMEF == null || valorCampoMEF.isEmpty()) {
            mensagensErro.append("ERRO: O campo Modelo Equipe Função está vazio.\\n");
            System.out.println("ERRO: O campo Modelo Equipe Função está vazio.");
        } else {
            System.out.println("O campo Modelo Equipe Função foi preenchido com: " + valorCampoMEF);
        }


        // Grupo Ação
        new Actions(navegador).moveByOffset(-50, 20).click().sendKeys().perform();
        // Espera para garantir que o campo foi clicado
        Thread.sleep(500);
        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
        String valorCampogrupoacao = (String) js.executeScript("return document.activeElement.value;");
        // Verificar se o campo Grupo Ação está vazio
        if (valorCampogrupoacao == null || valorCampogrupoacao.isEmpty()) {
            mensagensErro.append("ERRO: O campo Grupo Ação está vazio.\\n");
            System.out.println("ERRO: O campo Grupo Ação está vazio.");
        } else {
            System.out.println("O campo Grupo Ação foi preenchido com: " + valorCampogrupoacao);
        }


        //Etapa
        new Actions(navegador).moveByOffset(0, 25).click().perform();
        // Espera para garantir que o campo foi clicado
        Thread.sleep(500);
        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
        String valorCampoEtapa = (String) js.executeScript("return document.activeElement.value;");
        // Verificar se o campo Etapa está vazio
        if (valorCampoEtapa == null || valorCampoEtapa.isEmpty()) {
            mensagensErro.append("ERRO: O campo Etapa está vazio.\\n");
            System.out.println("ERRO: O campo Etapa está vazio.");
        } else {
            System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapa);
        }


        //Funções Equipe
        new Actions(navegador).moveByOffset(10, 30).click().perform();
        // Espera para garantir que o campo foi clicado
        Thread.sleep(500);
        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
        String valorCampoFuncoesEquipe = (String) js.executeScript("return document.activeElement.value;");
        // Verificar se o campo Funções Equipe está vazio
        if (valorCampoFuncoesEquipe == null || valorCampoFuncoesEquipe.isEmpty()) {
            mensagensErro.append("ERRO: O campo Funções Equipe está vazio.\\n");
            System.out.println("ERRO: O campo Funções Equipe Paroquia está vazio.");
        } else {
            System.out.println("O campo Funções Equipe foi preenchido com: " + valorCampoFuncoesEquipe);
        }


        //Pessoas
        new Actions(navegador).moveByOffset(0, 30).click().perform();
        // Espera para garantir que o campo foi clicado
        Thread.sleep(500);
        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
        String valorCampoPessoas = (String) js.executeScript("return document.activeElement.value;");
        // Verificar se o campo Pessoas está vazio
        if (valorCampoPessoas == null || valorCampoPessoas.isEmpty()) {
            mensagensErro.append("ERRO: O campo Pessoas está vazio.\\n");
            System.out.println("ERRO: O campo Pessoas Paroquia está vazio.");
        } else {
            System.out.println("O campo Pessoas foi preenchido com: " + valorCampoPessoas);
        }







        Thread.sleep(10000000);









    }
}


