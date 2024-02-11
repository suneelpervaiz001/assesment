package com.tech.assesment.constants;

public enum UserType {

    EMPLOYEE("EMPLOYEE"),
    AFFILIATE("AFFILIATE"),
    CUSTOMER_OVER_TWO_YEARS("CUSTOMER_OVER_TWO_YEARS");

    final String value;

    UserType(final String value) {
        this.value = value;
    }

}
