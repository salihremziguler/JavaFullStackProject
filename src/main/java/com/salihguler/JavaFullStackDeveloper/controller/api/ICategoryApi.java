package com.salihguler.JavaFullStackDeveloper.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryApi<D> {


    //C R U D
    //Create
    public ResponseEntity<?>  categoryApiCreate(D d);

    //List
    public ResponseEntity<List<?>> categoryApiList();

    //Find By ID
    public ResponseEntity<?> categoryApiFindById(Long id);
    //Create
    public ResponseEntity<?> categoryApiUpdate(Long id,D d);
    //Create
    public ResponseEntity<?> categoryApiDelete(Long id,D d);

    ////////////////////////////////

    //ALL DATA
    public ResponseEntity<String> categoryApiAllDelete();

    //SPEED DATA
    public ResponseEntity<List<D>> categoryApiSpeedData(Long key);







}
