package dev.prj.scautomation01.core;

import dev.prj.scautomation01.config.AutomationConfig;
import dev.prj.scautomation01.config.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

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
            yield new EdgeDriver(buildDriverOptions(new EdgeOptions()));
          }
          default -> new ChromeDriver(buildDriverOptions(new ChromeOptions()));
        };
    } else {
      throw new IllegalStateException("automation property not found in configuration file.");
    }

    System.setProperty(webDriverProp, automationConfig.getDriverPath());
    return driver;
  }

  private static <T extends ChromiumOptions<T>> T buildDriverOptions(T options) {
    options.addArguments("--disable-notifications");
    options.addArguments("--disable-infobars");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-ads");
    options.addArguments("--disable-features=InterestCohort");

    return options;
  }

  public static void quitDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}