package com.csii.hive.udf.udf;

import com.csii.hive.udf.iplocation.IPAddressUtils;
import com.csii.hive.udf.iplocation.IPLocation;
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
        StringBuilder sb = new StringBuilder(64);
        //1. 获取经纬度
        Location location = ipAddressUtils.getLookupService().getLocation(ip);
        sb.append(location.longitude).append(",").append(location.latitude).append(",");

        //2. 获取省份和城市
        IPLocation ipLocation = ipAddressUtils.getIPLocation(ip);
        String province = ipLocation.getRegion();
        String city = ipLocation.getCity();
        sb.append(province).append(",").append(city);
        return sb.toString();
    }
}
