package com.in28minutes.datadriventests;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testingss {
	
	WebDriver driver;
	
	@DataProvider(name="users-Ids-And-Passwords-CSV-DataProvider")
	public Iterator<String[]> usersIdsAndPasswordsDataProvider (){
		return readFromCSVFile("./src/test/resources/login-data.scv").iterator();
	}
	
	@BeforeTest
	public void beforeTest() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mythos\\Desktop\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void Testings() {
	
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Mythos\\Desktop\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		driver.get("https://dxctechnology.wd1.myworkdayjobs.com/en-US/DXCJobs/login?redirect=%2Fen-US%2FDXCJobs%2FuserHome");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		sleep(5);
		
		driver.findElement(By.id("input-4")).sendKeys("merdzhanov.vasil@gmail.com");
		WebElement login = driver.findElement(By.id("input-5"));
		login.sendKeys("Hugobosss34@");
		driver.findElement(By.className("css-tngcy1")).click();
		
		sleep(4);
		WebElement welcomeMsg = driver.findElement(By.className("css-pywxuv"));
		String message = welcomeMsg.getText();
		System.out.println(message);
		
		Assert.assertEquals(message, "Welcome, Vasil Merdzhanov");
		
		
		
		driver.quit();
	}
	
	
	@Test(dataProvider = "users-Ids-And-Passwords-CSV-DataProvider")
	public void testvameNeshto(String mail, String password, String isItPositiveTestString){
		
		boolean isItPositiveTest = Boolean.valueOf(isItPositiveTestString);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mythos\\Desktop\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.bg/auth/lgn");
		
		sleep(3);
		
		WebElement mailVm = driver.findElement(By.id("imapuser"));
		mailVm.sendKeys(mail);
		WebElement passVm = driver.findElement(By.id("pass"));
		passVm.sendKeys(password);
		driver.findElement(By.className("login_button")).submit();
		
		sleep(10);
		
		if(isItPositiveTest) {
			String nameVm = driver.findElement(By.id("user_mail_name")).getText();
			assertEquals(nameVm, "sartarus");
		}else {
			String wrongMsg = driver.findElement(By.id("footer_left")).getText();
			assertEquals(wrongMsg, "© 2023 Mail.bg");
		}
		
		driver.quit();
	}
	
	@Test
	public void testCSV () throws IOException{ 
		
		List<String[]> data = readFromCSVFile("./src/test/resources/login-data.scv");
		for (String[] row : data) {
			System.out.println(Arrays.toString(row));
		}
	}
	
	@Test
	public void openBrowserTest() {
		//Testss.openBrowser();
		driver.get("https://mail.bg/auth/lgn");
		
		Testss loginn = PageFactory.initElements(driver, Testss.class);
		
		loginn.login("sartarus@mail.bg", "hugoboss");
		
	}


	private List<String[]> readFromCSVFile(String csvFilePath){
		try{
			CSVReader reader = new CSVReader(new FileReader(csvFilePath));
			List<String[]> data = reader.readAll();
			return data;
		
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	private void sleep(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}