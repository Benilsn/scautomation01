package dev.prj.scautomation01.config;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

@SuppressWarnings("all")
public class ConfigLoader {

  private static AutomationConfig config;

  public static AutomationConfig load(){
    Yaml yml = new Yaml();

    InputStream is = ConfigLoader.class.getClassLoader().getResourceAsStream("application.yml");

    Map<String, Object> applicationYml = yml.load(is);
    Map<String, Object> automation = (Map<String, Object>)  applicationYml.get("automation");

    AutomationConfig ac = new AutomationConfig();
    ac.setDriverType((String) automation.get("browser"));
    config = ac;

    return ac;
  }

}
