package de.leuphana.webshop.webshop_ms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.leuphana.webshop.webshop_ms.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    // These tests test if Mapping works correctly

    @Test
    void getArticleById() throws Exception {
        mockMvc.perform(get("/api/v1/article/" + UUID.randomUUID().toString())
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

    @Test
    void saveNewArticle() throws Exception {
        Article article = Article.builder().build();
        String articleJson = objectMapper.writeValueAsString(article);

        mockMvc.perform(post("/api/v1/article/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(articleJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateArticleById() throws Exception {
        Article article = Article.builder().build();
        String articleJson = objectMapper.writeValueAsString(article);

        mockMvc.perform(put("/api/v1/article/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(articleJson))
                .andExpect(status().isNoContent());
    }
}