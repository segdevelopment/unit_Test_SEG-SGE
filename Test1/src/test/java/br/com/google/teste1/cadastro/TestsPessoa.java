package br.com.google.teste1.cadastro;

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
public class TestsPessoa {
        @SuppressWarnings("BusyWait")
        @Test
        @DisplayName("SEG")

        public void testDeCadastroNumero1() throws Throwable {


                // Loop infinito para repetir o processo completo
                String nomePessoa1;
                while (true) {

                        // Criar nome aleatório para o cadastro
                        Random random = new Random();
                        nomePessoa1 = "TestSeleniumWD" + random.nextInt(1000);
                        // Salvar o nome gerado em um arquivo
                        try (FileWriter writer = new FileWriter("nomePessoa1.txt")) {
                                writer.write(nomePessoa1);
                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                        // Driver
                        WebDriverManager.chromedriver().setup();
                        WebDriver navegador = new ChromeDriver();


                        // Abrir o o SEG
                        navegador.get("https://app.seg.inf.br/novo/");


                        // LOGIN
                        navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                                .sendKeys("JOAO.VICTOR");
                        navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                        navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                        // ESPERA POR CAMPO "ENTIDADE"
                        WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                        WebElement campoDinamico = wait.until(ExpectedConditions
                                .visibilityOfElementLocated(By.id("home.login.entidade")));
                        campoDinamico.sendKeys("SEG");

                        // ABERTURA DE JANELA "ENTIDADE'
                        navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                        navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text"))
                                .sendKeys(Keys.TAB);

                        Actions actions = new Actions(navegador);

                        // ENTRAR EM SEG DESENVOLVIMENTO
                        new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                        //ABRIR SGE (CADASTRO DE PESSOA).
                        navegador.get("https://app.seg.inf.br/novo/user/sge_base_pessoa");

                        // Tempo de espera
                        WebDriverWait wait1 = new WebDriverWait(navegador, Duration.ofSeconds(15));
                        WebElement elemento = wait.until(ExpectedConditions
                                .elementToBeClickable(By.className("avatar")));


                        // CRIAR CADASTRO
                        Thread.sleep(1000);
                        Actions actions1 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(-60, 30).click().perform();
                        Thread.sleep(1000);


                        // GERAÇÃO DE DADOS DINÂMICOS
                        String apelido = "TSTSWD" + random.nextInt(1000);
                        String cpf = "12345678" + random.nextInt(1000);
                        String[] profissoes = {"acrobata", "afretador", "cantor", "acabador de calçados", "adestrador de animais", "aromista", "antropólogo", "zootecnista", "vinagreiro", "vassoureiro"};
                        String profissao = profissoes[random.nextInt(profissoes.length)];
                        String[] generos = {"Masculino", "Feminino", "Outros"};
                        String genero = generos[random.nextInt(generos.length)];
                        String[] religioes = {"Católico", "Candomblecista", "Judeu", "Tambor de Mina", "Ateu"};
                        String religiao = religioes[random.nextInt(religioes.length)];
                        String celular = "619" + (10000000 + random.nextInt(89999999));
                        String email = "TestSWD" + random.nextInt(1000) + "@gmail.com";
                        String[] paroquias = {"PAROQUIA102", "PAROQUIA276", "PAROQUIA444", "PAROQUIA518"};
                        String paroquia = paroquias[random.nextInt(paroquias.length)];
                        String[] estadoscivil = {"solteiro", "união estável"};
                        String estadocivil = estadoscivil[random.nextInt(estadoscivil.length)];


                        //                               "CADASTRO"
                        //NOME
                        Thread.sleep(500);
                        Actions actions2 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 25).click().sendKeys(nomePessoa1).perform();

                        //APELIDO
                        Thread.sleep(500);
                        Actions actions3 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 25).click().sendKeys(apelido).perform();

                        //CPF
                        Thread.sleep(500);
                        Actions actions4 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 25).click().sendKeys(cpf).perform();

