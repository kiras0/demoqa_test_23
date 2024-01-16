package test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FormTestPage;
import pages.component.TableComponent;

import static io.qameta.allure.Allure.step;


@DisplayName("Form test on demoqa")
@Tag("demoqa")
public class FormTestPageObjects extends BaseTest {

    FormTestPage formTestPage = new FormTestPage();
    TableComponent tableComponent = new TableComponent();


    @Test
    @Tag("full")
    @DisplayName("Filling form test")
    void fillFormTest() {

        step("Open form test page", () ->
                formTestPage.openPage());
        step("Close all Ads", () ->
                formTestPage.closeBanner());
        step("Filling in the test form", () ->
                formTestPage.setFirstName("Hello")
                .setLastName("World")
                .setUserEmail("helloworld@email.com")
                .setGender("Other")
                .setUserNumber("0011223344")
                .setDateOfBirth("December","1990","10")
                .setSubjects("English")
                .setHobbies("Reading")
                .setPicture("image.png")
                .setAddress("Test Address Placed Here")
                .setState("NCR")
                .setCity("Delhi"));
        step("Clicking submitting the form", () ->
                formTestPage.pressSubmit());



        step("Checking for correct information on submitted form", () ->
        tableComponent.checkResult("Student Name", "Hello" + " " + "World")
                .checkResult("Student Email", "helloworld@email.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "0011223344")
                .checkResult("Date of Birth", "10" + " " + "December" + "," + "1990")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "image.png")
                .checkResult("Address", "Test Address Placed Here")
                .checkResult("State and City", "NCR" + " " + "Delhi"));
    }

    @Test
    @Tag("half")
    @DisplayName("Filling form test with only required fields")
    void requiredFieldFillFormTest() {
        step("Open form test page", () ->
                formTestPage.openPage());
        step("Close all Ads", () ->
                formTestPage.closeBanner());
        step("Filling in only required fields", () ->
                formTestPage.setFirstName("Hello")
                .setLastName("World")
                .setGender("Other")
                .setUserNumber("0123456789")
                .setDateOfBirth("December","1990","10"));
        step("Clicking submitting the form", () ->
                formTestPage.pressSubmit());

        step("Checking table for required submitted info", () ->
        tableComponent.checkResult("Student Name", "Hello" + " " + "World")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "0123456789")
                .checkResult("Date of Birth", "10" + " " + "December" + "," + "1990"));
    }


}


