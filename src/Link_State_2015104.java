import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Boolean.TRUE;

/**
 * Created by lirus on 10/11/17.
 */
public class Link_State_2015104 {
    public static void Bellman_Ford(int [][]cost, int src,int dest)
    {
        int path[]=new int[10];
        for(int i=0;i<10;i++)
            path[i]=Integer.MAX_VALUE;
        path[src]=0;
        int count=0;
        while(count<9)
        {
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < 10; j++) {
                    if (cost[i][j]!=Integer.MAX_VALUE && path[j]>path[i]+cost[i][j])
                        path[j]=path[i]+cost[i][j];
                }
            for(int i=0;i<10;i++)
                System.out.print(path[i]+" ");
            System.out.println("");
            count++;
        }
        System.out.println("Therefore the shortest path using Bellman_Ford from "+ (char)(src+65) + " to "+ (char)(dest+65) + " is "+path[dest]);
    }
    public static void Dijkstra(int[][] cost,int src,int dest)
    {
        int path[]=new int[10];
        for(int i=0;i<10;i++)
            path[i]=Integer.MAX_VALUE;
        path[src]=0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(src);
        while(!q.isEmpty())
        {
            int temp=q.poll();
            for(int i=0;i<10;i++)
            {
                if (cost[temp][i] != Integer.MAX_VALUE && path[i] > path[temp] + cost[temp][i])
                {
                    path[i] = path[temp] + cost[temp][i];
                    q.offer(i);
                }
            }
            for(int i=0;i<10;i++)
                System.out.print(path[i]+" ");
            System.out.println("");
        }

        System.out.println("Therefore the shortest path using Dijkstra from "+ (char)(src+65) + " to "+ (char)(dest+65) + " is "+path[dest]);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int[][] cost = new int[10][10];
        String [] words=s.split("\\s");
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++)
                cost[i][j]=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i+=3)
        {
            int a=words[i].charAt((0));
            int b=words[i+1].charAt((0));
            cost[a-65][b-65]=Integer.parseInt(words[i + 2]);
        }

        int src,dest;
        System.out.println("Enter the source and destination");
        String str=sc.nextLine();
        String [] w=str.split("\\s");
        src=w[0].charAt(0)-65;
        dest=w[1].charAt(0)-65;
        System.out.println("Enter the choice Dijkstra vs Bellman-Ford");
        String choice=sc.nextLine();
        if(choice=="Dijkstra")
        {
            Dijkstra(cost,src,dest);
            while(TRUE)
            {
                System.out.println("Enter the update");
                s=sc.nextLine();
                words=s.split("\\s");
                for(int i=0;i<words.length;i+=3)
                {
                    int a=words[i].charAt((0));
                    int b=words[i+1].charAt((0));
                    cost[a-65][b-65]=Integer.parseInt(words[i + 2]);
                }
                Dijkstra(cost,src,dest);
            }
        }
        else
        {
            Bellman_Ford(cost, src, dest);
            while(TRUE)
            {
                System.out.println("Enter the update");
                s=sc.nextLine();
                words=s.split("\\s");
                for(int i=0;i<words.length;i+=3)
                {
                    int a=words[i].charAt((0));
                    int b=words[i+1].charAt((0));
                    cost[a-65][b-65]=Integer.parseInt(words[i + 2]);
                }
                Bellman_Ford(cost,src,dest);
            }
        }
    }
}
