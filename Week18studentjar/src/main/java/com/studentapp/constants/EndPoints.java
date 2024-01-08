package com.studentapp.constants;

/**
 * Created by bhavesh
 */
public class EndPoints {

    /**
     * This is Endpoints of student api
     */
    public static final String GET_ALL_STUDENT = "/student/list";
    public static final String GET_SINGLE_STUDENT_BY_ID = "/student/{studentID}";
    public static final String UPDATE_STUDENT_BY_ID = "/student/{studentID}.json";
    public static final String DELETE_STUDENT_BY_ID = "/student/{studentID}";
    public static final String CREATE_STUDENT = "/student";
    public static final String FIRST_NAME = "firstName";


    /**
     * This is Endpoints of products api
     */

    public static final String GET_SINGLE_PRODUCT_BY_ID = "/{productID}";
    public static final String UPDATE_PRODUCT_BY_ID = "/{productID}";
    public static final String DELETE_PRODUCT_BY_ID = "/{productID}";

    /**
     * This is Endpoints of Authentication api
     */

}
