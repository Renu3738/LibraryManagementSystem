package com.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	@Query("select o from User o  where o.username=?1")
	User findByUserName(String userName);
}
