package dev.prj.scautomation01.core;

import dev.prj.scautomation01.config.AutomationConfig;
import dev.prj.scautomation01.config.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

  private static WebDriver driver;
  private static final AutomationConfig automationConfig;

  static {
    automationConfig = ConfigLoader.load();
  }

  public static WebDriver getDriver() {


    if (driver == null) {
      driver = new ChromeDriver();
    }
    return driver;
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}