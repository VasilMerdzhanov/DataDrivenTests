package com.in28minutes.datadriventests;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class LoginDataProviderCompliteCsvTest {
	//String[] userIds = {"sartarus@mail.bg", "spark@mail.bg", "noname@mail.bg"};
	
	//Create the Data Provider and give the data provider a name
	@DataProvider(name="user-ids-passwords-csv-data-provider")
	public Iterator<String[]> usersIdsAndPasswordsCSVDataProvider() {
		return readFromCSVFile("./src/test/resources/login-data.scv").iterator();
	}
	
	//Use the data provider
	@Test(dataProvider="user-ids-passwords-csv-data-provider")
	public void testunSuccessfulLoginWith28Minutes(String userIds, String password, String isLoginExpectedToBeSuccessfulString) {
		boolean isLoginExpectedToBeSuccessful = Boolean.valueOf(isLoginExpectedToBeSuccessfulString);
		
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mythos\\Desktop\\Drivers\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.bg/auth/lgn");
		//driver.findElement(By.id("imapuser")).sendKeys("sartarus@mail.bg");
		driver.findElement(By.id("imapuser")).sendKeys(userIds);
		WebElement passwordElement = driver.findElement(By.id("pass"));
		passwordElement.sendKeys(password);	
		//driver.findElement(By.className("login_button")).click();
		passwordElement.submit();
		
		
		if(isLoginExpectedToBeSuccessful) {
//			String errorMessageText = driver.findElement(By.id("footer_left")).getText();
//			assertEquals(errorMessageText,"© 2022 Mail.bg");
		}else {
//			String errorMessageText = driver.findElement(By.id("footer_left")).getText();      
//			--  dava mi greshka pri namiraneto na tozi element !
//			assertEquals(errorMessageText,"© 2022 Mail.bg");
		}
		
		driver.quit();
		
	}
	
	@Test
	public void TestReadingDataFromCSV() throws IOException {
		//./src/test/resources/login-data.scv
		List<String[]> data = readFromCSVFile("./src/test/resources/login-data.scv");
		for(String[] row:data) {
			System.out.println(Arrays.toString(row));
		}
	}

	private List<String[]> readFromCSVFile(String csvFilePath) {
		try {
		CSVReader reader = new CSVReader(new FileReader(csvFilePath));
		List<String[]> data = reader.readAll();
		return data;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
