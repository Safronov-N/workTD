package com.safronov.td;

import com.safronov.driver.Driver;
import com.safronov.Logger;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(features = "src/test/resources/features"
        , glue = "com.safronov.td.stepdefinition")
public class CucumberRunner {
    private TestNGCucumberRunner runner;

    @BeforeClass
    public void setUp() {
        runner = new TestNGCucumberRunner(this.getClass());
    }

    @DataProvider
    public Object[][] features() {
        Object[][] scenarios = runner.provideScenarios();
        ((PickleEventWrapper) scenarios[0][0]).getPickleEvent();
        return scenarios;
    }

    @Test(dataProvider = "features")
    public void feature(PickleEventWrapper pickleEventWrapper, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        runner.runScenario(pickleEventWrapper.getPickleEvent());
    }

    @AfterClass
    public static void tearDown() {
        Logger.info("Завершение теста");
        Driver.getInstance().exit();
    }
}

