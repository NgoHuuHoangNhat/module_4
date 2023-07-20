package com.example.exercise_1.service;

import com.example.exercise_1.model.EmailBox;
import com.example.exercise_1.model.Language;
import com.example.exercise_1.model.PageSize;
import com.example.exercise_1.repository.IEmailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailBoxService implements IEmailBoxService {
    @Autowired
    private IEmailBoxRepository emailBoxRepository;
    @Override
    public List<Language> findAllLanguageList() {
        return emailBoxRepository.findAllLanguageList();
    }

    @Override
    public List<PageSize> findAllPageSizeList() {
        return emailBoxRepository.findAllPageSizeList();
    }

    @Override
    public EmailBox findEmailBox() {
        return emailBoxRepository.findEmailBox();
    }

    @Override
    public void updateEmailBox(EmailBox emailBox) {
        emailBoxRepository.updateEmailBox(emailBox);
    }
}
