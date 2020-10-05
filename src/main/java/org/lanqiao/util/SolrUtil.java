package org.lanqiao.util;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.lanqiao.entity.Article;

import java.util.List;



public class SolrUtil {
    //指定solr服务器的地址
    private final static  String SOLR_URL= "http://localhost:8983/solr/";

    //    创建SolrServer对象
    public HttpSolrClient createSolrServer(){
        HttpSolrClient solr = null;
        solr = new HttpSolrClient.Builder(SOLR_URL).withConnectionTimeout(10000).withSocketTimeout(60000).build();
        return solr;
    }

    /**
     * 查询某城市的游记
     */
    public List<Article> querySolr(String cityName) throws Exception{
        HttpSolrClient solrServer = new HttpSolrClient.Builder(SOLR_URL + "articles/").withConnectionTimeout(10000).withSocketTimeout(60000).build();
        SolrQuery query = new SolrQuery();
        //下面设置solr查询参数
        query.set("q", "article_local:"+cityName);// 参数q  查询所有

        //获取查询结果
        QueryResponse response = solrServer.query(query);
        //两种结果获取：得到文档集合或者实体对象

        //查询得到文档的集合
        SolrDocumentList solrDocumentList = response.getResults();
        System.out.println("通过文档集合获取查询的结果");
        System.out.println("查询结果的总数量：" + solrDocumentList.getNumFound());
        //遍历列表
        for (SolrDocument doc : solrDocumentList) {
//            System.out.println("id:"+doc.get("id"));
            System.out.println("Article_id:"+doc.get("Article_id")+"\t"
                    +"user_id:"+doc.get("user_id")+"\t"
                    +"id_best:"+doc.get("id_best")+"\t"
                    +"hot:"+doc.get("hot")+"\t"
                    +"article_time:"+doc.get("article_time")+"\t"
                    +"article_address:"+doc.get("article_address")+"\t"
                    +"article_local:"+doc.get("article_local")+"\t"
                    +"article_img:"+doc.get("article_img")+"\t"
                    +"article_face:"+doc.get("article_face")+"\t"
                    +"article_content:"+doc.get("article_content")+"\t");
        }
        //得到实体对象
        List<Article> tmpLists = response.getBeans(Article.class);
        if(tmpLists!=null && tmpLists.size()>0){
            System.out.println("通过文档集合获取查询的结果");
            for(Article per:tmpLists){
                System.out.println("Article_id:"+per.getArticleId()+"\t"
                        +"user_id:"+per.getUserId()+"\t"
                        +"id_best:"+per.getIdBest()+"\t"
                        +"hot:"+per.getHot()+"\t"
                        +"article_time:"+per.getArticleTime()+"\t"
                        +"article_address:"+per.getArticleAddress()+"\t"
                        +"article_local:"+per.getArticleLocal()+"\t"
                        +"article_img:"+per.getArticleImg()+"\t"
                        +"article_face:"+per.getArticleFace()+"\t"
                        +"article_content:"+per.getArticleContent()+"\t");
            }
        }
        return tmpLists;
    }

    public static void main(String[] args) throws Exception {
        SolrUtil solr = new SolrUtil();
        solr.querySolr("北京市");
    }
}

