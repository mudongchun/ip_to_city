package com.csii.hive.udf;

import com.csii.hive.udf.udf.IPUDF;

public class UdfTest {
    public static void main(String[] args) {
        IPUDF ipudf = new IPUDF();
        String s = ipudf.evaluate("210.41.130.227");
        String s1 = ipudf.evaluate("182.61.200.7");
        String s2 = ipudf.evaluate("66.102.251.33");

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
    }
}
