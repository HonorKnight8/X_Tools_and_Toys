import monster.helloworld.file_name.FileNameServlet;
import monster.helloworld.mac_who_is.MacWhoIsDao;
import monster.helloworld.mac_who_is.OuiFileDao;
import org.apache.commons.text.StringEscapeUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;


public class Test {

    @org.junit.jupiter.api.Test
    public void test30(){
        System.out.println(new OuiFileDao().justGetOuiFile());
        System.out.println(System.getProperty("user.dir"));
    }

//    @org.junit.jupiter.api.Test
//    public void test1() {
//        FileNameServlet fileName = new FileNameServlet();
//        System.out.println(fileName.checkFileName("aA _-5.,txt"));
//
//
//        System.out.println(fileName.convertFileName("   Hello --  World 123   .   pDf"));
////        String str = " A123-Z-3 ";
////        System.out.println(str);
////        str = str.trim();
////        System.out.println(str);
////        str = str.toLowerCase();
////        System.out.println(str);
////
////        System.out.println(str.replace('-', '_'));
////        System.out.println(str);
//
//    }
//
//
//    @org.junit.jupiter.api.Test
//    public  void test25()  {
//        MacWhoIsDao.inquireOneMacAddress("");
//    }
//    @org.junit.jupiter.api.Test
//    public void test24() {
//        System.out.println("A：" + "A".matches("[^A-F]"));
//        System.out.println("B：" + "B".matches("[^A-F]"));
//        System.out.println("C：" + "C".matches("[^A-F]"));
//        System.out.println("D：" + "D".matches("[^A-F]"));
//        System.out.println("E：" + "E".matches("[^A-F]"));
//        System.out.println("F：" + "F".matches("[^A-F]"));
//        System.out.println("G：" + "G".matches("[^A-F]"));
//        System.out.println("AB：" + "H".matches("[^A-F]"));
//        System.out.println("AW：" + "AW".matches("[^A-F]"));
//        System.out.println("AW：" + "AW".matches("[\\s\\S]*[^A-F0-9\\-: ,][\\s\\S]*"));
//        System.out.println("GA：" + "GA".matches("[\\s\\S]*[^A-F0-9\\-: ,][\\s\\S]*"));
//    }
//
//    @org.junit.jupiter.api.Test
//    public void test23() {
//        String s = StringEscapeUtils.escapeHtml4("a`1234567890-=~!@#$%^&*()_+[]{};':\"\\|,./<>?\b\f\n\r\t\0 " + "qwertyuiopasdfghjklzxcvbnm");
//        s = s.toUpperCase();
//        System.out.println(s);
//        System.out.println(s.matches("[^A-F0-9\\-: ,]"));
//        s = s.replaceAll("[^A-F0-9\\-: ,]", "");
//        System.out.println(s.matches("[^A-F0-9\\-: ,]"));
//        System.out.println(s);
//
//
//    }
//
//    @org.junit.jupiter.api.Test
//    public void test22() {
////        File file = new File("./resources/oui/oui.txt");
////        System.out.println(file.getPath());
////        System.out.println(file.getPath().replaceAll("[\\\\]", "/"));
//////        System.out.println(File.separator);
////        System.out.println(file.exists());
//
//
//        File ouiFile = new OuiFileDao().getOuiFile();
//        System.out.println(ouiFile.getPath());
//        System.out.println(ouiFile.exists());
//
//    }
//
//    @org.junit.jupiter.api.Test
//    public void test21() throws IOException, InterruptedException {
////        File file = new File("./resources/oui/index.md");
////
////        System.out.println(file.lastModified());
////
////        Instant lastModInstant = Instant.ofEpochMilli(file.lastModified());
////        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("_yyyyMMdd_HHmmss");
////        ZoneId zone = ZoneId.systemDefault();
////        String suffix = dateTimeFormatter.format(LocalDateTime.ofInstant(lastModInstant, zone));
////        System.out.println(suffix);
////
////        LocalDateTime nowLDT = LocalDateTime.now();
//////        ZoneId zone = ZoneId.systemDefault();
////        Instant nowLdtInstant = nowLDT.atZone(zone).toInstant();
////        long now = nowLdtInstant.toEpochMilli();
////        System.out.println(now);
//
////        1629295412451
//
//
////        new OuiFileDao().downLoadFromUrl();
//
//        for (int i = 0; i < 5; i++) {
//            Thread.sleep(1000 * 6);
//            System.out.println(i);
//            new OuiFileDao().getOuiFile();
//        }
//
//        Thread.sleep(1000 * 11);
//        new OuiFileDao().getOuiFile();
//
////       new OuiFileDao("http://standards-oui.ieee.org/oui/oui.txt","./resources/","oui5.txt").getOui();
//
//    }
//
//    @org.junit.jupiter.api.Test
//    public void test2() throws IOException {
//
//        // 1.使用参数指定的字符串来构造对象
//        URL url = new URL("http://standards-oui.ieee.org/oui/oui.txt");
//        // 2.获取相关信息并打印出来
//        System.out.println(url.getProtocol());
//        System.out.println(url.getHost());
//        System.out.println(url.getPort());
//        System.out.println(url.getDefaultPort());
//        System.out.println(url.getPath());
//        System.out.println(url.getFile());
//
//        System.out.println(url.getAuthority());
//        System.out.println(url.getContent());
//        System.out.println(url.getQuery());
//        System.out.println(url.getRef());
//        System.out.println(url.getUserInfo());
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
//        System.out.println(simpleDateFormat.format(url.openConnection().getLastModified()));
//
//
//        System.exit(99);
//
//
//        // 3.建立连接并读取相关信息打印出来
//        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        InputStream inputStream = urlConnection.getInputStream();
//        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//        String str = null;
////            while ((str = br.readLine()) != null) {
////                System.out.println(str);
////            }
//
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
//        System.out.println(br.readLine());
//
//
//        br.close();
//        // 断开连接
//        urlConnection.disconnect();
//
//
////        File f1 = new File("http://standards-oui.ieee.org/oui/oui.txt");
//
////        System.out.println(f1.exists());
//    }
}
