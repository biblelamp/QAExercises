package com.pflb.learning;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com.pflb.learning.stepdefinitions"
)
public class MatrixBoardRunner { }
