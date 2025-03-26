package br.com.test4.operação.contribuição;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

@DisplayName("Teste automatizado de cadastro número 1")
public class TestsContribuição {
    @SuppressWarnings("BusyWait")
    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {

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
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_contribuicao");

                // GERAÇÃO DE DADOS DINÂMICOS
                Random random = new Random();
                String nome = "TestSeleniumWD" + random.nextInt(1000);
                String descricao = "TSTSWD" + random.nextInt(1000);
                String valor = "0" + random.nextInt(100);
                String[] gruposacao = {"134"};
                String grupoacao = gruposacao[random.nextInt(gruposacao.length)];

                // NOVO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[1]")).click();

                new Actions(navegador).moveByOffset(0, -20).click().sendKeys(nome).sendKeys(Keys.TAB).perform();// NOME
                new Actions(navegador).sendKeys(descricao).sendKeys(Keys.TAB).perform();// DESCRIÇÃO
                new Actions(navegador).sendKeys(valor).sendKeys(Keys.TAB).perform();// VALOR
                new Actions(navegador).sendKeys(grupoacao).sendKeys(Keys.TAB).perform();// GRUPO AÇÃO
                new Actions(navegador).sendKeys(Keys.ENTER).perform();// ETAPA
                new Actions(navegador).moveByOffset(0, 150).click().perform();// MARCAR A OPÇÃO "TODOS"

                // SALVAR CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[3]")).click();
                //FECHAR CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[7]")).click();

                // Capturar screenshot para análise visual
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Contribuição//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());
            }
            catch (Exception e) {System.out.println("Erro: " + e.getMessage());}

            try {// Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
            }
            catch (InterruptedException e) {Thread.currentThread().interrupt();}

            //ATUALIZAR ABA DE CADASTROS
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();

