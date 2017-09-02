package com.bjike.ser.addressBook;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.UserUtil;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.dto.Restrict;
import com.bjike.dto.addressBook.AllianceActivityDTO;
import com.bjike.dto.addressBook.AllianceMemberDTO;
import com.bjike.dto.addressBook.InterestAllianceDTO;
import com.bjike.dto.user.UserInfoDTO;
import com.bjike.entity.addressBook.AllianceActivity;
import com.bjike.entity.addressBook.AllianceMember;
import com.bjike.entity.addressBook.InterestAlliance;
import com.bjike.entity.user.User;
import com.bjike.entity.user.UserInfo;
import com.bjike.ser.ServiceImpl;
import com.bjike.ser.user.UserInfoSer;
import com.bjike.ser.user.UserSer;
import com.bjike.to.addressBook.InterestAllianceTO;
import com.bjike.type.user.UserType;
import com.bjike.vo.addressBook.InterestAllianceVO;
import com.bjike.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 兴趣联盟
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-30 14:51]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class InterestAllianceSerImpl extends ServiceImpl<InterestAlliance, InterestAllianceDTO> implements InterestAllianceSer {
    @Autowired
    private AllianceMemberSer allianceMemberSer;
    @Autowired
    private UserSer userSer;
    @Autowired
    private UserInfoSer userInfoSer;
    @Autowired
    private AllianceActivitySer allianceActivitySer;

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void add(InterestAllianceTO to) throws SerException {
        User user = UserUtil.currentUser();
        if (!UserType.PERSONAL_VIP.equals(user.getUserType())) {
            throw new SerException("您不是vip，不能创建联盟");
        }
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.getConditions().add(Restrict.eq("user.id", user.getId()));
        UserInfo userInfo = userInfoSer.findOne(userInfoDTO);
        if (null != userInfo) {
            if (null != userInfo.getReputation()) {
                if (userInfo.getReputation() < 200) {
                    throw new SerException("对不起，您的信誉值不足200不可创建新兴趣组");
                }
            }
        }
        InterestAlliance interestAlliance = BeanCopy.copyProperties(to, InterestAlliance.class, true);
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            sb.append(random.nextInt(9) + 1);
        }
        interestAlliance.setNumber(sb.toString());
        interestAlliance.setUserId(user.getId());
        super.save(interestAlliance);
        AllianceMember entity = new AllianceMember();
        entity.setInterestAlliance(interestAlliance);
        entity.setUserId(user.getId());
        allianceMemberSer.save(entity);
        List<String> userIds = to.getUserIds();
        if (null != userIds) {
            for (String id : userIds) {
                AllianceMemberDTO allianceMemberDTO = new AllianceMemberDTO();
                allianceMemberDTO.getConditions().add(Restrict.eq("interestAlliance.id", interestAlliance.getId()));
                allianceMemberDTO.getConditions().add(Restrict.eq("userId", id));
                AllianceMember allianceMember = allianceMemberSer.findOne(allianceMemberDTO);
                if (null != allianceMember) {
                    throw new SerException(userSer.findById(id).getUsername() + "已存在该联盟");
                }
                AllianceMember member = new AllianceMember();
                member.setInterestAlliance(interestAlliance);
                member.setUserId(id);
                allianceMemberSer.save(member);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void edit(InterestAllianceTO to) throws SerException {
        InterestAlliance entity = super.findById(to.getId());
        InterestAlliance interestAlliance = BeanCopy.copyProperties(to, InterestAlliance.class, true);
        BeanCopy.copyProperties(interestAlliance, entity, "userId", "id", "number","createTime","modifyTime");
        entity.setModifyTime(LocalDateTime.now());
        super.update(entity);
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void delete(String id) throws SerException {
        AllianceMemberDTO dto = new AllianceMemberDTO();
        dto.getConditions().add(Restrict.eq("interestAlliance.id", id));
        List<AllianceMember> members = allianceMemberSer.findByCis(dto);
        allianceMemberSer.remove(members);
        AllianceActivityDTO activityDTO = new AllianceActivityDTO();
        activityDTO.getConditions().add(Restrict.eq("interestAlliance.id", id));
        List<AllianceActivity> activities = allianceActivitySer.findByCis(activityDTO);
        allianceActivitySer.remove(activities);
        super.remove(id);
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void addMember(InterestAllianceTO to) throws SerException {
        String id = to.getId();
        List<String> userIds = to.getUserIds();
        InterestAlliance entity = super.findById(id);
        for (String userId : userIds) {
            AllianceMemberDTO dto = new AllianceMemberDTO();
            dto.getConditions().add(Restrict.eq("interestAlliance.id", id));
            dto.getConditions().add(Restrict.eq("userId", userId));
            AllianceMember member = allianceMemberSer.findOne(dto);
            if (null != member) {
                throw new SerException(userSer.findById(userId).getUsername() + "已存在该联盟");
            }
            AllianceMember allianceMember = new AllianceMember();
            allianceMember.setInterestAlliance(entity);
            allianceMember.setUserId(userId);
            allianceMemberSer.save(allianceMember);
        }
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void delMemeber(InterestAllianceTO to) throws SerException {
        String id = to.getId();
        List<String> userIds = to.getUserIds();
        for (String userId : userIds) {
            AllianceMemberDTO dto = new AllianceMemberDTO();
            dto.getConditions().add(Restrict.eq("interestAlliance.id", id));
            dto.getConditions().add(Restrict.eq("userId", userId));
            AllianceMember member = allianceMemberSer.findOne(dto);
            if (null != member) {
                allianceMemberSer.remove(member);
            }
        }
    }

    @Override
    public void Apply(String id) throws SerException {
        User user = UserUtil.currentUser();   //申请人
        InterestAlliance entity = super.findById(id);
        String userId = entity.getUserId();   //群主
        AllianceMemberDTO dto = new AllianceMemberDTO();
        dto.getConditions().add(Restrict.eq("interestAlliance.id", id));
        dto.getConditions().add(Restrict.eq("userId", user.getId()));
        AllianceMember member = allianceMemberSer.findOne(dto);
        if (null != member) {
            throw new SerException("您已存在该联盟");
        }
        //todo:发送申请消息给群主
    }

    @Override
    public void agree(String id, String userId) throws SerException {
        InterestAlliance entity = super.findById(id);
        AllianceMember allianceMember = new AllianceMember();
        allianceMember.setInterestAlliance(entity);
        allianceMember.setUserId(userId);
        allianceMemberSer.save(allianceMember);
    }

    @Override
    public void refuse(String id, String userId) throws SerException {
        //todo:发送消息给申请人
    }

    @Override
    public List<InterestAllianceVO> findByTag(String tag) throws SerException {
        InterestAllianceDTO dto = new InterestAllianceDTO();
        dto.getConditions().add(Restrict.eq("tag", tag));
        List<InterestAlliance> list = super.findByCis(dto);
        List<InterestAllianceVO> vos = new ArrayList<>();
        for (InterestAlliance interestAlliance : list) {
            InterestAllianceVO vo = BeanCopy.copyProperties(interestAlliance, InterestAllianceVO.class);
            vo.setUserName(userSer.findById(interestAlliance.getUserId()).getUsername());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<InterestAllianceVO> userAll() throws SerException {
        String userId = UserUtil.currentUserID();
        AllianceMemberDTO dto = new AllianceMemberDTO();
        dto.getConditions().add(Restrict.eq("userId", userId));
        List<AllianceMember> members = allianceMemberSer.findByCis(dto);
        List<InterestAlliance> list = members.stream().map(allianceMember -> allianceMember.getInterestAlliance()).collect(Collectors.toList());
        List<InterestAllianceVO> vos = new ArrayList<>();
        for (InterestAlliance interestAlliance : list) {
            InterestAllianceVO vo = BeanCopy.copyProperties(interestAlliance, InterestAllianceVO.class);
            vo.setUserName(userSer.findById(interestAlliance.getUserId()).getUsername());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public List<UserVO> findMembers(String id) throws SerException {
        AllianceMemberDTO dto = new AllianceMemberDTO();
        dto.getConditions().add(Restrict.eq("interestAlliance.id", id));
        List<AllianceMember> list = allianceMemberSer.findByCis(dto);
        List<UserVO> vos = new ArrayList<>();
        for (AllianceMember member : list) {
            User user = userSer.findById(member.getUserId());
            UserVO vo = BeanCopy.copyProperties(user, UserVO.class);
            vos.add(vo);
        }
        return vos;
    }
}
