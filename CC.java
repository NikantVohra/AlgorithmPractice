public class CC{
    private int[] comp;
    private int numCC;
    public cc(Graph G){
        comp = new int[G.numVertices()];
        numCC = 0;
        for(int i = 0; i < G.numVertices();i++){
            comp[i] = -1;        
        }
        
        for(int v = 0; v < G.numVertices();v++){
                
                dfs(G,v);
            cc++;
        }
    }
    
}
