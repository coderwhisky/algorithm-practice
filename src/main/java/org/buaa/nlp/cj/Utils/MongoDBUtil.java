package org.buaa.nlp.cj.Utils;


import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;

/**
 * Created by whisky on 15-5-13.
 */
public class MongoDBUtil {
    String addr = "localhost";
    int port = 27017;
    MongoClient mongoClient = new MongoClient(addr, port);

    public void mongoInsert(String dbname, String collectionName, Document doc) {
        MongoDatabase db = mongoClient.getDatabase(dbname);
        MongoCollection collection = db.getCollection(collectionName);
//        BasicDBObject doc = new BasicDBObject("version","v3");
//        doc.append("version", "v4");
        collection.insertOne(doc);
    }

    /**
     * 返回指定文档集合中的所有记录
     * @param dbname
     * @param collectionName
     * @return
     */
    public FindIterable<Document> mongoFindAll(String dbname, String collectionName) {
        FindIterable<Document> result = null;
        MongoDatabase db = mongoClient.getDatabase(dbname);
        MongoCollection collection = db.getCollection(collectionName);
        result = collection.find();
        Iterator iter = result.iterator();
        int docNum = 0;
        while (iter.hasNext()) {
//            System.out.println(++docNum);
            Document doc = (Document) iter.next();
//            System.out.println(doc.keySet());
//            System.out.println(doc.get("version8"));
//            System.out.println(doc.toJson());
        }
        return result;
    }

    /**
     * 根据过滤条件 filter 查询
     * @param dbname
     * @param collectionName
     * @param filter
     * @return
     */
    public FindIterable<Document> mongoFind(String dbname, String collectionName, Document filter) {
        FindIterable<Document> result = null;
        MongoDatabase db = mongoClient.getDatabase(dbname);
        MongoCollection collection = db.getCollection(collectionName);
        result = collection.find(filter);
        Iterator iter = result.iterator();
        int docNum = 0;
        while (iter.hasNext()) {
//            System.out.println(++docNum);
            Document doc = (Document) iter.next();
//            System.out.println(doc.keySet());
//            System.out.println(doc.get("version8"));
//            System.out.println(doc.toJson());
        }
        return result;
    }

    /**
     * 修改doc
     * @param dbName
     * @param collectionName
     * @param oldDoc
     * @param newDoc
     */
    public void mongoUpdate(String dbName, String collectionName, Document oldDoc, Document newDoc) {
        MongoDatabase db = mongoClient.getDatabase(dbName);
        MongoCollection collection = db.getCollection(collectionName);
//        collection.updateOne(oldDoc, newDoc);
        collection.findOneAndReplace(oldDoc, newDoc);
    }

    public static void main(String[] args) {
        MongoDBUtil mongoDBUtil = new MongoDBUtil();
//        Document doc = new Document();
//        doc.append("version","v3");
//        doc.append("version7", "v7");
//        doc.put("version7","v7");
//        doc.append("version8","v8");
//        doc.append("userId", "1014588231");
//        mongoDBUtil.mongoInsert("paperdata", "testCollection", doc);
        FindIterable<Document> result = mongoDBUtil.mongoFindAll("paperdata", "test");
        int resultCount = 0;
        for (Document thisDoc : result) {
            System.out.println(++resultCount);
            System.out.println(thisDoc.toString());
            System.out.println(thisDoc.get("a"));
        }
    }
}
