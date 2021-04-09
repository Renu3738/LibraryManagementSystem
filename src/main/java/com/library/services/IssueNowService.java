package com.library.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.BookDetail;
import com.library.entity.BookUser;
import com.library.entity.Customer;
import com.library.repository.BookRepository;
import com.library.repository.BookUserRepository;
import com.library.repository.CustomerRepository;

@Service
public class IssueNowService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookUserRepository bookUserRepository;

	public void issueBook(long cid, long bid, String fromDate, String toDate) {

		Customer c = customerRepository.getDataById(cid);
		BookDetail bd = bookRepository.getDataById(bid);

		Date fDate = new Date();
		Date tDate = new Date();

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fDate = format.parse(fromDate);
			tDate = format.parse(toDate);
		} catch (Exception e) {

		}

		BookUser bu = new BookUser();

		bu.setBookDetail(bd);
		bu.setIssuedTo(c);
		bu.setFromDate(fDate);
		bu.setToDate(tDate);

		bookUserRepository.save(bu);

		bd.setAvailability(false);

		bookRepository.save(bd);

	}

	public void bookReturn(long bid, String returnDate) {

		BookUser bu = bookUserRepository.findByDataId(bid);

		bu.setReturned(true);

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = format.parse(returnDate);
			bu.setReturnDate(d);
		} catch (Exception e) {
		}

		bookUserRepository.save(bu);

		BookDetail bd = bu.getBookDetail();

		bd.setAvailability(true);

		bookRepository.save(bd);

	}

}
