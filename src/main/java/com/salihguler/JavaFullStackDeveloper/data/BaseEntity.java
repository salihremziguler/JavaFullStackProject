package com.salihguler.JavaFullStackDeveloper.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.salihguler.JavaFullStackDeveloper.audit.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

//Lombook
@Getter
@Setter

//SUPER ClASS -> Entity yapılarına özel
@MappedSuperclass
//Buradak date olanları takip etme
@JsonIgnoreProperties(value={"created_date,updated_date"},allowGetters = true)
@EntityListeners(AuditingEntityListener.class)   //Audiding çalışabilmesi için

abstract public class BaseEntity extends AuditingAwareBaseEntity {

    //ID(Unique)
    @Id   //for database
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    protected Date systemDate;





}
