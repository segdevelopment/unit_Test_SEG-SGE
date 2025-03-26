package br.com.test1.grupoação;

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
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

@DisplayName("Teste automatizado de cadastro número 1")
public class TestsGrupoAção {
    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {

        // Configurar o WebDriver
        WebDriverManager.chromedriver().setup();

        // Loop infinito para repetir o processo completo
        while (true) {
            // Criar nome aleatório para o cadastro
            Random random = new Random();
            String nomega = "TestGASWD" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomega.txt")) {
                writer.write(nomega);
            } catch (IOException e) {
                e.printStackTrace();
            }

            WebDriver navegador = new ChromeDriver();

            try {
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

                // Abrir SGE (Grupo Ação)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");

                // Gerar dados dinâmicos
                // Campos dinâmicos
                String[] Tipos = {"Associação Religiosa", "Ação Social", "Construção", "Encontro", "Evento", "Grupo de Oração", "Loteamento", "Movimento", "Pastoral"};
                String Tipo = Tipos[random.nextInt(Tipos.length)];
                String[] MotoristasEF = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
                String MotoristaEF = MotoristasEF[random.nextInt(MotoristasEF.length)];
                String[] PassageirosEF = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
                String PassageiroEF = PassageirosEF[random.nextInt(PassageirosEF.length)];
                String[] GrupoPessoas = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
                String GrupoPessoa = GrupoPessoas[random.nextInt(GrupoPessoas.length)];
                String[] Fichas = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
                String Ficha = Fichas[random.nextInt(Fichas.length)];
                String[] Comunicacoes = {"333", "334", "335", "336", "337", "338", "339", "340", "341", "342", "343", "5446", "5447", "6400"};
                String Comunicacao = Comunicacoes[random.nextInt(Comunicacoes.length)];
                String[] Paroquias = {"252", "253", "256", "260", "261", "263", "264", "265", "266", "267", "268", "269", "270", "271", "272", "273", "274", "275", "276", "277", "278", "279"};
                String Paroquia = Paroquias[random.nextInt(Paroquias.length)];
                String sigla = "TSTSWD" + random.nextInt(1000);
                String[] modelos = {"8"};
                String modelo = modelos[random.nextInt(modelos.length)];


                // "novo" cadastro.
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(480, 25).click().perform();

                // "CADASTRO"
                //Tipo
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(-400, 20).click().sendKeys(Tipo).perform();
                //Motorista Equipe Função
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 20).click().sendKeys(Ficha).perform();
                //Motorista Equipe
                //Thread.sleep(1000);
                //new Actions(navegador).moveByOffset(0, 30).click().sendKeys(MotoristaE).perform();
                //PASSAGEIRO EQUIPE FUNÇÃO
                new Actions(navegador).moveByOffset(0, 55).click().sendKeys(PassageiroEF).perform();
                Thread.sleep(800);
                //GRUPO PESSOA
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(GrupoPessoa).perform();
                //FICHA
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(Ficha).perform();
                //COMUNICAÇÃO
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(-20, 30).click().sendKeys(Comunicacao).perform();
                //PARÓQUIA
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 25).click().sendKeys(Paroquia).perform();
                //NOME
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(nomega).perform();
                //SIGLA
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(sigla).perform();
                //Rolar Página"X"
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 15).click().sendKeys(Keys.TAB).perform();
                //Setor Etapa
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 25).sendKeys("X").sendKeys(Keys.TAB).perform();
                //Agrupar Casal
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, -100).click().perform();
                //GRUPO AÇÃO MODELO
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(modelos).sendKeys(Keys.TAB).perform();
                //Agrupar Casal
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // "Salvar Cadastro"
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(370, -400).click().perform();
                Thread.sleep(800);

                // Capturar screenshot para análise visual.
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//" + "Cadastro de Grupo Ação//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                try {
                    // Espera antes de iniciar o próximo ciclo
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // Finalizar navegador ao final de cada execução
                if (navegador != null) {
                    navegador.quit();
                }


                // "REABRIR NAVEGADOR PARA CADASTRAR ACESSO" \\
                navegador = new ChromeDriver();

                nomega = "";
                try (BufferedReader reader = new BufferedReader(new FileReader("nomega.txt"))) {
                    nomega = reader.readLine(); // Lê o nome salvo no arquivo
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Configurar o WebDriver
                WebDriverManager.chromedriver().setup();

                try {
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
                    navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");

                    // Campos dinâmicos
                    String[] VicariatosParoquia = {"CENTRO", "LAGO SUL", "LESTE", "NORTE", "SUL"};
                    String VicariatoParoquia = VicariatosParoquia[random.nextInt(VicariatosParoquia.length)];

                    // Pesquisa de Cadastro
                    Thread.sleep(1000);
                    navegador.findElement(By.className("input-buscar")).sendKeys(nomega + Keys.ENTER);

                    // GRUPO AÇÃO ACESSO
                    Thread.sleep(1500);
                    new Actions(navegador).moveByOffset(-40, -15).click().perform();
                    // NOVO
                    Thread.sleep(1000);
                    new Actions(navegador).moveByOffset(540, 30).click().perform();
                    // ARQUIDIOCESE
                    Thread.sleep(800);
                    new Actions(navegador).moveByOffset(-300, -45).click().sendKeys("BRASÍLIA").perform();
                    // VICARIATO PARÓQUIA
                    Thread.sleep(800);
                    new Actions(navegador).moveByOffset(0, 30).click().sendKeys(VicariatoParoquia).perform();
                    // SETOR PAROQUIA
                    Thread.sleep(800);
                    new Actions(navegador).moveByOffset(0, 30).click().sendKeys("I").perform();
                    // SALVAR CADASTRO
                    Thread.sleep(800);
                    navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]")).click();
                    Thread.sleep(800);
                    navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]")).click();
                    Thread.sleep(800);

                    // Capturar screenshot para análise visual
                    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                    File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                    File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//" + "Cadastro de Grupo Ação//Acesso//resultado_teste_" + timestamp + ".png");
                    FileHandler.copy(screenshotFile, destinoFile);
                    System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                } finally {
                    try {
                        // Espera antes de iniciar o próximo ciclo
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    // Finalizar navegador ao final de cada execução
                    if (navegador != null) {
                        navegador.quit();
                    }
                }
            }


            // "REABRIR NAVEGADOR EM MODELO" \\
            navegador = new ChromeDriver();


            // CONFIGURAR WEBDRIVER
            WebDriverManager.chromedriver().setup();

            try {
                // ABRIR O SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // LOGIN
                navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                        .sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                // ESPERA PARA VISUALIZAÇÃO DO CAMPO
                WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                WebElement campoDinamico = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("home.login.entidade")));
                campoDinamico.sendKeys("SEG");
                navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // ABRIR SEG (GRUPO AÇÃO)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");


                // Campos dinâmicos
                String nomemodelo = "GATeste" + random.nextInt(1000);
                String ID = "" + random.nextInt(100);

                // GRUPO AÇÃO MODELO
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(50, -15).click().perform();

                // NOVO
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(450, 30).click().perform();


                // NOME DO MODELO
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(-320, -80).click().sendKeys(nomemodelo).perform();
                // MODELO CRONOGRAMA
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // MODELO EQUIPE FUNÇÃO
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // ID
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(ID).perform();
                // PESSOA NÚCLEO RELATÓRIO
                Thread.sleep(800);
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // SALVAR CADASTRO
                Thread.sleep(800);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]" + "/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]")).click();
                Thread.sleep(800);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]" + "/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]")).click();
                Thread.sleep(800);

                // Capturar screenshot para análise visual
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
               File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado " + "Testes//Cadastro de Grupo Ação//Modelo//resultado_teste_" + timestamp + ".png");
               FileHandler.copy(screenshotFile, destinoFile);
               System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                try {
                    // Espera antes de iniciar o próximo ciclo
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }


                // Finalizar navegador ao final de cada execução
                if (navegador != null) {
                    navegador.quit();
                }


                // "REABRIR NAVEGADOR EM TEMA" \\
                navegador = new ChromeDriver();


                // CONFIGURAR WEBDRIVER
                WebDriverManager.chromedriver().setup();

                try {
                    // ABRIR O SEG
                    navegador.get("https://app.seg.inf.br/novo/");

                    // LOGIN
                    navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                            .sendKeys("JOAO.VICTOR");
                    navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                    navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                    // ESPERA PARA VISUALIZAÇÃO DO CAMPO
                    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                    WebElement campoDinamico = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home.login.entidade")));
                    campoDinamico.sendKeys("SEG");
                    navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                    new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                    // ABRIR SEG (GRUPO AÇÃO)
                    navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");

                    // Campos dinâmicos
                    String ncirculo = "" + random.nextInt(10);
                    String tema = "TemaCículoTest" + random.nextInt(100);
                    String descricao = "Teste de descrição para tema " + random.nextInt(100);
                    String[] modelosga = {"8", "11", "12", "13", "14", "16", "17", "18", "19"};
                    String modeloga = modelosga[random.nextInt(modelosga.length)];

                    // GRUPO AÇÃO TEMA
                    Thread.sleep(1000);
                    new Actions(navegador).moveByOffset(150, -15).click().perform();

                    // NOVO
                    new Actions(navegador).moveByOffset(350, 30).click().perform();

                    // MODELO GRUPO AÇÃO
                    Thread.sleep(800);
                    new Actions(navegador).moveByOffset(-380, -45).click().sendKeys(modeloga).perform();
                    // Nº DO CÍRCULO
                    Thread.sleep(800);
                    new Actions(navegador).moveByOffset(0, 30).click().sendKeys(ncirculo).perform();
                    // TEMA
                    Thread.sleep(800);
                    new Actions(navegador).moveByOffset(0, 30).click().sendKeys(tema).perform();
                    // DESCRIÇÃO
                   Thread.sleep(800);
                    new Actions(navegador).moveByOffset(0, 30).click().sendKeys(descricao).perform();
                    // SALVAR CADASTRO
                    Thread.sleep(800);
                    navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
                    Thread.sleep(800);
                    navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
                    Thread.sleep(800);

                    // Capturar screenshot para análise visual
                    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                    File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                    File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Tema//resultado_teste_" + timestamp + ".png");
                    FileHandler.copy(screenshotFile, destinoFile);
                    System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                } finally {
                    try {
                        // Espera antes de iniciar o próximo ciclo
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    // Finalizar navegador ao final de cada execução
                    if (navegador != null) {
                        navegador.quit();
                    }
                }
                // "REABRIR NAVEGADOR EM MODELO" \\
                navegador = new ChromeDriver();


                // CONFIGURAR WEBDRIVER
                WebDriverManager.chromedriver().setup();

                try {
                    // ABRIR O SEG
                    navegador.get("https://app.seg.inf.br/novo/");

                    // LOGIN
                    navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                            .sendKeys("JOAO.VICTOR");
                    navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                    navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                    // ESPERA PARA VISUALIZAÇÃO DO CAMPO
                    WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                    WebElement campoDinamico = wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.id("home.login.entidade")));
                    campoDinamico.sendKeys("SEG");
                   navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                    new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                    // ABRIR SEG (GRUPO AÇÃO)
                    navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");


                    // Campos dinâmicos
                   String[] nscirculo = {"18", "19"};
                    String ncirculo = nscirculo[random.nextInt(nscirculo.length)];
                    String sigla = "PergSiglaTest" + random.nextInt(100);
                    String npergunta = "" + random.nextInt(10);
                    String[] modelosga = {"18"};
                    String modeloga = modelosga[random.nextInt(modelosga.length)];
                    String pergunta = "Teste de pergunta" + random.nextInt(1000);


                    // GRUPO AÇÃO PERGUNTA
                    Thread.sleep(1000);
                    new Actions(navegador).moveByOffset(300, -15).click().perform();
                    // NOVO
                    new Actions(navegador).moveByOffset(200, 30).click().perform();

                    // MODELO GRUPO AÇÃO
                    Thread.sleep(500);
                    new Actions(navegador).moveByOffset(-380, -45).click().sendKeys(modeloga).perform();
                    // Nº DO CÍRCULO
                    Thread.sleep(500);
                   new Actions(navegador).moveByOffset(0, 30).click().sendKeys(ncirculo).perform();
                    // SIGLA
                    Thread.sleep(1000);
                    new Actions(navegador).moveByOffset(0, 90).click().sendKeys(sigla).perform();
                    // Nº DA PERGUNTA
                    Thread.sleep(500);
                    new Actions(navegador).moveByOffset(0, 30).click().sendKeys(npergunta).perform();
                    // PERGUNTA
                   Thread.sleep(500);
                    new Actions(navegador).moveByOffset(0, 50).click().sendKeys(pergunta).perform();
                    // SALVAR CADASTRO
                    navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
                  Thread.sleep(500);
                   navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();


                    // Capturar screenshot para análise visual
                    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                   File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                    File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Pergunta//resultado_teste_" + timestamp + ".png");
                    FileHandler.copy(screenshotFile, destinoFile);
                    System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

                } catch (Exception e) {
                    System.out.println("Erro: " + e.getMessage());
                } finally {
                    try {
                        // Espera antes de iniciar o próximo ciclo
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    // Finalizar navegador ao final de cada execução
                    if (navegador != null) {
                        navegador.quit();
                    }

                }
            }
        }
    }
}