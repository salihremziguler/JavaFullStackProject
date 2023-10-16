package com.salihguler.JavaFullStackDeveloper.business.dto.service.impl;

import com.salihguler.JavaFullStackDeveloper.bean.ModelMapperBean;
import com.salihguler.JavaFullStackDeveloper.business.dto.CategoryDto;
import com.salihguler.JavaFullStackDeveloper.business.dto.service.ICategoryServices;
import com.salihguler.JavaFullStackDeveloper.data.entity.BlogEntity;
import com.salihguler.JavaFullStackDeveloper.data.entity.CategoryEntity;
import com.salihguler.JavaFullStackDeveloper.data.repository.ICategoryRepository;
import com.salihguler.JavaFullStackDeveloper.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//LOMBOK

//SERVICES
@Service
@RequiredArgsConstructor
@Log4j2
public class CategoryServicesImpl implements ICategoryServices<CategoryDto, CategoryEntity> {

  /*  //Injection(Field) ==>1.yol
    @Autowired
    private ICategoryRepository iCategoryRepository;
*/
   /* //2.Yol ==>Constructor
    private final ICategoryRepository iCategoryRepository;
    @Autowired
    public CategoryServicesImpl(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }
*/

    //Injection(Field) ==>3.yol
    private final ICategoryRepository iCategoryRepository;

    private final ModelMapperBean modelMapperBean;

    //Model Mapper
    @Override
    public CategoryDto entityToDTo(CategoryEntity categoryEntity) {
        return modelMapperBean.modelMapperMethod().map(categoryEntity,CategoryDto.class);
    }


    @Override
    public CategoryEntity dtoToEntity(CategoryDto categoryDto) {
        return modelMapperBean.modelMapperMethod().map(categoryDto,CategoryEntity.class);
    }
    //Create
    @Override
    @Transactional  //create,update,delete
    public CategoryDto categoryServiceCreate(CategoryDto categoryDto) {

        if (categoryDto != null) {
            CategoryEntity categoryEntity=dtoToEntity(categoryDto);
            iCategoryRepository.save(categoryEntity);
            categoryDto.setId(categoryEntity.getCategoryId());
            categoryDto.setSystemDate(categoryEntity.getSystemDate());
        }
        else
        {
            throw new NullPointerException("categoryDto null veri");
        }

        return categoryDto;
    }
    //List
    @Override
    public List<CategoryDto> categoryServiceList() {
       Iterable<CategoryEntity> entityIterable= iCategoryRepository.findAll();
       //Dto To entity List
        List<CategoryDto> categoryDtoList=new ArrayList<>();
        for (CategoryEntity entity:entityIterable) {
            CategoryDto categoryDto=entityToDTo(entity);
            categoryDtoList.add(categoryDto);


        }
        log.info("Liste sayısı:"+categoryDtoList.size());


        return categoryDtoList;
    }

    //Find By ID
    @Override
    public CategoryDto categoryServiceFindById(Long id) {
        /*//1.YOL (FIND)
        Optional<CategoryEntity> findOptionalCategoryEntity=iCategoryRepository.findById(id);
        CategoryDto categoryDto=entityToDTo(findOptionalCategoryEntity.get());//get yapısı optional için
       //içeride bir veri var ise
        if(findOptionalCategoryEntity.isPresent())
        {
            return categoryDto;
        }*/

        //2.YOL  veri bulursan ekle bulamazsan exception fırlat
       CategoryEntity findOptionalCategoryEntity=null;

       if(id!=null)
       {

           findOptionalCategoryEntity=  iCategoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id+"nolu veri yoktur"));

       }
       else if(id==null)
       {
            new Exception("id null olarak gedi");
       }


        return entityToDTo(findOptionalCategoryEntity);
    }

    //Update
    @Override
    @Transactional
    public CategoryDto categoryServiceUpdate(Long id, CategoryDto categoryDto) {
      CategoryDto categoryFindDto=  categoryServiceFindById(id);
    if(categoryFindDto!=null)
    {
        CategoryEntity categoryEntity=dtoToEntity(categoryFindDto);
        categoryEntity.setCategoryName(categoryFindDto.getCategoryName());
        iCategoryRepository.save(categoryEntity);
            //dönüşte ID ve DAte Set et

    }


        return categoryFindDto;
    }

    //Delete
    @Override
    @Transactional
    public CategoryDto categoryServiceDelete(Long id, CategoryDto categoryDto) {
        CategoryDto categoryFindDto=  categoryServiceFindById(id);
        if(categoryFindDto!=null)
        {
            iCategoryRepository.deleteById(id);
            //dönüşte ID ve DAte Set et

        }
        return null;
    }
}//end class
