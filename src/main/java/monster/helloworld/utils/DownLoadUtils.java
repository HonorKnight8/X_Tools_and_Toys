package monster.helloworld.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownLoadUtils {
    // 本方法参考：https://blog.csdn.net/w410589502/article/details/53818137

    /**
     * 从网络Url中下载文件
     *
     * @param urlStr   String 下载 Url 链接
     * @param fileName String 文件名
     * @param savePath String 保存路径
     */
    public static void downLoadFromUrl(String urlStr, String fileName, String savePath) {
        URL url = null;
        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
            url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置超时间为3秒
            conn.setConnectTimeout(3 * 1000);
            // 防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            // 输入流
            inputStream = conn.getInputStream();
            // 获取字节数组
            byte[] getData = readInputStream(inputStream);

            // 文件保存位置
            File saveDir = new File(savePath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            File file = new File(saveDir + File.separator + fileName);
            fos = new FileOutputStream(file);
            fos.write(getData);
            System.out.println("info:" + url + " download success");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream 输入流
     * @return byte[] 字节数组
     */
    private static byte[] readInputStream(InputStream inputStream) {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            while ((len = inputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bos.toByteArray();
    }

}
