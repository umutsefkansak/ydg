package com.obs.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface SingletonModelMapperService {
    ModelMapper standartMap();
    ModelMapper looseMap();

}
