package dev.prj.scautomation01.pages;

import dev.prj.scautomation01.utils.PdfReportUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public abstract class BasePage {

  protected WebDriver driver;
  protected WebDriverWait wait;

  protected BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    PageFactory.initElements(driver, this);
  }

  public void printScreen(){
    PdfReportUtil.capture(driver);
  }

  public void savePdf(String stepText) throws IOException {
    PdfReportUtil.savePdf(stepText);
  }

}