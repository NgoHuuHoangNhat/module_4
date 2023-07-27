package com.example.exercise_1a.dto;


import com.example.exercise_1a.common.BirthDay;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class UserDto implements Validator {

    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String phoneNumber;
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, Date birthDay, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        if (userDto.getFirstName().trim().equals("")) {
            errors.rejectValue("firstName", null, "Not empty!");
        } else if (userDto.getFirstName().length() < 5 || userDto.getFirstName().length() > 45) {
            errors.rejectValue("firstName", null, "First name length between 5 and 45!");
        }

        if (userDto.getLastName().trim().equals("")) {
            errors.rejectValue("lastName", null, "Not empty!");
        } else if (userDto.getLastName().length() < 5 || userDto.getLastName().length() > 45) {
            errors.rejectValue("lastName", null, "Last name length between 5 and 45!");
        }

        if (userDto.getBirthDay() == null) {
            errors.rejectValue("birthDay", null, "Not empty!");
        } else if (!BirthDay.checkAge(userDto.getBirthDay())) {
            errors.rejectValue("birthDay", null, "Do not enough 18 year old!");
        }

        if (userDto.getPhoneNumber().trim().equals("")) {
            errors.rejectValue("phoneNumber", null, "Not empty");
        } else if (!userDto.getPhoneNumber().matches("(09|03|07|08|05)+([0-9]{8})\\b")) {
            errors.rejectValue("phoneNumber", null, "Not matches!");
        }

        if (userDto.getEmail().trim().equals("")) {
            errors.rejectValue("email", null, "Not Empty!");
        } else if (userDto.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$\n")) {
            errors.rejectValue("email", null, "Email is wrong format!");
        }
    }
}
