package com.bjike.ser.addressBook;

import com.bjike.common.exception.SerException;
import com.bjike.dto.addressBook.AllianceActivityDTO;
import com.bjike.entity.addressBook.AllianceActivity;
import com.bjike.ser.Ser;
import com.bjike.to.addressBook.ActivityMemberTO;
import com.bjike.to.addressBook.AllianceActivityTO;
import com.bjike.vo.addressBook.ActivityMemberVO;
import com.bjike.vo.addressBook.AllianceActivityVO;

import java.util.List;

/**
 * @Author: [chenjunhao]
 * @Date: [2017-08-31 10:07]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface AllianceActivitySer extends Ser<AllianceActivity, AllianceActivityDTO> {
    /**
     * 发布活动
     *
     * @param interestAllianceId
     * @param to
     * @throws SerException
     */
    void pulbish(String interestAllianceId, AllianceActivityTO to) throws SerException;

    /**
     * 编辑活动
     *
     * @param to
     * @throws SerException
     */
    void edit(AllianceActivityTO to) throws SerException;

    /**
     * 删除活动
     *
     * @param id
     * @throws SerException
     */
    void delete(String id) throws SerException;

    /**
     * 查看某联盟的所有活动
     *
     * @param interestAllianceId
     * @return
     * @throws SerException
     */
    List<AllianceActivityVO> list(String interestAllianceId) throws SerException;

    /**
     * 我要报名
     *
     * @param id
     * @throws SerException
     */
    void attend(String id, ActivityMemberTO activityMemberTO) throws SerException;

    /**
     * 查找某活动的所有成员
     *
     * @param id
     * @return
     * @throws SerException
     */
    List<ActivityMemberVO> findMembers(String id) throws SerException;
}
