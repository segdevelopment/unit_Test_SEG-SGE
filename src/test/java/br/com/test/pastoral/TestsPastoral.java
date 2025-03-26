package br.com.test.pastoral;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

@DisplayName("Teste automatizado de cadastro número 1")
public class TestsPastoral {

    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {

        // Configurar o WebDriver
        WebDriverManager.chromedriver().setup();

        // “Loop” infinito para repetir o processo completo
        while (true) {
            // Criar nome aleatório para o cadastro
            Random random = new Random();
            String nomePastoral = "TestPastoralSWD" + random.nextInt(1000);

            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomePastoral.txt")) {writer.write(nomePastoral);}
            catch (IOException e) {e.printStackTrace();}
            WebDriver navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            Dimension tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            try {
                // ABRIR SEG
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


                // ABRIR PÁGINA DE CADASTRO DE PASTORAL
                navegador.get("https://app.seg.inf.br/novo/user/sge_pastoral_base");


                // GERAÇÃO DE DADOS DINÂMICOS
                String sigla = "TSTPSWD" + random.nextInt(1000);
                String objetivo = "Objetivo Teste de Pastoral" + random.nextInt(1000);
                String formaatuacao = nomePastoral.toLowerCase() + random.nextInt(1000);
                String composicao = "Teste de Pastoral" + random.nextInt(1000);
                String[] tipos = {"Movimento", "Outros", "Palestra", "Pastoral", "Serviço"};
                String tipo = tipos[random.nextInt(tipos.length)];


                // INICIO DE CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[1]")).click();
                // PREENCHER CAMPOS
                Thread.sleep(200);
                new Actions(navegador).moveByOffset(-70, -40).click().sendKeys(nomePastoral).sendKeys(Keys.TAB).perform();//PASTORAL
                Thread.sleep(50);
                new Actions(navegador).sendKeys(sigla).sendKeys(Keys.TAB).perform();//SIGLA
                Thread.sleep(50);
                new Actions(navegador).sendKeys(objetivo).sendKeys(Keys.TAB).perform();//OBJETIVO
                Thread.sleep(50);
                new Actions(navegador).sendKeys(formaatuacao).sendKeys(Keys.TAB).perform();//FORMA DE ATUAÇÃO
                Thread.sleep(50);
                new Actions(navegador).sendKeys(composicao).sendKeys(Keys.TAB).perform();//COMPOSIÇÃO
                Thread.sleep(50);
                new Actions(navegador).sendKeys(tipo).sendKeys(Keys.ENTER).perform();//TIPO
                Thread.sleep(50);

                // SALVAR CADASTRO
                Thread.sleep(50);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[2]")).click();
                Thread.sleep(800);
                // TIRA UMA CAPTURA DE TELA PARA ANÁLISE VISUAL
                String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

                // CAMINHO PARA SALVAR A CAPTURA DE TELA
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pastorais//Cadastro//resultado_teste_" + timestamp + ".png");

                // SALVAR A CAPTURA DE TELA
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {System.out.println("Erro: " + e.getMessage());}
            finally {
                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(1000);
                // Finalizar navegador ao final de cada execução
                {navegador.quit();}
            }

            // ABRIR CONFERENCIA
            nomePastoral = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomePastoral.txt")))
            {nomePastoral = reader.readLine();}
            catch (IOException e) {e.printStackTrace();}

            // Reabrir o navegador para conferência
            navegador = new ChromeDriver();
            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);


            // Configurar o WebDriver
            WebDriverManager.chromedriver().setup();

            try {
                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div")).click();
                Thread.sleep(500);

                //SELECIONAR ENTIDADE
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_pastoral_base");


                //ATUALIZAR PÁGINA DE CADASTRO
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();

                //Pesquisa de Cadastro
                Thread.sleep(500);
                navegador.findElement(By.id("searchInput")).sendKeys(nomePastoral + Keys.ENTER);


                // Selecionar Cadastro
                Thread.sleep(500);
                Actions actions1 = new Actions(navegador);
                new Actions(navegador).moveByOffset(-40, 105).doubleClick().perform();

                // Selecionar "Alterar"
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[3]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();


                // Nome Pastoral
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, -140).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomePastoral = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Pastoral está vazio
                if (valorCampoNomePastoral == null || valorCampoNomePastoral.isEmpty()) {mensagensErro.append("ERRO: O campo Nome Pastoral está vazio.");
                    System.out.println("ERRO: O campo Nome Pastoral está vazio.");}
                else {System.out.println("O campo Nome Pastoral foi preenchido com: " + valorCampoNomePastoral);}

                // Sigla
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSigla = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSigla == null || valorCampoSigla.isEmpty()) {mensagensErro.append("ERRO: O campo Sigla está vazio.");
                    System.out.println("ERRO: O campo Sigla está vazio.");}
                else {System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla);}

