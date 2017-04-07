package com.alexkoveckiy.common.dao.service;

import com.alexkoveckiy.common.dao.entities.ContactEntity;
import com.alexkoveckiy.common.dao.repositories.ContactRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by alex on 11.03.17.
 */

@Component
public class ContactService extends BaseService<ContactEntity, ContactRepository> {

    public List<ContactEntity> findByProfileId(String profileId) {
        return repository.findByProfileId(profileId);
    }

    public ContactEntity findByProfileIdAndName(String profileId, String name) {
        return repository.findByProfileIdAndName(profileId, name);
    }
}
