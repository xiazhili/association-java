package com.bjike.ser.addressBook;

import com.bjike.common.exception.SerException;
import com.bjike.dto.addressBook.InterestAllianceDTO;
import com.bjike.entity.addressBook.InterestAlliance;
import com.bjike.ser.Ser;
import com.bjike.to.addressBook.InterestAllianceTO;
import com.bjike.vo.addressBook.InterestAllianceVO;
import com.bjike.vo.user.UserVO;

import java.util.List;

/**
 * 兴趣联盟
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-30 14:16]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface InterestAllianceSer extends Ser<InterestAlliance, InterestAllianceDTO> {
    /**
     * 创建联盟
     *
     * @param to
     * @throws SerException
     */
    void add(InterestAllianceTO to) throws SerException;

    /**
     * 编辑联盟
     *
     * @param to
     * @throws SerException
     */
    void edit(InterestAllianceTO to) throws SerException;

    /**
     * 删除
     *
     * @param id
     * @throws SerException
     */
    void delete(String id) throws SerException;

    /**
     * 添加成员
     *
     * @param to
     * @throws SerException
     */
    void addMember(InterestAllianceTO to) throws SerException;

    /**
     * 删除成员
     *
     * @param to
     * @throws SerException
     */
    void delMemeber(InterestAllianceTO to) throws SerException;

    /**
     * 申请加入联盟
     *
     * @param id
     * @throws SerException
     */
    void Apply(String id) throws SerException;

    /**
     * 同意加入联盟
     *
     * @param id
     * @param userId
     * @throws SerException
     */
    void agree(String id, String userId) throws SerException;

    /**
     * 拒绝加入联盟
     *
     * @param id
     * @param userId
     * @throws SerException
     */
    void refuse(String id, String userId) throws SerException;

    /**
     * 通过爱好标签查找兴趣联盟
     *
     * @param tag
     * @return
     * @throws SerException
     */
    List<InterestAllianceVO> findByTag(String tag) throws SerException;

    /**
     * 查找当前用户的所有兴趣联盟
     *
     * @return
     * @throws SerException
     */
    List<InterestAllianceVO> userAll() throws SerException;

    /**
     * 查找某联盟的所有成员
     *
     * @param id
     * @return
     * @throws SerException
     */
    List<UserVO> findMembers(String id) throws SerException;
}
