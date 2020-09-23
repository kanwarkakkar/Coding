package Graph;
import java.util.*;

public class LoveTriangle {
    
    public static void main(String [] str){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        HashMap<Integer, List<Integer>> hM = new HashMap<>();
       for(int i = 1 ; i <= length; i ++)
        {
            int element = sc.nextInt();
            List<Integer> lS = new ArrayList<>();
            if(hM.containsKey(i)){
                lS = hM.get(i);
                lS.add(element);
            }else{
                lS.add(element);
            }

            hM.put(i, lS);
        }

        sc.close();

        boolean[] visited = new boolean[length+1];
        boolean[] parent = new boolean[length+1];

        for(int i =1 ; i <= length;i++)
         { 
            
            if(visited[i] == false)
                {
                    //System.out.println(i);
                    if(findLoveDFS(hM,i, visited, parent,i) == true){
                    System.out.println("YES");
                    return;
             }}
            }
             System.out.println("NO");
       
    }

    static boolean findLoveDFS(  HashMap<Integer, List<Integer>> hM , int source, boolean[] visited, boolean[] parent, int p){

        visited[source] = true;
        parent[source] = true;
        List<Integer> ls = hM.get(source);
        if(ls == null || ls.size() == 0){
            return false;
        }
        for(int l : ls){
            //System.out.print(parent[l]  + " " + l + " "  + n + "\n");
            if(visited[l] == false && findLoveDFS(hM, l, visited, parent, source)){
                return true ;
            }else if(parent[l] == true && p != l){
                return true;
            }
        }
        parent[source] = false;
        return false;
    }
}
