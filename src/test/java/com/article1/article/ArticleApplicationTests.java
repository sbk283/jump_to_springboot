package com.article1.article;

import com.article1.article.article.Article;
import com.article1.article.article.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleApplicationTests {

	@Autowired
	private ArticleService articleService;

	@Test
	void testJpa() {
		for (int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			this.articleService.create(subject, content,null);
		}
	}

}
