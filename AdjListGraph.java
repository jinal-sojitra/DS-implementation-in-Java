import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author JINAL SOJITRA
 */
public class AdjList {
    //DFS
    public static void dfs(int node,boolean visited[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> dfs){
        dfs.add(node);
        visited[node]=true;
        for(Integer it:adj.get(node)){
            if(!visited[it])
                dfs(it,visited,adj,dfs);
        }
    }
    //driver_func
    public static ArrayList<Integer> dfsDriver(int v, ArrayList<ArrayList<Integer>> adj){
    ArrayList<Integer> dfs=new ArrayList<>();
    boolean visited[]=new boolean[v+1];
    for(int i=1;i<=v;i++){
        if(!visited[i])
            dfs(i,visited,adj,dfs);
    }
    return dfs;
    }
    
    //BFS
    public static ArrayList<Integer> bfsTraversal(int V,ArrayList<ArrayList<Integer>> list){
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean visited[]=new boolean[V+1];
        for(int i=1;i<=V;i++){//for Disconnected graph
            if(!visited[i]){
            //bfs
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                visited[i]=true;

                while(!q.isEmpty()){
                Integer node=q.remove();
                bfs.add(node);
                visited[node]=true;
                for(Integer it:list.get(node)){
                    if(!visited[it]){
                    q.add(it);
                    visited[it]=true;
                    }
                }
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args){
        int n=3,m=3;
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<Integer>());
        }
        
        list.get(1).add(2);
        list.get(2).add(1);
        
        list.get(2).add(3);
        list.get(3).add(2);
        
        list.get(3).add(1);
        list.get(1).add(3);
        
        System.out.println("BFS Traversal: "+bfsTraversal(n,list));
        System.out.println("DFS Traversal: "+dfsDriver(n,list));
    }
}
