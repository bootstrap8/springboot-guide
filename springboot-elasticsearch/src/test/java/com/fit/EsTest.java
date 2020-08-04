package com.fit;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.PutMappingRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.*;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class EsTest {


    /**
     * 创建Index
     */
//    @Test
    public void createIndex() throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("10.21.13.106", 9200, "http")));//初始化
        CreateIndexRequest request = new CreateIndexRequest("employee");//创建索引
        //创建的每个索引都可以有与之关联的特定设置。
        request.settings(Settings.builder()
                .put("index.number_of_shards", 3)
                .put("index.number_of_replicas", 2)
        );
        //可选参数
        //request.timeout(TimeValue.timeValueMinutes(2));//超时,等待所有节点被确认(使用TimeValue方式)
        //request.timeout("2m");//超时,等待所有节点被确认(使用字符串方式)
        request.masterNodeTimeout(TimeValue.timeValueMinutes(1));//连接master节点的超时时间(使用TimeValue方式)
        //request.masterNodeTimeout("1m");//连接master节点的超时时间(使用字符串方式)
        //request.waitForActiveShards(2);//在创建索引API返回响应之前等待的活动分片副本的数量，以int形式表示。

        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);

        client.close();

        System.out.println("isAcknowledged:" + createIndexResponse.isAcknowledged());
        System.out.println("isShardsAcknowledged:" + createIndexResponse.isShardsAcknowledged());

    }

    //    @Test
    public void putMapping() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("10.21.13.106", 9200, "http")));//初始化
        PutMappingRequest putMappingRequest = new PutMappingRequest("employee");
        /*//1
        putMappingRequest.source(
                "{\n" +
                        "  \"properties\": {\n" +
                        "    \"message\": {\n" +
                        "      \"type\": \"text\"\n" +
                        "    }\n" +
                        "  }\n" +
                        "}",
                XContentType.JSON);*/
        //2
//        Map<String, Object> jsonMap = new HashMap<>();
//        Map<String, Object> message = new HashMap<>();
//        message.put("type", "text");
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("message", message);
//        jsonMap.put("properties", properties);
//        putMappingRequest.source(jsonMap);

        //3
//        XContentBuilder builder = XContentFactory.jsonBuilder();
//        builder.startObject();
//        {
//            builder.startObject("properties");
//            {
//                builder.startObject("message");
//                {
//                    builder.field("type", "text").field("index", "false");
//                }
//                builder.endObject();
//                builder.startObject("ackFlag");
//                {
//                    builder.field("type", "integer");
//                }
//                builder.endObject();
//                builder.startObject("alarmuniqueid").field("type", "text").endObject();
//                builder.startObject("nename").field("type", "text").endObject();
//            }
//            builder.endObject();
//        }
//        builder.endObject();
//        putMappingRequest.source(builder);

        //4
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.startObject("properties");
            {
                builder.startObject("message").field("type", "text").field("index", "false").endObject();
                builder.startObject("ackFlag").field("type", "integer").endObject();
                builder.startObject("alarmuniqueid").field("type", "keyword").endObject();
                builder.startObject("nename").field("type", "keyword").endObject();
            }
            builder.endObject();
        }
        builder.endObject();
        putMappingRequest.source(builder);

        AcknowledgedResponse putMappingResponse = client.indices().putMapping(putMappingRequest, RequestOptions.DEFAULT);
        System.out.println("putMapping-->" + putMappingResponse.isAcknowledged());
    }

    /**
     * 删除索引
     *
     * @throws Exception
     */
//    @Test
    public void deleteIndex() throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("10.21.13.106", 9200, "http")));//初始化
        DeleteIndexRequest request = new DeleteIndexRequest("goods");
        request.timeout(TimeValue.timeValueMinutes(2));
        //request.timeout("2m");
        request.masterNodeTimeout(TimeValue.timeValueMinutes(1));
        //request.masterNodeTimeout("1m");
        AcknowledgedResponse deleteIndexResponse = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println("isAcknowledged:" + deleteIndexResponse.isAcknowledged());
        client.close();
    }

    /**
     * 检查索引是否存在
     *
     * @throws Exception
     */
//    @Test
    public void existIndex() throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("10.21.13.106", 9200, "http")));//初始化
        GetIndexRequest request = new GetIndexRequest();
        request.indices("goods");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println("索引goods:" + exists);
        client.close();
    }

    /**
     * 获取索引
     *
     * @throws Exception
     */
