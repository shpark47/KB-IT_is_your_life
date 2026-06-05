package app.sec02;

import app.sec01.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Iterator;

// import static : 클래스명을 생략하고 메소드명만 작성 가능
import static com.mongodb.client.model.Filters.*;

public class FindOneTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("study");

        Bson query = eq("_id", new ObjectId("6a226839e832a16e0f7f4ff6"));
        Document doc = collection.find(query).first();

        System.out.println(doc);
        Database.close();
    }
}
