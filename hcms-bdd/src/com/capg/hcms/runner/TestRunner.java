package com.capg.hcms.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="Features", glue="com.capg.hcms.stepDefinition")
public class TestRunner {
	
	

}
