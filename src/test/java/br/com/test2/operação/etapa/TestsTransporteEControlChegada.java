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
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

@DisplayName("Teste automatizado de cadastro número 1")
public class TestsTransporteEControlChegada {
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

                // Definindo o tamanho da janela do navegador
                Dimension tamanho = new Dimension(1024, 768);
                navegador.manage().window().setSize(tamanho);

                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha para entrar na conta da SEG.
                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
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
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[5]/div")).click();


                                                                            //"Cadastro"\\
                // Clicar no botão "Novo"
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]")).click();


                new Actions(navegador).moveByOffset(-50, -30).click().sendKeys("551").sendKeys(Keys.TAB).perform();// ETAPA
                new Actions(navegador).sendKeys("Testswd1").sendKeys(Keys.TAB).perform();// MOTORISTA
                new Actions(navegador).sendKeys("Conjuge Testswd1").sendKeys(Keys.ENTER).perform();// PASSAGEIRO

                // SALVAR CADASTRO
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]")).click();

                // Capturar screenshot para análise visual
                Thread.sleep(400);
                String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Transporte e Controle de Chegada//Transporte//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

                // FECHAR CADASTRO
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[7]")).click();

                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[6]")).click();
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[6]")).click();
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[6]")).click();




                                                //INICIO DE CICLO DE CONFERENCIA DE DADOS DO CADASTRO\\

                //SELECIONAR CADASTRO
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 190).doubleClick().sendKeys(Keys.TAB).perform();

                // Selecionar "Alterar"
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[4]")).click();

                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();

                // ETAPA
                new Actions(navegador).moveByOffset(-60, -180).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEtapa = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Etapa Função está vazio
                if (valorCampoEtapa == null || valorCampoEtapa.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                    System.out.println("ERRO: O campo Etapa está vazio.");}
                else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapa);}

                // MOTORISTA
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoMotorista = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Motorista está vazio
                if (valorCampoMotorista == null || valorCampoMotorista.isEmpty()) {mensagensErro.append("ERRO: O campo Motorista está vazio.");
                    System.out.println("ERRO: O campo Motorista está vazio.");}
                else {System.out.println("O campo Motorista foi preenchido com: " + valorCampoMotorista);}

                // PASSAGEIRO
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPassageiro = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Passageiro está vazio
                if (valorCampoPassageiro == null || valorCampoPassageiro.isEmpty()) {mensagensErro.append("ERRO: O campo Passageiro está vazio.");
                    System.out.println("ERRO: O campo Passageiro está vazio.");}
                else {System.out.println("O campo Passageiro foi preenchido com: " + valorCampoPassageiro);}

                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                // Definir o caminho e nome do arquivo
                String caminhoPasta = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Transporte e Controle de Chegada//Transporte//erros log//erros";
                String caminhoArquivo = caminhoPasta + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    FileWriter writer = new FileWriter(caminhoArquivo, true);
                    writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                    writer.close();

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);



                                             // "INICIO DE CICLO DE ALTERAÇÃO DE DADOS DO CADASTRO" \\
                //ALTERAÇÃO DOS DADOS

                // ETAPA
                Thread.sleep(250);
                new Actions(navegador).moveByOffset(0, -60).click().perform();
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div")).click();
                Thread.sleep(250);
                new Actions(navegador).moveByOffset(80, 30).doubleClick().perform();// MOTORISTA
                new Actions(navegador).moveByOffset(-40, 0).doubleClick().click().sendKeys("Teste Nº01").sendKeys(Keys.TAB).perform();// MOTORISTA


                new Actions(navegador).sendKeys("Teste Conjuge Nº01").perform();// PASSAGEIRO


                //SALVAR CADASTRO
                navegador.findElement(By.xpath("/html/body/div/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]")).click();
                Thread.sleep(500);
                //navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[3]/div[2]/div[1]/div[2]/div")).click();
                //SALVAR CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("/html/body/div/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]")).click();

                Thread.sleep(1000);
                // Capturar screenshot para análise visual
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Transporte e Controle de Chegada//Transporte//Cadastros alt//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

                //FECHAR CADASTRO
                Thread.sleep(800);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[7]")).click();
                Thread.sleep(200);

                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[6]")).click();
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[6]")).click();
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[6]")).click();



                                                 // "INICIO DE CICLO DE CONFERENCIA DE DADOS DO CADASTRO" \\

                //SELECIONAR CADASTRO
                Thread.sleep(600);
                new Actions(navegador).moveByOffset(0, 170).doubleClick().sendKeys(Keys.TAB).perform();

                // Selecionar "Alterar"
                Thread.sleep(600);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[4]")).click();

                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                mensagensErro = new StringBuilder();


                // ETAPA
                new Actions(navegador).moveByOffset(-60, -200).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEtapa2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Etapa Função está vazio
                if (valorCampoEtapa2 == null || valorCampoEtapa2.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                    System.out.println("ERRO: O campo Etapa está vazio.");}
                else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapa2);}

                // MOTORISTA
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoMotorista2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Motorista está vazio
                if (valorCampoMotorista2 == null || valorCampoMotorista2.isEmpty()) {mensagensErro.append("ERRO: O campo Motorista está vazio.");
                    System.out.println("ERRO: O campo Motorista está vazio.");}
                else {System.out.println("O campo Motorista foi preenchido com: " + valorCampoMotorista2);}

                // PASSAGEIRO
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPassageiro2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Passageiro está vazio
                if (valorCampoPassageiro2 == null || valorCampoPassageiro2.isEmpty()) {mensagensErro.append("ERRO: O campo Passageiro está vazio.");
                    System.out.println("ERRO: O campo Passageiro está vazio.");}
                else {System.out.println("O campo Passageiro foi preenchido com: " + valorCampoPassageiro2);}

                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                // Definir o caminho e nome do arquivo
                String caminhoPasta2 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Transporte e Controle de Chegada//Transporte//erros log alt//erros";
                String caminhoArquivo2 = caminhoPasta2 + "erroslogalt" + timestamp + ".txt"; // Nome fixo do arquivo

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta2);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    FileWriter writer = new FileWriter(caminhoArquivo2, true);
                    writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                    writer.close();

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo2);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}


                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);

                // Finalizar navegador ao final de cada execução
                {navegador.quit();}
            }
            catch (InterruptedException e) {throw new RuntimeException(e);}



            // / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
            // / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
            // / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
            // / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /

                                                    //INICIO DE CICLO DE OUTRA ABA\\

                                                      //""CONTROLE DE CHEGADA""\\

            try {
                // Driver
                WebDriverManager.chromedriver().setup();
                navegador = new ChromeDriver();
                // Definindo o tamanho da janela do navegador
                Dimension tamanho = new Dimension(1024, 768);
                navegador.manage().window().setSize(tamanho);

                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div")).click();
                Thread.sleep(250);

                //SELECIONAR ENTIDADE
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

                // Gerar dados dinâmicos para a pessoa
                Random random = new Random();
                String[] justificativas = {"309", "310", "311", "312", "313", "314", "5527"};
                String justificativa = justificativas[random.nextInt(justificativas.length)];

                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[6]/div")).click();

                // CLICAR EM "NOVO"
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[3]")).click();

                new Actions(navegador).moveByOffset(0, 0).click().sendKeys("TESTE 02 ETAPA").perform();// ETAPA
                new Actions(navegador).moveByOffset(0, 35).click().sendKeys("Teste Conjuge Nº01").sendKeys(Keys.TAB).perform();// PESSOA
                new Actions(navegador).sendKeys("11112020").sendKeys(Keys.TAB).sendKeys("1611").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// PREVISÃO
                new Actions(navegador).sendKeys("11112020").sendKeys(Keys.TAB).sendKeys("1811").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// CHEGADA
                new Actions(navegador).sendKeys(justificativa).sendKeys(Keys.ENTER).perform();// JUSTIFICATIVA

                // SALVAR CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[4]")).click();
                Thread.sleep(500);
                // Capturar screenshot para análise visual
                String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Transporte e Controle de Chegada//Controle de Chegada//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());
                Thread.sleep(1000);

                //FECHAR CADASTRO
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[8]")).click();

                //ATUALIZAR CADASTRO
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();


                //SELECIONAR CADASTRO
                Thread.sleep(200);
                new Actions(navegador).moveByOffset(0, 110).doubleClick().perform();



                                                            //"INICIO DE CICLO DE CONFERENCIA DE DADOS"\\


                //CLICAR EM ALTERAR
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[5]")).click();
                Thread.sleep(250);

                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();

                // ETAPA
                new Actions(navegador).moveByOffset(0, -145).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEtapaCC = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Etapa Função está vazio
                if (valorCampoEtapaCC == null || valorCampoEtapaCC.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                    System.out.println("ERRO: O campo Etapa está vazio.");}
                else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapaCC);}

                // PESSOA
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPessoaCC = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo PessoaCC está vazio
                if (valorCampoPessoaCC == null || valorCampoPessoaCC.isEmpty()) {mensagensErro.append("ERRO: O campo PessoaCC está vazio.");
                    System.out.println("ERRO: O campo PessoaCC está vazio.");}
                else {System.out.println("O campo PessoaCC foi preenchido com: " + valorCampoPessoaCC);}

                // PREVISÃO
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPrevisãoCC = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo PrevisãoCC está vazio
                if (valorCampoPrevisãoCC == null || valorCampoPrevisãoCC.isEmpty()) {mensagensErro.append("ERRO: O campo PrevisãoCC  está vazio.");
                    System.out.println("ERRO: O campo PrevisãoCC  está vazio.");}
                else {System.out.println("O campo PrevisãoCC  foi preenchido com: " + valorCampoPrevisãoCC);}

                // CHEGADA
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoChegadaCC = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo ChegadaCC está vazio
                if (valorCampoChegadaCC == null || valorCampoChegadaCC.isEmpty()) {mensagensErro.append("ERRO: O campo ChegadaCC está vazio.");
                    System.out.println("ERRO: O campo ChegadaCC está vazio.");}
                else {System.out.println("O campo ChegadaCC foi preenchido com: " + valorCampoChegadaCC);}

                // JUSTIFICATIVA
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoJustificativaCC = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo JustificativaCC está vazio
                if (valorCampoJustificativaCC == null || valorCampoJustificativaCC.isEmpty()) {mensagensErro.append("ERRO: O campo JustificativaCC está vazio.");
                    System.out.println("ERRO: O campo JustificativaCC está vazio.");}
                else {System.out.println("O campo JustificativaCC foi preenchido com: " + valorCampoJustificativaCC);}

                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                // Definir o caminho e nome do arquivo
                String caminhoPastaCC = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Transporte e Controle de Chegada//Controle de Chegada//erros log//erros";
                String caminhoArquivoCC = caminhoPastaCC + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPastaCC);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    FileWriter writer = new FileWriter(caminhoArquivoCC, true);
                    writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                    writer.close();

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivoCC);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}



                                                     // "INICIO DE CICLO DE ALTERAÇÃO DE DADOS" \\

                Thread.sleep(100);
                new Actions(navegador).moveByOffset(0, -120).doubleClick().click().sendKeys("TESTE 02 ETAPA").perform();// ETAPA
                new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys().perform();// PESSOA
                new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys("12122021").sendKeys(Keys.TAB).sendKeys("1010").perform();// PREVISÃO
                new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys("14122021").sendKeys(Keys.TAB).sendKeys("1111").perform();// CHEGADA
                new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(justificativa).sendKeys(Keys.ENTER).perform();// JUSTIFICATIVA

                // SALVAR CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[4]")).click();

                Thread.sleep(1000);
                // Capturar screenshot para análise visual
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Transporte e Controle de Chegada//Controle de Chegada//Cadastro alt//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());
                Thread.sleep(1000);

                //FECHAR CADASTRO
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[8]")).click();

                //ATUALIZAR CADASTRO
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();


                //SELECIONAR CADASTRO
                Thread.sleep(200);
                new Actions(navegador).moveByOffset(0, 40).doubleClick().perform();



                                                        // "INICIO DE CICLO DE CONFERENCIA DE DADOS ALTERADOS" \\

                //CLICAR EM ALTERAR
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[5]")).click();
                Thread.sleep(250);

                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                mensagensErro = new StringBuilder();

                // ETAPA
                new Actions(navegador).moveByOffset(0, -145).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEtapaCC2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Etapa Função está vazio
                if (valorCampoEtapaCC2 == null || valorCampoEtapaCC2.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                    System.out.println("ERRO: O campo Etapa está vazio.");}
                else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapaCC2);}

                // PESSOA
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPessoaCC2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo PessoaCC está vazio
                if (valorCampoPessoaCC2 == null || valorCampoPessoaCC2.isEmpty()) {mensagensErro.append("ERRO: O campo PessoaCC está vazio.");
                    System.out.println("ERRO: O campo PessoaCC está vazio.");}
                else {System.out.println("O campo PessoaCC foi preenchido com: " + valorCampoPessoaCC2);}

                // PREVISÃO
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPrevisãoCC2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo PrevisãoCC está vazio
                if (valorCampoPrevisãoCC2 == null || valorCampoPrevisãoCC2.isEmpty()) {mensagensErro.append("ERRO: O campo PrevisãoCC  está vazio.");
                    System.out.println("ERRO: O campo PrevisãoCC  está vazio.");}
                else {System.out.println("O campo PrevisãoCC  foi preenchido com: " + valorCampoPrevisãoCC2);}

                // CHEGADA
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoChegadaCC2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo ChegadaCC está vazio
                if (valorCampoChegadaCC2 == null || valorCampoChegadaCC2.isEmpty()) {mensagensErro.append("ERRO: O campo ChegadaCC está vazio.");
                    System.out.println("ERRO: O campo ChegadaCC está vazio.");}
                else {System.out.println("O campo ChegadaCC foi preenchido com: " + valorCampoChegadaCC2);}

                // JUSTIFICATIVA
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoJustificativaCC2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo JustificativaCC está vazio
                if (valorCampoJustificativaCC2 == null || valorCampoJustificativaCC2.isEmpty()) {mensagensErro.append("ERRO: O campo JustificativaCC está vazio.");
                    System.out.println("ERRO: O campo JustificativaCC está vazio.");}
                else {System.out.println("O campo JustificativaCC foi preenchido com: " + valorCampoJustificativaCC2);}

                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                // Definir o caminho e nome do arquivo
                String caminhoPastaCC2 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Transporte e Controle de Chegada//Controle de Chegada//erros log alt//erros";
                String caminhoArquivoCC2 = caminhoPastaCC2 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPastaCC2);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    FileWriter writer = new FileWriter(caminhoArquivoCC2, true);
                    writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                    writer.close();

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivoCC2);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}


                //EXCLUIR CADASTROS
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[6]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
                Thread.sleep(300);

                //FECHAR CADASTRO
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[8]")).click();
                Thread.sleep(300);

                //EXCLUIR DO TRANSPORTE
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[5]/div")).click();//CLICAR EM TRANSPORTE
                Thread.sleep(300);
                new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO CADASTRO
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[5]")).click();//CLICAR EM EXCLUIR
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();//CONCLUIR EXCLUSÃO
                Thread.sleep(300);

                Thread.sleep(500);
                // Fechar o navegador ao final de cada interação
                {navegador.quit();}
            }
            catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
}
