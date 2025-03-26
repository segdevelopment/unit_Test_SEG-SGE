package br.com.test5.operação.convite;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;

@DisplayName("Teste automatizado de cadastro número 1")
public class TestsConvite {
    @SuppressWarnings("BusyWait")
    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {

        // Loop infinito para repetir o processo completo
        while (true) {

            WebDriverManager.chromedriver().setup();
            WebDriver navegador = new ChromeDriver();
            Dimension tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            try {
                // Abrir o o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                // Espera para aparecer novo campo
                WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                WebElement campoDinamico = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home.login.entidade")));
                campoDinamico.sendKeys("SEG");

                // Abrindo a janela de seleção de entidade
                navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text")).sendKeys(Keys.TAB);

                // Entrar no SEG DESENVOLVIMENTO
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_aba_convite");

                // NOVO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]")).click();
                new Actions(navegador).moveByOffset(0, 10).click().sendKeys("134").sendKeys(Keys.TAB).perform();// GRUPO AÇÃO
                new Actions(navegador).sendKeys("TESTE 01 ETAPA").sendKeys(Keys.TAB).perform();// ETAPA
                new Actions(navegador).sendKeys("908").sendKeys(Keys.TAB).perform();// EQUIPE FUNÇÃO
                Thread.sleep(500);
                new Actions(navegador).sendKeys("15255").sendKeys(Keys.ENTER).sendKeys(Keys.TAB).perform();// CONVIDADO
                new Actions(navegador).sendKeys("01012025").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA DO CONVITE
                new Actions(navegador).sendKeys("10022025").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA DA RESPOSTA
                new Actions(navegador).sendKeys(Keys.TAB).perform(); // CONVIDANTE
                new Actions(navegador).sendKeys("Teste = Observação do Convite").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// OBSERVAÇÃo
                new Actions(navegador).moveByOffset(-20, 325).click().perform(); //RECUSOU
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys("313").sendKeys(Keys.ENTER).perform();// JUSTIFICATIVA CASO RECUSE

                // SALVAR CADASTRO
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[4]/div[2]/div[1]/div[2]/div[4]")).click();
                Thread.sleep(200);

                // Capturar screenshot para análise visual
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Convite//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());
            }
            catch (InterruptedException ex) {throw new RuntimeException(ex);}



                                                         //"INICIO DE CICLO DE CONFERENCIA DE DADOS"\\


            //CLICAR PARA SELECIONAR OS CADASTROS RECUSADOS
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"sge_ficha_convite.spliter.checkbox\"]/div")).click();

            //ATUALIZAR ABA DE CADASTROS
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[4]")).click();

            //SELECIONAR CADASTRO PARA CONFERENCIA
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(-60, -190).doubleClick().perform();
            //CLICAR EM "ALTERAR" CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[4]/div[2]/div[1]/div[2]/div[5]")).click();

            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            JavascriptExecutor js = (JavascriptExecutor) navegador;
            StringBuilder mensagensErro = new StringBuilder();

            // GRUPO AÇÃO
            new Actions(navegador).moveByOffset(0, -165).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNomeGA = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Ação está vazio
            if (valorCampoNomeGA == null || valorCampoNomeGA.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Ação está vazio.");
                System.out.println("ERRO: O campo Grupo Ação está vazio.");}
            else {System.out.println("O campo Grupo Ação foi preenchido com: " + valorCampoNomeGA);}

            // EQUIPE FUNÇÃO
            new Actions(navegador).moveByOffset(0, 60).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoEquipeF = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo EQUIPE FUNÇÃO está vazio
            if (valorCampoEquipeF == null || valorCampoEquipeF.isEmpty()) {mensagensErro.append("ERRO: O campo EQUIPE FUNÇÃO está vazio.");
                System.out.println("ERRO: O campo EQUIPE FUNÇÃO está vazio.");}
            else {System.out.println("O campo EQUIPE FUNÇÃO foi preenchido com: " + valorCampoEquipeF);}

            // CONVITE
            new Actions(navegador).moveByOffset(0, 60).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoConvite = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo CONVITE está vazio
            if (valorCampoConvite == null || valorCampoConvite.isEmpty()) {mensagensErro.append("ERRO: O campo CONVITE está vazio.");
                System.out.println("ERRO: O campo CONVITE está vazio.");}
            else {System.out.println("O campo CONVITE foi preenchido com: " + valorCampoConvite);}

