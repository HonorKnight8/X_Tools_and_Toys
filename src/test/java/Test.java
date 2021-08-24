import monster.helloworld.mac_who_is.Constant;
import monster.helloworld.mac_who_is.OuiFileBean;
import monster.helloworld.mac_who_is.OuiFileDao;

import java.io.*;


public class Test {

//    @org.junit.jupiter.api.Test
//    public void test32(){
//        System.out.println(Constant.test);
//
//        System.out.println(new OuiFileDao().getLastModifiedTime());
//        File ouiFile = OuiFileBean.getOuiFile(new File(this.getClass().getResource("/").getPath()));
//        System.out.println(ouiFile.getParentFile());
//    }


//    @org.junit.jupiter.api.Test
//    public void test31(){
//        System.out.println("1 " + System.getProperty("file.separator"));
//        System.out.println("2 " + System.getProperty("java.class.path"));
//        System.out.println("3 " + System.getProperty("java.home"));
//        System.out.println("4 " + System.getProperty("java.vendor"));
//        System.out.println("5 " + System.getProperty("java.vendor.url"));
//        System.out.println("6 " + System.getProperty("java.version"));
//        System.out.println("7 " + System.getProperty("line.separator"));
//        System.out.println("8 " + System.getProperty("os.arch"));
//        System.out.println("9 " + System.getProperty("os.name"));
//        System.out.println("10 " + System.getProperty("os.version"));
//        System.out.println("11 " + System.getProperty("path.separator"));
//        System.out.println("12 " + System.getProperty("user.dir"));
//        System.out.println("13 " + System.getProperty("user.home"));
//        System.out.println("14 " + System.getProperty("user.name"));
//
//        //"file.separator"    Character that separates components of a file path. This is "/" on UNIX and "\" on Windows.
//        //"java.class.path"	Path used to find directories and JAR archives containing class files. Elements of the class path are separated by a platform-specific character specified in the path.separator property.
//        //"java.home"	Installation directory for Java Runtime Environment (JRE)
//        //"java.vendor"	JRE vendor name
//        //"java.vendor.url"	JRE vendor URL
//        //"java.version"	JRE version number
//        //"line.separator"	Sequence used by operating system to separate lines in text files
//        //"os.arch"	Operating system architecture
//        //"os.name"	Operating system name
//        //"os.version"	Operating system version
//        //"path.separator"	Path separator character used in java.class.path
//        //"user.dir"	User working directory
//        //"user.home"	User home directory
//        //"user.name"
//    }


//    @org.junit.jupiter.api.Test
//    public void test30(){
//        System.out.println(new File(this.getClass().getResource("/").getPath()));
//        File file = OuiFileBean.getOuiFile(new File(this.getClass().getResource("/").getPath()));
//        System.out.println(file);
//        System.out.println(file.lastModified());
//        System.out.println(file.exists());
//    }

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

//        for (int i = 0; i < 5; i++) {
//            Thread.sleep(1000 * 6);
//            System.out.println(i);
//            new OuiFileDao().getOuiFile();
//        }
//
//        Thread.sleep(1000 * 11);
//        new OuiFileDao().getOuiFile();

//       new OuiFileDao("http://standards-oui.ieee.org/oui/oui.txt","./resources/","oui5.txt").getOui();

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
