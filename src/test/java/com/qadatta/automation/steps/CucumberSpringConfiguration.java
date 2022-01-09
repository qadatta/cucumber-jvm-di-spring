package com.qadatta.automation.steps;

import org.springframework.test.context.ContextConfiguration;

import com.qadatta.automation.config.Config;

import io.cucumber.spring.CucumberContextConfiguration;

@ContextConfiguration(classes = Config.class)
@CucumberContextConfiguration
public class CucumberSpringConfiguration {
}