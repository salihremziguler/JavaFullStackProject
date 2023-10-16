package com.salihguler.JavaFullStackDeveloper.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.util.Date;
//Lombook
@Getter
@Setter

//SUPER ClASS -> Entity yapılarına özel
@MappedSuperclass

//Buradak date olanları takip etme
@JsonIgnoreProperties(value={"created_date,updated_date"},allowGetters = true)

abstract public class AuditingAwareBaseEntity implements Serializable {

    public static final Long serialVersionUID=1L;

    //AUDUTING
    @CreatedBy  //Kim oluşturdu??
    @Column(name = "created_user")  //Database kim ekledi
     protected String createdUser;


    //Kim ne zaman ekledi
    @CreatedDate
    @Column(name = "created_date")
    protected Date createdDate;



    //Kim güncelledi??
    @LastModifiedBy  //Kim oluşturdu??
    @Column(name = "updated_user")  //Database kim ekledi
    protected String updatedUser;

    //Ne zaman
    @LastModifiedDate
    @Column(name = "updated_date")
    protected Date updatedDate;




}//end class