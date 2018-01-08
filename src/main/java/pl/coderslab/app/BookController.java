package pl.coderslab.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	public MemoryBookService memoryBookService;

	@Autowired
	public BookController(MemoryBookService memoryBookService) {
		this.memoryBookService = memoryBookService;
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping("/")
	@ResponseBody
	public Map<Long, Book> getBooks() {
		return memoryBookService.getBooks();
	}

	@RequestMapping("/{id}")
	@ResponseBody
	public Book getBook(@PathVariable("id") long id) {
		return memoryBookService.getById(id);
	}

	@RequestMapping("/remove/{id}")
	@ResponseBody
	public void deleteBook(@RequestParam("id") long id) {
		memoryBookService.deleteBook(id);
	}

	@PostMapping(value = "/add")
	@ResponseBody
	public void addBook(@RequestParam(name = "isbn", required = false) String isbn,
			@RequestParam(name = "title", required = false) String title,
			@RequestParam(name = "author", required = false) String author,
			@RequestParam(name = "publisher", required = false) String publisher,
			@RequestParam(name = "type", required = false) String type) {
		memoryBookService.addBook(isbn, title, author, publisher, type);
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateBook(@RequestBody(required = true) Book book) {
		memoryBookService.updateBook(book);

	}

}
