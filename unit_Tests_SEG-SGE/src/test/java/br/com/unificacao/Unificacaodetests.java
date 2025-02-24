package br.com.unificacao;

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
public class Unificacaodetests {
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
            Thread.sleep(200);
            new Actions(navegador).moveByOffset(0, 85).click().sendKeys(nomePessoa1).sendKeys(Keys.TAB).perform();//NOME
            new Actions(navegador).sendKeys(apelido).sendKeys(Keys.TAB).perform();//APELIDO
            new Actions(navegador).sendKeys(cpf).sendKeys(Keys.TAB).perform();//CPF
            new Actions(navegador).sendKeys(profissao).sendKeys(Keys.TAB).perform(); //PROFISSÃO
            new Actions(navegador).sendKeys(genero).sendKeys(Keys.TAB).perform(); //SEXO
            Thread.sleep(200);
            new Actions(navegador).sendKeys("11112000").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();//NASCIMENTO
            Thread.sleep(200);
            new Actions(navegador).sendKeys(estadocivil).sendKeys(Keys.TAB).perform();//ESTADO CIVIL
            new Actions(navegador).moveByOffset(0, 200).click().perform();//CLICAR NO BOTÃO "ATIVO"
            new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO BOTÃO "PESSOA FÍSICA"

            //clique no botão                  "CONTATO"
            Thread.sleep(200);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[3]/div")).click();
            new Actions(navegador).moveByOffset(0, -120).click().sendKeys(celular).sendKeys(Keys.TAB).perform();//CELULAR
            new Actions(navegador).sendKeys(email).perform();//E-MAIL

            //clique no botão                "RELIGIOSIDADE"
            Thread.sleep(200);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[4]/div")).click();
            new Actions(navegador).moveByOffset(0, -145).click().sendKeys(religiao).sendKeys(Keys.ENTER).perform();//RELIGIÃO
            new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO BOTÃO "BATISMO"
            new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO BOTÃO "COMUNHÃO"
            new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO BOTÃO "CRISMA"
            new Actions(navegador).moveByOffset(0, 30).click().sendKeys(paroquia).sendKeys(Keys.TAB).perform();//PARÓQUIA
            new Actions(navegador).sendKeys("xxxxx1").sendKeys(Keys.TAB).perform();//CONGREGAÇÃO
            new Actions(navegador).sendKeys("xxxxx2").sendKeys(Keys.TAB).perform();//ATUANTE IGREJA
            new Actions(navegador).sendKeys("xxxxx3").sendKeys(Keys.TAB).perform();//PASTORAIS OU SERVIÇOS
            new Actions(navegador).sendKeys("xxxxx4").sendKeys(Keys.TAB).perform();//MOVIMENTO QUE FREQUENTA
            new Actions(navegador).sendKeys("xxxxx5").sendKeys(Keys.TAB).perform();//SEITA, IDEOLOGIA OU RELIGIÃO QUE FREQUENTA
            new Actions(navegador).sendKeys("xxxxx6").perform();//ENTIDADE QUE FREQUENTA


            //clique no botão                 "OUTROS"
            Thread.sleep(200);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[5]/div")).click();
            navegador.findElement(By.xpath("//*[@id=\"sge_pessoa.modal.sge_pessoa_cadastro.undefined\"]/div")).click();
            new Actions(navegador).moveByOffset(0, -35).click().perform();//CLICAR NO BOTÃO AUTORIZA "E-MAIL" (Relatório)
            new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO BOTÃO AUTORIZA CELULAR (Relatório)
            new Actions(navegador).moveByOffset(0, 30).click().perform();//CLICAR NO BOTÃO AUTORIZA TEL RESIDENCIAL (Relatório)
            Thread.sleep(100);
            new Actions(navegador).moveByOffset(-80, 50).click().sendKeys("11112020").perform();//DATA DE VIGOR
            Thread.sleep(100);
            new Actions(navegador).moveByOffset(-50, 30).click().perform();//SELECIONAR ETAPA "1"
            new Actions(navegador).moveByOffset(120, -60).click().perform();//SELECIONAR ETAPA "2"
            new Actions(navegador).moveByOffset(120, -45).click().perform();//SELECIONAR ETAPA "3"
            new Actions(navegador).moveByOffset(0, 50).click().sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("1").sendKeys(Keys.TAB).perform();//NÚMERO DA ETAPA 1.
            Thread.sleep(100);
            new Actions(navegador).sendKeys("01012020").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA DE INÍCIO DA ETAPA 1
            Thread.sleep(100);
            new Actions(navegador).sendKeys("xxxxx7").sendKeys(Keys.TAB).perform();// LOCAL ETAPA 1
            new Actions(navegador).sendKeys("xXXXx8").sendKeys(Keys.TAB).perform();// NÚCLEO SIGLA ETAPA 1
            new Actions(navegador).sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("2").sendKeys(Keys.TAB).perform();//NÚMERO DA ETAPA 2
            Thread.sleep(100);
            new Actions(navegador).sendKeys("01012020").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA DE INÍCIO DA ETAPA 2
            Thread.sleep(100);
            new Actions(navegador).sendKeys("xxxxx9").sendKeys(Keys.TAB).perform();// LOCAL ETAPA 2
            new Actions(navegador).sendKeys("xXXXx10").sendKeys(Keys.TAB).perform();// NÚCLEO SIGLA ETAPA 2
            new Actions(navegador).sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("3").sendKeys(Keys.TAB).perform();//NÚMERO DA ETAPA 3
            Thread.sleep(100);
            new Actions(navegador).sendKeys("01012020").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA DE INÍCIO DA ETAPA 3
            Thread.sleep(100);
            new Actions(navegador).sendKeys("xxxxx11").sendKeys(Keys.TAB).perform();// LOCAL ETAPA 3
            new Actions(navegador).sendKeys("xXXXx12").perform();// NÚCLEO SIGLA ETAPA 3
            Thread.sleep(100);

            //                         "SALVAR CADASTRO"
            Thread.sleep(500);
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
            Thread.sleep(300);
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
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[3]/div")).click();
            // "CELULAR"
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
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[4]/div")).click();

            // "RELIGIAO"
            Thread.sleep(300);
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
            Thread.sleep(200);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[5]/div")).click();

