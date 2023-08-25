package com.pageobjects;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class CustomerLoginPage extends LoadableComponent<CustomerLoginPage>{
	
@FindBy (name="uid")
WebElement userId;

@FindBy (name="password")
WebElement password;

@FindBy (name="btnLogin")
WebElement loginButton;

@FindBy (name="btnReset")
WebElement resetButton;


WebDriver driver;
String url="http://www.demo.guru99.com";

public CustomerLoginPage()
{
	System.setProperty("webdriver.gecko.driver", "test//resources//geckodriver64bit.exe");
	driver = new FirefoxDriver();
	PageFactory.initElements(driver, this);
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
}
@Override
protected void isLoaded() throws Error {
	// TODO Auto-generated method stub
	
}
@Override
protected void load() {
	driver.get(url+"/v4/");
	
}

public InboxHome giveCredentials(String uid , String passwd)
{
	userId.sendKeys(uid);
	password.sendKeys(passwd);
	loginButton.click();
	String pageTitle=driver.getTitle();
	assertEquals( pageTitle , "Guru99 Bank Manager HomePage");
	System.out.println("Page Title is :"+pageTitle);
	System.out.println("Verification Successfull...!!!!!!");
	InboxHome inbox = new InboxHome(driver);
	   return inbox;
	
}

}
