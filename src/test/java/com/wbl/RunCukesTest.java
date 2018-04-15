package com.wbl;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features={"src/main/features"},
glue={"com.wbl.stepdefinitions"},
dryRun=false,
strict=true,
tags={"@login"},
plugin = { "progress" , "html:target/Cucumber"})
public class RunCukesTest {

}
