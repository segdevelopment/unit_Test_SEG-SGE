package br.com.test.pastoral;

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
public class TestsPastoral {

    @Test
    @DisplayName("SEG")
    public void testDeCadastroNumero1() throws Throwable {

        // Configurar o WebDriver
        WebDriverManager.chromedriver().setup();

        // “Loop” infinito para repetir o processo completo
        while (true) {

            // PASSO 1: Cadastro
            // Criar nome aleatório para o cadastro
            Random random = new Random();
            String nomePastoral = "TestPastoralSWD" + random.nextInt(1000);
            // Salvar o nome gerado em um arquivo
            try (FileWriter writer = new FileWriter("nomePastoral.txt")) {
                writer.write(nomePastoral);
            } catch (IOException e) {
                e.printStackTrace();
            }

            WebDriver navegador = new ChromeDriver();

            try {
                // ABRIR SEG
                navegador.get("https://app.seg.inf.br/novo/");


                // LOGIN
                navegador.findElement(By.xpath("//input[@id='home.login.login']"))
                        .sendKeys("JOAO.VICTOR");
                navegador.findElement(By.id("home.login.senha")).sendKeys("01082023");
                navegador.findElement(By.id("home.login.senha")).sendKeys(Keys.ENTER);


                // VISUALIZAR O CAMPO ENTIDADE
                WebDriverWait wait = new WebDriverWait(navegador, Duration.ofSeconds(10));
                WebElement campoDinamico = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("home.login.entidade")));
                campoDinamico.sendKeys("SEG");
                navegador.findElement(By.id("home.login.entidade")).sendKeys(Keys.ENTER);
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
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(500, -10).click().perform();

                // PREENCHER CAMPOS
                //PASTORAL
                Thread.sleep(1000);
                new Actions(navegador).moveByOffset(-400, -50).click().sendKeys(nomePastoral).sendKeys(Keys.TAB).perform();
                //SIGLA
                Thread.sleep(1000);
                new Actions(navegador).sendKeys(sigla).sendKeys(Keys.TAB).perform();
                //OBJETIVO
                Thread.sleep(1000);
                new Actions(navegador).sendKeys(objetivo).sendKeys(Keys.TAB).perform();
                //FORMA DE ATUAÇÃO
                Thread.sleep(1000);
                new Actions(navegador).sendKeys(formaatuacao).sendKeys(Keys.TAB).perform();
                //COMPOSIÇÃO
                Thread.sleep(1000);
                new Actions(navegador).sendKeys(composicao).sendKeys(Keys.TAB).perform();
                //TIPO
                Thread.sleep(1000);
                new Actions(navegador).sendKeys(tipo).sendKeys(Keys.ENTER).perform();


                // SALVAR CADASTRO
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[2]")).click();


                // Capturar screenshot para análise visual.
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
                File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//" +
                        "Cadastro de Paróquias//resultado_teste_" + timestamp + ".png");
                FileHandler.copy(screenshotFile, destinoFile);
                System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            } finally {
                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(1000); // Pausa de 3 segundos (ajuste conforme necessário)
                // Finalizar navegador ao final de cada execução
                if (navegador != null) {
                    navegador.quit();
                }
            }

            // ABRIR CONFERENCIA
            String nomeDaConferencia = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomePastoral.txt"))) {
                nomeDaConferencia = reader.readLine(); // Lê o nome salvo no arquivo
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Reabrir o navegador para conferência
            navegador = new ChromeDriver();

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
                navegador.get("https://app.seg.inf.br/novo/user/sge_pastoral_base");


                //Pesquisa de Cadastro
                Thread.sleep(1000);
                navegador.findElement(By.id("searchInput")).sendKeys(nomePastoral + Keys.ENTER);


                // Selecionar Cadastro
                Thread.sleep(2000);
                Actions actions1 = new Actions(navegador);
                new Actions(navegador).moveByOffset(50, 105).doubleClick().perform();

                // Selecionar "Alterar"
                Thread.sleep(1500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[3]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();


                // Nome Pastoral
                new Actions(navegador).moveByOffset(-90, -165).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomePastoral = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Pastoral está vazio
                if (valorCampoNomePastoral == null || valorCampoNomePastoral.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Nome Pastoral está vazio.\\n");
                    System.out.println("ERRO: O campo Nome Pastoral está vazio.");
                } else {
                    System.out.println("O campo Nome Pastoral foi preenchido com: " + valorCampoNomePastoral);
                }


                // Sigla
                new Actions(navegador).moveByOffset(0, 20).click().sendKeys().perform();
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


                // Objetivo
                new Actions(navegador).moveByOffset(0, 35).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoObjetivo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Objetivo está vazio
                if (valorCampoObjetivo == null || valorCampoObjetivo.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Objetivo está vazio.\\n");
                    System.out.println("ERRO: O campo Objetivo está vazio.");
                } else {
                    System.out.println("O campo Objetivo foi preenchido com: " + valorCampoObjetivo);
                }


                // Forma Atuação
                new Actions(navegador).moveByOffset(0, 100).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFormaAtuacao = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Forma Atuação está vazio
                if (valorCampoFormaAtuacao == null || valorCampoFormaAtuacao.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Forma Atuação está vazio.\\n");
                    System.out.println("ERRO: O campo Forma Atuação está vazio.");
                } else {
                    System.out.println("O campo Forma Atuação foi preenchido com: " + valorCampoFormaAtuacao);
                }


                // Composição
                new Actions(navegador).moveByOffset(0, 120).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoComposicao = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Composição está vazio
                if (valorCampoComposicao == null || valorCampoComposicao.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Composição está vazio.\\n");
                    System.out.println("ERRO: O campo Composição está vazio.");
                } else {
                    System.out.println("O campo Composição foi preenchido com: " + valorCampoComposicao);
                }


                // Tipo
                new Actions(navegador).moveByOffset(-30, 100).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTipo = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tipo está vazio
                if (valorCampoTipo == null || valorCampoTipo.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Tipo está vazio.\\n");
                    System.out.println("ERRO: O campo Tipo está vazio.");
                } else {
                    System.out.println("O campo Tipo foi preenchido com: " + valorCampoTipo);
                }
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                // Definir o caminho e nome do arquivo
                String caminhoPasta3 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pastorais/erros log//erros";
                String caminhoArquivo3 = caminhoPasta3 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {
                    // Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta3);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    FileWriter writer = new FileWriter(caminhoArquivo3, true);
                    writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                    writer.close();

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo3);
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }
                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(3000); // Pausa de 3 segundos (ajuste conforme necessário)
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


            // INICIO DE CICLO DE ALTERAÇÃO

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


            // Nome
            Thread.sleep(1000);
            new Actions(navegador).moveByOffset(0, -375).doubleClick().click().sendKeys(Keys.BACK_SPACE)
                    .sendKeys(nomePastoral2).perform();
            // Sigla
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 25).doubleClick().click().sendKeys(Keys.BACK_SPACE)
                    .sendKeys(sigla2).perform();
            // Objetivo
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 35).doubleClick().click().sendKeys(Keys.BACK_SPACE)
                    .sendKeys(objetivo2).perform();
            // Forma Atuação
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 100).doubleClick().click().sendKeys(Keys.BACK_SPACE)
                    .sendKeys(formaatuacao2).perform();
            // Composição
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 120).doubleClick().click().sendKeys(Keys.BACK_SPACE)
                    .sendKeys(composicao2).perform();
            // Tipo
            Thread.sleep(250);
            new Actions(navegador).moveByOffset(0, 90).doubleClick().click().sendKeys(Keys.BACK_SPACE)
                    .sendKeys(tipo2).perform();
            // Salvar Cadastro
            Thread.sleep(250);
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[2]")).click();
            navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[2]")).click();


            // Capturar screenshot para análise visual.
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File screenshotFile = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
            File destinoFile = new File("C://Users//baptista.joao//Documents//Resultado Testes//" +
                    "Cadastro de Pastorais//Alteração//resultado_teste_" + timestamp + ".png");
            FileHandler.copy(screenshotFile, destinoFile);
            System.out.println("Screenshot salva: " + destinoFile.getAbsolutePath());

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(3000); // Pausa de 3 segundos (ajuste conforme necessário)
                // Finalizar navegador ao final de cada execução
                if (navegador != null) {
                    navegador.quit();
                }




            // ABRIR CONFERENCIA DE ALTERAÇÃO
            nomePastoral2 = "";
            try (BufferedReader reader = new BufferedReader(new FileReader("nomePastoral2.txt"))) {
                nomePastoral2 = reader.readLine(); // Lê o nome salvo no arquivo
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Reabrir o navegador para conferência
            navegador = new ChromeDriver();

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
                navegador.get("https://app.seg.inf.br/novo/user/sge_pastoral_base");


                //Pesquisa de Cadastro
                Thread.sleep(1000);
                navegador.findElement(By.id("searchInput")).sendKeys(nomePastoral2 + Keys.ENTER);


                // Selecionar Cadastro
                Thread.sleep(2000);
                Actions actions1 = new Actions(navegador);
                new Actions(navegador).moveByOffset(50, 105).doubleClick().perform();

                // Selecionar "Alterar"
                Thread.sleep(1500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[3]")).click();


                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas e script para unir mensagens
                JavascriptExecutor js = (JavascriptExecutor) navegador;
                StringBuilder mensagensErro = new StringBuilder();


                // Nome Pastoral
                new Actions(navegador).moveByOffset(-90, -165).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoNomePastoral2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Nome Pastoral está vazio
                if (valorCampoNomePastoral2 == null || valorCampoNomePastoral2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Nome Pastoral está vazio.\\n");
                    System.out.println("ERRO: O campo Nome Pastoral está vazio.");
                } else {
                    System.out.println("O campo Nome Pastoral foi preenchido com: " + valorCampoNomePastoral2);
                }


                // Sigla
                new Actions(navegador).moveByOffset(0, 20).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoSigla2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Sigla está vazio
                if (valorCampoSigla2 == null || valorCampoSigla2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Sigla está vazio.\\n");
                    System.out.println("ERRO: O campo Sigla está vazio.");
                } else {
                    System.out.println("O campo Sigla foi preenchido com: " + valorCampoSigla2);
                }


                // Objetivo
                new Actions(navegador).moveByOffset(0, 35).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoObjetivo2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Objetivo está vazio
                if (valorCampoObjetivo2 == null || valorCampoObjetivo2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Objetivo está vazio.\\n");
                    System.out.println("ERRO: O campo Objetivo está vazio.");
                } else {
                    System.out.println("O campo Objetivo foi preenchido com: " + valorCampoObjetivo2);
                }


                // Forma Atuação
                new Actions(navegador).moveByOffset(0, 100).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoFormaAtuacao2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Forma Atuação está vazio
                if (valorCampoFormaAtuacao2 == null || valorCampoFormaAtuacao2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Forma Atuação está vazio.\\n");
                    System.out.println("ERRO: O campo Forma Atuação está vazio.");
                } else {
                    System.out.println("O campo Forma Atuação foi preenchido com: " + valorCampoFormaAtuacao2);
                }


                // Composição
                new Actions(navegador).moveByOffset(0, 120).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoComposicao2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Composição está vazio
                if (valorCampoComposicao2 == null || valorCampoComposicao2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Composição está vazio.\\n");
                    System.out.println("ERRO: O campo Composição está vazio.");
                } else {
                    System.out.println("O campo Composição foi preenchido com: " + valorCampoComposicao2);
                }


                // Tipo
                new Actions(navegador).moveByOffset(-30, 100).click().sendKeys().perform();
                // Espera para garantir que o campo foi clicado
                Thread.sleep(500);
                // Utiliza o JavaScript Executor para pegar o valor do campo baseado em coordenadas
                String valorCampoTipo2 = (String) js.executeScript("return document.activeElement.value;");
                // Verificar se o campo Tipo está vazio
                if (valorCampoTipo2 == null || valorCampoTipo2.isEmpty()) {
                    mensagensErro.append("ERRO: O campo Tipo está vazio.\\n");
                    System.out.println("ERRO: O campo Tipo está vazio.");
                } else {
                    System.out.println("O campo Tipo foi preenchido com: " + valorCampoTipo2);
                }


                // Definir o caminho e nome do arquivo
                String caminhoPasta3 = "C://Users//baptista.joao//Documents//Resultado Testes//Cadastro de Pastorais/erros log//erros";
                String caminhoArquivo3 = caminhoPasta3 + "erroslog" + timestamp + ".txt"; // Nome fixo do arquivo

                try {
                    // Criar a pasta caso não exista
                    File pasta = new File(caminhoPasta3);
                    if (!pasta.exists()) {pasta.mkdirs();}

                    // Criar ou abrir o arquivo para escrita (modo "append" para não sobrescrever)
                    FileWriter writer = new FileWriter(caminhoArquivo3, true);
                    writer.write("Erros encontrados:\n" + mensagensErro + "\n\n");
                    writer.close();

                    System.out.println("Arquivo de erro salvo em: " + caminhoArquivo3);
                } catch (IOException e) {
                    System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                }

                //Excluir Cadastro
                Thread.sleep(1000);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[2]/button[4]")).click();
                Thread.sleep(500);
                navegador.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div[2]/div[1]")).click();
                Thread.sleep(1000);

                // Espera antes de iniciar o próximo ciclo
                Thread.sleep(3000); // Pausa de 3 segundos (ajuste conforme necessário)
                // Finalizar navegador ao final de cada execução
                if (navegador != null) {
                    navegador.quit();
                }
            } catch (InterruptedException | WebDriverException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


