package com.qadatta.automation.browsers;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DesktopBrowser {
	@Value("${browser.desktop.width}")
	private int desktopWidth;

	@Value("${browser.desktop.height}")
	private int desktopHeight;

	@Bean
	@Profile("desktop")
	public WebDriver getDriver() {
	    File resourcesDirectory = new File("src/test/resources");

		System.setProperty("webdriver.chrome.driver",resourcesDirectory.getAbsolutePath()+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(desktopWidth, desktopHeight));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}