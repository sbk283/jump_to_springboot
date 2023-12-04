package com.article1.article.article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Page<Article> findAll(Pageable pageable);
    Page<Article> findAll(Specification<Article> spec, Pageable pageable);

    @Query("select distinct q " +
            "from Article q " +
            "left outer join SiteUser u1 on q.author = u1 " +
            "where " +
            "   q.subject like %:kw% " +
            "   or q.content like %:kw% " +
            "   or u1.username like %:kw% ")
    Page<Article> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
}
