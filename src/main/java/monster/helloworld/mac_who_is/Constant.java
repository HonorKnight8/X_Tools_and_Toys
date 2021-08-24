package monster.helloworld.mac_who_is;

public class Constant {
    // 本地测试环境标记(win + IDEA)
//    public static final Boolean IS_LOCAL_TEST_ENV = true;
    public static final Boolean IS_LOCAL_TEST_ENV = false;

    public static final String SAVE_PATH = "oui";
    public static final String FILE_NAME = "oui.txt";

    // oui 文件下载地址
    public static final String SOURCE_URL = IS_LOCAL_TEST_ENV?"http://10.10.10.20/oui.txt":"http://standards-oui.ieee.org/oui/oui.txt";
//    public static final String SOURCE_URL = "http://standards-oui.ieee.org/oui/oui.txt"; // 正式环境
//    public static final String SOURCE_URL = "http://10.10.10.20/oui.txt"; // 测试环境

    // oui 文件过期时间（更新间隔）
    public static final long OUI_TTL = IS_LOCAL_TEST_ENV?(1000 * 10):(1000 * 3600 * 24 * 7);
//     public static final long OUI_TTL = 1000 * 3600 * 24 * 7; // 7天，正式环境
//     public static final long OUI_TTL = 1000 * 3600; // 1小时，测试环境1
//     public static final long OUI_TTL = 1000 * 10; // 10秒，测试环境2
}