            // RESPOSTA
            new Actions(navegador).moveByOffset(0, 30).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoResposta = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo RESPOSTA está vazio
            if (valorCampoResposta == null || valorCampoResposta.isEmpty()) {mensagensErro.append("ERRO: O campo RESPOSTA está vazio.");
                System.out.println("ERRO: O campo RESPOSTA está vazio.");}
            else {System.out.println("O campo RESPOSTA foi preenchido com: " + valorCampoResposta);}


            // CONVIDANTE
            new Actions(navegador).moveByOffset(0, 30).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoConvidante = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo CONVIDANTE está vazio
            if (valorCampoConvidante == null || valorCampoConvidante.isEmpty()) {mensagensErro.append("ERRO: O campo CONVIDANTE está vazio.");
                System.out.println("ERRO: O campo CONVIDANTE está vazio.");}
            else {System.out.println("O campo CONVIDANTE foi preenchido com: " + valorCampoConvidante);}

            // OBSERVAÇÃO
            new Actions(navegador).moveByOffset(0, 50).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoObservacao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Etapa está vazio
            if (valorCampoObservacao == null || valorCampoObservacao.isEmpty()) {mensagensErro.append("ERRO: O campo OBSERVAÇÃO está vazio.");
                System.out.println("ERRO: O campo OBSERVAÇÃO está vazio.");}
            else {System.out.println("O campo OBSERVAÇÃO foi preenchido com: " + valorCampoObservacao);}

            // JUSTIFICATIVA
            new Actions(navegador).moveByOffset(0, 100).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoJustificativa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Etapa está vazio
            if (valorCampoJustificativa == null || valorCampoJustificativa.isEmpty()) {mensagensErro.append("ERRO: O campo JUSTIFICATIVA está vazio.");
                System.out.println("ERRO: O campo JUSTIFICATIVA está vazio.");}
            else {System.out.println("O campo JUSTIFICATIVA foi preenchido com: " + valorCampoJustificativa);}

