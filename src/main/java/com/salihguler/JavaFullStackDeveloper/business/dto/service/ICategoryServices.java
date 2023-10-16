package com.salihguler.JavaFullStackDeveloper.business.dto.service;

import java.util.List;

//D=DTO
//E=Entity
public interface ICategoryServices<D,E> {

    //Model mapper
    //DTO--->Entity
    //Entitit-->DTO   veri güvenliği

    public D entityToDTo(E e);
    public E dtoToEntity(D d);

    //C R U D
    //Create
    public D categoryServiceCreate(D d);

    //List
    public List<D> categoryServiceList();

    //Find By ID
    public D categoryServiceFindById(Long id);
    //Create
    public D categoryServiceUpdate(Long id,D d);
    //Create
    public D categoryServiceDelete(Long id,D d);







}
