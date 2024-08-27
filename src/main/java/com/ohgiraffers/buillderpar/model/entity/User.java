package com.ohgiraffers.buillderpar.model.entity;


public class User {

    private Long id;
    private String name;
    private String phone;
    private Integer age;
    private String address;


    public User(UserBuilder builder) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.address = address;
    }

   public static class UserBuilder {

        private String name;
        private String phone;
        private Integer age;
        private String address;

        public UserBuilder (String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public UserBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }


        public User build() {
            return new User(this);
        }

    }




}
