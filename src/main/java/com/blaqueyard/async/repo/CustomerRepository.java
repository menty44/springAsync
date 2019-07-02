package com.blaqueyard.async.repo;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import com.blaqueyard.async.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Async
    Future<List<Customer>> findByLastName(String lastName);

    @Async
    CompletableFuture<Customer> findOneById(Long id);

    @Async
    @Query("select c from Customer c")
    CompletableFuture<List<Customer>> findAllCustomers();

}