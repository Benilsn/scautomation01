package dev.prj.scautomation01.core;

import org.openqa.selenium.WebDriver;

public class TestContext {

  private final WebDriver driver;

  public TestContext() {
    this.driver = DriverFactory.getDriver();
  }

  public WebDriver getDriver() {
    return driver;
  }
}