package com.example.springbootjava3a.error;

public class MyError extends Error {
    public MyError() {
        throw new RuntimeException("not found");
    }
}
