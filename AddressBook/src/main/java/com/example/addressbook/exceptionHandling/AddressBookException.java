package com.example.addressbook.exceptionHandling;


public class AddressBookException extends RuntimeException {
    public AddressBookException(String message) {
        super(message);
    }
}
