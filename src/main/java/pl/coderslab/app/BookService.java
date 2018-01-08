package pl.coderslab.app;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface BookService {
	
	void addBook(String isbn, String title, String author, String publisher, String type);

	void updateBook(Book book);

	void deleteBook(long id);

	Book getById(long id);

	Map<Long, Book> getBooks();

}