package monster.helloworld.mac_who_is;

import java.io.File;

public class OuiFileBean {

    private static File ouiFile = null;

    public static File getOuiFile(File classLoadRoot) {
        // 将工程运行时的 java 类根目录作为参数传入
        // File classLoadRoot = new File(this.getClass().getResource("/").getPath());
        System.out.println(Constant.OUI_TTL + "|" + Constant.SOURCE_URL);
        if (ouiFile == null) {
            if (!Constant.IS_LOCAL_TEST_ENV) {
                // war 部署至 Linux 环境
                String ouiPath = classLoadRoot + System.getProperty("file.separator") + Constant.SAVE_PATH + System.getProperty("file.separator") + Constant.FILE_NAME;
                ouiFile = new File(ouiPath);
            } else {
                // 本地 Win + IDEA 开发环境
                ouiFile = new File("D:\\test\\macwi0824\\oui.txt");
            }
        }
        return ouiFile;
    }

}
