package com.bjike.ser.claim;

import com.bjike.common.exception.SerException;
import com.bjike.dto.claim.ClaimDTO;
import com.bjike.dto.user.UserDTO;
import com.bjike.entity.claim.Claim;
import com.bjike.ser.Ser;
import com.bjike.to.claim.ClaimTO;
import com.bjike.vo.claim.ClaimCenterVO;
import com.bjike.vo.claim.ClaimVO;

import java.util.List;

/**
 * @Author: [xiazhili]
 * @Date: [2017-08-29 10:55]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface ClaimSer extends Ser<Claim, ClaimDTO> {
    /**
     * 申请认领
     *
     * @param to to
     * @throws SerException
     */
    default void applyClaim(ClaimTO to) throws SerException {
    }
    /**
     * 一个认领
     *
     * @param id
     * @throws SerException
     */
    default ClaimCenterVO getId(String id) throws SerException {
        return null;
    }

    /**
     * 认领中心
     *
     * @param dto
     * @throws SerException
     */
    default List<ClaimCenterVO> list(UserDTO dto) throws SerException {
        return null;
    }

    /**
     * 我要认领
     *
     * @param to
     * @throws SerException
     */
    default String save(ClaimTO to) throws SerException {
        return null;
    }

    /**
     * 我的认领
     *
     * @param dto
     * @throws SerException
     */
    default List<ClaimVO> getClaim(ClaimDTO dto) throws SerException {
        return null;
    }
    /**
     * 强制担保
     *
     * @param
     * @throws SerException
     */
    default List<Claim> vouch(double num) throws SerException {
        return null;
    }
    /**
     * 认领列表
     *
     * @param
     * @throws SerException
     */
    default List<ClaimCenterVO> claimList(UserDTO dto) throws SerException {
        return null;
    }

    /**
     * 消息
     *
     * @throws SerException
     */
    default String message() throws SerException {
        return null;
    }


}
