package com.project.nongnong.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    // 모델매퍼를 사용하기 위한 환경설정파일
    @Bean //고정
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().
                setFieldMatchingEnabled(true).
                setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE).
                setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
