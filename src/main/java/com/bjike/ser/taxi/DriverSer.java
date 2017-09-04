package com.bjike.ser.taxi;

import com.bjike.common.exception.SerException;
import com.bjike.dto.taxi.DriverDTO;
import com.bjike.entity.taxi.Driver;
import com.bjike.ser.Ser;
import com.bjike.to.taxi.DriverTO;
import com.bjike.type.taxi.VerifyType;
import com.bjike.vo.taxi.DriverVO;

import java.io.File;
import java.util.List;

/**
 * 司机信息操作
 *
 * @Author: [liguiqin]
 * @Date: [2017-09-02 09:32]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface DriverSer extends Ser<Driver, DriverDTO> {
    /**
     * 申请
     * @param to 申请实体
     * @param files
     * @return
     * @throws SerException
     */
    default Boolean apply(DriverTO to, List<File> files) throws SerException {
        return null;

    }

    /**
     * 上传司机图片
     * @param files
     * @return
     * @throws SerException
     */
    default Boolean imgUpload( List<File> files) throws SerException {
        return null;
    }

    /**
     * 同意
     * @param id 申请司机id
     * @return
     * @throws SerException
     */
    default Boolean agree(String id) throws SerException {
        return null;
    }

    /**
     * 查找用户申请信息
     * @param userId 用户id
     * @return
     * @throws SerException
     */
    default DriverVO findByUserId(String userId) throws SerException {
        return null;
    }


    /**
     * 查找用户申请信息
     * @param verifyType 审核状态
     * @return
     * @throws SerException
     */
    default List<DriverVO> list(VerifyType verifyType,  DriverDTO dto) throws SerException {
        return null;
    }

}
