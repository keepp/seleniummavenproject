package seleniumdemo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTestConvertedFromIDE {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public void setUp() throws Exception {
	driver = new FirefoxDriver();
	baseUrl = "https://www.google.com.ua/";
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCode() throws Exception {
	driver.get(baseUrl);
	driver.findElement(By.id("lst-ib")).clear();
	driver.findElement(By.id("lst-ib")).sendKeys("Calculator");
	driver.findElement(By.name("btnG")).click();
	driver.findElement(By.linkText("Basic Calculator - Math.com")).click();
	driver.findElement(By.name("one")).click();
	driver.findElement(By.name("plus")).click();
	driver.findElement(By.name("three")).click();
	driver.findElement(By.name("DoIt")).click();

	try {
	    assertEquals("4", driver.findElement(By.name("Input"))
		    .getAttribute("value"));
	} catch (Error e) {
	    verificationErrors.append(e.toString());
	}

	driver.findElement(By.name("clear")).click();
	driver.findElement(By.name("nine")).click();
	driver.findElement(By.name("nine")).click();
	driver.findElement(By.name("six")).click();
	driver.findElement(By.name("minus")).click();
	driver.findElement(By.name("three")).click();
	driver.findElement(By.name("three")).click();
	driver.findElement(By.name("DoIt")).click();

	try {
	    assertEquals("963", driver.findElement(By.name("Input"))
		    .getAttribute("value"));
	} catch (Error e) {
	    verificationErrors.append(e.toString());
	}
    }

    @AfterClass
    public void tearDown() throws Exception {
	driver.quit();
	String verificationErrorString = verificationErrors.toString();
	if (!"".equals(verificationErrorString)) {
	    fail(verificationErrorString);
	}
    }
}
