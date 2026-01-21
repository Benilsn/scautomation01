package dev.prj.scautomation01.utils;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

@RequiredArgsConstructor
public class AutomationUtils {

  private static WebDriver driver;

  public static void highlightElement(WebElement element, Color color) {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    js.executeScript(
      "arguments[0].style.border='3px solid " + color.toString() + "';" +
        "arguments[0].style.backgroundColor='rgba(255, 255, 0, 0.2)';",
      element
    );
  }

  public static void undoHighlight(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    js.executeScript(
      "arguments[0].style.border='0px none';" +
        "arguments[0].style.backgroundColor='transparent';",
      element
    );
  }


}
