package com.ohgiraffers.buillderpar.model.dto;

import com.ohgiraffers.buillderpar.model.entity.User;

public class UserDTO {

    private Long id;
    private String name;
    private String phone;
    private Integer age;
    private String address;

    public UserDTO(UserDTOBuilder builder) {

        this.name = name;
        this.phone = phone;
        this.age = age;
        this.address = address;
    }

    public static class UserDTOBuilder {

        private String name;
        private String phone;
        private Integer age;
        private String address;

        public UserDTOBuilder (String name, String phone) {
            this.name = name;
            this.phone = phone;
        }

        public UserDTOBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public UserDTOBuilder address(String address) {
            this.address = address;
            return this;
        }


        public UserDTO build() {
            return new UserDTO(this);
        }

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}

