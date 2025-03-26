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
        WebDriver navegador;
        while (true) {

            // Criar nome aleatório para o cadastro
            Random random = new Random();
            String nomeEtapa = "TestEtapa" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomeEtapa.txt")) {
                writer.write(nomeEtapa);
            } catch (IOException e) {
                e.printStackTrace();
            }


            // Driver
            WebDriverManager.chromedriver().setup();
            navegador = new ChromeDriver();


            // Abrir o SEG
            navegador.get("https://app.seg.inf.br/novo/");


            // Login e senha para entrar na conta da SEG.
            navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                    .sendKeys("JOAO.VICTOR");
            navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
            navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);


            // Espera para aparecer novo campo.
            WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
            WebElement campoDinamico = wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.id("home.login.entidade")));
            campoDinamico.sendKeys("SEG");


            // Abrindo a janela de seleção de entidade
            navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
            navegador.findElement(By.id("home.login.entidade.entidade-modal.entidade-text"))
                    .sendKeys(Keys.TAB);
            Actions actions = new Actions(navegador);

            // Entrar no SEG DESENVOLVIMENTO
            new Actions(navegador).moveByOffset(350, 180).doubleClick().perform();

            // Abrir SGE (Cadastro de Pessoa).
            navegador.get("https://app.seg.inf.br/novo/user/sge_base_etapa");

            // Gerar dados dinâmicos para a pessoa
            String descricao = "TSTSWD" + random.nextInt(1000);
            String[] tipoetapas = {"loteamento", "retiro", "curso", "Encontro", "movimento",
                    "palestra", "pastoral", "seminário", "festa"};
            String tipoetapa = tipoetapas[random.nextInt(tipoetapas.length)];
            String[] gruposacao = {"124", "125", "126", "134", "136", "140", "142", "143", "146", "147"};
            String grupoacao = gruposacao[random.nextInt(gruposacao.length)];
            String[] comunicacoes = {"carta", "celular", "email", "facebook", "instagram", "skype", "sms"
                    , "teams", "340", "telegrama", "telegram", "whatsapp", "zoom"};
            String comunicacao = comunicacoes[random.nextInt(comunicacoes.length)];
            String numeroetapa = "1" + random.nextInt(1000);

            // Clicar em "Cadastro".
            Thread.sleep(1000);
            new Actions(navegador).moveByOffset(500, -15).click().perform();


            // Clicar em "Novo".
            Thread.sleep(1000);
            new Actions(navegador).moveByOffset(-20, 20).click().perform();

            // Nome
            Thread.sleep(1000);
            new Actions(navegador).moveByOffset(-400, -5).click().sendKeys(nomeEtapa).perform();
            // Descrição
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 25).click().sendKeys(descricao).perform();
            // Número Etapa
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 25).click().sendKeys(numeroetapa).perform();
            // Tipo Etapa
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 35).click().sendKeys(tipoetapa).perform();
            // Grupo Ação
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 40).click().sendKeys(grupoacao).perform();
            // Local
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 35).click().sendKeys("XXXXX1").perform();
            // Inicio Etapa
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 35).click().sendKeys("01012020").perform();
            // Fim Etapa
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 25).click().sendKeys("20012020").perform();
            // Local Avaliação
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 30).click().sendKeys("XXXXX2").perform();
            // Avaliação
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 35).click().sendKeys("20012020").sendKeys(Keys.TAB)
                    .sendKeys("1611").perform();
            // Meio de Comunicação
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 25).click().sendKeys(comunicacao)
                    .sendKeys(Keys.TAB).perform();
            // Padroeiro
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 35).sendKeys("xxxxx7").sendKeys(Keys.TAB).perform();
            // Etapa em Uso
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, -240).click().perform();
            // Finalizar Etapa
            // Thread.sleep(1000);
            // new Actions(navegador).moveByOffset(0, 30).click().perform();


            // "Salvar Cadastro"
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[3]")).click();
            Thread.sleep(500);


            // Tirar print da tela ao final da execução do “loop”
            try {
                // Gerar um timestamp único para o nome do arquivo
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

                // Caminho para salvar a captura de tela com o novo caminho
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Etapa//" + "Cadastro_Etapa_" + timestamp + ".png");

                // Salvar o arquivo de captura de tela
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


            // "REABRIR NAVEGADOR PARA CONFERENCIA" \\

            nomeEtapa = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomeEtapa.txt"))) {
                nomeEtapa = reader.readLine(); // Lê o nome salvo no arquivo
            } catch (IOException e) {
                e.printStackTrace();
            }


            navegador = new ChromeDriver();


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


            //Clicar em "Cadastro"
            Thread.sleep(1000);
            new Actions(navegador).moveByOffset(550, -15).click().perform();

            //Pesquisa de Cadastro
            Thread.sleep(1200);
            navegador.findElement(By.className("input-buscar")).sendKeys(nomeEtapa + Keys.ENTER);


            // Selecionar Cadastro
            Thread.sleep(1000);
            Actions actions1 = new Actions(navegador);
            new Actions(navegador).moveByOffset(-550, 170).doubleClick().perform();

            // Selecionar "Alterar"
            Thread.sleep(1000);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[4]")).click();


            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            JavascriptExecutor js = (JavascriptExecutor) navegador;
            StringBuilder mensagensErro = new StringBuilder();


            // Nome Etapa
            new Actions(navegador).moveByOffset(0, -180).click().sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(500);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNomeEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Nome Etapa está vazio
            if (valorCampoNomeEtapa == null || valorCampoNomeEtapa.isEmpty()) {
                mensagensErro.append("ERRO: O campo Nome Etapa está vazio.\\n");
                System.out.println("ERRO: O campo Nome Etapa está vazio.");
            } else {
                System.out.println("O campo Nome Etapa foi preenchido com: " + valorCampoNomeEtapa);
            }


            // Descrição
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDescricao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Descrição está vazio
            if (valorCampoDescricao == null || valorCampoDescricao.isEmpty()) {
                mensagensErro.append("ERRO: O campo Descricao está vazio.\\n");
                System.out.println("ERRO: O campo Descricao está vazio.");
            } else {
                System.out.println("O campo Descricao foi preenchido com: " + valorCampoDescricao);
            }


            // Número Etapa
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNumeroEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Número Etapa está vazio
            if (valorCampoNumeroEtapa == null || valorCampoNumeroEtapa.isEmpty()) {
                mensagensErro.append("ERRO: O campo Número Etapa está vazio.\\n");
                System.out.println("ERRO: O campo Número Etapa está vazio.");
            } else {
                System.out.println("O campo Número Etapa foi preenchido com: " + valorCampoNumeroEtapa);
            }


            // Tipo Etapa
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoTipoEtapa = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Tipo Etapa está vazio
            if (valorCampoNumeroEtapa == null || valorCampoTipoEtapa.isEmpty()) {
                mensagensErro.append("ERRO: O campo Tipo Etapa está vazio.\\n");
                System.out.println("ERRO: O campo Tipo Etapa está vazio.");
            } else {
                System.out.println("O campo Tipo Etapa foi preenchido com: " + valorCampoTipoEtapa);
            }


            // Grupo Ação
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoGrupoAcao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Ação está vazio
            if (valorCampoGrupoAcao == null || valorCampoGrupoAcao.isEmpty()) {
                mensagensErro.append("ERRO: O campo Grupo Ação está vazio.\\n");
                System.out.println("ERRO: O campo Grupo Ação está vazio.");
            } else {
                System.out.println("O campo Grupo Ação foi preenchido com: " + valorCampoGrupoAcao);
            }


            // Local
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocal = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Local está vazio
            if (valorCampoLocal == null || valorCampoLocal.isEmpty()) {
                mensagensErro.append("ERRO: O campo Local está vazio.\\n");
                System.out.println("ERRO: O campo Local Ação está vazio.");
            } else {
                System.out.println("O campo Local foi preenchido com: " + valorCampoLocal);
            }

            //Pulando datas
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

            // Local Avaliação
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalAvaliacao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Local está vazio
            if (valorCampoLocalAvaliacao == null || valorCampoLocalAvaliacao.isEmpty()) {
                mensagensErro.append("ERRO: O campo Local Avaliação está vazio.\\n");
                System.out.println("ERRO: O campo Local Avaliação está vazio.");
            } else {
                System.out.println("O campo Local Avaliação foi preenchido com: " + valorCampoLocalAvaliacao);
            }

            //Pulando data
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();


            // Meio de Comunicação
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMComunicacao = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Meio de Comunicação está vazio
            if (valorCampoMComunicacao == null || valorCampoMComunicacao.isEmpty()) {
                mensagensErro.append("ERRO: O campo Meio de Comunicação está vazio.\\n");
                System.out.println("ERRO: O campo Meio de Comunicação está vazio.");
            } else {
                System.out.println("O campo Meio de Comunicação foi preenchido com: " + valorCampoMComunicacao);
            }

            // Meio de Padroeiro
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPadroeiro = (String) js.executeScript("return document.activeElement.value;");
            // Verificar se o campo Padroeiro está vazio
            if (valorCampoPadroeiro == null || valorCampoPadroeiro.isEmpty()) {
                mensagensErro.append("ERRO: O campo Padroeiro está vazio.\\n");
                System.out.println("ERRO: O campo Padroeiro está vazio.");
            } else {
                System.out.println("O campo Meio de Padroeiro foi preenchido com: " + valorCampoPadroeiro);
            }

            // Definir o caminho e nome do arquivo
            String caminhoPasta = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Etapa//Erros na validação//erros";
            String caminhoArquivo = caminhoPasta + "erroslog.txt"; // Nome fixo do arquivo

            try {
                // Criar a pasta caso não exista
                File pasta = new File(caminhoPasta);
                if (!pasta.exists()) {
                    pasta.mkdirs();
                }

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                FileWriter writer = new FileWriter(caminhoArquivo, true);
                writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                writer.close();

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo);
            } catch (IOException e) {
                System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
            }

            Thread.sleep(3000);


            // INICIO DE CICLO DE ALTERAÇÃO

            // Criar nome aleatório para o cadastro
            String nomeEtapaAlteracao = "TestEtapa" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomeEtapaAlteração.txt")) {
                writer.write(nomeEtapaAlteracao);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String descricao2 = "TSTSWD" + random.nextInt(1000);
            String[] tipoetapas2 = {"loteamento", "retiro", "curso", "Encontro", "movimento",
                    "palestra", "pastoral", "seminário", "festa"};
            String tipoetapa2 = tipoetapas2[random.nextInt(tipoetapas2.length)];
            String[] gruposacao2 = {"124", "125", "126", "134", "136", "140", "142", "143", "146", "147"};
            String grupoacao2 = gruposacao2[random.nextInt(gruposacao2.length)];
            String[] comunicacoes2 = {"carta", "celular", "email", "facebook", "instagram", "skype", "sms"
                    , "teams", "340", "telegrama", "telegram", "whatsapp", "zoom"};
            String comunicacao2 = comunicacoes2[random.nextInt(comunicacoes2.length)];
            String numeroetapa2 = "1" + random.nextInt(1000);


            // Nome
            Thread.sleep(1000);
            new Actions(navegador).moveByOffset(0, 0).doubleClick().sendKeys(Keys.BACK_SPACE)
                    .sendKeys(nomeEtapaAlteracao).perform();
            // Descrição
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 25).doubleClick().sendKeys(Keys.BACK_SPACE)
                    .sendKeys(descricao2).perform();
            // Número Etapa
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 30).doubleClick().sendKeys(Keys.BACK_SPACE)
                    .sendKeys(numeroetapa2).perform();
            // Tipo Etapa
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 35).doubleClick().sendKeys(Keys.BACK_SPACE)
                    .sendKeys(tipoetapa2).perform();
            // Grupo Ação
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 40).doubleClick().sendKeys(Keys.BACK_SPACE)
                    .sendKeys(grupoacao2).perform();
            // Local
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 35).doubleClick().sendKeys(Keys.BACK_SPACE)
                    .sendKeys("XXXXX4").perform();
            // Local Avaliação
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 90).doubleClick().sendKeys(Keys.BACK_SPACE)
                    .sendKeys("XXXXX5").perform();
            // Meio de Comunicação
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 60).doubleClick().sendKeys(comunicacao2)
                    .sendKeys(Keys.TAB).perform();
            // Padroeiro
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 20).sendKeys("xxxxx3").perform();
            // Salvar Cadastro
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[3]")).click();



            // Tirar print da tela ao final da execução do “loop”
            try {
                // Gerar um timestamp único para o nome do arquivo
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

                // Caminho para salvar a captura de tela com o novo caminho
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Etapa//Alteração//" + "Cadastro_Etapa_" + timestamp + ".png");

                // Salvar o arquivo de captura de tela
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

            // "REABRIR NAVEGADOR PARA CONFERENCIA" \\

            nomeEtapaAlteracao = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomeEtapalteração.txt"))) {
                nomeEtapaAlteracao = reader.readLine(); // Lê o nome salvo no arquivo
            } catch (IOException e) {
                e.printStackTrace();
            }


            navegador = new ChromeDriver();


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


            //Clicar em "Cadastro"
            Thread.sleep(1000);
            new Actions(navegador).moveByOffset(550, -15).click().perform();

            //Pesquisa de Cadastro
            Thread.sleep(1200);
            navegador.findElement(By.className("input-buscar")).sendKeys(nomeEtapaAlteracao + Keys.ENTER);


            // Selecionar Cadastro
            Thread.sleep(2000);
            new Actions(navegador).moveByOffset(-550, 170).doubleClick().perform();

            // Selecionar "Alterar"
            Thread.sleep(1000);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[4]")).click();



            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
            JavascriptExecutor js2 = (JavascriptExecutor) navegador;
            StringBuilder mensagensErro2 = new StringBuilder();



            // Nome Etapa
            new Actions(navegador).moveByOffset(0, -180).click().sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(500);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNomeEtapa2 = (String) js2.executeScript("return document.activeElement.value;");
            // Verificar se o campo Nome Etapa está vazio
            if (valorCampoNomeEtapa2 == null || valorCampoNomeEtapa2.isEmpty()) {
                mensagensErro2.append("ERRO: O campo Nome Etapa está vazio.\\n");
                System.out.println("ERRO: O campo Nome Etapa está vazio.");
            } else {
                System.out.println("O campo Nome Etapa foi preenchido com: " + valorCampoNomeEtapa2);
            }


            // Descrição
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoDescricao2 = (String) js2.executeScript("return document.activeElement.value;");
            // Verificar se o campo Descrição está vazio
            if (valorCampoDescricao2 == null || valorCampoDescricao2.isEmpty()) {
                mensagensErro2.append("ERRO: O campo Descricao está vazio.\\n");
                System.out.println("ERRO: O campo Descricao está vazio.");
            } else {
                System.out.println("O campo Descricao foi preenchido com: " + valorCampoDescricao2);
            }


            // Número Etapa
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoNumeroEtapa2 = (String) js2.executeScript("return document.activeElement.value;");
            // Verificar se o campo Número Etapa está vazio
            if (valorCampoNumeroEtapa2 == null || valorCampoNumeroEtapa2.isEmpty()) {
                mensagensErro2.append("ERRO: O campo Número Etapa está vazio.\\n");
                System.out.println("ERRO: O campo Número Etapa está vazio.");
            } else {
                System.out.println("O campo Número Etapa foi preenchido com: " + valorCampoNumeroEtapa2);
            }


            // Tipo Etapa
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoTipoEtapa2 = (String) js2.executeScript("return document.activeElement.value;");
            // Verificar se o campo Tipo Etapa está vazio
            if (valorCampoNumeroEtapa2 == null || valorCampoTipoEtapa2.isEmpty()) {
                mensagensErro2.append("ERRO: O campo Tipo Etapa está vazio.\\n");
                System.out.println("ERRO: O campo Tipo Etapa está vazio.");
            } else {
                System.out.println("O campo Tipo Etapa foi preenchido com: " + valorCampoTipoEtapa2);
            }


            // Grupo Ação
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoGrupoAcao2 = (String) js2.executeScript("return document.activeElement.value;");
            // Verificar se o campo Grupo Ação está vazio
            if (valorCampoGrupoAcao2 == null || valorCampoGrupoAcao2.isEmpty()) {
                mensagensErro2.append("ERRO: O campo Grupo Ação está vazio.\\n");
                System.out.println("ERRO: O campo Grupo Ação está vazio.");
            } else {
                System.out.println("O campo Grupo Ação foi preenchido com: " + valorCampoGrupoAcao2);
            }


            // Local
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocal2 = (String) js2.executeScript("return document.activeElement.value;");
            // Verificar se o campo Local está vazio
            if (valorCampoLocal2 == null || valorCampoLocal2.isEmpty()) {
                mensagensErro2.append("ERRO: O campo Local está vazio.\\n");
                System.out.println("ERRO: O campo Local Ação está vazio.");
            } else {
                System.out.println("O campo Local foi preenchido com: " + valorCampoLocal2);
            }

            //Pulando datas
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();

            // Local Avaliação
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoLocalAvaliacao2 = (String) js2.executeScript("return document.activeElement.value;");
            // Verificar se o campo Local está vazio
            if (valorCampoLocalAvaliacao2 == null || valorCampoLocalAvaliacao2.isEmpty()) {
                mensagensErro2.append("ERRO: O campo Local Avaliação está vazio.\\n");
                System.out.println("ERRO: O campo Local Avaliação está vazio.");
            } else {
                System.out.println("O campo Local Avaliação foi preenchido com: " + valorCampoLocalAvaliacao2);
            }

            //Pulando data
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();


            // Meio de Comunicação
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoMComunicacao2 = (String) js2.executeScript("return document.activeElement.value;");
            // Verificar se o campo Meio de Comunicação está vazio
            if (valorCampoMComunicacao2 == null || valorCampoMComunicacao2.isEmpty()) {
                mensagensErro2.append("ERRO: O campo Meio de Comunicação está vazio.\\n");
                System.out.println("ERRO: O campo Meio de Comunicação está vazio.");
            } else {
                System.out.println("O campo Meio de Comunicação foi preenchido com: " + valorCampoMComunicacao2);
            }

            // Padroeiro
            new Actions(navegador).moveByOffset(0, 0).sendKeys(Keys.TAB).perform();
            // Espera para garantir que o campo foi clicado
            Thread.sleep(250);
            // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
            String valorCampoPadroeiro2 = (String) js2.executeScript("return document.activeElement.value;");
            // Verificar se o campo Padroeiro está vazio
            if (valorCampoPadroeiro2 == null || valorCampoPadroeiro2.isEmpty()) {
                mensagensErro2.append("ERRO: O campo Padroeiro está vazio.\\n");
                System.out.println("ERRO: O campo Padroeiro está vazio.");
            } else {
                System.out.println("O campo Padroeiro foi preenchido com: " + valorCampoPadroeiro2);
            }




            // Gerar um timestamp único para o nome do arquivo
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

            // Definir o caminho e nome do arquivo
            String caminhoPasta2 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Etapa//Erros na validação//erros";
            String caminhoArquivo2 = caminhoPasta2 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

            try {
                // Criar a pasta caso não exista
                File pasta = new File(caminhoPasta2);
                if (!pasta.exists()) {
                    pasta.mkdirs();
                }

                // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                FileWriter writer = new FileWriter(caminhoArquivo2, true);
                writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                writer.close();

                System.out.println("Arquivo de erro salvo em: " + caminhoArquivo2);
            } catch (IOException e) {
                System.out.println("Erro ao salvar o arquivo: " + e.getMessage());}

            //Excluir Cadastro
            Thread.sleep(2000);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/div[5]")).click();
            Thread.sleep(500);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
            Thread.sleep(4000);


            // Finalizar navegador ao final de cada execução
            if (navegador != null) {
                navegador.quit();
            }
        }

    }
}

