package com.gcit.lms;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Publisher;
import com.gcit.lms.service.AdministratorService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	AdministratorService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	
	@RequestMapping(value = "/addAuthor", method = RequestMethod.GET)
	public String addAuthor(Locale locale, Model model, @PathVariable String authorName) throws ClassNotFoundException, SQLException {
		Author author = new Author();
		author.setAuthorName(authorName);
		service.createAuthor(author);
		return "viewauthors";
	}
	
	@RequestMapping(value = "/updateAuthor", method = RequestMethod.GET)
	public String updateAuthor(Locale locale, Model model, @PathVariable("authorName") String authorName,@PathVariable("authorId") Integer authorId) throws ClassNotFoundException, SQLException {
		Author author = new Author();
		author.setAuthorName(authorName);
		author.setAuthorId(authorId);
		service.updateAuthor(author);
		return "viewauthors";
	}
	
	@RequestMapping(value = "/deleteAuthor", method = RequestMethod.GET)
	public String deleteAuthor(Locale locale, Model model, @PathVariable Integer authorId) throws ClassNotFoundException, SQLException {
		Author author = new Author();
		author.setAuthorId(authorId);
		service.deleteAuthor(authorId);
		return "viewauthors";
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String addBook(Locale locale, Model model, @PathVariable String title) throws ClassNotFoundException, SQLException {
		Book book = new Book();
		book.setTitle(title);
		service.createBook(book);
		return "viewbook";
	}
	
	@RequestMapping(value = "/updateBook", method = RequestMethod.GET)
	public String updateBook(Locale locale, Model model, @PathVariable("title") String title,@PathVariable("bookId") Integer bookId) throws ClassNotFoundException, SQLException {
		Book book = new Book();
		book.setTitle(title);
		book.setBookId(bookId);
		service.updateBook(book);
		return "viewbook";
	}
	
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public String deleteBook(Locale locale, Model model, @PathVariable Integer bookId) throws ClassNotFoundException, SQLException {
		Book book = new Book();
		book.setBookId(bookId);
		service.deleteBook(book);
		return "viewbook";
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/addBranch", method = RequestMethod.GET)
	public String addBranch(Locale locale, Model model, @PathVariable String branchName) throws ClassNotFoundException, SQLException {
		Branch branch = new Branch();
		branch.setBranchName(branchName);
		service.createBranch(branch);
		return "viewbranch";
	}
	
	
	@RequestMapping(value = "/updateBranch", method = RequestMethod.GET)
	public String updateBranch(Locale locale, Model model, @PathVariable("branchName") String branchName,@PathVariable("branchAddress") String branchAddress,@PathVariable("branchId") Integer branchId) throws ClassNotFoundException, SQLException {
		Branch branch = new Branch();
		branch.setBranchName(branchName);
		branch.setBranchAddress(branchAddress);
		branch.setBranchId(branchId);
		service.updateBranch(branch);
		return "viewbranch";
	}
	
	@RequestMapping(value = "/deleteBranch", method = RequestMethod.GET)
	public String deleteBranch(Locale locale, Model model, @PathVariable Integer branchId) throws ClassNotFoundException, SQLException {
		Branch branch = new Branch();
		branch.setBranchId(branchId);
		service.deleteBranch(branch);
		return "viewbranch";
	}
	
	
	
	
	
	@RequestMapping(value = "/addBorrower", method = RequestMethod.GET)
	public String addBorrower(Locale locale, Model model, @PathVariable String name) throws ClassNotFoundException, SQLException {
		Borrower borrower = new Borrower();
		borrower.setName(name);
		service.createBorrower(borrower);
		return "viewborrower";
	}
	
	@RequestMapping(value = "/updateBorrower", method = RequestMethod.GET)
	public String updateBorrower(Locale locale, Model model, @PathVariable("name") String name,@PathVariable("address") String address,@PathVariable("phone") String phone,@PathVariable("cardNo") Integer cardNo) throws ClassNotFoundException, SQLException {
		Borrower borrower = new Borrower();
		borrower.setName(name);
		borrower.setAddress(address);
		borrower.setPhone(phone);
		borrower.setCardNo(cardNo);
		service.updateBorrower(borrower);
		return "viewborrower";
	}
	
	@RequestMapping(value = "/deleteBorrower", method = RequestMethod.GET)
	public String deleteBorrower(Locale locale, Model model, @PathVariable Integer cardNo) throws ClassNotFoundException, SQLException {
		Borrower borrower = new Borrower();
		borrower.setCardNo(cardNo);
		service.deleteBorrower(borrower);
		return "viewborrower";
	}
	
	
	
	
	
	@RequestMapping(value = "/addPublisher", method = RequestMethod.GET)
	public String addPublisher(Locale locale, Model model, @PathVariable String publisherName) throws ClassNotFoundException, SQLException {
		Publisher publisher = new Publisher();
		publisher.setPublisherName(publisherName);
		service.createPublisher(publisher);
		return "viewpublisher";
	}
	
	
	@RequestMapping(value = "/updatePublisher", method = RequestMethod.GET)
	public String updatePublisher(Locale locale, Model model, @PathVariable("publisherName") String publisherName,@PathVariable("PublisherAddress") String publisherAddress,@PathVariable("publisherPhone") String publisherPhone,@PathVariable("publisherId") Integer publisherId) throws ClassNotFoundException, SQLException {
		Publisher publisher = new Publisher();
		publisher.setPublisherName(publisherName);
		publisher.setPublisherAddress(publisherAddress);
		publisher.setPublisherPhone(publisherPhone);
		publisher.setPublisherId(publisherId);
		service.updatePublisher(publisher);
		return "viewpublisher";
	}
	
	@RequestMapping(value = "/deletePublisher", method = RequestMethod.GET)
	public String deletePublisher(Locale locale, Model model, @PathVariable Integer publisherId) throws ClassNotFoundException, SQLException {
		Publisher publisher = new Publisher();
		publisher.setPublisherId(publisherId);
		service.deletePublisher(publisher);
		return "viewpublisher";
	}
	
}
