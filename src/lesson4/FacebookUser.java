package lesson4;

public class FacebookUser {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String gender;
    private int day;
    private int month;
    private int yearIndex;

    public FacebookUser(String firstname, String lastname, String email, String password, String gender, int day, int month, int yearIndex) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.day = day;
        this.month = month;
        this.yearIndex = yearIndex;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYearIndex() {
        return yearIndex;
    }

    public String getGender() {
        return gender;
    }
}