            // Definir o caminho e nome do arquivo
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta8 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Convite//erros log//erro";
            String caminhoArquivo8 = caminhoPasta8 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta8);
                if (!pasta.exists()) {pasta.mkdirs();}

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                FileWriter writer = new FileWriter(caminhoArquivo8, true);
                writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                writer.close();

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo8);}
            catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}
            Thread.sleep(500);



                                                      //"INICIO DE CICLO DE ALTERAÇÃO DOS DADOS"\\

            new Actions(navegador).moveByOffset(50, -335).doubleClick().click().sendKeys("134").perform();// GRUPO AÇÃO
            new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys("TESTE 02 ETAPA").perform();// ETAPA
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys().perform();// EQUIPE FUNÇÃO
            new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys().sendKeys(Keys.ENTER).perform();// CONVIDADO
            new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys("11112026").perform();// DATA DO CONVITE
            new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys("12112026").perform();// DATA DA RESPOSTA
            new Actions(navegador).moveByOffset(0, 30).doubleClick().perform();// CONVIDANTE
            new Actions(navegador).moveByOffset(0, 50).doubleClick().click().sendKeys("Teste = Observação do Convite Alterado").perform();// OBSERVAÇÃO
            new Actions(navegador).moveByOffset(0, 85).click().perform();// RECUSOU
            new Actions(navegador).moveByOffset(0, 30).click().sendKeys("313").sendKeys(Keys.ENTER).perform();// JUSTIFICATIVA CASO RECUSE

            // SALVAR CADASTRO
            Thread.sleep(400);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[4]/div[2]/div[1]/div[2]/div[4]")).click();
            Thread.sleep(200);

            // Capturar screenshot para análise visual
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Convite//Cadastro alt//resultado_teste_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            //INICIO DE CICLO DE CONFERENCIA DE DADOS\\

            //ATUALIZAR ABA DE CADASTROS
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[4]")).click();

            //SELECIONAR CADASTRO PARA CONFERENCIA
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(-30, -190).doubleClick().perform();
            //CLICAR EM "ALTERAR" CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[4]/div[2]/div[1]/div[2]/div[5]")).click();

            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            mensagensErro = new StringBuilder();

            // EQUIPE FUNÇÃO
            Thread.sleep(150);
            new Actions(navegador).moveByOffset(0, -90).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoEquipeF2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo EQUIPE FUNÇÃO está vazio
            if (valorCampoEquipeF2 == null || valorCampoEquipeF2.isEmpty()) {mensagensErro.append("ERRO: O campo EQUIPE FUNÇÃO está vazio.");
                System.out.println("ERRO: O campo EQUIPE FUNÇÃO está vazio.");}
            else {System.out.println("O campo EQUIPE FUNÇÃO foi preenchido com: " + valorCampoEquipeF2);}

            // CONVITE
            Thread.sleep(150);
            new Actions(navegador).moveByOffset(0, 60).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoConvite2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo CONVITE está vazio
            if (valorCampoConvite2 == null || valorCampoConvite2.isEmpty()) {mensagensErro.append("ERRO: O campo CONVITE está vazio.");
                System.out.println("ERRO: O campo CONVITE está vazio.");}
            else {System.out.println("O campo CONVITE foi preenchido com: " + valorCampoConvite2);}

            // RESPOSTA
            Thread.sleep(150);
            new Actions(navegador).moveByOffset(0, 30).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoResposta2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo RESPOSTA está vazio
            if (valorCampoResposta2 == null || valorCampoResposta2.isEmpty()) {mensagensErro.append("ERRO: O campo RESPOSTA está vazio.");
                System.out.println("ERRO: O campo RESPOSTA está vazio.");}
            else {System.out.println("O campo RESPOSTA foi preenchido com: " + valorCampoResposta2);}

            // CONVIDANTE
            Thread.sleep(150);
            new Actions(navegador).moveByOffset(0, 30).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoConvidante2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo CONVIDANTE está vazio
            if (valorCampoConvidante2 == null || valorCampoConvidante2.isEmpty()) {mensagensErro.append("ERRO: O campo CONVIDANTE está vazio.");
                System.out.println("ERRO: O campo CONVIDANTE está vazio.");}
            else {System.out.println("O campo CONVIDANTE foi preenchido com: " + valorCampoConvidante2);}

            // OBSERVAÇÃO
            Thread.sleep(150);
            new Actions(navegador).moveByOffset(0, 50).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoObservacao2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Etapa está vazio
            if (valorCampoObservacao2 == null || valorCampoObservacao2.isEmpty()) {mensagensErro.append("ERRO: O campo OBSERVAÇÃO está vazio.");
                System.out.println("ERRO: O campo OBSERVAÇÃO está vazio.");}
            else {System.out.println("O campo OBSERVAÇÃO foi preenchido com: " + valorCampoObservacao2);}

            // JUSTIFICATIVA
            Thread.sleep(150);
            new Actions(navegador).moveByOffset(0, 100).click().sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoJustificativa2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Etapa está vazio
            if (valorCampoJustificativa2 == null || valorCampoJustificativa2.isEmpty()) {mensagensErro.append("ERRO: O campo JUSTIFICATIVA está vazio.");
                System.out.println("ERRO: O campo JUSTIFICATIVA está vazio.");}
            else {System.out.println("O campo JUSTIFICATIVA foi preenchido com: " + valorCampoJustificativa2);}


            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta9 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Convite//erros log alt//erro";
            String caminhoArquivo9 = caminhoPasta9 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta9);
                if (!pasta.exists()) {pasta.mkdirs();}

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                FileWriter writer = new FileWriter(caminhoArquivo9, true);
                writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                writer.close();

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo9);}
            catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

            //EXCLUIR CADASTRO
            Thread.sleep(800);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[4]/div[2]/div[1]/div[2]/div[6]")).click();
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();

            Thread.sleep(500);

            //SELECIONAR CADASTRO PARA CONFERENCIA
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, -160).doubleClick().perform();

            //EXCLUIR CADASTRO
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[4]/div[2]/div[1]/div[2]/div[6]")).click();
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();

            Thread.sleep(300);
            // Fechar o navegador ao final de cada interação
            {navegador.quit();}
        }
    }
}
