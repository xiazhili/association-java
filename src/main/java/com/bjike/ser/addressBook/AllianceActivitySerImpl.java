package com.bjike.ser.addressBook;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.UserUtil;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.dto.Restrict;
import com.bjike.dto.addressBook.ActivityMemberDTO;
import com.bjike.dto.addressBook.AllianceActivityDTO;
import com.bjike.entity.addressBook.ActivityMember;
import com.bjike.entity.addressBook.AllianceActivity;
import com.bjike.entity.addressBook.InterestAlliance;
import com.bjike.entity.user.User;
import com.bjike.ser.ServiceImpl;
import com.bjike.ser.activity.ActivityCommentSer;
import com.bjike.to.addressBook.ActivityMemberTO;
import com.bjike.to.addressBook.AllianceActivityTO;
import com.bjike.vo.activity.ActivityCommentVO;
import com.bjike.vo.activity.ActivityDetailVO;
import com.bjike.vo.addressBook.ActivityMemberVO;
import com.bjike.vo.addressBook.AllianceActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: [chenjunhao]
 * @Date: [2017-08-31 10:09]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class AllianceActivitySerImpl extends ServiceImpl<AllianceActivity, AllianceActivityDTO> implements AllianceActivitySer {
    @Autowired
    private ActivityMemberSer activityMemberSer;
    @Autowired
    private InterestAllianceSer interestAllianceSer;
    @Autowired
    private ActivityCommentSer activityCommentSer;

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void pulbish(String interestAllianceId, AllianceActivityTO to) throws SerException {
        String name= UserUtil.currentUser().getUsername();
        InterestAlliance interestAlliance = interestAllianceSer.findById(interestAllianceId);
        AllianceActivity entity = BeanCopy.copyProperties(to, AllianceActivity.class, true);
        entity.setInterestAlliance(interestAlliance);
        entity.setPulbisher(name);
        super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void edit(AllianceActivityTO to) throws SerException {
        AllianceActivity entity = super.findById(to.getId());
        AllianceActivity allianceActivity = BeanCopy.copyProperties(to, AllianceActivity.class, true);
        BeanCopy.copyProperties(allianceActivity, entity, "interestAlliance.id", "id", "createTime","modifyTime","release");
        super.update(entity);
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void delete(String id) throws SerException {
        ActivityMemberDTO dto = new ActivityMemberDTO();
        dto.getConditions().add(Restrict.eq("allianceActivityId", id));
        List<ActivityMember> members = activityMemberSer.findByCis(dto);
        activityMemberSer.remove(members);
        super.remove(id);
    }

    @Override
    public List<AllianceActivityVO> list(String interestAllianceId) throws SerException {
        AllianceActivityDTO dto = new AllianceActivityDTO();
        dto.getConditions().add(Restrict.eq("interestAlliance.id", interestAllianceId));
        List<AllianceActivity> list = super.findByCis(dto);
        List<AllianceActivityVO> vos = new ArrayList<>();
        for (AllianceActivity activity : list) {
            AllianceActivityVO vo=BeanCopy.copyProperties(activity,AllianceActivityVO.class);
            int num=activity.getNum();
            ActivityMemberDTO activityMemberDTO=new ActivityMemberDTO();
            activityMemberDTO.getConditions().add(Restrict.eq("allianceActivityId",activity.getId()));
            String count=activityMemberSer.count(activityMemberDTO)+"";
            int attend=Integer.valueOf(count);
            int remain=num-attend;
            vo.setAttend(attend);
            vo.setRemain(remain);
            vos.add(vo);
        }
        return vos;
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void attend(String id, ActivityMemberTO activityMemberTO) throws SerException {
        User user=UserUtil.currentUser();
        Integer num=super.findById(id).getNum();
        ActivityMemberDTO dto=new ActivityMemberDTO();
        dto.getConditions().add(Restrict.eq("allianceActivityId",id));
        String count=activityMemberSer.count(dto)+"";
        if (num-Integer.valueOf(count)<=0){
            throw new SerException("该活动参与人数已满，下次请早");
        }
        dto.getConditions().add(Restrict.eq("userId",user.getId()));
        ActivityMember member=activityMemberSer.findOne(dto);
        if (null!=member){
            throw new SerException("您已参与该活动了");
        }
        ActivityMember activityMember = BeanCopy.copyProperties(activityMemberTO, ActivityMember.class, true);
        activityMember.setAllianceActivityId(id);
        activityMember.setUserId(user.getId());
        activityMember.setName(user.getUsername());
        activityMemberSer.save(activityMember);
    }

    @Override
    public List<ActivityMemberVO> findMembers(String id) throws SerException {
        ActivityMemberDTO dto=new ActivityMemberDTO();
        dto.getConditions().add(Restrict.eq("allianceActivityId",id));
        return BeanCopy.copyProperties(activityMemberSer.findByCis(dto),ActivityMemberVO.class);
    }

    @Override
    public ActivityDetailVO detail(String id) throws SerException {
        AllianceActivity activity=super.findById(id);
        ActivityDetailVO vo=BeanCopy.copyProperties(activity,ActivityDetailVO.class);
        int num=activity.getNum();
        ActivityMemberDTO activityMemberDTO=new ActivityMemberDTO();
        activityMemberDTO.getConditions().add(Restrict.eq("allianceActivityId",id));
        String count=activityMemberSer.count(activityMemberDTO)+"";
        int attend=Integer.valueOf(count);
        int remain=num-attend;
        vo.setAttend(attend);
        vo.setRemain(remain);
        List<ActivityMemberVO> memberVOS=findMembers(id);
        vo.setMemberVOS(memberVOS);
        List<ActivityCommentVO> commentVOS=activityCommentSer.comments(id);
        vo.setCommentVOS(commentVOS);
        vo.setCommentNum(activityCommentSer.commentNum(id));
        return vo;
    }
}
