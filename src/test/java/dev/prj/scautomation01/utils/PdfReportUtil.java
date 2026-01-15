package dev.prj.scautomation01.utils;

import dev.prj.scautomation01.config.AutomationConfig;
import dev.prj.scautomation01.config.ConfigLoader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PdfReportUtil {

  private static final List<File> screenshots = new ArrayList<>();
  private static final AutomationConfig automationConfig;

  static {
    automationConfig = ConfigLoader.load();
  }

  public static void capture(WebDriver driver) {
    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    screenshots.add(src);
  }

  public static void savePdf(String stepText) throws IOException {
    PDDocument document = new PDDocument();
    String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmm"));
    String reportsPath = automationConfig.getReports().getPath();
    String fileName = currentDate + ".pdf";

    File directory = new File(reportsPath);
    if (!directory.exists()) directory.mkdirs();
    File pdfFile = new File(directory, fileName);

    for (File screenshot : screenshots) {
      PDPage page = new PDPage();
      document.addPage(page);

      PDImageXObject image =
        PDImageXObject.createFromFileByContent(screenshot, document);

      PDPageContentStream contentStream =
        new PDPageContentStream(document, page);

      contentStream.drawImage(image, 10, 55, 650, 750);
      contentStream.beginText();
      contentStream.setFont(PDType1Font.HELVETICA, 12);
      contentStream.newLineAtOffset(200, 10);
      contentStream.showText(stepText);
      contentStream.endText();
      contentStream.close();
    }

    document.save(pdfFile.getAbsolutePath());
    document.close();
    screenshots.clear();
  }

}
