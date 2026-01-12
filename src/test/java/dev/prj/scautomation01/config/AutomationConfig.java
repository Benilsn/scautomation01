package dev.prj.scautomation01.config;

import lombok.Getter;

@Getter
public class AutomationConfig {

  private DriverType driverType;

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

}
