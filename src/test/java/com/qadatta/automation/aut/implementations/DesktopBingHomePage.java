package com.qadatta.automation.aut.implementations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.qadatta.automation.aut.model.BingHomePage;

@Component
@Profile("desktop")
public class DesktopBingHomePage implements BingHomePage {

	@Value("${aut.urls.home}")
	private String homePageUrl;

	private final WebDriver driver;

	@Autowired
	public DesktopBingHomePage(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void load() {
		driver.get(homePageUrl);

	}

	@Override
	public void searchFor(String searchTerm) {
		driver.findElement(By.id("sb_form_q")).sendKeys(searchTerm);
		driver.findElement(By.id("sb_form_go")).submit();;
	}

}
