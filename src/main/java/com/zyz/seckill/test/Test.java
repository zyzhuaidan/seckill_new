package com.zyz.seckill.test;

import java.util.HashSet;
import java.util.Set;

public class Test {


        public static int lengthOfLongestSubstring(String s) {
            int n = s.length();
            if(s == " "){
                return 1;
            }
            int resultLength = 0;
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n+1; j++){
                    if(judgeResult(s, i , j)){
                        resultLength = Math.max(resultLength, j - i);
                    }
                }
            }
            return resultLength;
        }
        public static boolean judgeResult(String s, int begin, int end){
            Set<Character> chr = new HashSet<>();

            for(int i = begin; i < end; i++){
                Character charStr = s.charAt(i);

                if(chr.contains(charStr)){
                    return false;
                }else{
                    chr.add(charStr);
                }
            }
            return true;
        }

    public static void main(String[] args) {
            String s = "a";
        int a  = lengthOfLongestSubstring(s);
        System.out.println(a);

    }

}
