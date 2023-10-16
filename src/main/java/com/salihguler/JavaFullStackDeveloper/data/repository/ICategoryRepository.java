package com.salihguler.JavaFullStackDeveloper.data.repository;

import com.salihguler.JavaFullStackDeveloper.data.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends CrudRepository<CategoryEntity,Long> {





}