            //SELECIONAR CADASTRO PARA CONFERENCIA
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, 10).doubleClick().perform();

            //CLICAR EM "ALTERAR" CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]")).click();

            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            JavascriptExecutor js = (JavascriptExecutor) navegador;
            StringBuilder mensagensErro = new StringBuilder();

            // NOME
            new Actions(navegador).moveByOffset(0, -180).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNomeContribuicao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Nome está vazio
            if (valorCampoNomeContribuicao == null || valorCampoNomeContribuicao.isEmpty()) {mensagensErro.append("ERRO: O campo Nome está vazio.");
                System.out.println("ERRO: O campo Nome está vazio.");}
            else {System.out.println("O campo Nome foi preenchido com: " + valorCampoNomeContribuicao);}

            // DESCRIÇÃO
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDescricao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo DESCRIÇÃO está vazio
            if (valorCampoDescricao == null || valorCampoDescricao.isEmpty()) {mensagensErro.append("ERRO: O campo DESCRIÇÃO está vazio.");
                System.out.println("ERRO: O campo DESCRIÇÃO está vazio.");}
            else {System.out.println("O campo DESCRIÇÃO foi preenchido com: " + valorCampoDescricao);}

            // VALOR
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoValor = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Valor está vazio
            if (valorCampoValor == null || valorCampoValor.isEmpty()) {mensagensErro.append("ERRO: O campo Valor está vazio.");
                System.out.println("ERRO: O campo Valor está vazio.");}
            else {System.out.println("O campo Valor foi preenchido com: " + valorCampoValor);}

            // GRUPO AÇÃO
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoGrupoAcao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Acao está vazio
            if (valorCampoGrupoAcao == null || valorCampoGrupoAcao.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Acao está vazio.");
                System.out.println("ERRO: O campo Grupo Acao está vazio.");}
            else {System.out.println("O campo Grupo Acao foi preenchido com: " + valorCampoGrupoAcao);}

            // ETAPA
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoGrupoEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Etapa está vazio
            if (valorCampoGrupoEtapa == null || valorCampoGrupoEtapa.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                System.out.println("ERRO: O campo Etapa está vazio.");}
            else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoGrupoEtapa);}

            // Definir o caminho e nome do arquivo
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta1 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Contribuição//erros log//erro";
            String caminhoArquivo1 = caminhoPasta1 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta1);
                if (!pasta.exists()) {pasta.mkdirs();}

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                FileWriter writer = new FileWriter(caminhoArquivo1, true);
                writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                writer.close();

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo1);}
            catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}
            Thread.sleep(500);



                                                     //"INICIO DE CICLO DE ALTERAÇÃO DOS DADOS"\\

            // GERAÇÃO DE DADOS DINÂMICOS
            Random random = new Random();
            String nome2 = "TestSeleniumALT" + random.nextInt(1000);
            String descricao2 = "TSTSWD" + random.nextInt(1000);
            String valor2 = "0" + random.nextInt(100);

            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, 20).doubleClick().sendKeys(nome2).sendKeys(Keys.TAB).perform();// NOME
            new Actions(navegador).sendKeys(descricao2).sendKeys(Keys.TAB).perform();// DESCRIÇÃO
            new Actions(navegador).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(valor2).sendKeys(Keys.TAB).perform();// VALOR
            new Actions(navegador).sendKeys(Keys.BACK_SPACE).sendKeys("TESTE 02 FIXO").sendKeys(Keys.TAB).perform();//GRUPO AÇÃO
            new Actions(navegador).sendKeys(Keys.BACK_SPACE).sendKeys("TESTE 02 ETAPA").sendKeys(Keys.TAB).perform();//ETAPA
            new Actions(navegador).moveByOffset(0, 150).click().perform();// DESMARCAR A OPÇÃO "TODOS"

            // SALVAR CADASTRO
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[3]")).click();
            //FECHAR CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[7]")).click();

            // Capturar screenshot para análise visual
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Contribuição//Cadastro alt//resultado_teste_ALT" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            //ATUALIZAR ABA DE CADASTROS
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();

            //SELECIONAR CADASTRO PARA CONFERENCIA
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, -5).doubleClick().perform();
            //CLICAR EM "ALTERAR" CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]")).click();

            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            mensagensErro = new StringBuilder();

            // NOME
            new Actions(navegador).moveByOffset(0, -200).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNomeContribuicao2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Nome está vazio
            if (valorCampoNomeContribuicao2 == null || valorCampoNomeContribuicao2.isEmpty()) {mensagensErro.append("ERRO: O campo Nome está vazio.");
                System.out.println("ERRO: O campo Nome está vazio.");}
            else {System.out.println("O campo Nome foi preenchido com: " + valorCampoNomeContribuicao2);}

            // DESCRIÇÃO
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDescricao2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo DESCRIÇÃO está vazio
            if (valorCampoDescricao2 == null || valorCampoDescricao2.isEmpty()) {mensagensErro.append("ERRO: O campo DESCRIÇÃO está vazio.");
                System.out.println("ERRO: O campo DESCRIÇÃO está vazio.");}
            else {System.out.println("O campo DESCRIÇÃO foi preenchido com: " + valorCampoDescricao2);}

            // VALOR
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoValor2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Valor está vazio
            if (valorCampoValor2 == null || valorCampoValor2.isEmpty()) {mensagensErro.append("ERRO: O campo Valor está vazio.");
                System.out.println("ERRO: O campo Valor está vazio.");}
            else {System.out.println("O campo Valor foi preenchido com: " + valorCampoValor2);}

            // GRUPO AÇÃO
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoGrupoAcao2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Acao está vazio
            if (valorCampoGrupoAcao2 == null || valorCampoGrupoAcao2.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Acao está vazio.");
                System.out.println("ERRO: O campo Grupo Acao está vazio.");}
            else {System.out.println("O campo Grupo Acao foi preenchido com: " + valorCampoGrupoAcao2);}

            // ETAPA
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoGrupoEtapa2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Etapa está vazio
            if (valorCampoGrupoEtapa2 == null || valorCampoGrupoEtapa2.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                System.out.println("ERRO: O campo Etapa está vazio.");}
            else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoGrupoEtapa2);}

            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta2 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Contribuição//erros log alt//erro";
            String caminhoArquivo2 = caminhoPasta2 + "erroslogALT" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta2);
                if (!pasta.exists()) {pasta.mkdirs();}

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                FileWriter writer = new FileWriter(caminhoArquivo2, true);
                writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                writer.close();

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo2);}
            catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}


            //EXCLUIR CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[5]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div[5]/div[3]/div[2]/div[1]/div[2]/div")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[5]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
            Thread.sleep(500);

            //FECHAR NAVEGADOR
            // Finalizar navegador ao final de cada execução{
            navegador.quit();

            // Pausa antes do próximo “loop” (ajustar conforme necessário)
            Thread.sleep(500);
        }
    }
}
