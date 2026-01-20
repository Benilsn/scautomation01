package dev.prj.scautomation01.pages;

import dev.prj.scautomation01.utils.PdfReportUtil;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public abstract class BasePage {

  protected WebDriver driver;

  protected BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void waitSeconds(int seconds) {
    try {
      Thread.sleep(seconds * 1000L);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  public void waitForVisibilityAndIgnore(WebElement element, int seconds) {
    try {
      new WebDriverWait(driver, Duration.ofSeconds(seconds))
        .until(ExpectedConditions.visibilityOf(element));
    } catch (TimeoutException ignored) {
    }
  }

  public void waitForVisibility(WebElement element, int seconds) {
    new WebDriverWait(driver, Duration.ofSeconds(seconds))
      .until(ExpectedConditions.visibilityOf(element));
  }

  public void printScreen() {
    PdfReportUtil.capture(driver);
  }

  public void savePdf(String stepText) throws IOException {
    PdfReportUtil.savePdf(stepText);
  }

}