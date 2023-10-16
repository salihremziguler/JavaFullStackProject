package com.salihguler.JavaFullStackDeveloper.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@Log4j2


@Entity
@Table(name="category_blogs")
//CAtegory(1) Blog(N)
public class CategoryEntity implements Serializable {

    //serileştirme
    public static final Long serialVersionUID=1L;

    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Relotional N(Category)   1(Blog)
    @Column(name = "category_id",unique = true,nullable = false,updatable = false,insertable = true)
    private Long categoryId;

    //CAtegory Name
    @Column(name = "category_nameee")
    private String categoryName;



    //DATE
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;


    //Relation
    @OneToMany(mappedBy = "relationcategoryEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<BlogEntity> relationblogEntityList;

    //Constructor(parametresiz)


    public CategoryEntity() {

    }

    //Constructor(parametreli)


    public CategoryEntity(String categoryName) {
        this.categoryName = categoryName;
    }

    //Constructor(parametreli)

    public CategoryEntity(String categoryName,  List<BlogEntity> relationblogEntityList) {
        this.categoryName = categoryName;

        this.relationblogEntityList = relationblogEntityList;
    }
}//end class
