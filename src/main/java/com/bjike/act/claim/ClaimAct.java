package com.bjike.act.claim;

import com.bjike.common.aspect.ADD;
import com.bjike.common.aspect.EDIT;
import com.bjike.common.exception.ActException;
import com.bjike.common.exception.SerException;
import com.bjike.common.interceptor.login.LoginAuth;
import com.bjike.common.restful.ActResult;
import com.bjike.common.restful.Result;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.dto.claim.ClaimDTO;
import com.bjike.dto.user.UserDTO;
import com.bjike.entity.claim.Claim;
import com.bjike.ser.claim.ClaimSer;
import com.bjike.to.claim.ClaimTO;
import com.bjike.vo.claim.ClaimCenterVO;
import com.bjike.vo.claim.ClaimVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 认领中心
 *
 * @Author: [xiazhili]
 * @Date: [2017-08-30 13:58]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@LoginAuth //登录验证注解,header必须携带token
@RestController
@RequestMapping("claim")
public class ClaimAct {

    @Autowired
    private ClaimSer claimSer;

    /**
     * 一个认领
     *
     * @param id id
     * @return class ClaimCenterVO
     * @throws ActException
     * @version v1
     */
    @GetMapping("claim/{id}")
    public Result claim(@PathVariable String id) throws ActException {
        try {
            return ActResult.initialize(claimSer.getId(id));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 认领中心
     *
     * @param dto
     * @return class ClaimCenterVO
     * @throws ActException
     * @version v1
     */
    @GetMapping("list")
    public Result list(UserDTO dto) throws ActException {
        try {
            return ActResult.initialize(claimSer.list(dto));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 我的认领
     *
     * @return class ClaimVO
     * @throws ActException
     * @version v1
     */
    @GetMapping("getClaim")
    public Result getClaim(ClaimDTO dto) throws ActException {
        try {
            List<ClaimVO> list = claimSer.getClaim(dto);
            return ActResult.initialize(BeanCopy.copyProperties(list, ClaimVO.class));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 认领信息
     *
     * @throws ActException
     * @version v1
     */

    @PostMapping("save")
    public Result save(@Validated(ADD.class) ClaimTO to) throws ActException {
        try {
            return ActResult.initialize(claimSer.save(to));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }

    }
    /**
     * 认领列表(取前三条)
     *
     * @param dto
     * @return class ClaimCenterVO
     * @throws ActException
     * @version v1
     */
    @GetMapping("claimList")
    public Result claimList(UserDTO dto) throws ActException {
        try {
            List<ClaimCenterVO>vos = claimSer.claimList(dto);
            return ActResult.initialize(vos);
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }
    /**
     * 强制担保
     *
     * @return class Claim
     * @throws ActException
     * @version v1
     */

    @PostMapping("vouch")
    public Result vouch(Double num) throws ActException {
        try {
            return ActResult.initialize(claimSer.vouch(num));
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }

    }

}
