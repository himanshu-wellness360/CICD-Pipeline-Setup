package genericUtilities;

import com.github.javafaker.Faker;

public class JavaUtility {


	// Method to generate random last name
	public String generateFakeFirstName() {
		Faker faker = new Faker();
		return faker.name().firstName(); // Generate and return a fake first name
	}

	// Method to generate random last name
	public String generateFakeLastName() {
		Faker faker = new Faker();
		return faker.name().lastName(); // Generate and return a fake last name
	}
	// Method to generate random email
	public String generateFakeEmail(String firstName, String lastName) {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@gmail.com"; // Generate email
    }

	// Method to generate random phone number
	public String generateFakePhoneNumber() {
		Faker faker = new Faker();
		return faker.phoneNumber().phoneNumber(); // Generate and return a fake phone number
	}

}


