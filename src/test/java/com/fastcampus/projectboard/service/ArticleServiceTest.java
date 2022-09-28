package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.type.SearchType;
import com.fastcampus.projectboard.dto.ArticleDto;
import com.fastcampus.projectboard.dto.ArticleUpdateDto;
import com.fastcampus.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut; //system under test;
    @Mock private ArticleRepository articleRepository;

/*

    홈 버튼 -> 게시판 페이지로 리다이렉션
            정렬기능
    */

    @DisplayName("게시글을 검색하면 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticlePageList(){

        // Given
        //SearchParameters parma = SearchParameters.of(SearchType.TILE, "search keyword");
        // When
        List<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); //제목, 본문, ID, 닉네임, 해시태그
        // Then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticles_thenReturnsArticle(){

        // Given
        Pageable pageable = Pageable.ofSize(20);
        given(a)

        // When
        ArticleDto articles = sut.searchArticle(1L); //제목, 본문, ID, 닉네임, 해시태그
        // Then
        assertThat(articles).isNotNull();
    }


    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {

        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);

    // When
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(), "sunu", "title","content", "#java"));
        // Then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 ID와 수정 정보를 입력하면, 게시글을 수정한다.")
    @Test
    void givenArticleIDAndModifiedInfo_whenUpdatingArticle_thenUpdatesArticle() {

        // Given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // When
        sut.updateArticle(1L, ArticleUpdateDto.of("title","content", "#java"));
        // Then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글 ID를 입력하면, 게시글을 삭제한다.")
    @Test
    void givenArticleID_whenDeletingArticle_thenDeletingsArticle() {

        // Given
        willDoNothing().given(articleRepository).delete(any(Article.class));

        // When
        sut.deleteArticle(1L);
        // Then
        then(articleRepository).should().delete(any(Article.class));
    }



}