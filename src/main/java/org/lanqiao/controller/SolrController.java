package org.lanqiao.controller;

import lombok.extern.slf4j.Slf4j;
import org.lanqiao.entity.Article;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;

@RestController
@Slf4j
public class SolrController {
    @Resource
    private SolrTemplate solrTemplate;


}
