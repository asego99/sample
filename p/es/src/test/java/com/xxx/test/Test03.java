package com.xxx.test;

import com.alibaba.fastjson.JSON;
import com.xxx.bean.SmsLogs;
import com.xxx.utils.ESClient;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.range.Range;
import org.elasticsearch.search.aggregations.metrics.cardinality.Cardinality;
import org.elasticsearch.search.aggregations.metrics.stats.extended.ExtendedStats;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class Test03 {
    private RestHighLevelClient client = ESClient.getClient();
    private String index = "sms-logs-index";
    private String type = "sms-logs-type";

    @Test
    public void createSmsLogsIndex() throws IOException {
        //1. settings
        Settings.Builder settings = Settings.builder()
                .put("number_of_shards", 3)
                .put("number_of_replicas", 1);

        //2. mapping.
        XContentBuilder mapping = JsonXContent.contentBuilder()
                .startObject()
                .startObject("properties")
                .startObject("createDate")
                .field("type", "date")
                .endObject()
                .startObject("sendDate")
                .field("type", "date")
                .endObject()
                .startObject("longCode")
                .field("type", "keyword")
                .endObject()
                .startObject("mobile")
                .field("type", "keyword")
                .endObject()
                .startObject("corpName")
                .field("type", "keyword")
                .endObject()
                .startObject("smsContent")
                .field("type", "text")
                .field("analyzer", "ik_max_word")
                .endObject()
                .startObject("state")
                .field("type", "integer")
                .endObject()
                .startObject("operatorId")
                .field("type", "integer")
                .endObject()
                .startObject("province")
                .field("type", "keyword")
                .endObject()
                .startObject("ipAddr")
                .field("type", "ip")
                .endObject()
                .startObject("replyTotal")
                .field("type", "integer")
                .endObject()
                .startObject("fee")
                .field("type", "long")
                .endObject()
                .endObject()
                .endObject();

        //3. 添加索引.
        CreateIndexRequest request = new CreateIndexRequest(index);
        request.settings(settings);
        request.mapping(type, mapping);
        client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println("OK!!");
    }

    @Test
    public void addTestData() throws IOException {
        BulkRequest request = new BulkRequest();

        SmsLogs smsLogs = new SmsLogs();
        smsLogs.setMobile("13800000000");
        smsLogs.setCorpName("途虎养车");
        smsLogs.setCreateDate(new Date());
        smsLogs.setSendDate(new Date());
        smsLogs.setIpAddr("10.126.2.9");
        smsLogs.setLongCode("10690000988");
        smsLogs.setReplyTotal(10);
        smsLogs.setState(0);
        smsLogs.setSmsContent("【途虎养车】亲爱的张三先生/女士，您在途虎购买的货品(单号TH123456)已 到指定安装店多日，" + "现需与您确认订单的安装情况，请点击链接按实际情况选择（此链接有效期为72H）。您也可以登录途 虎APP进入" + "“我的-待安装订单”进行预约安装。若您在服务过程中有任何疑问，请致电400-111-8868向途虎咨 询。");
        smsLogs.setProvince("北京");
        smsLogs.setOperatorId(1);
        smsLogs.setFee(3);
        request.add(new IndexRequest(index, type, "21").source(JSON.toJSONString(smsLogs), XContentType.JSON));

        smsLogs.setMobile("13700000001");
        smsLogs.setProvince("上海");
        smsLogs.setSmsContent("【途虎养车】亲爱的刘红先生/女士，您在途虎购买的货品(单号TH1234526)已 到指定安装店多日，" + "现需与您确认订单的安装情况，请点击链接按实际情况选择（此链接有效期为72H）。您也可以登录途 虎APP进入" + "“我的-待安装订单”进行预约安装。若您在服务过程中有任何疑问，请致电400-111-8868向途虎咨 询。");
        request.add(new IndexRequest(index, type, "22").source(JSON.toJSONString(smsLogs), XContentType.JSON));

        // -------------------------------------------------------------------------------------------------------------------

        SmsLogs smsLogs1 = new SmsLogs();
        smsLogs1.setMobile("13100000000");
        smsLogs1.setCorpName("盒马鲜生");
        smsLogs1.setCreateDate(new Date());
        smsLogs1.setSendDate(new Date());
        smsLogs1.setIpAddr("10.126.2.9");
        smsLogs1.setLongCode("10660000988");
        smsLogs1.setReplyTotal(15);
        smsLogs1.setState(0);
        smsLogs1.setSmsContent("【盒马】您尾号12345678的订单已开始配送，请在您指定的时间收货不要走开 哦~配送员：" + "刘三，电话：13800000000");
        smsLogs1.setProvince("北京");
        smsLogs1.setOperatorId(2);
        smsLogs1.setFee(5);
        request.add(new IndexRequest(index, type, "23").source(JSON.toJSONString(smsLogs1), XContentType.JSON));

        smsLogs1.setMobile("18600000001");
        smsLogs1.setProvince("上海");
        smsLogs1.setSmsContent("【盒马】您尾号7775678的订单已开始配送，请在您指定的时间收货不要走开 哦~配送员：" + "王五，电话：13800000001");
        request.add(new IndexRequest(index, type, "24").source(JSON.toJSONString(smsLogs1), XContentType.JSON));

        // -------------------------------------------------------------------------------------------------------------------

        SmsLogs smsLogs2 = new SmsLogs();
        smsLogs2.setMobile("15300000000");
        smsLogs2.setCorpName("滴滴打车");
        smsLogs2.setCreateDate(new Date());
        smsLogs2.setSendDate(new Date());
        smsLogs2.setIpAddr("10.126.2.8");
        smsLogs2.setLongCode("10660000988");
        smsLogs2.setReplyTotal(50);
        smsLogs2.setState(1);
        smsLogs2.setSmsContent("【滴滴单车平台】专属限时福利！青桔/小蓝月卡立享5折，特惠畅骑30天。" + "戳 https://xxxxxx退订TD");
        smsLogs2.setProvince("上海");
        smsLogs2.setOperatorId(3);
        smsLogs2.setFee(7);
        request.add(new IndexRequest(index, type, "25").source(JSON.toJSONString(smsLogs2), XContentType.JSON));

        smsLogs2.setMobile("18000000001");
        smsLogs2.setProvince("武汉");
        smsLogs2.setSmsContent("【滴滴单车平台】专属限时福利！青桔/小蓝月卡立享5折，特惠畅骑30天。" + "戳 https://xxxxxx退订TD");
        request.add(new IndexRequest(index, type, "26").source(JSON.toJSONString(smsLogs2), XContentType.JSON));


        // -------------------------------------------------------------------------------------------------------------------

        SmsLogs smsLogs3 = new SmsLogs();
        smsLogs3.setMobile("13900000000");
        smsLogs3.setCorpName("招商银行");
        smsLogs3.setCreateDate(new Date());
        smsLogs3.setSendDate(new Date());
        smsLogs3.setIpAddr("10.126.2.8");
        smsLogs3.setLongCode("10690000988");
        smsLogs3.setReplyTotal(50);
        smsLogs3.setState(0);
        smsLogs3.setSmsContent("【招商银行】尊贵的李四先生,恭喜您获得华为P30 Pro抽奖资格,还可领100 元打" + "车红包,仅限1天");
        smsLogs3.setProvince("上海");
        smsLogs3.setOperatorId(1);
        smsLogs3.setFee(8);
        request.add(new IndexRequest(index, type, "27").source(JSON.toJSONString(smsLogs3), XContentType.JSON));

        smsLogs3.setMobile("13990000001");
        smsLogs3.setProvince("武汉");
        smsLogs3.setSmsContent("【招商银行】尊贵的李四先生,恭喜您获得华为P30 Pro抽奖资格,还可领100 元打" + "车红包,仅限1天");
        request.add(new IndexRequest(index, type, "28").source(JSON.toJSONString(smsLogs3), XContentType.JSON));

        // -------------------------------------------------------------------------------------------------------------------

        SmsLogs smsLogs4 = new SmsLogs();
        smsLogs4.setMobile("13700000000");
        smsLogs4.setCorpName("中国平安保险有限公司");
        smsLogs4.setCreateDate(new Date());
        smsLogs4.setSendDate(new Date());
        smsLogs4.setIpAddr("10.126.2.8");
        smsLogs4.setLongCode("10690000998");
        smsLogs4.setReplyTotal(18);
        smsLogs4.setState(0);
        smsLogs4.setSmsContent("【中国平安】奋斗的时代，更需要健康的身体。中国平安为您提供多重健康保 障，在奋斗之路上为您保驾护航。退订请回复TD");
        smsLogs4.setProvince("武汉");
        smsLogs4.setOperatorId(1);
        smsLogs4.setFee(5);
        request.add(new IndexRequest(index, type, "29").source(JSON.toJSONString(smsLogs4), XContentType.JSON));

        smsLogs4.setMobile("13990000002");
        smsLogs4.setProvince("武汉");
        smsLogs4.setSmsContent("【招商银行】尊贵的王五先生,恭喜您获得iphone 56抽奖资格,还可领5 元打" + "车红包,仅限100天");
        request.add(new IndexRequest(index, type, "30").source(JSON.toJSONString(smsLogs4), XContentType.JSON));

        // -------------------------------------------------------------------------------------------------------------------


        SmsLogs smsLogs5 = new SmsLogs();
        smsLogs5.setMobile("13600000000");
        smsLogs5.setCorpName("中国移动");
        smsLogs5.setCreateDate(new Date());
        smsLogs5.setSendDate(new Date());
        smsLogs5.setIpAddr("10.126.2.8");
        smsLogs5.setLongCode("10650000998");
        smsLogs5.setReplyTotal(60);
        smsLogs5.setState(0);
        smsLogs5.setSmsContent("【北京移动】尊敬的客户137****0000，5月话费账单已送达您的139邮箱，" + "点击查看账单详情 http://y.10086.cn/; " + " 回Q关闭通知，关注“中国移动139邮箱”微信随时查账单【中国移动 139邮箱】");
        smsLogs5.setProvince("武汉");
        smsLogs5.setOperatorId(1);
        smsLogs5.setFee(4);
        request.add(new IndexRequest(index, type, "31").source(JSON.toJSONString(smsLogs5), XContentType.JSON));

        smsLogs5.setMobile("13990001234");
        smsLogs5.setProvince("山西");
        smsLogs5.setSmsContent("【北京移动】尊敬的客户137****1234，8月话费账单已送达您的126邮箱，\" + \"点击查看账单详情 http://y.10086.cn/; \" + \" 回Q关闭通知，关注“中国移动126邮箱”微信随时查账单【中国移动 126邮箱】");
        request.add(new IndexRequest(index, type, "32").source(JSON.toJSONString(smsLogs5), XContentType.JSON));
        // -------------------------------------------------------------------------------------------------------------------

        client.bulk(request, RequestOptions.DEFAULT);

        System.out.println("OK!");
    }

    @Test
    public void test01() throws IOException {
        SearchRequest request = new SearchRequest(index).types(type);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //不分词
//        searchSourceBuilder.query(QueryBuilders.termQuery("province", "北京"));
//        searchSourceBuilder.query(QueryBuilders.termQuery("province", "山西"));
        searchSourceBuilder.query(QueryBuilders.termsQuery("province", "北京", "山西"));

        request.source(searchSourceBuilder);//alt+enter

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());

        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    @Test
    public void test02() throws IOException {
        SearchRequest request = new SearchRequest(index).types(type);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //智能选择分不分词
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        //分页
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(12);

        searchSourceBuilder.query(QueryBuilders.matchQuery("smsContent", "收货安装"));

        searchSourceBuilder.query(QueryBuilders.matchQuery("smsContent", "中国 健康"));//默认and
        searchSourceBuilder.query(QueryBuilders.matchQuery("smsContent", "中国 健康").operator(Operator.AND));
        searchSourceBuilder.query(QueryBuilders.matchQuery("smsContent", "中国 健康").operator(Operator.OR));
        //多个字段进行匹配
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery("北京", "province", "smsContent"));

        request.source(searchSourceBuilder);//alt+enter

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());

        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    @Test
    public void test03() throws IOException {
        SearchRequest request = new SearchRequest(index).types(type);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //其他查询
        //id
        searchSourceBuilder.query(QueryBuilders.idsQuery().addIds("21", "22"));
        //前缀
        searchSourceBuilder.query(QueryBuilders.prefixQuery("corpName", "途虎"));
        //糊涂
        searchSourceBuilder.query(QueryBuilders.fuzzyQuery("corpName", "盒马鲜生"));
        searchSourceBuilder.query(QueryBuilders.fuzzyQuery("corpName", "盒马鲜生").prefixLength(2));//糊涂, 前两个字匹配查询
        //wildcard:通配符   wild:野生,不受控
        searchSourceBuilder.query(QueryBuilders.wildcardQuery("corpName", "中国*"));
        searchSourceBuilder.query(QueryBuilders.wildcardQuery("corpName", "中国??"));
        //范围
        searchSourceBuilder.query(QueryBuilders.rangeQuery("fee").gt(5).lte(10));
        //正则
        searchSourceBuilder.query(QueryBuilders.regexpQuery("mobile", "180[0-9]{8}"));

        request.source(searchSourceBuilder);//alt+enter

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());

        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    @Test
    public void test04() throws IOException {
        SearchRequest request = new SearchRequest(index).types(type);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //复合查询
        //bool
        searchSourceBuilder.query(QueryBuilders.boolQuery()
                .should(QueryBuilders.termQuery("province", "武汉"))
                .should(QueryBuilders.termQuery("province", "北京"))
                .mustNot(QueryBuilders.termQuery("operatorId", 2))
                .must(QueryBuilders.matchQuery("smsContent", "中国"))
                .must(QueryBuilders.matchQuery("smsContent", "平安"))
        );
        //bool查询之filter
        searchSourceBuilder.query(QueryBuilders.boolQuery()
                .filter(QueryBuilders.termQuery("corpName", "盒马鲜生"))
        );
        //boosting  boosting查询可以帮助我们去影响查询后的score
        searchSourceBuilder.query(QueryBuilders.boostingQuery(
                QueryBuilders.matchQuery("smsContent", "收货安装"),
                QueryBuilders.matchQuery("smsContent", "王五")).negativeBoost(0.5f)
        );


        request.source(searchSourceBuilder);//alt+enter

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());

        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsMap());
        }
    }

    @Test
    public void test05() throws IOException {
        SearchRequest request = new SearchRequest(index).types(type);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //指定查询条件
        searchSourceBuilder.query(QueryBuilders.matchQuery("smsContent", "盒马"));
        //构建高亮域
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("smsContent", 10)
                .preTags("<font color='red'>")
                .postTags("</font>");

        searchSourceBuilder.highlighter(highlightBuilder);

        request.source(searchSourceBuilder);//alt+enter

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());

        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsMap());
            //fragment:片段
            Text text = hit.getHighlightFields().get("smsContent").getFragments()[0];
            System.out.println(text.toString());
        }
    }

    //聚合↓

    @Test
    public void test06() throws IOException {
        SearchRequest request = new SearchRequest(index).types(type);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //cardinality:基数
        searchSourceBuilder.aggregation(AggregationBuilders.cardinality("agg").field("province"));
        //extendedStats:扩展状态
        searchSourceBuilder.aggregation(AggregationBuilders.extendedStats("agg").field("fee"));
        //range:范围
        searchSourceBuilder.aggregation(AggregationBuilders.range("agg").field("fee").addUnboundedTo(5).addRange(5, 10).addUnboundedFrom(10));

        request.source(searchSourceBuilder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
        //cardinality
        Cardinality cardinality = response.getAggregations().get("agg");
        System.out.println(cardinality.getValue());
        //extendedStats
        ExtendedStats extendedStats = response.getAggregations().get("agg");
        System.out.println(extendedStats.getCount());
        System.out.println(extendedStats.getMin());
        System.out.println(extendedStats.getMax());
        System.out.println(extendedStats.getAvg());
        System.out.println(extendedStats.getSum());
        //range
        Range range = response.getAggregations().get("agg");
        for (Range.Bucket bucket : range.getBuckets()) {
            System.out.println(bucket.getKey());
            System.out.println(bucket.getFrom());
            System.out.println(bucket.getTo());
            System.out.println(bucket.getDocCount());
        }
    }

}