package com.vincent;

import java.util.Arrays;

/**
 * Created by Vincent on 5/3/16.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("First step!");
        byte b = 'a';
        String ss = new String(new byte[]{b});
        byte dd = -10;
        System.out.println(dd);
        System.out.println(ss);
        System.out.println(Arrays.toString(ss.getBytes()));

        String haha = "103-dkjaslg汉子膂";
        System.out.println(Arrays.toString(haha.getBytes()));
        System.out.println(new String(haha.getBytes()));

    }
}
