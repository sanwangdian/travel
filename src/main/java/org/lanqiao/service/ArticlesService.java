package org.lanqiao.service;


import org.lanqiao.entity.Article;

import java.util.List;

public interface ArticlesService {

   int insertArticles(Article article);
   List<Article> getAllArticles();

   Article getArticleDetails(int articleId);

   List<Article> selectBestArticles(String isBest);

   int updateHot(int articleId, int hot);




}
