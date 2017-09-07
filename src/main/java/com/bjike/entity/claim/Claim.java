package com.bjike.entity.claim;

import com.bjike.entity.BaseEntity;
import com.bjike.entity.user.User;
import com.bjike.type.claim.RelationType;
import com.bjike.type.user.SexType;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

/**
 * @Author: [xiazhili]
 * @Date: [2017-08-29 14:58]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Entity
@Table(name = "claim")
public class Claim extends BaseEntity {
    /**
     * 姓名
     */
    @Column(columnDefinition = "VARCHAR(30) COMMENT '姓名' ", nullable = false)
    private String name;
    /**
     * 电话
     */
    @Column(columnDefinition = "VARCHAR(11) COMMENT '电话' ", nullable = false, unique = true)
    private String phone;
    /**
     * 性别
     */
    @Column(columnDefinition = "TINYINT(1)  COMMENT '性别' ", nullable = false)
    private SexType sexType;
    /**
     * 爱好
     */
    @Column(columnDefinition = "VARCHAR(256) COMMENT '爱好' ", nullable = false)
    private String hobby;
    /**
     * 地址
     */
    @Column(columnDefinition = "VARCHAR(256) COMMENT '地址' ", nullable = false)
    private String address;
    /**
     * 关系
     */
    @Column(columnDefinition = "TINYINT(1)  COMMENT '关系' ", nullable = false)
    private RelationType relationType;
    /**
     * 信誉分
     */
    @Column(columnDefinition = "DECIMAL(3,2) COMMENT '信誉分'")
    private Double reputation;
    /**
     * 生日
     */
    @Column(columnDefinition = "VARCHAR(100) COMMENT '生日' ")
    private String birthday;
    /**
     * 籍贯
     */
    @Column(columnDefinition = "VARCHAR(100) COMMENT '籍贯' ")
    private String nativePlace;
    /**
     * 性格
     */
    @Column(columnDefinition = "VARCHAR(256) COMMENT '性格' ")
    private String disposition;
    /**
     * 行业
     */
    @Column(columnDefinition = "VARCHAR(256) COMMENT '行业' ")
    private String industry;
    /**
     * 公司名称
     */
    @Column(columnDefinition = "VARCHAR(100) COMMENT '公司名称' ")
    private String company;
    /**
     * 职位
     */
    @Column(columnDefinition = "VARCHAR(100) COMMENT '职位' ")
    private String job;
    /**
     * 毕业学校
     */
    @Column(columnDefinition = "VARCHAR(100) COMMENT '毕业学校' ")
    private String school;
    /**
     * 学历
     */
    @Column(columnDefinition = "VARCHAR(50) COMMENT '学历' ")
    private String education;
    /**
     * 父亲
     */
    @Column(columnDefinition = "VARCHAR(30) COMMENT '父亲' ")
    private String fatherName;
    /**
     * 母亲
     */
    @Column(columnDefinition = "VARCHAR(30) COMMENT '母亲' ")
    private String motherName;
    /**
     * 婚姻状况
     */
    @Column(name = "is_expired", columnDefinition = "TINYINT(1)  COMMENT '婚姻状况'")
    private Boolean marriage;
    /**
     * 邮箱
     */
    @Column(columnDefinition = "VARCHAR(30) COMMENT '邮箱' ")
    @Email
    private String email;
    /**
     * 微信
     */
    @Column(columnDefinition = "VARCHAR(30) COMMENT '微信' ")
    private String weChat;
    /**
     * QQ
     */
    @Column(columnDefinition = "VARCHAR(30) COMMENT 'QQ' ")
    private String qq;
    /**
     * 用户
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", unique = true, columnDefinition = "VARCHAR(36) COMMENT '用户id' ", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
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
