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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        // Iniciar o loop
        while (true) {

            // Configurar o WebDriver
            WebDriverManager.chromedriver().setup();
            WebDriver navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            Dimension tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);


            try {
                // Abrir o sistema
                navegador.get("https://app.seg.inf.br/novo/");

                // Login no sistema
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                // Esperar campo de entidade aparecer e preencher
                WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                WebElement campoDinamico = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home.login.entidade")));
                campoDinamico.sendKeys("SEG");
                navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir a página de composição de equipes
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

                // GERAÇÃO DE DADOS DINÂMICOS
                Random random = new Random();
                String[] pessoas = {"15255", "15257", "15262", "15545"};
                String pessoa = pessoas[random.nextInt(pessoas.length)];
                String[] gruposacao = {"124", "125", "126", "134", "136", "140", "142"};
                String grupoacao = gruposacao[random.nextInt(gruposacao.length)];
                String[] funcoesequipe = {"908", "909", "910", "911"};
                String funcaoequipe = funcoesequipe[random.nextInt(funcoesequipe.length)];
                String[] etapas = {"551", "561", "562", "565"};
                String etapa = etapas[random.nextInt(etapas.length)];

                int numCliques2 = 10;
                Thread.sleep(500);
                for (int i = 0; i < numCliques2; i++) {
                    navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[6]")).click();
                    // Aguarde um pequeno intervalo entre os cliques
                    Thread.sleep(500);
                }

                // Clicar no botão "Novo"
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[2]")).click();

                Thread.sleep(50);
                new Actions(navegador).moveByOffset(-80, 100).click().sendKeys("EQUIPE FUNÇÃO TESTE 1").perform();// Modelo Equipe Função
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys("134").perform();// Grupo Ação
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(Keys.ENTER).perform();// Etapa
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 35).doubleClick().sendKeys("908").sendKeys(Keys.ENTER).perform();// Função Equipes
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys("15255").perform();// Pessoas
                Thread.sleep(50);

                // Salvar Cadastro
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[3]")).click();
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[3]")).click();
                Thread.sleep(500);

                // Capturar screenshot para análise visual
                String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Composição de Equipes//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
                // Finalizar navegador ao final de cada execução
                {navegador.quit();}

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



                                                                  // "ABRIR CONFERENCIA" \\

            // Reabrir o navegador para conferência
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
            WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
            WebElement campoDinamico = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.id("home.login.entidade")));
            campoDinamico.sendKeys("SEG");
            navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
            new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

            // Abrir SGE (Cadastro de Pessoa)
            navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

            //ATUALIZAR CADASTROS
            // Defina o número de cliques desejado
            int numCliques = 20;
            Thread.sleep(500);
            for (int i = 0; i < numCliques; i++) {
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[6]")).click();
                // Aguarde um pequeno intervalo entre os cliques
                Thread.sleep(500);
            }

            //BUSCAR CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/input")).sendKeys("joao victor");
            Thread.sleep(500);

            // Clicar no cadastro da Composição de Equipe
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, 140).doubleClick().perform();

            // Selecionar "Alterar"
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[4]")).click();

            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            JavascriptExecutor js = (JavascriptExecutor) navegador;
            StringBuilder mensagensErro = new StringBuilder();

            // Modelo Equipe Função
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, -25).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMEF = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Modelo Equipe Função está vazio
            if (valorCampoMEF == null || valorCampoMEF.isEmpty()) {mensagensErro.append("ERRO: O campo Modelo Equipe Função está vazio.");
                System.out.println("ERRO: O campo Modelo Equipe Função está vazio.");}
            else {System.out.println("O campo Modelo Equipe Função foi preenchido com: " + valorCampoMEF);}

            // Grupo Ação
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampogrupoacao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Ação está vazio
            if (valorCampogrupoacao == null || valorCampogrupoacao.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Ação está vazio.");
                System.out.println("ERRO: O campo Grupo Ação está vazio.");}
            else {System.out.println("O campo Grupo Ação foi preenchido com: " + valorCampogrupoacao);}

            //Etapa
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Etapa está vazio
            if (valorCampoEtapa == null || valorCampoEtapa.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                System.out.println("ERRO: O campo Etapa está vazio.");}
            else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapa);}

            //Funções Equipe
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoFuncoesEquipe = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Funções Equipe está vazio
            if (valorCampoFuncoesEquipe == null || valorCampoFuncoesEquipe.isEmpty()) {mensagensErro.append("ERRO: O campo Funções Equipe está vazio.");
                System.out.println("ERRO: O campo Funções Equipe Paroquia está vazio.");}
            else {System.out.println("O campo Funções Equipe foi preenchido com: " + valorCampoFuncoesEquipe);}

            //Pessoas
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPessoas = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Pessoas está vazio
            if (valorCampoPessoas == null || valorCampoPessoas.isEmpty()) {mensagensErro.append("ERRO: O campo Pessoas está vazio.");
                System.out.println("ERRO: O campo Pessoas Paroquia está vazio.");}
            else {System.out.println("O campo Pessoas foi preenchido com: " + valorCampoPessoas);}

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            // Definir o caminho e nome do arquivo
            String caminhoPasta15 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Composição de Equipes//erros log//erros";
            String caminhoArquivo15 = caminhoPasta15 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta15);
                if (!pasta.exists()) {pasta.mkdirs();}

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo15, true))) {
                    writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                    writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                }

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo15);}
            catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

            // Espera antes de iniciar o próximo ciclo
            Thread.sleep(500);



                                                  //"INICIO DE CICLO DE ALTERAÇÃO DE DADOS CADASTRADOS"\\


            //ALTERAÇÃO DOS DADOS
            Thread.sleep(300);
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys("146").perform();// Grupo Ação
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(Keys.ENTER).perform();// Etapa
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys("909").sendKeys(Keys.ENTER).perform();// Função Equipes
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys("15262").perform();// Pessoas
            Thread.sleep(50);

            // Salvar Cadastro
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[3]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[3]")).click();
            Thread.sleep(1500);

            // Capturar screenshot para análise visual
            timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Composição de Equipes//Cadastro alt//resultado_teste_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            //fechar cadastro
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[10]")).click();
            Thread.sleep(500);



                                                      //"INICIO DE CICLO DE CONFERÊNCIA DE DADOS ALTERADOS"\\

            //SELECIONAR CADASTRO
            // Defina o número de cliques desejado
            int numCliques2 = 20;
            Thread.sleep(500);
            for (int i = 0; i < numCliques2; i++) {
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[6]")).click();
                // Aguarde um pequeno intervalo entre os cliques
                Thread.sleep(500);
            }

            //BUSCAR CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/input")).clear();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/input")).sendKeys("Teste");
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[6]")).click();
            Thread.sleep(1000);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/input")).sendKeys(" n");
            Thread.sleep(500);

            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, -50).doubleClick().perform();

            //SELECIONAR O BOTÃO "ALTERAR"
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[4]")).click();
            Thread.sleep(300);


            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            js = (JavascriptExecutor) navegador;
            mensagensErro = new StringBuilder();

            // Modelo Equipe Função
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -60).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMEF2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Modelo Equipe Função está vazio
            if (valorCampoMEF2 == null || valorCampoMEF2.isEmpty()) {mensagensErro.append("ERRO: O campo Modelo Equipe Função está vazio.");
                System.out.println("ERRO: O campo Modelo Equipe Função está vazio.");}
            else {System.out.println("O campo Modelo Equipe Função foi preenchido com: " + valorCampoMEF2);}

            // Grupo Ação
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampogrupoacao2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Ação está vazio
            if (valorCampogrupoacao2 == null || valorCampogrupoacao2.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Ação está vazio.");
                System.out.println("ERRO: O campo Grupo Ação está vazio.");}
            else {System.out.println("O campo Grupo Ação foi preenchido com: " + valorCampogrupoacao2);}

            //Etapa
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoEtapa2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Etapa está vazio
            if (valorCampoEtapa2 == null || valorCampoEtapa2.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                System.out.println("ERRO: O campo Etapa está vazio.");}
            else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapa2);}

            //Funções Equipe
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoFuncoesEquipe2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Funções Equipe está vazio
            if (valorCampoFuncoesEquipe2 == null || valorCampoFuncoesEquipe2.isEmpty()) {mensagensErro.append("ERRO: O campo Funções Equipe está vazio.");
                System.out.println("ERRO: O campo Funções Equipe Paroquia está vazio.");}
            else {System.out.println("O campo Funções Equipe foi preenchido com: " + valorCampoFuncoesEquipe2);}

            //Pessoas
            Thread.sleep(50);
            new Actions(navegador).sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPessoas2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Pessoas está vazio
            if (valorCampoPessoas2 == null || valorCampoPessoas2.isEmpty()) {mensagensErro.append("ERRO: O campo Pessoas está vazio.");
                System.out.println("ERRO: O campo Pessoas Paroquia está vazio.");}
            else {System.out.println("O campo Pessoas foi preenchido com: " + valorCampoPessoas2);}


            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            // Definir o caminho e nome do arquivo
            String caminhoPasta16 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Composição de Equipes//erros log alt//erros";
            String caminhoArquivo16 = caminhoPasta16 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta16);
                if (!pasta.exists()) {pasta.mkdirs();}

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo16, true))) {
                    writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                    writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                }

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo16);}
            catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}


            //EXCLUIR CADASTRO
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[5]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();

            //FECHAR CADASTRO
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[10]")).click();

            //EXCLUSÃO DE CONJUGE
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 30).click().perform();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[5]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[5]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();

            //EXCLUSÃO DE CONJUGE 2
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 60).click().perform();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[5]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[5]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();

            //BUSCAR CADASTRO
            Thread.sleep(700);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/input")).clear();
            Thread.sleep(700);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/input")).sendKeys("Victoria");
            Thread.sleep(700);
            new Actions(navegador).moveByOffset(0, 0).click().perform();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[5]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[5]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[5]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[5]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();

            // Espera antes de iniciar o próximo ciclo
            Thread.sleep(2000);

            // Finalizar navegador ao final de cada execução
            {
                navegador.quit();
            }
        }
    }
}


