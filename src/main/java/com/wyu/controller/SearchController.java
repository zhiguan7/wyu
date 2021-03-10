package com.wyu.controller;

import com.wyu.dao.Orders_ItemDao;
import com.wyu.entity.Orders;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Resource
    private RestHighLevelClient client;
    @Autowired
    private Orders_ItemDao oid;

    @PostMapping("/user")
    public ReturnValue<List> searchUser(@RequestBody SearchBuild searchBuild){
        if(!GetInfoUtils.getUser()) return new ReturnValue<List>(-1,"查询失败，未知用户",null);
        if(null == searchBuild.getWhere()){
            Map<String,Object> m = new HashMap<>();
            m.put("user_id",GetInfoUtils.getUserId());
            searchBuild.setWhere(m);
        }else{
            searchBuild.getWhere().put("user_id",GetInfoUtils.getUserId());
        }
        searchBuild.setIndexes(new String[]{"user"});
        searchBuild.setExcludeFields(new String[]{"user_password","other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
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
            return new ReturnValue<List>(-1, "查询失败", null);
        }
    }

    @PostMapping("/factory")
    public ReturnValue<List> searchFactory(@RequestBody SearchBuild searchBuild) {
        if(GetInfoUtils.getFactoryId()==-1) return new ReturnValue<List>(-1,"查询失败，未知用户",null);
        if(null == searchBuild.getWhere()){
            Map<String,Object> m = new HashMap<>();
            m.put("factory_id",GetInfoUtils.getFactoryId());
            searchBuild.setWhere(m);
        }else{
            searchBuild.getWhere().put("factory_id",GetInfoUtils.getFactoryId());
        }

        searchBuild.setIndexes(new String[]{"factory"});
        searchBuild.setExcludeFields(new String[]{"other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
        try {
            SearchResponse searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
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
            return new ReturnValue<List>(-1,"查询失败",null);
        }
    }

    @PostMapping("/institution")
    public ReturnValue<List> searchInstitution(@RequestBody SearchBuild searchBuild)  {
        if(GetInfoUtils.getInsId()==-1) return new ReturnValue<List>(-1,"查询失败，未知用户",null);
        if(null == searchBuild.getWhere()){
            Map<String,Object> m = new HashMap<>();
            m.put("institution_id",GetInfoUtils.getInsId());
            searchBuild.setWhere(m);
        }else{
            searchBuild.getWhere().put("institution_id",GetInfoUtils.getInsId());
        }
        searchBuild.setIndexes(new String[]{"institution"});
        searchBuild.setExcludeFields(new String[]{"other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
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
            return new ReturnValue<List>(-1,"查询失败",null);
        }

    }

    @PostMapping("/institutionAll")
    public ReturnValue<List> searchAllInstitution(@RequestBody SearchBuild searchBuild)  {
        searchBuild.setIndexes(new String[]{"institution"});
        searchBuild.setExcludeFields(new String[]{"other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
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
            return new ReturnValue<List>(-1,"查询失败",null);
        }
    }

    @PostMapping("/item")
    public ReturnValue<List> searchItem(@RequestBody SearchBuild searchBuild)  {

        if(null!=searchBuild.getWhere().get("orders_id")) {
            SearchBuild s = new SearchBuild();
            Map m = new HashMap<String, Object>();
            m.put("orders_id",searchBuild.getWhere().get("orders_id"));
            s.setWhere(m);
            s.setIndexes(new String[]{"orders_item"});
            searchBuild.getWhere().put("item_id",search(s));
            searchBuild.getWhere().remove("orders_id");
        }

        if(null!=searchBuild.getWhere().get("institution_id")) {
            SearchBuild s = new SearchBuild();
            Map m = new HashMap<String, Object>();
            m.put("institution_id",searchBuild.getWhere().get("institution_id"));
            s.setWhere(m);
            s.setIndexes(new String[]{"ins_item"});
            searchBuild.getWhere().put("item_id",search(s));
            searchBuild.getWhere().remove("institution_id");
        }

        searchBuild.setIndexes(new String[]{"item"});
        searchBuild.setExcludeFields(new String[]{"other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
        try {
            SearchResponse searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
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
            return new ReturnValue<List>(-1,"查询失败",null);
        }
    }

    @PostMapping("/demand")
    public ReturnValue<List> searchDemand(@RequestBody SearchBuild searchBuild)  {
        if(!GetInfoUtils.getUser()) return new ReturnValue<List>(-1,"查询失败，未知用户",null);
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
            return new ReturnValue<List>(-1,"查询失败",null);
        }
    }

    @PostMapping("/demandAll")
    public ReturnValue<List> searchAllDemand(@RequestBody SearchBuild searchBuild)  {

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
            return new ReturnValue<List>(-1,"查询失败",null);
        }
    }

    @PostMapping("/userOrders")
    public ReturnValue<List> searchUserOrders(@RequestBody SearchBuild searchBuild)  {
        if(!GetInfoUtils.getUser()) return new ReturnValue<List>(-1,"查询失败，未知用户",null);
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
            return new ReturnValue<List>(-1,"查询失败",null);
        }
    }

    @PostMapping("/insOrders")
    public ReturnValue<List> searchInsOrders(@RequestBody SearchBuild searchBuild)  {
        if(GetInfoUtils.getInsId()==-1) return new ReturnValue<List>(-1,"查询失败，未知用户",null);
        if(null == searchBuild.getWhere()){
            Map<String,Object> m = new HashMap<>();
            m.put("institution",GetInfoUtils.getInsId());
            searchBuild.setWhere(m);
        }else{
            searchBuild.getWhere().put("institution",GetInfoUtils.getInsId());
        }
        searchBuild.setIndexes(new String[]{"orders"});
        searchBuild.setExcludeFields(new String[]{"other"});
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
        try {
            SearchResponse searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
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
            return new ReturnValue<List>(-1,"查询失败",null);
        }
    }

    public List search(SearchBuild searchBuild)  {
        SearchRequest searchRequest = SearchBuildUtils.search(searchBuild);
        try {
            SearchResponse searchResponse =client.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
            Iterator<SearchHit> iterator = hits.iterator();
            List<Object> list = new ArrayList<>();
            while(iterator.hasNext()){
                SearchHit hit = iterator.next();
                list.add(hit.getSourceAsMap().get("item_id"));
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
