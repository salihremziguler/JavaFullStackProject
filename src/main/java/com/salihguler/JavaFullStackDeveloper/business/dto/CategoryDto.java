package com.salihguler.JavaFullStackDeveloper.business.dto;

import com.salihguler.JavaFullStackDeveloper.audit.AuditingAwareBaseDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder

//CategoryDto(1)-BlogDto(N)
public class CategoryDto extends AuditingAwareBaseDto implements Serializable {

    public static final Long serialVersionUID=1L;


    @NotEmpty(message = "{blog.category.validation.constraints.NotNull.message}")
    @Size(min = 10,message = "{blog.category.least.validation.constraints.NotNull.message}")
    private String categoryName;


}
