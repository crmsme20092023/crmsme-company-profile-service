package com.crmsme.constant;

import org.springframework.web.servlet.tags.BindErrorsTag;

public interface CONSTANT_PROPERTIES {

    String OTP_EMAIL_SUBJECT="X-BillBook Login OTP";
    String OTP_EMAIL_TYPE="text/html";

    String OTP_EMAIL_TEMPLATE_NAME="email_otp_template.ftl";
    String OTP_EMAIL_FROM="xbillbook_otp@xbillbook.com";
    String OTP_ENC_SECRET_KEY="NlhaRSYyZm5icQ==";
    String PASS_ENCRYPTION_KEY="ekVxMkU2bjNuPw==";

    String CRM_SME_ENCRYPTED_PASSWORD= "c5HCIRbRN9Ij2uMIvqwsAQ==";


    interface  ROLES{

        String ADMIN="Admin";
        String SALESMAN="Salesman";
        String STOCK_MANAGER="Stock Manager";
        String PARTNER="Partner";
        String ACCOUNTANT="Accountant";
        String DELIVERY_BOY="Delivery Boy";

    }



}
