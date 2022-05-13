package com.test;

public class Intern {

    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);//


        String s3 = new String("1") + new String("1");
        String s5 = s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);//
        System.out.println(s5 == s4);


        // 若该字符串不存在常量池，则添加到常量池
        String str1 = new String("intern");
        String intern = str1.intern();
        System.out.println(str1 == intern);
        // string 的 hashCode 有缓存
        intern.hashCode();
        intern.equals("");
        intern.charAt(0);

        String str2 = "1";
        String intern2 = str2.intern();
        System.out.println(str2 == intern2);


    }


}
