package com.Huffman;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class HuffmanNode {
    int data;
    char ch;

    HuffmanNode left;
    HuffmanNode right;
}

class  MyCm implements Comparator<HuffmanNode>{
    public int compare (HuffmanNode x , HuffmanNode y){
        return x.data - y.data;
    }
}
public class Haffman {

    public static  void  print(HuffmanNode root , String s){
        if(root.left == null && root.right == null && Character.isLetter(root.ch)){
            System.out.println(root.ch + ":" + s);

            return;
        }
        print(root.left , s + "0");
        print(root.right, s + "1");
    }


    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int n;
        System.out.print("Please Enter Number Of Symols :");
        n = input.nextInt();

        char[] symolArr = new char[n];
        int[] AbSymolsArr = new int[n];

        for (int i = 0; i <n; i++){
            System.out.print("Symbol #" + (i+1) + ":");
            symolArr[i] = input.next().charAt(0);
            System.out.print("Faravani Namad #" + (i+1) + ":");
            AbSymolsArr[i] = input.nextInt();
        }

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyCm());

        for (int i =0; i <n; i++){
            HuffmanNode hn = new HuffmanNode();
            hn.ch = symolArr[i];
            hn.data = AbSymolsArr[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }
        HuffmanNode root = null;
        while (q.size() > 1){
            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();

            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.ch = '-';
            f.left = x;
            f.right = y;
            root = f;

            q.add(f);

        }
       print(root, "");
    }


}
