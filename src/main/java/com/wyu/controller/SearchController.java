package com.wyu.controller;

import com.wyu.entity.ReturnValue;
import com.wyu.entity.SearchBuild;
import com.wyu.util.SearchBuildUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Resource
    private RestHighLevelClient client;

    @GetMapping("/user")
    public ReturnValue<SearchHits> searchUser(@RequestBody SearchBuild searchBuild){

        searchBuild.setIndexes(new String[]{"user"});
        searchBuild.setExcludeFields(new String[]{"user_password","other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
        try {
            SearchResponse searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
//            System.out.println("查询结果有"+hits.getTotalHits()+"条");
//            Iterator<SearchHit> iterator = hits.iterator();
//            while(iterator.hasNext()){
//                SearchHit hit = iterator.next();
//                System.out.println(hit);
//            }
            return new ReturnValue<SearchHits>(1,"查询成功",hits);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ReturnValue<SearchHits>(-1,"查询失败",null);
    }

    @GetMapping("/factory")
    public ReturnValue<SearchHits> searchFactory(@RequestBody SearchBuild searchBuild) {

        searchBuild.setIndexes(new String[]{"factory"});
        searchBuild.setExcludeFields(new String[]{"other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
        try {
            SearchResponse searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
//            System.out.println("查询结果有"+hits.getTotalHits()+"条");
//            Iterator<SearchHit> iterator = hits.iterator();
//            while(iterator.hasNext()){
//                SearchHit hit = iterator.next();
//                System.out.println(hit);
//            }
            return new ReturnValue<SearchHits>(1,"查询成功",hits);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ReturnValue<SearchHits>(-1,"查询失败",null);
    }

    @GetMapping("/institution")
    public ReturnValue<SearchHits> searchInstitution(@RequestBody SearchBuild searchBuild)  {

        searchBuild.setIndexes(new String[]{"institution"});
        searchBuild.setExcludeFields(new String[]{"other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
        try {
            SearchResponse searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
//            System.out.println("查询结果有"+hits.getTotalHits()+"条");
//            Iterator<SearchHit> iterator = hits.iterator();
//            while(iterator.hasNext()){
//                SearchHit hit = iterator.next();
//                System.out.println(hit);
//            }
            return new ReturnValue<SearchHits>(1,"查询成功",hits);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ReturnValue<SearchHits>(-1,"查询失败",null);
    }

    @GetMapping("/item")
    public ReturnValue<SearchHits> searchItem(@RequestBody SearchBuild searchBuild)  {

        searchBuild.setIndexes(new String[]{"item"});
        searchBuild.setExcludeFields(new String[]{"other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
        try {
            SearchResponse searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
//            System.out.println("查询结果有"+hits.getTotalHits()+"条");
//            Iterator<SearchHit> iterator = hits.iterator();
//            while(iterator.hasNext()){
//                SearchHit hit = iterator.next();
//                System.out.println(hit);
//            }
            return new ReturnValue<SearchHits>(1,"查询成功",hits);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ReturnValue<SearchHits>(-1,"查询失败",null);
    }

    @GetMapping("/demand")
    public ReturnValue<SearchHits> searchDemand(@RequestBody SearchBuild searchBuild)  {

        searchBuild.setIndexes(new String[]{"demand"});
        searchBuild.setExcludeFields(new String[]{"other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
        try {
            SearchResponse searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
//            System.out.println("查询结果有"+hits.getTotalHits()+"条");
//            Iterator<SearchHit> iterator = hits.iterator();
//            while(iterator.hasNext()){
//                SearchHit hit = iterator.next();
//                System.out.println(hit);
//            }
            return new ReturnValue<SearchHits>(1,"查询成功",hits);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ReturnValue<SearchHits>(-1,"查询失败",null);
    }

    @GetMapping("/orders")
    public ReturnValue<SearchHits> searchOrders(@RequestBody SearchBuild searchBuild)  {

        searchBuild.setIndexes(new String[]{"orders"});
        searchBuild.setExcludeFields(new String[]{"other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
        try {
            SearchResponse searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
//            System.out.println("查询结果有"+hits.getTotalHits()+"条");
//            Iterator<SearchHit> iterator = hits.iterator();
//            while(iterator.hasNext()){
//                SearchHit hit = iterator.next();
//                System.out.println(hit);
//            }
            return new ReturnValue<SearchHits>(1,"查询成功",hits);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ReturnValue<SearchHits>(-1,"查询失败",null);
    }

}
