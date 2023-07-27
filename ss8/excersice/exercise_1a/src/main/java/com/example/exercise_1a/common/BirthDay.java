package com.example.exercise_1a.common;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class BirthDay {
    public static boolean checkAge(Date birthDay){
        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = birthDay.toLocalDate();

        Period period = Period.between(birthDate,currentDate);
        if(period.getYears() < 18){
            return false;
        }
        return true;
    }
}
