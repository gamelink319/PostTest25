package com.juaracoding.ujian.posttest26;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags ="",
			features = {"src/test/resources/features/01Search.feature",
						"src/test/resources/features/02Checkout.feature"},
				glue ="com.juaracoding.ujian.posttest26",
				plugin={"pretty","html:target/cucumber-reports.html",
						"json:target/extent-reports.html"})
public class TestRunnerPostTest extends AbstractTestNGCucumberTests {

}
