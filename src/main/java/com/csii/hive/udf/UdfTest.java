package com.csii.hive.udf;

public class UdfTest {
    public static void main(String[] args) {
        IPUDF ipudf = new IPUDF();
        String s = ipudf.evaluate("210.41.130.227");
        System.out.println(s);
    }
}
