package com.iqvia.repository;

import com.iqvia.model.Book;
import org.springframework.stereotype.Repository;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 11/3/2024
 * @Time: 11:55 PM
 */
@Repository
public interface BookRepository extends ApplicationRepository<Book, Long> {
}
