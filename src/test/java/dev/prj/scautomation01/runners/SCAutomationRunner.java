package dev.prj.scautomation01.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
  features = "src/test/resources/features",
  glue = "dev.prj.scautomation01",
  plugin = {"pretty"}
)
public class SCAutomationRunner extends AbstractTestNGCucumberTests { }
