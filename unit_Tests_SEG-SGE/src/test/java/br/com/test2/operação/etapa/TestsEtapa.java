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

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

@DisplayName("Teste automatizado de cadastro número 1")
public class TestsEtapa {
    @SuppressWarnings("BusyWait")
    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {

        // Loop infinito para repetir o processo completo

        while (true) {

            // Driver
            WebDriverManager.chromedriver().setup();
            WebDriver navegador = new ChromeDriver();
            //DIMENSÃO DA PÁGINA
            Dimension tamanho = new Dimension(1024, 768);
            navegador.manage().window().setSize(tamanho);

            // Criar nome aleatório para o cadastro
            Random random = new Random();
            String nomeEtapa = "TestEtapa" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomeEtapa.txt")) {writer.write(nomeEtapa);}
            catch (IOException e) {e.printStackTrace();}

            // Abrir o SEG
            navegador.get("https://app.seg.inf.br/novo/");

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
            navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text")).sendKeys(Keys.TAB);
            Actions actions = new Actions(navegador);

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
            String timestamp;
            timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Etapa//Cadastro//resultado_teste_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            //FECHAR NAVEGADOR
            // Finalizar navegador ao final de cada execução
            {navegador.quit();}
            Thread.sleep(500);



                                                    // "REABRIR NAVEGADOR PARA CONFERENCIA" \\

            nomeEtapa = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomeEtapa.txt"))) {
                nomeEtapa = reader.readLine();}
            catch (IOException e) {e.printStackTrace();}

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
            JavascriptExecutor js = (JavascriptExecutor) navegador;
            StringBuilder mensagensErro = new StringBuilder();

            // Nome Etapa
            new Actions(navegador).moveByOffset(0, -180).click().sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNomeEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Nome Etapa está vazio
            if (valorCampoNomeEtapa == null || valorCampoNomeEtapa.isEmpty()) {mensagensErro.append("ERRO: O campo Nome Etapa está vazio.");
                System.out.println("ERRO: O campo Nome Etapa está vazio.");}
            else {System.out.println("O campo Nome Etapa foi preenchido com: " + valorCampoNomeEtapa);}

            // Descrição
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDescricao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Descrição está vazio
            if (valorCampoDescricao == null || valorCampoDescricao.isEmpty()) {mensagensErro.append("ERRO: O campo Descrição está vazio.");
                System.out.println("ERRO: O campo Descrição está vazio.");}
            else {System.out.println("O campo Descrição foi preenchido com: " + valorCampoDescricao);}

            // Número Etapa
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNumeroEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Número Etapa está vazio
            if (valorCampoNumeroEtapa == null || valorCampoNumeroEtapa.isEmpty()) {mensagensErro.append("ERRO: O campo Número Etapa está vazio.");
                System.out.println("ERRO: O campo Número Etapa está vazio.");}
            else {System.out.println("O campo Número Etapa foi preenchido com: " + valorCampoNumeroEtapa);}

            // Tipo Etapa
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoTipoEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Tipo Etapa está vazio
            if (valorCampoTipoEtapa == null || valorCampoTipoEtapa.isEmpty()) {mensagensErro.append("ERRO: O campo Tipo Etapa está vazio.");
                System.out.println("ERRO: O campo Tipo Etapa está vazio.");}
            else {System.out.println("O campo Tipo Etapa foi preenchido com: " + valorCampoTipoEtapa);}

            // Grupo Ação
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoGrupoAcao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Ação está vazio
            if (valorCampoGrupoAcao == null || valorCampoGrupoAcao.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Ação está vazio.");
                System.out.println("ERRO: O campo Grupo Ação está vazio.");}
            else {System.out.println("O campo Grupo Ação foi preenchido com: " + valorCampoGrupoAcao);}

            // Local
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocal = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Local está vazio
            if (valorCampoLocal == null || valorCampoLocal.isEmpty()) {mensagensErro.append("ERRO: O campo Local está vazio.");
                System.out.println("ERRO: O campo Local Ação está vazio.");}
            else {System.out.println("O campo Local foi preenchido com: " + valorCampoLocal);}

            //Pulando datas
            new Actions(navegador).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

            // Local Avaliação
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalAvaliacao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Local está vazio
            if (valorCampoLocalAvaliacao == null || valorCampoLocalAvaliacao.isEmpty()) {mensagensErro.append("ERRO: O campo Local Avaliação está vazio.");
                System.out.println("ERRO: O campo Local Avaliação está vazio.");}
            else {System.out.println("O campo Local Avaliação foi preenchido com: " + valorCampoLocalAvaliacao);}

            //Pulando data
            new Actions(navegador).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

            // Meio de Comunicação
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMComunicacao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Meio de Comunicação está vazio
            if (valorCampoMComunicacao == null || valorCampoMComunicacao.isEmpty()) {mensagensErro.append("ERRO: O campo Meio de Comunicação está vazio.");
                System.out.println("ERRO: O campo Meio de Comunicação está vazio.");}
            else {System.out.println("O campo Meio de Comunicação foi preenchido com: " + valorCampoMComunicacao);}

            // Meio de Padroeiro
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPadroeiro = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Padroeiro está vazio
            if (valorCampoPadroeiro == null || valorCampoPadroeiro.isEmpty()) {mensagensErro.append("ERRO: O campo Padroeiro está vazio.");
                System.out.println("ERRO: O campo Padroeiro está vazio.");}
            else {System.out.println("O campo Meio de Padroeiro foi preenchido com: " + valorCampoPadroeiro);}

            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            String caminhoPasta = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Etapa//erros log//erros";
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

            // Criar nome aleatório para o cadastro
            String nomeEtapaAlt = "TestEtapaAlt" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomeEtapaAlt.txt"))
            {writer.write(nomeEtapaAlt);}
            catch (IOException e) {e.printStackTrace();}

            String descricao2 = "TSTSWD" + random.nextInt(1000);
            String[] tipoetapas2 = {"loteamento", "retiro", "curso", "Encontro", "movimento", "palestra", "pastoral", "seminário", "festa"};
            String tipoetapa2 = tipoetapas2[random.nextInt(tipoetapas2.length)];
            String[] gruposacao2 = {"124", "125", "126", "134", "136", "140", "142", "143", "146", "147"};
            String grupoacao2 = gruposacao2[random.nextInt(gruposacao2.length)];
            String[] comunicacoes2 = {"carta", "celular", "email", "facebook", "instagram", "skype", "sms", "teams", "340", "telegrama", "telegram", "whatsapp", "zoom"};
            String comunicacao2 = comunicacoes2[random.nextInt(comunicacoes2.length)];
            String numeroetapa2 = "1" + random.nextInt(1000);


            new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys(nomeEtapaAlt).sendKeys(Keys.TAB).perform();// Nome
            new Actions(navegador).sendKeys(descricao2).sendKeys(Keys.TAB).perform();// Descrição
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
            }
            catch (Exception e) {System.out.println("Erro: " + e.getMessage());}
            finally {
                try {
                    // Espera antes de iniciar o próximo ciclo
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {Thread.currentThread().interrupt();}

                // Finalizar navegador ao final de cada execução
                {navegador.quit();}
            }



                                                      // "REABRIR NAVEGADOR PARA CONFERENCIA" \\

            nomeEtapaAlt = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomeEtapaAlt.txt"))) {
                nomeEtapaAlt = reader.readLine();}
            catch (IOException e) {e.printStackTrace();}


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
            if (valorCampoNomeEtapaAlt == null || valorCampoNomeEtapaAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Nome Etapa está vazio.");
                System.out.println("ERRO: O campo Nome Etapa está vazio.");}
            else {System.out.println("O campo Nome Etapa foi preenchido com: " + valorCampoNomeEtapaAlt);}

