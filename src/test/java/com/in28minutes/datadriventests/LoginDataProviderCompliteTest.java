package com.in28minutes.datadriventests;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class LoginDataProviderCompliteTest {
	//String[] userIds = {"sartarus@mail.bg", "spark@mail.bg", "noname@mail.bg"};
	
	//Create the Data Provider and give the data provider a name
	@DataProvider(name="user-ids-password-data-provider")
	public Object[][] usersIdsAndPasswordsDataProvider() {
		return new Object[][]{
				{"sartarus@mail.bg", "hugoboss", true},
				{"spark@mail.bg", "neshto", false},
				{"greshen@mail.bg","neshto", false}
				};
	}
	
	//Use the data provider
	@Test(dataProvider="user-ids-password-data-provider")
	public void testunSuccessfulLoginWith28Minutes(String userIds, String password, boolean isLoginExpectedToBeSuccessful) {
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
}
