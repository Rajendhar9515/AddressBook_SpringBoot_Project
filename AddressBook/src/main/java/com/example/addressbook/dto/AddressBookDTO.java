package com.example.addressbook.dto;


import lombok.Data;
import javax.validation.constraints.*;

@Data
public class AddressBookDTO {


    @Pattern(regexp = "^[A-Za-z]{1,} [A-Za-z]{2,}$", message = "Please enter valid name")
    String fullName;

    @NotBlank(message = "Please enter address")
    String Address;

    @NotBlank(message = "Please enter city")
    String city;

    @NotBlank(message = "Please Enter state name")
    String state;

    @NotBlank(message = "Please enter country")
    String country;

    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Zip is Invalid")
    String zip;

    @Pattern(regexp = "[0-9]{10}$", message = "phoneNumber is Invalid")
    String phoneNumber;

    @Pattern(regexp ="^(.+)@(\\S+)$", message = "Email is Invalid")
    String email;
}
