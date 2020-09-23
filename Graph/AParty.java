package Graph;
import java.util.*;
public class AParty {
    
    public static void main(String[] args){
        AParty A = new AParty();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        HashMap<Integer, List<Integer>> hM = new HashMap<>();
       for(int i = 1 ; i <= length; i ++)
        {
            int element = sc.nextInt();
            List<Integer> lS = new ArrayList<>();
            if(hM.containsKey(element)){
                lS = hM.get(element);
                lS.add(i);
            }else{
                lS.add(i);
            }

            hM.put(element, lS);
        }
        
        sc.close();
        //Find max depth in lS
        // DFS over elements with key -1
        List<Integer> lRoot = hM.get(-1);

        int maxHeight = 0;
        for(int i : lRoot){
            
            int height = A.traverse(hM,i);
            if(height > maxHeight){
                maxHeight = height;
            }
        }
         System.out.println(maxHeight);
    }

    int traverse(HashMap<Integer, List<Integer>> hM, int source){

        if(!hM.containsKey(source)){
            return 0;
        }

        List<Integer> lS = hM.get(source);
        for(int i : lS){
            return 1 + traverse(hM, i);
        }
        return 0;
    }
}
