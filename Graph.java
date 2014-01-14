import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Graph{
    
    private int V;
    private int E;
    private ArrayList<Integer>[] adjList;  
    
    
    public Graph(int V){
        this.V = V;
        this.E = 0;
        adjList = (ArrayList<Integer>[]) new ArrayList[V];
        for(int i = 0;i < V;i++)
           adjList[i] = new ArrayList<Integer>();     
        
    }
    
    public Graph(Scanner S){
        this(S.nextInt());
        int edges = S.nextInt();
        for(int i = 0; i < edges; i++)
            this.addEdge(S.nextInt(),S.nextInt());
        
    }

    public void addEdge(int u,int v){
        adjList[u].add(v);
        adjList[v].add(u);
        E++;
    }
    
    public int numEdges(){
        return E;
    }
    
    public int numVertices(){
        return V;
    }
    public Iterable<Integer> adj(int v){
        return adjList[v];
    }

    public String toString(){
        StringBuilder S = new StringBuilder();
        S.append(V+" vertices "+E+" edges\n");
        for(int i = 0; i < V; i++){
            S.append(i+" : "); 
            for(int u : adj(i))
                S.append(u+" ");
            S.append("\n");          
        }
        return S.toString();
    
    }

    public static void main(String[] args){
        File F = new File(args[0]);
        try{
            Scanner S = new Scanner(F);
            Graph G = new Graph(S); 
            System.out.println(G); 
            BFS D = new BFS(G);
            int[] dist = D.distTo();
            for(int i = 0;i < dist.length;i++)
                System.out.println(i+" : "+dist[i]);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
                 
    }
}
