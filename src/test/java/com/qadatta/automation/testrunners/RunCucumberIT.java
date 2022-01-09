package com.qadatta.automation.testrunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = {"classpath:features/"},
  plugin   = {"pretty"},
  glue     = {"com.qadatta.automation.steps"})
public class RunCucumberIT {
}