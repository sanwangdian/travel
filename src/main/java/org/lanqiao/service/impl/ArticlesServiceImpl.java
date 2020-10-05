package org.lanqiao.service.impl;

import org.lanqiao.entity.Article;
import org.lanqiao.mapper.ArticleMapper;
import org.lanqiao.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticlesServiceImpl implements ArticlesService {

    @Resource
    ArticleMapper articleMapper;


    @Override
    public int insertArticles(Article article) {

        return articleMapper.insert(article);
    }

    @Override
    public List<Article> getAllArticles(){
        return articleMapper.getAllArticles();
    }

    @Override
    public Article getArticleDetails(int articleId) {
        return articleMapper.selectByArticleId(articleId);
    }

    @Override
    public List<Article> selectBestArticles(String isBest) {
        return articleMapper.selectBestArticles(isBest);
    }

    @Override
    public int updateHot(int articleId, int hot) {
        hot = hot+1;
        return articleMapper.updateHot(articleId,hot);
    }
}
