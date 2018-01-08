package pl.coderslab.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MemoryBookService implements BookService {
	

	private long NEXT_VAR = 3;
	private Map<Long,Book> list;
	
	public MemoryBookService() {
		list = new HashMap<Long,Book>();
		list.put(1L, new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "", ""));
		list.put(2L, new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy", "", ""));
		list.put(3L, new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann", "", ""));
	}
	
	public long getNextId() {
		NEXT_VAR++;
		return NEXT_VAR;
	}
	
	public void addBook(String isbn, String title, String author, String publisher, String type) {
		long id = getNextId();
		if(!StringUtils.isEmpty(isbn) && !StringUtils.isEmpty(author) && !StringUtils.isEmpty(title)) {
			list.put(id, new Book(id, isbn, title, author, publisher, type));
		}
		
	}
	public void updateBook(Book book) {
		if(book != null && book.getId() != 0) {
			if(list.get(book.getId())!=null) {
				list.replace(book.getId(), book);
			}
		}
	}
	public void deleteBook(long id) {
		if(id>0 && list.get(id)!=null) {
			list.remove(id);
		}
		
	}
	public Book getById(long id) {
		if(id>0 && list.size()>=id) {
			return list.get(id);
		}
		return null;
	}
	public Map<Long, Book> getBooks() {
		return list;
	}
	



}