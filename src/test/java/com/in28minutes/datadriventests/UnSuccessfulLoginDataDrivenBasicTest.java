package com.in28minutes.datadriventests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class UnSuccessfulLoginDataDrivenBasicTest {
	//String[] userIds = {"sartarus@mail.bg", "spark@mail.bg", "noname@mail.bg"};
	
	//Create the Data Provider and give the data provider a name
	@DataProvider(name="user-ids-data-provider")
	public String[] usersIdsDataProvider() {
		return new String[]{"smotan@mail.bg", "spark@mail.bg", "greshen@mail.bg"};
	}
	
	//Use the data provider
	@Test(dataProvider="user-ids-data-provider")
	public void testLoginWith28Minutes(String userIds) {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mythos\\Desktop\\Drivers\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.bg/auth/lgn");
		
		//driver.findElement(By.id("imapuser")).sendKeys("sartarus@mail.bg");
		driver.findElement(By.id("imapuser")).sendKeys(userIds);
		WebElement passwordElement = driver.findElement(By.id("pass"));
		passwordElement.sendKeys("*********");
	
		//driver.findElement(By.className("login_button")).click();
		passwordElement.submit();	
		driver.quit();
	}
}
