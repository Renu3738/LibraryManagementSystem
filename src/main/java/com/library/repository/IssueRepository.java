package com.library.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.BookUser;


@Repository
public interface IssueRepository extends CrudRepository<BookUser, Long> {
	@Query("select b from BookUser b where id=?1")
	BookUser getDataById(long id);

}
