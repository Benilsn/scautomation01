package dev.prj.scautomation01.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void open() {
    driver.get("https://automationexercise.com/");
  }

  public String getTitle() {
    return driver.getTitle();
  }
}