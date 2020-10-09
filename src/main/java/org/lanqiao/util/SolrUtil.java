package org.lanqiao.util;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.lanqiao.entity.Article;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class SolrUtil {
    //指定solr服务器的地址
    private final static String SOLR_URL = "http://39.96.55.109:8983/solr/";

    //    创建SolrServer对象
    public HttpSolrClient createSolrServer() {
        HttpSolrClient solr = null;
        solr = new HttpSolrClient.Builder(SOLR_URL).withConnectionTimeout(10000).withSocketTimeout(60000).build();
        return solr;
    }

    /**
     * 查询某城市的游记
     */
    public List<Article> querySolr(String cityName) throws Exception {
        HttpSolrClient solrServer = new HttpSolrClient.Builder(SOLR_URL + "article/").withConnectionTimeout(10000).withSocketTimeout(60000).build();
        SolrQuery query = new SolrQuery();
        //下面设置solr查询参数
        query.set("q", "article_local:" + cityName);// 参数q  查询所有
        System.out.println("solrUtil---cityName:" + cityName);
        //获取查询结果
        QueryResponse response = solrServer.query(query);
        //两种结果获取：得到文档集合或者实体对象

        //查询得到文档的集合
        SolrDocumentList solrDocumentList = response.getResults();
        //得到实体对象
        List<Article> tmpLists = response.getBeans(Article.class);
        if (tmpLists.size() > 8) {
            List<Article> list = tmpLists.stream().sorted(new Comparator<Article>() {
                @Override
                public int compare(Article o1, Article o2) {
                    return Integer.parseInt(o2.getHot()) - Integer.parseInt(o1.getHot());
                }
            }).limit(8).collect(Collectors.toList());
            return list;
        }
        return tmpLists;
    }


    /**
     * 查询作者的游记
     */
    public List<Article> querySolr2(String user) throws Exception {
        HttpSolrClient solrServer = new HttpSolrClient.Builder(SOLR_URL + "article/").withConnectionTimeout(10000).withSocketTimeout(60000).build();
        SolrQuery query = new SolrQuery();
        //下面设置solr查询参数
        query.set("q", "user_id:" + user);// 参数q  查询所有
        System.out.println("user_id" + user);
        //获取查询结果
        QueryResponse response = solrServer.query(query);
        //两种结果获取：得到文档集合或者实体对象

        //查询得到文档的集合
        SolrDocumentList solrDocumentList = response.getResults();
        //得到实体对象
        List<Article> tmpLists = response.getBeans(Article.class);
        if (tmpLists.size() > 3) {
            List<Article> list = tmpLists.stream().sorted(new Comparator<Article>() {
                @Override
                public int compare(Article o1, Article o2) {
                    return Integer.parseInt(o2.getHot()) - Integer.parseInt(o1.getHot());
                }
            }).limit(3).collect(Collectors.toList());
            return list;
        }
        return tmpLists;
    }



    public static void main(String[] args) throws Exception {
        SolrUtil solr = new SolrUtil();
        solr.querySolr("天津市");
    }
}

