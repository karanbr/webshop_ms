package de.leuphana.webshop.webshop_ms.controller;

import de.leuphana.webshop.webshop_ms.model.ArticleDto;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/article")
@RestController
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ArticleController {

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable("articleId") UUID articleId) {
        // todo impl
        return new ResponseEntity<>(ArticleDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewArticle(@RequestBody @Validated ArticleDto articleDto) {
        // todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{articleId}")
    public ResponseEntity updateArticleById(@PathVariable("articleId") UUID articleId, @RequestBody @Validated ArticleDto articleDto){
        // todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
