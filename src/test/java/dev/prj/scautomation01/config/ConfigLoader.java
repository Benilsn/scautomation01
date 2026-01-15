package dev.prj.scautomation01.config;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("all")
public class ConfigLoader {

  private static AutomationConfig config;

  public static AutomationConfig load() {
    Yaml yml = new Yaml();

    InputStream is = ConfigLoader.class.getClassLoader().getResourceAsStream("application.yaml");

    Map<String, Object> applicationYml = yml.load(is);
    Map<String, Object> automation = (Map<String, Object>) applicationYml.get("automation");

    if (Objects.nonNull(automation)) {
      AutomationConfig ac = new AutomationConfig();
      ac.setDriverType((String) automation.get("driver-type"));
      ac.setDriverPath((String) automation.get("driver-path"));

      Map<String, Object> reports = (Map<String, Object>) automation.get("reports");
      if (Objects.nonNull(reports)) {
        AutomationConfig.Reports rts = new AutomationConfig.Reports();
        rts.setEnabled((Boolean) reports.get("enabled"));
        rts.setPath((String) reports.get("path"));
        ac.setReports(rts);
      }

      config = ac;
    }

    return config;
  }

}
