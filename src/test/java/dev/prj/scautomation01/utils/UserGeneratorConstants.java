package dev.prj.scautomation01.utils;

import java.util.Map;

public interface UserGeneratorConstants {

  GeneratorUtils.User[] USERS = {
    new GeneratorUtils.User("Lucas", GeneratorUtils.User.GenderType.MALE),
    new GeneratorUtils.User("Ana", GeneratorUtils.User.GenderType.FEMALE),
    new GeneratorUtils.User("Pedro", GeneratorUtils.User.GenderType.MALE),
    new GeneratorUtils.User("Marina", GeneratorUtils.User.GenderType.FEMALE),
    new GeneratorUtils.User("Joao", GeneratorUtils.User.GenderType.MALE),
    new GeneratorUtils.User("Beatriz", GeneratorUtils.User.GenderType.FEMALE),
    new GeneratorUtils.User("Carlos", GeneratorUtils.User.GenderType.MALE),
    new GeneratorUtils.User("Julia", GeneratorUtils.User.GenderType.FEMALE)
  };

  String[] LAST_NAMES = {
    "Silva", "Santos", "Oliveira", "Pereira", "Costa", "Rodrigues"
  };

  String[] EMAIL_DOMAINS = {
    "gmail.com", "outlook.com", "test.com"
  };

  String[] COMPANIES = {
    "TechNova", "BlueSoft", "Green Solutions", "NextGen Corp",
    "Alpha Systems", "Future Labs", "Cloudify", "DataWorks"
  };

  String[] ADDRESS_1 = {
    "123 Main Street", "456 Oak Avenue", "789 Pine Road",
    "12 Sunset Blvd", "88 Market Street", "901 First Ave"
  };

  String[] ADDRESS_2 = {
    "Apt 101", "Suite 500", "Floor 3", "Unit B", "Block C", ""
  };

  Map<GeneratorUtils.Country, String[]> STATES = Map.of(
    GeneratorUtils.Country.INDIA, new String[]{"Maharashtra", "Karnataka", "Delhi"},
    GeneratorUtils.Country.UNITED_STATES, new String[]{"California", "Texas", "New York"},
    GeneratorUtils.Country.CANADA, new String[]{"Ontario", "Quebec", "British Columbia"},
    GeneratorUtils.Country.AUSTRALIA, new String[]{"New South Wales", "Victoria", "Queensland"},
    GeneratorUtils.Country.ISRAEL, new String[]{"Tel Aviv", "Jerusalem"},
    GeneratorUtils.Country.NEW_ZEALAND, new String[]{"Auckland", "Wellington"},
    GeneratorUtils.Country.SINGAPORE, new String[]{"Central"}
  );

  Map<GeneratorUtils.Country, String[]> CITIES = Map.of(
    GeneratorUtils.Country.INDIA, new String[]{"Mumbai", "Bangalore", "Delhi"},
    GeneratorUtils.Country.UNITED_STATES, new String[]{"Los Angeles", "Houston", "New York"},
    GeneratorUtils.Country.CANADA, new String[]{"Toronto", "Vancouver", "Montreal"},
    GeneratorUtils.Country.AUSTRALIA, new String[]{"Sydney", "Melbourne", "Brisbane"},
    GeneratorUtils.Country.ISRAEL, new String[]{"Tel Aviv", "Haifa"},
    GeneratorUtils.Country.NEW_ZEALAND, new String[]{"Auckland", "Christchurch"},
    GeneratorUtils.Country.SINGAPORE, new String[]{"Singapore"}
  );

}
