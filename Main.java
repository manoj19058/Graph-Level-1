public class Main{
	static class Edge{
		int src; 
		int nbr; 
		int wt; 
		Edge(int src, int nbr, int wt){
			this.src = src; 
			this.nbr = nbr; 
			this.wt = wt; 
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int vtces = sc.nextInt(); 
		ArrayList<Edge>[] graph = new ArrayList[vtces]; 
		for(int i = 0; i < vtces; i++){
			graph[i] = new ArrayList<Edge>(); 
		}
		int edges = 10; 
		for(int i = 0; i < edges; i++){
			int u = sc.nextInt(); 
			int v = sc.nextInt(); 
			int wt = sc.nextInt(); 
			graph[u].add(new Edge(u, v, wt)); 
			graph[v].add(new Edge(v, u, wt)); 
		}
		boolean visited[] = new boolean[vtces]; 
		int src = sc.nextInt(), dest = sc.nextInt(); 
		boolean path = hasPath(graph, src, dest); 
		System.out.println(path);
	}
	public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean visited []){
		if(src == dest)	return true; 

		visited[src] = true; 
		for(Edge edge : graph[src]){
			if(visited[edge.nbr]) continue; 
			boolean path = hasPath(graph, edge.nbr, dest, visited)
			if(path) return true;  
		}

		return false; 
	}
}