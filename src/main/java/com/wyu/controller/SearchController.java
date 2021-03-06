package com.wyu.controller;

import com.wyu.entity.ReturnValue;
import com.wyu.entity.SearchBuild;
import com.wyu.util.GetInfoUtils;
import com.wyu.util.SearchBuildUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Resource
    private RestHighLevelClient client;

    @PostMapping("/user")
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

    @PostMapping("/factory")
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

    @PostMapping("/institution")
    public ReturnValue<SearchHits> searchInstitution(@RequestBody SearchBuild searchBuild)  {
        if(null == searchBuild.getWhere()){
            Map<String,Object> m = new HashMap<>();
            m.put("factory_id",GetInfoUtils.getFactoryId());
            searchBuild.setWhere(m);
        }else{
            searchBuild.getWhere().put("factory_id",GetInfoUtils.getFactoryId());
        }
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

    @PostMapping("/item")
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

    @PostMapping("/demand")
    public ReturnValue<List> searchDemand(@RequestBody SearchBuild searchBuild)  {
        if(null == searchBuild.getWhere()){
            Map<String,Object> m = new HashMap<>();
            m.put("user_id",GetInfoUtils.getUserId());
            searchBuild.setWhere(m);
        }else{
            searchBuild.getWhere().put("user_id",GetInfoUtils.getUserId());
        }
        searchBuild.setIndexes(new String[]{"demand"});
        searchBuild.setExcludeFields(new String[]{"other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
        System.out.println(searchRequest);
        try {
            SearchResponse searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
//            System.out.println("查询结果有"+hits.getTotalHits()+"条");
            Iterator<SearchHit> iterator = hits.iterator();
            List<Object> list = new ArrayList<>();
            while(iterator.hasNext()){
                SearchHit hit = iterator.next();
               list.add(hit.getSourceAsMap());
            }
            list.add(hits.getTotalHits());
            return new ReturnValue<List>(1,"查询成功",list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ReturnValue<List>(-1,"查询失败",null);
    }

    @PostMapping("/orders")
    public ReturnValue<SearchHits> searchOrders(@RequestBody SearchBuild searchBuild)  {
        if(null == searchBuild.getWhere()){
            Map<String,Object> m = new HashMap<>();
            m.put("user",GetInfoUtils.getUserId());
            searchBuild.setWhere(m);
        }else{
            searchBuild.getWhere().put("user",GetInfoUtils.getUserId());
        }
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
