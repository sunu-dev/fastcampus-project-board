package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.dto.ArticleCommentDto;
import com.fastcampus.projectboard.repository.ArticleCommentRepository;
import com.fastcampus.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;


@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {
    @InjectMocks private ArticleCommentService sut;
    @Mock
    private ArticleRepository articleRepository;
    private ArticleCommentRepository articleCommentRepository;

    @DisplayName("게시글 ID로 조회하면, 해당하는 댓글 리스트를 반환한다. ")
    @Test
    void givenArticleId_whenSearchingCommnts_thenReturnsArticleComments(){
        // Given
        Long articleId = 1L;
        Article.of("title", "content","#java").getArticleComment();
        given(articleRepository.findById(articleId)).willReturn(Optional.of(
                Article.of("title", "content","#java")
        ));
        // When
        List<ArticleCommentDto> articleComments = sut.searchArticleComment(articleId);
        // Then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

    @DisplayName("정보를 입력하면, 댓글을 저장한다. ")
    @Test
    void givenArticleId_whenSearchingCommnts2_thenReturnsArticleComments(){
        // Given
        Long articleId = 1L;
        Article.of("title", "content","#java").getArticleComment();
        given(articleRepository.findById(articleId)).willReturn(Optional.of(
                Article.of("title", "content","#java")
        ));
        // When
        List<ArticleCommentDto> articleComments = sut.searchArticleComment(articleId);
        // Then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }
}