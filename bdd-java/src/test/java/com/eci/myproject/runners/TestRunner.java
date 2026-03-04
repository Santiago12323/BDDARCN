package com.eci.myproject.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/eci/myproject/features",
        glue = "com.eci.myproject.steps",
        plugin = {"pretty"}
)
public class TestRunner {
}