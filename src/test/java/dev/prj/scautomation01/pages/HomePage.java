package dev.prj.scautomation01.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

  public By title = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
  public By singInUpButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void open() {
    driver.get("https://automationexercise.com/");
  }

}