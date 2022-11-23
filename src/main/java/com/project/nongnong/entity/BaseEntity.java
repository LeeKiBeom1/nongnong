package com.project.nongnong.entity;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // 다른 Entity 클래스들이 이 클래스를 상속할 경우 createdDate / modifiedDate 를 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)  // 해당 클래스에 Auditing 기능을 포함한다.
public class BaseEntity {

    // Entity 가 생성되어 저장될 때 시강니 자동 저장됩니다.
    @CreatedDate
    private LocalDateTime createdDate;

    // 조회한 Entity 값을 변경할 때 시간이 자동 저장됩니다.
    @LastModifiedDate
    private LocalDateTime modifiedDate;


}
