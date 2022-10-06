package com.example.addressbook.model;


import com.example.addressbook.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class AddressBookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    String fullName;
    String Address;
    String city;
    String state;
    String country;
    String zip;
    String phoneNumber;
    String email;

    public  AddressBookModel(AddressBookDTO addressBookDTO, int id){
        this.fullName = addressBookDTO.getFullName();
        this.Address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state= addressBookDTO.getState();
        this.country = addressBookDTO.getCountry();
        this.zip = addressBookDTO.getZip();
        this.email = addressBookDTO.getEmail();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.id = id;
    }

    public  AddressBookModel(AddressBookDTO addressBookDTO){
        this.fullName = addressBookDTO.getFullName();
        this.Address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state= addressBookDTO.getState();
        this.country = addressBookDTO.getCountry();
        this.zip = addressBookDTO.getZip();
        this.email = addressBookDTO.getEmail();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.id = id;
    }


}
