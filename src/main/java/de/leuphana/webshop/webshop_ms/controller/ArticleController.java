package de.leuphana.webshop.webshop_ms.controller;

import de.leuphana.webshop.webshop_ms.model.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/article")
@RestController
public class ArticleController {

    @GetMapping("/{articleId}")
    public ResponseEntity<Article> getArticleById(@PathVariable("articleId") UUID articleId) {
        // todo impl
        return new ResponseEntity<>(Article.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewArticle(@RequestBody Article article) {
        // todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{articleId}")
    public ResponseEntity updateArticleById(@PathVariable("articleId") UUID articleId, @RequestBody Article article){
        // todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
