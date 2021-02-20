package de.leuphana.webshop.bootstrap;

import de.leuphana.webshop.domain.Article;
import de.leuphana.webshop.repositories.ArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ArticleLoader implements CommandLineRunner { // Implements this so it can run on startup

    private final ArticleRepository articleRepository;

    public ArticleLoader(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadArticleObjects();
    }

    private void loadArticleObjects() {
        if (articleRepository.count() == 0){

            articleRepository.save(Article.builder()
                    .articleName("Samsung Galaxy S21")
                    .price(new BigDecimal("1099"))
                    .quantityToOrder(1000)
                    .minOnHand(987)
                    .ean(123456789L)
                    .build());

            articleRepository.save(Article.builder()
                    .articleName("Huawei Mate 20 Pro")
                    .price(new BigDecimal("899"))
                    .quantityToOrder(600)
                    .minOnHand(450)
                    .ean(223456789L)
                    .build());
        }

        System.out.println("Loaded Articles: " + articleRepository.count());
    }
}
