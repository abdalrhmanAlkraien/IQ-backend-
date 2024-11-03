package com.iqvia.service;

import com.iqvia.dto.request.BookRequest;
import com.iqvia.dto.response.BookResponse;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 11/3/2024
 * @Time: 11:55 PM
 */
public interface BookService {

    Page<BookResponse> getAllBooks(final Map<String, String> filters);

    void createNewBook(final BookRequest bookRequest);
}
