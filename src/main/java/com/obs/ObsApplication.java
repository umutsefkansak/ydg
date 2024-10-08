package com.obs;

import com.obs.core.utilities.mappers.SingletonModelMapperService;
import com.obs.core.utilities.mappers.SingletonModelMapperServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObsApplication {

	public static void main(String[] args){
		SpringApplication.run(ObsApplication.class, args);

		SingletonModelMapperService s1 = SingletonModelMapperServiceImpl.getInstance();
		SingletonModelMapperService s2 = SingletonModelMapperServiceImpl.getInstance();

		if(s1 == s2){
			System.out.println("esit");
		}
		else{
			System.out.println("farkli");
		}

	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
