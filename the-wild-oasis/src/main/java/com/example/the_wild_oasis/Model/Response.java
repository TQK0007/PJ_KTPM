package com.example.the_wild_oasis.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Response<T> {
    private T data;
    private String message;
}
