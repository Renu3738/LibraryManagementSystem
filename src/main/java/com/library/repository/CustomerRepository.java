package com.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	@Query("select b from Customer b where id=?1")
	Customer getDataById(long id);

}
