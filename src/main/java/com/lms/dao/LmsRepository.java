package com.lms.dao;

import com.lms.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsRepository extends CrudRepository<Book,Long>{
}
