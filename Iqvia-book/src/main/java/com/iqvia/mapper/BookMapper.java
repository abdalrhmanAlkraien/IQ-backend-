package com.iqvia.mapper;

import com.iqvia.dto.request.BookRequest;
import com.iqvia.dto.response.BookResponse;
import com.iqvia.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 11/3/2024
 * @Time: 11:55 PM
 */
@Mapper(componentModel = "spring")
public abstract class BookMapper {

    @Mapping(source = "bookName", target = "name")
    @Mapping(source = "bookCategory", target = "category")
    public abstract Book toEntity(final BookRequest bookRequest);

    @Mapping(target = "bookName", source = "name")
    @Mapping(target = "bookCategory", source = "category")
    public abstract BookResponse toResponse(final Book book);
}
