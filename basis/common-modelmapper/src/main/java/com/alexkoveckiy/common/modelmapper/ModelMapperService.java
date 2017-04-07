package com.alexkoveckiy.common.modelmapper;

import com.alexkoveckiy.common.dao.entities.ProfileStatusEntity;
import com.alexkoveckiy.common.dto.configuration.DTO.ProfileStatusDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 22.03.17.
 */
@Component
public class ModelMapperService extends ModelMapper {
    public ModelMapperService() {
        //this mapping is needed because without it mapper
        //tries to convert wrong field to boolean
        addMappings(new PropertyMap<ProfileStatusEntity, ProfileStatusDTO>() {
            @Override
            protected void configure() {
                map().setOnline(System.currentTimeMillis() - source.getLastTimeOnline() < 300000);
            }
        });
    }
}