                // Objetivo
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 35).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoObjetivo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Objetivo está vazio
                if (valorCampoObjetivo == null || valorCampoObjetivo.isEmpty()) {mensagensErro.append("ERRO: O campo Objetivo está vazio.");
                    System.out.println("ERRO: O campo Objetivo está vazio.");}
                else {System.out.println("O campo Objetivo foi preenchido com: " + valorCampoObjetivo);}

                // Forma Atuação
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 100).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFormaAtuacao = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Forma Atuação está vazio
                if (valorCampoFormaAtuacao == null || valorCampoFormaAtuacao.isEmpty()) {mensagensErro.append("ERRO: O campo Forma Atuação está vazio.");
                    System.out.println("ERRO: O campo Forma Atuação está vazio.");}
                else {System.out.println("O campo Forma Atuação foi preenchido com: " + valorCampoFormaAtuacao);}

                // Composição
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 120).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoComposicao = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Composição está vazio
                if (valorCampoComposicao == null || valorCampoComposicao.isEmpty()) {mensagensErro.append("ERRO: O campo Composição está vazio.");
                    System.out.println("ERRO: O campo Composição está vazio.");}
                else {System.out.println("O campo Composição foi preenchido com: " + valorCampoComposicao);}

                // Tipo
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 80).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTipo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tipo está vazio
                if (valorCampoTipo == null || valorCampoTipo.isEmpty()) {mensagensErro.append("ERRO: O campo Tipo está vazio.");
                    System.out.println("ERRO: O campo Tipo está vazio.");}
                else {System.out.println("O campo Tipo foi preenchido com: " + valorCampoTipo);}

                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                // Definir o caminho e nome do arquivo
                String caminhoPasta5 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pastorais//erros log//erros";
                String caminhoArquivo5 = caminhoPasta5 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta5);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo5, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo5);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
            }
            catch (Exception e) {throw new RuntimeException(e);}



                                                    // "INICIO DE CICLO DE ALTERAÇÃO" \\

            // Criar nome aleatório para o cadastro
            String nomePastoral2 = "TestPastoral" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomePastoral2.txt"))
            {writer.write(nomePastoral2);}
            catch (IOException e) {e.printStackTrace();}

            // GERAÇÃO DE DADOS DINÂMICOS
            String sigla2 = "TSTPSWD" + random.nextInt(1000);
            String objetivo2 = "Objetivo Teste de Pastoral" + random.nextInt(1000);
            String formaatuacao2 = nomePastoral.toLowerCase() + random.nextInt(1000);
            String composicao2 = "Teste de Pastoral" + random.nextInt(1000);
            String[] tipos2 = {"Movimento", "Outros", "Palestra", "Pastoral", "Serviço"};
            String tipo2 = tipos2[random.nextInt(tipos2.length)];


            Thread.sleep(400);
            new Actions(navegador).moveByOffset(0, -360).doubleClick().click().sendKeys(nomePastoral2).perform();//NOME
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(sigla2).perform();//SIGLA
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(objetivo2).perform();//OBJETIVO
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 100).doubleClick().click().sendKeys(formaatuacao2).perform();//FORMA DE ATUAÇÃO
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 100).doubleClick().click().sendKeys(composicao2).perform();//COMPOSIÇÃO
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 100).doubleClick().click().sendKeys(tipo2).sendKeys(Keys.ENTER).perform();//TIPO
            Thread.sleep(50);

            // Salvar Cadastro
            Thread.sleep(50);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[2]")).click();
            Thread.sleep(800);
            // SCREENSHOT
            try {
                // TIRA UMA CAPTURA DE TELA PARA ANÁLISE VISUAL
                String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

                // CAMINHO PARA SALVAR A CAPTURA DE TELA
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pastorais//Cadastro alt//resultado_teste_ALT" + timestamp + ".png");

                // SALVAR A CAPTURA DE TELA
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            }
            catch (Exception e) {System.out.println("Erro: " + e.getMessage());}
            finally {
                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
                // Finalizar navegador ao final de cada execução
                {navegador.quit();}
            }


                                                                 // "ABRIR CONFERENCIA DE ALTERAÇÃO" \\


            nomePastoral2 = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomePastoral2.txt")))
            {nomePastoral2 = reader.readLine();}
            catch (IOException e) {e.printStackTrace();}

            // Configurar o WebDriver
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);


            try {
                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div")).click();
                Thread.sleep(500);

                //SELECIONAR ENTIDADE
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_pastoral_base");

                //ATUALIZAR PÁGINA DE CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();

                //Pesquisa de Cadastro
                Thread.sleep(500);
                navegador.findElement(By.id("searchInput")).sendKeys(nomePastoral2 + Keys.ENTER);

                // Selecionar Cadastro
                Thread.sleep(500);
                Actions actions1 = new Actions(navegador);
                new Actions(navegador).moveByOffset(50, 105).doubleClick().perform();

                // Selecionar "Alterar"
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[3]")).click();

                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();


                // Nome Pastoral
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(-90, -140).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomePastoralALT = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Pastoral está vazio
                if (valorCampoNomePastoralALT == null || valorCampoNomePastoralALT.isEmpty()) {mensagensErro.append("ERRO: O campo Nome Pastoral está vazio.");
                    System.out.println("ERRO: O campo Nome Pastoral está vazio.");}
                else {System.out.println("O campo Nome Pastoral foi preenchido com: " + valorCampoNomePastoralALT);}

                // Sigla
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSiglaALT = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSiglaALT == null || valorCampoSiglaALT.isEmpty()) {mensagensErro.append("ERRO: O campo Sigla está vazio.");
                    System.out.println("ERRO: O campo Sigla está vazio.");}
                else {System.out.println("O campo Sigla foi preenchido com: " + valorCampoSiglaALT);}

                // Objetivo
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 35).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoObjetivoALT = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Objetivo está vazio
                if (valorCampoObjetivoALT == null || valorCampoObjetivoALT.isEmpty()) {mensagensErro.append("ERRO: O campo Objetivo está vazio.");
                    System.out.println("ERRO: O campo Objetivo está vazio.");}
                else {System.out.println("O campo Objetivo foi preenchido com: " + valorCampoObjetivoALT);}

                // Forma Atuação
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 100).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFormaAtuacaoALT = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Forma Atuação está vazio
                if (valorCampoFormaAtuacaoALT == null || valorCampoFormaAtuacaoALT.isEmpty()) {mensagensErro.append("ERRO: O campo Forma Atuação está vazio.");
                    System.out.println("ERRO: O campo Forma Atuação está vazio.");}
                else {System.out.println("O campo Forma Atuação foi preenchido com: " + valorCampoFormaAtuacaoALT);}

                // Composição
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 120).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoComposicaoALT = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Composição está vazio
                if (valorCampoComposicaoALT == null || valorCampoComposicaoALT.isEmpty()) {mensagensErro.append("ERRO: O campo Composição está vazio.");
                    System.out.println("ERRO: O campo Composição está vazio.");}
                else {System.out.println("O campo Composição foi preenchido com: " + valorCampoComposicaoALT);}

                // Tipo
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 80).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTipoALT = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tipo está vazio
                if (valorCampoTipoALT == null || valorCampoTipoALT.isEmpty()) {mensagensErro.append("ERRO: O campo Tipo está vazio.");
                    System.out.println("ERRO: O campo Tipo está vazio.");}
                else {System.out.println("O campo Tipo foi preenchido com: " + valorCampoTipoALT);}

                //EXCLUIR CADASTRO
                Thread.sleep(100);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[4]")).click();
                Thread.sleep(150);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
                Thread.sleep(50);

                // Definir o caminho e nome do arquivo
                String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                String caminhoPasta6 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pastorais//erros log alt//erros";
                String caminhoArquivo6 = caminhoPasta6 + "erroslogAlt" + timestamp + ".txt"; // Nome fixo do arquivo

                try {
                    // Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta6);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo6, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo6);
                }
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(1000);
                // Finalizar navegador ao final de cada execução
                {navegador.quit();}
            }
            catch (InterruptedException e) {throw new RuntimeException(e);}
        }
    }
}


