package com.iqvia.controller;

import com.iqvia.constant.EndPoints;
import com.iqvia.dto.request.BookRequest;
import com.iqvia.dto.response.BookResponse;
import com.iqvia.service.BookService;
import com.iqvia.util.GenericResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 11/3/2024
 * @Time: 11:57 PM
 */
@RestController
@RequestMapping(EndPoints.BOOK_PATH)
@RequiredArgsConstructor
@Log4j2
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<GenericResponse<Page<BookResponse>>> getAllAuthor(
            @RequestParam final Map<String, String> filters
    ) {

        log.info("call get all book API");
        return ResponseEntity.ok(GenericResponse.success(bookService.getAllBooks(filters)));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<String>> createNewAuthor(
            @RequestBody @Valid final BookRequest bookRequest
    ) throws URISyntaxException {

        log.info("call create new book API");
        bookService.createNewBook(bookRequest);
        return ResponseEntity
                .created(new URI(EndPoints.BOOK_PATH))
                .body(GenericResponse.success("Book has been created"));
    }
}
