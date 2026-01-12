package dev.prj.scautomation01.hooks;

import dev.prj.scautomation01.core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

  @Before
  public void setup() {
  }

  @After
  public void tearDown() {
    DriverFactory.quitDriver();
  }

}
