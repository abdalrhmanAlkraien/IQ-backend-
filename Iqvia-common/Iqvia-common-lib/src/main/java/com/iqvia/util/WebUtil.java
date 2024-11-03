package com.iqvia.util;

import com.iqvia.constant.GeneralConst;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * @author: Abd-alrhman Alkraien.
 * @Date: 11/3/2024
 * @Time: 11:27 PM
 */
@UtilityClass
@FieldDefaults(level = AccessLevel.PUBLIC)
public class WebUtil {

     public Pageable buildPageable(Map<String, String> filter) {

        if(filter != null
                        && filter.containsKey(GeneralConst.PAGEABLE_SIZE)
                        && filter.containsKey(GeneralConst.PAGEABLE_PAGE)) {

            return PageRequest
                    .of(
                            Integer.parseInt(filter.get(GeneralConst.PAGEABLE_PAGE)),
                            Integer.parseInt(filter.get(GeneralConst.PAGEABLE_SIZE))
                    );
        }
        return PageRequest.of(0,10);
    }
}
