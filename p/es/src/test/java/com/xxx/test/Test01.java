package com.xxx.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xxx.bean.Person;
import com.xxx.utils.ESClient;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName Test01
 * @Description
 * @Date 2022-08-23 13:48
 */
public class Test01 {
    //创建客户端
    private RestHighLevelClient client = ESClient.getClient();
    private String index = "person";//索引
    private String type = "man";//类型

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test01() throws IOException {
        //创建索引并制定settings和mappings结构,搞结构
        CreateIndexRequest request = new CreateIndexRequest();
        //setting
        Settings.Builder settings = Settings.builder().put("number_of_shards", 5).put("number_of_replicas", 1);
        request.settings(settings);

        //json
        XContentBuilder mappings = JsonXContent.contentBuilder()
                .startObject()
                .startObject("properties")
                .startObject("name")
                .field("type", "text")
                .field("analyzer", "ik_max_word")
                .endObject()
                .startObject("age")
                .field("type", "integer")
                .endObject()
                .startObject("birthday")
                .field("type", "date")
                .field("format", "yyyy-MM-dd")
                .endObject()
                .endObject()
                .endObject();
        //mapping
        request.mapping(type, mappings);

        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @Test
    public void test02() throws IOException {
        GetIndexRequest request = new GetIndexRequest();
        request.indices(index);//提交请求,绑定索引

        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    @Test
    public void test03() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(index);//删除对应索引

        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @Test
    public void test04() throws IOException {
        Person person = new Person(1, "fbb", 18, new Date());
        //将对象变为json样式字符串
//        String json = new ObjectMapper().writeValueAsString(person);
        String json = objectMapper.writeValueAsString(person);

        IndexRequest request = new IndexRequest(index, type, json);
        //提交json请求
        request.source(json, XContentType.JSON);

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @Test
    public void test05() throws IOException {
        UpdateRequest request = new UpdateRequest(index, type, "1");
        //map集合存储修改的属性
        Map map = new HashMap();
        map.put("name", "gd");
        request.doc(map);

        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @Test
    public void test06() throws IOException {
        DeleteRequest request = new DeleteRequest(index, type, "1");

        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    //批量操作↓

    @Test
    public void test07() throws IOException {
        Person p = new Person(1, "fbb", 18, new Date());
        Person p2 = new Person(2, "lbb", 24, new Date());
        Person p3 = new Person(3, "bb", 30, new Date());

        String json = objectMapper.writeValueAsString(p);
        String json2 = objectMapper.writeValueAsString(p2);
        String json3 = objectMapper.writeValueAsString(p3);

        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest(index, type, p.getId().toString()).source(json, XContentType.JSON));
        request.add(new IndexRequest(index, type, p2.getId().toString()).source(json2, XContentType.JSON));
        request.add(new IndexRequest(index, type, p3.getId().toString()).source(json3, XContentType.JSON));

        //bulk:批量
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @Test
    public void test08() throws IOException {
        Map map = new HashMap();
        map.put("name", "xxx");

        Map map2 = new HashMap();
        map2.put("name", "xxx2");

        Map map3 = new HashMap();
        map3.put("name", "xxx3");

        BulkRequest request = new BulkRequest();
        request.add(new UpdateRequest(index, type, "1").doc(map));
        request.add(new UpdateRequest(index, type, "2").doc(map2));
        request.add(new UpdateRequest(index, type, "3").doc(map3));

        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @Test
    public void test09() throws IOException {
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest(index, type, "1"));
        request.add(new DeleteRequest(index, type, "2"));
        request.add(new DeleteRequest(index, type, "3"));

        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }
}