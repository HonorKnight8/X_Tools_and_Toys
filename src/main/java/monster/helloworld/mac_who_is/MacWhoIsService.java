package monster.helloworld.mac_who_is;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MacWhoIsService {

    /**
     * 拿到经过初步处理的 MAC 地址（可能是批量），调用 DAO 方法逐个进行查询
     * @param macAddress String 传入字符串形式的 MAC 地址（可能多个）
     * @return Map<String, String> 返回 “MAC地址：查询结果” MAP形式的查询结果
     */
    public static Map<String, String> inquire(String macAddress) {

        // 把 MAC 地址的连接符去掉（统一使用没有连接符的格式进行查询）
        macAddress = macAddress.replaceAll("[:\\-\\. ]", "");
        // 转数组
        String[] macArray = macAddress.split(",");
        // System.out.println(Arrays.toString(macArray));

        Map<String, String> resultsMap = new HashMap<>();

        for (int i = 0; i < macArray.length; i++) {
            if (macArray[i].length() < 6) {
                resultsMap.put(macArray[i], "MAC 地址过短");
            } else if (macArray[i].length() > 12) {
                resultsMap.put(macArray[i], "MAC 地址过长");
            } else {
                // MAC 地址长度合规，进行查询
                // System.out.println(macArray[i]);
                resultsMap.put(macArray[i], MacWhoIsDao.inquireOneMacAddress(macArray[i]));
            }
        }

        return resultsMap;
    }
}
