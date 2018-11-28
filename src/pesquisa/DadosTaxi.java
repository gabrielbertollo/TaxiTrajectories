package pesquisa;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DadosTaxi {
	
	public List<LeitorArquivos> leitor(String arquivo) throws FileNotFoundException {
		
		//Lista de registros de cada taxi
		List<LeitorArquivos> registros = new ArrayList<>();
		//Scanner para pegar todos os arquivos no diretorio files do projeto
		Scanner scan = new Scanner(new FileReader(arquivo)).useDelimiter("[,\n]");
		
		//Leitor dos arquivos
		while(scan.hasNext()) {
			Long idTaxi = scan.nextLong();
			String data = scan.next();
			String longitudeStr = scan.next();
			Double longitude = Double.parseDouble(longitudeStr);
			String latitudeStr = scan.next();
			Double latitude = Double.parseDouble(latitudeStr);
			registros.add(new LeitorArquivos(idTaxi, data, longitude, latitude));
		}
		
	return registros;	
	}
	
	public String[] getFileNames(){
		File diretorio = new File("arquivos");
		
		File[] arquivos = diretorio.listFiles();
		String[] nomes = new String[arquivos.length];
		for (int i = 0; i<arquivos.length;i++) {
			nomes[i]=arquivos[i].getAbsolutePath();			
		}
		return nomes;	
	}

}
