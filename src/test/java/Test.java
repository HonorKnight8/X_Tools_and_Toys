import monster.helloworld.file_name.FileName;
import monster.helloworld.mac_who_is.OuiFileDao;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;


public class Test {

    @org.junit.jupiter.api.Test
    public void test1() {
        FileName fileName = new FileName();
        System.out.println(fileName.checkFileName("aA _-5.,txt"));


        System.out.println(fileName.convertFileName("   Hello --  World 123   .   pDf"));
//        String str = " A123-Z-3 ";
//        System.out.println(str);
//        str = str.trim();
//        System.out.println(str);
//        str = str.toLowerCase();
//        System.out.println(str);
//
//        System.out.println(str.replace('-', '_'));
//        System.out.println(str);

    }

    @org.junit.jupiter.api.Test
    public void test21() throws IOException, InterruptedException {
//        File file = new File("./resources/oui/index.md");
//
//        System.out.println(file.lastModified());
//
//        Instant lastModInstant = Instant.ofEpochMilli(file.lastModified());
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("_yyyyMMdd_HHmmss");
//        ZoneId zone = ZoneId.systemDefault();
//        String suffix = dateTimeFormatter.format(LocalDateTime.ofInstant(lastModInstant, zone));
//        System.out.println(suffix);
//
//        LocalDateTime nowLDT = LocalDateTime.now();
////        ZoneId zone = ZoneId.systemDefault();
//        Instant nowLdtInstant = nowLDT.atZone(zone).toInstant();
//        long now = nowLdtInstant.toEpochMilli();
//        System.out.println(now);

//        1629295412451



//        new OuiFileDao().downLoadFromUrl();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000 * 6);
            System.out.println(i);
            new OuiFileDao().getOuiFile();
        }

        Thread.sleep(1000 * 11);
        new OuiFileDao().getOuiFile();

//       new OuiFileDao("http://standards-oui.ieee.org/oui/oui.txt","./resources/","oui5.txt").getOui();

    }

    @org.junit.jupiter.api.Test
    public void test2() throws IOException {

        // 1.使用参数指定的字符串来构造对象
        URL url = new URL("http://standards-oui.ieee.org/oui/oui.txt");
        // 2.获取相关信息并打印出来
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getDefaultPort());
        System.out.println(url.getPath());
        System.out.println(url.getFile());

        System.out.println(url.getAuthority());
        System.out.println(url.getContent());
        System.out.println(url.getQuery());
        System.out.println(url.getRef());
        System.out.println(url.getUserInfo());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        System.out.println(simpleDateFormat.format(url.openConnection().getLastModified()));


        System.exit(99);


        // 3.建立连接并读取相关信息打印出来
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String str = null;
//            while ((str = br.readLine()) != null) {
//                System.out.println(str);
//            }

        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());


        br.close();
        // 断开连接
        urlConnection.disconnect();


//        File f1 = new File("http://standards-oui.ieee.org/oui/oui.txt");

//        System.out.println(f1.exists());
    }
}
