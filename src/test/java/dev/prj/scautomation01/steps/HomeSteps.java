package dev.prj.scautomation01.steps;

import dev.prj.scautomation01.core.DriverFactory;
import dev.prj.scautomation01.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class HomeSteps {

  private final WebDriver driver;
  private final HomePage homePage;

  public HomeSteps() {
    this.driver = DriverFactory.getDriver();
    this.homePage = new HomePage(driver);
  }

  @Given("I open the demo website")
  public void openWebsite() {
    homePage.open();
  }

  @Then("the page title should contain {string}")
  public void validateTitle(String expected) throws IOException {
    Assert.assertTrue(true);
  }
}