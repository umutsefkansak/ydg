package com.obs.core.utilities.mappers;

import lombok.Synchronized;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class SingletonModelMapperServiceImpl implements SingletonModelMapperService{

    private static SingletonModelMapperService instance;
    private ModelMapper modelMapper;


    private SingletonModelMapperServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public static SingletonModelMapperService getInstance(){

        if(instance == null){
            synchronized (SingletonModelMapperServiceImpl.class){
                if(instance==null){
                    instance = new SingletonModelMapperServiceImpl(new ModelMapper());
                }
            }
        }
        return instance;
    }



    @Override
    public ModelMapper standartMap() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);

        return this.modelMapper;
    }

    @Override
    public ModelMapper looseMap() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        return this.modelMapper;
    }


}
