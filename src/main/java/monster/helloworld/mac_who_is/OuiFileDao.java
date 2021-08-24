package monster.helloworld.mac_who_is;

import monster.helloworld.utils.DownLoadUtils;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class OuiFileDao {

    /**
     * 获取 oui 文件最后修改时间的方法
     *
     * @return String
     */
    public String getLastModifiedTime() {

        File ouiFile = OuiFileBean.getOuiFile(new File(this.getClass().getResource("/").getPath()));

        if (!ouiFile.exists()) {
            // 文件不存在
            return "资料库为空（执行查询将自动更新资料库）。";

        } else {
            Instant lastModifiedInstant = Instant.ofEpochMilli(ouiFile.lastModified());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss");
            ZoneId zone = ZoneId.systemDefault();
            String lastModifiedStr = dateTimeFormatter.format(LocalDateTime.ofInstant(lastModifiedInstant, zone));
            // System.out.println(lastModifiedStr);
            return lastModifiedStr;
        }
    }

    /**
     * 获取 oui 文件对象的方法。
     * 若文件不存在，或过期，调用下载方法进行下载，
     * 下载之前备份旧文件。
     *
     * @return File
     */
    public File getOuiFile() {

        // 判断本地目录的是否存在
        File ouiFile = OuiFileBean.getOuiFile(new File(this.getClass().getResource("/").getPath()));
        File saveDir = ouiFile.getParentFile();
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }
        File file = new File(saveDir + File.separator + Constant.FILE_NAME);
        if (!file.exists()) {
            // 文件不存在，直接执行下载
            DownLoadUtils.downLoadFromUrl(Constant.SOURCE_URL,Constant.FILE_NAME,saveDir.toString());

        } else {
            // 文件存在，判断本地文件的最后修改时间（大于 7 天，则更新，更新时执行备份）
            long lastUpdateTime = file.lastModified();
            // System.out.println(lastUpdateTime);

            LocalDateTime nowLDT = LocalDateTime.now();
            ZoneId zone = ZoneId.systemDefault();
            Instant nowLdtInstant = nowLDT.atZone(zone).toInstant();
            long now = nowLdtInstant.toEpochMilli();
            // System.out.println(now);

            if ((now - lastUpdateTime) >= Constant.OUI_TTL) {
                // 执行备份
                // 备份过程也应该单独写一个方法，只保留最近的 3 个备份文件

                Instant lastModInstant = Instant.ofEpochMilli(file.lastModified());
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("_yyyyMMdd_HHmmss");
                String suffix = dateTimeFormatter.format(LocalDateTime.ofInstant(lastModInstant, zone));
                // System.out.println(suffix);

                File backupFile = new File(saveDir + File.separator + Constant.FILE_NAME + suffix);
                if (backupFile.exists()) {  //  确保新的文件名不存在
                    try {
                        throw new IOException("file exists");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (file.renameTo(backupFile)) { // 执行备份文件
                    System.out.println("文件备份完成");
                } else {
                    System.out.println("文件备份失败，跳过备份步骤");
                }
                // 执行下载更新
                DownLoadUtils.downLoadFromUrl(Constant.SOURCE_URL,Constant.FILE_NAME,saveDir.toString());
            }

        }

        return file;
    }

}
