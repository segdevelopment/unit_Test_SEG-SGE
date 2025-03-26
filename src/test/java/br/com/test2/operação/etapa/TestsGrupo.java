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

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;
import java.util.Random;

@SuppressWarnings("ALL")
@DisplayName("Teste automatizado de cadastro número 1")
public class TestsGrupo {
    @SuppressWarnings("BusyWait")
    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {

        // Loop infinito para repetir o processo completo
        while (true) {

            // Criar nome aleatório para o cadastro
            Random random = new Random();
            String nomeGrupo = "TestGrupoSWD" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomeGrupo.txt"))
            {writer.write(nomeGrupo);}
            catch (IOException e) {e.printStackTrace();}

            // Criar nome aleatório para o cadastro de alteração
            String nomeGrupoAlt = "TestGrupoSWD" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomeGrupoAlt.txt"))
            {writer.write(nomeGrupoAlt);}
            catch (IOException e) {e.printStackTrace();}

            WebDriverManager.chromedriver().setup();
            WebDriver navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            Dimension tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);


            WebDriverWait wait;
            WebElement campoDinamico;
            try {
                // Abrir o o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                // Espera para aparecer novo campo
                wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                campoDinamico = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("home.login.entidade")));
                campoDinamico.sendKeys("SEG");

                // Abrindo a janela de seleção de entidade
                navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text"))
                        .sendKeys(Keys.TAB);
                Actions actions = new Actions(navegador);

                // GERAÇÃO DE DADOS DINÂMICOS
                String slogan = "Slogan Teste de Grupo" + random.nextInt(1000);
                String[] Equipes = {"Azul", "Amarelo", "Verde", "Vermelho"};
                String equipe = Equipes[random.nextInt(Equipes.length)];

