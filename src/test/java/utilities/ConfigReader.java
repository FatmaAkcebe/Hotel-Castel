package utilities;

import com.github.javafaker.Faker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    static Faker faker = new Faker(new Locale("en-US"));
    private static final String configFilePath = "configuration.properties";

    static {
        try {
            FileInputStream file = new FileInputStream(configFilePath);
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }

    public static void updateProperty(String keyword) {

        switch (keyword) {
            case "firstName":
                String firstName = "Test" + faker.name().firstName();
                properties.setProperty(keyword, firstName);
                break;
            case "lastName":
                String lastName = "Test" + faker.name().lastName();
                properties.setProperty(keyword, lastName);
                break;
            case "email":
                String email = "Test" + faker.internet().emailAddress();
                properties.setProperty(keyword, email);
                break;
            case "phone":
                String phone = "Test" + faker.phoneNumber().cellPhone();
                properties.setProperty(keyword, phone);
                break;
            case "zipCode":
                String zipCode = faker.number().digits(4);
                properties.setProperty(keyword, zipCode);
                break;
            case "address1":
                String address1 = faker.address().fullAddress();
                properties.setProperty(keyword, address1);
                break;
            case "address2":
                String address2 = faker.address().secondaryAddress();
                properties.setProperty(keyword, address2);
                break;
            case "city":
                String city = faker.address().city();
                properties.setProperty(keyword, city);
                break;
            case "gastName":
                String gastName = "Test" + faker.name().fullName();
                properties.setProperty(keyword, gastName);
                break;
            case "orderNumber":
                String orderNumber = faker.number().digits(10);
                properties.setProperty(keyword, orderNumber);
                break;
            case "vatID":
                String vatID = faker.idNumber().valid();
                properties.setProperty(keyword, vatID);
                break;
            case "costCenter":
                String costCenter = faker.company().industry();
                properties.setProperty(keyword, costCenter);
                break;
            case "referans":
                String referans = faker.lorem().word();
                properties.setProperty(keyword, referans);
                break;
        }
    }

    public static void saveToConfig(String key, String value) {
        properties.setProperty(key, value);
        saveProperties();
    }

    private static void saveProperties() {
        try (FileOutputStream outputFile = new FileOutputStream(configFilePath)) {
            properties.store(outputFile, "Updated Dynamic Properties");
        } catch (IOException e) {
            throw new RuntimeException("Error while updating configuration.properties file", e);
        }
    }
}