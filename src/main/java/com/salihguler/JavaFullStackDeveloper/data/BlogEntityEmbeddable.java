package com.salihguler.JavaFullStackDeveloper.data;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

//Lombok
@Getter
@Setter

@Embeddable
public class BlogEntityEmbeddable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Relotional N(Category)   1(Blog)
    @Column(name = "blogId",unique = true,nullable = false)
    private Long blog_id;


    //HEADER
    @Column(name = "header",nullable = false,unique = true,length = 500,insertable = true,updatable = true,columnDefinition = "varchar(255) default 'blog için başlık girilmedi' ")
    private String header;

    //CONTENT
    @Lob
    @Column(name = "content",columnDefinition = "varchar(255) default 'blog için içerik girilmedi' ")
    private String content;

    //TITLE
    private String title;


    //DATE
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;





    //Javada olsun Database(entity) de olmasın
   /* @Transient
    private Object specialData*/
/*
    @Lob //Büyük nesneler için kullanılır.
    private String bigData*/





}
