package com.spring.henallux.cyberware.dataAccess.dataAccessObject;

import com.spring.henallux.cyberware.dataAccess.repository.LanguageRepository;
import com.spring.henallux.cyberware.dataAccess.utility.ModelEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LanguageDataAccess implements LanguageDAO {
    private LanguageRepository languageRepository;
    private ModelEntityConverter converter;

    @Autowired
    public LanguageDataAccess(LanguageRepository languageRepository, ModelEntityConverter converter) {
        this.languageRepository = languageRepository;
        this.converter = converter;
    }
}