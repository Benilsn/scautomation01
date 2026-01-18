package dev.prj.scautomation01.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class GeneratorUtils {

  static Random rdn;

  private static final User[] USERS = {
    new User("Lucas", User.GenderType.MALE),
    new User("Ana", User.GenderType.FEMALE),
    new User("Pedro", User.GenderType.MALE),
    new User("Marina", User.GenderType.FEMALE),
    new User("Joao", User.GenderType.MALE),
    new User("Beatriz", User.GenderType.FEMALE),
    new User("Carlos", User.GenderType.MALE),
    new User("Julia", User.GenderType.FEMALE)
  };

  private static final String[] LAST_NAMES = {
    "Silva", "Santos", "Oliveira", "Pereira", "Costa", "Rodrigues"
  };

  private static final String[] EMAIL_DOMAINS = {
    "gmail.com", "outlook.com", "test.com"
  };

  static {
    rdn = new Random();
  }

  public static User generate() {
    User baseUser = USERS[rdn.nextInt(USERS.length)];

    String email = generateEmail(baseUser.name);
    String password = generatePassword(baseUser.name);

    baseUser.setEmail(email);
    baseUser.setPassword(password);

    return baseUser;
  }

  private static String generateEmail(String firstName) {
    String lastName = LAST_NAMES[rdn.nextInt(LAST_NAMES.length)];
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

  @Getter
  @Setter
  public static class User {
    @Setter(AccessLevel.NONE)
    private final String name;
    @Setter(AccessLevel.NONE)
    private final By gender;

    private String email;
    private String password;

    public User(String name, GenderType genderType) {
      this.name = name;
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

  }

}
