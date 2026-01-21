package dev.prj.scautomation01.pages;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.IntStream;

public class SignInUpPage extends BasePage {

  @FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/h2")
  public WebElement newUserSignUpTitle;

  @FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/form/input[2]")
  public WebElement newUserFormNameInput;

  @FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/form/input[3]")
  public WebElement newUserFormEmailInput;

  @FindBy(xpath = "//*[@id='form']/div/div/div[3]/div/form/button")
  public WebElement signUpButton;

  @FindBy(xpath = "//*[@id='form']/div/div/div/div/h2/b")
  public WebElement enterAccountInformationTitle;

  public DateOfBirth dateOfBirth;

  @FindBy(id = "password")
  public WebElement newUserPasswordInput;

  @FindBy(id = "newsletter")
  public WebElement newsLetterCheckBox;

  @FindBy(id = "optin")
  public WebElement specialOfferCheckBox;

  @FindBy(id = "first_name")
  public WebElement firstNameInput;

  @FindBy(id = "last_name")
  public WebElement lastNameInput;

  @FindBy(id = "company")
  public WebElement companyNameInput;

  @FindBy(id = "address1")
  public WebElement firstAddressInput;

  @FindBy(id = "address2")
  public WebElement secondAddressInput;

  @Getter(AccessLevel.NONE)
  @FindBy(id = "country")
  public WebElement countrySelect;

  @FindBy(id = "state")
  public WebElement stateInput;

  @FindBy(id = "city")
  public WebElement cityInput;

  @FindBy(id = "zipcode")
  public WebElement zipCodeInput;

  @FindBy(id = "mobile_number")
  public WebElement mobileNumberInput;

  @FindBy(xpath = "//*[@id='form']/div/div/div/div/form/button")
  public WebElement createAccountButton;

  @FindBy(xpath = "//*[@id='form']/div/div/div/div/a")
  public WebElement accountCreatedContinueButton;

  public SignInUpPage(WebDriver driver) {
    super(driver);
    dateOfBirth = new DateOfBirth(driver);
  }

  public void open() {
    driver.get("https://automationexercise.com/signup");
  }

  public WebElement country(String country) {
    return
      this.countrySelect
        .findElements(By.tagName("option"))
        .stream()
        .filter(e -> e.getText().equalsIgnoreCase(country))
        .findFirst()
        .orElseThrow(() -> new NotFoundException(String.format("Country (%s), not found!", country)));
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
      By dateOfBirthSelect = By.xpath("//*[@id='form']/div/div/div/div/form/div[5]/div");
      return driver.findElement(dateOfBirthSelect)
        .findElements(By.tagName("div"))
        .stream()
        .filter(e -> e.getAttribute("id").equalsIgnoreCase(elementId))
        .filter(e -> e.findElement(By.tagName("select")).isEnabled())
        .findFirst()
        .orElseThrow(() -> new NotFoundException(String.format("Element %s not found!", elementId)));
    }

    public void selectDay(String dayNumber) {
      if (this.day.isDisplayed()) this.day.click();
      else throw new ElementNotInteractableException("Day element not displayed!");

      List<WebElement> days = this.day.findElements(By.tagName("option"));
      days.remove(0);

      days.stream()
        .filter(day -> day.getText().equalsIgnoreCase(dayNumber))
        .findFirst()
        .orElseThrow(() -> new NotFoundException(String.format("Day %s not found!", dayNumber)))
        .click();
    }

    public void selectMonth(String month) {
      if (this.month.isDisplayed()) this.month.click();
      else throw new ElementNotInteractableException("Month element not displayed!");

      List<WebElement> months = this.month.findElements(By.tagName("option"));
      months.remove(0);

      months.get(Integer.parseInt(month)).click();
    }

    public void selectYear(String yearNumber) {
      if (this.year.isDisplayed()) this.year.click();
      else throw new ElementNotInteractableException("Year element not displayed!");

      List<WebElement> years = this.year.findElements(By.tagName("option"));
      years.remove(0);

      years.stream()
        .filter(year -> year.getText().equalsIgnoreCase(yearNumber))
        .findFirst()
        .orElseThrow(() -> new NotFoundException(String.format("Year %s not found!", yearNumber)))
        .click();
    }

  }

}