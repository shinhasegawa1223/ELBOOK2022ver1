package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.BookList;
import com.example.demo.Mapper.BookMapper;

@Service
public class BookService {

	@Autowired
	BookMapper bookMapper;

	public List<BookList> findBook() {
		return bookMapper.findBook();
	}

	public List<BookList> targetBook(int book_id) {
		return bookMapper.targetBook(book_id);
	}

	public void createBook(BookList bookList) {
		bookMapper.createBook(bookList);
	}

	public void editBook(BookList bookList) {
		bookMapper.editBook(bookList);
	}

	public void deleteBook(int book_id) {
		bookMapper.deleteBook(book_id);
	}

}