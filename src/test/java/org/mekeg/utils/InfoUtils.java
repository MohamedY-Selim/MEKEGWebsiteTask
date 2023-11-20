package org.mekeg.utils;

import com.github.javafaker.Faker;
import org.mekeg.objects.Info;

public class InfoUtils {
    public static Info generateRandomInfo() {
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String email = new Faker().internet().emailAddress();
        String mobileNumber = "01001234567";
        String street = new Faker().address().streetName();
        String square = new Faker().address().state();
        String landMark = new Faker().address().state();
        String building = new Faker().address().buildingNumber();
        String floor = new Faker().address().buildingNumber();
        String flat = new Faker().address().buildingNumber();
        return new Info(firstName, lastName, email, mobileNumber, street, square, landMark, building, floor, flat);
    }
}