//    @Test
    public void getIndex() throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("10.21.13.106", 9200, "http")));//初始化
        GetIndexRequest request = new GetIndexRequest().indices("shop");
        GetIndexResponse getIndexResponse = client.indices().get(request, RequestOptions.DEFAULT);
        System.out.println(Arrays.toString(getIndexResponse.getIndices()));
        client.close();
    }


    /**
     * 创建或者更新文档
     * 6.x 一个索引只能存储一种类型的type
     * 7.x 去掉了type
     *
     * @throws Exception
     */
    @Test
    public void insertDocument() throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("10.21.13.106", 9200, "http")));//初始化

//        Map<String, Object> jsonMap = new HashMap<>();
//        jsonMap.put("title", "完美的衣服");
//        jsonMap.put("create_date", "2019-02-17");
//        IndexRequest request = new IndexRequest("shop", "goods", "2").source(jsonMap);
//        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
//
//        System.out.println("id:" + indexResponse.getId());
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("message", "完美的衣服");
        jsonMap.put("alarmuniqueid", "00|456");
        IndexRequest request = new IndexRequest("employee").type("_doc").id("3").source(jsonMap);
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);

        System.out.println("id:" + indexResponse.getId());
        log.info("更新文档id:<{}>成功!", "3");
        client.close();
    }

    /**
     * 获取文档
     *
     * @throws Exception
     */
//    @Test
    public void getDocument() throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("10.21.13.106", 9200, "http")));//初始化
        GetRequest request = new GetRequest("shop", "goods", "1");
        GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);

        System.out.println("数据如下：" + getResponse.getSource().toString());

        client.close();
    }

    /**
     * 判断某一个文档是否存在
     *
     * @throws Exception
     */
//    @Test
    public void existDocument() throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("10.21.13.106", 9200, "http")));//初始化
        GetRequest request = new GetRequest("shop", "goods", "1");
        boolean exists = client.exists(request, RequestOptions.DEFAULT);

        System.out.println("是否存在：" + exists);

        client.close();
    }

    /**
     * 删除文档
     *
     * @throws Exception
     */
//    @Test
    public void deleteDocuemnt() throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("10.21.13.106", 9200, "http")));//初始化
        DeleteRequest request = new DeleteRequest("shop", "goods", "2");
        request.timeout(TimeValue.timeValueMinutes(2));
        // request.timeout("2m");
        DeleteResponse deleteResponse = client.delete(request, RequestOptions.DEFAULT);

        System.out.println(deleteResponse.getSeqNo());
        client.close();
    }

    /**
     * 更新文档
     *
     * @throws Exception
     */
    @Test
    public void updateDocument() throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("10.21.13.106", 9200, "http")));//初始化
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("message", "完美的衣服-XXX4");
        //jsonMap.put("create_date", "2019-02-17");
        UpdateRequest request = new UpdateRequest("employee", "_doc", "3").doc(jsonMap);
        UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
        System.out.println(updateResponse.getId());
        client.close();
    }

    /**
     * 条件搜索
     *
     * @throws Exception
     */
//    @Test
    public void searchDocument() throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("10.21.13.106", 9200, "http")));//初始化
        SearchRequest request = new SearchRequest();
        request.indices("shop");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("title", "鞋子"));
        //## 排序start
        sourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
        sourceBuilder.sort(new FieldSortBuilder("_uid").order(SortOrder.ASC));
        //## 排序end
        sourceBuilder.from(0);
        sourceBuilder.size(5);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        request.source(sourceBuilder);

        SearchResponse searchResponse = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();

        SearchHit[] searchHits = hits.getHits();

        System.out.println("SearchHit:" + searchHits.length);

        for (SearchHit hit : searchHits) {
            Map<String, Object> datas = hit.getSourceAsMap();
            System.out.println(datas.toString());
        }

        client.close();
    }

    @Test
    public void bulkApi() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("10.21.13.106", 9200, "http")));//初始化
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("posts").id("1").source(XContentType.JSON, "field", "foo"));
        request.add(new IndexRequest("posts").id("2").source(XContentType.JSON, "field", "bar"));
        request.add(new IndexRequest("posts").id("3").source(XContentType.JSON, "field", "baz"));
        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println("-->" + bulkResponse.hasFailures());

    }
}