package com.salihguler.JavaFullStackDeveloper.audit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

//BAse DTO
//Lombook
@Getter
@Setter
abstract public class AuditingAwareBaseDto implements Serializable {

    public static final Long serialVersionUID=1L;
    //ID
    private Long id;

    @Builder.Default  //Default olarak ayarlar
    protected Date systemDate=new Date(System.currentTimeMillis());

    //AUDUTING
    //Ekleme User,Date
    @JsonIgnore //Backente giden veriyi saklar
    protected String createdUser;
    protected Date createdDate;

    //Güncelleme User,Date
    @JsonIgnore //Backente giden veriyi saklar
    protected String updatedUser;
    protected Date updatedDate;



}//end class
