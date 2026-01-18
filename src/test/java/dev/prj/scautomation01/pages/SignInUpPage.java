package dev.prj.scautomation01.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInUpPage extends BasePage {

  public By newUserSignUpTitle = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
  public By newUserFormNameInput = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
  public By newUserFormEmailInput = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
  public By signUpButton = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
  public By enterAccountInformationTitle = By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b");
  public By newUserPasswordInput = By.xpath("//*[@id=\"password\"]");

  public SignInUpPage(WebDriver driver) {
    super(driver);
  }

  public void open() {
    driver.get("https://automationexercise.com/signup");
  }

}