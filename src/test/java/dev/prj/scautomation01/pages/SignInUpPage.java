package dev.prj.scautomation01.pages;

import org.openqa.selenium.*;

import java.util.List;

public class SignInUpPage extends BasePage {

  public By newUserSignUpTitle = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
  public By newUserFormNameInput = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
  public By newUserFormEmailInput = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
  public By signUpButton = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
  public By enterAccountInformationTitle = By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b");
  public By newUserPasswordInput = By.xpath("//*[@id=\"password\"]");
  public DateOfBirth dateOfBirth;

  public SignInUpPage(WebDriver driver) {
    super(driver);
    dateOfBirth = new DateOfBirth(driver);
  }

  public void open() {
    driver.get("https://automationexercise.com/signup");
  }

  public static class DateOfBirth {
    public WebElement day;
    public WebElement month;
    public WebElement year;
    public WebDriver driver;

    public DateOfBirth(WebDriver driver) {
      this.driver = driver;
    }

    public DateOfBirth build() {
      this.day = findElement("uniform-days");
      this.month = findElement("uniform-months");
      this.year = findElement("uniform-years");
      return this;
    }

    private WebElement findElement(String elementId) {
      By dateOfBirthSelect = By.xpath("//*[@id=\"form\"]/div/div/div/div/form/div[5]/div");
      return driver.findElement(dateOfBirthSelect)
        .findElements(By.tagName("div"))
        .stream()
        .filter(e -> e.getAttribute("id").equalsIgnoreCase(elementId))
        .filter(e -> e.findElement(By.tagName("select")).isEnabled())
        .findFirst()
        .orElseThrow(() -> new NotFoundException(String.format("Element %s not found!", elementId)));
    }

    public void selectDay(String dayNumber){
      if (this.day.isDisplayed()) this.day.click();
      else throw new ElementNotInteractableException("Day element not displayed!");

      List<WebElement> days = this.day.findElements(By.tagName("option"));

      days.stream()
        .filter(day -> day.getText().equalsIgnoreCase(dayNumber))
        .findFirst()
        .orElseThrow(() -> new NotFoundException(String.format("Day %s not found!", dayNumber)))
        .click();
    }

    public void selectMonth(String month){
      if (this.month.isDisplayed()) this.month.click();
      else throw new ElementNotInteractableException("Month element not displayed!");

      List<WebElement> months = this.month.findElements(By.tagName("option"));

      months.stream()
        .filter(day -> day.getText().equalsIgnoreCase(month))
        .findFirst()
        .orElseThrow(() -> new NotFoundException(String.format("Month %s not found!", month)))
        .click();
    }

    public void selectYear(String yearNumber){
      if (this.year.isDisplayed()) this.year.click();
      else throw new ElementNotInteractableException("Year element not displayed!");

      List<WebElement> years = this.year.findElements(By.tagName("option"));

      years.stream()
        .filter(year -> year.getText().equalsIgnoreCase(yearNumber))
        .findFirst()
        .orElseThrow(() -> new NotFoundException(String.format("Year %s not found!", yearNumber)))
        .click();
    }

  }

}