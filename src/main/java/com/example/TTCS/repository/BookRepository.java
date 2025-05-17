package com.example.TTCS.repository;

import com.example.TTCS.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public interface BookRepository extends JpaRepository<Book, Long> {
//    List findByStatus(BookStatus status);
//    List findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String title, String author);
}
