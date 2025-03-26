package br.com.google.teste1.cadastro;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.xml.sax.SAXException;
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

        while (true) {

            // Criar nome aleatório para o cadastro
            Random random = new Random();
            String nomePessoa1 = "TestSeleniumWD" + random.nextInt(100000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomePessoa1.txt")) {
                writer.write(nomePessoa1);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Driver
            WebDriverManager.chromedriver().setup();
            WebDriver navegador = new ChromeDriver();
            // Definindo o tamanho da janela do navegador
            Dimension tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            // Abrir o o SEG
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

            Actions actions;
            actions = new Actions(navegador);

            //ABRIR SGE (CADASTRO DE PESSOA).
            navegador.get("https://app.seg.inf.br/novo/user/sge_base_pessoa");

            // Tempo de espera
            WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(15));
            WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(By.className("avatar")));

            // CRIAR CADASTRO

            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[2]")).click();

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
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 85).click().sendKeys(nomePessoa1).sendKeys(Keys.TAB).perform();//NOME
            Thread.sleep(50);
            new Actions(navegador).sendKeys(apelido).sendKeys(Keys.TAB).perform();//APELIDO
            Thread.sleep(50);
            new Actions(navegador).sendKeys(cpf).sendKeys(Keys.TAB).perform();//CPF
            Thread.sleep(50);
            new Actions(navegador).sendKeys(profissao).sendKeys(Keys.TAB).perform(); //PROFISSÃO
            Thread.sleep(50);
            new Actions(navegador).sendKeys(genero).sendKeys(Keys.TAB).perform(); //SEXO
            Thread.sleep(300);
            new Actions(navegador).sendKeys("11112000").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();//NASCIMENTO
            Thread.sleep(300);
            new Actions(navegador).sendKeys(estadocivil).sendKeys(Keys.TAB).perform();//ESTADO CIVIL
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 200).click().perform();//CLICAR NO BOTÃO "ATIVO"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO BOTÃO "PESSOA FÍSICA"

            //clique no botão                  "CONTATO"
            Thread.sleep(50);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[3]/div")).click();
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -120).click().sendKeys(celular).sendKeys(Keys.TAB).perform();//CELULAR
            Thread.sleep(50);
            new Actions(navegador).sendKeys(email).perform();//E-MAIL

            //clique no botão                "RELIGIOSIDADE"
            Thread.sleep(50);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[4]/div")).click();
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -145).click().sendKeys(religiao).sendKeys(Keys.ENTER).perform();//RELIGIÃO
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO BOTÃO "BATISMO"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO BOTÃO "COMUNHÃO"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO BOTÃO "CRISMA"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).click().sendKeys(paroquia).sendKeys(Keys.TAB).perform();//PARÓQUIA
            Thread.sleep(50);
            new Actions(navegador).sendKeys("xxxxx1").sendKeys(Keys.TAB).perform();//CONGREGAÇÃO
            Thread.sleep(50);
            new Actions(navegador).sendKeys("xxxxx2").sendKeys(Keys.TAB).perform();//ATUANTE IGREJA
            Thread.sleep(50);
            new Actions(navegador).sendKeys("xxxxx3").sendKeys(Keys.TAB).perform();//PASTORAIS OU SERVIÇOS
            Thread.sleep(50);
            new Actions(navegador).sendKeys("xxxxx4").sendKeys(Keys.TAB).perform();//MOVIMENTO QUE FREQUENTA
            Thread.sleep(50);
            new Actions(navegador).sendKeys("xxxxx5").sendKeys(Keys.TAB).perform();//SEITA, IDEOLOGIA OU RELIGIÃO QUE FREQUENTA
            Thread.sleep(50);
            new Actions(navegador).sendKeys("xxxxx6").perform();//ENTIDADE QUE FREQUENTA
            Thread.sleep(50);

            //clique no botão                 "OUTROS"
            Thread.sleep(50);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[5]/div")).click();
            Thread.sleep(50);
            navegador.findElement(By.xpath("//*[@id=\"sge_pessoa.modal.sge_pessoa_cadastro.undefined\"]/div")).click();
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -35).click().perform();//CLICAR NO BOTÃO AUTORIZA "E-MAIL" (Relatório)
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO BOTÃO AUTORIZA CELULAR (Relatório)
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO BOTÃO AUTORIZA TEL RESIDENCIAL (Relatório)
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(-80, 50).click().sendKeys("11112020").perform();//DATA DE VIGOR
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(-50, 30).click().perform();//SELECIONAR ETAPA "1"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(120, -60).click().perform();//SELECIONAR ETAPA "2"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(120, -45).click().perform();//SELECIONAR ETAPA "3"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 50).click().sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("1").sendKeys(Keys.TAB).perform();//NÚMERO DA ETAPA 1.
            Thread.sleep(50);
            new Actions(navegador).sendKeys("01012020").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA DE INÍCIO DA ETAPA 1
            Thread.sleep(50);
            new Actions(navegador).sendKeys("xxxxx7").sendKeys(Keys.TAB).perform();// LOCAL ETAPA 1
            Thread.sleep(50);
            new Actions(navegador).sendKeys("xXXXx8").sendKeys(Keys.TAB).perform();// NÚCLEO SIGLA ETAPA 1
            Thread.sleep(50);
            new Actions(navegador).sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("2").sendKeys(Keys.TAB).perform();//NÚMERO DA ETAPA 2
            Thread.sleep(50);
            new Actions(navegador).sendKeys("01012020").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA DE INÍCIO DA ETAPA 2
            Thread.sleep(50);
            new Actions(navegador).sendKeys("xxxxx9").sendKeys(Keys.TAB).perform();// LOCAL ETAPA 2
            Thread.sleep(50);
            new Actions(navegador).sendKeys("xXXXx10").sendKeys(Keys.TAB).perform();// NÚCLEO SIGLA ETAPA 2
            Thread.sleep(50);
            new Actions(navegador).sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("3").sendKeys(Keys.TAB).perform();//NÚMERO DA ETAPA 3
            Thread.sleep(50);
            new Actions(navegador).sendKeys("01012020").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA DE INÍCIO DA ETAPA 3
            Thread.sleep(50);
            new Actions(navegador).sendKeys("xxxxx11").sendKeys(Keys.TAB).perform();// LOCAL ETAPA 3
            Thread.sleep(50);
            new Actions(navegador).sendKeys("xXXXx12").perform();// NÚCLEO SIGLA ETAPA 3


            //                         "SALVAR CADASTRO"
            Thread.sleep(200);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/button[3]")).click();
            Thread.sleep(500);

            // Capturar screenshot para análise visual
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pessoas//Cadastro//resultado_teste_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            //FECHAR NAVEGADOR
            // Finalizar navegador ao final de cada execução
            {
                navegador.quit();
            }
            // PAUSA PARA FECHAR O NAVEGADOR
            Thread.sleep(500);

            //INICIO DE CICLO DE CONFERENCIA DE CADASTRO\\

            // Driver
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();
            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            // Abrir o o SEG
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

            //ABRIR SGE (CADASTRO DE PESSOA).
            navegador.get("https://app.seg.inf.br/novo/user/sge_base_pessoa");
            // Tempo de espera
            wait = new WebDriverWait(navegador, Duration.ofSeconds(15));
            elemento = wait.until(ExpectedConditions.elementToBeClickable(By.className("avatar")));

            //Pesquisa de Cadastro
            navegador.findElement(By.id("searchInput")).sendKeys(nomePessoa1 + Keys.ENTER);

            //ATUALIZAR PÁGINA DE CADASTRO
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();

            // Selecionar Cadastro
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(-80, 135).doubleClick().perform();
            // Selecionar "Alterar"
            Thread.sleep(200);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/button[4]")).click();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            JavascriptExecutor js = (JavascriptExecutor) navegador;
            StringBuilder mensagensErro = new StringBuilder();

            // "NOME"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -60).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNome = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Nome está vazio
            if (valorCampoNome == null || valorCampoNome.isEmpty()) {
                mensagensErro.append("ERRO: O campo Nome está vazio.\n");
                System.out.println("ERRO: O campo Nome está vazio.\n");
            } else {
                System.out.println("O campo Nome foi preenchido com: " + valorCampoNome);
            }

            // "APELIDO"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoApelido = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Apelido está vazio
            if (valorCampoApelido == null || valorCampoApelido.isEmpty()) {
                mensagensErro.append("ERRO: O campo Apelido está vazio.\n");
                System.out.println("ERRO: O campo Apelido está vazio.\n");
            } else {
                System.out.println("O campo Apelido foi preenchido com: " + valorCampoApelido);
            }

            // "CPF"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoCPF = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo CPF está vazio
            if (valorCampoCPF == null || valorCampoCPF.isEmpty()) {
                mensagensErro.append("ERRO: O campo CPF está vazio.\n");
                System.out.println("ERRO: O campo CPF está vazio.\n");
            } else {
                System.out.println("O campo CPF foi preenchido com: " + valorCampoCPF);
            }

            // "PROFISSÃO"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoProfissao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Profissão está vazio
            if (valorCampoProfissao == null || valorCampoProfissao.isEmpty()) {
                mensagensErro.append("ERRO: O campo Profissão está vazio.\n");
                System.out.println("ERRO: O campo Profissão está vazio.\n");
            } else {
                System.out.println("O campo Profissão foi preenchido com: " + valorCampoProfissao);
            }

            // "SEXO"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoSexo = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Sexo está vazio
            if (valorCampoSexo == null || valorCampoSexo.isEmpty()) {
                mensagensErro.append("ERRO: O campo Sexo está vazio.\n");
                System.out.println("ERRO: O campo Sexo está vazio.\n");
            } else {
                System.out.println("O campo Sexo foi preenchido com: " + valorCampoSexo);
            }

            Thread.sleep(50);
            new Actions(navegador).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
            Thread.sleep(50);

            // "ESTADO CIVIL"
            Thread.sleep(50);
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorEstadoCivil = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo EstadoCivil está vazio
            if (valorEstadoCivil == null || valorEstadoCivil.isEmpty()) {
                mensagensErro.append("ERRO: O campo EstadoCivil está vazio.\n");
                System.out.println("ERRO: O campo EstadoCivil está vazio.\n");
            } else {
                System.out.println("O campo EstadoCivil foi preenchido com: " + valorEstadoCivil);
            }

            //clique no botão
            // "CONTATO"
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[3]/div")).click();
            // "CELULAR"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 90).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoCelular = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Celular está vazio
            if (valorCampoCelular == null || valorCampoCelular.isEmpty()) {
                mensagensErro.append("ERRO: O campo Celular está vazio.\n");
                System.out.println("ERRO: O campo Celular está vazio.\n");
            } else {
                System.out.println("O campo Celular foi preenchido com: " + valorCampoCelular);
            }

            // "E-MAIL"
            Thread.sleep(50);
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoEmail = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Email está vazio
            if (valorCampoEmail == null || valorCampoEmail.isEmpty()) {
                mensagensErro.append("ERRO: O campo Email está vazio.\n");
                System.out.println("ERRO: O campo Email está vazio.\n");
            } else {
                System.out.println("O campo Email foi preenchido com: " + valorCampoEmail);
            }

            //clique no botão                "RELIGIOSIDADE"
            Thread.sleep(50);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[4]/div")).click();
            // "RELIGIAO"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -130).click().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoReligiao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Religiao está vazio
            if (valorCampoReligiao == null || valorCampoReligiao.isEmpty()) {
                mensagensErro.append("ERRO: O campo Religiao está vazio.\n");
                System.out.println("ERRO: O campo Religiao está vazio.\n");
            } else {
                System.out.println("O campo Religiao foi preenchido com: " + valorCampoReligiao);
            }

            // "PARÓQUIA"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 100).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoParoquia = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Paroquia está vazio
            if (valorCampoParoquia == null || valorCampoParoquia.isEmpty()) {
                mensagensErro.append("ERRO: O campo Paroquia está vazio.\n");
                System.out.println("ERRO: O campo Paroquia está vazio.\n");
            } else {
                System.out.println("O campo Paroquia foi preenchido com: " + valorCampoParoquia);
            }

            // "CONGREGAÇÃO"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoCongregacao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Congregação está vazio
            if (valorCampoCongregacao == null || valorCampoCongregacao.isEmpty()) {
                mensagensErro.append("ERRO: O campo Congregacao está vazio.\n");
                System.out.println("ERRO: O campo Congregacao está vazio.\n");
            } else {
                System.out.println("O campo Congregacao foi preenchido com: " + valorCampoCongregacao);
            }

            // "ATUANTE IGREJA"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoAtuanteIgreja = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Atuante Igreja está vazio
            if (valorCampoAtuanteIgreja == null || valorCampoAtuanteIgreja.isEmpty()) {
                mensagensErro.append("ERRO: O campo Atuante Igreja está vazio.\n");
                System.out.println("ERRO: O campo Atuante Igreja está vazio.\n");
            } else {
                System.out.println("O campo Atuante Igreja foi preenchido com: " + valorCampoAtuanteIgreja);
            }

            // "PASTORAIS OU SERVIÇOS"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPastoraisouServicos = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Atuante Igreja está vazio
            if (valorCampoPastoraisouServicos == null || valorCampoPastoraisouServicos.isEmpty()) {
                mensagensErro.append("ERRO: O campo PastoraisouServiços está vazio.\n");
                System.out.println("ERRO: O campo PastoraisouServiços está vazio.\n");
            } else {
                System.out.println("O campo PastoraisouServiços Igreja foi preenchido com: " + valorCampoPastoraisouServicos);
            }

            // "MOVIMENTO QUE FREQUENTA"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMovqueFrequenta = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Movimento que Frequenta está vazio
            if (valorCampoMovqueFrequenta == null || valorCampoMovqueFrequenta.isEmpty()) {
                mensagensErro.append("ERRO: O campo MovimentoqueFrequenta está vazio.\n");
                System.out.println("ERRO: O campo MovimentoqueFrequenta está vazio.\n");
            } else {
                System.out.println("O campo MovimentoqueFrequenta Igreja foi preenchido com: " + valorCampoMovqueFrequenta);
            }

            // "SEITA, IDEOLOGIA OU RELIGIÃO QUE FREQUENTA"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoSeitaIdeologiaReligiao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Movimento que Frequenta está vazio
            if (valorCampoSeitaIdeologiaReligiao == null || valorCampoSeitaIdeologiaReligiao.isEmpty()) {
                mensagensErro.append("ERRO: O campo SeitaIdeologiaReligiao está vazio.\n");
                System.out.println("ERRO: O campo SeitaIdeologiaReligiao está vazio.\n");
            } else {
                System.out.println("O campo SeitaIdeologiaReligiao Igreja foi preenchido com: " + valorCampoSeitaIdeologiaReligiao);
            }

            // "ENTIDADE QUE FREQUENTA"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoEntidadequefrequenta = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Movimento que Frequenta está vazio
            if (valorCampoEntidadequefrequenta == null || valorCampoEntidadequefrequenta.isEmpty()) {
                mensagensErro.append("ERRO: O campo Entidadequefrequenta está vazio.\n");
                System.out.println("ERRO: O campo Entidadequefrequenta está vazio.\n");
            } else {
                System.out.println("O campo Entidadequefrequenta Igreja foi preenchido com: " + valorCampoEntidadequefrequenta);
            }

            //clique no botão                 "OUTROS"
            Thread.sleep(50);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[5]/div")).click();
            // "Número Etapa 1"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 65).click().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNumeroEtapa1 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo NumeroEtapa1 está vazio
            if (valorCampoNumeroEtapa1 == null || valorCampoNumeroEtapa1.isEmpty()) {
                mensagensErro.append("ERRO: O campo NumeroEtapa1 está vazio.\n");
                System.out.println("ERRO: O campo NumeroEtapa1 está vazio.\n");
            } else {
                System.out.println("O campo NumeroEtapa1 foi preenchido com: " + valorCampoNumeroEtapa1);
            }

            // "Data Início Etapa 1"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 20).click().sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDataInicioEtapa1 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo NumeroEtapa1 está vazio
            if (valorCampoDataInicioEtapa1 == null || valorCampoDataInicioEtapa1.isEmpty()) {
                mensagensErro.append("ERRO: O campo DataInicioEtapa1 está vazio.\n");
                System.out.println("ERRO: O campo DataInicioEtapa1 está vazio.\n");
            } else {
                System.out.println("O campo DataInicioEtapa1 foi preenchido com: " + valorCampoDataInicioEtapa1);
            }

            // "Local Etapa 1"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalEtapa1 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo LocalEtapa1 está vazio
            if (valorCampoLocalEtapa1 == null || valorCampoLocalEtapa1.isEmpty()) {
                mensagensErro.append("ERRO: O campo LocalEtapa1 está vazio.\n");
                System.out.println("ERRO: O campo LocalEtapa1 está vazio.\n");
            } else {
                System.out.println("O campo LocalEtapa1 foi preenchido com: " + valorCampoLocalEtapa1);
            }

            // "Núcleo Sigla Etapa 1"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNucleoSiglaEtapa1 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo LocalEtapa1 está vazio
            if (valorCampoNucleoSiglaEtapa1 == null || valorCampoNucleoSiglaEtapa1.isEmpty()) {
                mensagensErro.append("ERRO: O campo NucleoSiglaEtapa1 está vazio.\n");
                System.out.println("ERRO: O campo NucleoSiglaEtapa1 está vazio.\n");
            } else {
                System.out.println("O campo NucleoSiglaEtapa1 foi preenchido com: " + valorCampoNucleoSiglaEtapa1);
            }

            // "Número Etapa 2"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNumeroEtapa2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo NumeroEtapa2 está vazio
            if (valorCampoNumeroEtapa2 == null || valorCampoNumeroEtapa2.isEmpty()) {
                mensagensErro.append("ERRO: O campo NumeroEtapa2 está vazio.\n");
                System.out.println("ERRO: O campo NumeroEtapa2 está vazio.\n");
            } else {
                System.out.println("O campo NumeroEtapa2 foi preenchido com: " + valorCampoNumeroEtapa2);
            }

            // "Data Início Etapa 2"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDataInicioEtapa2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo NumeroEtapa2 está vazio
            if (valorCampoDataInicioEtapa2 == null || valorCampoDataInicioEtapa2.isEmpty()) {
                mensagensErro.append("ERRO: O campo DataInicioEtapa2 está vazio.\n");
                System.out.println("ERRO: O campo DataInicioEtapa2 está vazio.\n");
            } else {
                System.out.println("O campo DataInicioEtapa2 foi preenchido com: " + valorCampoDataInicioEtapa2);
            }

            // "Local Etapa 2"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalEtapa2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo LocalEtapa1 está vazio
            if (valorCampoLocalEtapa2 == null || valorCampoLocalEtapa2.isEmpty()) {
                mensagensErro.append("ERRO: O campo LocalEtapa2 está vazio.\n");
                System.out.println("ERRO: O campo LocalEtapa2 está vazio.\n");
            } else {
                System.out.println("O campo LocalEtapa2 foi preenchido com: " + valorCampoLocalEtapa2);
            }

            // "Núcleo Sigla Etapa 2"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNucleoSiglaEtapa2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo LocalEtapa2 está vazio
            if (valorCampoNucleoSiglaEtapa2 == null || valorCampoNucleoSiglaEtapa2.isEmpty()) {
                mensagensErro.append("ERRO: O campo NucleoSiglaEtapa2 está vazio.\n");
                System.out.println("ERRO: O campo NucleoSiglaEtapa2 está vazio.\n");
            } else {
                System.out.println("O campo NucleoSiglaEtapa2 foi preenchido com: " + valorCampoNucleoSiglaEtapa2);
            }

            // "Número Etapa 3"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNumeroEtapa3 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo NumeroEtapa3 está vazio
            if (valorCampoNumeroEtapa3 == null || valorCampoNumeroEtapa3.isEmpty()) {
                mensagensErro.append("ERRO: O campo NumeroEtapa3 está vazio.\n");
                System.out.println("ERRO: O campo NumeroEtapa3 está vazio.\n");
            } else {
                System.out.println("O campo NumeroEtapa3 foi preenchido com: " + valorCampoNumeroEtapa3);
            }

            // "Data Início Etapa 3"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDataInicioEtapa3 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo DataInicioEtapa3 está vazio
            if (valorCampoDataInicioEtapa3 == null || valorCampoDataInicioEtapa3.isEmpty()) {
                mensagensErro.append("ERRO: O campo DataInicioEtapa3 está vazio.\n");
                System.out.println("ERRO: O campo DataInicioEtapa3 está vazio.\n");
            } else {
                System.out.println("O campo DataInicioEtapa3 foi preenchido com: " + valorCampoDataInicioEtapa3);
            }

            // "Local Etapa 3"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalEtapa3 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo LocalEtapa1 está vazio
            if (valorCampoLocalEtapa3 == null || valorCampoLocalEtapa3.isEmpty()) {
                mensagensErro.append("ERRO: O campo LocalEtapa3 está vazio.\n");
                System.out.println("ERRO: O campo LocalEtapa3 está vazio.\n");
            } else {
                System.out.println("O campo LocalEtapa3 foi preenchido com: " + valorCampoLocalEtapa3);
            }

            // "Núcleo Sigla Etapa 3"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNucleoSiglaEtapa3 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo NucleoSiglaEtapa3 está vazio
            if (valorCampoNucleoSiglaEtapa3 == null || valorCampoNucleoSiglaEtapa3.isEmpty()) {
                mensagensErro.append("ERRO: O campo NucleoSiglaEtapa3 está vazio.\n");
                System.out.println("ERRO: O campo NucleoSiglaEtapa3 está vazio.\n");
            } else {
                System.out.println("O campo NucleoSiglaEtapa3 foi preenchido com: " + valorCampoNucleoSiglaEtapa3);
            }

            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta1 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pessoas//erros log//erros";
            String caminhoArquivo1 = caminhoPasta1 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta1);
                if (!pasta.exists()) {
                    pasta.mkdirs();
                }

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo1, true))) {
                    writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                    writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                }


                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo1);
            } catch (IOException e) {
                System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
            }
            Thread.sleep(500);


            // "INICIO DE CICLO DE ALTERAÇÃO" \\

            //GERAR NOME DINÂMICO PARA ALTERAÇÃO
            String nomePessoa2 = "TestSeleniumWD" + random.nextInt(100000);
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
            Thread.sleep(200);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[1]/div")).click();
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -115).doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys(nomePessoa2).sendKeys(Keys.TAB).perform();//NOME
            Thread.sleep(50);
            new Actions(navegador).sendKeys(apelido2).sendKeys(Keys.TAB).perform();//APELIDO
            Thread.sleep(50);
            new Actions(navegador).sendKeys(cpf2).sendKeys(Keys.TAB).perform();//CPF
            Thread.sleep(50);
            new Actions(navegador).sendKeys(profissao2).sendKeys(Keys.TAB).perform();//PROFISSÃO
            Thread.sleep(50);
            new Actions(navegador).sendKeys(genero2).sendKeys(Keys.TAB).perform();//SEXO
            Thread.sleep(50);
            new Actions(navegador).sendKeys("11112000").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();//NASCIMENTO
            Thread.sleep(50);
            new Actions(navegador).sendKeys(estadocivil2).sendKeys(Keys.ENTER).perform();//ESTADO CIVIL
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 245).click().perform();//FICHA FÍSICA
            Thread.sleep(50);

            //clique no botão                   "CONTATO"
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[3]/div")).click();
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -155).doubleClick().sendKeys(celular2).perform();//CELULAR
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(email2).perform();//E-MAIL
            Thread.sleep(500);

            //clique no botão                "RELIGIOSIDADE"
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[4]/div")).click();
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -170).doubleClick().click().sendKeys(religiao2).sendKeys(Keys.ENTER).perform();//RELIGIÃO
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 115).doubleClick().click().sendKeys(paroquia2).sendKeys(Keys.TAB).perform();//PAROQUIA
            Thread.sleep(50);
            new Actions(navegador).sendKeys("aaaaa1").sendKeys(Keys.TAB).perform();//CONGREGAÇÃO
            Thread.sleep(50);
            new Actions(navegador).sendKeys("aaaaa2").sendKeys(Keys.TAB).perform();//ATUANTE IGREJA
            Thread.sleep(50);
            new Actions(navegador).sendKeys("aaaaa3").sendKeys(Keys.TAB).perform();//PASTORAIS OU SERVIÇOS
            Thread.sleep(50);
            new Actions(navegador).sendKeys("aaaaa4").sendKeys(Keys.TAB).perform();//MOVIMENTO QUE FREQUENTA
            Thread.sleep(50);
            new Actions(navegador).sendKeys("aaaaa5").sendKeys(Keys.TAB).perform();//SEITA, IDEOLOGIA OU RELIGIÃO QUE FREQUENTA
            Thread.sleep(50);
            new Actions(navegador).sendKeys("aaaaa6").perform();//ENTIDADE QUE FREQUENTA
            Thread.sleep(500);

            //clique no botão                 "OUTROS"
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[5]/div")).click();
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 30).click().sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("4").sendKeys(Keys.TAB).perform();//NÚMERO DA ETAPA 1
            Thread.sleep(50);
            new Actions(navegador).sendKeys("10022021").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA DE INÍCIO DA ETAPA 1
            Thread.sleep(50);
            new Actions(navegador).sendKeys("aaaaa7").sendKeys(Keys.TAB).perform();// LOCAL ETAPA 1
            Thread.sleep(50);
            new Actions(navegador).sendKeys("aaaaa8").sendKeys(Keys.TAB).perform();// NÚCLEO SIGLA ETAPA 1
            Thread.sleep(50);
            new Actions(navegador).sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("5").sendKeys(Keys.TAB).perform();//NÚMERO DA ETAPA 2
            Thread.sleep(50);
            new Actions(navegador).sendKeys("10022021").sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA INÍCIO DA ETAPA 2
            Thread.sleep(50);
            new Actions(navegador).sendKeys("aaaaa9").sendKeys(Keys.TAB).perform();// LOCAL ETAPA 2
            Thread.sleep(50);
            new Actions(navegador).sendKeys("aaaaa10").sendKeys(Keys.TAB).perform();// NÚCLEO SIGLA ETAPA 2
            Thread.sleep(50);
            new Actions(navegador).sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("6").sendKeys(Keys.TAB).perform();//NÚMERO DA ETAPA 3
            Thread.sleep(50);
            new Actions(navegador).sendKeys("10022021").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA INÍCIO ETAPA 3
            Thread.sleep(50);
            new Actions(navegador).sendKeys("aaaaa11").sendKeys(Keys.TAB).perform();// LOCAL ETAPA 3
            Thread.sleep(50);
            new Actions(navegador).sendKeys("aaaaa12").perform();// NÚCLEO SIGLA ETAPA 3
            Thread.sleep(500);

            //                         "SALVAR CADASTRO"
            Thread.sleep(200);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/button[3]")).click();
            Thread.sleep(500);

            // SCREENSHOT
            try {// MOVER PARA AS COORDENADAS E CLICAR
                new Actions(navegador).moveByOffset(154, 154).click().perform();
                Thread.sleep(500);

                // TIRA UMA CAPTURA DE TELA PARA ANÁLISE VISUAL
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

                // CAMINHO PARA SALVAR A CAPTURA DE TELA
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pessoas//Cadastro alt//resultado_teste_" + timestamp + ".png");

                // SALVAR A CAPTURA DE TELA
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro ao verificar falhas visíveis nas coordenadas " + "(" + 154 + ", " + 154 + "): " + e.getMessage());

                // PAUSA PARA FECHAR O NAVEGADOR
                Thread.sleep(500);
            }
            //FINALIZAR NAVEGADOR
            navegador.quit();


            // Reabrir o navegador para conferência DE ALTERAÇÕES

            nomePessoa2 = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomePessoa2.txt"))) {
                nomePessoa2 = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Driver
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();
            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            // Abrir o o SEG
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

            //ABRIR SGE (CADASTRO DE PESSOA).
            navegador.get("https://app.seg.inf.br/novo/user/sge_base_pessoa");
            // Tempo de espera
            wait = new WebDriverWait(navegador, Duration.ofSeconds(15));
            elemento = wait.until(ExpectedConditions
                    .elementToBeClickable(By.className("avatar")));

            //Pesquisa de Cadastro
            navegador.findElement(By.id("searchInput")).sendKeys(nomePessoa2 + Keys.ENTER);

            //ATUALIZAR PÁGINA DE CADASTRO
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[4]")).click();

            // Selecionar Cadastro
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(-80, 135).doubleClick().perform();
            // Selecionar "Alterar"
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/button[4]")).click();

            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            js = (JavascriptExecutor) navegador;
            mensagensErro = new StringBuilder();

            // "NOME"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -65).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNomeALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Nome está vazio
            if (valorCampoNomeALT == null || valorCampoNomeALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo Nome está vazio.\n");
                System.out.println("ERRO: O campo Nome está vazio.\n");
            } else {
                System.out.println("O campo Nome foi preenchido com: " + valorCampoNomeALT);
            }

            // "APELIDO"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoApelidoALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Apelido está vazio
            if (valorCampoApelidoALT == null || valorCampoApelidoALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo Apelido está vazio.\n");
                System.out.println("ERRO: O campo Apelido está vazio.\n");
            } else {
                System.out.println("O campo Apelido foi preenchido com: " + valorCampoApelidoALT);
            }

            // "CPF"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoCPFALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo CPF está vazio
            if (valorCampoCPFALT == null || valorCampoCPFALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo CPF está vazio.\n");
                System.out.println("ERRO: O campo CPF está vazio.\n");
            } else {
                System.out.println("O campo CPF foi preenchido com: " + valorCampoCPFALT);
            }

            // "PROFISSÃO"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoProfissaoALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Profissão está vazio
            if (valorCampoProfissaoALT == null || valorCampoProfissaoALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo Profissão está vazio.\n");
                System.out.println("ERRO: O campo Profissão está vazio.\n");
            } else {
                System.out.println("O campo Profissão foi preenchido com: " + valorCampoProfissaoALT);
            }

            // "SEXO"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoSexoALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Sexo está vazio
            if (valorCampoSexoALT == null || valorCampoSexoALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo Sexo está vazio.\n");
                System.out.println("ERRO: O campo Sexo está vazio.\n");
            } else {
                System.out.println("O campo Sexo foi preenchido com: " + valorCampoSexoALT);
            }

            Thread.sleep(50);
            new Actions(navegador).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
            Thread.sleep(50);

            // "ESTADO CIVIL"
            Thread.sleep(50);
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorEstadoCivilALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo EstadoCivil está vazio
            if (valorEstadoCivilALT == null || valorEstadoCivilALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo EstadoCivil está vazio.\n");
                System.out.println("ERRO: O campo EstadoCivil está vazio.\n");
            } else {
                System.out.println("O campo EstadoCivil foi preenchido com: " + valorEstadoCivilALT);
            }


            //clique no botão                  "CONTATO"
            Thread.sleep(50);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[3]/div")).click();
            // "CELULAR"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 90).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoCelularALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Celular está vazio
            if (valorCampoCelularALT == null || valorCampoCelularALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo Celular está vazio.\n");
                System.out.println("ERRO: O campo Celular está vazio.\n");
            } else {
                System.out.println("O campo Celular foi preenchido com: " + valorCampoCelularALT);
            }

            // "E-MAIL"
            Thread.sleep(50);
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoEmailALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Email está vazio
            if (valorCampoEmailALT == null || valorCampoEmailALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo Email está vazio.\n");
                System.out.println("ERRO: O campo Email está vazio.\n");
            } else {
                System.out.println("O campo Email foi preenchido com: " + valorCampoEmailALT);
            }


            //clique no botão                "RELIGIOSIDADE"
            Thread.sleep(50);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[4]/div")).click();
            // "RELIGIAO"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -110).click().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoReligiaoALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Religiao está vazio
            if (valorCampoReligiaoALT == null || valorCampoReligiaoALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo Religiao está vazio.\n");
                System.out.println("ERRO: O campo Religiao está vazio.\n");
            } else {
                System.out.println("O campo Religiao foi preenchido com: " + valorCampoReligiaoALT);
            }

            // "PARÓQUIA"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 95).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoParoquiaALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Paroquia está vazio
            if (valorCampoParoquiaALT == null || valorCampoParoquiaALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo Paroquia está vazio.\n");
                System.out.println("ERRO: O campo Paroquia está vazio.\n");
            } else {
                System.out.println("O campo Paroquia foi preenchido com: " + valorCampoParoquiaALT);
            }

            // "CONGREGAÇÃO"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoCongregacaoALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Congregação está vazio
            if (valorCampoCongregacaoALT == null || valorCampoCongregacaoALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo Congregacao está vazio.\n");
                System.out.println("ERRO: O campo Congregacao está vazio.\n");
            } else {
                System.out.println("O campo Congregacao foi preenchido com: " + valorCampoCongregacaoALT);
            }

            // "ATUANTE IGREJA"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoAtuanteIgrejaALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Atuante Igreja está vazio
            if (valorCampoAtuanteIgrejaALT == null || valorCampoAtuanteIgrejaALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo Atuante Igreja está vazio.\n");
                System.out.println("ERRO: O campo Atuante Igreja está vazio.\n");
            } else {
                System.out.println("O campo Atuante Igreja foi preenchido com: " + valorCampoAtuanteIgrejaALT);
            }

            // "PASTORAIS OU SERVIÇOS"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPastoraisouServicosALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Atuante Igreja está vazio
            if (valorCampoPastoraisouServicosALT == null || valorCampoPastoraisouServicosALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo PastoraisouServiços está vazio.\n");
                System.out.println("ERRO: O campo PastoraisouServiços está vazio.\n");
            } else {
                System.out.println("O campo PastoraisouServiços Igreja foi preenchido com: " + valorCampoPastoraisouServicosALT);
            }

            // "MOVIMENTO QUE FREQUENTA"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMovqueFrequentaALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Movimento que Frequenta está vazio
            if (valorCampoMovqueFrequentaALT == null || valorCampoMovqueFrequentaALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo MovimentoqueFrequenta está vazio.\n");
                System.out.println("ERRO: O campo MovimentoqueFrequenta está vazio.\n");
            } else {
                System.out.println("O campo MovimentoqueFrequenta Igreja foi preenchido com: " + valorCampoMovqueFrequentaALT);
            }

            // "SEITA, IDEOLOGIA OU RELIGIÃO QUE FREQUENTA"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoSeitaIdeologiaReligiaoALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Movimento que Frequenta está vazio
            if (valorCampoSeitaIdeologiaReligiaoALT == null || valorCampoSeitaIdeologiaReligiaoALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo SeitaIdeologiaReligiao está vazio.\n");
                System.out.println("ERRO: O campo SeitaIdeologiaReligiao está vazio.\n");
            } else {
                System.out.println("O campo SeitaIdeologiaReligiao Igreja foi preenchido com: " + valorCampoSeitaIdeologiaReligiaoALT);
            }

            // "ENTIDADE QUE FREQUENTA"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoEntidadequefrequentaALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Movimento que Frequenta está vazio
            if (valorCampoEntidadequefrequentaALT == null || valorCampoEntidadequefrequentaALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo Entidadequefrequenta está vazio.\n");
                System.out.println("ERRO: O campo Entidadequefrequenta está vazio.\n");
            } else {
                System.out.println("O campo Entidadequefrequenta Igreja foi preenchido com: " + valorCampoEntidadequefrequentaALT);
            }


            //clique no botão                                    "OUTROS"
            Thread.sleep(50);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[5]/div")).click();
            // "Número Etapa 1"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 65).click().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNumeroEtapa1ALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo NumeroEtapa1 está vazio
            if (valorCampoNumeroEtapa1ALT == null || valorCampoNumeroEtapa1ALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo NumeroEtapa1 está vazio.\n");
                System.out.println("ERRO: O campo NumeroEtapa1 está vazio.\n");
            } else {
                System.out.println("O campo NumeroEtapa1 foi preenchido com: " + valorCampoNumeroEtapa1ALT);
            }

            // "Data Início Etapa 1"
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 20).click().sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDataInicioEtapa1ALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo NumeroEtapa1 está vazio
            if (valorCampoDataInicioEtapa1ALT == null || valorCampoDataInicioEtapa1ALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo DataInicioEtapa1 está vazio.\n");
                System.out.println("ERRO: O campo DataInicioEtapa1 está vazio.\n");
            } else {
                System.out.println("O campo DataInicioEtapa1 foi preenchido com: " + valorCampoDataInicioEtapa1ALT);
            }

            // "Local Etapa 1"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalEtapa1ALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo LocalEtapa1 está vazio
            if (valorCampoLocalEtapa1ALT == null || valorCampoLocalEtapa1ALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo LocalEtapa1 está vazio.\n");
                System.out.println("ERRO: O campo LocalEtapa1 está vazio.\n");
            } else {
                System.out.println("O campo LocalEtapa1 foi preenchido com: " + valorCampoLocalEtapa1ALT);
            }

            // "Núcleo Sigla Etapa 1"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNucleoSiglaEtapa1ALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo LocalEtapa1 está vazio
            if (valorCampoNucleoSiglaEtapa1ALT == null || valorCampoNucleoSiglaEtapa1ALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo NucleoSiglaEtapa1 está vazio.\n");
                System.out.println("ERRO: O campo NucleoSiglaEtapa1 está vazio.\n");
            } else {
                System.out.println("O campo NucleoSiglaEtapa1 foi preenchido com: " + valorCampoNucleoSiglaEtapa1ALT);
            }

            // "Número Etapa 2"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNumeroEtapa2ALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo NumeroEtapa2 está vazio
            if (valorCampoNumeroEtapa2ALT == null || valorCampoNumeroEtapa2ALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo NumeroEtapa2 está vazio.\n");
                System.out.println("ERRO: O campo NumeroEtapa2 está vazio.\n");
            } else {
                System.out.println("O campo NumeroEtapa2 foi preenchido com: " + valorCampoNumeroEtapa2ALT);
            }

            // "Data Início Etapa 2"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDataInicioEtapa2ALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo NumeroEtapa2 está vazio
            if (valorCampoDataInicioEtapa2ALT == null || valorCampoDataInicioEtapa2ALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo DataInicioEtapa2 está vazio.\n");
                System.out.println("ERRO: O campo DataInicioEtapa2 está vazio.\n");
            } else {
                System.out.println("O campo DataInicioEtapa2 foi preenchido com: " + valorCampoDataInicioEtapa2ALT);
            }

            // "Local Etapa 2"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalEtapa2ALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo LocalEtapa1 está vazio
            if (valorCampoLocalEtapa2ALT == null || valorCampoLocalEtapa2ALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo LocalEtapa2 está vazio.\n");
                System.out.println("ERRO: O campo LocalEtapa2 está vazio.\n");
            } else {
                System.out.println("O campo LocalEtapa2 foi preenchido com: " + valorCampoLocalEtapa2ALT);
            }

            // "Núcleo Sigla Etapa 2"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNucleoSiglaEtapa2ALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo LocalEtapa2 está vazio
            if (valorCampoNucleoSiglaEtapa2ALT == null || valorCampoNucleoSiglaEtapa2ALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo NucleoSiglaEtapa2 está vazio.\n");
                System.out.println("ERRO: O campo NucleoSiglaEtapa2 está vazio.\n");
            } else {
                System.out.println("O campo NucleoSiglaEtapa2 foi preenchido com: " + valorCampoNucleoSiglaEtapa2ALT);
            }

            // "Número Etapa 3"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNumeroEtapa3ALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo NumeroEtapa3 está vazio
            if (valorCampoNumeroEtapa3ALT == null || valorCampoNumeroEtapa3ALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo NumeroEtapa3 está vazio.\n");
                System.out.println("ERRO: O campo NumeroEtapa3 está vazio.\n");
            } else {
                System.out.println("O campo NumeroEtapa3 foi preenchido com: " + valorCampoNumeroEtapa3ALT);
            }


            // "Data Início Etapa 3"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDataInicioEtapa3ALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo DataInicioEtapa3 está vazio
            if (valorCampoDataInicioEtapa3ALT == null || valorCampoDataInicioEtapa3ALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo DataInicioEtapa3 está vazio.\n");
                System.out.println("ERRO: O campo DataInicioEtapa3 está vazio.\n");
            } else {
                System.out.println("O campo DataInicioEtapa3 foi preenchido com: " + valorCampoDataInicioEtapa3ALT);
            }

            // "Local Etapa 3"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalEtapa3ALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo LocalEtapa1 está vazio
            if (valorCampoLocalEtapa3ALT == null || valorCampoLocalEtapa3ALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo LocalEtapa3 está vazio.\n");
                System.out.println("ERRO: O campo LocalEtapa3 está vazio.\n");
            } else {
                System.out.println("O campo LocalEtapa3 foi preenchido com: " + valorCampoLocalEtapa3ALT);
            }

            // "Núcleo Sigla Etapa 3"
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNucleoSiglaEtapa3ALT = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo NucleoSiglaEtapa3 está vazio
            if (valorCampoNucleoSiglaEtapa3ALT == null || valorCampoNucleoSiglaEtapa3ALT.isEmpty()) {
                mensagensErro.append("ERRO: O campo NucleoSiglaEtapa3 está vazio.\n");
                System.out.println("ERRO: O campo NucleoSiglaEtapa3 está vazio.\n");
            } else {
                System.out.println("O campo NucleoSiglaEtapa3 foi preenchido com: " + valorCampoNucleoSiglaEtapa3ALT);
            }

            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta2 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pessoas//erros log alt//erros";
            String caminhoArquivo2 = caminhoPasta2 + "erroslogALT" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta2);
                if (!pasta.exists()) {
                    pasta.mkdirs();
                }

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo2, true))) {
                    writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                    writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                }


                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo2);
            } catch (IOException e) {
                System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
            }

            // Excluir cadastro após testes realizados
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/button[5]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/button[5]")).click();
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();

            //Pausa antes de reiniciar processo.
            Thread.sleep(1500);
            //FECHAR NAVEGADOR
            // Finalizar navegador ao final de cada execução
            {navegador.quit();}
        }
    }
}


