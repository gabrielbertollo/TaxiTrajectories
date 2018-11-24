package principal;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import pesquisa.DadosTaxi;
import pesquisa.LeitorArquivos;
import pesquisa.Mongo;
import pesquisa.MySql;
import util.Cronometro;
import util.PersistenciaUtil;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		
		List<LeitorArquivos> list = new ArrayList<>();
		
		MySql testeMySql = new MySql();
		System.out.println("Teste MySQL");
		testeMySql.save(list);
		testeMySql.consulta(list);
		System.out.println("------------------");
		
		Mongo testeMongo = new Mongo();
		System.out.println("Teste Mongo");
		testeMongo.save(list);
		testeMongo.consulta(list);
		
		DadosTaxi dados = new DadosTaxi();
		String[] arquivos = dados.getFileNames();
		System.out.println("Teste com: " + arquivos.length + " arquivos.");
		System.out.println(list.size() + " registros.");
		
	}

}
