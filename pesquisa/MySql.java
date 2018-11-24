package pesquisa;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import util.Cronometro;
import util.PersistenciaUtil;

public class MySql {
	
	EntityManager em = PersistenciaUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();
		
	public void save(List<LeitorArquivos> list) throws FileNotFoundException {
		et.begin();
		DadosTaxi dados = new DadosTaxi();
		String[] arquivos = dados.getFileNames();
		for (int i = 0; i < arquivos.length; i++) 
			list.addAll(dados.leitor(arquivos[i]));
		Cronometro.start();
		for (LeitorArquivos trajetorias : list) 
			em.persist(trajetorias);
		et.commit();
		Cronometro.stop();
		System.out.println("Save: "+Cronometro.tempoMilissegundos()+"ms");
	}
	
	public void consulta(List<LeitorArquivos> list) {
		List<LeitorArquivos> listaRandomica = new ArrayList<LeitorArquivos>();
		Random generator = new Random();
		for(int i=0; i < 10; i++){
			int index = generator.nextInt(list.size());
			listaRandomica.add(list.get(index));
		}
		
		Cronometro.start();
		TypedQuery<LeitorArquivos> query = em.createQuery(
				"select p from LeitorArquivos p where p.longitude "
						+ "= :longitude and p.latitude = :latitude",
				LeitorArquivos.class);
		
		for (LeitorArquivos la : listaRandomica) {	
			query.setParameter("longitude", la.getLongitude());
			query.setParameter("latitude", la.getLatitude());
		}
		Cronometro.stop();
		
		System.out.println("Consulta: "+Cronometro.tempoMilissegundos()+"ms");
		em.close();
	}

}
