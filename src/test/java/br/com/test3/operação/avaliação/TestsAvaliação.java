package br.com.test3.operação.avaliação;

import org.apache.logging.log4j.core.Appender;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;

@DisplayName("Teste automatizado de cadastro número 1")
public class TestsAvaliação {
    @SuppressWarnings("BusyWait")
    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {

        // Loop infinito para repetir o processo completo
        while (true) {
            WebDriverManager.chromedriver().setup();
            WebDriver navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            Dimension tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);
            Actions actions = null;
            String timestamp;

            try {
                // Abrir o o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha para entrar na conta da SEG
                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                // Espera para aparecer novo campo
                WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                WebElement campoDinamico = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("home.login.entidade")));
                campoDinamico.sendKeys("SEG");

                // Abrindo a janela de seleção de entidade
                navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text")).sendKeys(Keys.TAB);

                // Entrar no SEG DESENVOLVIMENTO
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_aba_avaliacao");

                // "NOVO"
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[2]")).click();

                new Actions(navegador).moveByOffset(0, -25).click().sendKeys("134").sendKeys(Keys.TAB).perform();//GRUPO AÇÃO
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6" + "]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div")).click();//ETAPA
                new Actions(navegador).moveByOffset(0, 60).click().sendKeys("15255").perform();// PESSOA
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys("5428").sendKeys(Keys.ENTER).perform();// PERFIL
                new Actions(navegador).moveByOffset(0, 45).doubleClick().sendKeys("30").sendKeys(Keys.TAB).perform();// ÁREA
                new Actions(navegador).sendKeys("10").perform();// NOTA

                // SALVAR CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[3]")).click();
                Thread.sleep(500);
                // Capturar screenshot para análise visual
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Avaliação//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {System.out.println("Erro: " + e.getMessage());}
            finally {
                try {
                    Thread.sleep(500);}
                catch (InterruptedException e) {Thread.currentThread().interrupt();}
                // Finalizar navegador ao final de cada execução
                {navegador.quit();}
            }



                                             // "REABRIR PARA CONFERENCIA DE ALTERAÇÃO DE CADASTRO" \\

            // Configurar o WebDriver
            WebDriverManager.chromedriver().setup();

            navegador = new ChromeDriver();
            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            JavascriptExecutor js = null;
            try {
                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                actions = new Actions(navegador);

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

                actions = new Actions(navegador);

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_aba_avaliacao");

                //RE-SELECIONAR O CADASTRO PARA CONFERENCIA
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(-40, 120).doubleClick().perform();

                // CLICAR EM ALTERAR
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]")).click();

                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();

                // GRUPO AÇÃO
                new Actions(navegador).moveByOffset(0, -180).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoGrupoAcao = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo GRUPO AÇÃO está vazio
                if (valorCampoGrupoAcao == null || valorCampoGrupoAcao.isEmpty()) {mensagensErro.append("ERRO: O campo GRUPO AÇÃO está vazio.");
                    System.out.println("ERRO: O campo GRUPO AÇÃO está vazio.");}
                else {System.out.println("O campo GRUPO AÇÃO foi preenchido com: " + valorCampoGrupoAcao);}

                // ETAPA
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEtapa = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo ETAPA está vazio
                if (valorCampoEtapa == null || valorCampoEtapa.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                    System.out.println("ERRO: O campo Etapa está vazio.");}
                else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapa);}

                // PESSOA
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPessoa = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Pessoa está vazio
                if (valorCampoPessoa == null || valorCampoPessoa.isEmpty()) {mensagensErro.append("ERRO: O campo Pessoa está vazio.");
                    System.out.println("ERRO: O campo Pessoa está vazio.");}
                else {System.out.println("O campo Pessoa foi preenchido com: " + valorCampoPessoa);}

                // PERFIL
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPerfil = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Perfil está vazio
                if (valorCampoPerfil == null || valorCampoPerfil.isEmpty()) {mensagensErro.append("ERRO: O campo Perfil está vazio.");
                    System.out.println("ERRO: O campo Perfil está vazio.");}
                else {System.out.println("O campo Perfil foi preenchido com: " + valorCampoPerfil);}

                // ÁREA
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoArea = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo ÁREA está vazio
                if (valorCampoArea == null || valorCampoArea.isEmpty()) {mensagensErro.append("ERRO: O campo ÁREA está vazio.");
                    System.out.println("ERRO: O campo ÁREA está vazio.");}
                else {System.out.println("O campo ÁREA foi preenchido com: " + valorCampoArea);}

                // NOTA
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNota = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nota está vazio
                if (valorCampoNota == null || valorCampoNota.isEmpty()) {mensagensErro.append("ERRO: O campo Nota está vazio.");
                    System.out.println("ERRO: O campo Nota está vazio.");
                } else {System.out.println("O campo Nota foi preenchido com: " + valorCampoNota);}

                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta1 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Avaliação//erros log//erro";
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
                Thread.sleep(1000);



                                                        // 'ALTERAÇÃO DE DADOS CADASTRADOS" \\

                new Actions(navegador).moveByOffset(0, 25).doubleClick().click().sendKeys("TESTE 02 FIXO").perform();// GRUPO AÇÃO
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div")).click();// ETAPA
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div")).click();
                new Actions(navegador).moveByOffset(0, 65).doubleClick().doubleClick().sendKeys("Teste Conjuge Nº01").perform();// PESSOA
                new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys("5428").perform();// PERFIL
                new Actions(navegador).moveByOffset(0, 40).doubleClick().doubleClick().sendKeys("39").perform();// ÁREA
                new Actions(navegador).moveByOffset(0, 30).doubleClick().doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys("0").perform();// NOTA

                //SALVAR CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[3]")).click();

                // Capturar screenshot para análise visual
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Avaliação//Alteração//resultado_teste_ALT" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());}
            catch (Exception e) {System.out.println("Erro: " + e.getMessage());}



                                                              // "CONFERENCIA DE ALTERAÇÃO" \\

            //ATUALIZAR PÁGINA
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();

            //RE-SELECIONAR O CADASTRO PARA CONFERENCIA
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, 0).doubleClick().perform();

            //CLICAR EM ALTERAR CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]")).click();

            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            js = (JavascriptExecutor) navegador;
            StringBuilder mensagensErro = new StringBuilder();

            // GRUPO AÇÃO
            new Actions(navegador).moveByOffset(0, -180).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoGrupoAcao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo GRUPO AÇÃO está vazio
            if (valorCampoGrupoAcao == null || valorCampoGrupoAcao.isEmpty()) {mensagensErro.append("ERRO: O campo GRUPO AÇÃO está vazio.");
                System.out.println("ERRO: O campo GRUPO AÇÃO está vazio.");}
            else {System.out.println("O campo GRUPO AÇÃO foi preenchido com: " + valorCampoGrupoAcao);}

            // ETAPA
            actions.sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo ETAPA está vazio
            if (valorCampoEtapa == null || valorCampoEtapa.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                System.out.println("ERRO: O campo Etapa está vazio.");}
            else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapa);}

            // PESSOA
            actions.sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPessoa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Pessoa está vazio
            if (valorCampoPessoa == null || valorCampoPessoa.isEmpty()) {mensagensErro.append("ERRO: O campo Pessoa está vazio.");
                System.out.println("ERRO: O campo Pessoa está vazio.");}
            else {System.out.println("O campo Pessoa foi preenchido com: " + valorCampoPessoa);}

            // PERFIL
            actions.sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPerfil = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Perfil está vazio
            if (valorCampoPerfil == null || valorCampoPerfil.isEmpty()) {mensagensErro.append("ERRO: O campo Perfil está vazio.");
                System.out.println("ERRO: O campo Perfil está vazio.");}
            else {System.out.println("O campo Perfil foi preenchido com: " + valorCampoPerfil);}


            // ÁREA
            actions.sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoArea = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo ÁREA está vazio
            if (valorCampoArea == null || valorCampoArea.isEmpty()) {mensagensErro.append("ERRO: O campo ÁREA está vazio.");
                System.out.println("ERRO: O campo ÁREA está vazio.");}
            else {System.out.println("O campo ÁREA foi preenchido com: " + valorCampoArea);}

            // NOTA
            actions.sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNota = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Nota está vazio
            if (valorCampoNota == null || valorCampoNota.isEmpty()) {mensagensErro.append("ERRO: O campo Nota está vazio.");
                System.out.println("ERRO: O campo Nota está vazio.");}
            else {System.out.println("O campo Nota foi preenchido com: " + valorCampoNota);}

            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta2 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Avaliação//erros log alt//erro";
            String caminhoArquivo2 = caminhoPasta2 + "erroslogAlt" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta2);
                if (!pasta.exists()) {pasta.mkdirs();}

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                FileWriter writer = new FileWriter(caminhoArquivo2, true);
                writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                writer.close();

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo2);}
            catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}
            Thread.sleep(500);

            //EXCLUIR CADASTRO
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[5]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
            Thread.sleep(500);

            //FECHAR NAVEGADOR
            // Finalizar navegador ao final de cada execução
            {navegador.quit();}
        }
    }
}
