package com.iqvia.model;

import com.iqvia.model.enumeration.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 11/3/2024
 * @Time: 11:52 PM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_book")
public class Book extends AbstractEntity {

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "author_id")
    private Long authorId;
}
