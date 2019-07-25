package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.CollegeEntity;

public interface CollegeRepository extends CrudRepository<CollegeEntity, Long> {

}
