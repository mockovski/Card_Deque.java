package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card_Queue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> firstPlayer = new LinkedList<>();
        Queue<Integer> secondPlayer = new LinkedList<>();
        System.out.println("Введите карты первого игрока: ");
        int input;
        for(int i=0;i<5;i++){
            input = in.nextInt();
            firstPlayer.offer(input);
        }
        System.out.println("Введите карты второго игрока: ");
        for(int i=0;i<5;i++){
            input = in.nextInt();
            secondPlayer.offer(input);
        }
        int cnt =0;
        while(!firstPlayer.isEmpty() && !secondPlayer.isEmpty()){
            if(firstPlayer.peek()==0){
                firstPlayer.offer(secondPlayer.poll());
                firstPlayer.offer(firstPlayer.poll());
            }
            else if(secondPlayer.peek()==0){
                secondPlayer.offer(secondPlayer.poll());
                secondPlayer.offer(firstPlayer.poll());
            }
            else if (firstPlayer.peek()>secondPlayer.peek()){
                firstPlayer.offer(secondPlayer.poll());
                firstPlayer.offer(firstPlayer.poll());
            }
            else {
                secondPlayer.offer(secondPlayer.poll());
                secondPlayer.offer(firstPlayer.poll());
            }
            cnt++;
            if(cnt>106) break;
        }
        if(cnt>106) System.out.println("botva");
        else if(secondPlayer.isEmpty()) System.out.println("first");
        else System.out.println("second");

        System.out.println(firstPlayer);
        System.out.println(secondPlayer);
    }
}
