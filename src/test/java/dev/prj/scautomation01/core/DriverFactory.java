package dev.prj.scautomation01.core;

import dev.prj.scautomation01.config.AutomationConfig;
import dev.prj.scautomation01.config.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Objects;

public class DriverFactory {

  private static WebDriver driver;
  private static final AutomationConfig automationConfig;

  static {
    automationConfig = ConfigLoader.load();
  }

  public static WebDriver getDriver() {
    String webDriverProp = "webdriver.chrome.driver";
    if (Objects.nonNull(automationConfig) && Objects.nonNull(automationConfig.getDriverType())) {
      driver =
        switch (automationConfig.getDriverType()) {
          case EDGE -> {
            webDriverProp = "webdriver.edge.driver";
            yield new EdgeDriver();
          }
          default -> new ChromeDriver();
        };
    } else {
      throw new IllegalStateException("automation property not found in configuration file.");
    }

    System.setProperty(webDriverProp, automationConfig.getDriverPath());
    return driver;
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}