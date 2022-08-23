package com.xxx.test;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    RestHighLevelClient client = ESClient.getClient();
    String index = "person";
    String type = "man";
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void test01() throws IOException {
        //创建索引并制定settings和mappings结构,搞结构
        CreateIndexRequest request = new CreateIndexRequest(index);

        //settings.
        Settings.Builder settings = Settings.builder().put("number_of_shards", 5).put("number_of_replicas", 1);//.var
        request.settings(settings);

        //json.
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

        request.mapping(type, mappings);

        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);//重点代码,alt enter,缺啥补啥
        System.out.println(response.toString());
    }

    @Test
    public void test02() throws IOException {
        GetIndexRequest request = new GetIndexRequest();
        request.indices(index);

        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    @Test
    public void test03() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(index);

        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
        System.out.println(response.isAcknowledged());
    }

    @Test
    public void test04() throws IOException {
        Person person = new Person(1, "fbb", 18, new Date());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);

        IndexRequest request = new IndexRequest(index, type, person.getId().toString());
        request.source(json, XContentType.JSON);

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @Test
    public void test05() throws IOException {
        UpdateRequest request = new UpdateRequest(index, type, "1");

        Map map = new HashMap();
        map.put("name", "gd");
        request.doc(map);

        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.out.println(request);
    }

    @Test
    public void test06() throws IOException {
        DeleteRequest request = new DeleteRequest(index, type, "1");

        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    @Test
    public void test07() throws IOException {

        Person p = new Person(1, "fbb", 18, new Date());
        Person p2 = new Person(2, "lbb", 24, new Date());
        Person p3 = new Person(3, "bb", 30, new Date());

        objectMapper.writeValueAsString(p);
        objectMapper.writeValueAsString(p2);
        objectMapper.writeValueAsString(p3);

        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest(index, type, p.getId().toString()));
        request.add(new IndexRequest(index, type, p2.getId().toString()));
        request.add(new IndexRequest(index, type, p3.getId().toString()));

        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(request);
    }
}
