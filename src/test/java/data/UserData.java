package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class UserData {

    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String testEmail = faker.internet().emailAddress();
    public String streetAddress = faker.address().streetAddress();
    public String phoneNumber = faker.numerify("##########");

    public static String nameFile = "test.png";

    private String gender;
    private String year;
    private String month;
    private String day;
    private String subjects;
    private String hobbies;
    private String state;
    private String city;

    public UserData() {
        gender = getRandomGender();
        year = getRandomYear();
        month = getRandomMonth();
        day = getRandomDay();
        subjects = getRandomSubjects();
        hobbies = getRandomHobbies();
        state = getRandomState();
        city = getRandomCity(state);
    }

    public String getGender() {
        return gender;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getSubjects() {
        return subjects;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    private int getRandomFakerInt(int min, int max) {
        return faker.number().numberBetween(min, max + 1);
    }

    private String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    private String getRandomYear() {
        int currentYear = LocalDate.now().getYear();
        return String.valueOf(getRandomFakerInt(1990, currentYear + 1));
    }

    private String getRandomMonth() {
        return Month.of(getRandomFakerInt(1, 13)).getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    private String getRandomDay() {
        int year = Integer.parseInt(getRandomYear());
        int month = Month.valueOf(getRandomMonth().toUpperCase()).getValue();
        int maxDayInMonth = YearMonth.of(year, month).lengthOfMonth();

        return String.valueOf(getRandomFakerInt(1, maxDayInMonth + 1));
    }

    private String getRandomSubjects() {
        return faker.options().option("Physics", "English", "Commerce", "History",
                "Chemistry", "Maths", "Arts", "Biology", "Computer Science", "Economics");
    }

    private String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    private String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    private String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException(
                    "Неизвестное значение state: " + state);
        };
    }
}
