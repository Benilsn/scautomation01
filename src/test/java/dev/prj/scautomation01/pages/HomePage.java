package dev.prj.scautomation01.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

  private final WebDriver driver;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public void open() {
    driver.get("https://automationexercise.com/");
  }

  public String getTitle() {
    return driver.getTitle();
  }
}