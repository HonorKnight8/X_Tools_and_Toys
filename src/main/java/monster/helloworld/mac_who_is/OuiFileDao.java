package monster.helloworld.mac_who_is;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class OuiFileDao {

    // private String sourceUrl = "http://standards-oui.ieee.org/oui/oui.txt";
    public String sourceUrl = "http://10.10.10.20/oui.txt";
    public String fileName = "oui.txt";
    // public String savePath = "./web_resources/oui/"; // 用相对路径会出错
    // public String savePath = "~/web_resources/oui/";
    public String savePath = "D:\\#Coding\\GitHub_Repository\\x_tools_and_toys\\web_resources\\oui\\";
    // private final long OUI_TTL = 1000 * 3600 * 24 * 7; // 7天
    private final long OUI_TTL = 1000 * 3600; // 1小时
    // public static final long OUI_TTL = 1000 * 10; // 10秒


//    public RandomAccessFile getRandomAccessFile() {
//        RandomAccessFile randomAccessFile = null;
//        try {
//            randomAccessFile = new RandomAccessFile(this.savePath + this.fileName, "r");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return randomAccessFile;
//    }

    public String getLastModifiedTime() {

        File ouiFile = new OuiFileDao().getOuiFile();

        if (!ouiFile.exists()) {
            // 文件不存在
            return "资料库为空（执行查询将自动更新资料库）。";

        } else {
            Instant lastModifiedInstant = Instant.ofEpochMilli(ouiFile.lastModified());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
            ZoneId zone = ZoneId.systemDefault();
            String lastModifiedStr = dateTimeFormatter.format(LocalDateTime.ofInstant(lastModifiedInstant, zone));
            // System.out.println(lastModifiedStr);
            return lastModifiedStr;
        }
    }

    public File getOuiFile() {

        // 判断本地文件的是否存在
        File saveDir = new File(this.savePath);
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }
        File file = new File(saveDir + File.separator + this.fileName);
        if (!file.exists()) {
            // 文件不存在，直接执行下载
            downLoadFromUrl();

        } else {
            // 文件存在，判断本地文件的最后修改时间（大于 7 天，则更新，更新时执行备份）
            long lastUpdateTime = file.lastModified();
            // System.out.println(lastUpdateTime);

            LocalDateTime nowLDT = LocalDateTime.now();
            ZoneId zone = ZoneId.systemDefault();
            Instant nowLdtInstant = nowLDT.atZone(zone).toInstant();
            long now = nowLdtInstant.toEpochMilli();
            // System.out.println(now);

            if ((now - lastUpdateTime) >= OUI_TTL) {
                // 执行备份
                // 备份过程也应该单独写一个方法，只保留最近的 3 个备份文件

                Instant lastModInstant = Instant.ofEpochMilli(file.lastModified());
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("_yyyyMMdd_HHmmss");
                String suffix = dateTimeFormatter.format(LocalDateTime.ofInstant(lastModInstant, zone));
                // System.out.println(suffix);

                File backupFile = new File(saveDir + File.separator + this.fileName + suffix);
                if (backupFile.exists()) {  //  确保新的文件名不存在
                    try {
                        throw new IOException("file exists");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (file.renameTo(backupFile)) {
                    System.out.println("文件备份完成");
                } else {
                    System.out.println("文件备份失败，跳过备份步骤");
                }
                // 执行下载更新
                this.downLoadFromUrl();
            }

        }

        return file;
    }


    /**
     * 从网络 Url 中下载文件
     */
    public void downLoadFromUrl() {
        URL url = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            url = new URL(this.sourceUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            // 设置超时间为 3 秒
            httpURLConnection.setConnectTimeout(3 * 1000);
            // 防止网站屏蔽程序抓取而返回 403 错误
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            // 得到输入流
            inputStream = httpURLConnection.getInputStream();
            // 获取字节数组
            byte[] getData = readInputStream(inputStream);

            //文件保存位置
            File saveDir = new File(this.savePath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            File file = new File(saveDir + File.separator + this.fileName);
            // System.out.println(file.getPath());
            fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write(getData);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从输入流中获取字节数组  （ inputSteam >> 字节数组 >> fileOutPutSteam ）
     * 本方法参考：https://blog.csdn.net/w410589502/article/details/53818137
     *
     * @param inputStream 传入一个输入流
     * @return byte[] 返回字节数组
     */
    public byte[] readInputStream(InputStream inputStream) {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            while ((len = inputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }


//    public String getSuffix() {
//        LocalDateTime nowLDT = LocalDateTime.now();
//        ZoneId zone = ZoneId.systemDefault();
//        Instant nowLdtInstant = nowLDT.atZone(zone).toInstant();
//        //long now = nowLdtInstant.toEpochMilli();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("_yyyyMMdd_HHmmss");
//        String suffix = dateTimeFormatter.format(LocalDateTime.ofInstant(nowLdtInstant, zone));
//        System.out.println(suffix);
//        return suffix;
//    }
}
