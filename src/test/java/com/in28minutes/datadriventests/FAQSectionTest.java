package com.in28minutes.datadriventests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class FAQSectionTest {
	
	  WebDriver driver = new ChromeDriver();

	
//	@Given("^the Framer site is loaded$")
	  public void loadFramerSite() {
	    driver.get("https://framer.com");
	  }

//	  @When("^I click on 'Pricing' button$")
	  public void clickPricingButton() {
	    WebElement pricingButton = driver.findElement(By.id("pricingButton"));
	    pricingButton.click();
	  }

//	  @And("^I see the Pricing page$")
	  public void verifyPricingPageDisplayed() {
	    String pageTitle = driver.getTitle();
	    Assert.assertEquals("Pricing | Framer", pageTitle);
	  }

//	  @Then("^I see the FAQ section contains 4 questions$")
	  public void verifyFAQSection() {
	    WebElement faqSection = driver.findElement(By.id("faqSection"));
	    List<WebElement> faqQuestions = faqSection.findElements(By.cssSelector(".faq-question"));
	    Assert.assertEquals(4, faqQuestions.size());
	  }

@AfterClass
public void quitBrowser() {
  driver.quit();
}}