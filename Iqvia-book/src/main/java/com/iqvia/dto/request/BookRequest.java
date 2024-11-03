package com.iqvia.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iqvia.model.enumeration.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 11/3/2024
 * @Time: 11:58 PM
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookRequest {

    @JsonProperty("name")
    @NotBlank
    private String bookName;

    @JsonProperty("category")
    @NotNull
    private Category bookCategory;
    @NotNull
    private Long authorId;
}
