package com.gcit.lms.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookCopiesDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.dao.BorrowerDAO;
import com.gcit.lms.dao.BranchDAO;
import com.gcit.lms.dao.GenreDAO;
import com.gcit.lms.dao.PublisherDAO;
import com.gcit.lms.dao.BookLoansDAO;
import com.gcit.lms.entity.Author;
import com.gcit.lms.entity.Book;
import com.gcit.lms.entity.BookCopies;
import com.gcit.lms.entity.Borrower;
import com.gcit.lms.entity.Branch;
import com.gcit.lms.entity.Genre;
import com.gcit.lms.entity.Publisher;
import com.gcit.lms.entity.BookLoans;

public class AdministratorService {

	@Autowired
	AuthorDAO aDAO;
	
	@Autowired
	BookDAO bDAO;
	
	@Autowired
	BookLoansDAO blDAO;
	
	@Autowired
	BorrowerDAO borDAO;
	
	@Autowired
	BranchDAO brDAO;
	
	@Autowired
	GenreDAO gDAO;
	
	@Autowired
	PublisherDAO pDAO;
	
	@Autowired
	BookCopiesDAO bcDAO;
	
	
	// ADD AUTHOR
	@Transactional
	public void createAuthor(Author author) throws ClassNotFoundException,SQLException {
		aDAO.addAuthor(author);
		
	}
	
	// UPDATE AUTHOR
	@Transactional
	public void updateAuthor(Author author) throws ClassNotFoundException,SQLException {
		aDAO.updateAuthor(author);
	}
	
	// DELETE AUTHOR
	@Transactional
	public void deleteAuthor(Integer authorId) throws ClassNotFoundException,SQLException {
		aDAO.deleteAuthor(authorId);
	}

	
	
	
	// ADD BOOK
	@Transactional
	public void createBook(Book book) throws ClassNotFoundException,SQLException {
		bDAO.addBook(book);
	}
	
	
	// UPDATE BOOK
	@Transactional
	public void updateBook(Book book) throws ClassNotFoundException,SQLException {
		bDAO.updateBook(book);
	}
	
	// DELETE BOOK
	public void deleteBook(Book bookId) throws ClassNotFoundException, SQLException {
		bDAO.deleteBook(bookId);
	}
	
	
	
	
	
	// ADD BRANCH
	@Transactional
	public void createBranch(Branch branch) throws ClassNotFoundException,SQLException {
		brDAO.addBranch(branch);
	}
	
	// UPDATE BRANCH
	@Transactional
	public void updateBranch(Branch branch) throws ClassNotFoundException,SQLException {
		brDAO.updateBranch(branch);
	}
	
	// DELETE BRANCH
	@Transactional
	public void deleteBranch(Branch branchId) throws ClassNotFoundException, SQLException {
		brDAO.deleteBranch(branchId);
	}
	
	
	

	
	// ADD BORROWER
	@Transactional
	public void createBorrower(Borrower borrower) throws ClassNotFoundException, SQLException{
		borDAO.addBorrower(borrower);
	}

	// UPDATE BORROWER
	@Transactional
	public void updateBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
		borDAO.updateBorrower(borrower);
	}

	// DELETE BORROWER
	public void deleteBorrower(Borrower cardNo) throws ClassNotFoundException, SQLException {
		borDAO.deleteBorrower(cardNo);
	}

		

	
	// ADD PUBLISHER
	@Transactional
	public void createPublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		pDAO.addPublisher(publisher);
	}

	// UPDATE PUBLISHER
	@Transactional
	public void updatePublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		pDAO.updatePublisher(publisher);
	}

	// DELETE PUBLISHER
	public void deletePublisher(Publisher publisherId) throws ClassNotFoundException, SQLException {
		pDAO.deletePublisher(publisherId);
	}
	
	
