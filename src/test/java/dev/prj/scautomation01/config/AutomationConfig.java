package dev.prj.scautomation01.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomationConfig {

  @Setter(AccessLevel.NONE)
  private DriverType driverType;
  private String driverPath;
  private Reports reports;

  public void setDriverType(String driverType) {
    if (driverType.equalsIgnoreCase(DriverType.EDGE.name()))
      this.driverType = DriverType.EDGE;
    else
      this.driverType = DriverType.CHROME;
  }

  public enum DriverType {
    CHROME,
    EDGE
  }

  @Getter
  @Setter
  public static class Reports {
    private boolean enabled;
    private String path;
  }

}
