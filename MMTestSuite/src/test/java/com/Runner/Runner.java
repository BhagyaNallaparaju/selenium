package com.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "classpath:features" , glue = {
		"classpath:com/stepdefinition" }, plugin = {"pretty","html:target/cucumber-html-report"})
public class Runner extends AbstractTestNGCucumberTests{
	

}
