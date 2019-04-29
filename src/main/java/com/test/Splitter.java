package com.test;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    public static List<String> split(String src, String[] tokens) {
        List<String> srcList = Arrays.asList(src);
        for(String token : tokens) {
            List<String> targetList = new ArrayList<>();
            for(String item : srcList) {
                String[] targetArray = item.split(token, -1);
                for(String target : targetArray) {
                    targetList.add(target);
                }
            }
            srcList = targetList;
        }
        return srcList;
    }

    public static void main(String[] args) {
        String src = "abc---def::ghi::jkl:mno-";
        String[] tokens = { "--", "ghi", ":", "-", "rst" };
        List<String> result = split(src, tokens);

        String str = StringUtils.join(result, "\",\"");
        System.out.println("{\"" + str + "\"}");
    }

}
