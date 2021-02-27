package com.wyu.controller;

import com.wyu.util.SearchBuildUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Resource
    private RestHighLevelClient client;

    @GetMapping("/test")
    public void test() {

        Map<String,Object> m1 = new HashMap();
        m1.put("user_name", "胡");

        SearchRequest searchRequest = SearchBuildUtils.search(new String[]{"user"},1,10,
                null,null,null,m1);

        try {
            SearchResponse searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
            for(SearchHit hit : searchResponse.getHits().getHits()){
                System.out.println(hit.getSourceAsString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
