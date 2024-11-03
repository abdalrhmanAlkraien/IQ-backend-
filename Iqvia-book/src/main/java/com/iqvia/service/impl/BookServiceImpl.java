package com.iqvia.service.impl;

import com.iqvia.dto.request.BookRequest;
import com.iqvia.dto.response.BookResponse;
import com.iqvia.mapper.BookMapper;
import com.iqvia.repository.BookRepository;
import com.iqvia.service.BookService;
import com.iqvia.util.WebUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 11/3/2024
 * @Time: 11:56 PM
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final RestTemplate restTemplate;

    private static final String AUTHOR_URL = "http://localhost:8085/api/v1/author";

    @Override
    public Page<BookResponse> getAllBooks(Map<String, String> filters) {

        return bookRepository.findAll(WebUtil.buildPageable(filters))
                .map(bookMapper::toResponse);
    }

    @Override
    @Transactional
    public void createNewBook(BookRequest bookRequest) {

        bookRepository.save(bookMapper.toEntity(bookRequest));
        // TODO call restTemplate to update book.

        ResponseEntity responseEntity =
                restTemplate.exchange(AUTHOR_URL + "/".concat(bookRequest.getAuthorId().toString()),
                        HttpMethod.PUT,
                        HttpEntity.EMPTY,
                        String.class);

        if (!responseEntity.getStatusCode().is2xxSuccessful()) {

            throw new RuntimeException("wrong request");
        }
    }
}
