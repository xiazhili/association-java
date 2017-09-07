package com.bjike.to.claim;

import com.bjike.common.aspect.ADD;
import com.bjike.to.BaseTO;
import com.bjike.type.claim.RelationType;
import com.bjike.type.user.SexType;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @Author: [xiazhili]
 * @Date: [2017-08-29 15:55]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class ClaimTO extends BaseTO {
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空", groups = {ADD.class})
    private String name;
    /**
     * 电话
     */
    @NotBlank(message = "电话不能为空", groups = {ADD.class})
    private String phone;
    /**
     * 性别
     */
    @NotNull(message = "性别不能为空", groups = {ADD.class})
    private SexType sexType;
    /**
     * 爱好
     */
    @NotBlank(message = "爱好不能为空", groups = {ADD.class})
    private String hobby;
    /**
     * 地址
     */
    @NotBlank(message = "地址不能为空", groups = {ADD.class})
    private String address;
    /**
     * 关系
     */
    @NotNull(message = "关系不能为空", groups = {ADD.class})
    private RelationType relationType;
    /**
     * 信誉值
     */
    @NotNull(message = "信誉值不能为空", groups = {ADD.class})
    private Double reputation;

    /**
     * 生日
     */
    private String birthday;
    /**
     * 性格
     */
    private String disposition;
    /**
     * 籍贯
     */
    private String nativePlace;
    /**
     * 毕业学校
     */
    private String school;
    /**
     * 学历
     */
    private String education;
    /**
     * 公司名称
     */
    private String company;
    /**
     * 职位
     */
    private String job;
    /**
     * 父亲
     */
    private String fatherName;
    /**
     * 母亲
     */
    private String motherName;
    /**
     * 婚姻状况
     */
    private Boolean marriage;
    /**
     * QQ
     */
    private String qq;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 微信
     */
    private String weChat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SexType getSexType() {
        return sexType;
    }

    public void setSexType(SexType sexType) {
        this.sexType = sexType;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    public Double getReputation() {
        return reputation;
    }

    public void setReputation(Double reputation) {
        this.reputation = reputation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Boolean getMarriage() {
        return marriage;
    }

    public void setMarriage(Boolean marriage) {
        this.marriage = marriage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
