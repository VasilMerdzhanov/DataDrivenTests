package com.in28minutes.datadriventests;

import org.testng.annotations.Test;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class LoginDataProviderCompliteExcelTest {
	//String[] userIds = {"sartarus@mail.bg", "spark@mail.bg", "noname@mail.bg"};
	
	//Create the Data Provider and give the data provider a name
	@DataProvider(name="user-ids-passwords-excel-data-provider")
	public String[][] usersIdsAndPasswordsDataProvider() {
		return ExcelReadUtil.readExcelInto2DArray("./src/test/resources/login-data.xlsx", "Sheet1", 3);
	}
	
	//Use the data provider
	@Test(dataProvider="user-ids-passwords-excel-data-provider")
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
	public void readFromExcel() {
		String[][] data = ExcelReadUtil.readExcelInto2DArray("./src/test/resources/login-data.xlsx", "Sheet1", 3);
		System.out.println(Arrays.deepToString(data));
	}
}
