package Config;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;

// I used https://java.libhunt.com/java-faker-alternatives

public class FormFillers {

    Faker faker = new Faker();

    String username;
    String password;
    String passwordRepeat;
    String firstName;
    String lastName;
    String email;
    String phone;
    String address1;
    String address2;
    String city;
    String state;
    String zip;
    String country;
    String save;

    public void field() {
        username = faker.name().username();
        password = faker.internet().password();
        passwordRepeat = password;
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        phone = faker.phoneNumber().phoneNumber();
        address1 = faker.address().fullAddress();
        address2 = faker.address().fullAddress();
        city = faker.address().city();
        state = faker.address().state();
        zip = faker.address().zipCode();
        country = faker.address().country();
    }





}
