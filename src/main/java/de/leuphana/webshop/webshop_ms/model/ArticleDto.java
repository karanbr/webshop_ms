package de.leuphana.webshop.webshop_ms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto {

    @Null
    private UUID articleId;

    @Null
    private OffsetDateTime createdDate;
    @Null
    private OffsetDateTime lastModified;

    @NotBlank
    private String name;

    @NotBlank
    private String manufacturer;

    @Positive
    @NotNull
    private BigDecimal price;

    private Integer quantityOnHand;

}
