package br.com.seg.test.paroquia;

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
public class TestsParoquia {
    // Variável global para armazenar o nome gerado
    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {



        // Configurar o WebDriver
        WebDriverManager.chromedriver().setup();



        // “Loop” infinito para repetir o processo completo
        while (true) {// “Loop” infinito para o processo de cadastro e conferência

            // Criar nome aleatório para o cadastro
            Random random = new Random();
            String nomeParoquia = "TestParoquia" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomeParoquia.txt")) {
                writer.write(nomeParoquia);
            } catch (IOException e) {
                e.printStackTrace();
            }
            WebDriver navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            Dimension tamanho = new Dimension(1024, 768); // Largura: 1024px, Altura: 768px
            navegador.manage().window().setSize(tamanho);

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

                // Abrir SEG DESENVOLVIMENTO
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_paroquia");

                // Gerar dados dinâmicos
                String sigla = "TSTPSWD" + random.nextInt(100);
                String telefone = "619" + (10000000 + random.nextInt(89999999));
                String email = nomeParoquia.toLowerCase() + "tstpswd@gmail.com";
                String instagram = "tstpswd" + nomeParoquia.toLowerCase();
                String facebook = "tstpswd" + nomeParoquia.toLowerCase();

                // Iniciar cadastro
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[1]")).click();

                // Preencher os campos
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(-100, -80).click().sendKeys(nomeParoquia)
                        .sendKeys(Keys.TAB).perform();
                Thread.sleep(500);
                new Actions(navegador).sendKeys("Brasília").sendKeys(Keys.TAB).perform();
                Thread.sleep(500);
                new Actions(navegador).sendKeys(sigla).sendKeys(Keys.TAB).perform();
                Thread.sleep(500);
                new Actions(navegador).sendKeys("CENTRO").sendKeys(Keys.TAB).perform();
                Thread.sleep(500);
                new Actions(navegador).sendKeys("X").sendKeys(Keys.TAB).perform();
                Thread.sleep(500);
                new Actions(navegador).sendKeys("71828650").sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                        .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                Thread.sleep(1000);
                new Actions(navegador).sendKeys(telefone).sendKeys(Keys.TAB).perform();
                Thread.sleep(500);
                new Actions(navegador).sendKeys(telefone).sendKeys(Keys.TAB).perform();
                Thread.sleep(500);
                new Actions(navegador).sendKeys(telefone).sendKeys(Keys.TAB).perform();
                Thread.sleep(500);
                new Actions(navegador).sendKeys(email).sendKeys(Keys.TAB).perform();
                Thread.sleep(500);
                new Actions(navegador).sendKeys("www." + nomeParoquia.toLowerCase() + ".com.br")
                        .sendKeys(Keys.TAB).perform();
                Thread.sleep(500);
                new Actions(navegador).sendKeys(instagram).sendKeys(Keys.TAB).perform();
                Thread.sleep(500);
                new Actions(navegador).sendKeys(facebook).perform();

                // Salvar Cadastro
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[2]")).click();

                // Capturar screenshot para análise
                String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//" +
                        "Cadastro de Paróquias//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {// Finalizar navegador ao final de cada execução
                navegador.quit();
            }
            // Espera antes de iniciar o próximo ciclo
            Thread.sleep(2000); // Pausa de 2 segundos (ajuste conforme necessário)


