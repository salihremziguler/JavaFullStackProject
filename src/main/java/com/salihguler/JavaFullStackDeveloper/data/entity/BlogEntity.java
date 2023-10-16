package com.salihguler.JavaFullStackDeveloper.data.entity;

import com.salihguler.JavaFullStackDeveloper.audit.AuditingAwareBaseEntity;
import com.salihguler.JavaFullStackDeveloper.data.BlogEntityEmbeddable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder

@Entity
@Table(name="blogs")

// (Blog)N (Category)1
public class BlogEntity extends AuditingAwareBaseEntity implements Serializable {

    //serileştirme
    public static final Long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Relotional N(Category)   1(Blog)
    @Column(name = "blogId",unique = true,nullable = false,updatable = false,insertable = true)
    private Long blog_id;

    //Embedded
    @Embedded
    private BlogEntityEmbeddable blogEntityEmbeddable=new BlogEntityEmbeddable();


    //Relation
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "category_id",nullable = false)
    private CategoryEntity relationcategoryEntity;

    //Constructor (parametresiz)


    public BlogEntity() {

    }

    //Constructor (parametreli)


    public BlogEntity(BlogEntityEmbeddable blogEntityEmbeddable, CategoryEntity relationcategoryEntity) {
        this.blogEntityEmbeddable = blogEntityEmbeddable;
        this.relationcategoryEntity = relationcategoryEntity;
    }



}
