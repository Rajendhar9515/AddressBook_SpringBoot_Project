package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;

public interface IAddressBookInterface {

        Object saveAll(AddressBookDTO addressBookDTO);

        Object display();

        Object findById(int id);

        Object update(AddressBookDTO addressBookDTO, int id);

        Object deleteById(int id);

        Object searchByCity(String city);

        Object sortByName();

        Object sortByCity();
}