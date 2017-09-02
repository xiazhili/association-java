package build;

import com.bjike.common.util.clazz.StringUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 构建
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class Build {


    private static Map<String, String> CUS = new HashMap<>(4);
    private String className = null;
    private String packageName = null;
    private List<Model> models = new ArrayList<>(); //保存类属性列表

    static {
        CUS.put("包名", "");
        CUS.put("类名", "");
        CUS.put("作者", "");
        CUS.put("描述", "");

    }

    /**
     * 构建文件
     *
     * @throws Exception
     */
    @Test
    public void createFile() throws Exception {
        create();
        // delete();
        System.out.println("构建生成文件成功！");
    }

    /**
     * 创建文件
     *
     * @throws Exception
     */
    private void create() throws Exception {

        //获取输入文件路径
        String inputPath = System.getProperty("user.dir") + "/src/test/java/build/input.txt";
        String fieldsString = null;
        Template entityTmp = loadTmp("entityTmp.jtm");
        List<String> lines = FileUtils.readLines(new File(inputPath),
                "utf-8");
        //创建entity java 文件
        fieldsString = createDetails(lines, entityTmp);
        String details[] = fieldsString.split(";");
        createField(details, entityTmp);
        ParseTmpUtil.CreatePackageAndClass(entityTmp.render(), packageName, className, "entityTmp");
        String[] templates = new String[]{"serTmp", "serImplTmp", "dtoTmp", "toTmp", "voTmp", "actTmp", "repTmp"};
        //创建java 文件
        for (String tmp : templates) {
            Template template = loadTmp(tmp + ".jtm");
            createDetails(lines, template);
            if (tmp.equals("toTmp") || tmp.equals("voTmp")) {
                createField(details, template);
            }
            ParseTmpUtil.CreatePackageAndClass(template.render(), packageName, className, tmp);
        }
    }

    /**
     * 删除文件
     *
     * @throws Exception
     */
    private void delete() throws Exception {
        String root = System.getProperty("user.dir") + "/src/main/java/com/bjike/";
        String inputPath = System.getProperty("user.dir") + "/src/test/java/build/input.txt";
        List<String> lines = FileUtils.readLines(new File(inputPath), "utf-8");
        String packages = StringUtils.substringAfter(lines.get(0), ":");
        String[] templates = new String[]{"ser", "dto", "to", "vo", "act", "rep"};
        for (String m : templates)
            FileUtils.deleteDirectory(new File(root + "/" + packages + "/" + m));
    }

    /**
     * 构建属性
     */
    private void createField(String[] details, Template modelTmp) {
        Model m = null;
        models.removeAll(models);
        for (String str : details) {
            m = new Model();
            String type = str.split(" ")[0];
            String name = str.split(" ")[1];
            String[] annotation = str.split(" ");
            if (annotation.length > 2) {
                m.setAnnotation(annotation[2]);
            }
            m.setSwapCaseName(name.substring(0, 1).toUpperCase() + name.substring(1));
            m.setType(type);
            m.setFieldName(name);
            models.add(m);
        }
        modelTmp.binding("list", models);
    }

    /**
     * 加载模板
     */
    private Template loadTmp(String fileName) {
        String root = System.getProperty("user.dir") + "/src/test/java/build/template/";

        FileResourceLoader resourceLoader = new FileResourceLoader(root, "utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        return gt.getTemplate(fileName);
    }

    /**
     * 构建类描述
     */
    private String createDetails(List<String> lines, Template modelTmp) {
        for (String line : lines) {
            String[] ls = line.split(":");
            if (ls.length == 2) {
                switch (ls[0]) {
                    case "包名":
                        CUS.put("包名", line.split(":")[1]);
                        break;
                    case "类名":
                        CUS.put("类名", line.split(":")[1]);
                        break;
                    case "作者":
                        CUS.put("作者", line.split(":")[1]);
                        break;
                    case "描述":
                        CUS.put("描述", line.split(":")[1]);
                        break;
                    default:
                        break;
                }
            }
        }

        StringBuilder fieldsString = new StringBuilder();
        boolean fieldBegin = false;
        for (String line : lines) {
            if ("(".equals(line)) {
                fieldBegin = true;
                continue;
            }
            if (")".equals(line)) {
                break;
            }
            if (fieldBegin) {
                fieldsString.append(line);
            }
        }

        String strTmp = CUS.toString();
        String desc[] = strTmp.substring(1, strTmp.toString().length() - 1).split(",");
        for (int i = 0; i < desc.length; i++) {
            switch (i) {
                case 0:
                    packageName = desc[i].split("=")[1];
                    String[] packageNames = packageName.split("\\.");
                    int length = packageNames.length;
                    if (0 < length) {
                        packageName = "";
                        for (int j = 0; j < length; j++) {
                            packageName = packageName + "/" + packageNames[j];
                        }
                    } else {
                        packageName = "/" + packageName;
                    }
                    modelTmp.binding("package", packageName.replace('/', '.').substring(1));
                    break;
                case 1:
                    modelTmp.binding("author", desc[i].split("=")[1]);
                    break;
                case 2:
                    className = desc[i].split("=")[1];
                    modelTmp.binding("clazz", className);
                    modelTmp.binding("lowClazz", StringUtil.lowerCaseFirst(className));
                    break;
                case 3:
                    modelTmp.binding("des", desc[i].split("=")[1]);
                    break;
                default:
                    break;
            }
        }
        return fieldsString.toString();
    }

}

