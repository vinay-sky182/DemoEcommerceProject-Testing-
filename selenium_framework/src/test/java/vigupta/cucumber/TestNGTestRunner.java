package vigupta.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/vigupta/cucumber", glue = "vigupta.stepDefinations", monochrome = true, tags = "@Order", plugin = {"html:target/cucumber.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests
{
    
}
