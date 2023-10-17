package com.salihguler.JavaFullStackDeveloper.controller.api.impl;

import com.salihguler.JavaFullStackDeveloper.assist.FrontendUrl;
import com.salihguler.JavaFullStackDeveloper.business.dto.CategoryDto;
import com.salihguler.JavaFullStackDeveloper.business.dto.service.ICategoryServices;
import com.salihguler.JavaFullStackDeveloper.controller.api.ICategoryApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Lombok
@RequiredArgsConstructor
@Log4j2
//API
@RestController //api olabilmesi için
@CrossOrigin(origins = FrontendUrl.REACT_URL)  //http://localhost3000
@RequestMapping("/category/api/v1")
public class CategoryApiImpl implements ICategoryApi<CategoryDto> {

    //Injection
    private final ICategoryServices iCategoryServices;
    //Create
    @Override
    @PostMapping(value = "/create") //http://localhost/category/api/v1/create
    public ResponseEntity<?> categoryApiCreate(@Valid @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(iCategoryServices.categoryServiceCreate(categoryDto));
    }

    //List
    @Override
    @GetMapping(value = "/list")  //http://localhost/category/api/v1/list
    public ResponseEntity<List<?>> categoryApiList() {
        return ResponseEntity.ok(iCategoryServices.categoryServiceList());
    }

    //Find By Id
    @Override
    @GetMapping(value = "/find/{id}")  ////http://localhost/category/api/v1/find/1
    public ResponseEntity<?> categoryApiFindById(@PathVariable(name="id") Long id) {
        return ResponseEntity.ok(iCategoryServices.categoryServiceFindById(id));
    }

    //Update
    @Override
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> categoryApiUpdate(@PathVariable(name = "id") Long id,@Valid @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.status(HttpStatus.OK).body(iCategoryServices.categoryServiceUpdate(id,categoryDto));
    }

    //Delete by id
    @Override
    @DeleteMapping (value = "/delete/{id}")

    public ResponseEntity<?> categoryApiDelete(@PathVariable(name = "id") Long id,@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.status(200).body(iCategoryServices.categoryServiceDelete(id,categoryDto));
    }
//////////////////////////////////////////
    //ALl Delete
    @Override

    public ResponseEntity<String> categoryApiAllDelete() {
        return null;
    }

    //Speed Data
    @Override
    public ResponseEntity<List<CategoryDto>> categoryApiSpeedData(Long key) {
        return null;
    }
}
