package com.juaracoding.ujian;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags ="",
				features = "src/test/resources/features/Checkout.feature",
				glue ="com.juaracoding.ujian",
				plugin={"pretty","html:target/cucumber-reports.html"})
public class TestRunnerUjian5 extends AbstractTestNGCucumberTests {

}
