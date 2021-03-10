package com.wyu.util;

import com.wyu.entity.SearchBuild;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.util.CollectionUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class SearchBuildUtils {

    public static SearchRequest search(SearchBuild searchBuild) {

        int page = searchBuild.getPage();
        int size = searchBuild.getSize();
        String[] indexes = searchBuild.getIndexes();
        String[] includeFields = searchBuild.getIncludeFields();
        String[] excludeFields = searchBuild.getExcludeFields();
        Map<String, Boolean> sortFieldsToAsc = searchBuild.getSortFieldsToAsc();
        Map<String, Object> where = searchBuild.getWhere();

        //请求对象
        SearchRequest searchRequest = new SearchRequest();
        //指定请求对象的索引
        searchRequest.indices(indexes);

        //添加搜索内容的参数
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        //添加条件
        if (where != null && !where.isEmpty()) {
            BoolQueryBuilder boolQueryBuilder1 = QueryBuilders.boolQuery();
            BoolQueryBuilder boolQueryBuilder2 = QueryBuilders.boolQuery();
            where.forEach((k, v) -> {
                if(v instanceof List) {
                    List l = (List) v;
                    Iterator iterator = l.iterator();
                    while (iterator.hasNext())
                        boolQueryBuilder2.should(QueryBuilders.matchQuery(k, iterator.next()));
                }else {
                    boolQueryBuilder1.must(QueryBuilders.matchQuery(k, v));
                }
            });
            boolQueryBuilder1.must(boolQueryBuilder2);
            sourceBuilder.query(boolQueryBuilder1);
        }

        //设置查询的起始索引位置和数量
        page = page <= 0 ? 1 : page;
        size = size <= 0 ? 15 : size;
        size = size >= 1000 ? 1000 : size;
        sourceBuilder.from(size * (page - 1));
        sourceBuilder.size(size);

        //设置排序
        if (sortFieldsToAsc != null && !sortFieldsToAsc.isEmpty()) {
            sortFieldsToAsc.forEach((k, v) -> {
                sourceBuilder.sort(new FieldSortBuilder(k).order(v ? SortOrder.ASC : SortOrder.DESC));
            });
        } else {
            sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
        }

        //设置超时
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //添加排除返回的字段
        if (!CollectionUtils.isEmpty(includeFields) || !CollectionUtils.isEmpty(excludeFields)) {
            sourceBuilder.fetchSource(includeFields, excludeFields);
        }

        //添加至搜索请求
        searchRequest.source(sourceBuilder);

//        System.out.println(searchRequest.source().toString());
        return searchRequest;
    }

}
