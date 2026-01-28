package dev.prj.scautomation01.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.ThreadLocalRandom;

public class GeneratorUtils implements UserGeneratorConstants {

  static ThreadLocalRandom rdn;

  static {
    rdn = ThreadLocalRandom.current();
  }

  public static User generate() {
    User baseUser = USERS[rdn.nextInt(USERS.length)];

    final String lastName = generateLastName();
    final String email = generateEmail(baseUser.firstName, lastName);
    final String password = generatePassword(baseUser.firstName);
    final User.BirthsDate birthsDate = generateBirthDate();

    baseUser.setLastName(lastName);
    baseUser.setEmail(email);
    baseUser.setPassword(password);
    baseUser.setBirthsDate(birthsDate);

    buildAddressFor(baseUser);

    return baseUser;
  }

  private static String generateLastName() {
    return LAST_NAMES[rdn.nextInt(LAST_NAMES.length)];
  }

  private static String generateEmail(String firstName, String lastName) {
    int number = rdn.nextInt(10_000);
    String domain = EMAIL_DOMAINS[rdn.nextInt(EMAIL_DOMAINS.length)];

    return firstName.toLowerCase()
      .concat("_")
      .concat(lastName.toLowerCase())
      .concat(String.valueOf(number))
      .concat("@")
      .concat(domain);
  }

  private static String generatePassword(String seed) {
    return Base64.getEncoder()
      .encodeToString(seed.getBytes(StandardCharsets.UTF_8));
  }

  private static User.BirthsDate generateBirthDate() {
    final String day = String.valueOf(rdn.nextInt(1, 31));
    final String month = String.valueOf(rdn.nextInt(0, 12));
    final String year = String.valueOf(rdn.nextInt(1950, 2003));

    return new User.BirthsDate(day, month, year);

  }

  private static void buildAddressFor(User baseUser) {
    Country country = Country.values()[rdn.nextInt(Country.values().length)];

    String state = STATES.get(country)[rdn.nextInt(STATES.get(country).length)];
    String city = CITIES.get(country)[rdn.nextInt(CITIES.get(country).length)];

    baseUser.setCompanyName(COMPANIES[rdn.nextInt(COMPANIES.length)]);
    baseUser.setFirstAddress(ADDRESS_1[rdn.nextInt(ADDRESS_1.length)]);
    baseUser.setSecondAddress(ADDRESS_2[rdn.nextInt(ADDRESS_2.length)]);
    baseUser.setCountry(country.actualName);
    baseUser.setState(state);
    baseUser.setCity(city);
    baseUser.setZipCode(generateZipCode(country));
    baseUser.setMobileNumber(generateMobile(country));
  }

  private static String generateMobile(Country country) {
    return switch (country) {
      case UNITED_STATES, CANADA -> "+1" + (2000000000L + rdn.nextLong(7999999999L));
      case AUSTRALIA -> "+61" + (400000000L + rdn.nextLong(599999999L));
      case INDIA -> "+91" + (6000000000L + rdn.nextLong(3999999999L));
      case ISRAEL -> "+972" + (500000000L + rdn.nextLong(499999999L));
      case NEW_ZEALAND -> "+64" + (200000000L + rdn.nextLong(699999999L));
      case SINGAPORE -> "+65" + (80000000 + rdn.nextInt(19999999));
    };
  }

  private static String generateZipCode(Country country) {
    return switch (country) {
      case UNITED_STATES -> String.valueOf(10000 + rdn.nextInt(89999));
      case CANADA -> "A" + rdn.nextInt(9) + "B " + rdn.nextInt(9) + "C" + rdn.nextInt(9);
      case AUSTRALIA -> String.valueOf(2000 + rdn.nextInt(7999));
      case INDIA -> String.valueOf(110000 + rdn.nextInt(889999));
      case ISRAEL -> String.valueOf(1000000 + rdn.nextInt(8999999));
      case NEW_ZEALAND -> String.valueOf(600 + rdn.nextInt(399));
      case SINGAPORE -> String.valueOf(100000 + rdn.nextInt(899999));
    };
  }

  @Getter
  @Setter
  public static class User {
    @Setter(AccessLevel.NONE)
    private final String firstName;
    @Setter(AccessLevel.NONE)
    private final By gender;

    private String lastName;
    private String email;
    private String password;
    private BirthsDate birthsDate;
    private String companyName;
    private String firstAddress;
    private String secondAddress;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    private String mobileNumber;

    public User(String name, GenderType genderType) {
      this.firstName = name;
      this.gender = genderType.genderPath;
    }

    public enum GenderType {
      MALE(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/div[1]/div[1]/label")),
      FEMALE(By.xpath("//*[@id='form']/div/div/div/div/form/div[1]/div[2]/label"));

      final By genderPath;

      GenderType(By genderPath) {
        this.genderPath = genderPath;
      }
    }

    public record BirthsDate(String day, String month, String year) {
    }

  }

  @Getter
  public enum Country {
    INDIA("India"),
    UNITED_STATES("United States"),
    CANADA("Canada"),
    AUSTRALIA("Australia"),
    ISRAEL("Israel"),
    NEW_ZEALAND("New Zealand"),
    SINGAPORE("Singapore");

    private final String actualName;

    Country(String actualName) {
      this.actualName = actualName;
    }
  }

}
