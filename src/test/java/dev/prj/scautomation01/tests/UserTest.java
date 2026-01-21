package dev.prj.scautomation01.tests;

import dev.prj.scautomation01.pages.HomePage;
import dev.prj.scautomation01.pages.SignInUpPage;
import dev.prj.scautomation01.utils.GeneratorUtils;
import org.testng.Assert;
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

    homePage.waitForVisibility(homePage.singInUpButton, 2);
    assertTrue(homePage.singInUpButton.isDisplayed());
    homePage.singInUpButton.click();

    SignInUpPage signInUpPage = new SignInUpPage(driver);

    assertTrue(signInUpPage.newUserSignUpTitle.isDisplayed());

    final GeneratorUtils.User user = generate();

    signInUpPage.newUserFormNameInput.sendKeys(user.getFirstName());
    signInUpPage.newUserFormEmailInput.sendKeys(user.getEmail());
    signInUpPage.signUpButton.click();

    assertTrue(signInUpPage.enterAccountInformationTitle.isDisplayed());

    //Select gender
    driver.findElement(user.getGender()).click();

    //Write password
    signInUpPage.newUserPasswordInput.sendKeys(user.getPassword());

    //Select Date of birth
    SignInUpPage.DateOfBirth dateOfBirtSelect = new SignInUpPage.DateOfBirth(driver).build();
    dateOfBirtSelect.selectDay(user.getBirthsDate().day());
    dateOfBirtSelect.selectMonth(user.getBirthsDate().month());
    dateOfBirtSelect.selectYear(user.getBirthsDate().year());

    //Checkboxes
    signInUpPage.newsLetterCheckBox.click();
    signInUpPage.specialOfferCheckBox.click();

    //Select other Info
    signInUpPage.firstNameInput.sendKeys(user.getFirstName());
    signInUpPage.lastNameInput.sendKeys(user.getLastName());
    signInUpPage.companyNameInput.sendKeys(user.getCompanyName());
    signInUpPage.firstAddressInput.sendKeys(user.getFirstAddress());
    signInUpPage.secondAddressInput.sendKeys(user.getSecondAddress());
    signInUpPage.country(user.getCountry()).click();
    signInUpPage.stateInput.sendKeys(user.getState());
    signInUpPage.cityInput.sendKeys(user.getCity());
    signInUpPage.zipCodeInput.sendKeys(user.getZipCode());
    signInUpPage.mobileNumberInput.sendKeys(user.getMobileNumber());

    signInUpPage.createAccountButton.click();

    signInUpPage.waitForVisibility(homePage.accountActionTitle, 2);
    Assert.assertEquals(homePage.accountActionTitle.getText(), "ACCOUNT CREATED!");

    signInUpPage.accountCreatedContinueButton.click();

    signInUpPage.waitForVisibility(homePage.loggedAsUserAnchor, 2);
    Assert.assertTrue(homePage.loggedAsUserAnchor.isDisplayed());

//    deleteAccount(homePage);
  }

  /**
   * 1. Launch browser
   * 2. Navigate to url 'http://automationexercise.com'
   * 3. Verify that home page is visible successfully
   * 4. Click on 'Signup / Login' button
   * 5. Verify 'Login to your account' is visible
   * 6. Enter correct email address and password
   * 7. Click 'login' button
   * 8. Verify that 'Logged in as username' is visible
   * 9. Click 'Delete Account' button
   * 10. Verify that 'ACCOUNT DELETED!' is visible
   */
  @Test
  public void shouldLoginWithaValidUser() {
    HomePage homePage = new HomePage(driver);

  }

  private void deleteAccount(HomePage homePage) {
    homePage.deleteAccountButton.click();

    homePage.waitForVisibility(homePage.accountActionTitle, 2);
    Assert.assertEquals(homePage.accountActionTitle.getText(), "ACCOUNT DELETED!");
  }

}