                        //PROFISSÃO
                        Thread.sleep(500);
                        Actions actions5 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 25).click().sendKeys(profissao).perform();

                        //SEXO
                        Thread.sleep(500);
                        Actions actions6 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 25).click().sendKeys(genero).sendKeys(Keys.TAB).perform();

                        //NASCIMENTO
                        Thread.sleep(500);
                        Actions actions7 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 40).sendKeys("11112000").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                        Actions actions8 = new Actions(navegador);

                        //ESTADO CIVIL
                        Thread.sleep(500);
                        Actions actions9 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(-20, 0).sendKeys(estadocivil).sendKeys(Keys.ENTER).perform();
                        Thread.sleep(500);

                        //CLICAR NO BOTÃO "ATIVO"
                        Actions actions10 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 60).click().perform();

                        //CLICAR NO BOTÃO "PESSOA FÍSICA"
                        Actions actions11 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 30).click().perform();
                        Thread.sleep(500);


                        //clique no botão                  "CONTATO"
                        Actions actions12 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(30, -260).click().perform();
                        Thread.sleep(500);

                        //CELULAR
                        Actions actions13 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 120).click().sendKeys(celular).perform();

                        //E-MAIL
                        Thread.sleep(500);
                        Actions actions14 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 35).click().sendKeys(email).perform();


                        //clique no botão                "RELIGIOSIDADE"
                        Thread.sleep(500);
                        Actions actions15 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(60, -50).click().perform();

                        //RELIGIÃO
                        Thread.sleep(500);
                        Actions actions16 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, -100).click().sendKeys(religiao).sendKeys(Keys.ENTER).perform();
                        Thread.sleep(500);

                        //CLICAR NO BOTÃO "BATISMO"
                        Thread.sleep(500);
                        Actions actions17 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 30).click().perform();

                        //CLICAR NO BOTÃO "COMUNHÃO"
                        Thread.sleep(500);
                        Actions actions18 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 30).click().perform();

                        //CLICAR NO BOTÃO "CRISMA"
                        Thread.sleep(500);
                        Actions actions19 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 30).click().perform();

                        //PARÓQUIA
                        Thread.sleep(500);
                        Actions actions20 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 30).click().sendKeys(paroquia).perform();

                        //CONGREGAÇÃO
                        Thread.sleep(500);
                        Actions actions21 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 30).click().sendKeys("xxxxx1").perform();

                        //ATUANTE IGREJA
                        Thread.sleep(500);
                        Actions actions22 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 30).click().sendKeys("xxxxx2").perform();

                        //PASTORAIS OU SERVIÇOS
                        Thread.sleep(500);
                        Actions actions23 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 30).click().sendKeys("xxxxx3").perform();

                        //MOVIMENTO QUE FREQUENTA
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 30).click().sendKeys("xxxxx4").sendKeys(Keys.TAB).perform();


                        //SEITA, IDEOLOGIA OU RELIGIÃO QUE FREQUENTA
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(10, 25).sendKeys("xxxxx5").sendKeys(Keys.TAB).perform();


                        //ENTIDADE QUE FREQUENTA
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 0).sendKeys("xxxxx6").perform();


                        //clique no botão                 "OUTROS"
                        Actions actions27 = new Actions(navegador);
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(110, -320).click().perform();
                        Thread.sleep(500);

                        //CLICAR NO BOTÃO AUTORIZA E-MAIL (Relatório)
                        Thread.sleep(500);
                        Actions actions28 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 110).click().perform();

                        //CLICAR NO BOTÃO AUTORIZA CELULAR (Relatório)
                        Thread.sleep(500);
                        Actions actions29 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 30).click().perform();

                        //CLICAR NO BOTÃO AUTORIZA TEL RESIDENCIAL (Relatório)
                        Thread.sleep(500);
                        Actions actions30 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 30).click().perform();

                        //DATA DE VIGOR
                        Thread.sleep(500);
                        Actions actions31 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(-80, 50).click().sendKeys("11112020").perform();

                        //SELECIONAR ETAPA "1"
                        Thread.sleep(500);
                        Actions actions32 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(-200, 50).click().perform();

                        //SELECIONAR ETAPA "2"
                        Thread.sleep(500);
                        Actions actions33 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(120, -60).click().perform();

                        //SELECIONAR ETAPA "3"
                        Thread.sleep(500);
                        Actions actions34 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(120, -30).click().perform();

                        //PREENCHER ETAPA "1"
                        //NÚMERO DA ETAPA 1
                        Thread.sleep(500);
                        Actions actions35 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 30).click().sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("1").sendKeys(Keys.TAB).perform();

                        // DATA DE INÍCIO DA ETAPA 1
                        Thread.sleep(500);
                        Actions actions36 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 25).sendKeys("01012020").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

                        // LOCAL ETAPA 1
                        Thread.sleep(500);
                        Actions actions37 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 25).sendKeys("xxxxx7").sendKeys(Keys.TAB).perform();

                        // NÚCLEO SIGLA ETAPA 1
                        Thread.sleep(500);
                        Actions actions38 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(10, 25).sendKeys("xXXXx8").sendKeys(Keys.TAB).perform();


                        //PREENCHER ETAPA "2"
                        //NÚMERO DA ETAPA
                        Thread.sleep(500);
                        Actions actions39 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 40).sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("2").sendKeys(Keys.TAB).perform();

                        // DATA INÍCIO DA ETAPA 2
                        Thread.sleep(500);
                        Actions actions40 = new Actions(navegador);
                        new Actions(navegador).moveByOffset(0, 25).sendKeys("01012020").sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

                        // LOCAL ETAPA 2
                        Thread.sleep(500);
                        Actions actions41 = new Actions(navegador);
                        new Actions(navegador).sendKeys("xxxxx9").sendKeys(Keys.TAB).perform();

                        // NÚCLEO SIGLA ETAPA 2
                        Thread.sleep(500);
                        Actions actions42 = new Actions(navegador);
                        new Actions(navegador).sendKeys("xXXXx10").sendKeys(Keys.TAB).perform();


                        //PREENCHER ETAPA "3"
                        //NÚMERO DA ETAPA
                        Thread.sleep(500);
                        Actions actions43 = new Actions(navegador);
                        new Actions(navegador).sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("3").sendKeys(Keys.TAB).perform();

                        // DATA INÍCIO ETAPA 3
                        Thread.sleep(500);
                        Actions actions44 = new Actions(navegador);
                        new Actions(navegador).sendKeys("01012020").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

                        // LOCAL ETAPA 3
                        Thread.sleep(500);
                        Actions actions45 = new Actions(navegador);
                        new Actions(navegador).sendKeys("xxxxx11").sendKeys(Keys.TAB).perform();

                        // NÚCLEO SIGLA ETAPA 3
                        Thread.sleep(500);
                        Actions actions46 = new Actions(navegador);
                        new Actions(navegador).sendKeys("xXXXx12").perform();

                        //VOLTAR AO TOPO DA TELA
                        Thread.sleep(500);
                        Actions actions47 = new Actions(navegador);
                        actions.moveByOffset(470, -420).click().perform();


                        //                         "SALVAR CADASTRO"
                        Thread.sleep(500);
                        navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/button[3]")).click();


                        // SCREENSHOT
                        try {
                                // MOVER PARA AS COORDENADAS E CLICAR
                                new Actions(navegador).moveByOffset(154, 154).click().perform();
                                Thread.sleep(1000);

                                // TIRA UMA CAPTURA DE TELA PARA ANÁLISE VISUAL
                                String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

                                // CAMINHO PARA SALVAR A CAPTURA DE TELA
                                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//" + "Cadastro de Pessoas//resultado_teste_" + timestamp + ".png");

                                // SALVAR A CAPTURA DE TELA
                                FileHandler.copy(screenshotFile, destinoFile);
                                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

                        } catch (Exception e) {
                                System.out.println("Erro ao verificar falhas visíveis nas coordenadas " + "(" + 154 + ", " + 154 + "): " + e.getMessage());


                                // PAUSA PARA FECHAR O NAVEGADOR
                                Thread.sleep(2000);
                        }
                        //FINALIZAR NAVEGADOR
                        navegador.quit();


                        // Reabrir o navegador para conferência
                        nomePessoa1 = "";
                        try (BufferedReader reader = new BufferedReader(new FileReader("nomePessoa1.txt"))) {
                                nomePessoa1 = reader.readLine(); // Lê o nome salvo no arquivo
                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                        // Driver
                        WebDriverManager.chromedriver().setup();
                        navegador = new ChromeDriver();

                        // Abrir o o SEG
                        navegador.get("https://app.seg.inf.br/novo/");


                        // Login e senha para entrar na conta da SEG.
                        navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                                .sendKeys("JOAO.VICTOR");
                        navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                        navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);


                        // Espera para aparecer novo campo.
                        wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                        campoDinamico = wait.until(ExpectedConditions
                                .visibilityOfElementLocated(By.id("home.login.entidade")));
                        campoDinamico.sendKeys("SEG");


                        // Abrindo a janela de seleção de entidade
                        navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                        navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text"))
                                .sendKeys(Keys.TAB);
                        actions = new Actions(navegador);


                        // Entrar no SEG DESENVOLVIMENTO
                        new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();


                        //Abrir SGE (Cadastro de Pessoa).
                        navegador.get("https://app.seg.inf.br/novo/user/sge_base_pessoa");


                        // Tempo de espera
                        // By elementoLocator = By.xpath("//*[class(avatar)='']");
                        wait = new WebDriverWait(navegador, Duration.ofSeconds(15));
                        elemento = wait.until(ExpectedConditions
                                .elementToBeClickable(By.className("avatar")));

                        //Pesquisa de Cadastro
                        navegador.findElement(By.id("searchInput")).sendKeys(nomePessoa1 + Keys.ENTER);

                        // Selecionar Cadastro
                        Thread.sleep(1000);
                        new Actions(navegador).moveByOffset(100, 130).doubleClick().perform();

                        // Selecionar "Alterar"
                        Thread.sleep(1000);
                        new Actions(navegador).moveByOffset(50, -240).click().perform();


                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                        JavascriptExecutor js = (JavascriptExecutor) navegador;
                        StringBuilder mensagensErro = new StringBuilder();


                        // "NOME"
                        Thread.sleep(500);
                        actions.moveByOffset(0, 180).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNome = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Nome está vazio
                        if (valorCampoNome == null || valorCampoNome.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Nome está vazio.\\n");
                                System.out.println("ERRO: O campo Nome está vazio.");
                        } else {
                                System.out.println("O campo Nome foi preenchido com: " + valorCampoNome);
                        }

                        // "APELIDO"
                        actions.moveByOffset(0, 20).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoApelido = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Apelido está vazio
                        if (valorCampoApelido == null || valorCampoApelido.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Apelido está vazio.\\n");
                                System.out.println("ERRO: O campo Apelido está vazio.");
                        } else {
                                System.out.println("O campo Apelido foi preenchido com: " + valorCampoApelido);
                        }

                        // "CPF"
                        actions.moveByOffset(0, 30).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoCPF = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo CPF está vazio
                        if (valorCampoCPF == null || valorCampoCPF.isEmpty()) {
                                mensagensErro.append("ERRO: O campo CPF está vazio.\\n");
                                System.out.println("ERRO: O campo CPF está vazio.");
                        } else {
                                System.out.println("O campo CPF foi preenchido com: " + valorCampoCPF);
                        }

                        // "PROFISSÃO"
                        actions.moveByOffset(0, 30).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoProfissao = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Profissão está vazio
                        if (valorCampoProfissao == null || valorCampoProfissao.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Profissão está vazio.\\n");
                                System.out.println("ERRO: O campo Profissão está vazio.");
                        } else {
                                System.out.println("O campo Profissão foi preenchido com: " + valorCampoProfissao);
                        }

                        // "SEXO"
                        actions.moveByOffset(0, 30).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoSexo = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Sexo está vazio
                        if (valorCampoSexo == null || valorCampoSexo.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Sexo está vazio.\\n");
                                System.out.println("ERRO: O campo Sexo está vazio.");
                        } else {
                                System.out.println("O campo Sexo foi preenchido com: " + valorCampoSexo);
                        }

                        // "ESTADO CIVIL"
                        actions.moveByOffset(0, 60).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorEstadoCivil = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo EstadoCivil está vazio
                        if (valorEstadoCivil == null || valorEstadoCivil.isEmpty()) {
                                mensagensErro.append("ERRO: O campo EstadoCivil está vazio.\\n");
                                System.out.println("ERRO: O campo EstadoCivil está vazio.");
                        } else {
                                System.out.println("O campo EstadoCivil foi preenchido com: " + valorEstadoCivil);
                        }


                        //CLICAR EM CONTATO
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(-180, -230).click().perform();

                        // "CELULAR"
                        actions.moveByOffset(0, 140).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoCelular = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Celular está vazio
                        if (valorCampoCelular == null || valorCampoCelular.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Celular está vazio.\\n");
                                System.out.println("ERRO: O campo Celular está vazio.");
                        } else {
                                System.out.println("O campo Celular foi preenchido com: " + valorCampoCelular);
                        }

                        // "E-MAIL"
                        actions.moveByOffset(0, 20).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoEmail = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Email está vazio
                        if (valorCampoEmail == null || valorCampoEmail.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Email está vazio.\\n");
                                System.out.println("ERRO: O campo Email está vazio.");
                        } else {
                                System.out.println("O campo Email foi preenchido com: " + valorCampoEmail);
                        }


                        //Clicar em Religiosidade
                        Thread.sleep(1000);
                        new Actions(navegador).moveByOffset(40, -50).click().perform();

                        // "Religiao"
                        actions.moveByOffset(0, -110).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoReligiao = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Religiao está vazio
                        if (valorCampoReligiao == null || valorCampoReligiao.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Religiao está vazio.\\n");
                                System.out.println("ERRO: O campo Religiao está vazio.");
                        } else {
                                System.out.println("O campo Religiao foi preenchido com: " + valorCampoReligiao);
                        }

                        // "PARÓQUIA"
                        actions.moveByOffset(0, 130).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoParoquia = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Paroquia está vazio
                        if (valorCampoParoquia == null || valorCampoParoquia.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Paroquia está vazio.\\n");
                                System.out.println("ERRO: O campo Paroquia está vazio.");
                        } else {
                                System.out.println("O campo Paroquia foi preenchido com: " + valorCampoParoquia);
                        }

                        // "CONGREGAÇÃO"
                        actions.moveByOffset(0, 25).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoCongregacao = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Congregação está vazio
                        if (valorCampoCongregacao == null || valorCampoCongregacao.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Congregacao está vazio.\\n");
                                System.out.println("ERRO: O campo Congregacao está vazio.");
                        } else {
                                System.out.println("O campo Congregacao foi preenchido com: " + valorCampoCongregacao);
                        }

                        // "ATUANTE IGREJA"
                        actions.moveByOffset(0, 25).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoAtuanteIgreja = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Atuante Igreja está vazio
                        if (valorCampoAtuanteIgreja == null || valorCampoAtuanteIgreja.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Atuante Igreja está vazio.\\n");
                                System.out.println("ERRO: O campo Atuante Igreja está vazio.");
                        } else {
                                System.out.println("O campo Atuante Igreja foi preenchido com: " + valorCampoAtuanteIgreja);
                        }

                        // "PASTORAIS OU SERVIÇOS"
                        actions.moveByOffset(0, 35).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoPastoraisouServicos = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Atuante Igreja está vazio
                        if (valorCampoPastoraisouServicos == null || valorCampoPastoraisouServicos.isEmpty()) {
                                mensagensErro.append("ERRO: O campo PastoraisouServiços está vazio.\\n");
                                System.out.println("ERRO: O campo PastoraisouServiços está vazio.");
                        } else {
                                System.out.println("O campo PastoraisouServiços Igreja foi preenchido com: " + valorCampoPastoraisouServicos);
                        }

                        // "MOVIMENTO QUE FREQUENTA"
                        actions.moveByOffset(0, 20).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoMovqueFrequenta = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Movimento que Frequenta está vazio
                        if (valorCampoMovqueFrequenta == null || valorCampoMovqueFrequenta.isEmpty()) {
                                mensagensErro.append("ERRO: O campo MovimentoqueFrequenta está vazio.\\n");
                                System.out.println("ERRO: O campo MovimentoqueFrequenta está vazio.");
                        } else {
                                System.out.println("O campo MovimentoqueFrequenta Igreja foi preenchido com: " + valorCampoMovqueFrequenta);
                        }

                        // "SEITA, IDEOLOGIA OU RELIGIÃO QUE FREQUENTA"
                        actions.moveByOffset(60, 30).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoSeitaIdeologiaReligiao = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Movimento que Frequenta está vazio
                        if (valorCampoSeitaIdeologiaReligiao == null || valorCampoSeitaIdeologiaReligiao.isEmpty()) {
                                mensagensErro.append("ERRO: O campo SeitaIdeologiaReligiao está vazio.\\n");
                                System.out.println("ERRO: O campo SeitaIdeologiaReligiao está vazio.");
                        } else {
                                System.out.println("O campo SeitaIdeologiaReligiao Igreja foi preenchido com: " + valorCampoSeitaIdeologiaReligiao);
                        }

                        // "ENTIDADE QUE FREQUENTA"
                        actions.moveByOffset(0, 35).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoEntidadequefrequenta = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Movimento que Frequenta está vazio
                        if (valorCampoEntidadequefrequenta == null || valorCampoEntidadequefrequenta.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Entidadequefrequenta está vazio.\\n");
                                System.out.println("ERRO: O campo Entidadequefrequenta está vazio.");
                        } else {
                                System.out.println("O campo Entidadequefrequenta Igreja foi preenchido com: " + valorCampoEntidadequefrequenta);
                        }


                        //CLICAR EM OUTROS
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(40, -310).click().perform();

                        // "Número Etapa 1"
                        actions.moveByOffset(0, 180).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNumeroEtapa1 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo NumeroEtapa1 está vazio
                        if (valorCampoNumeroEtapa1 == null || valorCampoNumeroEtapa1.isEmpty()) {
                                mensagensErro.append("ERRO: O campo NumeroEtapa1 está vazio.\\n");
                                System.out.println("ERRO: O campo NumeroEtapa1 está vazio.");
                        } else {
                                System.out.println("O campo NumeroEtapa1 foi preenchido com: " + valorCampoNumeroEtapa1);
                        }

                        // "Data Início Etapa 1"
                        actions.moveByOffset(0, 30).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoDataInicioEtapa1 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo NumeroEtapa1 está vazio
                        if (valorCampoDataInicioEtapa1 == null || valorCampoDataInicioEtapa1.isEmpty()) {
                                mensagensErro.append("ERRO: O campo DataInicioEtapa1 está vazio.\\n");
                                System.out.println("ERRO: O campo DataInicioEtapa1 está vazio.");
                        } else {
                                System.out.println("O campo DataInicioEtapa1 foi preenchido com: " + valorCampoDataInicioEtapa1);
                        }

                        // "Local Etapa 1"
                        actions.moveByOffset(0, 35).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoLocalEtapa1 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo LocalEtapa1 está vazio
                        if (valorCampoLocalEtapa1 == null || valorCampoLocalEtapa1.isEmpty()) {
                                mensagensErro.append("ERRO: O campo LocalEtapa1 está vazio.\\n");
                                System.out.println("ERRO: O campo LocalEtapa1 está vazio.");
                        } else {
                                System.out.println("O campo LocalEtapa1 foi preenchido com: " + valorCampoLocalEtapa1);
                        }

                        // "Núcleo Sigla Etapa 1"
                        actions.moveByOffset(0, 20).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNucleoSiglaEtapa1 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo LocalEtapa1 está vazio
                        if (valorCampoNucleoSiglaEtapa1 == null || valorCampoNucleoSiglaEtapa1.isEmpty()) {
                                mensagensErro.append("ERRO: O campo NucleoSiglaEtapa1 está vazio.\\n");
                                System.out.println("ERRO: O campo NucleoSiglaEtapa1 está vazio.");
                        } else {
                                System.out.println("O campo NucleoSiglaEtapa1 foi preenchido com: " + valorCampoNucleoSiglaEtapa1);
                        }

                        // "Número Etapa 2"
                        actions.moveByOffset(0, 25).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNumeroEtapa2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo NumeroEtapa2 está vazio
                        if (valorCampoNumeroEtapa2 == null || valorCampoNumeroEtapa2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo NumeroEtapa2 está vazio.\\n");
                                System.out.println("ERRO: O campo NumeroEtapa2 está vazio.");
                        } else {
                                System.out.println("O campo NumeroEtapa2 foi preenchido com: " + valorCampoNumeroEtapa2);
                        }

                        // "Data Início Etapa 2"
                        actions.moveByOffset(0, 40).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoDataInicioEtapa2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo NumeroEtapa2 está vazio
                        if (valorCampoDataInicioEtapa2 == null || valorCampoDataInicioEtapa2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo DataInicioEtapa2 está vazio.\\n");
                                System.out.println("ERRO: O campo DataInicioEtapa2 está vazio.");
                        } else {
                                System.out.println("O campo DataInicioEtapa2 foi preenchido com: " + valorCampoDataInicioEtapa2);
                        }

                        //Rolar tela para baixo
                        actions.moveByOffset(0, 0).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();


                        // "Local Etapa 2"
                        actions.moveByOffset(-40, -150).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoLocalEtapa2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo LocalEtapa1 está vazio
                        if (valorCampoLocalEtapa2 == null || valorCampoLocalEtapa2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo LocalEtapa2 está vazio.\\n");
                                System.out.println("ERRO: O campo LocalEtapa2 está vazio.");
                        } else {
                                System.out.println("O campo LocalEtapa2 foi preenchido com: " + valorCampoLocalEtapa2);
                        }

                        // "Núcleo Sigla Etapa 2"
                        actions.moveByOffset(0, 20).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNucleoSiglaEtapa2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo LocalEtapa2 está vazio
                        if (valorCampoNucleoSiglaEtapa2 == null || valorCampoNucleoSiglaEtapa2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo NucleoSiglaEtapa2 está vazio.\\n");
                                System.out.println("ERRO: O campo NucleoSiglaEtapa2 está vazio.");
                        } else {
                                System.out.println("O campo NucleoSiglaEtapa2 foi preenchido com: " + valorCampoNucleoSiglaEtapa2);
                        }

                        // "Número Etapa 3"
                        actions.moveByOffset(0, 35).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNumeroEtapa3 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo NumeroEtapa3 está vazio
                        if (valorCampoNumeroEtapa3 == null || valorCampoNumeroEtapa3.isEmpty()) {
                                mensagensErro.append("ERRO: O campo NumeroEtapa3 está vazio.\\n");
                                System.out.println("ERRO: O campo NumeroEtapa3 está vazio.");
                        } else {
                                System.out.println("O campo NumeroEtapa3 foi preenchido com: " + valorCampoNumeroEtapa3);
                        }


                        // "Data Início Etapa 3"
                        actions.moveByOffset(-20, 25).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoDataInicioEtapa3 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo DataInicioEtapa3 está vazio
                        if (valorCampoDataInicioEtapa3 == null || valorCampoDataInicioEtapa3.isEmpty()) {
                                mensagensErro.append("ERRO: O campo DataInicioEtapa3 está vazio.\\n");
                                System.out.println("ERRO: O campo DataInicioEtapa3 está vazio.");
                        } else {
                                System.out.println("O campo DataInicioEtapa3 foi preenchido com: " + valorCampoDataInicioEtapa3);
                        }

                        // "Local Etapa 3"
                        actions.moveByOffset(0, 30).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoLocalEtapa3 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo LocalEtapa1 está vazio
                        if (valorCampoLocalEtapa3 == null || valorCampoLocalEtapa3.isEmpty()) {
                                mensagensErro.append("ERRO: O campo LocalEtapa3 está vazio.\\n");
                                System.out.println("ERRO: O campo LocalEtapa3 está vazio.");
                        } else {
                                System.out.println("O campo LocalEtapa3 foi preenchido com: " + valorCampoLocalEtapa3);
                        }

                        // "Núcleo Sigla Etapa 3"
                        actions.moveByOffset(0, 35).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNucleoSiglaEtapa3 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo NucleoSiglaEtapa3 está vazio
                        if (valorCampoNucleoSiglaEtapa3 == null || valorCampoNucleoSiglaEtapa3.isEmpty()) {
                                mensagensErro.append("ERRO: O campo NucleoSiglaEtapa3 está vazio.\\n");
                                System.out.println("ERRO: O campo NucleoSiglaEtapa3 está vazio.");
                        } else {
                                System.out.println("O campo NucleoSiglaEtapa3 foi preenchido com: " + valorCampoNucleoSiglaEtapa3);
                        }


                        // Definir o caminho e nome do arquivo
                        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                        String caminhoPasta4 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pessoas//erros log//erros";
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
                        Thread.sleep(2000);


                        // INICIO DE CICLO DE ALTERAÇÃO

                        String nomePessoa2 = "TestSeleniumWD" + random.nextInt(1000);
                        // Salvar o nome gerado em um arquivo
                        try (FileWriter writer = new FileWriter("nomePessoa2.txt")) {
                                writer.write(nomePessoa2);
                        } catch (IOException e) {
                                e.printStackTrace();
                        }


                        // GERAÇÃO DE DADOS DINÂMICOS
                        String apelido2 = "TSTSWD" + random.nextInt(1000);
                        String cpf2 = "12345678" + random.nextInt(1000);
                        String[] profissoes2 = {"acrobata", "afretador", "cantor", "acabador de calçados", "adestrador de animais", "aromista", "antropólogo", "zootecnista", "vinagreiro", "vassoureiro"};
                        String profissao2 = profissoes2[random.nextInt(profissoes2.length)];
                        String[] generos2 = {"Masculino", "Feminino", "Outros"};
                        String genero2 = generos2[random.nextInt(generos2.length)];
                        String[] religioes2 = {"Católico", "Candomblecista", "Judeu", "Tambor de Mina", "Ateu"};
                        String religiao2 = religioes2[random.nextInt(religioes2.length)];
                        String celular2 = "619" + (10000000 + random.nextInt(89999999));
                        String email2 = "TestSWD" + random.nextInt(1000) + "@gmail.com";
                        String[] paroquias2 = {"PAROQUIA102", "PAROQUIA276", "PAROQUIA444", "PAROQUIA518"};
                        String paroquia2 = paroquias2[random.nextInt(paroquias2.length)];
                        String[] estadoscivil2 = {"solteiro", "união estável"};
                        String estadocivil2 = estadoscivil2[random.nextInt(estadoscivil2.length)];




                        //                               "CADASTRO"
                        Thread.sleep(500);
                        navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[1]/div")).click();

                        //NOME
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, -250).doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys(nomePessoa2).sendKeys(Keys.TAB).perform();

                        //APELIDO
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 0).sendKeys(apelido2).sendKeys(Keys.TAB).perform();

                        //CPF
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 20).sendKeys(cpf2).sendKeys(Keys.TAB).perform();

                        //PROFISSÃO
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 0).sendKeys(profissao2).sendKeys(Keys.TAB).perform();

                        //SEXO
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 0).sendKeys(genero2).sendKeys(Keys.TAB).perform();

                        //NASCIMENTO
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 0).sendKeys("11112000").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

                        //ESTADO CIVIL
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 0).sendKeys(estadocivil2).sendKeys(Keys.ENTER).perform();


                        //FICHA FÍSICA
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 200).click().perform();


                        //clique no botão                  "CONTATO"
                        navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[3]/div")).click();

                        //CELULAR
                        new Actions(navegador).moveByOffset(0, -150).doubleClick().sendKeys(celular2).perform();

                        //E-MAIL
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 30).click().doubleClick().sendKeys(email2).perform();
                        Thread.sleep(500);

                        //clique no botão                "RELIGIOSIDADE"
                        navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[4]/div")).click();

                        //RELIGIÃO
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, -150).click().doubleClick().sendKeys(religiao2).sendKeys(Keys.ENTER).perform();

                        //PAROQUIA
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 125).click().doubleClick().sendKeys(paroquia2).perform();


                        //CONGREGAÇÃO
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys("aaaaa1").perform();

                        //ATUANTE IGREJA
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys("aaaaa2").perform();

                        //PASTORAIS OU SERVIÇOS
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys("aaaaa3").perform();

                        //MOVIMENTO QUE FREQUENTA
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys("aaaaa4").sendKeys(Keys.TAB).perform();


                        //SEITA, IDEOLOGIA OU RELIGIÃO QUE FREQUENTA
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(10, 25).sendKeys("aaaaa5").sendKeys(Keys.TAB).perform();


                        //ENTIDADE QUE FREQUENTA
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 0).sendKeys("aaaaa6").perform();


                        //                               "OUTROS"
                        Thread.sleep(500);
                        navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[5]/div")).click();



                        //NÚMERO DA ETAPA 1
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, -120).doubleClick().sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("4").sendKeys(Keys.TAB).perform();

                        // DATA DE INÍCIO DA ETAPA 1
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 25).sendKeys("10012020").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

                        // LOCAL ETAPA 1
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 25).sendKeys("aaaaa7").sendKeys(Keys.TAB).perform();

                        // NÚCLEO SIGLA ETAPA 1
                        Thread.sleep(500);
                        new Actions(navegador).sendKeys("aaaaa8").sendKeys(Keys.TAB).perform();

                        //PREENCHER ETAPA "2"
                        //NÚMERO DA ETAPA
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 35).sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("5").sendKeys(Keys.TAB).perform();

                        // DATA INÍCIO DA ETAPA 2
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(0, 30).sendKeys("10012021").sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

                        // LOCAL ETAPA 2
                        Thread.sleep(500);
                        new Actions(navegador).sendKeys("aaaaa9").sendKeys(Keys.TAB).perform();

                        // NÚCLEO SIGLA ETAPA 2
                        Thread.sleep(500);
                        new Actions(navegador).sendKeys("aaaaa10").sendKeys(Keys.TAB).perform();


                        //PREENCHER ETAPA "3"
                        //NÚMERO DA ETAPA
                        Thread.sleep(500);
                        new Actions(navegador).sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("6").sendKeys(Keys.TAB).perform();

                        // DATA INÍCIO ETAPA 3
                        Thread.sleep(500);
                        new Actions(navegador).sendKeys("10012022").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

                        // LOCAL ETAPA 3
                        Thread.sleep(500);
                        new Actions(navegador).sendKeys("aaaaa11").sendKeys(Keys.TAB).perform();

                        // NÚCLEO SIGLA ETAPA 3
                        Thread.sleep(500);
                        new Actions(navegador).sendKeys("aaaaa12").perform();

                        
                        //                         "SALVAR CADASTRO"
                        Thread.sleep(500);
                        navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/button[3]")).click();



                        // SCREENSHOT
                        try {
                                // MOVER PARA AS COORDENADAS E CLICAR
                                new Actions(navegador).moveByOffset(154, 154).click().perform();
                                Thread.sleep(1000);

                                // TIRA UMA CAPTURA DE TELA PARA ANÁLISE VISUAL
                                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

                                // CAMINHO PARA SALVAR A CAPTURA DE TELA
                                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pessoas//Alteração//resultado_teste_" + timestamp + ".png");

                                // SALVAR A CAPTURA DE TELA
                                FileHandler.copy(screenshotFile, destinoFile);
                                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

                        } catch (Exception e) {
                                System.out.println("Erro ao verificar falhas visíveis nas coordenadas " + "(" + 154 + ", " + 154 + "): " + e.getMessage());


                                // PAUSA PARA FECHAR O NAVEGADOR
                                Thread.sleep(2000);
                        }
                        //FINALIZAR NAVEGADOR
                        navegador.quit();




                        // Reabrir o navegador para conferência
                        nomePessoa2 = "";
                        try (BufferedReader reader = new BufferedReader(new FileReader("nomePessoa2.txt"))) {
                                nomePessoa2 = reader.readLine(); // Lê o nome salvo no arquivo
                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                        // Driver
                        WebDriverManager.chromedriver().setup();
                        navegador = new ChromeDriver();

                        // Abrir o o SEG
                        navegador.get("https://app.seg.inf.br/novo/");


                        // Login e senha para entrar na conta da SEG.
                        navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                                .sendKeys("JOAO.VICTOR");
                        navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                        navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);


                        // Espera para aparecer novo campo.
                        wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                        campoDinamico = wait.until(ExpectedConditions
                                .visibilityOfElementLocated(By.id("home.login.entidade")));
                        campoDinamico.sendKeys("SEG");


                        // Abrindo a janela de seleção de entidade
                        navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                        navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text"))
                                .sendKeys(Keys.TAB);
                        actions = new Actions(navegador);


                        // Entrar no SEG DESENVOLVIMENTO
                        new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();


                        //Abrir SGE (Cadastro de Pessoa).
                        navegador.get("https://app.seg.inf.br/novo/user/sge_base_pessoa");


                        // Tempo de espera
                        // By elementoLocator = By.xpath("//*[class(avatar)='']");
                        wait = new WebDriverWait(navegador, Duration.ofSeconds(15));
                        elemento = wait.until(ExpectedConditions
                                .elementToBeClickable(By.className("avatar")));

                        //Pesquisa de Cadastro
                        navegador.findElement(By.id("searchInput")).sendKeys(nomePessoa2 + Keys.ENTER);

                        // Selecionar Cadastro
                        Thread.sleep(1000);
                        new Actions(navegador).moveByOffset(100, 130).doubleClick().perform();

                        // Selecionar "Alterar"
                        Thread.sleep(1000);
                        new Actions(navegador).moveByOffset(50, -240).click().perform();


                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                        js = (JavascriptExecutor) navegador;
                        mensagensErro = new StringBuilder();


                        // "NOME"
                        Thread.sleep(500);
                        actions.moveByOffset(0, 180).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNome2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Nome está vazio
                        if (valorCampoNome2 == null || valorCampoNome2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Nome está vazio.\\n");
                                System.out.println("ERRO: O campo Nome está vazio.");
                        } else {
                                System.out.println("O campo Nome foi preenchido com: " + valorCampoNome2);
                        }

                        // "APELIDO"
                        actions.moveByOffset(0, 20).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoApelido2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Apelido está vazio
                        if (valorCampoApelido2 == null || valorCampoApelido2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Apelido está vazio.\\n");
                                System.out.println("ERRO: O campo Apelido está vazio.");
                        } else {
                                System.out.println("O campo Apelido foi preenchido com: " + valorCampoApelido2);
                        }

                        // "CPF"
                        actions.moveByOffset(0, 30).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoCPF2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo CPF está vazio
                        if (valorCampoCPF2 == null || valorCampoCPF2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo CPF está vazio.\\n");
                                System.out.println("ERRO: O campo CPF está vazio.");
                        } else {
                                System.out.println("O campo CPF foi preenchido com: " + valorCampoCPF2);
                        }

                        // "PROFISSÃO"
                        actions.moveByOffset(0, 30).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoProfissao2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Profissão está vazio
                        if (valorCampoProfissao2 == null || valorCampoProfissao2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Profissão está vazio.\\n");
                                System.out.println("ERRO: O campo Profissão está vazio.");
                        } else {
                                System.out.println("O campo Profissão foi preenchido com: " + valorCampoProfissao2);
                        }

                        // "SEXO"
                        actions.moveByOffset(0, 30).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoSexo2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Sexo está vazio
                        if (valorCampoSexo2 == null || valorCampoSexo2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Sexo está vazio.\\n");
                                System.out.println("ERRO: O campo Sexo está vazio.");
                        } else {
                                System.out.println("O campo Sexo foi preenchido com: " + valorCampoSexo2);
                        }

                        // "ESTADO CIVIL"
                        actions.moveByOffset(0, 60).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorEstadoCivil2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo EstadoCivil está vazio
                        if (valorEstadoCivil2 == null || valorEstadoCivil2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo EstadoCivil está vazio.\\n");
                                System.out.println("ERRO: O campo EstadoCivil está vazio.");
                        } else {
                                System.out.println("O campo EstadoCivil foi preenchido com: " + valorEstadoCivil2);
                        }


                        //CLICAR EM CONTATO
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(-180, -230).click().perform();

                        // "CELULAR"
                        actions.moveByOffset(0, 140).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoCelular2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Celular está vazio
                        if (valorCampoCelular2 == null || valorCampoCelular2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Celular está vazio.\\n");
                                System.out.println("ERRO: O campo Celular está vazio.");
                        } else {
                                System.out.println("O campo Celular foi preenchido com: " + valorCampoCelular2);
                        }

                        // "E-MAIL"
                        actions.moveByOffset(0, 20).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoEmail2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Email está vazio
                        if (valorCampoEmail2 == null || valorCampoEmail2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Email está vazio.\\n");
                                System.out.println("ERRO: O campo Email está vazio.");
                        } else {
                                System.out.println("O campo Email foi preenchido com: " + valorCampoEmail2);
                        }


                        //Clicar em Religiosidade
                        Thread.sleep(1000);
                        new Actions(navegador).moveByOffset(40, -50).click().perform();

                        // "Religiao"
                        actions.moveByOffset(0, -110).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoReligiao2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Religiao está vazio
                        if (valorCampoReligiao2 == null || valorCampoReligiao2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Religiao está vazio.\\n");
                                System.out.println("ERRO: O campo Religiao está vazio.");
                        } else {
                                System.out.println("O campo Religiao foi preenchido com: " + valorCampoReligiao2);
                        }

                        // "PARÓQUIA"
                        actions.moveByOffset(0, 130).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoParoquia2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Paroquia está vazio
                        if (valorCampoParoquia2 == null || valorCampoParoquia2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Paroquia está vazio.\\n");
                                System.out.println("ERRO: O campo Paroquia está vazio.");
                        } else {
                                System.out.println("O campo Paroquia foi preenchido com: " + valorCampoParoquia2);
                        }

                        // "CONGREGAÇÃO"
                        actions.moveByOffset(0, 25).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoCongregacao2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Congregação está vazio
                        if (valorCampoCongregacao2 == null || valorCampoCongregacao2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Congregacao está vazio.\\n");
                                System.out.println("ERRO: O campo Congregacao está vazio.");
                        } else {
                                System.out.println("O campo Congregacao foi preenchido com: " + valorCampoCongregacao2);
                        }

                        // "ATUANTE IGREJA"
                        actions.moveByOffset(0, 25).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoAtuanteIgreja2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Atuante Igreja está vazio
                        if (valorCampoAtuanteIgreja2 == null || valorCampoAtuanteIgreja2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Atuante Igreja está vazio.\\n");
                                System.out.println("ERRO: O campo Atuante Igreja está vazio.");
                        } else {
                                System.out.println("O campo Atuante Igreja foi preenchido com: " + valorCampoAtuanteIgreja2);
                        }

                        // "PASTORAIS OU SERVIÇOS"
                        actions.moveByOffset(0, 35).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoPastoraisouServicos2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Atuante Igreja está vazio
                        if (valorCampoPastoraisouServicos2 == null || valorCampoPastoraisouServicos2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo PastoraisouServiços está vazio.\\n");
                                System.out.println("ERRO: O campo PastoraisouServiços está vazio.");
                        } else {
                                System.out.println("O campo PastoraisouServiços Igreja foi preenchido com: " + valorCampoPastoraisouServicos2);
                        }

                        // "MOVIMENTO QUE FREQUENTA"
                        actions.moveByOffset(0, 20).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoMovqueFrequenta2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Movimento que Frequenta está vazio
                        if (valorCampoMovqueFrequenta2 == null || valorCampoMovqueFrequenta2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo MovimentoqueFrequenta está vazio.\\n");
                                System.out.println("ERRO: O campo MovimentoqueFrequenta está vazio.");
                        } else {
                                System.out.println("O campo MovimentoqueFrequenta Igreja foi preenchido com: " + valorCampoMovqueFrequenta2);
                        }

                        // "SEITA, IDEOLOGIA OU RELIGIÃO QUE FREQUENTA"
                        actions.moveByOffset(60, 30).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoSeitaIdeologiaReligiao2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Movimento que Frequenta está vazio
                        if (valorCampoSeitaIdeologiaReligiao2 == null || valorCampoSeitaIdeologiaReligiao2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo SeitaIdeologiaReligiao está vazio.\\n");
                                System.out.println("ERRO: O campo SeitaIdeologiaReligiao está vazio.");
                        } else {
                                System.out.println("O campo SeitaIdeologiaReligiao Igreja foi preenchido com: " + valorCampoSeitaIdeologiaReligiao2);
                        }

                        // "ENTIDADE QUE FREQUENTA"
                        actions.moveByOffset(0, 35).click().perform();
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoEntidadequefrequenta2 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo Movimento que Frequenta está vazio
                        if (valorCampoEntidadequefrequenta2 == null || valorCampoEntidadequefrequenta2.isEmpty()) {
                                mensagensErro.append("ERRO: O campo Entidadequefrequenta está vazio.\\n");
                                System.out.println("ERRO: O campo Entidadequefrequenta está vazio.");
                        } else {
                                System.out.println("O campo Entidadequefrequenta Igreja foi preenchido com: " + valorCampoEntidadequefrequenta2);
                        }


                        //CLICAR EM OUTROS
                        Thread.sleep(500);
                        new Actions(navegador).moveByOffset(40, -310).click().perform();

                        // "Número Etapa 1"
                        actions.moveByOffset(0, 180).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNumeroEtapa12 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo NumeroEtapa1 está vazio
                        if (valorCampoNumeroEtapa12 == null || valorCampoNumeroEtapa12.isEmpty()) {
                                mensagensErro.append("ERRO: O campo NumeroEtapa1 está vazio.\\n");
                                System.out.println("ERRO: O campo NumeroEtapa1 está vazio.");
                        } else {
                                System.out.println("O campo NumeroEtapa1 foi preenchido com: " + valorCampoNumeroEtapa12);
                        }

                        // "Data Início Etapa 1"
                        actions.moveByOffset(0, 30).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoDataInicioEtapa12 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo NumeroEtapa1 está vazio
                        if (valorCampoDataInicioEtapa12 == null || valorCampoDataInicioEtapa12.isEmpty()) {
                                mensagensErro.append("ERRO: O campo DataInicioEtapa1 está vazio.\\n");
                                System.out.println("ERRO: O campo DataInicioEtapa1 está vazio.");
                        } else {
                                System.out.println("O campo DataInicioEtapa1 foi preenchido com: " + valorCampoDataInicioEtapa12);
                        }

                        // "Local Etapa 1"
                        actions.moveByOffset(0, 35).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoLocalEtapa12 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo LocalEtapa1 está vazio
                        if (valorCampoLocalEtapa12 == null || valorCampoLocalEtapa12.isEmpty()) {
                                mensagensErro.append("ERRO: O campo LocalEtapa1 está vazio.\\n");
                                System.out.println("ERRO: O campo LocalEtapa1 está vazio.");
                        } else {
                                System.out.println("O campo LocalEtapa1 foi preenchido com: " + valorCampoLocalEtapa12);
                        }

                        // "Núcleo Sigla Etapa 1"
                        actions.moveByOffset(0, 20).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNucleoSiglaEtapa12 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo LocalEtapa1 está vazio
                        if (valorCampoNucleoSiglaEtapa12 == null || valorCampoNucleoSiglaEtapa12.isEmpty()) {
                                mensagensErro.append("ERRO: O campo NucleoSiglaEtapa1 está vazio.\\n");
                                System.out.println("ERRO: O campo NucleoSiglaEtapa1 está vazio.");
                        } else {
                                System.out.println("O campo NucleoSiglaEtapa1 foi preenchido com: " + valorCampoNucleoSiglaEtapa12);
                        }

                        // "Número Etapa 2"
                        actions.moveByOffset(0, 25).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNumeroEtapa22 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo NumeroEtapa2 está vazio
                        if (valorCampoNumeroEtapa22 == null || valorCampoNumeroEtapa22.isEmpty()) {
                                mensagensErro.append("ERRO: O campo NumeroEtapa2 está vazio.\\n");
                                System.out.println("ERRO: O campo NumeroEtapa2 está vazio.");
                        } else {
                                System.out.println("O campo NumeroEtapa2 foi preenchido com: " + valorCampoNumeroEtapa22);
                        }

                        // "Data Início Etapa 2"
                        actions.moveByOffset(0, 40).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoDataInicioEtapa22 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo NumeroEtapa2 está vazio
                        if (valorCampoDataInicioEtapa22 == null || valorCampoDataInicioEtapa22.isEmpty()) {
                                mensagensErro.append("ERRO: O campo DataInicioEtapa2 está vazio.\\n");
                                System.out.println("ERRO: O campo DataInicioEtapa2 está vazio.");
                        } else {
                                System.out.println("O campo DataInicioEtapa2 foi preenchido com: " + valorCampoDataInicioEtapa22);
                        }

                        //Rolar tela para baixo
                        actions.moveByOffset(0, 0).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();


                        // "Local Etapa 2"
                        actions.moveByOffset(-40, -150).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoLocalEtapa22 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo LocalEtapa1 está vazio
                        if (valorCampoLocalEtapa22 == null || valorCampoLocalEtapa22.isEmpty()) {
                                mensagensErro.append("ERRO: O campo LocalEtapa2 está vazio.\\n");
                                System.out.println("ERRO: O campo LocalEtapa2 está vazio.");
                        } else {
                                System.out.println("O campo LocalEtapa2 foi preenchido com: " + valorCampoLocalEtapa22);
                        }

                        // "Núcleo Sigla Etapa 2"
                        actions.moveByOffset(0, 20).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNucleoSiglaEtapa22 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo LocalEtapa2 está vazio
                        if (valorCampoNucleoSiglaEtapa22 == null || valorCampoNucleoSiglaEtapa22.isEmpty()) {
                                mensagensErro.append("ERRO: O campo NucleoSiglaEtapa2 está vazio.\\n");
                                System.out.println("ERRO: O campo NucleoSiglaEtapa2 está vazio.");
                        } else {
                                System.out.println("O campo NucleoSiglaEtapa2 foi preenchido com: " + valorCampoNucleoSiglaEtapa22);
                        }

                        // "Número Etapa 3"
                        actions.moveByOffset(0, 35).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNumeroEtapa32 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo NumeroEtapa3 está vazio
                        if (valorCampoNumeroEtapa32 == null || valorCampoNumeroEtapa32.isEmpty()) {
                                mensagensErro.append("ERRO: O campo NumeroEtapa3 está vazio.\\n");
                                System.out.println("ERRO: O campo NumeroEtapa3 está vazio.");
                        } else {
                                System.out.println("O campo NumeroEtapa3 foi preenchido com: " + valorCampoNumeroEtapa32);
                        }


                        // "Data Início Etapa 3"
                        actions.moveByOffset(-20, 25).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoDataInicioEtapa32 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo DataInicioEtapa3 está vazio
                        if (valorCampoDataInicioEtapa32 == null || valorCampoDataInicioEtapa32.isEmpty()) {
                                mensagensErro.append("ERRO: O campo DataInicioEtapa3 está vazio.\\n");
                                System.out.println("ERRO: O campo DataInicioEtapa3 está vazio.");
                        } else {
                                System.out.println("O campo DataInicioEtapa3 foi preenchido com: " + valorCampoDataInicioEtapa32);
                        }

                        // "Local Etapa 3"
                        actions.moveByOffset(0, 30).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoLocalEtapa32 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo LocalEtapa1 está vazio
                        if (valorCampoLocalEtapa32 == null || valorCampoLocalEtapa32.isEmpty()) {
                                mensagensErro.append("ERRO: O campo LocalEtapa3 está vazio.\\n");
                                System.out.println("ERRO: O campo LocalEtapa3 está vazio.");
                        } else {
                                System.out.println("O campo LocalEtapa3 foi preenchido com: " + valorCampoLocalEtapa32);
                        }

                        // "Núcleo Sigla Etapa 3"
                        actions.moveByOffset(0, 35).click().perform();
                        // Espera para garantir que o campo foi clicado
                        Thread.sleep(500);
                        // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                        String valorCampoNucleoSiglaEtapa32 = (String) js.executeScript("return document.activeElement.value;");
                        // Verificar se o campo NucleoSiglaEtapa3 está vazio
                        if (valorCampoNucleoSiglaEtapa32 == null || valorCampoNucleoSiglaEtapa32.isEmpty()) {
                                mensagensErro.append("ERRO: O campo NucleoSiglaEtapa3 está vazio.\\n");
                                System.out.println("ERRO: O campo NucleoSiglaEtapa3 está vazio.");
                        } else {
                                System.out.println("O campo NucleoSiglaEtapa3 foi preenchido com: " + valorCampoNucleoSiglaEtapa32);
                        }


                        // Definir o caminho e nome do arquivo
                        timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                        caminhoPasta4 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pessoas//erros log//erros";
                        caminhoArquivo4 = caminhoPasta4 + "erroslog" + timestamp + ".txt";

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
                        Thread.sleep(3000);

                        // Excluir cadastro após testes realizados
                        Thread.sleep(500);
                        navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/button[5]")).click();
                        Thread.sleep(500);
                        navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]"));

                        //Pausa antes de reiniciar processo.
                        Thread.sleep(3000);


                }

        }
}


