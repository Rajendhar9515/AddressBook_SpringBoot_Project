package com.example.addressbook.repository;


import com.example.addressbook.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepo extends JpaRepository<AddressBookModel, Integer> {
 @Query(value = "SELECT * FROM addressbook.address_book_model where id = id and city = :city", nativeQuery = true)
 List<AddressBookModel> searchResult(String city);

 @Query(value = "SELECT * FROM addressbook.address_book_model order by full_name", nativeQuery = true)
 List<AddressBookModel> sortByName();

 @Query(value = "SELECT * FROM addressbook.address_book_model order by city", nativeQuery = true)
 List<AddressBookModel> sortByCity();
}