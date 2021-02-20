package de.leuphana.webshop.repositories;

import de.leuphana.webshop.domain.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface ArticleRepository extends PagingAndSortingRepository<Article, UUID> {
}
