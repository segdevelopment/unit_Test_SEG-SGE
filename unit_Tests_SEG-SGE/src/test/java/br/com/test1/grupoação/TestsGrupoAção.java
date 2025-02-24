package br.com.test1.grupoação;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import java.io.*;
import java.io.File;
import java.text.SimpleDateFormat;
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
        WebDriver navegador;
        Dimension tamanho;
        while (true) {
            // Criar nome aleatório para o cadastro
            Random random = new Random();
            String nomegrupoacao = "TestGASWD" + random.nextInt(10000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomegrupoacao.txt"))
            {writer.write(nomegrupoacao);}
            catch (IOException e) {e.printStackTrace();}

            // Criar nome aleatório para o cadastro de alteração
            String nomegaalteracao = "TestGAalt" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomegaalteracao.txt")) {writer.write(nomegaalteracao);}
            catch (IOException e) {e.printStackTrace();}

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

                Actions actions = new Actions(navegador);

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
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[5]")).click();


                                                                           // "CADASTRO" \\


                Thread.sleep(300);
                actions.moveByOffset(0, 30).click().sendKeys(Tipo).sendKeys(Keys.TAB).perform();//TIPO
                Thread.sleep(50);
                actions.sendKeys("908").sendKeys(Keys.TAB).perform();//MOTORISTA EQUIPE FUNÇÃO
                Thread.sleep(50);
                actions.sendKeys("239").sendKeys(Keys.TAB).perform();//Motorista Equipe
                Thread.sleep(50);
                actions.sendKeys("908").sendKeys(Keys.TAB).perform();//PASSAGEIRO EQUIPE FUNÇÃO
                Thread.sleep(50);
                actions.sendKeys("908").sendKeys(Keys.TAB).perform();//GRUPO PESSOA
                Thread.sleep(50);
                actions.sendKeys("908").sendKeys(Keys.TAB).perform();//FICHA
                Thread.sleep(50);
                actions.sendKeys(Comunicacao).sendKeys(Keys.TAB).perform();//COMUNICAÇÃO
                Thread.sleep(50);
                actions.sendKeys(Paroquia).sendKeys(Keys.TAB).perform();//PARÓQUIA
                Thread.sleep(50);
                actions.moveByOffset(0, 240).doubleClick().click().sendKeys(nomegrupoacao).sendKeys(Keys.TAB).perform();//NOME
                Thread.sleep(50);
                actions.sendKeys(sigla).sendKeys(Keys.TAB).perform();//SIGLA
                Thread.sleep(50);
                actions.sendKeys("X").sendKeys(Keys.TAB).perform();//SETOR ETAPA
                Thread.sleep(50);
                actions.moveByOffset(0, 80).click().sendKeys(Keys.TAB).perform();//AGRUPAR CASAL
                Thread.sleep(50);
                actions.sendKeys(modelos).perform();//GRUPO AÇÃO MODELO
                Thread.sleep(50);
                actions.moveByOffset(100, 35).click().perform();//PESSOA AUTORIZADA
                Thread.sleep(50);

                // "SALVAR CADASTRO"
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[6]")).click();
                Thread.sleep(150);

                // Capturar screenshot para análise visual.
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Cadastro//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            }
            catch (Exception e) {System.out.println("Erro: " + e.getMessage());
            }
            finally {
                try {
                    // Espera antes de iniciar o próximo ciclo
                    Thread.sleep(1500);}
                catch (InterruptedException e) {Thread.currentThread().interrupt();}

                // Finalizar navegador ao final de cada execução
                {navegador.quit();}
            }

            // "REABRIR O NAVEGADOR PARA CONFERÊNCIA" \\

            try (BufferedReader reader = new BufferedReader(new FileReader("nomegrupoacao.txt"))) {
                nomegrupoacao = reader.readLine();}
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

                Actions actions = new Actions(navegador);

                // Abrir SGE (Cadastro de Pessoa)
                navegador.get("https://app.seg.inf.br/novo/user/sge_base_gp_acao");

                //PESQUISA DE CADASTRO
                Thread.sleep(800);
                navegador.findElement(By.className("input-buscar")).sendKeys(nomegrupoacao + Keys.ENTER);
                // SELECIONAR CADASTRO
                Thread.sleep(800);
                actions.moveByOffset(-40, 105).doubleClick().perform();
                // CLICAR EM ALTERAR
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[7]")).click();

                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();

                // TIPO
                Thread.sleep(50);
                actions.moveByOffset(0, -70).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTipo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tipo está vazio
                if (valorCampoTipo == null || valorCampoTipo.isEmpty()) {mensagensErro.append("ERRO: O campo Tipo está vazio.");
                    System.out.println("ERRO: O campo Tipo está vazio.");}
                else {System.out.println("O campo Tipo foi preenchido com: " + valorCampoTipo);}

                // MOTORISTA EQUIPE FUNÇÃO
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoMEF = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo MEF está vazio
                if (valorCampoMEF == null || valorCampoMEF.isEmpty()) {mensagensErro.append("ERRO: O campo Motorista (Equipe Função) está vazio.");
                    System.out.println("ERRO: O campo Motorista (Equipe Função) está vazio.");}
                else {System.out.println("O campo Motorista (Equipe Função) foi preenchido com: " + valorCampoMEF);}

                // MOTORISTA EQUIPE
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoME = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo ME está vazio
                if (valorCampoME == null || valorCampoME.isEmpty()) {mensagensErro.append("ERRO: O campo Motorista (Equipe) está vazio.");
                    System.out.println("ERRO: O campo Motorista (Equipe) está vazio.");}
                else {System.out.println("O campo Motorista (Equipe) foi preenchido com: " + valorCampoME);}

                // Passageiro (Equipe Função)
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPEF = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Passageiro (Equipe Função) está vazio
                if (valorCampoPEF == null || valorCampoPEF.isEmpty()) {mensagensErro.append("ERRO: O campo Passageiro (Equipe Função) está vazio.");
                    System.out.println("ERRO: O campo Passageiro (Equipe Função) está vazio.");}
                else {System.out.println("O campo Passageiro (Equipe Função) foi preenchido com: " + valorCampoPEF);}

                // Grupo Pessoa (Equipe Função)
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoGPEF = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Grupo Pessoa (Equipe Função) está vazio
                if (valorCampoGPEF == null || valorCampoGPEF.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Pessoa (Equipe Função) está vazio");
                    System.out.println("ERRO: O campo Grupo Pessoa (Equipe Função) está vazio.");}
                else {System.out.println("O campo Grupo Pessoa (Equipe Função) foi preenchido com: " + valorCampoGPEF);}

                // Ficha (Equipe Função)
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFEF = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Ficha (Equipe Função) está vazio
                if (valorCampoFEF == null || valorCampoFEF.isEmpty()) {mensagensErro.append("ERRO: O campo Ficha (Equipe Função) está vazio.");
                    System.out.println("ERRO: O campo Grupo Ficha (Equipe Função) está vazio.");}
                else {System.out.println("O campo Grupo Ficha (Equipe Função) foi preenchido com: " + valorCampoFEF);}

                // Comunicação
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoComunicacao = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Comunicação está vazio
                if (valorCampoComunicacao == null || valorCampoComunicacao.isEmpty()) {mensagensErro.append("ERRO: O campo Comunicação está vazio.");
                    System.out.println("ERRO: O campo Comunicação está vazio.");}
                else {System.out.println("O campo Comunicação foi preenchido com: " + valorCampoComunicacao);}

                // Paroquia
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Paroquia está vazio
                if (valorCampoParoquia == null || valorCampoParoquia.isEmpty()) {mensagensErro.append("ERRO: O campo Paroquia está vazio.");
                    System.out.println("ERRO: O campo Paroquia está vazio.");}
                else {System.out.println("O campo Paroquia foi preenchido com: " + valorCampoParoquia);}

                // Nome
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNome = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome está vazio
                if (valorCampoNome == null || valorCampoNome.isEmpty()) {mensagensErro.append("ERRO: O campo Nome está vazio.");
                    System.out.println("ERRO: O campo Nome está vazio.");}
                else {System.out.println("O campo Nome foi preenchido com: " + valorCampoNome);}

                // Sigla
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSigla = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSigla == null || valorCampoSigla.isEmpty()) {mensagensErro.append("ERRO: O campo Sigla está vazio.");
                    System.out.println("ERRO: O campo Sigla está vazio.");}
                else {System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla);}

                // Setor Etapa
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSetorEtapa = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Setor Etapa está vazio
                if (valorCampoSetorEtapa == null || valorCampoSetorEtapa.isEmpty()) {mensagensErro.append("ERRO: O campo Setor Etapa está vazio.");
                    System.out.println("ERRO: O campo Setor Etapa está vazio.");}
                else {System.out.println("O campo Setor Etapa foi preenchido com: " + valorCampoSetorEtapa);}

                // Grupo Ação Modelo
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoGAM = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Grupo Ação Modelo está vazio
                if (valorCampoGAM == null || valorCampoGAM.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Ação Modelo está vazio.");
                    System.out.println("ERRO: O campo Grupo Ação Modelo está vazio.");}
                else {System.out.println("O campo Grupo Ação Modelo foi preenchido com: " + valorCampoGAM);}


                // Definir o caminho e nome do arquivo
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta7 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Cadastro//erros log//erro";
                String caminhoArquivo7 = caminhoPasta7 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta7);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo7, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }
                }
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}
                Thread.sleep(1500);

            }
            catch (InterruptedException e) {throw new RuntimeException(e);}



                                                    // INICIO DE CICLO DE ALTERAÇÃO \\
                                                       //"ALTERAÇÃO DE CADASTRO"\\

            Actions actions = new Actions(navegador);
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
            Thread.sleep(400);
            actions.moveByOffset(-60, -65).doubleClick().sendKeys(TipoAlt).sendKeys(Keys.TAB).perform();//TIPO
            Thread.sleep(50);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(50);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(50);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(50);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(50);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(50);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(50);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(50);
            actions.sendKeys(nomegaalteracao).sendKeys(Keys.TAB).perform();//NOME
            Thread.sleep(50);
            actions.sendKeys(siglaAlt).sendKeys(Keys.TAB).perform();//SIGLA
            Thread.sleep(50);
            actions.sendKeys("I").sendKeys(Keys.TAB).perform();//SETOR ETAPA
            Thread.sleep(50);

            // "SALVAR CADASTRO"
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[6]")).click();
            Thread.sleep(400);

            // Capturar screenshot para análise visual.
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Cadastro//Cadastro alt//resultado_teste_Alt" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            // Finalizar navegador ao final de cada execução
            {navegador.quit();}



                                                // "REABRIR NAVEGADOR PARA CONFERENCIA DE CADASTRO" \\

            nomegaalteracao = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomegaalteracao.txt")))
            {nomegaalteracao = reader.readLine();}
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
                // SELECIONAR CADASTRO
                Thread.sleep(800);
                actions.moveByOffset(-40, 105).doubleClick().perform();
                // CLICAR EM ALTERAR
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[7]")).click();

                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();

                // TIPO
                Thread.sleep(50);
                actions.moveByOffset(0, -70).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTipoAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tipo está vazio
                if (valorCampoTipoAlt == null || valorCampoTipoAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Tipo está vazio.");
                    System.out.println("ERRO: O campo Tipo está vazio.");}
                else {System.out.println("O campo Tipo foi preenchido com: " + valorCampoTipoAlt);}

                // MOTORISTA EQUIPE FUNÇÃO
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoMEFAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo MEF está vazio
                if (valorCampoMEFAlt == null || valorCampoMEFAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Motorista (Equipe Função) está vazio.");
                    System.out.println("ERRO: O campo Motorista (Equipe Função) está vazio.");}
                else {System.out.println("O campo Motorista (Equipe Função) foi preenchido com: " + valorCampoMEFAlt);}

                // MOTORISTA EQUIPE
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoMEAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo ME está vazio
                if (valorCampoMEAlt == null || valorCampoMEAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Motorista (Equipe) está vazio.");
                    System.out.println("ERRO: O campo Motorista (Equipe) está vazio.");}
                else {System.out.println("O campo Motorista (Equipe) foi preenchido com: " + valorCampoMEAlt);}

                // Passageiro (Equipe Função)
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPEFAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Passageiro (Equipe Função) está vazio
                if (valorCampoPEFAlt == null || valorCampoPEFAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Passageiro (Equipe Função) está vazio.");
                    System.out.println("ERRO: O campo Passageiro (Equipe Função) está vazio.");}
                else {System.out.println("O campo Passageiro (Equipe Função) foi preenchido com: " + valorCampoPEFAlt);}

                // Grupo Pessoa (Equipe Função)
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoGPEFAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Grupo Pessoa (Equipe Função) está vazio
                if (valorCampoGPEFAlt == null || valorCampoGPEFAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Pessoa (Equipe Função) está vazio.");
                    System.out.println("ERRO: O campo Grupo Pessoa (Equipe Função) está vazio.");}
                else {System.out.println("O campo Grupo Pessoa (Equipe Função) foi preenchido com: " + valorCampoGPEFAlt);}

                // Ficha (Equipe Função)
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFEFAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Ficha (Equipe Função) está vazio
                if (valorCampoFEFAlt == null || valorCampoFEFAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Ficha (Equipe Função) está vazio.");
                    System.out.println("ERRO: O campo Grupo Ficha (Equipe Função) está vazio.");}
                else {System.out.println("O campo Grupo Ficha (Equipe Função) foi preenchido com: " + valorCampoFEFAlt);}

                // Comunicação
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoComunicacaoAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Comunicação está vazio
                if (valorCampoComunicacaoAlt == null || valorCampoComunicacaoAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Comunicação está vazio.");
                    System.out.println("ERRO: O campo Comunicação está vazio.");}
                else {System.out.println("O campo Comunicação foi preenchido com: " + valorCampoComunicacaoAlt);}

                // Paroquia
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoParoquiaAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Paroquia está vazio
                if (valorCampoParoquiaAlt == null || valorCampoParoquiaAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Paroquia está vazio.");
                    System.out.println("ERRO: O campo Paroquia está vazio.");}
                else {System.out.println("O campo Paroquia foi preenchido com: " + valorCampoParoquiaAlt);}

                // Nome
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome está vazio
                if (valorCampoNomeAlt == null || valorCampoNomeAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Nome está vazio.");
                    System.out.println("ERRO: O campo Nome está vazio.");}
                else {System.out.println("O campo Nome foi preenchido com: " + valorCampoNomeAlt);}

                // Sigla
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSiglaAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSiglaAlt == null || valorCampoSiglaAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Sigla está vazio.");
                    System.out.println("ERRO: O campo Sigla está vazio.");}
                else {System.out.println("O campo Sigla foi preenchido com: " + valorCampoSiglaAlt);}

                // Setor Etapa
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSetorEtapaAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Setor Etapa está vazio
                if (valorCampoSetorEtapaAlt == null || valorCampoSetorEtapaAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Setor Etapa está vazio.");
                    System.out.println("ERRO: O campo Setor Etapa está vazio.");}
                else {System.out.println("O campo Setor Etapa foi preenchido com: " + valorCampoSetorEtapaAlt);}

                // Grupo Ação Modelo
                Thread.sleep(50);
                actions.sendKeys().sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoGAMAlt = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Grupo Ação Modelo está vazio
                if (valorCampoGAMAlt == null || valorCampoGAMAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Ação Modelo está vazio.");
                    System.out.println("ERRO: O campo Grupo Ação Modelo está vazio.");}
                else {System.out.println("O campo Grupo Ação Modelo foi preenchido com: " + valorCampoGAMAlt);}

                Thread.sleep(1000);


                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta8 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Cadastro//erros log alt//erros log//erro";
                String caminhoArquivo8 = caminhoPasta8 + "erroslogAlt" + timestamp + ".txt";

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta8);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo8, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo8);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}


                // Finalizar navegador ao final de cada execução
                {navegador.quit();}

            }
            catch (InterruptedException e) {throw new RuntimeException(e);}

// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / /// "ABRIR NAVEGADOR PARA CADASTRAR "ACESSO"" \\/ / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /
// / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / / /


            nomegaalteracao = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomegaalteracao.txt")))
            {nomegaalteracao = reader.readLine();}
            catch (IOException e) {e.printStackTrace();}

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

                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, -30).click().sendKeys("BRASÍLIA").sendKeys(Keys.TAB).perform();// ARQUIDIOCESE
                Thread.sleep(50);
                new Actions(navegador).sendKeys(VicariatoParoquia).sendKeys(Keys.TAB).perform();// VICARIATO PARÓQUIA
                Thread.sleep(50);
                new Actions(navegador).sendKeys("I").sendKeys(Keys.ENTER).perform();// SETOR PAROQUIA
                Thread.sleep(50);

                // SALVAR CADASTRO
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]")).click();
                Thread.sleep(400);

                // Capturar screenshot para análise visual
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Acesso//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());
            }
            catch (Exception e) {System.out.println("Erro: " + e.getMessage());
            }
            finally {
                try {
                    // Espera antes de iniciar o próximo ciclo
                    Thread.sleep(1500);
                }
                catch (InterruptedException e) {Thread.currentThread().interrupt();}

                // Finalizar navegador ao final de cada execução
                {navegador.quit();}
            }



                                                // "Reabrir o navegador para conferência de cadastro" \\

            nomegaalteracao = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomegaalteracao.txt")))
            {nomegaalteracao = reader.readLine();}
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
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();

                // ARQUIDIOCESE
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, -170).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeArquidiocese = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Arquidiocese está vazio
                if (valorCampoNomeArquidiocese == null || valorCampoNomeArquidiocese.isEmpty()) {mensagensErro.append("ERRO: O campo Arquidiocese está vazio.");
                    System.out.println("ERRO: O campo Arquidiocese está vazio.");}
                else {System.out.println("O campo Arquidiocese foi preenchido com: " + valorCampoNomeArquidiocese);}

                // VICARIATO PAROQUIA
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeVicariatoParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoNomeVicariatoParoquia == null || valorCampoNomeVicariatoParoquia.isEmpty()) {mensagensErro.append("ERRO: O campo Vicariato Paroquia está vazio.");
                    System.out.println("ERRO: O campo Vicariato Paroquia está vazio.");}
                else {System.out.println("O campo Vicariato Paroquia foi preenchido com: " + valorCampoNomeVicariatoParoquia);}

                // SETOR PAROQUIA
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSetorParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Setor Paroquia está vazio
                if (valorCampoNomeVicariatoParoquia == null || valorCampoSetorParoquia.isEmpty()) {mensagensErro.append("ERRO: O campo Setor Paroquia está vazio.");
                    System.out.println("ERRO: O campo Setor Paroquia está vazio.");}
                else {System.out.println("O campo Setor Paroquia foi preenchido com: " + valorCampoSetorParoquia);}

                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta9 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Acesso//erros log//erro";
                String caminhoArquivo9 = caminhoPasta9 + "erroslogAlt" + timestamp + ".txt";

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta9);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo9, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo9);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}


                // "INICIO DE ALTERAÇÃO DE CADASTRO" \\

                //GERAÇÃO DE DADOS DINÂMICOS
                random = new Random();
                String[] VicariatosParoquiaAlt = {"CENTRO", "LAGO SUL", "LESTE", "NORTE", "SUL"};
                String VicariatoParoquiaAlt = VicariatosParoquiaAlt[random.nextInt(VicariatosParoquiaAlt.length)];

                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 0).doubleClick().sendKeys("BRASÍLIA").sendKeys(Keys.TAB).perform();// ARQUIDIOCESE
                Thread.sleep(50);
                new Actions(navegador).sendKeys(VicariatoParoquiaAlt).sendKeys(Keys.TAB).perform();// VICARIATO PARÓQUIA
                Thread.sleep(50);
                new Actions(navegador).sendKeys("I").sendKeys(Keys.ENTER).perform();// SETOR PAROQUIA
                Thread.sleep(50);

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
                try {Thread.sleep(1500);}
                catch (InterruptedException e) {Thread.currentThread().interrupt();}

                // Finalizar navegador ao final de cada execução
                {navegador.quit();}
            }



                                                    // "REABRIR PARA CONFERENCIA DE ALTERAÇÃO DE CADASTRO" \\

            nomegaalteracao = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomegaalteracao.txt")))
            {nomegaalteracao = reader.readLine();}
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
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();

                // ARQUIDIOCESE
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, -170).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeArquidiocese = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Arquidiocese está vazio
                if (valorCampoNomeArquidiocese == null || valorCampoNomeArquidiocese.isEmpty()) {mensagensErro.append("ERRO: O campo Arquidiocese está vazio.");
                    System.out.println("ERRO: O campo Arquidiocese está vazio.");}
                else {System.out.println("O campo Arquidiocese foi preenchido com: " + valorCampoNomeArquidiocese);}

                // VICARIATO PAROQUIA
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomeVicariatoParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Vicariato Paroquia está vazio
                if (valorCampoNomeVicariatoParoquia == null || valorCampoNomeVicariatoParoquia.isEmpty()) {mensagensErro.append("ERRO: O campo Vicariato Paroquia está vazio.");
                    System.out.println("ERRO: O campo Vicariato Paroquia está vazio.");}
                else {System.out.println("O campo Vicariato Paroquia foi preenchido com: " + valorCampoNomeVicariatoParoquia);}

                // SETOR PAROQUIA
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSetorParoquia = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Setor Paroquia está vazio
                if (valorCampoNomeVicariatoParoquia == null || valorCampoSetorParoquia.isEmpty()) {mensagensErro.append("ERRO: O campo Setor Paroquia está vazio.");
                    System.out.println("ERRO: O campo Setor Paroquia está vazio.");}
                else {System.out.println("O campo Setor Paroquia foi preenchido com: " + valorCampoSetorParoquia);}

                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta10 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Acesso//erros log alt//erro";
                String caminhoArquivo10 = caminhoPasta10 + "erroslogAlt" + timestamp + ".txt";

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta10);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo10, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo10);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

                // Excluir cadastro após testes realizados
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/div[2]/div[4]")).click();
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]"));


                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(1500);}
            catch (InterruptedException e) {Thread.currentThread().interrupt();}

            // Finalizar navegador ao final de cada execução
            {navegador.quit();}


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
            try (FileWriter writer = new FileWriter("nomega.txt"))
            {writer.write(temaga);}
            catch (IOException e) {e.printStackTrace();}

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
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[4]/div")).click();
                // NOVO
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]")).click();

                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, -30).click().sendKeys(modeloga).perform();// MODELO GRUPO AÇÃO
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(ncirculo).perform();// Nº DO CÍRCULO
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(temaga).perform();// TEMA
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, 30).click().sendKeys(descricao).perform();// DESCRIÇÃO
                Thread.sleep(50);

                // SALVAR CADASTRO
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
                Thread.sleep(800);

                // Capturar screenshot para análise visual
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Tema//Cadastro//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            }
            catch (Exception e) {System.out.println("Erro: " + e.getMessage());}
            finally {
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {Thread.currentThread().interrupt();}

                // Finalizar navegador ao final de cada execução
                {navegador.quit();}
            }



                                                        //"REABRIR PARA CONFERENCIA DE CADASTRO"\\

            temaga = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("temaga.txt"))) {
                temaga = reader.readLine();}
            catch (IOException e) {e.printStackTrace();}

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

                Thread.sleep(800);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[4]/div")).click();

                // SELECIONAR CADASTRO
                Thread.sleep(800);
                actions.moveByOffset(-40, 175).doubleClick().perform();

                // CLICAR EM ALTERAR
                Thread.sleep(800);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();

                // MODELO GRUPO AÇÃO
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, -230).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoMGA = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo MODELO GRUPO AÇÃO está vazio
                if (valorCampoMGA == null || valorCampoMGA.isEmpty()) {mensagensErro.append("ERRO: O campo MODELO GRUPO AÇÃO está vazio.");
                    System.out.println("ERRO: O campo MODELO GRUPO AÇÃO está vazio.");}
                else {System.out.println("O campo MODELO GRUPO AÇÃO foi preenchido com: " + valorCampoMGA);}

                // Número do Círculo
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNCirculo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Número do Círculo está vazio
                if (valorCampoNCirculo == null || valorCampoNCirculo.isEmpty()) {mensagensErro.append("ERRO: O campo Número do Círculo está vazio.");
                    System.out.println("ERRO: O campo Número do Círculo está vazio.");}
                else {System.out.println("O campo Número do Círculo foi preenchido com: " + valorCampoNCirculo);}

                // TEMA
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTema = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tema está vazio
                if (valorCampoTema == null || valorCampoTema.isEmpty()) {mensagensErro.append("ERRO: O campo Tema está vazio.");
                    System.out.println("ERRO: O campo Tema está vazio.");}
                else {System.out.println("O campo Tema foi preenchido com: " + valorCampoTema);}

                // DESCRIÇÃO
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoDescricao = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Descricao está vazio
                if (valorCampoDescricao == null || valorCampoDescricao.isEmpty()) {mensagensErro.append("ERRO: O campo Descricao está vazio.");
                    System.out.println("ERRO: O campo Descricao está vazio.");}
                else {System.out.println("O campo Descricao foi preenchido com: " + valorCampoDescricao);}

                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta11 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Tema//erros log//erro";
                String caminhoArquivo11 = caminhoPasta11 + "erroslog" + timestamp + ".txt";

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta11);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo11, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo11);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
            }
            catch (InterruptedException e) {Thread.currentThread().interrupt();}



                                                         //"CICLO DE ALTERAÇÃO DE DADOS"\\

            random = new Random();
            String temaga2 = "TestGASWDAlt" + random.nextInt(10000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomega.txt")) {
                writer.write(temaga2);}
            catch (IOException e) {e.printStackTrace();}

            // Campos dinâmicos
            random = new Random();
            String ncirculo2 = "" + random.nextInt(10);
            String descricao2 = "Teste de descrição para tema " + random.nextInt(100);
            String[] modelosga2 = {"13"};
            String modeloga2 = modelosga2[random.nextInt(modelosga2.length)];

            // MODELO GRUPO AÇÃO
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(50, 50).click().sendKeys(ncirculo2).sendKeys(Keys.TAB).perform();// Nº DO CÍRCULO
            Thread.sleep(50);
            new Actions(navegador).sendKeys(temaga2).sendKeys(Keys.TAB).perform();// TEMA
            Thread.sleep(50);
            new Actions(navegador).sendKeys(descricao2).sendKeys(Keys.ENTER).perform();// DESCRIÇÃO
            Thread.sleep(50);

            // SALVAR CADASTRO
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
            JavascriptExecutor js = (JavascriptExecutor) navegador;
            StringBuilder mensagensErro = new StringBuilder();

            // MODELO GRUPO AÇÃO
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -260).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMGA = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo MODELO GRUPO AÇÃO está vazio
            if (valorCampoMGA == null || valorCampoMGA.isEmpty()) {mensagensErro.append("ERRO: O campo MODELO GRUPO AÇÃO está vazio.");
                System.out.println("ERRO: O campo MODELO GRUPO AÇÃO está vazio.");}
            else {System.out.println("O campo MODELO GRUPO AÇÃO foi preenchido com: " + valorCampoMGA);}

            // NÚMERO DO CÍRCULO
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNCirculo = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Número do Círculo está vazio
            if (valorCampoNCirculo == null || valorCampoNCirculo.isEmpty()) {mensagensErro.append("ERRO: O campo Número do Círculo está vazio.");
                System.out.println("ERRO: O campo Número do Círculo está vazio.");}
            else {System.out.println("O campo Número do Círculo foi preenchido com: " + valorCampoNCirculo);}

            // TEMA
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoTema = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Tema está vazio
            if (valorCampoTema == null || valorCampoTema.isEmpty()) {mensagensErro.append("ERRO: O campo Tema está vazio.");
                System.out.println("ERRO: O campo Tema está vazio.");}
            else {System.out.println("O campo Tema foi preenchido com: " + valorCampoTema);}

            // DESCRIÇÃO
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDescricao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Descricao está vazio
            if (valorCampoDescricao == null || valorCampoDescricao.isEmpty()) {mensagensErro.append("ERRO: O campo Descricao está vazio.");
                System.out.println("ERRO: O campo Descricao está vazio.");}
            else {System.out.println("O campo Descricao foi preenchido com: " + valorCampoDescricao);}

            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta12 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Tema// log alt//erro";
            String caminhoArquivo12 = caminhoPasta12 + "erroslog" + timestamp + ".txt";

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta12);
                if (!pasta.exists()) {pasta.mkdirs();}

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo12, true))) {
                    writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                    writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                }

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo12);}
            catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

            // Excluir cadastro após testes realizados
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[4]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]"));
            Thread.sleep(500);

            // Finalizar navegador ao final de cada execução
            {navegador.quit();}

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

                String[] nscirculo = {"77", "79"};
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

                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, -20).click().sendKeys(modeloga).sendKeys(Keys.TAB).perform();// MODELO GRUPO AÇÃO
                Thread.sleep(50);
                new Actions(navegador).sendKeys(ncirculo).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();// Nº DO CÍRCULO
                Thread.sleep(50);
                new Actions(navegador).sendKeys(sigla).sendKeys(Keys.TAB).perform();// SIGLA
                Thread.sleep(50);
                new Actions(navegador).sendKeys(npergunta).sendKeys(Keys.TAB).perform();// Nº DA PERGUNTA
                Thread.sleep(50);
                new Actions(navegador).sendKeys(pergunta).perform();// PERGUNTA
                Thread.sleep(50);

                // SALVAR CADASTRO
                Thread.sleep(250);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();

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
                {navegador.quit();}
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
                Thread.sleep(800);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[5]/div")).click();
                // SELECIONAR CADASTRO
                Thread.sleep(800);
                actions.moveByOffset(-40, 175).doubleClick().perform();
                // CLICAR EM ALTERAR
                Thread.sleep(800);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[3]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                js = (JavascriptExecutor) navegador;
                mensagensErro = new StringBuilder();

                // MODELO GRUPO AÇÃO
                Thread.sleep(50);
                new Actions(navegador).moveByOffset(0, -220).click().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoMGA2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo MODELO GRUPO AÇÃO está vazio
                if (valorCampoMGA2 == null || valorCampoMGA2.isEmpty()) {mensagensErro.append("ERRO: O campo MODELO GRUPO AÇÃO está vazio.");
                    System.out.println("ERRO: O campo MODELO GRUPO AÇÃO está vazio.");}
                else {System.out.println("O campo MODELO GRUPO AÇÃO foi preenchido com: " + valorCampoMGA2);}

                // Número do Círculo
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNCirculo2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Número do Círculo está vazio
                if (valorCampoNCirculo2 == null || valorCampoNCirculo2.isEmpty()) {mensagensErro.append("ERRO: O campo Número do Círculo está vazio.\\n");
                    System.out.println("ERRO: O campo Número do Círculo está vazio.");}
                else {System.out.println("O campo Número do Círculo foi preenchido com: " + valorCampoNCirculo2);}

                // TEMA
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTema2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tema está vazio
                if (valorCampoTema2 == null || valorCampoTema2.isEmpty()) {mensagensErro.append("ERRO: O campo Tema está vaz");
                    System.out.println("ERRO: O campo Tema está vazio.");}
                else {System.out.println("O campo Tema foi preenchido com: " + valorCampoTema2);}

                // DESCRIÇÃO
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoDescricao2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Descricao está vazio
                if (valorCampoDescricao2 == null || valorCampoDescricao2.isEmpty()) {mensagensErro.append("ERRO: O campo Descricao está vazio");
                    System.out.println("ERRO: O campo Descricao está vazio.");}
                else {System.out.println("O campo Descricao foi preenchido com: " + valorCampoDescricao2);}

                // SIGLA
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSigla2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSigla2 == null || valorCampoSigla2.isEmpty()) {mensagensErro.append("ERRO: O campo Sigla está vazio.");
                    System.out.println("ERRO: O campo Sigla está vazio.");}
                else {System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla2);}

                // N PERGUNTA
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNPergunta2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo N PERGUNTA está vazio
                if (valorCampoNPergunta2 == null || valorCampoNPergunta2.isEmpty()) {mensagensErro.append("ERRO: O campo N PERGUNTA está vazio.");
                    System.out.println("ERRO: O campo N PERGUNTA está vazio.");}
                else {System.out.println("O campo N PERGUNTA foi preenchido com: " + valorCampoNPergunta2);}

                // PERGUNTA
                Thread.sleep(50);
                new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoPergunta2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo PERGUNTA está vazio
                if (valorCampoPergunta2 == null || valorCampoPergunta2.isEmpty()) {mensagensErro.append("ERRO: O campo PERGUNTA está vazio.");
                    System.out.println("ERRO: O campo N PERGUNTA está vazio.");}
                else {System.out.println("O campo PERGUNTA foi preenchido com: " + valorCampoPergunta2);}


                // Definir o caminho e nome do arquivo
                timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String caminhoPasta13 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Pergunta//erros log//erro";
                String caminhoArquivo13 = caminhoPasta13 + "erroslog" + timestamp + ".txt";

                try {// Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta13);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo13, true))) {
                        writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                        writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                    }

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo13);}
                catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
            }
            catch (InterruptedException e) {Thread.currentThread().interrupt();}


            //                                               "ALTERAÇÃO DE DADOS CADASTRADOS"

            // Dados dinâmicos
            String[] nscirculo5 = {"77", "79"};
            String ncirculo5 = nscirculo5[random.nextInt(nscirculo5.length)];
            String sigla5 = "PergSiglaTest" + random.nextInt(100);
            String npergunta5 = "" + random.nextInt(10);
            String[] modelosga5 = {"13"};
            String modeloga5 = modelosga5[random.nextInt(modelosga5.length)];
            String pergunta5 = "Teste de pergunta" + random.nextInt(1000);

            //CADASTRO
            Thread.sleep(150);
            new Actions(navegador).moveByOffset(0, 50).doubleClick().sendKeys(ncirculo5)// Nº DO CÍRCULO
                    .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
            Thread.sleep(50);
            new Actions(navegador).sendKeys(sigla5).sendKeys(Keys.TAB).perform();// SIGLA
            Thread.sleep(50);
            new Actions(navegador).sendKeys(npergunta5).sendKeys(Keys.TAB).perform();// Nº DA PERGUNTA
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, 150).doubleClick().click().sendKeys(pergunta5).perform();// PERGUNTA
            Thread.sleep(50);

            // SALVAR CADASTRO
            Thread.sleep(150);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]")).click();
            Thread.sleep(150);
            //SAIR DO CADASTRO
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[6]")).click();
            Thread.sleep(400);

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
            Thread.sleep(50);
            new Actions(navegador).moveByOffset(0, -220).click().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            valorCampoMGA = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo MODELO GRUPO AÇÃO está vazio
            if (valorCampoMGA == null || valorCampoMGA.isEmpty()) {mensagensErro.append("ERRO: O campo MODELO GRUPO AÇÃO está vazio.");
                System.out.println("ERRO: O campo MODELO GRUPO AÇÃO está vazio.");}
            else {System.out.println("O campo MODELO GRUPO AÇÃO foi preenchido com: " + valorCampoMGA);}

            // NÚMERO DO CÍRCULO
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNCirculo4 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Número do Círculo está vazio
            if (valorCampoNCirculo4 == null || valorCampoNCirculo4.isEmpty()) {mensagensErro.append("ERRO: O campo Número do Círculo está vazio.");
                System.out.println("ERRO: O campo Número do Círculo está vazio.");}
            else {System.out.println("O campo Número do Círculo foi preenchido com: " + valorCampoNCirculo4);}

            // TEMA
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoTema4 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Tema está vazio
            if (valorCampoTema4 == null || valorCampoTema4.isEmpty()) {mensagensErro.append("ERRO: O campo Tema está vazio.");
                System.out.println("ERRO: O campo Tema está vazio.");}
            else {System.out.println("O campo Tema foi preenchido com: " + valorCampoTema4);}

            // DESCRIÇÃO
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDescricao4 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Descricao está vazio
            if (valorCampoDescricao4 == null || valorCampoDescricao4.isEmpty()) {mensagensErro.append("ERRO: O campo Descricao está vazio.");
                System.out.println("ERRO: O campo Descricao está vazio.");}
            else {System.out.println("O campo Descricao foi preenchido com: " + valorCampoDescricao4);}

            // SIGLA
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoSigla4 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Sigla está vazio
            if (valorCampoSigla4 == null || valorCampoSigla4.isEmpty()) {
                mensagensErro.append("ERRO: O campo Sigla está vazio.");System.out.println("ERRO: O campo Sigla está vazio.");}
            else {System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla4);}

            // N PERGUNTA
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNPergunta4 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo N PERGUNTA está vazio
            if (valorCampoNPergunta4 == null || valorCampoNPergunta4.isEmpty()) {mensagensErro.append("ERRO: O campo N PERGUNTA está vazio.");
                System.out.println("ERRO: O campo N PERGUNTA está vazio.");}
            else {System.out.println("O campo N PERGUNTA foi preenchido com: " + valorCampoNPergunta4);}

            // PERGUNTA
            Thread.sleep(50);
            new Actions(navegador).sendKeys().sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPergunta4 = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo PERGUNTA está vazio
            if (valorCampoPergunta4 == null || valorCampoPergunta4.isEmpty()) {mensagensErro.append("ERRO: O campo PERGUNTA está vazio.");
                System.out.println("ERRO: O campo N PERGUNTA está vazio.");}
            else {System.out.println("O campo PERGUNTA foi preenchido com: " + valorCampoPergunta4);}


            // Definir o caminho e nome do arquivo
            Thread.sleep(500);
            timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String caminhoPasta14 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Grupo Ação//Pergunta//erros log alt//erro";
            String caminhoArquivo14 = caminhoPasta14 + "erroslog" + timestamp + ".txt";

            try {// Criar a pasta caso não exista
                File pasta = new File(caminhoPasta14);
                if (!pasta.exists()) {pasta.mkdirs();}

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo14, true))) {
                    writer.write("Erros encontrados:" + System.lineSeparator()); // Adiciona quebra de linha
                    writer.write(mensagensErro + System.lineSeparator() + System.lineSeparator()); // Garante espaçamento
                }

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo14);}
            catch (IOException e) {System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

            // Excluir cadastro após testes realizados
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div[2]/div[2]/div[1]/div[2]/div[4]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]"));

            // EXCLUIR GRUPO AÇÃO
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[1]/div/div[1]/div")).click();
            Thread.sleep(250);

            Thread.sleep(250);

            Thread.sleep(250);

            // Espera antes de iniciar o próximo ciclo
            Thread.sleep(500);
            try {// Espera antes de iniciar o próximo ciclo
                Thread.sleep(500);
            }
            catch (InterruptedException e) {Thread.currentThread().interrupt();}

            // Finalizar navegador ao final de cada execução
            {navegador.quit();}
        }
    }
}