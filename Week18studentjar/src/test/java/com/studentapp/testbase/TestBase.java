package com.studentapp.testbase;

import com.studentapp.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by bhavesh
 *
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("local.URL"); //http://localhost
        RestAssured.port = Integer.parseInt(propertyReader.getProperty("student.Port")); //8080
       // RestAssured.basePath = Path.STUDENT; //    /student
        //http://localhost:8080
    }

}
