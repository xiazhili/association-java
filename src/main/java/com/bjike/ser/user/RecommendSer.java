package com.bjike.ser.user;

import com.bjike.common.exception.SerException;
import com.bjike.dto.user.RecommendDTO;
import com.bjike.entity.user.Recommend;
import com.bjike.ser.Ser;
import com.bjike.to.user.RecommendTO;
import com.bjike.vo.recommend.RecommendVO;

import java.util.List;

/**
 * 推荐信息业务
 *
 * @Author: [liguiqin]
 * @Date: [2017-08-23 14:20]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface RecommendSer extends Ser<Recommend, RecommendDTO> {

    default String add(RecommendTO to) throws SerException {
        return null;
    }

    /**
     * 我推荐的人
     *
     * @return
     * @throws SerException
     */
    default List<RecommendVO> myRecommends(RecommendDTO dto) throws SerException {
        return null;
    }

    /**
     * 校验邀请码
     * @param code
     * @return
     * @throws SerException
     */
    default Boolean validate(String code) throws SerException {
        return null;
    }

    /**
     * 通过邀请码查询推荐
     * @param code
     * @return
     * @throws SerException
     */
    default Recommend findByInviteCode(String code) throws SerException {
        return null;
    }
    /**
     * 通过用户id查询推荐人
     */
    default Recommend findByUserId(String userId) throws SerException {
        return null;
    }
}
