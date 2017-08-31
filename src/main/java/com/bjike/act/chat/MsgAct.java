package com.bjike.act.chat;

import com.bjike.common.exception.ActException;
import com.bjike.common.exception.SerException;
import com.bjike.common.interceptor.login.LoginAuth;
import com.bjike.common.restful.ActResult;
import com.bjike.common.restful.Result;
import com.bjike.dto.chat.MsgDTO;
import com.bjike.entity.chat.Msg;
import com.bjike.ser.chat.mongo.MsgSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 消息
 *
 * @Author: [liguiqin]
 * @Date: [2017-07-19 13:58]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@LoginAuth
@RestController
@RequestMapping("chat/msg")
public class MsgAct {
    @Autowired
    private MsgSer msgSer;

    /**
     * Point单独聊天消息记录
     *
     * @return class Msg
     * @throws ActException
     */
    @GetMapping("point/{reviver}")
    public Result pointMsg(MsgDTO dto, @PathVariable String reviver, HttpServletRequest request) throws ActException {
        try {
            dto.setReviver(reviver);
            List<Msg> msgs = msgSer.pointMsg(dto);
            return ActResult.initialize(msgs);
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * Group群聊天消息记录
     *
     * @return
     * @throws ActException
     */
    @GetMapping("group/{groupId}")
    public Result groupMsg(MsgDTO dto, @PathVariable String groupId) throws ActException {
        try {
            dto.setGroupId(groupId);
            List<Msg> msgs = msgSer.groupMsg(dto);
            return ActResult.initialize(msgs);
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }


}
