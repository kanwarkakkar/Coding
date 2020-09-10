package Graph;
import java.util.*;

public class NewYearTransportation  {
    
    public static void main(String [] args){
        // Read input
        // Create Graph
        // Do DFS or BFS.
        Scanner sc = new Scanner(System.in);
        
        int nodes = sc.nextInt();
        int target = sc.nextInt();

        HashMap<Integer,Integer> hM = new HashMap<>();
        
        NewYearTransportation nYT = new NewYearTransportation();
        nYT.createGraph(nodes,sc,hM);

        boolean[] visited = new boolean[nodes+1];
        if(nYT.DFS(hM,visited,1,target)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }


    }

    private boolean DFS(HashMap<Integer,Integer> hM, boolean[] visited, int source, int target)
    {
        visited[source] = true;
        if(hM.containsKey(source)){
            int nextElement = hM.get(source);
            if(nextElement == target){
                return true;
            }else if(visited[nextElement] == false){
                boolean b =  DFS(hM, visited, nextElement, target);
                return b;
            } 
        }else{
            return false;
        }
        return false;
        
     }

    private void createGraph(int N, Scanner sc,  HashMap<Integer,Integer> hM){

        for(int i = 1; i < N ; i++){
            // Create a relationship i -> i + x;
            int value = i + sc.nextInt();
                hM.put(i, value);  
        }
    }
}
