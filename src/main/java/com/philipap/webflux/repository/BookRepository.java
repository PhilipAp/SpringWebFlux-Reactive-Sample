package com.philipap.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.philipap.webflux.model.Book;

public interface BookRepository extends ReactiveMongoRepository<Book, String>{

}
