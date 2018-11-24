package pesquisa;

import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import util.Cronometro;

public class Mongo {
	
	private MongoClient mongo;
	private MongoDatabase db;
	private MongoCollection<Document> colecao;

	public Mongo() {
		mongo = new MongoClient("localhost", 27017);
		mongo.dropDatabase("pesquisa");
		db = mongo.getDatabase("pesquisa");

		colecao = db.getCollection("LeitorArquivos");
	}

	public void save(List<LeitorArquivos> list) {
		Cronometro.start();
		for (LeitorArquivos lt : list) {
			colecao.insertOne(new Document().append("taxiID", lt.getTaxiID())
					.append("DateTime", lt.getData())
					.append("longitude", lt.getLongitude())
					.append("latitude", lt.getLatitude()));
		}
		Cronometro.stop();
		System.out.println("Save: "+Cronometro.tempoMilissegundos()+"ms");
	}

	public void consulta(List<LeitorArquivos> list) {
		FindIterable<Document> iterable = null;
		MongoCollection<Document> colecao = db.getCollection("LeitorArquivos");
		
		Cronometro.start();
		for (LeitorArquivos lt : list) {
			iterable = colecao.find(new Document().append("longitude",
					lt.getLongitude()).append("latitude", lt.getLatitude()));
			
			}
		Cronometro.stop();
		System.out.println("Consulta: "+Cronometro.tempoMilissegundos()+"ms");
		}

}
