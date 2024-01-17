package pages;

import com.codeborne.selenide.SelenideElement;
import pages.component.CalendarComponent;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FormTestPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateCityWrapperInput = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitInput = $("#submit");



// open("/automation-practice-form"); Firefox fix*
    CalendarComponent calendarComponent = new CalendarComponent();
    public FormTestPage openPage() {
        open("");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public FormTestPage closeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public FormTestPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public FormTestPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public FormTestPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public FormTestPage setGender(String value) {
        userGenderInput.$(byText(value)).click();

        return this;
    }
    public FormTestPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }
    public FormTestPage setDateOfBirth(String Month, String Year, String Day) {
        calendarInput.click();
        calendarComponent.setDate(Month,Year,Day);


        return this;
    }
    public FormTestPage setSubjects(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }
    public FormTestPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }
    public FormTestPage setPicture(String filename) {
        pictureInput.uploadFromClasspath(filename);

        return this;
    }
    public FormTestPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }
    public FormTestPage setState(String value) {
        stateInput.click();
        stateCityWrapperInput.$(byText(value)).click();


        return this;
    }
    public FormTestPage setCity(String value) {
        cityInput.click();
        stateCityWrapperInput.$(byText(value)).click();


        return this;
    }
    public FormTestPage pressSubmit() {
        submitInput.click();

        return this;
    }
}
