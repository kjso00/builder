package com.ohgiraffers.buillderpar.model.entity;

public class User {

    private String name;
    private String phone;
    private int age;
    private String postalCode;
    private String address;
    private String detailAddress;


    public User(UserBuilder builder) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.postalCode = postalCode;
        this.address = address;
        this.detailAddress = detailAddress;
    }

    public static class UserBuilder {
        private String name;
        private String phone;
        private int age;
        private String postalCode;
        private String address;
        private String detailAddress;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }
    public UserBuilder phone(String phone) {
        this.phone = phone;

    }



}
