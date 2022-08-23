package com.xxx.utils;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author Mr.Li
 * @version 1.0
 * @ClassName ESClient
 * @Description
 * @Date 2022-08-23 13:46
 */
public class ESClient {
    public static RestHighLevelClient getClient() {
        return new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.226.100", 9200)));
    }
}
