package com.studentapp.cucumber.steps;

import com.studentapp.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class StudentSteps {
    static ValidatableResponse response;
    static String email = null;
    static String firstName = null;
    static int studentId;

    @Steps
    com.studentapp.studentinfo.StudentSteps studentSteps;


    @When("^User sends a GET request to list endpoint$")
    public void userSendsAGETRequestToListEndpoint() {
        response = studentSteps.getAllStudentInfo();

    }

    @Then("^User must get back a valid status code 200$")
    public void userMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }

    @When("^I create a new student by providing the information firstName \"([^\"]*)\" lastName \"([^\"]*)\" email \"([^\"]*)\" programme \"([^\"]*)\" courses \"([^\"]*)\"$")
    public void iCreateANewStudentByProvidingTheInformationFirstNameLastNameEmailProgrammeCourses(String _firstName, String lastName, String _email, String programme, String courses) {
        List<String> courseList = new ArrayList<>();
        courseList.add(courses);
        firstName = TestUtils.getRandomValue()+ _firstName;  //4657code1
        email = TestUtils.getRandomValue() + _email;  //1344codebuster1@gmail.com
        response=studentSteps.createStudent(firstName, lastName, email, programme, courseList);
        response.statusCode(201);
        System.out.println(firstName);
        System.out.println(email);
    }

    @Then("^I verify that the student with \"([^\"]*)\" is created$")
    public void iVerifyThatTheStudentWithIsCreated(String _email) {
        HashMap<String, Object> studentMap = studentSteps.getStudentInfoByEmail(email);
        studentId = (int) studentMap.get("id");
        System.out.println(studentId);
    }


    @And("^I update the student with information firstName \"([^\"]*)\" lastName \"([^\"]*)\" email \"([^\"]*)\" programme \"([^\"]*)\" courses \"([^\"]*)\"$")
    public void iUpdateTheStudentWithInformationFirstNameLastNameEmailProgrammeCourses(String _firstName, String lastName, String email, String programme, String courses) {
        List<String> courseList = new ArrayList<>();
        courseList.add(courses);
        firstName = firstName + "update"; //code14657update
        studentSteps.updateStudent(studentId, firstName, lastName, email, programme, courseList);
    }

    @And("^The student with firstName \"([^\"]*)\" is updated successfully$")
    public void theStudentWithFirstNameIsUpdatedSuccessfully(String _firstName) {
        HashMap<String, ?> studentMap = studentSteps.getStudentInfoByFirstName(firstName);
        Assert.assertThat(studentMap, hasValue(firstName));

    }


    @And("^I delete the student that created with firstName \"([^\"]*)\"$")
    public void iDeleteTheStudentThatCreatedWithFirstName(String firstName) {
        response = studentSteps.deleteStudentInfoByID(studentId);

    }

    @Then("^The student deleted successfully from the application$")
    public void theStudentDeletedSuccessfullyFromTheApplication() {
        response.statusCode(204);
        studentSteps.getStudentInfoByStudentId(studentId).statusCode(404);
    }

    @Given("^Student application is running$")
    public void studentApplicationIsRunning() {
    }
}