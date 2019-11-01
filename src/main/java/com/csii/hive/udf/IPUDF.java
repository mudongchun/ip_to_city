package com.csii.hive.udf;

import com.csii.hive.iplocation.IPAddressUtils;
import com.csii.hive.iplocation.IPLocation;
import com.maxmind.geoip.Location;
import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * @Description TODO
 * @Author KG21_YANG
 * @Date 2019/10/9 15:59
 */
public class IPUDF extends UDF {
    private IPAddressUtils ipAddressUtils = new IPAddressUtils();

    public  String evaluate(String ip) {
        String res = null;

        //1. 获取经纬度
        Location location = ipAddressUtils.getLookupService().getLocation(ip);
        String longitude = String.valueOf(location.longitude);
        String latitude = String.valueOf(location.latitude);

        //2. 获取省份和城市
        IPLocation ipLocation = ipAddressUtils.getIPLocation(ip);
        String province = ipLocation.getRegion();
        String city = ipLocation.getCity();
        res = longitude + "u" + latitude + "u" + province + "u" + city;
        return res;
    }
}
