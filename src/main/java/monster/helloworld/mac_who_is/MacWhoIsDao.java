package monster.helloworld.mac_who_is;

import org.apache.commons.text.StringEscapeUtils;

import java.io.*;

public class MacWhoIsDao {

    /**
     * 拿一个 MAC 地址，在 oui 文件中进行查询
     *
     * @param oneMacAddress String 传入一个 MAC 地址
     * @return String 返回查询结果
     */
    public static String inquireOneMacAddress(String oneMacAddress) {
        // System.out.println(oneMacAddress);
        // 获取 oui 文件对象
        File ouiFile = new OuiFileDao().getOuiFile();
        String returnResult;

        try {
            BufferedReader in = new BufferedReader(new FileReader(ouiFile));
            // 逐行读取文件
            String line;
            while ((line = in.readLine()) != null) {
                // 如果读不到文件，说明已到文件末尾
                if (line.startsWith(oneMacAddress.substring(0, 6))) {
                    // 拿查询的 MAC 地址进行匹配，匹配成功就返回信息
                    // System.out.println(oneMacAddress + "\n" + line);
                    returnResult = line.substring(20).trim()
                            + " ♦ " + in.readLine().trim()
                            + " ♦ " + in.readLine().trim()
                            + " ♦ " + in.readLine().trim();
                    returnResult = StringEscapeUtils.escapeHtml4(returnResult);

                    return returnResult;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读完文件没匹配到，说明没有记录
        return "资料库中未匹配到相关记录";
    }

}
