package com.bjike.ser.addressBook;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.dto.Restrict;
import com.bjike.dto.addressBook.ActivityMemberDTO;
import com.bjike.dto.addressBook.AllianceActivityDTO;
import com.bjike.entity.addressBook.ActivityMember;
import com.bjike.entity.addressBook.AllianceActivity;
import com.bjike.entity.addressBook.InterestAlliance;
import com.bjike.ser.ServiceImpl;
import com.bjike.to.addressBook.ActivityMemberTO;
import com.bjike.to.addressBook.AllianceActivityTO;
import com.bjike.vo.addressBook.ActivityMemberVO;
import com.bjike.vo.addressBook.AllianceActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void pulbish(String interestAllianceId, AllianceActivityTO to) throws SerException {
        InterestAlliance interestAlliance = interestAllianceSer.findById(interestAllianceId);
        AllianceActivity entity = BeanCopy.copyProperties(to, AllianceActivity.class, true);
        entity.setInterestAlliance(interestAlliance);
        super.save(entity);
    }

    @Override
    public void edit(AllianceActivityTO to) throws SerException {
        AllianceActivity entity = super.findById(to.getId());
        AllianceActivity allianceActivity = BeanCopy.copyProperties(to, AllianceActivity.class, true);
        BeanCopy.copyProperties(allianceActivity, entity, "interestAlliance.id", "id", "createTime","modifyTime");
        super.update(entity);
    }

    @Override
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
    public void attend(String id, ActivityMemberTO activityMemberTO) throws SerException {
        ActivityMember activityMember = BeanCopy.copyProperties(activityMemberTO, ActivityMember.class, true);
        activityMember.setAllianceActivityId(id);
        activityMemberSer.save(activityMember);
    }

    @Override
    public List<ActivityMemberVO> findMembers(String id) throws SerException {
        ActivityMemberDTO dto=new ActivityMemberDTO();
        dto.getConditions().add(Restrict.eq("allianceActivityId",id));
        return BeanCopy.copyProperties(activityMemberSer.findByCis(dto),ActivityMemberVO.class);
    }
}
