import java.util.ArrayList;
import java.util.Collections;

public class Grafo<E> {
	private int[][] matrizGrafo;
	public ArrayList<E> nodos;
	
	
//	public Grafo(E[] a){
//		this.matrizGrafo = new int[a.length][a.length];
//		for (int i = 0; i < a.length; i++) {
//			for (int j = 0; j < a.length; j++) {
//				matrizGrafo[i][j]=Integer.MAX_VALUE;
//			}
//		}
//		nodos = new ArrayList<E>();
//		Collections.addAll(nodos, a);
//	}
	
	public Grafo(E[] a, int[][] distancias) {
		this.matrizGrafo = distancias;
		nodos = new ArrayList<E>();
		Collections.addAll(nodos, a);
	}
	
	public int[][] distanciaMinima;
	Object[][] nodoAnterior;
	
	public int[][] Floyd_Warshall(){
		
		int n= nodos.size();
		distanciaMinima = new int[n][n];
		nodoAnterior = new Object[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				distanciaMinima[i][j] = matrizGrafo[i][j];
				if(i!=j) {
				nodoAnterior[i][j] = nodos.get(i);
				}
			}
		}

		for (int k = 0; k < n; k++) {
	      for (int i = 0; i < n; i++) {
	        for (int j = 0; j < n; j++) {
	          if (distanciaMinima[i][k] + distanciaMinima[k][j] < distanciaMinima[i][j]) {
	            distanciaMinima[i][j] = distanciaMinima[i][k] + distanciaMinima[k][j];
	            nodoAnterior[i][j] = nodos.get(k);
	            System.out.println(
	            		"Nueva distancia minima : "+
	            nodos.get(i)+
	            " - "+nodos.get(k)+
	            		" - "+ 
	            nodos.get(j)+"\n  Distancia anterior :"+ 
	            		distanciaMinima[i][j]+
	            "\n    Nuevas distancia: "
	            		+distanciaMinima[i][k] + " + "+distanciaMinima[k][j]+" = "+(distanciaMinima[i][k] +distanciaMinima[k][j]));
	          }
	        }
	      }
	    }
		print_Floyd_Warshall();
		return distanciaMinima;
	}
	
	public void print_Floyd_Warshall() {
		System.out.println("\nMatriz de Distancias:");
		for (int i = 0; i < distanciaMinima.length; i++) {
			for (int j = 0; j < distanciaMinima.length; j++) {
				System.out.print(distanciaMinima[i][j]+" , ");
			}
			System.out.println();
		}
		
		System.out.println("\nMatriz de Recoridos:");
		for (int i = 0; i < matrizGrafo.length; i++) {
			for (int j = 0; j < matrizGrafo.length; j++) {
				System.out.print(((E)nodoAnterior[i][j])+" , ");
			}
			System.out.println();
		}
	}
			
}
