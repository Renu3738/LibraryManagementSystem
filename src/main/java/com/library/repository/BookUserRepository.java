package com.library.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.BookDetail;
import com.library.entity.BookUser;

@Repository
public interface BookUserRepository extends CrudRepository<BookUser, Long> {

	@Query("select bu from BookUser bu order by id desc")
	List<BookUser> orderByDesc();

	@Query("select bu from BookUser bu where bu.id=?1")
	BookUser findByDataId(long id);
}