            // "Número Etapa 1"
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
            Thread.sleep(500);
            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta1 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pessoas//erros log//erros";
            String caminhoArquivo1 = caminhoPasta1 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta1);
                if (!pasta.exists()) {
                    boolean mkdirs = pasta.mkdirs();
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
            new Actions(navegador).moveByOffset(0, -115).doubleClick().sendKeys(Keys.BACK_SPACE).sendKeys(nomePessoa2).sendKeys(Keys.TAB).perform();//NOME
            new Actions(navegador).sendKeys(apelido2).sendKeys(Keys.TAB).perform();//APELIDO
            new Actions(navegador).sendKeys(cpf2).sendKeys(Keys.TAB).perform();//CPF
            new Actions(navegador).sendKeys(profissao2).sendKeys(Keys.TAB).perform();//PROFISSÃO
            new Actions(navegador).sendKeys(genero2).sendKeys(Keys.TAB).perform();//SEXO
            Thread.sleep(200);
            new Actions(navegador).sendKeys("11112000").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();//NASCIMENTO
            Thread.sleep(200);
            new Actions(navegador).sendKeys(estadocivil2).sendKeys(Keys.ENTER).perform();//ESTADO CIVIL
            new Actions(navegador).moveByOffset(0, 245).click().perform();//FICHA FÍSICA

            //clique no botão                   "CONTATO"
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[3]/div")).click();
            new Actions(navegador).moveByOffset(0, -155).doubleClick().sendKeys(celular2).perform();//CELULAR
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(email2).perform();//E-MAIL

            //clique no botão                "RELIGIOSIDADE"
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[4]/div")).click();
            new Actions(navegador).moveByOffset(0, -170).doubleClick().click().sendKeys(religiao2).sendKeys(Keys.ENTER).perform();//RELIGIÃO
            new Actions(navegador).moveByOffset(0, 115).doubleClick().click().sendKeys(paroquia2).sendKeys(Keys.TAB).perform();//PAROQUIA
            new Actions(navegador).sendKeys("aaaaa1").sendKeys(Keys.TAB).perform();//CONGREGAÇÃO
            new Actions(navegador).sendKeys("aaaaa2").sendKeys(Keys.TAB).perform();//ATUANTE IGREJA
            new Actions(navegador).sendKeys("aaaaa3").sendKeys(Keys.TAB).perform();//PASTORAIS OU SERVIÇOS
            new Actions(navegador).sendKeys("aaaaa4").sendKeys(Keys.TAB).perform();//MOVIMENTO QUE FREQUENTA
            new Actions(navegador).sendKeys("aaaaa5").sendKeys(Keys.TAB).perform();//SEITA, IDEOLOGIA OU RELIGIÃO QUE FREQUENTA
            new Actions(navegador).sendKeys("aaaaa6").perform();//ENTIDADE QUE FREQUENTA

            //clique no botão                 "OUTROS"
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[5]/div")).click();
            new Actions(navegador).moveByOffset(0, 30).click().sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("4").sendKeys(Keys.TAB).perform();//NÚMERO DA ETAPA 1
            Thread.sleep(100);
            new Actions(navegador).sendKeys("10022021").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA DE INÍCIO DA ETAPA 1
            Thread.sleep(100);
            new Actions(navegador).sendKeys("aaaaa7").sendKeys(Keys.TAB).perform();// LOCAL ETAPA 1
            new Actions(navegador).sendKeys("aaaaa8").sendKeys(Keys.TAB).perform();// NÚCLEO SIGLA ETAPA 1
            new Actions(navegador).sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("5").sendKeys(Keys.TAB).perform();//NÚMERO DA ETAPA 2
            Thread.sleep(100);
            new Actions(navegador).sendKeys("10022021").sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA INÍCIO DA ETAPA 2
            Thread.sleep(100);
            new Actions(navegador).sendKeys("aaaaa9").sendKeys(Keys.TAB).perform();// LOCAL ETAPA 2
            new Actions(navegador).sendKeys("aaaaa10").sendKeys(Keys.TAB).perform();// NÚCLEO SIGLA ETAPA 2
            new Actions(navegador).sendKeys("A").sendKeys(Keys.BACK_SPACE).sendKeys("6").sendKeys(Keys.TAB).perform();//NÚMERO DA ETAPA 3
            Thread.sleep(100);
            new Actions(navegador).sendKeys("10022021").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// DATA INÍCIO ETAPA 3
            Thread.sleep(100);
            new Actions(navegador).sendKeys("aaaaa11").sendKeys(Keys.TAB).perform();// LOCAL ETAPA 3
            new Actions(navegador).sendKeys("aaaaa12").perform();// NÚCLEO SIGLA ETAPA 3

            //                         "SALVAR CADASTRO"
            Thread.sleep(600);
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
            Thread.sleep(500);
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
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[3]/div")).click();
            // "CELULAR"
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
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[4]/div")).click();

            // "RELIGIAO"
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
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div/div[1]/div/div[5]/div")).click();
            // "Número Etapa 1"
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
            Thread.sleep(500);
            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta2 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pessoas//erros log alt//erros";
            String caminhoArquivo2 = caminhoPasta2 + "erroslogALT" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta2);
                if (!pasta.exists()) {
                    boolean mkdirs = pasta.mkdirs();
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
            Thread.sleep(500);
            //FECHAR NAVEGADOR
            // Finalizar navegador ao final de cada execução
            {navegador.quit();}



// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// /////////////////////////////////////////////////////////////CADASTRO DE PARÓQUIA////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // Criar nome aleatório para o cadastro
            random = new Random();
            String nomeParoquia = "TestParoquia" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomeParoquia.txt")) {
                writer.write(nomeParoquia);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // CRIAR NOME ALEATÓRIO PARA ALTERAÇÃO DE CADASTRO
            String nomeParoquia2 = "TestParoquiaAlt" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomeParoquia2.txt")) {
                writer.write(nomeParoquia2);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Configurar o WebDriver
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();

            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            js = (JavascriptExecutor) navegador;
            mensagensErro = new StringBuilder();

            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            try {
                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("KELDER.TESTE");
                navegador.findElement(By.id("home.login.senha")).sendKeys("12345678");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div")).click();
                Thread.sleep(250);

                //SELECIONAR ENTIDADE
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_paroquia");

                // Gerar dados dinâmicos
                String sigla = "TSTPSWD" + random.nextInt(100);
                String telefone = "619" + (10000000 + random.nextInt(89999999));
                String emailPar1 = nomeParoquia.toLowerCase() + "tstpswd@gmail.com";
                String instagram = "tstpswd" + nomeParoquia.toLowerCase();
                String facebook = "tstpswd" + nomeParoquia.toLowerCase();

                // Iniciar cadastro
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[1]")).click();

                // Preencher os campos
                Thread.sleep(250);
                new Actions(navegador).moveByOffset(-100, -80).click().sendKeys(nomeParoquia).sendKeys(Keys.TAB).perform();//NOME
                new Actions(navegador).sendKeys("Brasília").sendKeys(Keys.TAB).perform();//ARQUIDIOCESE
                new Actions(navegador).sendKeys(sigla).sendKeys(Keys.TAB).perform();//SIGLA
                new Actions(navegador).sendKeys("CENTRO").sendKeys(Keys.TAB).perform();//VICARIATO PARÓQUIA
                new Actions(navegador).sendKeys("X").sendKeys(Keys.TAB).perform();//SETOR PARÓQUIA
                Thread.sleep(500);
                new Actions(navegador).sendKeys("71828650").sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();//CEP
                Thread.sleep(500);
                new Actions(navegador).sendKeys(telefone).sendKeys(Keys.TAB).perform();//ENDEREÇO
                new Actions(navegador).sendKeys(telefone).sendKeys(Keys.TAB).perform();//BAIRRO
                new Actions(navegador).sendKeys(telefone).sendKeys(Keys.TAB).perform();//CIDADE
                new Actions(navegador).sendKeys(emailPar1).sendKeys(Keys.TAB).perform();//UF
                new Actions(navegador).sendKeys("www." + nomeParoquia.toLowerCase() + ".com.br").sendKeys(Keys.TAB).perform();//TELEFONE
                new Actions(navegador).sendKeys(instagram).sendKeys(Keys.TAB).perform();//TELEFONE 2
                new Actions(navegador).sendKeys(facebook).perform();//WHATSAPP

                // Salvar Cadastro
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[2]")).click();
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[2]")).click();
                Thread.sleep(500);

                // Capturar screenshot para análise
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Paróquias//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                navegador.quit();
            }

            // Espera antes de iniciar o próximo ciclo
            Thread.sleep(500);


            // " CONFERENCIA" \\
            nomeParoquia = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomeParoquia.txt"))) {
                nomeParoquia = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }


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
                navegador.findElement(By.id("home.login.login")).sendKeys("KELDER.TESTE");
                navegador.findElement(By.id("home.login.senha")).sendKeys("12345678");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div")).click();
                Thread.sleep(500);

                //SELECIONAR ENTIDADE
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_paroquia");

                //ATUALIZAR PÁGINA DE CADASTRO
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(600);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();


                //Pesquisa de Cadastro
                Thread.sleep(400);
                navegador.findElement(By.id("searchInput")).sendKeys(nomeParoquia + Keys.ENTER);

                // Selecionar Cadastro
                Thread.sleep(700);
                new Actions(navegador).moveByOffset(-100, 140).doubleClick().perform();

                // Selecionar "Alterar"
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[3]")).click();
                Thread.sleep(400);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();

                // NOME PARÓQUIA
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, -225).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Paróquia está vazio
                if (valorCampoNomeParoquia == null || valorCampoNomeParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Nome Paróquia está vazio.\n");
                    System.out.println("ERRO: O campo Nome Paróquia está vazio.\n");
                } else {
                    System.out.println("O campo Nome Paróquia foi preenchido com: " + valorCampoNomeParoquia);
                }

                // ARQUIDIOCESE
                new Actions(navegador).moveByOffset(0, 25).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoArquidiocese = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Arquidiocese está vazio
                if (valorCampoArquidiocese == null || valorCampoArquidiocese.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Arquidiocese está vazio.\n");
                    System.out.println("ERRO: O campo Arquidiocese está vazio.\n");
                } else {
                    System.out.println("O campo Arquidiocese foi preenchido com: " + valorCampoArquidiocese);
                }

                //SIGLA
                new Actions(navegador).moveByOffset(0, 25).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSigla = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSigla == null || valorCampoSigla.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Sigla está vazio.\n");
                    System.out.println("ERRO: O campo Sigla está vazio.\n");
                } else {
                    System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla);
                }

                //VICARIATO PARÓQUIA
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoVicariatoParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoVicariatoParoquia == null || valorCampoVicariatoParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Vicariato Paroquia está vazio.\n");
                    System.out.println("ERRO: O campo Vicariato Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Vicariato Paroquia foi preenchido com: " + valorCampoVicariatoParoquia);
                }

                //SETOR PARÓQUIA
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSetorParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoSetorParoquia == null || valorCampoSetorParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Setor Paroquia está vazio.\n");
                    System.out.println("ERRO: O campo Setor Paroquia Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Setor Paroquia foi preenchido com: " + valorCampoSetorParoquia);
                }

                //CEP
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoCEP = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoCEP == null || valorCampoCEP.isEmpty()) {
                    mensagensErro.append("ERRO: O campo CEP está vazio.\n");
                    System.out.println("ERRO: O campo CEP Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo CEP foi preenchido com: " + valorCampoCEP);
                }

                //ENDEREÇO
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEndereco = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoEndereco == null || valorCampoEndereco.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Endereço está vazio.\n");
                    System.out.println("ERRO: O campo Endereço Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Endereço foi preenchido com: " + valorCampoEndereco);
                }

                //BAIRRO
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoBairro = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoBairro == null || valorCampoBairro.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Bairro está vazio.\n");
                    System.out.println("ERRO: O campo Bairro Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Bairro foi preenchido com: " + valorCampoBairro);
                }

                //CIDADE
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoCidade = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoCidade == null || valorCampoCidade.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Cidade está vazio.\n");
                    System.out.println("ERRO: O campo Cidade Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Cidade foi preenchido com: " + valorCampoCidade);
                }

                //UF
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoUF = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoUF == null || valorCampoUF.isEmpty()) {
                    mensagensErro.append("ERRO: O campo UF está vazio.\n");
                    System.out.println("ERRO: O campo UF Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo UF foi preenchido com: " + valorCampoUF);
                }

                //TELEFONE
                new Actions(navegador).moveByOffset(0, 35).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTelefone = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoTelefone == null || valorCampoTelefone.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Telefone está vazio.\n");
                    System.out.println("ERRO: O campo Telefone Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Telefone foi preenchido com: " + valorCampoTelefone);
                }

                //TELEFONE 2
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTelefone2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoTelefone2 == null || valorCampoTelefone2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Telefone 2 está vazio.\n");
                    System.out.println("ERRO: O campo Telefone 2 Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Telefone 2 foi preenchido com: " + valorCampoTelefone2);
                }

                //WHATSAPP
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoWhatsapp = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoWhatsapp == null || valorCampoWhatsapp.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Whatsapp está vazio.\n");
                    System.out.println("ERRO: O campo Whatsapp Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Whatsapp foi preenchido com: " + valorCampoWhatsapp);
                }

                //E-MAIL
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEmailPar1 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoEmailPar1 == null || valorCampoEmailPar1.isEmpty()) {
                    mensagensErro.append("ERRO: O campo E-mail está vazio.\n");
                    System.out.println("ERRO: O campo E-mail Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo E-mail foi preenchido com: " + valorCampoEmailPar1);
                }

                //SITE
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSite = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoSite == null || valorCampoSite.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Site está vazio.\n");
                    System.out.println("ERRO: O campo Site Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Site foi preenchido com: " + valorCampoSite);
                }

                //INSTAGRAM
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoInstagram = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoInstagram == null || valorCampoInstagram.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Instagram está vazio.\n");
                    System.out.println("ERRO: O campo Instagram Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Instagram foi preenchido com: " + valorCampoInstagram);
                }

                //FACEBOOK
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFacebook = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoFacebook == null || valorCampoFacebook.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Facebook está vazio.\n");
                    System.out.println("ERRO: O campo Facebook Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Facebook foi preenchido com: " + valorCampoFacebook);
                }


                // DEFINIR O CAMINHO E NOME DO ARQUIVO
                Thread.sleep(50);
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Paróquias//erros log//erros";
                String caminhoArquivo = caminhoPasta + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {

                    // CRIAR A PASTA CASO NÃO EXISTA
                    File pasta = new File(caminhoPasta);
                    if (!pasta.exists()) {
                        boolean mkdirs = pasta.mkdirs();
                    }

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }


                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo);
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }
                Thread.sleep(500);


                //ALTERAÇÃO DE DADOS\\

                // Criar nome aleatório para o cadastro


                // GERAÇÃO DE DADOS DINÂMICOS
                String sigla2 = "TSTPSWDALT" + random.nextInt(1000);
                String telefone2 = "619" + (10000000 + random.nextInt(89999999));
                String telefone3 = "619" + (10000000 + random.nextInt(89999999));
                String telefone4 = "619" + (10000000 + random.nextInt(89999999));
                String emailPar = nomeParoquia2.toLowerCase() + "tstpswd@gmail.com";
                String instagram2 = "tstpswd" + nomeParoquia2.toLowerCase();
                String facebook2 = "tstpswd" + nomeParoquia2.toLowerCase();


                // INICIO DE CICLO DE ALTERAÇÃO
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, -480).doubleClick().click().sendKeys(nomeParoquia2).perform();//NOME
                new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(Keys.BACK_SPACE)//ARQUIDIOCESE
                        .sendKeys("BRASÍLIA").sendKeys(Keys.TAB).perform();
                new Actions(navegador).moveByOffset(0, 30).sendKeys(Keys.BACK_SPACE).sendKeys(sigla2).perform();//SIGLA
                new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(Keys.BACK_SPACE).sendKeys("CENTRO").perform();//VICARIATO PARÓQUIA
                new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys("I").sendKeys(Keys.TAB).perform();//SETOR PARÓQUIA
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 25).doubleClick().click().sendKeys(Keys.BACK_SPACE)//CEP
                        .sendKeys("70050-000").sendKeys(Keys.ENTER).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                        .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 150).sendKeys(Keys.BACK_SPACE).sendKeys(telefone2).sendKeys(Keys.TAB).perform();//TELEFONE
                new Actions(navegador).moveByOffset(0, 30).sendKeys(Keys.BACK_SPACE).sendKeys(telefone3).sendKeys(Keys.TAB).perform();//TELEFONE 2
                new Actions(navegador).moveByOffset(0, 30).sendKeys(Keys.BACK_SPACE).sendKeys(telefone4).sendKeys(Keys.TAB).perform();//WHATSAPP
                new Actions(navegador).moveByOffset(0, 30).sendKeys(Keys.BACK_SPACE).sendKeys(emailPar).sendKeys(Keys.TAB).perform();//EMAIL
                new Actions(navegador).moveByOffset(0, 30).sendKeys(Keys.BACK_SPACE).sendKeys//SITE
                        ("www." + nomeParoquia2.toLowerCase() + ".com.br").sendKeys(Keys.TAB).perform();
                new Actions(navegador).moveByOffset(0, 35).sendKeys(Keys.BACK_SPACE).sendKeys(instagram2).sendKeys(Keys.TAB).perform();//INSTAGRAM
                new Actions(navegador).moveByOffset(0, 35).sendKeys(Keys.BACK_SPACE).sendKeys(facebook2).sendKeys(Keys.TAB).perform();//FACEBOOK

                // SALVAR CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[2]")).click();
                Thread.sleep(1000);

                // CAPTURAR SCREENSHOT PARA ANÁLISE
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Paróquias//Cadastro Alt//resultado_teste_alt" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                navegador.quit();
            }


            // "REABRIR O NAVEGADOR PARA CONFERENCIA" \\

            nomeParoquia2 = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomeParoquia2.txt"))) {
                nomeParoquia2 = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // CONFIGURAR O WEBDRIVER
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();

            // DEFINIÇÃO DA JANELA DO NAVEGAÇÃO
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            try {
                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                // LOGIN E SENHA
                navegador.findElement(By.id("home.login.login")).sendKeys("KELDER.TESTE");
                navegador.findElement(By.id("home.login.senha")).sendKeys("12345678");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div")).click();
                Thread.sleep(250);

                //SELECIONAR ENTIDADE
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // ABRIR SEG (CADASTRO DE PARÓQUIA)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_paroquia");

                //PESQUISA DE CADASTRO
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys(nomeParoquia2 + Keys.ENTER);

                //ATUALIZAR PÁGINA DE CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[3]")).click();

                // SELECIONAR CADASTRO
                Thread.sleep(600);
                new Actions(navegador).moveByOffset(-120, 140).doubleClick().perform();

                // SELECIONAR "ALTERAR"
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[3]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();


                // Nome Paróquia
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(-20, -230).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Paróquia está vazio
                if (valorCampoNomeParoquia == null || valorCampoNomeParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Nome Paróquia está vazio.\n");
                    System.out.println("ERRO: O campo Nome Paróquia está vazio.\n");
                } else {
                    System.out.println("O campo Nome Paróquia foi preenchido com: " + valorCampoNomeParoquia);
                }

                // Arquidiocese
                new Actions(navegador).moveByOffset(0, 25).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoArquidiocese = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Arquidiocese está vazio
                if (valorCampoArquidiocese == null || valorCampoArquidiocese.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Arquidiocese está vazio.\n");
                    System.out.println("ERRO: O campo Arquidiocese está vazio.\n");
                } else {
                    System.out.println("O campo Arquidiocese foi preenchido com: " + valorCampoArquidiocese);
                }

                //Sigla
                new Actions(navegador).moveByOffset(0, 25).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSigla = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSigla == null || valorCampoSigla.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Sigla está vazio.\n");
                    System.out.println("ERRO: O campo Sigla está vazio.\n");
                } else {
                    System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla);
                }

                //Vicariato Paroquia
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoVicariatoParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoVicariatoParoquia == null || valorCampoVicariatoParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Vicariato Paroquia está vazio.\n");
                    System.out.println("ERRO: O campo Vicariato Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Vicariato Paroquia foi preenchido com: " + valorCampoVicariatoParoquia);
                }

                //Setor Paroquia
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSetorParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoSetorParoquia == null || valorCampoSetorParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Setor Paroquia está vazio.\n");
                    System.out.println("ERRO: O campo Setor Paroquia Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Setor Paroquia foi preenchido com: " + valorCampoSetorParoquia);
                }

                //CEP
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoCEP = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoCEP == null || valorCampoCEP.isEmpty()) {
                    mensagensErro.append("ERRO: O campo CEP está vazio.\n");
                    System.out.println("ERRO: O campo CEP Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo CEP foi preenchido com: " + valorCampoCEP);
                }

                //Endereço
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEndereco = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoEndereco == null || valorCampoEndereco.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Endereço está vazio.\n");
                    System.out.println("ERRO: O campo Endereço Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Endereço foi preenchido com: " + valorCampoEndereco);
                }

                //Bairro
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoBairro = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoBairro == null || valorCampoBairro.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Bairro está vazio.\n");
                    System.out.println("ERRO: O campo Bairro Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Bairro foi preenchido com: " + valorCampoBairro);
                }

                //Cidade
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoCidade = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoCidade == null || valorCampoCidade.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Cidade está vazio.\n");
                    System.out.println("ERRO: O campo Cidade Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Cidade foi preenchido com: " + valorCampoCidade);
                }

                //UF
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoUF = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoUF == null || valorCampoUF.isEmpty()) {
                    mensagensErro.append("ERRO: O campo UF está vazio.\n");
                    System.out.println("ERRO: O campo UF Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo UF foi preenchido com: " + valorCampoUF);
                }

                //Telefone
                new Actions(navegador).moveByOffset(0, 35).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTelefone = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoTelefone == null || valorCampoTelefone.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Telefone está vazio.\n");
                    System.out.println("ERRO: O campo Telefone Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Telefone foi preenchido com: " + valorCampoTelefone);
                }

                //Telefone 2
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTelefone2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoTelefone2 == null || valorCampoTelefone2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Telefone 2 está vazio.\n");
                    System.out.println("ERRO: O campo Telefone 2 Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Telefone 2 foi preenchido com: " + valorCampoTelefone2);
                }

                //Whatsapp
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoWhatsapp = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoWhatsapp == null || valorCampoWhatsapp.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Whatsapp está vazio.\n");
                    System.out.println("ERRO: O campo Whatsapp Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Whatsapp foi preenchido com: " + valorCampoWhatsapp);
                }

                //E-mail
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEmailPar = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoEmailPar == null || valorCampoEmailPar.isEmpty()) {
                    mensagensErro.append("ERRO: O campo E-mail está vazio.\n");
                    System.out.println("ERRO: O campo E-mail Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo E-mail foi preenchido com: " + valorCampoEmailPar);
                }

                //Site
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSite = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoSite == null || valorCampoSite.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Site está vazio.\n");
                    System.out.println("ERRO: O campo Site Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Site foi preenchido com: " + valorCampoSite);
                }

                // Instagram
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoInstagram = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoInstagram == null || valorCampoInstagram.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Instagram está vazio.\n");
                    System.out.println("ERRO: O campo Instagram Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Instagram foi preenchido com: " + valorCampoInstagram);
                }

                // Facebook
                new Actions(navegador).moveByOffset(0, 30).click().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFacebook = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoFacebook == null || valorCampoFacebook.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Facebook está vazio.\n");
                    System.out.println("ERRO: O campo Facebook Paroquia está vazio.\n");
                } else {
                    System.out.println("O campo Facebook foi preenchido com: " + valorCampoFacebook);
                }

                // EXCLUIR
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[4]")).click();
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
                Thread.sleep(250);

                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta4 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Paróquias//erros log alt//erros";
                String caminhoArquivo4 = caminhoPasta4 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo
                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta4);
                    if (!pasta.exists()) {
                        boolean mkdirs = pasta.mkdirs();
                    }

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo4, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo4);
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }
                Thread.sleep(500);

                //FECHAR NAVEGADOR
                // Finalizar navegador ao final de cada execução
                {
                    navegador.quit();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// /////////////////////////////////////////////////////////////CADASTRO DE PASTORAL////////////////////////////////////////////////////////////////////////
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


            // Criar nome aleatório para o cadastro
            String nomePastoral = "TestPastoralSWD" + random.nextInt(1000);

            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomePastoral.txt")) {
                writer.write(nomePastoral);
            } catch (IOException e) {
                e.printStackTrace();
            }
            navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
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
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(-70, -40).click().sendKeys(nomePastoral).sendKeys(Keys.TAB).perform();//PASTORAL
                new Actions(navegador).sendKeys(sigla).sendKeys(Keys.TAB).perform();//SIGLA
                new Actions(navegador).sendKeys(objetivo).sendKeys(Keys.TAB).perform();//OBJETIVO
                new Actions(navegador).sendKeys(formaatuacao).sendKeys(Keys.TAB).perform();//FORMA DE ATUAÇÃO
                new Actions(navegador).sendKeys(composicao).sendKeys(Keys.TAB).perform();//COMPOSIÇÃO
                new Actions(navegador).sendKeys(tipo).sendKeys(Keys.ENTER).perform();//TIPO

                // SALVAR CADASTRO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[2]")).click();
                Thread.sleep(600);
                // TIRA UMA CAPTURA DE TELA PARA ANÁLISE VISUAL
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

                // CAMINHO PARA SALVAR A CAPTURA DE TELA
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pastorais//Cadastro//resultado_teste_" + timestamp + ".png");

                // SALVAR A CAPTURA DE TELA
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
                // Finalizar navegador ao final de cada execução
                {
                    navegador.quit();
                }
            }

            // ABRIR CONFERENCIA
            nomePastoral = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomePastoral.txt"))) {
                nomePastoral = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

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
                Thread.sleep(400);
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
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();


                // Nome Pastoral
                Thread.sleep(400);
                new Actions(navegador).moveByOffset(0, -140).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomePastoral = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Pastoral está vazio
                if (valorCampoNomePastoral == null || valorCampoNomePastoral.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Nome Pastoral está vazio.\n");
                    System.out.println("ERRO: O campo Nome Pastoral está vazio.");
                } else {
                    System.out.println("O campo Nome Pastoral foi preenchido com: " + valorCampoNomePastoral);
                }

                // Sigla
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSigla = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSigla == null || valorCampoSigla.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Sigla está vazio.\n");
                    System.out.println("ERRO: O campo Sigla está vazio.");
                } else {
                    System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla);
                }

                // Objetivo
                new Actions(navegador).moveByOffset(0, 35).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoObjetivo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Objetivo está vazio
                if (valorCampoObjetivo == null || valorCampoObjetivo.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Objetivo está vazio.\n");
                    System.out.println("ERRO: O campo Objetivo está vazio.");
                } else {
                    System.out.println("O campo Objetivo foi preenchido com: " + valorCampoObjetivo);
                }

                // Forma Atuação
                new Actions(navegador).moveByOffset(0, 100).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFormaAtuacao = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Forma Atuação está vazio
                if (valorCampoFormaAtuacao == null || valorCampoFormaAtuacao.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Forma Atuação está vazio.\n");
                    System.out.println("ERRO: O campo Forma Atuação está vazio.");
                } else {
                    System.out.println("O campo Forma Atuação foi preenchido com: " + valorCampoFormaAtuacao);
                }

                // Composição
                new Actions(navegador).moveByOffset(0, 120).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoComposicao = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Composição está vazio
                if (valorCampoComposicao == null || valorCampoComposicao.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Composição está vazio.\n");
                    System.out.println("ERRO: O campo Composição está vazio.");
                } else {
                    System.out.println("O campo Composição foi preenchido com: " + valorCampoComposicao);
                }

                // Tipo
                new Actions(navegador).moveByOffset(0, 80).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTipo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tipo está vazio
                if (valorCampoTipo == null || valorCampoTipo.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Tipo está vazio.\n");
                    System.out.println("ERRO: O campo Tipo está vazio.");
                } else {
                    System.out.println("O campo Tipo foi preenchido com: " + valorCampoTipo);
                }

                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                // Definir o caminho e nome do arquivo
                String caminhoPasta5 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pastorais//erros log//erros";
                String caminhoArquivo5 = caminhoPasta5 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta5);
                    if (!pasta.exists()) {
                        boolean mkdirs = pasta.mkdirs();
                    }
                    Thread.sleep(400);
                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo5, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo5);
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


            // "INICIO DE CICLO DE ALTERAÇÃO" \\

            // Criar nome aleatório para o cadastro
            String nomePastoral2 = "TestPastoral" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomePastoral2.txt")) {
                writer.write(nomePastoral2);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // GERAÇÃO DE DADOS DINÂMICOS
            String sigla2 = "TSTPSWD" + random.nextInt(1000);
            String objetivo2 = "Objetivo Teste de Pastoral" + random.nextInt(1000);
            String formaatuacao2 = nomePastoral.toLowerCase() + random.nextInt(1000);
            String composicao2 = "Teste de Pastoral" + random.nextInt(1000);
            String[] tipos2 = {"Movimento", "Outros", "Palestra", "Pastoral", "Serviço"};
            String tipo2 = tipos2[random.nextInt(tipos2.length)];


            Thread.sleep(400);
            new Actions(navegador).moveByOffset(0, -360).doubleClick().click().sendKeys(nomePastoral2).perform();//NOME
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(sigla2).perform();//SIGLA
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(objetivo2).perform();//OBJETIVO
            new Actions(navegador).moveByOffset(0, 100).doubleClick().click().sendKeys(formaatuacao2).perform();//FORMA DE ATUAÇÃO
            new Actions(navegador).moveByOffset(0, 100).doubleClick().click().sendKeys(composicao2).perform();//COMPOSIÇÃO
            new Actions(navegador).moveByOffset(0, 100).doubleClick().click().sendKeys(tipo2).sendKeys(Keys.ENTER).perform();//TIPO

            // Salvar Cadastro
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[2]")).click();
            Thread.sleep(500);
            // SCREENSHOT
            try {
                // TIRA UMA CAPTURA DE TELA PARA ANÁLISE VISUAL
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

                // CAMINHO PARA SALVAR A CAPTURA DE TELA
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pastorais//Cadastro alt//resultado_teste_ALT" + timestamp + ".png");

                // SALVAR A CAPTURA DE TELA
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
                // Finalizar navegador ao final de cada execução
                {
                    navegador.quit();
                }
            }


            // "ABRIR CONFERENCIA DE ALTERAÇÃO" \\


            nomePastoral2 = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomePastoral2.txt"))) {
                nomePastoral2 = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

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
                Thread.sleep(500);
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
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();


                // Nome Pastoral
                Thread.sleep(400);
                new Actions(navegador).moveByOffset(-90, -140).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomePastoralALT = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Pastoral está vazio
                if (valorCampoNomePastoralALT == null || valorCampoNomePastoralALT.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Nome Pastoral está vazio.\n");
                    System.out.println("ERRO: O campo Nome Pastoral está vazio.");
                } else {
                    System.out.println("O campo Nome Pastoral foi preenchido com: " + valorCampoNomePastoralALT);
                }

                // Sigla
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSiglaALT = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSiglaALT == null || valorCampoSiglaALT.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Sigla está vazio.\n");
                    System.out.println("ERRO: O campo Sigla está vazio.");
                } else {
                    System.out.println("O campo Sigla foi preenchido com: " + valorCampoSiglaALT);
                }

                // Objetivo
                new Actions(navegador).moveByOffset(0, 35).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoObjetivoALT = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Objetivo está vazio
                if (valorCampoObjetivoALT == null || valorCampoObjetivoALT.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Objetivo está vazio.\n");
                    System.out.println("ERRO: O campo Objetivo está vazio.");
                } else {
                    System.out.println("O campo Objetivo foi preenchido com: " + valorCampoObjetivoALT);
                }

                // Forma Atuação
                new Actions(navegador).moveByOffset(0, 100).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFormaAtuacaoALT = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Forma Atuação está vazio
                if (valorCampoFormaAtuacaoALT == null || valorCampoFormaAtuacaoALT.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Forma Atuação está vazio.\n");
                    System.out.println("ERRO: O campo Forma Atuação está vazio.");
                } else {
                    System.out.println("O campo Forma Atuação foi preenchido com: " + valorCampoFormaAtuacaoALT);
                }

                // Composição
                new Actions(navegador).moveByOffset(0, 120).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoComposicaoALT = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Composição está vazio
                if (valorCampoComposicaoALT == null || valorCampoComposicaoALT.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Composição está vazio.\n");
                    System.out.println("ERRO: O campo Composição está vazio.");
                } else {
                    System.out.println("O campo Composição foi preenchido com: " + valorCampoComposicaoALT);
                }

                // Tipo
                new Actions(navegador).moveByOffset(0, 80).click().sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTipoALT = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tipo está vazio
                if (valorCampoTipoALT == null || valorCampoTipoALT.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Tipo está vazio.\n");
                    System.out.println("ERRO: O campo Tipo está vazio.");
                } else {
                    System.out.println("O campo Tipo foi preenchido com: " + valorCampoTipoALT);
                }

                //EXCLUIR CADASTRO
                Thread.sleep(100);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[4]")).click();
                Thread.sleep(150);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
                Thread.sleep(150);

                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                String caminhoPasta6 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pastorais//erros log alt//erros";
                String caminhoArquivo6 = caminhoPasta6 + "erroslogAlt" + timestamp + ".txt"; // Nome fixo do arquivo

                try {
                    // Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta6);
                    if (!pasta.exists()) {
                        boolean mkdirs = pasta.mkdirs();
                    }
                    Thread.sleep(400);
                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo6, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo6);
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
                // Finalizar navegador ao final de cada execução
                {
                    navegador.quit();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / /// "ABRIR NAVEGADOR PARA CADASTRAR "GRUPO AÇÃO"" \\/ / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /

            // Criar nome aleatório para o cadastro
            random = new Random();
            String nomegrupoacao = "TestGASWD" + random.nextInt(10000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomegrupoacao.txt")) {
                writer.write(nomegrupoacao);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Criar nome aleatório para o cadastro de alteração
            String nomegaalteracao = "TestGAalt" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomegaalteracao.txt")) {
                writer.write(nomegaalteracao);
            } catch (IOException e) {
                e.printStackTrace();
            }

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

                actions = new Actions(navegador);

                // Abrir SGE (Grupo Ação)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");

                // Gerar dados dinâmicos
                // Campos dinâmicos
                String[] Tipos = {"Associação Religiosa", "Ação Social", "Construção", "Encontro", "Evento", "Grupo de Oração", "Loteamento", "Movimento", "Pastoral"};
                String Tipo = Tipos[random.nextInt(Tipos.length)];
                String[] Comunicacoes = {"333", "334", "335", "336", "337", "338", "339", "340", "341", "342", "343", "5446", "5447", "6400"};
                String Comunicacao = Comunicacoes[random.nextInt(Comunicacoes.length)];
                String[] Paroquias = {"252", "253", "256", "264", "265", "266", "267"};
                String Paroquia = Paroquias[random.nextInt(Paroquias.length)];
                String sigla = "TSTSWD" + random.nextInt(1000);
                String[] modelos = {"13"};
                String modelo = modelos[random.nextInt(modelos.length)];

                // "novo" cadastro.
                Thread.sleep(600);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[5]")).click();


                // "CADASTRO" \\

                Thread.sleep(1000);
                actions.moveByOffset(0, 30).click().sendKeys(Tipo).sendKeys(Keys.TAB).perform();//TIPO
                actions.sendKeys("908").sendKeys(Keys.TAB).perform();//MOTORISTA EQUIPE FUNÇÃO
                actions.sendKeys("239").sendKeys(Keys.TAB).perform();//Motorista Equipe
                actions.sendKeys("908").sendKeys(Keys.TAB).perform();//PASSAGEIRO EQUIPE FUNÇÃO
                actions.sendKeys("908").sendKeys(Keys.TAB).perform();//GRUPO PESSOA
                actions.sendKeys("908").sendKeys(Keys.TAB).perform();//FICHA
                actions.sendKeys(Comunicacao).sendKeys(Keys.TAB).perform();//COMUNICAÇÃO
                actions.sendKeys(Paroquia).sendKeys(Keys.TAB).perform();//PARÓQUIA
                actions.moveByOffset(0, 240).doubleClick().click().sendKeys(nomegrupoacao).sendKeys(Keys.TAB).perform();//NOME
                actions.sendKeys(sigla).sendKeys(Keys.TAB).perform();//SIGLA
                actions.sendKeys("X").sendKeys(Keys.TAB).perform();//SETOR ETAPA
                actions.moveByOffset(0, 80).click().sendKeys(Keys.TAB).perform();//AGRUPAR CASAL
                actions.sendKeys(modelos).perform();//GRUPO AÇÃO MODELO
                actions.moveByOffset(100, 35).click().perform();//PESSOA AUTORIZADA

                // "SALVAR CADASTRO"
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[6]")).click();
                Thread.sleep(400);

                // Capturar screenshot para análise visual.
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Cadastro//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            try {
                    // Espera antes de iniciar o próximo ciclo
                    Thread.sleep(500);
                } catch (InterruptedException e) {Thread.currentThread().interrupt();}
                {navegador.quit();}



                                        // "REABRIR O NAVEGADOR PARA CONFERÊNCIA" \\

            try (BufferedReader reader = new BufferedReader(new FileReader("nomegrupoacao.txt"))) {
                nomegrupoacao = reader.readLine();
            }
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

                actions = new Actions(navegador);

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");

                //PESQUISA DE CADASTRO
                Thread.sleep(600);
                navegador.findElement(By.className("input-buscar")).sendKeys(nomegrupoacao + Keys.ENTER);


                //Atualizar pagina
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                Thread.sleep(600);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();

                // SELECIONAR CADASTRO
                Thread.sleep(500);
                actions.moveByOffset(-40, 105).doubleClick().perform();
                // CLICAR EM ALTERAR
                Thread.sleep(600);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[7]")).click();

                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();

                // TIPO
                Thread.sleep(500);
                actions.moveByOffset(0, -70).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTipo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tipo está vazio
                if (valorCampoTipo == null || valorCampoTipo.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Tipo está vazio.\n");
                    System.out.println("ERRO: O campo Tipo está vazio.");
                } else {
                    System.out.println("O campo Tipo foi preenchido com: " + valorCampoTipo);
                }

                // MOTORISTA EQUIPE FUNÇÃO
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoMEF = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo MEF está vazio
                if (valorCampoMEF == null || valorCampoMEF.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Motorista (Equipe Função) está vazio.\n");
                    System.out.println("ERRO: O campo Motorista (Equipe Função) está vazio.");
                } else {
                    System.out.println("O campo Motorista (Equipe Função) foi preenchido com: " + valorCampoMEF);
                }

                // MOTORISTA EQUIPE
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoME = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo ME está vazio
                if (valorCampoME == null || valorCampoME.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Motorista (Equipe) está vazio.\n");
                    System.out.println("ERRO: O campo Motorista (Equipe) está vazio.");
                } else {
                    System.out.println("O campo Motorista (Equipe) foi preenchido com: " + valorCampoME);
                }

                // Passageiro (Equipe Função)
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPEF = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Passageiro (Equipe Função) está vazio
                if (valorCampoPEF == null || valorCampoPEF.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Passageiro (Equipe Função) está vazio.\n");
                    System.out.println("ERRO: O campo Passageiro (Equipe Função) está vazio.");
                } else {
                    System.out.println("O campo Passageiro (Equipe Função) foi preenchido com: " + valorCampoPEF);
                }

                // Grupo Pessoa (Equipe Função)
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoGPEF = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Grupo Pessoa (Equipe Função) está vazio
                if (valorCampoGPEF == null || valorCampoGPEF.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Grupo Pessoa (Equipe Função) está vazio.\n");
                    System.out.println("ERRO: O campo Grupo Pessoa (Equipe Função) está vazio.");
                } else {
                    System.out.println("O campo Grupo Pessoa (Equipe Função) foi preenchido com: " + valorCampoGPEF);
                }

                // Ficha (Equipe Função)
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFEF = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Ficha (Equipe Função) está vazio
                if (valorCampoFEF == null || valorCampoFEF.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Ficha (Equipe Função) está vazio.\n");
                    System.out.println("ERRO: O campo Grupo Ficha (Equipe Função) está vazio.");
                } else {
                    System.out.println("O campo Grupo Ficha (Equipe Função) foi preenchido com: " + valorCampoFEF);
                }

                // Comunicação
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoComunicacao = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Comunicação está vazio
                if (valorCampoComunicacao == null || valorCampoComunicacao.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Comunicação está vazio.\n");
                    System.out.println("ERRO: O campo Comunicação está vazio.");
                } else {
                    System.out.println("O campo Comunicação foi preenchido com: " + valorCampoComunicacao);
                }

                // Paroquia
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoParoquiaGA = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Paroquia está vazio
                if (valorCampoParoquiaGA == null || valorCampoParoquiaGA.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Paroquia está vazio.\n");
                    System.out.println("ERRO: O campo Paroquia está vazio.");
                } else {
                    System.out.println("O campo Paroquia foi preenchido com: " + valorCampoParoquiaGA);
                }

                // Nome
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeGA = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome está vazio
                if (valorCampoNomeGA == null || valorCampoNomeGA.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Nome está vazio.\n");
                    System.out.println("ERRO: O campo Nome está vazio.");
                } else {
                    System.out.println("O campo Nome foi preenchido com: " + valorCampoNomeGA);
                }

                // Sigla
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSigla = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSigla == null || valorCampoSigla.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Sigla está vazio.\n");
                    System.out.println("ERRO: O campo Sigla está vazio.");
                } else {
                    System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla);
                }

                // Setor Etapa
                actions.sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSetorEtapa = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Setor Etapa está vazio
                if (valorCampoSetorEtapa == null || valorCampoSetorEtapa.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Setor Etapa está vazio.\n");
                    System.out.println("ERRO: O campo Setor Etapa está vazio.");
                } else {
                    System.out.println("O campo Setor Etapa foi preenchido com: " + valorCampoSetorEtapa);
                }

                // Grupo Ação Modelo
                actions.sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoGAM = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Grupo Ação Modelo está vazio
                if (valorCampoGAM == null || valorCampoGAM.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Grupo Ação Modelo está vazio.\n");
                    System.out.println("ERRO: O campo Grupo Ação Modelo está vazio.");
                } else {
                    System.out.println("O campo Grupo Ação Modelo foi preenchido com: " + valorCampoGAM);
                }

                Thread.sleep(400);
                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta7 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Cadastro//erros log//erro";
                String caminhoArquivo7 = caminhoPasta7 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta7);
                    if (!pasta.exists()) {
                        boolean mkdirs = pasta.mkdirs();
                    }

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo7, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }
                Thread.sleep(500);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            // INICIO DE CICLO DE ALTERAÇÃO \\
            //"ALTERAÇÃO DE CADASTRO"\\

            actions = new Actions(navegador);
            // Gerar dados dinâmicos
            // Campos dinâmicos

            String[] TiposAlt = {"Associação Religiosa", "Ação Social", "Construção", "Encontro", "Evento", "Grupo de Oração", "Loteamento", "Movimento", "Pastoral"};
            String TipoAlt = TiposAlt[random.nextInt(TiposAlt.length)];
            String[] ComunicacoesAlt = {"333", "334", "335", "336", "337", "338", "339", "340", "341", "342", "343", "5446", "5447", "6400"};
            String ComunicacaoAlt = ComunicacoesAlt[random.nextInt(ComunicacoesAlt.length)];
            String[] ParoquiasAlt = {"252", "253", "256", "264", "265", "266", "267"};
            String ParoquiaAlt = ParoquiasAlt[random.nextInt(ParoquiasAlt.length)];
            String siglaAlt = "TSTSWD" + random.nextInt(1000);
            String[] modelosAlt = {"13"};
            String modeloAlt = modelosAlt[random.nextInt(modelosAlt.length)];


            // "CADASTRO"
            Thread.sleep(500);
            actions.moveByOffset(-60, -65).doubleClick().click().sendKeys(TipoAlt).sendKeys(Keys.TAB).perform();//TIPO
            actions.sendKeys(Keys.TAB).perform();
            actions.sendKeys(Keys.TAB).perform();
            actions.sendKeys(Keys.TAB).perform();
            actions.sendKeys(Keys.TAB).perform();
            actions.sendKeys(Keys.TAB).perform();
            actions.sendKeys(Keys.TAB).perform();
            actions.sendKeys(Keys.TAB).perform();
            actions.sendKeys(nomegaalteracao).sendKeys(Keys.TAB).perform();//NOME
            actions.sendKeys(siglaAlt).sendKeys(Keys.TAB).perform();//SIGLA
            Thread.sleep(150);
            actions.sendKeys("I").sendKeys(Keys.TAB).perform();//SETOR ETAPA

            // "SALVAR CADASTRO"
            Thread.sleep(400);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[6]")).click();
            Thread.sleep(400);

            // Capturar screenshot para análise visual.
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Cadastro//Cadastro alt//resultado_teste_Alt" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            // Finalizar navegador ao final de cada execução
            {
                navegador.quit();
            }


            // "REABRIR NAVEGADOR PARA CONFERENCIA DE CADASTRO" \\

            nomegaalteracao = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomegaalteracao.txt"))) {
                nomegaalteracao = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Configurar o WebDriver
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            try {
                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                actions = new Actions(navegador);

                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div")).click();
                Thread.sleep(500);

                //SELECIONAR ENTIDADE
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                actions = new Actions(navegador);

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");

                //ATUALIZAR A PAGINA
                Thread.sleep(700);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                Thread.sleep(300);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();

                //PESQUISA DE CADASTRO
                Thread.sleep(1000);
                navegador.findElement(By.className("input-buscar")).sendKeys(nomegaalteracao + Keys.ENTER);

                //ATUALIZAR A PAGINA
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                Thread.sleep(200);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[7]")).click();


                // SELECIONAR CADASTRO
                Thread.sleep(500);
                actions.moveByOffset(-40, 105).doubleClick().perform();
                // CLICAR EM ALTERAR
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[7]")).click();

                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();

                // TIPO
                Thread.sleep(400);
                actions.moveByOffset(0, -70).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTipoAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tipo está vazio
                if (valorCampoTipoAlt == null || valorCampoTipoAlt.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Tipo está vazio.\n");
                    System.out.println("ERRO: O campo Tipo está vazio.");
                } else {
                    System.out.println("O campo Tipo foi preenchido com: " + valorCampoTipoAlt);
                }

                // MOTORISTA EQUIPE FUNÇÃO
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoMEFAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo MEF está vazio
                if (valorCampoMEFAlt == null || valorCampoMEFAlt.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Motorista (Equipe Função) está vazio.\n");
                    System.out.println("ERRO: O campo Motorista (Equipe Função) está vazio.");
                } else {
                    System.out.println("O campo Motorista (Equipe Função) foi preenchido com: " + valorCampoMEFAlt);
                }

                // MOTORISTA EQUIPE
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoMEAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo ME está vazio
                if (valorCampoMEAlt == null || valorCampoMEAlt.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Motorista (Equipe) está vazio.\n");
                    System.out.println("ERRO: O campo Motorista (Equipe) está vazio.");
                } else {
                    System.out.println("O campo Motorista (Equipe) foi preenchido com: " + valorCampoMEAlt);
                }

                // Passageiro (Equipe Função)
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPEFAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Passageiro (Equipe Função) está vazio
                if (valorCampoPEFAlt == null || valorCampoPEFAlt.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Passageiro (Equipe Função) está vazio.\n");
                    System.out.println("ERRO: O campo Passageiro (Equipe Função) está vazio.");
                } else {
                    System.out.println("O campo Passageiro (Equipe Função) foi preenchido com: " + valorCampoPEFAlt);
                }

                // Grupo Pessoa (Equipe Função)
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoGPEFAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Grupo Pessoa (Equipe Função) está vazio
                if (valorCampoGPEFAlt == null || valorCampoGPEFAlt.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Grupo Pessoa (Equipe Função) está vazio.\n");
                    System.out.println("ERRO: O campo Grupo Pessoa (Equipe Função) está vazio.");
                } else {
                    System.out.println("O campo Grupo Pessoa (Equipe Função) foi preenchido com: " + valorCampoGPEFAlt);
                }

                // Ficha (Equipe Função)
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFEFAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Ficha (Equipe Função) está vazio
                if (valorCampoFEFAlt == null || valorCampoFEFAlt.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Ficha (Equipe Função) está vazio.\n");
                    System.out.println("ERRO: O campo Grupo Ficha (Equipe Função) está vazio.");
                } else {
                    System.out.println("O campo Grupo Ficha (Equipe Função) foi preenchido com: " + valorCampoFEFAlt);
                }

                // Comunicação
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoComunicacaoAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Comunicação está vazio
                if (valorCampoComunicacaoAlt == null || valorCampoComunicacaoAlt.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Comunicação está vazio.\n");
                    System.out.println("ERRO: O campo Comunicação está vazio.");
                } else {
                    System.out.println("O campo Comunicação foi preenchido com: " + valorCampoComunicacaoAlt);
                }

                // Paroquia
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoParoquiaAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Paroquia está vazio
                if (valorCampoParoquiaAlt == null || valorCampoParoquiaAlt.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Paroquia está vazio.\n");
                    System.out.println("ERRO: O campo Paroquia está vazio.");
                } else {
                    System.out.println("O campo Paroquia foi preenchido com: " + valorCampoParoquiaAlt);
                }

                // Nome
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome está vazio
                if (valorCampoNomeAlt == null || valorCampoNomeAlt.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Nome está vazio.\n");
                    System.out.println("ERRO: O campo Nome está vazio.");
                } else {
                    System.out.println("O campo Nome foi preenchido com: " + valorCampoNomeAlt);
                }

                // Sigla
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSiglaAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSiglaAlt == null || valorCampoSiglaAlt.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Sigla está vazio.\n");
                    System.out.println("ERRO: O campo Sigla está vazio.");
                } else {
                    System.out.println("O campo Sigla foi preenchido com: " + valorCampoSiglaAlt);
                }

                // Setor Etapa
                actions.sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSetorEtapaAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Setor Etapa está vazio
                if (valorCampoSetorEtapaAlt == null || valorCampoSetorEtapaAlt.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Setor Etapa está vazio.\n");
                    System.out.println("ERRO: O campo Setor Etapa está vazio.");
                } else {
                    System.out.println("O campo Setor Etapa foi preenchido com: " + valorCampoSetorEtapaAlt);
                }

                // Grupo Ação Modelo
                actions.sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoGAMAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Grupo Ação Modelo está vazio
                if (valorCampoGAMAlt == null || valorCampoGAMAlt.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Grupo Ação Modelo está vazio.\n");
                    System.out.println("ERRO: O campo Grupo Ação Modelo está vazio.");
                } else {
                    System.out.println("O campo Grupo Ação Modelo foi preenchido com: " + valorCampoGAMAlt);
                }

                Thread.sleep(400);


                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta8 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Cadastro//erros log alt//erros log//erro";
                String caminhoArquivo8 = caminhoPasta8 + "erroslogAlt" + timestamp + ".txt";

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta8);
                    if (!pasta.exists()) {
                        boolean mkdirs = pasta.mkdirs();
                    }

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo8, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo8);
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }


                // Finalizar navegador ao final de cada execução
                {
                    navegador.quit();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / /// "ABRIR NAVEGADOR PARA CADASTRAR "ACESSO"" \\/ / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /


            nomegaalteracao = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomegaalteracao.txt"))) {
                nomegaalteracao = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Configurar o WebDriver
            navegador = new ChromeDriver();
            WebDriverManager.chromedriver().setup();

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
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");

                // Campos dinâmicos
                random = new Random();
                String[] VicariatosParoquia = {"CENTRO", "LAGO SUL", "LESTE", "NORTE", "SUL"};
                String VicariatoParoquia = VicariatosParoquia[random.nextInt(VicariatosParoquia.length)];

                // Pesquisa de Cadastro
                Thread.sleep(800);
                navegador.findElement(By.className("input-buscar")).sendKeys(nomegaalteracao + Keys.ENTER);

                // GRUPO AÇÃO ACESSO
                Thread.sleep(800);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[2]/div")).click();
                // NOVO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[1]")).click();

                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, -30).click().sendKeys("BRASÍLIA").sendKeys(Keys.TAB).perform();// ARQUIDIOCESE
                new Actions(navegador).sendKeys(VicariatoParoquia).sendKeys(Keys.TAB).perform();// VICARIATO PARÓQUIA
                new Actions(navegador).sendKeys("I").sendKeys(Keys.ENTER).perform();// SETOR PAROQUIA

                // SALVAR CADASTRO
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]")).click();
                Thread.sleep(400);

                // Capturar screenshot para análise visual
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Acesso//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                try {
                    // Espera antes de iniciar o próximo ciclo
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                // Finalizar navegador ao final de cada execução
                {
                    navegador.quit();
                }
            }


            // "Reabrir o navegador para conferência de cadastro" \\

            nomegaalteracao = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomegaalteracao.txt"))) {
                nomegaalteracao = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

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

                actions = new Actions(navegador);

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");

                //PESQUISA DE CADASTRO
                Thread.sleep(100);
                navegador.findElement(By.className("input-buscar")).sendKeys(nomegaalteracao + Keys.ENTER);


                //GRUPO AÇÃO // ACESSO
                Thread.sleep(800);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[2]/div")).click();
                // SELECIONAR CADASTRO
                Thread.sleep(800);
                actions.moveByOffset(-40, 130).doubleClick().perform();
                // CLICAR EM ALTERAR
                Thread.sleep(800);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[3]")).click();

                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();

                // ARQUIDIOCESE
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, -170).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeArquidiocese = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Arquidiocese está vazio
                if (valorCampoNomeArquidiocese == null || valorCampoNomeArquidiocese.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Arquidiocese está vazio.");
                    System.out.println("ERRO: O campo Arquidiocese está vazio.");
                } else {
                    System.out.println("O campo Arquidiocese foi preenchido com: " + valorCampoNomeArquidiocese);
                }

                // VICARIATO PAROQUIA
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeVicariatoParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoNomeVicariatoParoquia == null || valorCampoNomeVicariatoParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Vicariato Paroquia está vazio.");
                    System.out.println("ERRO: O campo Vicariato Paroquia está vazio.");
                } else {
                    System.out.println("O campo Vicariato Paroquia foi preenchido com: " + valorCampoNomeVicariatoParoquia);
                }

                // SETOR PAROQUIA
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSetorParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Setor Paroquia está vazio
                if (valorCampoNomeVicariatoParoquia == null || valorCampoSetorParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Setor Paroquia está vazio.");
                    System.out.println("ERRO: O campo Setor Paroquia está vazio.");
                } else {
                    System.out.println("O campo Setor Paroquia foi preenchido com: " + valorCampoSetorParoquia);
                }

                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta9 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Acesso//erros log//erro";
                String caminhoArquivo9 = caminhoPasta9 + "erroslogAlt" + timestamp + ".txt";

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta9);
                    if (!pasta.exists()){
                        boolean mkdirs = pasta.mkdirs();
                    }
                    Thread.sleep(400);
                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo9, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo9);
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }


                // "INICIO DE ALTERAÇÃO DE CADASTRO" \\

                //GERAÇÃO DE DADOS DINÂMICOS
                random = new Random();
                String[] VicariatosParoquiaAlt = {"CENTRO", "LAGO SUL", "LESTE", "NORTE", "SUL"};
                String VicariatoParoquiaAlt = VicariatosParoquiaAlt[random.nextInt(VicariatosParoquiaAlt.length)];

                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, 0).doubleClick().sendKeys("BRASÍLIA").sendKeys(Keys.TAB).perform();// ARQUIDIOCESE
                new Actions(navegador).sendKeys(VicariatoParoquiaAlt).sendKeys(Keys.TAB).perform();// VICARIATO PARÓQUIA
                new Actions(navegador).sendKeys("I").sendKeys(Keys.ENTER).perform();// SETOR PAROQUIA

                // SALVAR CADASTRO
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]")).click();
                Thread.sleep(1000);

                // Capturar screenshot para análise visual
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Acesso//Cadastro alt//resultado_teste_Alt" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // Finalizar navegador ao final de cada execução
                {
                    navegador.quit();
                }
            }


            // "REABRIR PARA CONFERENCIA DE ALTERAÇÃO DE CADASTRO" \\

            nomegaalteracao = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomegaalteracao.txt"))) {
                nomegaalteracao = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Configurar o WebDriver
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            try {
                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                actions = new Actions(navegador);
                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div")).click();
                Thread.sleep(500);

                //SELECIONAR ENTIDADE
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                actions = new Actions(navegador);

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");

                //PESQUISA DE CADASTRO
                Thread.sleep(800);
                navegador.findElement(By.className("input-buscar")).sendKeys(nomegaalteracao + Keys.ENTER);
                //GRUPO AÇÃO // ACESSO
                Thread.sleep(800);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[2]/div")).click();
                // SELECIONAR CADASTRO
                Thread.sleep(800);
                actions.moveByOffset(-40, 130).doubleClick().perform();
                // CLICAR EM ALTERAR
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[3]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();

                // ARQUIDIOCESE
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, -170).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeArquidiocese = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Arquidiocese está vazio
                if (valorCampoNomeArquidiocese == null || valorCampoNomeArquidiocese.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Arquidiocese está vazio.");
                    System.out.println("ERRO: O campo Arquidiocese está vazio.");
                } else {
                    System.out.println("O campo Arquidiocese foi preenchido com: " + valorCampoNomeArquidiocese);
                }

                // VICARIATO PAROQUIA
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeVicariatoParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoNomeVicariatoParoquia == null || valorCampoNomeVicariatoParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Vicariato Paroquia está vazio.");
                    System.out.println("ERRO: O campo Vicariato Paroquia está vazio.");
                } else {
                    System.out.println("O campo Vicariato Paroquia foi preenchido com: " + valorCampoNomeVicariatoParoquia);
                }

                // SETOR PAROQUIA
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSetorParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Setor Paroquia está vazio
                if (valorCampoNomeVicariatoParoquia == null || valorCampoSetorParoquia.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Setor Paroquia está vazio.");
                    System.out.println("ERRO: O campo Setor Paroquia está vazio.");
                } else {
                    System.out.println("O campo Setor Paroquia foi preenchido com: " + valorCampoSetorParoquia);
                }

                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta10 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Acesso//erros log alt//erro";
                String caminhoArquivo10 = caminhoPasta10 + "erroslogAlt" + timestamp + ".txt";

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta10);
                    if (!pasta.exists()) {
                        boolean mkdirs = pasta.mkdirs();
                    }
                    Thread.sleep(400);
                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo10, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo10);
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }

                // Excluir cadastro após testes realizados
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]")).click();
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();


                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Finalizar navegador ao final de cada execução
            {
                navegador.quit();
            }


// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / /// "ABRIR NAVEGADOR PARA CADASTRAR "MODELO"" \\/ / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /


//        // CONFIGURAR WEBDRIVER
//        WebDriverManager.chromedriver().setup();
//        navegador = new ChromeDriver();
//        // Definindo o tamanho da janela do navegador
//            tamanho = new Dimension(1024, 768);
//        navegador.manage().window().setSize(tamanho);
//
//        try {
//            // ABRIR O SEG
//            navegador.get("https://app.seg.inf.br/novo/");
//
//            // Login e senha
//                        navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
//                        navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
//                        navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);
//                        Thread.sleep(500);
//                        navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div")).click();
//                        Thread.sleep(500);
//
//                        //SELECIONAR ENTIDADE
//                        new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();
//
//            // ABRIR SEG (GRUPO AÇÃO)
//            navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");
//
//
//            // Campos dinâmicos
//            random = new Random();
//            String nomemodelo = "GATeste" + random.nextInt(1000);
//            String ID = "" + random.nextInt(100);
//
//            // GRUPO AÇÃO MODELO
//            Thread.sleep(1000);
//            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[3]/div")).click();
//            // NOVO
//            Thread.sleep(250);
//            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[1]")).click();
//            // NOME DO MODELO
//            Thread.sleep(250);
//            new Actions(navegador).moveByOffset(0, -60).click().sendKeys(nomemodelo).perform();
//            // MODELO CRONOGRAMA
//            Thread.sleep(250);
//            new Actions(navegador).moveByOffset(0, 30).click().sendKeys(Keys.TAB).perform();
//            // MODELO EQUIPE FUNÇÃO
//            Thread.sleep(250);
//            new Actions(navegador).sendKeys("14").sendKeys(Keys.TAB).perform();
//            // ID
//            Thread.sleep(250);
//            new Actions(navegador).sendKeys(ID).perform();
//
//            // PESSOA NÚCLEO RELATÓRIO
//            //               Thread.sleep(250);
//            //               new Actions(navegador).moveByOffset(0, 75).click().perform();
//
//            // SALVAR CADASTRO
//            Thread.sleep(400);
//            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]" + "/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]")).click();
//            Thread.sleep(1000);
//
//            // Capturar screenshot para análise visual
//            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//            screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
//            destinoFile = new File("C://Users//baptista.joao//Documents//Resultado " + "Testes//Cadastro de Grupo Ação//Modelo//resultado_teste_" + timestamp + ".png");
//            FileHandler.copy(screenshotFile, destinoFile);
//            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());
//
//        } catch (Exception e) {
//            System.out.println("Erro: " + e.getMessage());
//        } finally {
//            try {
//                // Espera antes de iniciar o próximo ciclo
//                Thread.sleep(1500);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//
//
//            // Finalizar navegador ao final de cada execução
//            if (navegador != null) {
//                navegador.quit();
//            }
//        }


// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / // "ABRIR NAVEGADOR PARA CADASTRAR "TEMA"" \\ / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /

            random = new Random();
            String temaga = "TestGASWD" + random.nextInt(10000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomega.txt")) {
                writer.write(temaga);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // CONFIGURAR WEBDRIVER
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            try {
                // ABRIR O SEG
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

                // ABRIR SEG (GRUPO AÇÃO)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");

                // Campos dinâmicos
                random = new Random();
                String ncirculo = "" + random.nextInt(10);
                String descricao = "Teste de descrição para tema " + random.nextInt(100);
                String[] modelosga = {"13"};
                String modeloga = modelosga[random.nextInt(modelosga.length)];

                // GRUPO AÇÃO TEMA
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[4]/div")).click();
                // NOVO
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]")).click();

                Thread.sleep(400);
                new Actions(navegador).moveByOffset(0, -30).click().sendKeys(modeloga).perform();// MODELO GRUPO AÇÃO
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(ncirculo).perform();// Nº DO CÍRCULO
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(temaga).perform();// TEMA
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(descricao).perform();// DESCRIÇÃO

                // SALVAR CADASTRO
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
                Thread.sleep(500);

                // Capturar screenshot para análise visual
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Tema//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // Finalizar navegador ao final de cada execução
                {
                    navegador.quit();
                }
            }


            //"REABRIR PARA CONFERENCIA DE CADASTRO"\\

            temaga = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("temaga.txt"))) {
                temaga = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Configurar o WebDriver
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            actions = null;
            try {
                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                actions = new Actions(navegador);

                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div")).click();
                Thread.sleep(500);

                //SELECIONAR ENTIDADE
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                actions = new Actions(navegador);

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");


                //"CONFERENCIA DE GRUPO AÇÃO TEMA"\\

                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[4]/div")).click();

                // SELECIONAR CADASTRO
                Thread.sleep(500);
                actions.moveByOffset(-40, 175).doubleClick().perform();

                // CLICAR EM ALTERAR
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();

                // MODELO GRUPO AÇÃO
                Thread.sleep(400);
                new Actions(navegador).moveByOffset(0, -230).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoMGA = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo MODELO GRUPO AÇÃO está vazio
                if (valorCampoMGA == null || valorCampoMGA.isEmpty()) {
                    mensagensErro.append("ERRO: O campo MODELO GRUPO AÇÃO está vazio.\n");
                    System.out.println("ERRO: O campo MODELO GRUPO AÇÃO está vazio.");
                } else {
                    System.out.println("O campo MODELO GRUPO AÇÃO foi preenchido com: " + valorCampoMGA);
                }

                // Número do Círculo
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNCirculo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Número do Círculo está vazio
                if (valorCampoNCirculo == null || valorCampoNCirculo.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Número do Círculo está vazio.\n");
                    System.out.println("ERRO: O campo Número do Círculo está vazio.");
                } else {
                    System.out.println("O campo Número do Círculo foi preenchido com: " + valorCampoNCirculo);
                }

                // TEMA
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTema = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tema está vazio
                if (valorCampoTema == null || valorCampoTema.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Tema está vazio.\n");
                    System.out.println("ERRO: O campo Tema está vazio.");
                } else {
                    System.out.println("O campo Tema foi preenchido com: " + valorCampoTema);
                }

                // DESCRIÇÃO
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoDescricao = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Descricao está vazio
                if (valorCampoDescricao == null || valorCampoDescricao.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Descricao está vazio.\n");
                    System.out.println("ERRO: O campo Descricao está vazio.");
                } else {
                    System.out.println("O campo Descricao foi preenchido com: " + valorCampoDescricao);
                }

                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta11 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Tema//erros log//erro";
                String caminhoArquivo11 = caminhoPasta11 + "erroslog" + timestamp + ".txt";

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta11);
                    if (!pasta.exists()) {
                        boolean mkdirs = pasta.mkdirs();
                    }
                    Thread.sleep(400);
                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo11, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo11);
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


            //"CICLO DE ALTERAÇÃO DE DADOS"\\

            random = new Random();
            String temaga2 = "TestGASWDAlt" + random.nextInt(10000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomega.txt")) {
                writer.write(temaga2);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Campos dinâmicos
            random = new Random();
            String ncirculo2 = "" + random.nextInt(10);
            String descricao2 = "Teste de descrição para tema " + random.nextInt(100);
            String[] modelosga2 = {"13"};
            String modeloga2 = modelosga2[random.nextInt(modelosga2.length)];

            // MODELO GRUPO AÇÃO
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(50, 50).doubleClick().click().sendKeys(ncirculo2).sendKeys(Keys.TAB).perform();// Nº DO CÍRCULO
            new Actions(navegador).sendKeys(temaga2).sendKeys(Keys.TAB).perform();// TEMA
            new Actions(navegador).sendKeys(descricao2).sendKeys(Keys.ENTER).perform();// DESCRIÇÃO

            // SALVAR CADASTRO
            Thread.sleep(400);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
            Thread.sleep(500);

            // Capturar screenshot para análise visual
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Tema//Cadastro alt//resultado_teste_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());


            Thread.sleep(500);


            //"INICIO DE CONFERENCIA DE ALTERAÇÃO"\\

            //FECHAR ABA
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[6]")).click();

            // SELECIONAR CADASTRO
            Thread.sleep(500);
            actions.moveByOffset(0, 200).doubleClick().perform();

            // CLICAR EM ALTERAR
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]")).click();

            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            js = (JavascriptExecutor) navegador;
            mensagensErro = new StringBuilder();

            // MODELO GRUPO AÇÃO
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, -260).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMGA = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo MODELO GRUPO AÇÃO está vazio
            if (valorCampoMGA == null || valorCampoMGA.isEmpty()) {
                mensagensErro.append("ERRO: O campo MODELO GRUPO AÇÃO está vazio.\n");
                System.out.println("ERRO: O campo MODELO GRUPO AÇÃO está vazio.");
            } else {
                System.out.println("O campo MODELO GRUPO AÇÃO foi preenchido com: " + valorCampoMGA);
            }

            // NÚMERO DO CÍRCULO
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNCirculo = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Número do Círculo está vazio
            if (valorCampoNCirculo == null || valorCampoNCirculo.isEmpty()) {
                mensagensErro.append("ERRO: O campo Número do Círculo está vazio.\n");
                System.out.println("ERRO: O campo Número do Círculo está vazio.");
            } else {
                System.out.println("O campo Número do Círculo foi preenchido com: " + valorCampoNCirculo);
            }

            // TEMA
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoTema = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Tema está vazio
            if (valorCampoTema == null || valorCampoTema.isEmpty()) {
                mensagensErro.append("ERRO: O campo Tema está vazio.\n");
                System.out.println("ERRO: O campo Tema está vazio.");
            } else {
                System.out.println("O campo Tema foi preenchido com: " + valorCampoTema);
            }

            // DESCRIÇÃO
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDescricao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Descricao está vazio
            if (valorCampoDescricao == null || valorCampoDescricao.isEmpty()) {
                mensagensErro.append("ERRO: O campo Descricao está vazio.\n");
                System.out.println("ERRO: O campo Descricao está vazio.");
            } else {
                System.out.println("O campo Descricao foi preenchido com: " + valorCampoDescricao);
            }

            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta12 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Tema// log alt//erro";
            String caminhoArquivo12 = caminhoPasta12 + "erroslog" + timestamp + ".txt";

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta12);
                if (!pasta.exists()) {
                    boolean mkdirs = pasta.mkdirs();
                }
                Thread.sleep(400);
                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo12, true))) {
                    writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                    writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                }

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo12);
            } catch (IOException e) {
                System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
            }

            // Excluir cadastro após testes realizados
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[4]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
            Thread.sleep(500);

            // Finalizar navegador ao final de cada execução
            {
                navegador.quit();
            }

            // Espera antes de iniciar o próximo ciclo
            Thread.sleep(500);


// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / // "ABRIR NAVEGADOR PARA CADASTRAR "PERGUNTA"" \\ / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /

            // CONFIGURAR WEBDRIVER
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            try {
                // ABRIR O SEG
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

                // ABRIR SEG (GRUPO AÇÃO)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");


                // Campos dinâmicos

                String[] nscirculo = {"114","100","118","106"};
                String ncirculo = nscirculo[random.nextInt(nscirculo.length)];
                String sigla = "PergSiglaTest" + random.nextInt(100);
                String npergunta = "" + random.nextInt(10);
                String[] modelosga = {"13"};
                String modeloga = modelosga[random.nextInt(modelosga.length)];
                String pergunta = "Teste de pergunta" + random.nextInt(1000);


                // GRUPO AÇÃO PERGUNTA
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[5]/div")).click();
                // NOVO
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]")).click();

                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, -20).click().sendKeys(modeloga).sendKeys(Keys.TAB).perform();// MODELO GRUPO AÇÃO
                new Actions(navegador).sendKeys(ncirculo).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// Nº DO CÍRCULO
                new Actions(navegador).sendKeys(sigla).sendKeys(Keys.TAB).perform();// SIGLA
                new Actions(navegador).sendKeys(npergunta).sendKeys(Keys.TAB).perform();// Nº DA PERGUNTA
                new Actions(navegador).sendKeys(pergunta).perform();// PERGUNTA

                // SALVAR CADASTRO
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
                Thread.sleep(400);

                // Capturar screenshot para análise visual
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Pergunta//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                try {// Espera antes de iniciar o próximo ciclo
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // Finalizar navegador ao final de cada execução
                {
                    navegador.quit();
                }
            }


            //"REABRIR PARA CONFERENCIA DE ALTERAÇÃO DE CADASTRO"\\

            // Configurar o WebDriver
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            actions = null;
            try {
                // Abrir o SEG
                navegador.get("https://app.seg.inf.br/novo/");

                actions = new Actions(navegador);

                // Login e senha
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[3]/div[2]/div")).click();
                Thread.sleep(500);

                //SELECIONAR ENTIDADE
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                actions = new Actions(navegador);

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");


                //GRUPO AÇÃO // PERGUNTA
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[5]/div")).click();
                // SELECIONAR CADASTRO
                Thread.sleep(600);
                actions.moveByOffset(-40, 175).doubleClick().perform();
                // CLICAR EM ALTERAR
                Thread.sleep(600);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();

                // MODELO GRUPO AÇÃO
                Thread.sleep(500);
                new Actions(navegador).moveByOffset(0, -220).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoMGA2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo MODELO GRUPO AÇÃO está vazio
                if (valorCampoMGA2 == null || valorCampoMGA2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo MODELO GRUPO AÇÃO está vazio.\n");
                    System.out.println("ERRO: O campo MODELO GRUPO AÇÃO está vazio.");
                } else {
                    System.out.println("O campo MODELO GRUPO AÇÃO foi preenchido com: " + valorCampoMGA2);
                }

                // Número do Círculo
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNCirculo2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Número do Círculo está vazio
                if (valorCampoNCirculo2 == null || valorCampoNCirculo2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Número do Círculo está vazio.\n");
                    System.out.println("ERRO: O campo Número do Círculo está vazio.");
                } else {
                    System.out.println("O campo Número do Círculo foi preenchido com: " + valorCampoNCirculo2);
                }

                // TEMA
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTema2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tema está vazio
                if (valorCampoTema2 == null || valorCampoTema2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Tema está vazio.\n");
                    System.out.println("ERRO: O campo Tema está vazio.");
                } else {
                    System.out.println("O campo Tema foi preenchido com: " + valorCampoTema2);
                }

                // DESCRIÇÃO
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoDescricao2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Descricao está vazio
                if (valorCampoDescricao2 == null || valorCampoDescricao2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Descricao está vazio.\n");
                    System.out.println("ERRO: O campo Descricao está vazio.");
                } else {
                    System.out.println("O campo Descricao foi preenchido com: " + valorCampoDescricao2);
                }

                // SIGLA
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSigla2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSigla2 == null || valorCampoSigla2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Sigla está vazio.\n");
                    System.out.println("ERRO: O campo Sigla está vazio.");
                } else {
                    System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla2);
                }

                // N PERGUNTA
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNPergunta2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo N PERGUNTA está vazio
                if (valorCampoNPergunta2 == null || valorCampoNPergunta2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo N PERGUNTA está vazio.\n");
                    System.out.println("ERRO: O campo N PERGUNTA está vazio.");
                } else {
                    System.out.println("O campo N PERGUNTA foi preenchido com: " + valorCampoNPergunta2);
                }

                // PERGUNTA
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPergunta2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo PERGUNTA está vazio
                if (valorCampoPergunta2 == null || valorCampoPergunta2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo PERGUNTA está vazio.\n");
                    System.out.println("ERRO: O campo PERGUNTA está vazio.");
                } else {
                    System.out.println("O campo PERGUNTA foi preenchido com: " + valorCampoPergunta2);
                }


                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta13 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Pergunta//erros log//erro";
                String caminhoArquivo13 = caminhoPasta13 + "erroslog" + timestamp + ".txt";

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta13);
                    if (!pasta.exists()) {
                        boolean mkdirs = pasta.mkdirs();
                    }
                    Thread.sleep(400);
                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo13, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo13);
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


            //                                               "ALTERAÇÃO DE DADOS CADASTRADOS"

            // Dados dinâmicos
            String[] nscirculo5 = {"114","100","118","106"};
            String ncirculo5 = nscirculo5[random.nextInt(nscirculo5.length)];
            String sigla5 = "PergSiglaTest" + random.nextInt(100);
            String npergunta5 = "" + random.nextInt(10);
            String[] modelosga5 = {"13"};
            String modeloga5 = modelosga5[random.nextInt(modelosga5.length)];
            String pergunta5 = "Teste de pergunta" + random.nextInt(1000);

            //CADASTRO
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, 50).doubleClick().sendKeys(ncirculo5)// Nº DO CÍRCULO
                    .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
            new Actions(navegador).sendKeys(sigla5).sendKeys(Keys.TAB).perform();// SIGLA
            new Actions(navegador).sendKeys(npergunta5).sendKeys(Keys.TAB).perform();// Nº DA PERGUNTA
            new Actions(navegador).moveByOffset(0, 150).doubleClick().click().sendKeys(pergunta5).perform();// PERGUNTA

            // SALVAR CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
            Thread.sleep(500);
            //SAIR DO CADASTRO
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[6]")).click();
            Thread.sleep(300);

            // Capturar screenshot para análise visual
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Pergunta//Cadastro alt//resultado_teste_ALT" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());


            //                                     "RE-SELECIONAR O CADASTRO PARA CONFERENCIA DE ALTERAÇÃO"

            Thread.sleep(150);
            new Actions(navegador).moveByOffset(0, 30).doubleClick().perform();

            // CLICAR EM ALTERAR
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]")).click();

            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            js = (JavascriptExecutor) navegador;
            mensagensErro = new StringBuilder();

            // MODELO GRUPO AÇÃO
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, -220).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            valorCampoMGA = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo MODELO GRUPO AÇÃO está vazio
            if (valorCampoMGA == null || valorCampoMGA.isEmpty()) {
                mensagensErro.append("ERRO: O campo MODELO GRUPO AÇÃO está vazio.\n");
                System.out.println("ERRO: O campo MODELO GRUPO AÇÃO está vazio.");
            } else {
                System.out.println("O campo MODELO GRUPO AÇÃO foi preenchido com: " + valorCampoMGA);
            }

            // NÚMERO DO CÍRCULO
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNCirculo4 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Número do Círculo está vazio
            if (valorCampoNCirculo4 == null || valorCampoNCirculo4.isEmpty()) {
                mensagensErro.append("ERRO: O campo Número do Círculo está vazio.\n");
                System.out.println("ERRO: O campo Número do Círculo está vazio.");
            } else {
                System.out.println("O campo Número do Círculo foi preenchido com: " + valorCampoNCirculo4);
            }

            // TEMA
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoTema4 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Tema está vazio
            if (valorCampoTema4 == null || valorCampoTema4.isEmpty()) {
                mensagensErro.append("ERRO: O campo Tema está vazio.\n");
                System.out.println("ERRO: O campo Tema está vazio.");
            } else {
                System.out.println("O campo Tema foi preenchido com: " + valorCampoTema4);
            }

            // DESCRIÇÃO
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDescricao4 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Descricao está vazio
            if (valorCampoDescricao4 == null || valorCampoDescricao4.isEmpty()) {
                mensagensErro.append("ERRO: O campo Descricao está vazio.\n");
                System.out.println("ERRO: O campo Descricao está vazio.");
            } else {
                System.out.println("O campo Descricao foi preenchido com: " + valorCampoDescricao4);
            }

            // SIGLA
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoSigla4 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Sigla está vazio
            if (valorCampoSigla4 == null || valorCampoSigla4.isEmpty()) {
                mensagensErro.append("ERRO: O campo Sigla está vazio.\n");
                System.out.println("ERRO: O campo Sigla está vazio.");
            } else {
                System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla4);
            }

            // N PERGUNTA
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNPergunta4 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo N PERGUNTA está vazio
            if (valorCampoNPergunta4 == null || valorCampoNPergunta4.isEmpty()) {
                mensagensErro.append("ERRO: O campo N PERGUNTA está vazio.\n");
                System.out.println("ERRO: O campo N PERGUNTA está vazio.");
            } else {
                System.out.println("O campo N PERGUNTA foi preenchido com: " + valorCampoNPergunta4);
            }

            // PERGUNTA
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPergunta4 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo PERGUNTA está vazio
            if (valorCampoPergunta4 == null || valorCampoPergunta4.isEmpty()) {
                mensagensErro.append("ERRO: O campo PERGUNTA está vazio.\n");
                System.out.println("ERRO: O campo N PERGUNTA está vazio.");
            } else {
                System.out.println("O campo PERGUNTA foi preenchido com: " + valorCampoPergunta4);
            }


            // Definir o caminho e nome do arquivo
            Thread.sleep(500);
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta14 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Pergunta//erros log alt//erro";
            String caminhoArquivo14 = caminhoPasta14 + "erroslog" + timestamp + ".txt";

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta14);
                if (!pasta.exists()) {
                    boolean mkdirs = pasta.mkdirs();
                }
                Thread.sleep(400);
                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo14, true))) {
                    writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                    writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                }

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo14);
            } catch (IOException e) {
                System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
            }

            // Excluir cadastro após testes realizados
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[4]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();

            try {// Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Finalizar navegador ao final de cada execução
            {
                navegador.quit();
            }


// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / // "ABRIR NAVEGADOR PARA CADASTRAR "COMPOSIÇÃO DE EQUIPE"" \\ / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /


            // Configurar o WebDriver
            navegador = new ChromeDriver();
            WebDriverManager.chromedriver().setup();

            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);


            try {
                // Abrir o sistema
                navegador.get("https://app.seg.inf.br/novo/");

                // Login no sistema
                navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

                // Esperar campo de entidade aparecer e preencher
                wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                WebElement campoDinamico = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home.login.entidade")));
                campoDinamico.sendKeys("SEG");
                navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir a página de composição de equipes
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

                // GERAÇÃO DE DADOS DINÂMICOS
                random = new Random();
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
                    Thread.sleep(400);
                }

                // Clicar no botão "Novo"
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[2]")).click();

                Thread.sleep(500);
                new Actions(navegador).moveByOffset(-80, 100).click().sendKeys("EQUIPE FUNÇÃO TESTE 1").perform();// Modelo Equipe Função
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys("134").perform();// Grupo Ação
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(Keys.ENTER).perform();// Etapa
                new Actions(navegador).moveByOffset(0, 35).doubleClick().sendKeys("908").sendKeys(Keys.ENTER).perform();// Função Equipes
                new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys("15255").perform();// Pessoas

                // Salvar Cadastro
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[3]")).click();
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[3]")).click();
                Thread.sleep(500);

                // Capturar screenshot para análise visual
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Composição de Equipes//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
                // Finalizar navegador ao final de cada execução
                {
                    navegador.quit();
                }

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
            wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
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
                Thread.sleep(400);
            }

            //BUSCAR CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/input")).sendKeys("JV");
            Thread.sleep(500);

            //ATUALIZAR CADASTROS
            // Defina o número de cliques desejado
            int numCliques2 = 20;
            Thread.sleep(500);
            for (int i2 = 0; i2 < numCliques; i2++) {
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[6]")).click();
                // Aguarde um pequeno intervalo entre os cliques
                Thread.sleep(400);
            }
            // Clicar no cadastro da Composição de Equipe
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, 140).doubleClick().perform();

            // Selecionar "Alterar"
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[4]")).click();

            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            js = (JavascriptExecutor) navegador;
            mensagensErro = new StringBuilder();

            // Modelo Equipe Função
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, -25).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMEF = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Modelo Equipe Função está vazio
            if (valorCampoMEF == null || valorCampoMEF.isEmpty()) {
                mensagensErro.append("ERRO: O campo Modelo Equipe Função está vazio.\n");
                System.out.println("ERRO: O campo Modelo Equipe Função está vazio.");
            } else {
                System.out.println("O campo Modelo Equipe Função foi preenchido com: " + valorCampoMEF);
            }

            // Grupo Ação
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampogrupoacao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Ação está vazio
            if (valorCampogrupoacao == null || valorCampogrupoacao.isEmpty()) {
                mensagensErro.append("ERRO: O campo Grupo Ação está vazio.\n");
                System.out.println("ERRO: O campo Grupo Ação está vazio.");
            } else {
                System.out.println("O campo Grupo Ação foi preenchido com: " + valorCampogrupoacao);
            }

            //Etapa
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Etapa está vazio
            if (valorCampoEtapa == null || valorCampoEtapa.isEmpty()) {
                mensagensErro.append("ERRO: O campo Etapa está vazio.\n");
                System.out.println("ERRO: O campo Etapa está vazio.");
            } else {
                System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapa);
            }

            //Funções Equipe
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoFuncoesEquipe = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Funções Equipe está vazio
            if (valorCampoFuncoesEquipe == null || valorCampoFuncoesEquipe.isEmpty()) {
                mensagensErro.append("ERRO: O campo Funções Equipe está vazio.\n");
                System.out.println("ERRO: O campo Funções Equipe Paroquia está vazio.");
            } else {
                System.out.println("O campo Funções Equipe foi preenchido com: " + valorCampoFuncoesEquipe);
            }

            //Pessoas
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPessoas = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Pessoas está vazio
            if (valorCampoPessoas == null || valorCampoPessoas.isEmpty()) {
                mensagensErro.append("ERRO: O campo Pessoas está vazio.\n");
                System.out.println("ERRO: O campo Pessoas Paroquia está vazio.");
            } else {
                System.out.println("O campo Pessoas foi preenchido com: " + valorCampoPessoas);
            }

            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            // Definir o caminho e nome do arquivo
            String caminhoPasta15 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Composição de Equipes//erros log//erros";
            String caminhoArquivo15 = caminhoPasta15 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta15);
                if (!pasta.exists()) {
                    boolean mkdirs = pasta.mkdirs();
                }
                Thread.sleep(400);
                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo15, true))) {
                    writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                    writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                }

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo15);
            } catch (IOException e) {
                System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
            }

            // Espera antes de iniciar o próximo ciclo
            Thread.sleep(500);


            //"INICIO DE CICLO DE ALTERAÇÃO DE DADOS CADASTRADOS"\\


            //ALTERAÇÃO DOS DADOS
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys("146").perform();// Grupo Ação
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys(Keys.ENTER).perform();// Etapa
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys("909").sendKeys(Keys.ENTER).perform();// Função Equipes
            new Actions(navegador).moveByOffset(0, 30).doubleClick().click().sendKeys("15262").perform();// Pessoas

            // Salvar Cadastro
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[3]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[3]")).click();
            Thread.sleep(500);

            // Capturar screenshot para análise visual
            timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Composição de Equipes//Cadastro alt//resultado_teste_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            //fechar cadastro
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[10]")).click();
            Thread.sleep(1500);


            //"INICIO DE CICLO DE CONFERÊNCIA DE DADOS ALTERADOS"\\

            //SELECIONAR CADASTRO
            // Defina o número de cliques desejado
            int numCliques4 = 20;
            Thread.sleep(500);
            for (int i4 = 0; i4 < numCliques2; i4++) {
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[6]")).click();
                // Aguarde um pequeno intervalo entre os cliques
                Thread.sleep(400);
            }

            //BUSCAR CADASTRO
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/input")).clear();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/input")).sendKeys("Teste");
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[6]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/input")).sendKeys(" n");
            Thread.sleep(500);

            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, -50).doubleClick().perform();

            //SELECIONAR CADASTRO
            // Defina o número de cliques desejado
            int numCliques3 = 20;
            Thread.sleep(500);
            for (int i3 = 0; i3 < numCliques2; i3++) {
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[6]")).click();
                // Aguarde um pequeno intervalo entre os cliques
                Thread.sleep(400);
            }

            //SELECIONAR O BOTÃO "ALTERAR"
            Thread.sleep(300);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[5]/div[2]/div[1]/div[2]/button[4]")).click();
            Thread.sleep(300);


            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            js = (JavascriptExecutor) navegador;
            mensagensErro = new StringBuilder();

            // Modelo Equipe Função
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(0, -60).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMEF2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Modelo Equipe Função está vazio
            if (valorCampoMEF2 == null || valorCampoMEF2.isEmpty()) {
                mensagensErro.append("ERRO: O campo Modelo Equipe Função está vazio.\n");
                System.out.println("ERRO: O campo Modelo Equipe Função está vazio.");
            } else {
                System.out.println("O campo Modelo Equipe Função foi preenchido com: " + valorCampoMEF2);
            }

            // Grupo Ação
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampogrupoacao2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Ação está vazio
            if (valorCampogrupoacao2 == null || valorCampogrupoacao2.isEmpty()) {
                mensagensErro.append("ERRO: O campo Grupo Ação está vazio.\n");
                System.out.println("ERRO: O campo Grupo Ação está vazio.");
            } else {
                System.out.println("O campo Grupo Ação foi preenchido com: " + valorCampogrupoacao2);
            }

            //Etapa
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoEtapa2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Etapa está vazio
            if (valorCampoEtapa2 == null || valorCampoEtapa2.isEmpty()) {
                mensagensErro.append("ERRO: O campo Etapa está vazio.\n");
                System.out.println("ERRO: O campo Etapa está vazio.");
            } else {
                System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapa2);
            }

            //Funções Equipe
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoFuncoesEquipe2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Funções Equipe está vazio
            if (valorCampoFuncoesEquipe2 == null || valorCampoFuncoesEquipe2.isEmpty()) {
                mensagensErro.append("ERRO: O campo Funções Equipe está vazio.\n");
                System.out.println("ERRO: O campo Funções Equipe Paroquia está vazio.");
            } else {
                System.out.println("O campo Funções Equipe foi preenchido com: " + valorCampoFuncoesEquipe2);
            }

            //Pessoas
            new Actions(navegador).sendKeys().perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPessoas2 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Pessoas está vazio
            if (valorCampoPessoas2 == null || valorCampoPessoas2.isEmpty()) {
                mensagensErro.append("ERRO: O campo Pessoas está vazio.\n");
                System.out.println("ERRO: O campo Pessoas Paroquia está vazio.");
            } else {
                System.out.println("O campo Pessoas foi preenchido com: " + valorCampoPessoas2);
            }


            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            // Definir o caminho e nome do arquivo
            String caminhoPasta16 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Composição de Equipes//erros log alt//erros";
            String caminhoArquivo16 = caminhoPasta16 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta16);
                if (!pasta.exists()) {
                    boolean mkdirs = pasta.mkdirs();
                }
                Thread.sleep(400);
                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo16, true))) {
                    writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                    writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                }

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo16);
            } catch (IOException e) {
                System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
            }


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
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/input")).sendKeys("Victoria");
            Thread.sleep(250);
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
            Thread.sleep(500);

            // Finalizar navegador ao final de cada execução
            {
                navegador.quit();
            }


// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / /// "ABRIR NAVEGADOR PARA CADASTRAR "ETAPA"" \\/ / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /


            // Driver
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();
            //DIMENSÃO DA PÁGINA
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            // Criar nome aleatório para o cadastro
            random = new Random();
            String nomeEtapa = "TestEtapa" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomeEtapa.txt")) {
                writer.write(nomeEtapa);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Abrir o SEG
            navegador.get("https://app.seg.inf.br/novo/");

            // Login e senha
            navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
            navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
            navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);


            // Espera para aparecer novo campo.
            wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
            campoDinamico = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.id("home.login.entidade")));
            campoDinamico.sendKeys("SEG");

            // Abrindo a janela de seleção de entidade
            navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
            navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text")).sendKeys(Keys.TAB);
            actions = new Actions(navegador);

            // Entrar no SEG DESENVOLVIMENTO
            new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

            // Abrir SGE (Cadastro de Pessoa).
            navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

            // Gerar dados dinâmicos para a pessoa
            String descricao = "TSTSWD" + random.nextInt(1000);
            String[] tipoetapas = {"loteamento", "retiro", "curso", "Encontro", "movimento", "palestra", "pastoral", "seminário", "festa"};
            String tipoetapa = tipoetapas[random.nextInt(tipoetapas.length)];
            String[] gruposacao = {"124", "125", "126", "134", "136", "140", "142", "143", "146", "147"};
            String grupoacao = gruposacao[random.nextInt(gruposacao.length)];
            String[] comunicacoes = {"carta", "celular", "email", "facebook", "instagram", "skype", "sms", "teams", "340", "telegrama", "telegram", "whatsapp", "zoom"};
            String comunicacao = comunicacoes[random.nextInt(comunicacoes.length)];
            String numeroetapa = "1" + random.nextInt(1000);

            // Clicar em "Cadastro".
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[8]/div")).click();

            // Clicar em "Novo".
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div[2]")).click();

            Thread.sleep(500);
            new Actions(navegador).moveByOffset(50, 10).click().sendKeys(nomeEtapa).sendKeys(Keys.TAB).perform();// Nome
            new Actions(navegador).sendKeys(descricao).sendKeys(Keys.TAB).perform();// Descrição
            new Actions(navegador).sendKeys(numeroetapa).sendKeys(Keys.TAB).perform();// Número Etapa
            new Actions(navegador).sendKeys(tipoetapa).sendKeys(Keys.TAB).perform();// Tipo Etapa
            new Actions(navegador).sendKeys(grupoacao).sendKeys(Keys.TAB).perform();// Grupo Ação
            new Actions(navegador).sendKeys("XXXXX1").sendKeys(Keys.TAB).perform();// Local
            new Actions(navegador).sendKeys("01012020").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// Inicio Etapa
            new Actions(navegador).sendKeys("20012020").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// Fim Etapa
            new Actions(navegador).sendKeys("XXXXX2").sendKeys(Keys.TAB).perform();// Local Avaliação
            new Actions(navegador).sendKeys("20012020").sendKeys(Keys.TAB).sendKeys("1611").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// Avaliação
            new Actions(navegador).sendKeys(comunicacao).sendKeys(Keys.TAB).perform();// Meio de Comunicação
            new Actions(navegador).sendKeys("xxxxx7").sendKeys(Keys.TAB).perform();// Padroeiro
            new Actions(navegador).moveByOffset(0, 350).click().perform();// Etapa em Uso

            // Finalizar Etapa (OPCIONAL)
            // Thread.sleep(1000);
            // new Actions(navegador).moveByOffset(0, 30).click().perform();

            // "Salvar Cadastro"
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[3]")).click();
            Thread.sleep(250);

            // Tirar print da tela ao final da execução do “loop”
            // Capturar screenshot para análise visual
            timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Etapa//Cadastro//resultado_teste_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            //FECHAR NAVEGADOR
            // Finalizar navegador ao final de cada execução
            {
                navegador.quit();
            }
            Thread.sleep(500);


            // "REABRIR NAVEGADOR PARA CONFERENCIA" \\

            nomeEtapa = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomeEtapa.txt"))) {
                nomeEtapa = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // CONFIGURAR WEBDRIVER
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();

            //DIMENSÃO DA PÁGINA
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            // Abrir o o SEG
            navegador.get("https://app.seg.inf.br/novo/");

            // Login e senha para entrar na conta da SEG.
            navegador.findElement(By.id("home.login.login")).sendKeys("JOAO.VICTOR");
            navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
            navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

            // Espera para aparecer novo campo.
            wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
            campoDinamico = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home.login.entidade")));
            campoDinamico.sendKeys("SEG");

            // Abrindo a janela de seleção de entidade
            navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
            navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text")).sendKeys(Keys.TAB);
            actions = new Actions(navegador);

            // Entrar no SEG DESENVOLVIMENTO
            new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

            //Abrir SGE (Cadastro de Pessoa).
            navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");


            // Clicar em "Cadastro".
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[8]/div")).click();
            //Pesquisa de Cadastro
            Thread.sleep(500);
            navegador.findElement(By.className("input-buscar")).sendKeys(nomeEtapa + Keys.ENTER);
            // Selecionar Cadastro
            Thread.sleep(500);
            Actions actions1 = new Actions(navegador);
            new Actions(navegador).moveByOffset(-70, 150).doubleClick().perform();
            // Selecionar "Alterar"
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[4]")).click();


            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            js = (JavascriptExecutor) navegador;
            mensagensErro = new StringBuilder();

            // Nome Etapa
            new Actions(navegador).moveByOffset(0, -180).click().sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNomeEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Nome Etapa está vazio
            if (valorCampoNomeEtapa == null || valorCampoNomeEtapa.isEmpty()) {
                mensagensErro.append("ERRO: O campo Nome Etapa está vazio.");
                System.out.println("ERRO: O campo Nome Etapa está vazio.");
            } else {
                System.out.println("O campo Nome Etapa foi preenchido com: " + valorCampoNomeEtapa);
            }

            // Descrição
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDescricaoEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Descrição está vazio
            if (valorCampoDescricaoEtapa == null || valorCampoDescricaoEtapa.isEmpty()) {
                mensagensErro.append("ERRO: O campo Descrição está vazio.");
                System.out.println("ERRO: O campo Descrição está vazio.");
            } else {
                System.out.println("O campo Descrição foi preenchido com: " + valorCampoDescricaoEtapa);
            }

            // Número Etapa
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNumeroEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Número Etapa está vazio
            if (valorCampoNumeroEtapa == null || valorCampoNumeroEtapa.isEmpty()) {
                mensagensErro.append("ERRO: O campo Número Etapa está vazio.");
                System.out.println("ERRO: O campo Número Etapa está vazio.");
            } else {
                System.out.println("O campo Número Etapa foi preenchido com: " + valorCampoNumeroEtapa);
            }

            // Tipo Etapa
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoTipoEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Tipo Etapa está vazio
            if (valorCampoTipoEtapa == null || valorCampoTipoEtapa.isEmpty()) {
                mensagensErro.append("ERRO: O campo Tipo Etapa está vazio.");
                System.out.println("ERRO: O campo Tipo Etapa está vazio.");
            } else {
                System.out.println("O campo Tipo Etapa foi preenchido com: " + valorCampoTipoEtapa);
            }

            // Grupo Ação
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoGrupoAcao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Ação está vazio
            if (valorCampoGrupoAcao == null || valorCampoGrupoAcao.isEmpty()) {
                mensagensErro.append("ERRO: O campo Grupo Ação está vazio.");
                System.out.println("ERRO: O campo Grupo Ação está vazio.");
            } else {
                System.out.println("O campo Grupo Ação foi preenchido com: " + valorCampoGrupoAcao);
            }

            // Local
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocal = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Local está vazio
            if (valorCampoLocal == null || valorCampoLocal.isEmpty()) {
                mensagensErro.append("ERRO: O campo Local está vazio.");
                System.out.println("ERRO: O campo Local Ação está vazio.");
            } else {
                System.out.println("O campo Local foi preenchido com: " + valorCampoLocal);
            }

            //Pulando datas
            new Actions(navegador).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

            // Local Avaliação
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalAvaliacao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Local está vazio
            if (valorCampoLocalAvaliacao == null || valorCampoLocalAvaliacao.isEmpty()) {
                mensagensErro.append("ERRO: O campo Local Avaliação está vazio.");
                System.out.println("ERRO: O campo Local Avaliação está vazio.");
            } else {
                System.out.println("O campo Local Avaliação foi preenchido com: " + valorCampoLocalAvaliacao);
            }

            //Pulando data
            new Actions(navegador).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

            // Meio de Comunicação
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMComunicacao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Meio de Comunicação está vazio
            if (valorCampoMComunicacao == null || valorCampoMComunicacao.isEmpty()) {
                mensagensErro.append("ERRO: O campo Meio de Comunicação está vazio.");
                System.out.println("ERRO: O campo Meio de Comunicação está vazio.");
            } else {
                System.out.println("O campo Meio de Comunicação foi preenchido com: " + valorCampoMComunicacao);
            }

            // Meio de Padroeiro
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPadroeiro = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Padroeiro está vazio
            if (valorCampoPadroeiro == null || valorCampoPadroeiro.isEmpty()) {
                mensagensErro.append("ERRO: O campo Padroeiro está vazio.");
                System.out.println("ERRO: O campo Padroeiro está vazio.");
            } else {
                System.out.println("O campo Meio de Padroeiro foi preenchido com: " + valorCampoPadroeiro);
            }

            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            String caminhoPasta = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Etapa//erros log//erros";
            String caminhoArquivo = caminhoPasta + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

            try {
                // Criar a pasta caso não exista
                File pasta = new File(caminhoPasta);
                if (!pasta.exists()) {
                    boolean mkdirs = pasta.mkdirs();
                }
                Thread.sleep(400);
                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                FileWriter writer = new FileWriter(caminhoArquivo, true);
                writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                writer.close();

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo);
            } catch (IOException e) {
                System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
            }

            Thread.sleep(500);


            // "INICIO DE CICLO DE ALTERAÇÃO" \\

            // Criar nome aleatório para o cadastro
            String nomeEtapaAlt = "TestEtapaAlt" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomeEtapaAlt.txt")) {
                writer.write(nomeEtapaAlt);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String descricaoetapa = "TSTSWD" + random.nextInt(1000);
            String[] tipoetapas2 = {"loteamento", "retiro", "curso", "Encontro", "movimento", "palestra", "pastoral", "seminário", "festa"};
            String tipoetapa2 = tipoetapas2[random.nextInt(tipoetapas2.length)];
            String[] gruposacao2 = {"124", "125", "126", "134", "136", "140", "142", "143", "146", "147"};
            String grupoacao2 = gruposacao2[random.nextInt(gruposacao2.length)];
            String[] comunicacoes2 = {"carta", "celular", "email", "facebook", "instagram", "skype", "sms", "teams", "340", "telegrama", "telegram", "whatsapp", "zoom"};
            String comunicacao2 = comunicacoes2[random.nextInt(comunicacoes2.length)];
            String numeroetapa2 = "1" + random.nextInt(1000);


            new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys(nomeEtapaAlt).sendKeys(Keys.TAB).perform();// Nome
            new Actions(navegador).sendKeys(descricaoetapa).sendKeys(Keys.TAB).perform();// Descrição
            new Actions(navegador).sendKeys(numeroetapa2).sendKeys(Keys.TAB).perform();// Número Etapa
            new Actions(navegador).sendKeys(tipoetapa2).sendKeys(Keys.TAB).perform();// Tipo Etapa
            new Actions(navegador).sendKeys(grupoacao2).sendKeys(Keys.TAB).perform();// Grupo Ação
            new Actions(navegador).sendKeys("aaaaa4").sendKeys(Keys.TAB).perform();// Local
            new Actions(navegador).sendKeys("10022021").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform(); // Inicio Etapa
            new Actions(navegador).sendKeys("10022021").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// Fim Etapa
            new Actions(navegador).sendKeys("aaaaa2").sendKeys(Keys.TAB).perform();// Local Avaliação
            new Actions(navegador).sendKeys("10022021").sendKeys(Keys.TAB).sendKeys("1611").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// Avaliação
            new Actions(navegador).sendKeys(comunicacao2).sendKeys(Keys.TAB).perform();// Meio de Comunicação
            new Actions(navegador).sendKeys("aaaaa7").sendKeys(Keys.TAB).perform();// Padroeiro

            // Salvar Cadastro
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[3]")).click();
            Thread.sleep(500);

            // Tirar print da tela ao final da execução do “loop”
            try {
                // Gerar um timestamp único para o nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

                // Caminho para salvar a captura de tela com o novo caminho
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Etapa//Cadastro alt//" + "Cadastro_Etapa_" + timestamp + ".png");

                // Salvar o arquivo de captura de tela
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                try {
                    // Espera antes de iniciar o próximo ciclo
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // Finalizar navegador ao final de cada execução
                {
                    navegador.quit();
                }
            }


            // "REABRIR NAVEGADOR PARA CONFERENCIA" \\

            nomeEtapaAlt = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomeEtapaAlt.txt"))) {
                nomeEtapaAlt = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }


            navegador = new ChromeDriver();
            //DIMENSÃO DA PÁGINA
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);


            // CONFIGURAR WEBDRIVER
            WebDriverManager.chromedriver().setup();

            // Abrir o o SEG
            navegador.get("https://app.seg.inf.br/novo/");

            // Login e senha para entrar na conta da SEG.
            navegador.findElement(By.xpath("//input[@id='home.login.login']")).sendKeys("JOAO.VICTOR");
            navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
            navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);

            // Espera para aparecer novo campo.
            wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
            campoDinamico = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("home.login.entidade")));
            campoDinamico.sendKeys("SEG");

            // Abrindo a janela de seleção de entidade
            navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
            navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text")).sendKeys(Keys.TAB);
            actions = new Actions(navegador);

            // Entrar no SEG DESENVOLVIMENTO
            new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

            //Abrir SGE (Cadastro de Pessoa).
            navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");


            // Clicar em "Cadastro".
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[8]/div")).click();
            //Pesquisa de Cadastro
            Thread.sleep(500);
            navegador.findElement(By.className("input-buscar")).sendKeys(nomeEtapaAlt + Keys.ENTER);
            // Selecionar Cadastro
            Thread.sleep(500);
            new Actions(navegador).moveByOffset(-70, 150).doubleClick().perform();
            // Selecionar "Alterar"
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[4]")).click();


            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            js = (JavascriptExecutor) navegador;
            mensagensErro = new StringBuilder();


            // Nome Etapa
            new Actions(navegador).moveByOffset(0, -180).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNomeEtapaAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Nome Etapa está vazio
            if (valorCampoNomeEtapaAlt == null || valorCampoNomeEtapaAlt.isEmpty()) {
                mensagensErro.append("ERRO: O campo Nome Etapa está vazio.");
                System.out.println("ERRO: O campo Nome Etapa está vazio.");
            } else {
                System.out.println("O campo Nome Etapa foi preenchido com: " + valorCampoNomeEtapaAlt);
            }

            // Descrição
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDescricaoAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Descrição está vazio
            if (valorCampoDescricaoAlt == null || valorCampoDescricaoAlt.isEmpty()) {
                mensagensErro.append("ERRO: O campo Descricao está vazio.");
                System.out.println("ERRO: O campo Descricao está vazio.");
            } else {
                System.out.println("O campo Descricao foi preenchido com: " + valorCampoDescricaoAlt);
            }

            // Número Etapa
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNumeroEtapaAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Número Etapa está vazio
            if (valorCampoNumeroEtapaAlt == null || valorCampoNumeroEtapaAlt.isEmpty()) {
                mensagensErro.append("ERRO: O campo Número Etapa está vazio.");
                System.out.println("ERRO: O campo Número Etapa está vazio.");
            } else {
                System.out.println("O campo Número Etapa foi preenchido com: " + valorCampoNumeroEtapaAlt);
            }

            // Tipo Etapa
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoTipoEtapaAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Tipo Etapa está vazio
            if (valorCampoTipoEtapaAlt == null || valorCampoTipoEtapaAlt.isEmpty()) {
                mensagensErro.append("ERRO: O campo Tipo Etapa está vazio.");
                System.out.println("ERRO: O campo Tipo Etapa está vazio.");
            } else {
                System.out.println("O campo Tipo Etapa foi preenchido com: " + valorCampoTipoEtapaAlt);
            }

            // Grupo Ação
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoGrupoAcaoAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Ação está vazio
            if (valorCampoGrupoAcaoAlt == null || valorCampoGrupoAcaoAlt.isEmpty()) {
                mensagensErro.append("ERRO: O campo Grupo Ação está vazio.");
                System.out.println("ERRO: O campo Grupo Ação está vazio.");
            } else {
                System.out.println("O campo Grupo Ação foi preenchido com: " + valorCampoGrupoAcaoAlt);
            }

            // Local
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Local está vazio
            if (valorCampoLocalAlt == null || valorCampoLocalAlt.isEmpty()) {
                mensagensErro.append("ERRO: O campo Local está vazio.");
                System.out.println("ERRO: O campo Local Ação está vazio.");
            } else {
                System.out.println("O campo Local foi preenchido com: " + valorCampoLocalAlt);
            }

            //Pulando datas
            new Actions(navegador).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

            // Local Avaliação
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalAvaliacaoAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Local está vazio
            if (valorCampoLocalAvaliacaoAlt == null || valorCampoLocalAvaliacaoAlt.isEmpty()) {
                mensagensErro.append("ERRO: O campo Local Avaliação está vazio.\\n");
                System.out.println("ERRO: O campo Local Avaliação está vazio.");
            } else {
                System.out.println("O campo Local Avaliação foi preenchido com: " + valorCampoLocalAvaliacaoAlt);
            }

            //Pulando data
            new Actions(navegador).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

            // Meio de Comunicação
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMComunicacaoAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Meio de Comunicação está vazio
            if (valorCampoMComunicacaoAlt == null || valorCampoMComunicacaoAlt.isEmpty()) {
                mensagensErro.append("ERRO: O campo Meio de Comunicação está vazio.");
                System.out.println("ERRO: O campo Meio de Comunicação está vazio.");
            } else {
                System.out.println("O campo Meio de Comunicação foi preenchido com: " + valorCampoMComunicacaoAlt);
            }

            // Meio de Padroeiro
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPadroeiroAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Padroeiro está vazio
            if (valorCampoPadroeiroAlt == null || valorCampoPadroeiroAlt.isEmpty()) {
                mensagensErro.append("ERRO: O campo Padroeiro está vazio.");
                System.out.println("ERRO: O campo Padroeiro está vazio.");
            } else {
                System.out.println("O campo Meio de Padroeiro foi preenchido com: " + valorCampoPadroeiroAlt);
            }


            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            String caminhoPasta18 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Etapa//erros log alt//erros";
            String caminhoArquivo18 = caminhoPasta18 + "erroslogalt" + timestamp + ".txt"; // Nome fixo do arquivo

            try {
                // Criar a pasta caso não exista
                File pasta = new File(caminhoPasta18);
                if (!pasta.exists()) {
                    boolean mkdirs = pasta.mkdirs();
                }

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                FileWriter writer = new FileWriter(caminhoArquivo18, true);
                writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                writer.close();

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo18);
            } catch (IOException e) {
                System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
            }

            //Excluir Cadastro
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[5]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
            Thread.sleep(1000);

            // Finalizar navegador ao final de cada execução
            {
                navegador.quit();
            }



// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / /// "ABRIR NAVEGADOR PARA CADASTRAR "GRUPO"" \\/ / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /



            // Criar nome aleatório para o cadastro
            random = new Random();
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
            navegador = new ChromeDriver();

            // Definindo o tamanho da janela do navegador
            tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);


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
                actions = new Actions(navegador);

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
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
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
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();

                //ETAPA
                new Actions(navegador).moveByOffset(40, -285).doubleClick().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEtapaGrupo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Etapa está vazio
                if (valorCampoEtapaGrupo == null || valorCampoEtapaGrupo.isEmpty()) {mensagensErro.append("ERRO: O campo Etapa está vazio.");
                    System.out.println("ERRO: O campo Etapa está vazio.");}
                else {System.out.println("O campo Etapa foi preenchido com: " + valorCampoEtapaGrupo);}

                //EQUIPE
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoEquipeGrupo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Equipe está vazio
                if (valorCampoEquipeGrupo == null || valorCampoEquipeGrupo.isEmpty()) {mensagensErro.append("ERRO: O campo Equipe está vazio.");
                    System.out.println("ERRO: O campo Equipe está vazio.");}
                else {System.out.println("O campo Equipe foi preenchido com: " + valorCampoEquipeGrupo);}

                //NOME
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeGrupo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Função está vazio
                if (valorCampoNomeGrupo == null || valorCampoNomeGrupo.isEmpty()) {mensagensErro.append("ERRO: O campo Nome está vazio.");
                    System.out.println("ERRO: O campo Nome está vazio.");}
                else {System.out.println("O campo Nome foi preenchido com: " + valorCampoNomeGrupo);}

                //SLOGAN
                new Actions(navegador).sendKeys().perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSloganGrupo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Slogan está vazio
                if (valorCampoSloganGrupo == null || valorCampoSloganGrupo.isEmpty()) {mensagensErro.append("ERRO: O campo Slogan está vazio.");
                    System.out.println("ERRO: O campo Slogan está vazio.");}
                else {System.out.println("O campo Slogan foi preenchido com: " + valorCampoSloganGrupo);}

                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                caminhoPasta = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//Cadastro//erros log//erros";
                caminhoArquivo = caminhoPasta + "erroslog" + timestamp + ".txt";

                try {
                    // Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta);
                    if (!pasta.exists()) {
                        boolean mkdirs = pasta.mkdirs();
                    }

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
                String caminhoPasta20 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//Cadastro//erros log alt//erros";
                String caminhoArquivo20 = caminhoPasta20 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {
                    // Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta20);
                    if (!pasta.exists()) {
                        boolean mkdirs = pasta.mkdirs();
                    }

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    FileWriter writer = new FileWriter(caminhoArquivo20, true);
                    writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                    writer.close();

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo20);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

                // Finalizar navegador ao final de cada execução
                {navegador.quit();}
            } catch (InterruptedException e) {throw new RuntimeException(e);}



