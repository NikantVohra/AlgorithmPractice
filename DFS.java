public class DFS{
    private boolean[] visited;
    private int count;
    public DFS(Graph G){
        count = 0;
        visited = new boolean[G.numVertices()];
        for(int v = 0; v < G.numVertices();v++)
            if(!visited[v])
                dfs(v,G);        
    
    }
    
    public int count(){
        return count;
    }
    private void dfs(int v,Graph G){
        visited[v] = true;
        count++;
        for(int u : G.adj(v)){
            if(!visited[u])
                dfs(u,G);
           
        }
    }

    public boolean isVisited(int v){
        return visited[v];
    
    }
    
   


}
