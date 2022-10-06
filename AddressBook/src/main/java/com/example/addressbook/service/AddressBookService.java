package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.exceptionHandling.AddressBookException;
import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.repository.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookInterface {

    @Autowired
    AddressBookRepo addressBookRepo;

    public AddressBookModel saveAll(AddressBookDTO addressBookDTO) {
        List<AddressBookModel> addressBookData = addressBookRepo.findAll();
        for (AddressBookModel bookData : addressBookData) {
            if (bookData.getFullName().equals(addressBookDTO.getFullName())) {
                throw new AddressBookException("This is a duplicate value");
            }
        }
        AddressBookModel addressBookModel = new AddressBookModel(addressBookDTO);
        return addressBookRepo.save(addressBookModel);
    }

    public List<AddressBookModel> display() {
        return addressBookRepo.findAll();
    }

    public AddressBookModel findById(int id) {
        return addressBookRepo.findById(id).orElseThrow(() ->
                new AddressBookException("Employee with id " + id + " does not exist in database"));
    }

    public AddressBookModel update(AddressBookDTO addressBookDTO, int id) {
        if (addressBookRepo.findById(id).isPresent()) {
            List<AddressBookModel> addressBookData = addressBookRepo.findAll();
            for (AddressBookModel bookData : addressBookData) {
                if (bookData.getId() != id && bookData.getFullName().equals(addressBookDTO.getFullName())) {
                    throw new AddressBookException("This is a duplicate value");
                }
            }
            AddressBookModel addressBookModel = new AddressBookModel(addressBookDTO, id);
            return addressBookRepo.save(addressBookModel);
        } else {
            throw new AddressBookException("This id is not present");
        }
    }

    public String deleteById(int id) {
        Optional<AddressBookModel> userId = addressBookRepo.findById(id);
        if (userId.isPresent()) {
            addressBookRepo.deleteById(id);
            return "deleted data by id successfully";
        } else {
            throw (new AddressBookException("This id is not present"));
        }
    }

    public List<AddressBookModel> searchByCity(String city) {
        if (addressBookRepo.searchResult(city).isEmpty()) {
            throw (new AddressBookException("This city not there"));
        } else {
            return addressBookRepo.searchResult(city);
        }
    }

    public List<AddressBookModel> sortByName() {
        if (addressBookRepo.sortByName().isEmpty()) {
            throw (new AddressBookException("name not there"));
        } else {
            return addressBookRepo.sortByName();
        }
    }

    public List<AddressBookModel> sortByCity() {
        if (addressBookRepo.sortByCity().isEmpty()) {
            throw (new AddressBookException("City not there"));
        } else {
            return addressBookRepo.sortByCity();
        }
    }

}
