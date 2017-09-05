package com.bjike.to.user;

import com.bjike.common.aspect.ADD;
import com.bjike.type.user.SexType;
import org.hibernate.validator.constraints.NotBlank;

/**
 * vip
 *
 * @Author: [liguiqin]
 * @Date: [2017-09-01 14:11]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class VIPApplyTO {
    /**
     * 昵称
     */
    @NotBlank(message = "昵称不能为空!", groups = {ADD.class})
    private String nickname;
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空!", groups = {ADD.class})
    private String phone;
    /**
     * 名字
     */
    @NotBlank(message = "名字不能为空!", groups = {ADD.class})
    private String realName;

    /**
     * 性别
     */
    @NotBlank(message = "性别不能为空!", groups = {ADD.class})
    private SexType sexType;
    /**
     * 性别
     */
    @NotBlank(message = "爱好不能为空!", groups = {ADD.class})
    private String interest;
    /**
     * 地址
     */
    @NotBlank(message = "地址不能为空!", groups = {ADD.class})
    private String address;

    /**
     * 年龄
     */
    private String age;
    /**
     * 性格
     */
    private String disposition;
    /**
     * 籍贯
     */
    private String nativePlace;
    /**
     * 公司
     */
    private String company;
    /**
     * 职位
     */
    private String job;
    /**
     * 学历
     */
    private String education;
    /**
     * 毕业学校
     */
    private String school;
    /**
     * 行业
     */
    private String industry;

    /**
     * 父亲姓名
     */
    private String fatherName;
    /**
     * 母亲姓名
     */
    private String motherName;
    /**
     * 婚姻状况
     */
    private Boolean marriage;
    /**
     * qq
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public SexType getSexType() {
        return sexType;
    }

    public void setSexType(SexType sexType) {
        this.sexType = sexType;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
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

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
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
}