            // Descrição
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDescricaoAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Descrição está vazio
            if (valorCampoDescricaoAlt == null || valorCampoDescricaoAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Descricao está vazio.");
                System.out.println("ERRO: O campo Descricao está vazio.");}
            else {System.out.println("O campo Descricao foi preenchido com: " + valorCampoDescricaoAlt);}

            // Número Etapa
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNumeroEtapaAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Número Etapa está vazio
            if (valorCampoNumeroEtapaAlt == null || valorCampoNumeroEtapaAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Número Etapa está vazio.");
                System.out.println("ERRO: O campo Número Etapa está vazio.");}
            else {System.out.println("O campo Número Etapa foi preenchido com: " + valorCampoNumeroEtapaAlt);}

            // Tipo Etapa
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoTipoEtapaAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Tipo Etapa está vazio
            if (valorCampoTipoEtapaAlt == null || valorCampoTipoEtapaAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Tipo Etapa está vazio.");
                System.out.println("ERRO: O campo Tipo Etapa está vazio.");}
            else {System.out.println("O campo Tipo Etapa foi preenchido com: " + valorCampoTipoEtapaAlt);}

            // Grupo Ação
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoGrupoAcaoAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Ação está vazio
            if (valorCampoGrupoAcaoAlt == null || valorCampoGrupoAcaoAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Grupo Ação está vazio.");
                System.out.println("ERRO: O campo Grupo Ação está vazio.");}
            else {System.out.println("O campo Grupo Ação foi preenchido com: " + valorCampoGrupoAcaoAlt);}

