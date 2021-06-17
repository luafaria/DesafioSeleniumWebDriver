package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestaEntradaDeDadosSteps {

    // Variáveis globais
    public WebDriver driver;
    WebDriverWait wait;

    // Variáveis preenchimento dados veículo - COLOCAR NO OBJETO VEÍCULO
    String cylinderCapacity = "1000";
    String enginePerformance = "1200";
    String payload = "1000";
    String totalWeight = "500";
    String listPrice = "100000";
    String licencePlateNumber = "123abcd";
    String annualMilage = "1500";

    // Variáveis preenchimento dados pessoais - COLOCAR NO OBJETO PESSOA
    String name = "Luciane";
    String lastName = "Faria";
    String zipcode = "27524200";
    String city = "Resende";

    // Variáveis preenchimento dados produto - COLOCAR NO OBJETO PRODUTO
    String startData = "16/06/2022";

    //Variáveis preenchimento enviar cotação - COLOCAR NO OBJETO PESSOA
    String email = "lu.afaria@hotmail.com";
    String phone = "998821154";
    String username = "luafaria";
    String password = "Lu123456";
    String confirmPassword = "Lu123456";
    String comments = "Não consegui aplicar o PageObjects, mas entendi o conceito e cheguei até aqui!" +
            "Obrigada Gama! Obrigada Accenture! Obrigada a todos que contribuiram para isso!";

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver,30);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Dado("que o usuario está na página da Tricents")
    public void que_o_usuario_está_na_página_da_tricents() {
        driver.get("http://sampleapp.tricentis.com/101/app.php");
    }

    //PREENCHIMENTO DE DADOS DO VEÍCULO
    @Quando("seleciona os itens de forma correta")
    public void seleciona_os_itens_de_forma_correta() {

        WebElement make	=	driver.findElement(By.id("make"));
        Select select	=	new	Select(make);
        select.selectByVisibleText("Honda");

        WebElement	model	=	driver.findElement(By.id("model"));
        select	=	new	Select(model);
        select.selectByVisibleText("Moped");

        WebElement	numberOfSeats	=	driver.findElement(By.id("numberofseats"));
        select	=	new	Select(numberOfSeats);
        select.selectByVisibleText("1");

        WebElement	numberOfSeatsMotorcycle	=	driver.findElement(By.id("numberofseatsmotorcycle"));
        select	=	new	Select(numberOfSeatsMotorcycle);
        select.selectByVisibleText("1");

        WebElement	fuelType	=	driver.findElement(By.id("fuel"));
        select	=	new	Select(fuelType);
        select.selectByVisibleText("Gas");
    }

    @Quando("preenche os campos de forma correta")
    public void preenche_os_campos_de_forma_correta() {
        driver.findElement(By.name("Cylinder Capacity")).sendKeys(cylinderCapacity);
        driver.findElement(By.name("[kW]")).sendKeys(enginePerformance);
        driver.findElement(By.name("Payload")).sendKeys(payload);
        driver.findElement(By.name("Total Weight")).sendKeys(totalWeight);
        driver.findElement(By.name("List Price")).sendKeys(listPrice);
        driver.findElement(By.name("License Plate Number")).sendKeys(licencePlateNumber);
        driver.findElement(By.name("Annual Mileage")).sendKeys(annualMilage);
        driver.findElement(By.name("Date of Manufacture")).sendKeys("01/01/2000");
    }

    @Quando("clica no botão next")
    public void clica_no_botão_next() {
        driver.findElement(By.name("Next (Enter Insurant Data)")).sendKeys(Keys.ENTER);
    }

    @Então("deve ir para a aba inserir os dados do seguro")
    public void deve_ir_para_a_aba_inserir_os_dados_do_seguro() {

        String resultadoEsperado = "Enter Insurant Data";

        Assert.assertEquals(resultadoEsperado, driver.getTitle());
    }

    //PREENCHIMENTO DE DADOS PESSOAIS

    @Quando("seleciona os itens pessoais de forma correta")
    public void seleciona_os_itens_pessoais_de_forma_correta() {
        //Campos select
        WebElement country	=	driver.findElement(By.id("country"));
        Select selection	=	new	Select(country);
        selection.selectByVisibleText("Brazil");

        WebElement ocupation	=	driver.findElement(By.id("occupation"));
        Select select	=	new	Select(ocupation);
        select.selectByVisibleText("Employee");
    }

    @Quando("preenche os campos pessoais de forma correta")
    public void preenche_os_campos_pessoais_de_forma_correta() {
        driver.findElement(By.name("First Name")).sendKeys(name);
        driver.findElement(By.name("Last Name")).sendKeys(lastName);
        driver.findElement(By.name("Zip Code")).sendKeys(zipcode);
        driver.findElement(By.name("City")).sendKeys(city);
        driver.findElement(By.name("Date of Birth")).sendKeys("07/06/1993");
        driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[1]/span")).click();
    }

    @Quando("clica no botão next da página")
    public void clica_no_botão_next_da_página() {
        driver.findElement(By.name("Next (Enter Product Data)")).sendKeys(Keys.ENTER);
    }

    @Então("deve ir para a aba inserir os dados do produto")
    public void deve_ir_para_a_aba_inserir_os_dados_do_produto() {
        String resultadoEsperado = "Enter Product Data";
        Assert.assertEquals(resultadoEsperado, driver.getTitle());
    }

    //PREENCHIMENTO DE DADOS DO PRODUTO
    @Quando("seleciona os itens do produto de forma correta")
    public void seleciona_os_itens_do_produto_de_forma_correta() {
        WebElement insuranceSum	=	driver.findElement(By.id("insurancesum"));
        Select select	=	new	Select(insuranceSum);
        select.selectByVisibleText("3.000.000,00");

        WebElement	meritRating	=	driver.findElement(By.id("meritrating"));
        select	=	new	Select(meritRating);
        select.selectByVisibleText("Super Bonus");

        WebElement	damageInsurance	=	driver.findElement(By.id("damageinsurance"));
        select	=	new	Select(damageInsurance);
        select.selectByVisibleText("Full Coverage");

        WebElement	courtesyCar	=	driver.findElement(By.id("courtesycar"));
        select	=	new	Select(courtesyCar);
        select.selectByVisibleText("No");

    }

    @Quando("preenche os campos do produto de forma correta")
    public void preenche_os_campos_do_produto_de_forma_correta() {
        driver.findElement(By.name("Start Date")).sendKeys("01/01/2022");
        driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[1]/span")).click();
    }

    @Quando("clica no botão next da página produto")
    public void clica_no_botão_next_da_página_produto() {
        driver.findElement(By.name("Next (Select Price Option)")).click();
    }

    @Então("deve ir para a aba selecionar opções de preço")
    public void deve_ir_para_a_aba_selecionar_opções_de_preço() {
        String resultadoEsperado = "Select Price Option";
        Assert.assertEquals(resultadoEsperado, driver.getTitle());
    }

    @Quando("deve selecionar a forma de pagamento")
    public void deve_selecionar_a_forma_de_pagamento() {
        driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[2]/span")).click();
    }

    @Quando("clica no botão next da página opção de preço")
    public void clica_no_botão_next_da_página_opção_de_preço() {
        driver.findElement(By.name("Next (Send Quote)")).click();
    }

    @Então("deve ir para a aba enviar cotação")
    public void deve_ir_para_a_aba_enviar_cotação() {
        String resultadoEsperado = "Send Quote";
        Assert.assertEquals(resultadoEsperado, driver.getTitle());
    }

    @Quando("preenche os campos da página enviar cotação de forma correta")
    public void preenche_os_campos_da_página_enviar_cotação_de_forma_correta() {
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.name("Phone")).sendKeys(phone);
        driver.findElement(By.name("Username")).sendKeys(username);
        driver.findElement(By.name("Password")).sendKeys(password);
        driver.findElement(By.name("Confirm Password")).sendKeys(confirmPassword);
        driver.findElement(By.name("Comments")).sendKeys(comments);
    }

    @Quando("clica no botão send")
    public void clica_no_botão_send() {
        driver.findElement(By.name("Send E-Mail")).click();
    }

    @Quando("deve receber a mensagem de confirmação {string}")
    public void deve_receber_a_mensagem_de_confirmação(String string) {
        WebElement sendingSucess = driver.findElement(By.xpath("/html/body/div[4]/h2"));
        assertEquals(string, sendingSucess.getText());
    }

    @Então("deve clicar no botão ok")
    public void deve_clicar_no_botão_ok() {
        driver.findElement(By.xpath("/html/body/div[4]/div[7]/div/button")).click();
    }


    @After
    public void posCondicao(){
        wait = new WebDriverWait(driver,15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.quit();
    }
}
