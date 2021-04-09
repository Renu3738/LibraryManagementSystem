package com.library.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.BookDetail;
import com.library.entity.User;

@Repository
public interface BookRepository extends CrudRepository<BookDetail, Long> {
	@Query("select b from BookDetail b where id=?1")
	BookDetail getDataById(long id);

	@Query("select b from BookDetail b where b.bookname like %?1% and b.availability=?2")
	List<BookDetail> getBootDetailByName(String bookName, boolean available, Pageable pageable);
	
	@Query("select b from BookDetail b where b.isbn=?1")
	BookDetail getDataByIsbn(String isbn);
}
