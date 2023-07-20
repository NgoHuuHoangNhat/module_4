package com.example.exercise_1.repository;

import com.example.exercise_1.model.EmailBox;
import com.example.exercise_1.model.Language;
import com.example.exercise_1.model.PageSize;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailBoxRepository implements IEmailBoxRepository {
    private static List<Language> languageList = new ArrayList<>();
    private static List<PageSize> pageSizeList = new ArrayList<>();
    private static EmailBox emailBox;

    static {
        languageList.add(new Language(1, "English"));
        languageList.add(new Language(2, "Vietnamese"));
        languageList.add(new Language(3, "Japanese"));
        languageList.add(new Language(4, "Chinese"));
    }

    static {
        pageSizeList.add(new PageSize(1, 5));
        pageSizeList.add(new PageSize(2, 10));
        pageSizeList.add(new PageSize(3, 15));
        pageSizeList.add(new PageSize(4, 25));
        pageSizeList.add(new PageSize(5, 50));
        pageSizeList.add(new PageSize(6, 100));
    }

    static {
        emailBox = new EmailBox(languageList.get(1).getName(), pageSizeList.get(1).getSize(), true, "Thor");
    }

    @Override
    public List<Language> findAllLanguageList() {
        return languageList;
    }

    @Override
    public List<PageSize> findAllPageSizeList() {
        return pageSizeList;
    }

    @Override
    public EmailBox findEmailBox() {
        return emailBox;
    }

    @Override
    public void updateEmailBox(EmailBox emailBoxInfoUpdate) {
        emailBox.setLanguages(emailBoxInfoUpdate.getLanguages());
        emailBox.setPageSizes(emailBoxInfoUpdate.getPageSizes());
        emailBox.setSignature(emailBoxInfoUpdate.getSignature());
        emailBox.setSpamsFilter(emailBoxInfoUpdate.getSpamsFilter());
    }
}
