package com.msys.angular.ui.TestRunner;


import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;
import com.msys.angular.ui.helpers.Browser;
import com.msys.angular.ui.helpers.Generic;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

@CucumberOptions(plugin = {"com.cucumber.listener.ExtentCucumberFormatter:",
        "junit:target/cucumber-reports/Jobs.xml"},
        features = {"Feature"},
        glue = {"com/msys/angular/ui/stepdef"},
        tags = {"@Login"})


public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;
    public ExtentCucumberFormatter ExtentCucumberFormatter;
    public File resultfile;
    public static String strFolderName;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        Browser.LoadConfigFile();
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        resultfile = new File(System.getProperty("user.dir")
                + "//TestReports//UIReports// " + "Run_"
                + Generic.getCuttentTimeStamp() + "//report.html");

        ExtentCucumberFormatter = new ExtentCucumberFormatter(resultfile);
        strFolderName = resultfile.getParent();
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "//src//test//java//com//msys//angular//ui//report//extent-config.xml"));
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", "Windows 10" + " 64 Bit");
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.5.2");
        Reporter.setSystemInfo("Java Version", "1.8.0_151");
        testNGCucumberRunner.finish();
    }
}