//          //////////////
//          ///"PESSOA"///
//          //////////////

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
            timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//Pessoa//Cadastro//resultado_teste_" + timestamp + ".png");
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
            js = (JavascriptExecutor) navegador;
            mensagensErro = new StringBuilder();

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
                if (!pasta.exists()) {
                    boolean mkdirs = pasta.mkdirs();
                }

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                FileWriter writer = new FileWriter(caminhoArquivo7, true);
                writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                writer.close();

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo7);}
            catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

            Thread.sleep(500);
            // Finalizar navegador ao final de cada execução
            if (navegador != null) {navegador.quit();}



//            ///////////////
              //"PERGUNTAS"//
//            ///////////////

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

                // Entrar no SEG DESENVOLVIMENTO
                new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

                // Abrir SGE (Cadastro de Grupo)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

                //Clicar em Grupo
                Thread.sleep(400);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[4]/div")).click();

                // Clicar em Perguntas
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
                String caminhoPasta21 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo//Perguntas//erros log//erros";
                String caminhoArquivo21 = caminhoPasta21 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta21);
                    if (!pasta.exists()) {
                        boolean mkdirs = pasta.mkdirs();
                    }

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    FileWriter writer = new FileWriter(caminhoArquivo21, true);
                    writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                    writer.close();

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo21);}
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
