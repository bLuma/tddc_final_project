package com.example.demo.repository;

import com.example.demo.entity.Memo;
import org.springframework.data.repository.CrudRepository;

public interface MemosRepository extends CrudRepository<Memo, Integer> {

}
