package org.lanqiao.mapper;

import org.lanqiao.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List selectAllArticle();

    List<Article> getAllArticles();

    List<Article> selectBestArticles(String isBest);

    //    hcy
    List selectAllArticle(Article record);

    Article selectByArticleId(Integer articleId);

    int updateHot(Integer articleId, Integer hot);
}