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

    private ModelMapper modelMapper;

    public ModelMapperService() {
        modelMapper = new ModelMapper();
        //this mapping is needed because without it mapper
        //tries to convert wrong field to boolean
        //and throws exception that Long can't be
        //converted to boolean
        modelMapper.addMappings(new PropertyMap<ProfileStatusEntity, ProfileStatusDTO>() {
            @Override
            protected void configure() {
                map().setOnline(System.currentTimeMillis() - source.getLastTimeOnline() < 300000);
            }
        });
    }

    public <D> D map(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public void map(Object source, Object destination) {
        modelMapper.map(source, destination);
    }
}
