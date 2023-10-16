package com.salihguler.JavaFullStackDeveloper.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

//Lombok
@Getter
@Setter

//SUPER CLASS
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)   //Audiding çalışabilmesi için

abstract public class BaseEntity implements Serializable {

    //serileştirme
    public static final Long serialVersionUID=1L;

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,updatable = false,unique = false)
    private Long id;

    //DATE
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;







}
