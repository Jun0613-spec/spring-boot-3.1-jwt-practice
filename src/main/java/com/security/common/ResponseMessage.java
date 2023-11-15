package com.security.common;

public interface ResponseMessage {
    
    //HTTP Status 200
    public static final String SUCCESS = "Success.";
    
    //HTTP Status 400
    public static final String VALIDATION_FAILED = "Validation failed.";
    public static final String DUPLICATE_EMAIL = "Duplicate email.";
    public static final String DUPLICATE_NICKNAME = "Duplicate nickname.";
    public static final String NOT_EXISTED_USER = "This user does not exist.";
    public static final String NOT_EXISTED_POST = "This post does not exist.";

    //HTTP Status 401
    public static final String SIGN_IN_FAIL = "Login informatino mismatch.";
    public static final String AUTHORIZATION_FAIL = "Authorization Failed.";

    //HTTP Status 403
    public static final String NO_PERMISSION = "Do not have permission.";

    //HTTP Status 500
    public static final String DATABASE_ERROR = "Database error.";
}
