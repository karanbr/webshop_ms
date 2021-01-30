package de.leuphana.webshop.webshop_ms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

    private UUID articleId;
    private String manufacturer;
    private String name;
    private BigDecimal price;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModified;
    private Integer quantityOnHand;

}
