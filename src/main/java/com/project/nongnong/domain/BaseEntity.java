package com.project.nongnong.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // 다른 Entity 클래스들이 이 클래스를 상속할 경우 createdDate / modifiedDate 를 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)  // 해당 클래스에 Auditing 기능을 포함한다.
public abstract class BaseEntity {
    // 얘는 abstract class로 만들어야한다 인터페이스가 아니다. 인터페이스와 다른점을 알아야한다.
    // AuditingEntityListener.class 이부분을 value = {AuditingEntityListener.class} 이렇게 해도 동작한다.

    // Entity 가 생성되어 저장될 때 시간이 자동 저장됩니다.
    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime createdDate;

    // 조회한 Entity 값을 변경할 때 시간이 자동 저장됩니다.
    @LastModifiedDate
    @Column(name = "moddate", updatable = false)
    private LocalDateTime modifiedDate;


}