            // Reabrir o navegador para conferência
            nomeParoquia = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomeParoquia.txt"))) {
                nomeParoquia = reader.readLine(); // Lê o nome salvo no arquivo
            } catch (IOException e) {
                e.printStackTrace();
            }


            navegador = new ChromeDriver();
            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            // Configurar o WebDriver
            WebDriverManager.chromedriver().setup();

            String nomeParoquia2;
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
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_paroquia");

                //Pesquisa de Cadastro
                Thread.sleep(1000);
                navegador.findElement(By.id("searchInput")).sendKeys(nomeParoquia + Keys.ENTER);

                // Selecionar Cadastro
                Thread.sleep(2000);
                new Actions(navegador).moveByOffset(0, 140).doubleClick().perform();

                // Selecionar "Alterar"
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[3]")).click();

                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();


                // Nome Paróquia
                new Actions(navegador).moveByOffset(-20, -225).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Paróquia está vazio
                if (valorCampoNomeParoquia == null || valorCampoNomeParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Nome Paróquia está vazio.\\n");
                    System.out.println("ERRO: O campo Nome Paróquia está vazio.");
                } else {
                    System.out.println("O campo Nome Paróquia foi preenchido com: " + valorCampoNomeParoquia);
                }


                // Arquidiocese
                new Actions(navegador).moveByOffset(0, 25).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(1000);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoArquidiocese = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Arquidiocese está vazio
                if (valorCampoArquidiocese == null || valorCampoArquidiocese.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Arquidiocese está vazio.\\n");
                    System.out.println("ERRO: O campo Arquidiocese está vazio.");
                } else {
                    System.out.println("O campo Arquidiocese foi preenchido com: " + valorCampoArquidiocese);
                }


                //Sigla
                new Actions(navegador).moveByOffset(0, 25).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSigla = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSigla == null || valorCampoSigla.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Sigla está vazio.\\n");
                    System.out.println("ERRO: O campo Sigla está vazio.");
                } else {
                    System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla);
                }


                //Vicariato Paroquia
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoVicariatoParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoVicariatoParoquia == null || valorCampoVicariatoParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Vicariato Paroquia está vazio.\\n");
                    System.out.println("ERRO: O campo Vicariato Paroquia está vazio.");
                } else {
                    System.out.println("O campo Vicariato Paroquia foi preenchido com: " + valorCampoVicariatoParoquia);
                }


                //Setor Paroquia
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSetorParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoSetorParoquia == null || valorCampoSetorParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Setor Paroquia está vazio.\\n");
                    System.out.println("ERRO: O campo Setor Paroquia Paroquia está vazio.");
                } else {
                    System.out.println("O campo Setor Paroquia foi preenchido com: " + valorCampoSetorParoquia);
                }


                //CEP
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoCEP = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoCEP == null || valorCampoCEP.isEmpty()) {
                    mensagensErro.append("ERRO: O campo CEP está vazio.\\n");
                    System.out.println("ERRO: O campo CEP Paroquia está vazio.");
                } else {
                    System.out.println("O campo CEP foi preenchido com: " + valorCampoCEP);
                }


                //Endereço
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEndereco = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoEndereco == null || valorCampoEndereco.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Endereço está vazio.\\n");
                    System.out.println("ERRO: O campo Endereço Paroquia está vazio.");
                } else {
                    System.out.println("O campo Endereço foi preenchido com: " + valorCampoEndereco);
                }


                //Bairro
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoBairro = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoBairro == null || valorCampoBairro.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Bairro está vazio.\\n");
                    System.out.println("ERRO: O campo Bairro Paroquia está vazio.");
                } else {
                    System.out.println("O campo Bairro foi preenchido com: " + valorCampoBairro);
                }


                //Cidade
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoCidade = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoCidade == null || valorCampoCidade.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Cidade está vazio.\\n");
                    System.out.println("ERRO: O campo Cidade Paroquia está vazio.");
                } else {
                    System.out.println("O campo Cidade foi preenchido com: " + valorCampoCidade);
                }


                //UF
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoUF = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoUF == null || valorCampoUF.isEmpty()) {
                    mensagensErro.append("ERRO: O campo UF está vazio.\\n");
                    System.out.println("ERRO: O campo UF Paroquia está vazio.");
                } else {
                    System.out.println("O campo UF foi preenchido com: " + valorCampoUF);
                }


                //Telefone
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 35).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTelefone = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoTelefone == null || valorCampoTelefone.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Telefone está vazio.\\n");
                    System.out.println("ERRO: O campo Telefone Paroquia está vazio.");
                } else {
                    System.out.println("O campo Telefone foi preenchido com: " + valorCampoTelefone);
                }


                //Telefone 2
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTelefone2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoTelefone2 == null || valorCampoTelefone2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Telefone 2 está vazio.\\n");
                    System.out.println("ERRO: O campo Telefone 2 Paroquia está vazio.");
                } else {
                    System.out.println("O campo Telefone 2 foi preenchido com: " + valorCampoTelefone2);
                }


                //Whatsapp
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoWhatsapp = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoWhatsapp == null || valorCampoWhatsapp.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Whatsapp está vazio.\\n");
                    System.out.println("ERRO: O campo Whatsapp Paroquia está vazio.");
                } else {
                    System.out.println("O campo Whatsapp foi preenchido com: " + valorCampoWhatsapp);
                }


                //E-mail
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEmail = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoEmail == null || valorCampoEmail.isEmpty()) {
                    mensagensErro.append("ERRO: O campo E-mail está vazio.\\n");
                    System.out.println("ERRO: O campo E-mail Paroquia está vazio.");
                } else {
                    System.out.println("O campo E-mail foi preenchido com: " + valorCampoEmail);
                }


                //Site
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSite = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoSite == null || valorCampoSite.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Site está vazio.\\n");
                    System.out.println("ERRO: O campo Site Paroquia está vazio.");
                } else {
                    System.out.println("O campo Site foi preenchido com: " + valorCampoSite);
                }

                // Instagram
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoInstagram = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoInstagram == null || valorCampoInstagram.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Instagram está vazio.\\n");
                    System.out.println("ERRO: O campo Instagram Paroquia está vazio.");
                } else {
                    System.out.println("O campo Instagram foi preenchido com: " + valorCampoInstagram);
                }


                // Facebook
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFacebook = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoFacebook == null || valorCampoFacebook.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Facebook está vazio.\\n");
                    System.out.println("ERRO: O campo Facebook Paroquia está vazio.");
                } else {
                    System.out.println("O campo Facebook foi preenchido com: " + valorCampoFacebook);
                }

                // Voltar ao topo da tela
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[3]")).click();


                // PASSO 1: Cadastro
                // Criar nome aleatório para alteração de cadastro
                nomeParoquia2 = "TestParoquia" + random.nextInt(1000);
                // Salvar o nome gerado em um arquivo
                try (FileWriter writer = new FileWriter("nomeParoquia2.txt")) {
                    writer.write(nomeParoquia2);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // GERAÇÃO DE DADOS DINÂMICOS
                String sigla2 = "TSTPSWD" + random.nextInt(1000);
                String telefone2 = "619" + (10000000 + random.nextInt(89999999));
                String email2 = nomeParoquia.toLowerCase() + "tstpswd@gmail.com";
                String instagram2 = "tstpswd" + nomeParoquia.toLowerCase();
                String facebook2 = "tstpswd" + nomeParoquia.toLowerCase();


                // INICIO DE CICLO DE ALTERAÇÃO
                // NOME
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, -480).doubleClick().click().sendKeys(nomeParoquia2).perform();

                // ARQUIDIOCESE
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(Keys.BACK_SPACE)
                        .sendKeys("BRASÍLIA").perform();
                // SIGLA
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(Keys.BACK_SPACE)
                        .sendKeys(sigla2).perform();
                // VICARIATO PARÓQUIA
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(Keys.BACK_SPACE)
                        .sendKeys("CENTRO").perform();

                // SETOR PARÓQUIA
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys("I")
                        .sendKeys(Keys.TAB).perform();
                // CEP
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 25).doubleClick().click().sendKeys(Keys.BACK_SPACE)
                        .sendKeys("70050-000").sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                        .sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                // TELEFONE
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).sendKeys(Keys.BACK_SPACE)
                        .sendKeys(telefone2).sendKeys(Keys.TAB).perform();

                // TELEFONE 2
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).sendKeys(Keys.BACK_SPACE)
                        .sendKeys(telefone2).sendKeys(Keys.TAB).perform();

                // TELEFONE 2
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).sendKeys(Keys.BACK_SPACE)
                        .sendKeys(telefone2).sendKeys(Keys.TAB).perform();

                // WHATSAPP
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 30).sendKeys(Keys.BACK_SPACE)
                        .sendKeys(telefone2).sendKeys(Keys.TAB).perform();

                // EMAIL
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 35).sendKeys(Keys.BACK_SPACE)
                        .sendKeys(email2).sendKeys(Keys.TAB).perform();

                //SITE
                new Actions(navegador).sendKeys("www." + nomeParoquia2.toLowerCase() + ".com.br")
                        .sendKeys(Keys.TAB).perform();

                //INSTAGRAM
                Thread.sleep(500);
                new Actions(navegador).sendKeys(instagram2).sendKeys(Keys.TAB).perform();

                //FACEBOOK
                Thread.sleep(500);
                new Actions(navegador).sendKeys(facebook2).perform();

                // Salvar Cadastro
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[2]")).click();

                // Capturar screenshot para análise
                String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//" +
                        "Cadastro de Paróquias//Alteração//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {// Finalizar navegador ao final de cada execução
                navegador.quit();
            }


            // Reabrir o navegador para conferência
            nomeParoquia2 = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomeParoquia2.txt"))) {
                nomeParoquia2 = reader.readLine(); // Lê o nome salvo no arquivo
            } catch (IOException e) {
                e.printStackTrace();
            }


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
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_paroquia");

                //Pesquisa de Cadastro
                Thread.sleep(1000);
                navegador.findElement(By.id("searchInput")).sendKeys(nomeParoquia2 + Keys.ENTER);

                // Selecionar Cadastro
                Thread.sleep(2000);
                new Actions(navegador).moveByOffset(0, 140).doubleClick().perform();

                // Selecionar "Alterar"
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[3]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();


                // Nome Paróquia
                new Actions(navegador).moveByOffset(-20, -225).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(1000);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Paróquia está vazio
                if (valorCampoNomeParoquia == null || valorCampoNomeParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Nome Paróquia está vazio.\\n");
                    System.out.println("ERRO: O campo Nome Paróquia está vazio.");
                } else {
                    System.out.println("O campo Nome Paróquia foi preenchido com: " + valorCampoNomeParoquia);
                }


                // Arquidiocese
                new Actions(navegador).moveByOffset(0, 25).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(1000);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoArquidiocese = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Arquidiocese está vazio
                if (valorCampoArquidiocese == null || valorCampoArquidiocese.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Arquidiocese está vazio.\\n");
                    System.out.println("ERRO: O campo Arquidiocese está vazio.");
                } else {
                    System.out.println("O campo Arquidiocese foi preenchido com: " + valorCampoArquidiocese);
                }


                //Sigla
                new Actions(navegador).moveByOffset(0, 25).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSigla = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSigla == null || valorCampoSigla.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Sigla está vazio.\\n");
                    System.out.println("ERRO: O campo Sigla está vazio.");
                } else {
                    System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla);
                }


                //Vicariato Paroquia
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoVicariatoParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoVicariatoParoquia == null || valorCampoVicariatoParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Vicariato Paroquia está vazio.\\n");
                    System.out.println("ERRO: O campo Vicariato Paroquia está vazio.");
                } else {
                    System.out.println("O campo Vicariato Paroquia foi preenchido com: " + valorCampoVicariatoParoquia);
                }


                //Setor Paroquia
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSetorParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoSetorParoquia == null || valorCampoSetorParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Setor Paroquia está vazio.\\n");
                    System.out.println("ERRO: O campo Setor Paroquia Paroquia está vazio.");
                } else {
                    System.out.println("O campo Setor Paroquia foi preenchido com: " + valorCampoSetorParoquia);
                }


                //CEP
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoCEP = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoCEP == null || valorCampoCEP.isEmpty()) {
                    mensagensErro.append("ERRO: O campo CEP está vazio.\\n");
                    System.out.println("ERRO: O campo CEP Paroquia está vazio.");
                } else {
                    System.out.println("O campo CEP foi preenchido com: " + valorCampoCEP);
                }


                //Endereço
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEndereco = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoEndereco == null || valorCampoEndereco.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Endereço está vazio.\\n");
                    System.out.println("ERRO: O campo Endereço Paroquia está vazio.");
                } else {
                    System.out.println("O campo Endereço foi preenchido com: " + valorCampoEndereco);
                }


                //Bairro
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoBairro = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoBairro == null || valorCampoBairro.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Bairro está vazio.\\n");
                    System.out.println("ERRO: O campo Bairro Paroquia está vazio.");
                } else {
                    System.out.println("O campo Bairro foi preenchido com: " + valorCampoBairro);
                }


                //Cidade
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoCidade = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoCidade == null || valorCampoCidade.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Cidade está vazio.\\n");
                    System.out.println("ERRO: O campo Cidade Paroquia está vazio.");
                } else {
                    System.out.println("O campo Cidade foi preenchido com: " + valorCampoCidade);
                }


                //UF
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoUF = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoUF == null || valorCampoUF.isEmpty()) {
                    mensagensErro.append("ERRO: O campo UF está vazio.\\n");
                    System.out.println("ERRO: O campo UF Paroquia está vazio.");
                } else {
                    System.out.println("O campo UF foi preenchido com: " + valorCampoUF);
                }


                //Telefone
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 35).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTelefone = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoTelefone == null || valorCampoTelefone.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Telefone está vazio.\\n");
                    System.out.println("ERRO: O campo Telefone Paroquia está vazio.");
                } else {
                    System.out.println("O campo Telefone foi preenchido com: " + valorCampoTelefone);
                }


                //Telefone 2
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTelefone2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoTelefone2 == null || valorCampoTelefone2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Telefone 2 está vazio.\\n");
                    System.out.println("ERRO: O campo Telefone 2 Paroquia está vazio.");
                } else {
                    System.out.println("O campo Telefone 2 foi preenchido com: " + valorCampoTelefone2);
                }


                //Whatsapp
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoWhatsapp = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoWhatsapp == null || valorCampoWhatsapp.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Whatsapp está vazio.\\n");
                    System.out.println("ERRO: O campo Whatsapp Paroquia está vazio.");
                } else {
                    System.out.println("O campo Whatsapp foi preenchido com: " + valorCampoWhatsapp);
                }


                //E-mail
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEmail = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoEmail == null || valorCampoEmail.isEmpty()) {
                    mensagensErro.append("ERRO: O campo E-mail está vazio.\\n");
                    System.out.println("ERRO: O campo E-mail Paroquia está vazio.");
                } else {
                    System.out.println("O campo E-mail foi preenchido com: " + valorCampoEmail);
                }


                //Site
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSite = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoSite == null || valorCampoSite.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Site está vazio.\\n");
                    System.out.println("ERRO: O campo Site Paroquia está vazio.");
                } else {
                    System.out.println("O campo Site foi preenchido com: " + valorCampoSite);
                }

                // Instagram
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoInstagram = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoInstagram == null || valorCampoInstagram.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Instagram está vazio.\\n");
                    System.out.println("ERRO: O campo Instagram Paroquia está vazio.");
                } else {
                    System.out.println("O campo Instagram foi preenchido com: " + valorCampoInstagram);
                }


                // Facebook
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFacebook = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoFacebook == null || valorCampoFacebook.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Facebook está vazio.\\n");
                    System.out.println("ERRO: O campo Facebook Paroquia está vazio.");
                } else {
                    System.out.println("O campo Facebook foi preenchido com: " + valorCampoFacebook);
                }

                // EXCLUIR
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[4]")).click();
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
                Thread.sleep(500);

                // Definir o caminho e nome do arquivo
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta4 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Paróquias//erros log//erros";
                String caminhoArquivo4 = caminhoPasta4 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {
                    // Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta4);
                    if (!pasta.exists()) {
                        pasta.mkdirs();
                    }

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    FileWriter writer = new FileWriter(caminhoArquivo4, true);
                    writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                    writer.close();

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo4);
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }
                Thread.sleep(1100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
