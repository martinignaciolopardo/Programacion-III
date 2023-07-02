package TPE2;

import TPE.GrafoNoDirigido;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class CSVReader {

	private String path;

	public CSVReader(String path) {
		this.path = path;
	}

	public void read() {

		// Obtengo una lista con las lineas del archivo
		// lines.get(0) tiene la primer linea del archivo
		// lines.get(1) tiene la segunda linea del archivo... y así
		ArrayList<String[]> lines = this.readContent();

		GrafoNoDirigido<Integer> grafo = new GrafoNoDirigido<>();

		for (String[] line: lines) {
			// Cada linea es un arreglo de Strings, donde cada posicion guarda un elemento
			Integer origen = Integer.parseInt(line[0].trim().substring(1));
			Integer destino = Integer.parseInt(line[1].trim().substring(1));
			Integer etiqueta = Integer.parseInt(line[2].trim());

			if(!grafo.contieneVertice(origen)){
				grafo.agregarVertice(origen);
			}
			if(!grafo.contieneVertice(destino)){
				grafo.agregarVertice(destino);
			}
			if (!grafo.existeArco(origen, destino)){
				grafo.agregarArco(origen, destino, etiqueta);
			}
			//System.out.println("Ori: " + origen + " Des: " + destino + " Val: " + etiqueta);
		}

		System.out.println("\nServicio greedy: ");
		ServicioGreedy sg = new ServicioGreedy(grafo);
		System.out.println("Lista de túneles a construir :" + sg.camino());
		System.out.println("Cantidad de metros totales a construir: " + sg.getMenorDistancia() + "mts");
		System.out.println("Costo: " + sg.getIteraciones() + " iteraciones");

		System.out.println("\nServicio backtracking: ");
		ServicioBacktracking sb = new ServicioBacktracking(grafo);
		sb.setDistanciaGreedy(sg.getMenorDistancia());
		System.out.println("Lista de túneles a construir :" +sb.caminos());
		System.out.println("Cantidad de metros totales a construir: " + sb.getMenorDistancia() + "mts");
		System.out.println("Costo: " + sb.getIteraciones() + " iteraciones");

	}

	private ArrayList<String[]> readContent() {
		ArrayList<String[]> lines = new ArrayList<String[]>();

		File file = new File(this.path);
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				line = line.trim();
				lines.add(line.split(";"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}

		return lines;
	}

}