/*	// ADD BOOK_AUTHOR
	public void createBookAuthor(Book book) throws ClassNotFoundException,
			SQLException {

		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try {

			BookDAO adao = new BookDAO(conn);
			book.setBookId(adao.addBookWithID(book));
			for (Author a : book.getAuthors()) {
				adao.addBookAuthor(book, a);
			}
			for (Genre ge : book.getGenres()) {
				adao.addBookGenre(book, ge);
			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}*/

	


	
	/*// EDIT BOOKCOPIES
	public void editBookCopies(BookCopies bc) throws ClassNotFoundException,SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try {
			BookCopiesDAO adao = new BookCopiesDAO(conn);
			adao.updateBookCopies(bc);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
		return;
	}*/

	
	
	



	// LIST ALL AUTHORS
	public List<Author> getAllAuthors(int pageNo)throws ClassNotFoundException, SQLException {
		
			List<Author> authors = aDAO.readAllAuthors(pageNo);
			/*for(Author a : authors){
				bDAO.
			}*/
		return null;
	}

	// LIST ALL AUTHORS BY NAME
	public List<Author> getAllAuthorsByName(String searchString, Integer pageNo)
			throws ClassNotFoundException, SQLException {
	
			List<Author> authors = aDAO.readAuthorsByName(searchString, pageNo);
		
		return null;
	}

	// LIST ALL BOOKS BY NAME
	public List<Book> getAllBooksByName(String searchString, Integer pageNo)
			throws ClassNotFoundException, SQLException {
		
			List<Book> books = bDAO.readBooksByName(searchString, pageNo);
		
		return null;
	}

	// LIST ALL AUTHORS BY AUTHOR NAME
	public List<Author> getAllAuthorsByAuthorName(String searchString,Integer pageNo) throws ClassNotFoundException, SQLException {
	
		List<Author> authors =  aDAO.readAuthorsByAuthorName(searchString, pageNo);
		
		return null;
	}

	// LIST ALL AUTHORS BY AUTHOR NAME
	public List<Author> getAllAuthorsByTitle(String searchString, Integer pageNo) throws ClassNotFoundException, SQLException {
		
		List<Author> authors = aDAO.readAuthorsByBookTitle(searchString, pageNo);
		
		return null;
	}

	// LIST ALL AUTHORS BY AUTHOR NAME
	public List<Author> getAllAuthorsByAuthorOrTitle(String searchString,Integer pageNo) throws ClassNotFoundException, SQLException {
		
		List<Author> authors = aDAO.readAuthorsByBookTitleorName(searchString, pageNo);
		
		return null;
	}

	// LIST ALL BOOKS BY AUTHOR NAME
	public List<Book> getAllBooksByAuthor(String searchString, Integer pageNo) throws ClassNotFoundException, SQLException {
	
		List<Book> books = bDAO.readBooksByAuthor(searchString, pageNo);
		
		return null;
	}

	// LIST ALL BOOKS BY AUTHOR NAME
	public List<Book> getAllBooksByAuthorOrTitle(String searchString,Integer pageNo) throws ClassNotFoundException, SQLException {
		
		List<Book> books = bDAO.readBooksByAuthorOrTitle(searchString, pageNo);
		
		return null;
	}

	// LIST ALL BRANCHES BY NAME
	public List<Branch> getAllBranchByName(String searchString, Integer pageNo) throws ClassNotFoundException, SQLException {
		
		List<Branch> branch = brDAO.readBranchByName(searchString, pageNo);
		
		return null;
	}
	
	//LIST ALL BORROWERS BY NAME
	public List<Borrower> getAllBorrowersByName(String searchString, Integer pageNo) throws ClassNotFoundException, SQLException {
		
		List<Borrower> borrower = borDAO.readBorrowerByName(searchString, pageNo);

		return null;
	}

	//LIST ALL PUBLISHERS BY NAME
	public List<Publisher> getAllPublishersByName(String searchString,Integer pageNo) throws ClassNotFoundException, SQLException {
	
		List<Publisher> publisher = pDAO.readPublishersByName(searchString, pageNo);
		
		return null;
	}

	// GET BOOK COPIES NUMBER FROM PARTICULAR BRANCH
	public List<BookCopies> getBookCopiesByBranchID(Integer branchId) throws ClassNotFoundException, SQLException {
		
		List<BookCopies> bcopies = bcDAO.readBookCopiesByBranchID(branchId);
		
		return null;
	}

	// GET BOOKS FROM PARTICULAR BRANCH
	public List<Book> getBooksWithBranch(Integer branchId) throws ClassNotFoundException, SQLException {
		
		List<Book> books = bDAO.readBookByBranchID(branchId);
		
		return null;
	}

