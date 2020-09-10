package Graph;
import java.util.*;

public class BerSUBall {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        int length1 = sc.nextInt();
        int[] boys = new int [length1+1];
    
        for(int i = 1 ; i <= length1; i++){
            boys[i] = sc.nextInt();
        }

        int length2 = sc.nextInt();
        int[] girls = new int[length2+1];
        boolean[] visited = new boolean[length2+1];

        for(int j = 1 ; j <= length2; j++){
            girls[j] = sc.nextInt();
        }

        int count = 0;

        Arrays.sort(boys,0,length1+1);
        Arrays.sort(girls,0,length2+1);
       
        for(int in = 1; in <= length1 ; in++){
            for(int g=1; g<=length2; g++){

                if(visited[g] == true)
                    continue;

                int diff = Math.abs(girls[g] - boys[in]);

                if(diff > 1)
                    continue;


                count++;
                visited[g] = true;
                break;
            }
        }
        System.out.println(count);}
 }
