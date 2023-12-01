package com.crmsme.global.exception;

public interface ExceptionConstant {

    public interface  ExceptionTypes{
        String FIELD_VALIDATION="FIELD_VALIDATION";
        String SYSTEM_ERROR="SYSTEM_ERROR";
        String BUSINESS_VALIDATION="BUSINESS_VALIDATION";

        String UNAUTHORIZED = "UNAUTHORIZED";
    }


    public interface  ExceptionCode{
        int _500 =500;
        int _501 =501;
        int _400 =400;
        int _401 =401;
    }

}
