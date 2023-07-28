package com.example.exercise_2.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class MusicDto implements Validator {

    private Integer id;
    @NotBlank(message = "Music name not empty")
    private String name;
    @NotBlank(message = "Singer name not empty")
    private String singer;
    @NotBlank(message = "Kind of music not empty")
    private String kindOfMusic;

    public MusicDto() {
    }

    public MusicDto(Integer id, String name, String singer, String kindOfMusic) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        if(musicDto.getName().length() > 800){
            errors.rejectValue("name",null,"Name not exceed 800 characters!");
        }else if(!musicDto.getName().matches("^[a-zA-Z0-9\\s]*$")){
            errors.rejectValue("name",null,"Name not contain special characters (@ ; , . = - + , ….)!");
        }
        if(musicDto.getSinger().length() > 300){
            errors.rejectValue("singer",null,"Singer name not exceed 800 characters!");
        }else if(!musicDto.getSinger().matches("^[a-zA-Z0-9\\s]*$")){
            errors.rejectValue("singer",null,"Singer name not contain special characters (@ ; , . = - + , ….)!");
        }
        if(musicDto.getKindOfMusic().length() > 1000){
            errors.rejectValue("kindOfMusic",null,"Kind of music not exceed 800 characters!");
        }else if(!musicDto.getKindOfMusic().matches("^[a-zA-Z0-9\\s\\,]*$")){
            errors.rejectValue("kindOfMusic",null,"Kind of music not contain special characters (@ ; , . = - + , ….)!");
        }
    }
}
