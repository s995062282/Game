package game_life;

import java.util.Random;
import java.io.*;
public class xiayidai {
    int[][] a = new int[100][100];
    int [][]b=new int [100][100];
    public void set() {
        for (int i = 0; i < 100; i++)

        {
            for (int j = 0; j < 100; j++) {
                Random random = new Random();

                int s = random.nextInt(2);
                a[i][j]=s;
            }
        }
    }
    public void next(){
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<100;j++)
            {
                int sum=0;
                if(i==0&&j==0)
                    sum=a[1][1]+a[0][1]+a[1][0];
                else if(i==99&&j==99)
                    sum=a[99][98]+a[98][99]+a[98][98];
                else if(i==99&&j==0)
                    sum=a[98][0]+a[98][1]+a[99][1];
                else if(i==0&&j==99)
                    sum=a[0][98]+a[1][98]+a[1][99];
                else if(i==0)
                    sum=a[0][j-1]+a[0][j+1]+a[1][j-1]+a[1][j]+a[1][j+1];
                else if(i==99)
                    sum=a[99][j-1]+a[99][j+1]+a[98][j-1]+a[98][j]+a[98][j+1];
                else if(j==0)
                    sum=a[i-1][0]+a[i+1][0]+a[i-1][1]+a[i][1]+a[i+1][1];
                else if(j==99)
                    sum=a[i-1][99]+a[i+1][99]+a[i-1][98]+a[i][98]+a[i+1][98];
                else
                    sum=a[i][j-1]+a[i][j+1]+a[i-1][j]+a[i+1][j]+a[i-1][j-1]+a[i-1][j+1]+a[i+1][j-1]+a[i+1][j+1];
                if(a[i][j]==0&&sum==3)
                    b[i][j]=1;
                else if(a[i][j]==1&&sum<2)
                    b[i][j]=0;
                else if(a[i][j]==1&&sum>3)
                    b[i][j]=0;
                else
                    b[i][j]=a[i][j];
            }
        }
        for(int i=0;i<100;i++)
            for(int j=0;j<100;j++)
                a[i][j]=b[i][j];

    }
    public void print (){
        for(int i=0;i<100;i++)
        {
            for(int j=0;j<100;j++)
                System.out.print(a[i][j]+"  ");
            System.out.println();
        }
    }
}