/*	// READ BORROWER BOOKS
	public List<Book> getAllBorrowersByID(Integer cardNo) throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		System.out.println("In the getAllBorrowerByID method");
		try {
			BookLoansDAO bldao = new BookLoansDAO(conn);
			return bldao.readBookBycardNo(cardNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return null;
	}*/

	// GET PUBLISHERS
	public List<Publisher> getAllPublishers(int pageNo) throws ClassNotFoundException, SQLException {
	
		List<Publisher> publisher = pDAO.readAllPublishers(pageNo);
		
		return null;

	}

	// GET BORROWERS
	public List<Borrower> getAllBorrowers(int pageNo) throws ClassNotFoundException, SQLException {
		
		List<Borrower> borrower = borDAO.readAllBorrowers(pageNo);
		
		return null;

	}

	// GET ALL BRANCHES
	public List<Branch> getAllBranches(int pageNo) throws ClassNotFoundException, SQLException {
		
		List<Branch> branch = brDAO.readAllBranches(pageNo);
		
		return null;
	}

	// GET ALL BOOKS
	public List<Book> getAllBooks(int pageNo) throws ClassNotFoundException, SQLException {
		
		List<Book> books = bDAO.readAllBooks(pageNo);
		
		return null;
	}

	/*// GET AUTHOR COUNT
	public Integer getAuthorCount() throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			return adao.getCount();
		} catch (Exception e) {
			e.printStackTrace();
			// conn.rollback();
		} finally {
			conn.close();
		}
		return null;
	}*/

	/*// GET BOOK COUNT
	public Integer getBookCount() throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try {
			BookDAO bdao = new BookDAO(conn);
			return bdao.getCount();
		} catch (Exception e) {
			e.printStackTrace();
			// conn.rollback();
		} finally {
			conn.close();
		}
		return null;
	}*/

	/*// GET BORROWER COUNT
	public Integer getBorrowerCount() throws ClassNotFoundException,
			SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try {
			BorrowerDAO borrdao = new BorrowerDAO(conn);
			return borrdao.getCount();
		} catch (Exception e) {
			e.printStackTrace();
			// conn.rollback();
		} finally {
			conn.close();
		}
		return null;
	}*/

	/*// GET BRANCH COUNT
	public Integer getBranchCount() throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try {
			BranchDAO brdao = new BranchDAO(conn);
			return brdao.getCount();
		} catch (Exception e) {
			e.printStackTrace();
			// conn.rollback();
		} finally {
			conn.close();
		}
		return null;
	}*/

	/*// GET PUBLISHER COUNT
	public Integer getPublisherCount() throws ClassNotFoundException,
			SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try {
			PublisherDAO pdao = new PublisherDAO(conn);
			return pdao.getCount();
		} catch (Exception e) {
			e.printStackTrace();
			// conn.rollback();
		} finally {
			conn.close();
		}
		return null;
	}*/

	

	// GET ALL GENRES
	public List<Genre> getAllGenres() throws ClassNotFoundException,SQLException {
		
		List<Genre> genres = gDAO.readAllGenre();
		
		return null;
	}

	/*// GET AUTHOR BY ID
	public Author getAuthorByID(Integer authorId)
			throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try {
			AuthorDAO adao = new AuthorDAO(conn);
			return aDAO.readAuthorsByID(authorId);
		} catch (Exception e) {
			e.printStackTrace();
			// conn.rollback();
		} finally {
			conn.close();
		}
		return null;
	}
*/
	/*// GET BOOK BY ID
	public Book getBookByID(Integer bookId) throws ClassNotFoundException,
			SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try {
			BookDAO adao = new BookDAO(conn);
			return adao.readBookByID(bookId);
		} catch (Exception e) {
			e.printStackTrace();
			// conn.rollback();
		} finally {
			conn.close();
		}
		return null;
	}*/

	/*// GET BORROWER BY ID
	public Borrower getBorrowerByID(Integer cardNo)
			throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try {
			BorrowerDAO borrdao = new BorrowerDAO(conn);
			return borrdao.readBorrowerByID(cardNo);
		} catch (Exception e) {
			e.printStackTrace();
			// conn.rollback();
		} finally {
			conn.close();
		}
		return null;
	}*/

	/*// GET PUBLISHER BY ID
	public Publisher getPublisherByID(Integer publisherId)
			throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try {
			PublisherDAO pdao = new PublisherDAO(conn);
			return pdao.readPublisherByID(publisherId);
		} catch (Exception e) {
			e.printStackTrace();
			// conn.rollback();
		} finally {
			conn.close();
		}
		return null;
	}*/

//	// GET BRANCH BY ID
//	public Branch getBranchByID(Integer branchId)
//			throws ClassNotFoundException, SQLException {
//		ConnectionUtil c = new ConnectionUtil();
//		Connection conn = c.getConnection();
//		try {
//			BranchDAO pdao = new BranchDAO(conn);
//			return pdao.readBranchByID(branchId);
//		} catch (Exception e) {
//			e.printStackTrace();
//			// conn.rollback();
//		} finally {
//			conn.close();
//		}
//		return null;
//	}
	
	
	
	
	
	

	// VERIFY CARD DETAILS
	public boolean verifyCard(int cardN) throws ClassNotFoundException, SQLException {
		
		boolean present = false;
		
		if (borDAO.readBorrowerByID(cardN) != null){
			present = true;
		}
		
		return present;
	}

/*	// BOOK CHECKIN
	public boolean bookCheckIn(Integer bookId, Integer cardNo)
			throws ClassNotFoundException, SQLException {
		ConnectionUtil c = new ConnectionUtil();
		Connection conn = c.getConnection();
		try {
			System.out.println("inside service book checkin");
			BookLoansDAO brdao = new BookLoansDAO(conn);
			System.out.println(bookId);
			System.out.println(cardNo);
			blDAO.checkIn(bookId, cardNo);

			conn.commit();
		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
		return false;
	}*/

	// BOOK CHECK OUT
	public void bookCheckOut(int bookId, int cardNo, int branchId) throws ClassNotFoundException, SQLException {
			System.out.println(bookId);
			System.out.println(cardNo);
			blDAO.checkOut(bookId, cardNo, branchId);

	}

	

}
