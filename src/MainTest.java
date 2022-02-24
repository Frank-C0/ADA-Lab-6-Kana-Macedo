public class MainTest {
	
	static int MAX = 9999;
	public static void main (String[] args) {
		
		int[][] distancias = new int[][] {
			{0,4,8,MAX,MAX},
			{4,0,1,2,MAX},
			{8,MAX,0,4,2},
			{MAX,2,4,0,7},
			{MAX,MAX,2,7,0}
		};
		
		Grafo<String> g = new Grafo<String>(
				new String[] {"A","B","C","D","E"}, distancias);
		
		System.out.println("Nodos del Grafo: ");
		System.out.println(g.nodos);
		System.out.println();
		System.out.println("Distancias del grafo:");
		printArray(distancias);
		
		System.out.println();
		
		g.Floyd_Warshall();
		
		
		
		
	}
	
	public static void printArray(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if(a[i][j] == MAX) {
					System.out.print("INF , ");
				}else {
					System.out.print(a[i][j]+" , ");
				}
				
			}
			System.out.println();
		}
	}
	
	
	
}
