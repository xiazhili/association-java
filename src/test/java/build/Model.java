package build;

/**
 * 构建工具类模板
 */
public class Model {

    String swapCaseName;//开头自字母大写的类名
    String type; //属性类型
    String fieldName;//属性名称
    String annotation;//字段描述

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSwapCaseName() {
        return swapCaseName;
    }

    public void setSwapCaseName(String swapCaseName) {
        this.swapCaseName = swapCaseName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }


}
