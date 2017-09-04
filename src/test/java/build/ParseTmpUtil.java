package build;

import com.bjike.common.util.clazz.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;

/**
 * 生成由模板自动生成
 */
public class ParseTmpUtil {

    private static FileWriter wt = null;
    private static File folder = null;
    private static File file = null;
    private static String proPath = System.getProperty("user.dir") + "/src/main/java/com/bjike/";
    private static String[] tmps = new String[]{"serTmp", "serImplTmp", "dtoTmp", "toTmp", "voTmp", "actTmp", "repTmp", "entityTmp"};

    public static boolean CreatePackageAndClass(String content, String packageName, String className, String type) {
        String folderPath = null;
        String filePath = null;
        try {
            for (String tmp : tmps) {
                if (tmp.equals(type)) {
                    String packages = StringUtils.substringBefore(tmp, "Tmp");
                    if (packages.equalsIgnoreCase("rep")) {
                        packages = "dao";
                    }
                    if (packages.equalsIgnoreCase("serImpl")) {
                        packages = "ser";
                    }
                    folderPath = proPath + packages + "/" + packageName;
                    String clazz = StringUtils.substringBefore(tmp, "Tmp");
                    clazz = StringUtil.upperCaseFirst(clazz);
                    if (clazz.equalsIgnoreCase("to") || clazz.equalsIgnoreCase("vo")
                            || clazz.equalsIgnoreCase("dto")) {
                        clazz = clazz.toUpperCase();
                    } else if (clazz.equalsIgnoreCase("entity")) {
                        clazz = "";
                    }

                    filePath = folderPath + "/" + className + clazz + ".java";
                    break;
                }
            }
            createFile(folderPath, filePath, content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 创建文件或者文件夹
     *
     * @param folderPath
     * @param filePath
     * @param content
     * @throws Exception
     */
    private static void createFile(String folderPath, String filePath, String content) throws Exception {
        folder = new File(folderPath);

        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        }
        file = new File(filePath);
        if (folder.exists() && !file.exists()) {
            file.createNewFile();
        }
        wt = new FileWriter(file);
        wt.write(content);
        wt.close();
    }


}
