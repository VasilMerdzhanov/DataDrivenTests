package com.in28minutes.datadriventests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import ch.qos.logback.classic.Logger;

public class Testss {
	
	public  WebDriver driver;

	public Testss(WebDriver driver) {
		super();
		//this.driver = driver;
	}
	
	@FindBy(id="imapuser")
	WebElement mail;
	
	@FindBy(id="pass")
	WebElement passWord;
	
	@FindBy(className="login_button")
	WebElement button;
	
	By search = By.id("pass");
	
//	public static void openBrowser() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mythos\\Desktop\\Drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//	//	driver.get("https://mail.bg/auth/lgn");
//	}
	
	public void enterName(String enterMail) {
		mail.sendKeys(enterMail);
	}
	
	public void enterPassword(String enterPass) {
		passWord.sendKeys(enterPass);
	}

	public void submit() {
		button.submit();
	}
	
	public void login(String mail, String pass) {
		enterName(mail);
		enterPassword(pass);
		submit();
	}
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
