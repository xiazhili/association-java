package com.bjike.act.friend;

import com.bjike.common.exception.ActException;
import com.bjike.common.exception.SerException;
import com.bjike.common.interceptor.login.LoginAuth;
import com.bjike.common.restful.ActResult;
import com.bjike.common.restful.Result;
import com.bjike.ser.user.RelationshipSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台找人
 *
 * @Author: [liguiqin]
 * @Date: [2017-06-27 16:29]
 * @Description: [后台找人 ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@RequestMapping("friend")
@RestController
@LoginAuth
public class RelationshipAct {
    @Autowired
    private RelationshipSer relationshipSer;

    /**
     * 后台找人
     * @version v1
     * @param name 昵称
     */
    @RequestMapping("chain/{name}")
    public Result search(@PathVariable String name) throws ActException {
        try {
            return ActResult.initialize(relationshipSer.search(name));

        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

}
