import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Graph {
    Map<Integer,List<Integer>> adjList = null;

    public void build(int[][]graph){
        Map<Integer,List<Integer>> map = new HashMap();
        for(int i=0;i<graph.length;i++){
            map.putIfAbsent(graph[i][0],new ArrayList<Integer>());
            map.putIfAbsent(graph[i][1],new ArrayList<Integer>());
            map.get(graph[i][0]).add(graph[i][1]);
            map.get(graph[i][1]).add(graph[i][0]);
        }
        this.adjList = map;

    }
    
    public void dfsPrint(){
        boolean[]visited = new boolean[this.adjList.size()];
        for(int n:this.adjList.keySet()){
            if(!visited[n]){
                dfs(visited, n);
            }
        }
    }
    public void dfs(boolean[]visited, int node){
        List<Integer> nodes = this.adjList.get(node);
        visited[node]=true;
        System.out.println(node);
        for(int i=0;i<nodes.size();i++){
            if(!visited[nodes.get(i)]){
                dfs(visited, nodes.get(i));
            }
        }
    }

    public void bfsPrint(){

    }
    public static void main(String[] args) {
        Graph graph = new Graph();
        int[][] edges= {{0,1}, { 1, 2 },{ 1, 0 },{ 2, 0 },{ 2, 3 },{ 2, 4 } }; 
        graph.build(edges);
        graph.dfsPrint();
    }
}
