package app.sec02;

import app.sec01.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.Iterator;

public class FindTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("study");

        // FindIterable : 조회 결과를 반복자(Iterator) 형태로 반활할 수 있는 객체
        FindIterable<Document> doc = collection.find();

        for (Document d : doc) {
            System.out.println(d);
        }

        Database.close();
    }
}
