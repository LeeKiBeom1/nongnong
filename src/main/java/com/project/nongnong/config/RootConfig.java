package com.project.nongnong.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class RootConfig {
    // 모델매퍼를 사용하기 위한 환경설정파일 고정으로 사용한다고 생각
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().
                setFieldMatchingEnabled(true).
                setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE).
                setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    // 여기는 Root 컨테이너 이고 @Repository 어노테이션이붙은 클래스들은 여기에 Bean객체로 생성된다.
    // 그렇게 해야 new를 이용해 생성자를 불러오지 않고 컨테이너에서 받아올 수 있다.
    // @Bean 을 써서 직접 등록하는 방법과 일단 만들고 @Repository 를 이용해 등록하는 방법을 적절히 쓰면 된다.


    // 직접 RootContainer에 빈객체로 만들었고 이를통해 프로젝트 어디에서든 JPAQuery를 주입받아 queryDSL을 사용 가능하다.
    @PersistenceContext // 영속성 컨텍스트를 주입하는 표준 애너테이션
    private EntityManager entityManager;
    // 실제 트랜잭션 단위가 수행될때마다 생성되는 EntityManager
    // 클라이언트의 요청이 들어올때 생성했다가 요청이 끝나면 닫는다.
    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }



    




}
