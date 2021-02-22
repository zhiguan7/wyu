package com.wyu;

import com.wyu.entity.Factory;
import com.wyu.entity.Institution;
import com.wyu.entity.User;
import com.wyu.util.RedisUtil;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TestInstitutionBeApplicationTests {

	@Autowired
	private RedisUtil redisUtil;
	@Resource
	private RestHighLevelClient client;

	@Test
	void contextLoads() throws IOException {
		User user = new User();
		user.setUser_id(1);
		user.setUser_email("123");
		user.setUser_name("111");
		user.setUser_password("123");
		user.setUser_address("123");
		user.setUser_faces("123123");
		user.setUser_tel("13213123123");
		user.setUser_gender(User.Gender.MAN);
		user.setUser_role(User.Role.USER);
		user.setUser_state(User.State.ACTIVE);
		IndexRequest request=new IndexRequest("user").source(beanToMap(user));
		IndexResponse response = client.index(request,RequestOptions.DEFAULT);
		System.out.println(JSONObject.toJSON(response));

	}

	public static <T> Map<String,Object> beanToMap(T bean){
		Map<String,Object> map=new HashMap<>();
		if (bean!=null){
			BeanMap beanMap=BeanMap.create(bean);
			for(Object key:beanMap.keySet()){
				if (beanMap.get(key)!=null){
					map.put(key+"",beanMap.get(key));
				}
			}
		}
		return map;
	}

}
