package com.salihguler.JavaFullStackDeveloper.data.repository;

import com.salihguler.JavaFullStackDeveloper.data.entity.BlogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//CRUD Repository
//Jpa Repository
//                                                 BlogEntity Id variable Long

@Repository
public interface IBlogRepository extends CrudRepository<BlogEntity,Long> {


}
