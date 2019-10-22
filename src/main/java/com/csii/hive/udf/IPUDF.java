package com.csii.hive.udf;

import com.csii.hive.iplocation.IPAddressUtils;
import com.csii.hive.iplocation.IPLocation;
import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.io.IOException;

/**
 * @Description TODO
 * @Author KG21_YANG
 * @Date 2019/10/9 15:59
 */
public class IPUDF extends UDF {
    @SuppressWarnings("finally")
    public static String evaluate(String ip){
        String res=null;
        try {
            String filepath = "/root/GeoLiteCity.dat";
            LookupService lookupService = new LookupService(filepath);
            IPAddressUtils ipAddressUtils = new IPAddressUtils();
            IPLocation ipLocation = ipAddressUtils.getregion(ip);
            Location location = lookupService.getLocation(ip);
            String longitude = String.valueOf(location.longitude);
            String latitude = String.valueOf(location.latitude);
            String province = ipLocation.getRegion();
            String city = ipLocation.getCity();
            res=longitude+"|"+latitude+"|"+province+"|"+city;
//            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return res;
        }
    }

//    public static void main(String[] args) {
//        IPUDF ipudf = new IPUDF();
//        String s = ipudf.evaluate("210.41.130.227");
//        System.out.println(s);
//    }
}
