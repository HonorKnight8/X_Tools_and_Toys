package monster.helloworld.mac_who_is;

import java.util.HashMap;
import java.util.Map;

public class MacWhoIsService {
    public static Map<String, String> inquire(String macAddress) {

        // 把 MAC 的连接符去掉（统一使用没有连接符的格式进行查询）
        macAddress = macAddress.replaceAll("[:\\-\\. ]", "");
        // 转数组
        String[] macArray = macAddress.split(",");

        Map<String, String> resultsMap = new HashMap<>();

        for (int i = 0; i < macArray.length; i++) {
            if (macArray[i].length() < 6) {
                resultsMap.put(macArray[i], "MAC 地址过短");
            } else if (macArray[i].length() > 12) {
                resultsMap.put(macArray[i], "MAC 地址过长");
            } else {
                resultsMap.put(macArray[i], MacWhoIsDao.inquireOneMacAddress(macArray[i]));
            }
        }

        return resultsMap;
    }
}
