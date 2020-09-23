package SuffixArray;

import java.util.*;
import javafx.*;

public class BasicSufficArray {
    
    public static class Pair{
        Character first;
        Integer firstInt;
        Pair pair;
        Integer second;
        public Pair(Character first, Integer second){
            this.first = first;
            this.second = second;
        }

        public Pair(Integer firstInt, Integer second){
            this.firstInt = firstInt;
            this.second = second;
        }

        public static Pair[] SortPair(Pair[] A){
            Arrays.sort(A, new Comparator<Pair>() { 
                @Override public int compare(Pair p1, Pair p2) 
                { 
                    return p1.first - p2.first; 
                } 
            });
            return A;
        }
    }

    public static class Pair1{
        Pair first;
        Integer second;

        public Pair1(Pair first, Integer second){
            this.first = first;
            this.second = second;
        }
    }

    public static class CustomerSortingComparator implements Comparator<Pair1> { 
  
    

        @Override
        public int compare(Pair1 o1, Pair1 o2) {
            int first = o1.first.firstInt.compareTo(o2.first.firstInt); 
            int second = o1.first.second.compareTo(o2.first.second); 
            if(first == 0){
                return (second ==0) ? first : second;
            }else{
                return first;
            }
        }
    } 
    public static void main(String[] args){
    
        // Read Input
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        // Append $ to the string -> it has smallest lexicographical value.
        input +='$';
        int length = input.length();
        // Need to create PAIR of order and equivalence class.
        
        int [] P = new int[length];
        int [] C = new int[length];
        Pair[] A = new Pair[length];

        // K = 0
        for(int i = 0 ; i < length; i++){
            A[i] = new Pair(input.charAt(i), i);
        }

        Pair.SortPair(A);
        
        // K = 0
        // Order Array
        for(int i = 0; i < length;  i++){
            P[i] = A[i].second;
        }

        // Equivalence class array.
        C[P[0]] = 0;
        for(int i=1; i < length;i++){
           if(A[i].first != A[i-1].first){
               C[P[i]] =C[P[i-1]]+1;
           }else{
               C[P[i]] = C[P[i-1]];
           }
        }
    
        int k = 0;
        while((1 << k) < length){
            ArrayList<Pair1> lS = new ArrayList<>();

            for(int i =0; i < length; i++)
            {    
                int nextI = (i + (1 << k)) % length;
                lS.add(new Pair1(new Pair(C[i],C[nextI] ), i));
            
            }

        Collections.sort(lS,new CustomerSortingComparator());

          // Order Array
          for(int i = 0; i < length;  i++){
            P[i] = lS.get(i).second;
        }
        
        // Equivalence class array.
        C[P[0]] = 0;
        for(int i=1; i < length;i++){
            int pair1First = lS.get(i).first.firstInt;
            int pair2First = lS.get(i-1).first.firstInt;

            int pair1Second = lS.get(i).first.second;
            int pair2Second = lS.get(i-1).first.second;

 
           if( ( pair1First == pair2First) && (pair1Second== pair2Second)){
                C[P[i]] =C[P[i-1]];
           }else{
               C[P[i]] = C[P[i-1]]+1;
           }

        }

        k++;
    }

    for(int i =0; i < length;i++){
        System.out.print(P[i] + " ");
    }
}
}
