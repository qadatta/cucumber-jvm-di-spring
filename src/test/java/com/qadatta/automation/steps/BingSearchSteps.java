package com.qadatta.automation.steps;

import static org.junit.Assert.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import com.qadatta.automation.aut.model.BingHomePage;
import com.qadatta.automation.aut.model.BingSearchResultsPage;

import io.cucumber.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class BingSearchSteps implements En {
	private final BingHomePage bingHomePage;
	private final BingSearchResultsPage bingSearchResultsPage;

	@Autowired
	public BingSearchSteps(BingHomePage bingHomePage, BingSearchResultsPage bingSearchResultsPage) {
		
		this.bingHomePage = bingHomePage;
	    this.bingSearchResultsPage = bingSearchResultsPage;
	    
		Given("I am on the bing search engine", () -> {
			bingHomePage.load();
		});

		When("I enter a search term", () -> {
			bingHomePage.searchFor("cucumber");
		});

		Then("relevant results for that search term are displayed", () -> {

			assertThat(bingSearchResultsPage.getFirstResultTitle()).contains("Cucumber");

		});
	}
}