                // Entrar no SEG DESENVOLVIMENTO
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Grupo)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

                // Clicar em Grupo
                Thread.sleep(600);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[4]/div")).click();

                // Clicar no botão "Novo"
                Thread.sleep(600);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]")).click();
                new Actions(navegador).moveByOffset(0, -25).click().sendKeys("TESTE 01 ETAPA").perform();// Etapa
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys("azul").perform();// Equipe
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(nomeGrupo).perform();// Nome
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(slogan).perform();// Slogan

                // Salvar Cadastro
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[4]")).click();

                // Capturar screenshot para análise visual
                File destinoFile;
                File screenshotFile;
                String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//Cadastro//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
                // Finalizar navegador ao final de cada execução
                navegador.quit();



                                                              // ABRIR CONFERENCIA \\

                // Configurar o WebDriver
                WebDriverManager.chromedriver().setup();
                navegador = new ChromeDriver();

                // Definindo o tamanho da janela do navegador
                tamanho = new Dimension(1024, 768);
                navegador.manage().window().setSize(tamanho);


                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha
                navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                        .sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                // Espera até o campo de entidade estar visível
                wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                campoDinamico = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("home.login.entidade")));
                campoDinamico.sendKeys("SEG");
                navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

                //Clicar em GRUPO
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[4]/div")).click();
                //Clicar no cadastro do Grupo
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(-80, 245).doubleClick().perform();
                //CLICAR EM ALTERAR
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();

                //ETAPA
                new Actions(navegador).moveByOffset(40, -285).doubleClick().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEtapa = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Etapa está vazio
                if (valorCampoEtapa == null || valorCampoEtapa.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                    System.out.println("ERRO: O campo Etapa está vazio.");}
                else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapa);}

                //EQUIPE
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEquipe = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Equipe está vazio
                if (valorCampoEquipe == null || valorCampoEquipe.isEmpty()) {mensagensErro.append("ERRO: O campo Equipe está vazio.");
                    System.out.println("ERRO: O campo Equipe está vazio.");}
                else {System.out.println("O campo Equipe foi preenchido com: " + valorCampoEquipe);}

                //NOME
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNome = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Função está vazio
                if (valorCampoNome == null || valorCampoNome.isEmpty()) {mensagensErro.append("ERRO: O campo Nome está vazio.");
                    System.out.println("ERRO: O campo Nome está vazio.");}
                else {System.out.println("O campo Nome foi preenchido com: " + valorCampoNome);}

                //SLOGAN
                new Actions(navegador).sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSlogan = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Slogan está vazio
                if (valorCampoSlogan == null || valorCampoSlogan.isEmpty()) {mensagensErro.append("ERRO: O campo Slogan está vazio.");
                    System.out.println("ERRO: O campo Slogan está vazio.");}
                else {System.out.println("O campo Slogan foi preenchido com: " + valorCampoSlogan);}

                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                String caminhoPasta = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//Cadastro//erros log//erros";
                String caminhoArquivo = caminhoPasta + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {
                    // Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    FileWriter writer = new FileWriter(caminhoArquivo, true);
                    writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                    writer.close();

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}


                Thread.sleep(500);


                                                    // "INICIO DE CICLO DE ALTERAÇÃO" \\


                String slogan2 = "Slogan Teste de Grupo" + random.nextInt(1000);
                String[] Equipes2 = {"Azul", "Amarelo", "Verde", "Vermelho"};
                String equipe2 = Equipes2[random.nextInt(Equipes2.length)];

                new Actions(navegador).moveByOffset(0, 40).doubleClick().sendKeys("amarelo").sendKeys(Keys.TAB).perform();// Equipe
                new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys(nomeGrupoAlt).perform();// Nome
                new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(slogan2).perform();// Slogan

                //SALVAR CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[1]")).click();


                // Capturar screenshot para análise visual
                Thread.sleep(400);
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//Cadastro//Cadastro alt//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(1000); // Pausa de 1 segundos (ajuste conforme necessário)
                // Finalizar navegador ao final de cada execução
                if (navegador != null) {navegador.quit();}



                                                                // "ABRIR CONFERENCIA" \\

                // Configurar o WebDriver
                WebDriverManager.chromedriver().setup();
                navegador = new ChromeDriver();

                // Definindo o tamanho da janela do navegador
                tamanho = new Dimension(1024, 768);
                navegador.manage().window().setSize(tamanho);

                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                // Espera até o campo de entidade estar visível
                wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                campoDinamico = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("home.login.entidade")));
                campoDinamico.sendKeys("SEG");
                navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

                //Clicar em GRUPO
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[4]/div")).click();
                //Clicar no cadastro do Grupo
                Thread.sleep(400);
                new Actions(navegador).moveByOffset(-80, 245).doubleClick().perform();
                //CLICAR EM ALTERAR
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();

                //ETAPA
                new Actions(navegador).moveByOffset(40, -265).doubleClick().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEtapaAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Etapa está vazio
                if (valorCampoEtapaAlt == null || valorCampoEtapaAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                    System.out.println("ERRO: O campo Etapa está vazio.");}
                else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapaAlt);}

                //EQUIPE
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEquipeAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Equipe está vazio
                if (valorCampoEquipeAlt == null || valorCampoEquipeAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Equipe está vazio.");
                    System.out.println("ERRO: O campo Equipe está vazio.");}
                else {System.out.println("O campo Equipe foi preenchido com: " + valorCampoEquipeAlt);}

                //NOME
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Função está vazio
                if (valorCampoNomeAlt == null || valorCampoNomeAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Nome está vazio.");
                    System.out.println("ERRO: O campo Nome está vazio.");}
                else {System.out.println("O campo Nome foi preenchido com: " + valorCampoNomeAlt);}

                //SLOGAN
                new Actions(navegador).sendKeys(Keys.ENTER).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSloganAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Slogan está vazio
                if (valorCampoSloganAlt == null || valorCampoSloganAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Slogan está vazio.");
                    System.out.println("ERRO: O campo Slogan está vazio.");}
                else {System.out.println("O campo Slogan foi preenchido com: " + valorCampoSloganAlt);}


                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                String caminhoPasta2 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//Cadastro//erros log alt//erros";
                String caminhoArquivo2 = caminhoPasta2 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {
                    // Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta2);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    FileWriter writer = new FileWriter(caminhoArquivo2, true);
                    writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                    writer.close();

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo2);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

                // Finalizar navegador ao final de cada execução
                {navegador.quit();}
            } catch (InterruptedException e) {throw new RuntimeException(e);}



                                                                    ////////////
                                                                    //"PESSOA"//
                                                                    /////////////

            nomeGrupoAlt = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomeGrupoAlt.txt"))) {
                nomeGrupoAlt = reader.readLine();}
            catch (IOException e) {e.printStackTrace();}

            // Configurar o WebDriver
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            // Abrir o SEG
            navegador.get("https://app.seg.inf.br/novo/");

            // Login e senha
            navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
            navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
            navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

            // Espera até o campo de entidade estar visível
            wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
            campoDinamico = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home.login.entidade")));
            campoDinamico.sendKeys("SEG");
            navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
            new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

            // Abrir SGE (Cadastro de Pessoa)
            navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

            // Criar nome aleatório para o cadastro
            random = new Random();
            String nomeGPessoa = "TestGrupoSWD" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomeGPessoa.txt"))
            {writer.write(nomeGPessoa);}
            catch (IOException e) {e.printStackTrace();}

            // GERAÇÃO DE DADOS DINÂMICOS
            String slogan = "Slogan Teste de Grupo" + random.nextInt(1000);
            String[] Equipes = {"Azul", "Amarelo", "Verde", "Vermelho"};
            String equipe = Equipes[random.nextInt(Equipes.length)];

            //CLICAR EM GRUPO
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[4]/div")).click();

            //Clicar em PESSOA dentro de GRUPO
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/div[2]/div")).click();

            // "NOVO" CADASTRO
            Thread.sleep(200);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div/div[1]/div/div[2]/div[1]")).click();

            //GRUPO ETAPA

            new Actions(navegador).moveByOffset(0, 10).click().sendKeys(Keys.ENTER).perform();//FUNÇÃO EQUIPE
            new Actions(navegador).moveByOffset(0, 30).click().sendKeys("15255").sendKeys(Keys.ENTER).perform(); //PESSOA
            //SALVAR CADASTRO
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div[2]/div[2]")).click();


            // Capturar screenshot para análise visual
            Thread.sleep(500);
            String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//Pessoa//Cadastro//resultado_teste_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            //FECHAR CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div[2]/div[6]")).click();
            Thread.sleep(500);


            //ATUALIZAR PAGINA DE CADASTRO
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div/div[1]/div/div[2]/div[2]")).click();
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div/div[1]/div/div[2]/div[2]")).click();
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div/div[1]/div/div[2]/div[2]")).click();



                                                                // "INICIO DE CICLO DE CONFERENCIA" \\

            //Clicar no cadastro do Pessoa em Grupo
            Thread.sleep(200);
            new Actions(navegador).moveByOffset(0, 200).doubleClick().perform();

            //CLICAR EM ALTERAR
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div[2]/div[3]")).click();

            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            JavascriptExecutor js = (JavascriptExecutor) navegador;
            StringBuilder mensagensErro = new StringBuilder();

            //GRUPO ETAPA
            new Actions(navegador).moveByOffset(-50, -250).doubleClick().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoGrupoEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Etapa está vazio
            if (valorCampoGrupoEtapa == null || valorCampoGrupoEtapa.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Etapa está vazio.");
                System.out.println("ERRO: O campo Grupo Etapa está vazio.");}
            else {System.out.println("O campo Grupo Etapa foi preenchido com: " + valorCampoGrupoEtapa);}

            // FUNÇÃO EQUIPE
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoFuncaoEquipe = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Número do Função Equipe está vazio
            if (valorCampoFuncaoEquipe == null || valorCampoFuncaoEquipe.isEmpty()) {mensagensErro.append("ERRO: O campo Função Equipe está vazio.");
                System.out.println("ERRO: O campo Função Equipe está vazio.");}
            else {System.out.println("O campo Função Equipe foi preenchido com: " + valorCampoFuncaoEquipe);}

            // PESSOA
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPessoa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Pessoa Equipe está vazio
            if (valorCampoPessoa == null || valorCampoPessoa.isEmpty()) {mensagensErro.append("ERRO: O campo Pessoa está vazio.");
                System.out.println("ERRO: O campo Pessoa está vazio.");}
            else {System.out.println("O campo Pessoa foi preenchido com: " + valorCampoPessoa);}


            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta7 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//Pessoa//erros log//erro";
            String caminhoArquivo7 = caminhoPasta7 + "erroslog" + timestamp + ".txt";

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta7);
                if (!pasta.exists()) {pasta.mkdirs();}

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                FileWriter writer = new FileWriter(caminhoArquivo7, true);
                writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                writer.close();

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo7);}
            catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

            Thread.sleep(500);
            // Finalizar navegador ao final de cada execução
            if (navegador != null) {navegador.quit();}



                                                                ///////////////
                                                                //"PERGUNTAS"//
                                                                ///////////////

            try {
                // Configurar o WebDriver
                WebDriverManager.chromedriver().setup();
                navegador = new ChromeDriver();

                // Definindo o tamanho da janela do navegador
                tamanho = new Dimension(1024, 768);
                navegador.manage().window().setSize(tamanho);

                // Abrir o o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha para entrar na conta da SEG
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                // Espera para aparecer novo campo
                wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                campoDinamico = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("home.login.entidade")));
                campoDinamico.sendKeys("SEG");

                // Abrindo a janela de seleção de entidade
                navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text")).sendKeys(Keys.TAB);
                Actions actions = new Actions(navegador);


                // Entrar no SEG DESENVOLVIMENTO
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Grupo)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

                //Clicar em Grupo
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[4]/div")).click();

                // Clicar em Peguntas
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/div[3]/div")).click();

                // Clicar no botão "Novo"
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]")).click();

                new Actions(navegador).moveByOffset(0, 0).click().sendKeys("Teste de pergunta917").sendKeys(Keys.TAB).perform();//PERGUNTA
                new Actions(navegador).moveByOffset(0, 50).click().sendKeys("Teste de resposta para cadastro de pergunta com selenium webdriver").perform();// RESPOSTA

                //Salvar cadastro
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();

                // Capturar screenshot para análise visual
                Thread.sleep(400);
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//Perguntas//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());


                //Fechar cadastro
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[6]")).click();

                //Atualizar página de cadastro
                Thread.sleep(150);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(150);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(150);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[3]")).click();



                                                             // "CICLO DE CONFERENCIA DE CADASTRO" \\

                //Clicar no cadastro do Pessoa em Grupo
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 200).doubleClick().perform();

                //CLICAR EM ALTERAR
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();


                //GRUPO ETAPA
                new Actions(navegador).moveByOffset(-50, -300).doubleClick().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoGrupoEtapa2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Etapa está vazio
                if (valorCampoGrupoEtapa2 == null || valorCampoGrupoEtapa2.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Etapa está vazio.");
                    System.out.println("ERRO: O campo Grupo Etapa está vazio.");}
                else {System.out.println("O campo Grupo Etapa foi preenchido com: " + valorCampoGrupoEtapa2);}

                // PERGUNTA
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPergunta = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Pergunta Equipe está vazio
                if (valorCampoPergunta == null || valorCampoPergunta.isEmpty()) {mensagensErro.append("ERRO: O campo Pergunta está vazio.");
                    System.out.println("ERRO: O campo Pergunta está vazio.");}
                else {System.out.println("O campo Pergunta foi preenchido com: " + valorCampoPergunta);}

                // RESPOSTA
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoResposta = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Resposta Equipe está vazio
                if (valorCampoResposta == null || valorCampoResposta.isEmpty()) {mensagensErro.append("ERRO: O campo Resposta está vazio.");
                    System.out.println("ERRO: O campo Resposta está vazio.");}
                else {System.out.println("O campo Resposta foi preenchido com: " + valorCampoResposta);}

                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                // Definir o caminho e nome do arquivo
                String caminhoPasta2 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//Perguntas//erros log//erros";
                String caminhoArquivo2 = caminhoPasta2 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta2);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    FileWriter writer = new FileWriter(caminhoArquivo2, true);
                    writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                    writer.close();

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo2);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

                //FECHAR CADASTRO
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[6]")).click();
                Thread.sleep(700);



                                                                 // "EXCLUSÃO DE CADASTROS" \\

                //EXCLUIR PERGUNTA
                Thread.sleep(250);
                new Actions(navegador).moveByOffset(50, 300).click().perform();
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]")).click();
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
                Thread.sleep(250);

                //EXCLUIR PESSOA
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/div[2]/div")).click();
                Thread.sleep(250);
                new Actions(navegador).moveByOffset(0, 0).doubleClick().perform();
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div[2]/div[4]")).click();
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
                Thread.sleep(250);

                //EXCLUIR CADASTRO
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div")).click();
                Thread.sleep(250);
                new Actions(navegador).moveByOffset(-70, 0).doubleClick().perform();
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]")).click();
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
                Thread.sleep(250);

                Thread.sleep(1250);
                // Finalizar navegador ao final de cada execução
                if (navegador != null) {navegador.quit();}
            }
            catch (InterruptedException e) {throw new RuntimeException(e);}
        }

    }
}