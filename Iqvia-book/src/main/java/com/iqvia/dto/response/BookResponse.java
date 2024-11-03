package com.iqvia.dto.response;

import com.iqvia.model.enumeration.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 11/3/2024
 * @Time: 11:58 PM
 */
@Data
@AllArgsConstructor
public class BookResponse {

    private Long id;
    private String bookName;
    private Category bookCategory;
    private Long authorId;
}
