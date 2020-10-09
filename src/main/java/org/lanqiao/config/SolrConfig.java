package org.lanqiao.config;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;

import javax.annotation.Resource;

@Configuration
public class SolrConfig {
    @Resource
    private SolrClient solrClient;

    @Bean
    public SolrTemplate getSolrTemplate(){
        return new SolrTemplate(solrClient);
    }
}
