package dev.prj.scautomation01.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

  @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")
  public WebElement homeButton;

  @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
  public WebElement singInUpButton;

  @FindBy(xpath = "//*[@id='form']/div/div/div/h2/b")
  public WebElement accountActionTitle;

  @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a")
  public WebElement loggedAsUserAnchor;

  @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")
  public WebElement logoutButton;

  @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[5]/a")
  public WebElement deleteAccountButton;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void open() {
    driver.get("https://automationexercise.com/");
  }

}