package de.leuphana.webshop.webshop_ms.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.leuphana.webshop.webshop_ms.model.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleController.class)
class ArticleDtoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    ArticleDto validArticle;

    // These tests test if Mapping works correctly

//    @Before
//    public void setUp() {
//        validArticle = ArticleDto.builder()
//                .articleId(UUID.randomUUID())
//                .name("Book")
//                .manufacturer("Springer")
//                .price(new BigDecimal("10"))
//                .build();
//    }

    @Test
    void getArticleById() throws Exception {
        mockMvc.perform(get("/api/v1/article/" + UUID.randomUUID().toString())
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

    @Test
    void saveNewArticle() throws Exception {
        ArticleDto articleDto = ArticleDto.builder().build();
        String articleJson = objectMapper.writeValueAsString(articleDto);

        mockMvc.perform(post("/api/v1/article/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(articleJson))
                .andExpect(status().isCreated());

    }

    @Test
    void updateArticleById() throws Exception {
        ArticleDto articleDto = ArticleDto.builder().build();
        String articleJson = objectMapper.writeValueAsString(articleDto);

        mockMvc.perform(put("/api/v1/article/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(articleJson))
                .andExpect(status().isNoContent());
    }
}