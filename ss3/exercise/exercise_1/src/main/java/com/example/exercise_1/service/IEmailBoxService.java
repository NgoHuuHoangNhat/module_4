package com.example.exercise_1.service;

import com.example.exercise_1.model.EmailBox;
import com.example.exercise_1.model.Language;
import com.example.exercise_1.model.PageSize;

import java.util.List;

public interface IEmailBoxService {
    List<Language> findAllLanguageList();

    List<PageSize> findAllPageSizeList();

    EmailBox findEmailBox();

    void updateEmailBox(EmailBox emailBox);
}
