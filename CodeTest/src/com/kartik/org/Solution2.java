package com.kartik.org;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        int energy = 100;
        int cloud = 0;
        do
        {
            energy--; //You performed a jump
            
            cloud = (cloud + k) % n;
            
            if(c[cloud] == 1)
            {
                energy -= 2;//You landed on a thundercloud
            }
        }
        while(cloud != 0);
        
        System.out.println(energy);
    }
}