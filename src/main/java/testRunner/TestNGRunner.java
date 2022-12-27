package testRunner;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import commons.ConfigReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;


@CucumberOptions(plugin = {"pretty:target/cucumber-reports/cucumber-pretty.txt", "html:target/cucumber-reports/raw-cucumber-html-report.html", "json:target/report.json", "json:target/cucumber-reports/CucumberTestReport.json", "com.vimalselvam.cucumber.ExtentCucumberFormatter:output/extentreport.html"}, features = {"./src/test/resources/features/"}, glue = {"stepDefinitions"}, tags =  "@MyFeature", publish = false)

public class TestNGRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("output/extentreport.html");
    }
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(new ConfigReader().getReportConfigPath()));
    }
}

