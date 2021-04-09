package com.library.validation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.entity.BookDetail;
import com.library.entity.BookUser;
import com.library.entity.Customer;
import com.library.entity.GeneralError;
import com.library.repository.BookRepository;
import com.library.repository.BookUserRepository;
import com.library.repository.CustomerRepository;

@Component
public class IssueValidation {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookUserRepository bookUserRepository;

	public GeneralError validateIssue(long cid, long bid, String fromDate, String toDate) {
		GeneralError ge = new GeneralError();

		ge.setValid(true);

		Customer c = customerRepository.getDataById(cid);

		if (c == null) {
			ge.setValid(false);
			ge.setMessage("Validation Fail. Customer Not Found");
		}

		BookDetail bd = bookRepository.getDataById(bid);

		if (bd == null) {
			ge.setValid(false);
			ge.setMessage("Validation Fail. Book Not Found");
		} else if (!bd.isAvailability()) {
			ge.setValid(false);
			ge.setMessage("Validation Fail. Book Already Issued");
		}

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fd = format.parse(fromDate);
			Date td = format.parse(toDate);

			if (td.before(fd)) {
				ge.setValid(false);
				ge.setMessage("Validation Fail. From Date must be greater than to date");
			}

		/*	long fromTime = fd.getTime();

			long toTime = td.getTime();

			if (fromTime > toTime) {
				ge.setValid(false);
				ge.setMessage("Validation Fail. From Date must be greater than to date");
			}*/
			
		} catch (Exception e) {
			ge.setValid(false);
			ge.setMessage("Date Not Valid");
		}

		return ge;
	}

	public GeneralError validationReturn(long bid, String returnDate) {
		GeneralError ge = new GeneralError();

		ge.setValid(true);

		BookUser bu = bookUserRepository.findByDataId(bid);

		if (bu == null) {
			ge.setValid(false);
			ge.setMessage("Book Issue Not FOund");
		} else {
			BookDetail b = bu.getBookDetail();

			if (b.isAvailability()) {
				ge.setValid(false);
				ge.setMessage("Book Already Return");
			}

		}

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			format.parse(returnDate);
		} catch (Exception e) {
			ge.setValid(false);
			ge.setMessage("Date Not Valid");
		}

		return ge;
	}

}
