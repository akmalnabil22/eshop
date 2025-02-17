package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    @LocalServerPort
    private  int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;
    private String createProductUrl;
    private String listProductUrl;

    @BeforeEach
    void setUp() {
        baseUrl = String.format("%s:%d", testBaseUrl, serverPort);
        createProductUrl=baseUrl+"/product/create";
        listProductUrl=baseUrl+"/product/list";
    }
    @Test
    void buttonToCreate_isWorking(ChromeDriver driver) throws  Exception {
        driver.get(listProductUrl);
        WebElement createButton = driver.findElement(By.linkText("Create Product"));
        createButton.click();
        String currentUrl = driver.getCurrentUrl();
        assertEquals(createProductUrl,currentUrl);
    }
    @Test
    void createProduct_isWorking(ChromeDriver driver) throws  Exception {
        driver.get(createProductUrl);
        WebElement nameInput = driver.findElement(By.id("nameInput"));
        nameInput.clear();
        String productName = "Name Test";
        nameInput.sendKeys(productName);

        WebElement quantityInput = driver.findElement(By.id("quantityInput"));
        quantityInput.clear();
        String productQuantity = "20";
        quantityInput.sendKeys(productQuantity);

        WebElement submit = driver.findElement(By.tagName("button"));
        submit.click();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(listProductUrl,currentUrl);

        List<WebElement> tds = driver.findElements(By.tagName("td"));
        assertEquals(3, tds.size());

        String listedProductName = tds.get(0).getText();
        assertEquals(productName,listedProductName);
        String listedProductQuantity = tds.get(1).getText();
        assertEquals(productQuantity,listedProductQuantity);
    }
}