            // Local
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Local está vazio
            if (valorCampoLocalAlt == null || valorCampoLocalAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Local está vazio.");
                System.out.println("ERRO: O campo Local Ação está vazio.");}
            else {System.out.println("O campo Local foi preenchido com: " + valorCampoLocalAlt);}

            //Pulando datas
            new Actions(navegador).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

            // Local Avaliação
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalAvaliacaoAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Local está vazio
            if (valorCampoLocalAvaliacaoAlt == null || valorCampoLocalAvaliacaoAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Local Avaliação está vazio.\\n");
                System.out.println("ERRO: O campo Local Avaliação está vazio.");}
            else {System.out.println("O campo Local Avaliação foi preenchido com: " + valorCampoLocalAvaliacaoAlt);}

            //Pulando data
            new Actions(navegador).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

            // Meio de Comunicação
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMComunicacaoAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Meio de Comunicação está vazio
            if (valorCampoMComunicacaoAlt == null || valorCampoMComunicacaoAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Meio de Comunicação está vazio.");
                System.out.println("ERRO: O campo Meio de Comunicação está vazio.");}
            else {System.out.println("O campo Meio de Comunicação foi preenchido com: " + valorCampoMComunicacaoAlt);}

            // Meio de Padroeiro
            new Actions(navegador).sendKeys(Keys.TAB).perform();
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPadroeiroAlt = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Padroeiro está vazio
            if (valorCampoPadroeiroAlt == null || valorCampoPadroeiroAlt.isEmpty()) {mensagensErro.append("ERRO: O campo Padroeiro está vazio.");
                System.out.println("ERRO: O campo Padroeiro está vazio.");}
            else {System.out.println("O campo Meio de Padroeiro foi preenchido com: " + valorCampoPadroeiroAlt);}


            // Definir o caminho e nome do arquivo
            timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            String caminhoPasta2 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Etapa//erros log alt//erros";
            String caminhoArquivo2 = caminhoPasta2 + "erroslogalt" + timestamp + ".txt"; // Nome fixo do arquivo

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

            //Excluir Cadastro
            Thread.sleep(1000);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[5]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
            Thread.sleep(1000);

            // Finalizar navegador ao final de cada execução
            {navegador.quit();}
        }
    }
}

