package dev.prj.scautomation01.tests;

import dev.prj.scautomation01.pages.HomePage;
import dev.prj.scautomation01.pages.SignInUpPage;
import dev.prj.scautomation01.utils.GeneratorUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static dev.prj.scautomation01.utils.GeneratorUtils.*;
import static org.testng.Assert.assertTrue;

public class UserTest extends BaseTest {

  /*
  1. Launch browser
  2. Navigate to url 'http://automationexercise.com'
  3. Verify that home page is visible successfully
  4. Click on 'Signup / Login' button
  5. Verify 'New User Signup!' is visible
  6. Enter name and email address
  7. Click 'Signup' button
  8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

TODO
  9. Fill details: Title, Name, Email, Password, Date of birth

  10. Select checkbox 'Sign up for our newsletter!'
  11. Select checkbox 'Receive special offers from our partners!'
  12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
  13. Click 'Create Account button'
  14. Verify that 'ACCOUNT CREATED!' is visible
  15. Click 'Continue' button
  16. Verify that 'Logged in as username' is visible
  17. Click 'Delete Account' button
  18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
   */

  @Test
  public void shouldRegisterAUser() {
    HomePage homePage = new HomePage(driver);
    homePage.open();

    homePage.wait(2);

    assertTrue(driver.findElement(homePage.singInUpButton).isDisplayed());
    driver.findElement(homePage.singInUpButton).click();

    SignInUpPage signInUpPage = new SignInUpPage(driver);

    assertTrue(driver.findElement(signInUpPage.newUserSignUpTitle).isDisplayed());

    final GeneratorUtils.User user = generate();

    driver.findElement(signInUpPage.newUserFormNameInput).sendKeys(user.getName());
    driver.findElement(signInUpPage.newUserFormEmailInput).sendKeys(user.getEmail());

    driver.findElement(signInUpPage.signUpButton).click();

    homePage.wait(2);

    assertTrue(driver.findElement(signInUpPage.enterAccountInformationTitle).isDisplayed());

    //Select gender
    driver.findElement(user.getGender()).click();

    //Write password
    driver.findElement(signInUpPage.newUserPasswordInput).sendKeys(user.getPassword());

    //Select Date of birth
    SignInUpPage.DateOfBirth dateOfBirtSelect = new SignInUpPage.DateOfBirth(driver).build();

    // TODO Make it dynamic
    dateOfBirtSelect.selectDay("1");
    dateOfBirtSelect.selectMonth("February");
    dateOfBirtSelect.selectYear("2007");


  }


}
