package com.example.addressbook.dto;


import lombok.Data;

@Data
public class ResponseDTO {
    String message;
    Object data;

    public ResponseDTO(String message, Object data){
        this.message = message;
        this.data = data;
    }
}
