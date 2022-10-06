package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.service.IAddressBookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/addressBook")
public class AddressBook {

    @Autowired
    IAddressBookInterface iAddressBookInterface;

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> save(@Valid  @RequestBody AddressBookDTO addressBookDTO){
        ResponseDTO responseDTO = new ResponseDTO("Data saved successfully", iAddressBookInterface.saveAll(addressBookDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/empdata")
    public ResponseEntity<ResponseDTO> displayAll(){
        ResponseDTO responseDTO = new ResponseDTO("Get call successfully", iAddressBookInterface.display());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ResponseDTO> findById(@PathVariable int id ){
        ResponseDTO responseDTO = new ResponseDTO("Get call for Id successfully", iAddressBookInterface.findById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ResponseDTO> update(@Valid @RequestBody AddressBookDTO addressBookDTO, @PathVariable int id) {
        ResponseDTO responseDTO = new ResponseDTO("Updated data successfully", iAddressBookInterface.update(addressBookDTO, id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Deleted data successfully", iAddressBookInterface.deleteById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/search/{city}")
    public ResponseEntity<ResponseDTO> searchByCity(@PathVariable String city){
        ResponseDTO responseDTO = new ResponseDTO("Get call for city successfully",iAddressBookInterface.searchByCity(city));
        return  new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    @GetMapping("/sortByName")
    public ResponseEntity<ResponseDTO> sortByName(){
        ResponseDTO responseDTO = new ResponseDTO("Get call for name sorted successfully",iAddressBookInterface.sortByName());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }
    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDTO> sortByCity(){
        ResponseDTO responseDTO = new ResponseDTO("Get call for city sorted successfully",iAddressBookInterface.sortByCity());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

    }
}
