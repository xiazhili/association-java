package com.bjike.ser.claim;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.UserUtil;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.dto.Restrict;
import com.bjike.dto.claim.ClaimDTO;
import com.bjike.dto.user.RecommendDTO;
import com.bjike.dto.user.UserDTO;
import com.bjike.dto.user.UserInfoDTO;
import com.bjike.entity.claim.Claim;
import com.bjike.entity.user.Recommend;
import com.bjike.entity.user.User;
import com.bjike.entity.user.UserInfo;
import com.bjike.ser.ServiceImpl;
import com.bjike.ser.user.RecommendSer;
import com.bjike.ser.user.UserInfoSer;
import com.bjike.ser.user.UserSer;
import com.bjike.to.claim.ClaimTO;
import com.bjike.type.user.UserType;
import com.bjike.vo.claim.ClaimCenterVO;
import com.bjike.vo.claim.ClaimVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: [xiazhili]
 * @Date: [2017-08-29 15:57]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class ClaimSerImpl extends ServiceImpl<Claim, ClaimDTO> implements ClaimSer {
    @Autowired
    private UserSer userSer;
    @Autowired
    private RecommendSer recommendSer;
    @Autowired
    private UserInfoSer userInfoSer;

    @Transactional(rollbackFor = SerException.class)
    @Override
    public void applyClaim(ClaimTO to) throws SerException {
        User user = UserUtil.currentUser(false);
        if (user.getUserType().equals(UserType.ORDINARY)) {
            throw new SerException("你不是VIP,不可进行认领操作");
        } else {
            Claim claim = BeanCopy.copyProperties(to, Claim.class);
            String account = to.getPhone();
            List<User> userList = userSer.findByAccount(account);
            if (!userList.isEmpty()) {
                claim.setUser(userList.get(0));
            } else {
                throw new SerException("没有该手机号对应的用户");
            }
            super.save(claim);
        }

    }

    @Override
    public ClaimCenterVO getId(String id) throws SerException {
        User user = userSer.findById(id);
        RecommendDTO recommendDTO = new RecommendDTO();
        recommendDTO.getConditions().add(Restrict.isNotNull("user.id"));
        recommendDTO.getConditions().add(Restrict.eq("recommended.id", user.getId()));
        ClaimCenterVO claimCenterVO = new ClaimCenterVO();
        List<Recommend> list = recommendSer.findByCis(recommendDTO);
        if (!list.isEmpty()) {
            String name = list.get(0).getUser().getUsername();
            claimCenterVO.setRecommend(name);
        }
        claimCenterVO.setHeadPath(user.getHeadPath());
        claimCenterVO.setNickname(user.getNickname());
        claimCenterVO.setNumber(user.getNumber());
        claimCenterVO.setUsername(user.getUsername());
        return claimCenterVO;
    }

    @Override
    public List<ClaimCenterVO> list(UserDTO dto) throws SerException {
        dto.getSorts().add("createTime=asc");
        List<ClaimCenterVO> claimCenterVOS = new ArrayList<>();
        dto.getConditions().add(Restrict.ne("userType", UserType.ORDINARY));
        List<User> userList = userSer.findByCis(dto);
        for (User user : userList) {
            ClaimCenterVO vo = BeanCopy.copyProperties(user, ClaimCenterVO.class);
            vo.setUserId(user.getId());
            RecommendDTO recommendDTO = new RecommendDTO();
            recommendDTO.getConditions().add(Restrict.isNotNull("user.id"));
            recommendDTO.getConditions().add(Restrict.eq("recommended.id", user.getId()));
            List<Recommend> list = recommendSer.findByCis(recommendDTO);
            if (!list.isEmpty()) {
                String name = list.get(0).getUser().getUsername();
                vo.setRecommend(name);
            }
            claimCenterVOS.add(vo);
        }
        return claimCenterVOS;
    }


    @Transactional(rollbackFor = SerException.class)
    @Override
    public String save(ClaimTO to) throws SerException {

        Claim claim = BeanCopy.copyProperties(to, Claim.class);
        claim.setUser(UserUtil.currentUser());
        UserInfoDTO dto = new UserInfoDTO();
        List<UserInfo> userInfoList = userInfoSer.findByCis(dto);
        for (UserInfo userInfo : userInfoList) {
            int num = 0;
            if (claim.getName().equals(userInfo.getUser().getUsername())) {
                num++;
            }
            if (claim.getPhone().equals(userInfo.getUser().getPhone())) {
                num++;
            }
            if (claim.getSexType().equals(userInfo.getUser().getSexType())) {
                num++;
            }
            if (claim.getHobby().equals(userInfo.getInterest())) {
                num++;
            }
            if (claim.getAddress().equals(userInfo.getAddress())) {
                num++;
            }
            if (claim.getRelationType().equals(userInfo.getRelationshipType())) {
                num++;
            }
            if (claim.getReputation().equals(userInfo.getReputation())) {
                num++;
            }
            if (num >= 5) {
                if (match(to)) {
                    super.save(claim);
                    return "认领成功";
                }
            }

        }
        return "认领失败";
    }

    private Boolean match(ClaimTO to) throws SerException {
        UserInfoDTO dto = new UserInfoDTO();
        List<UserInfo> userInfoList = userInfoSer.findByCis(dto);
        for (UserInfo userInfo : userInfoList) {
            int num = 0;
            if (userInfo.getBirthday() != null) {
                if (to.getBirthday().equals(userInfo.getBirthday())) {
                    num++;
                }
            }
            if (userInfo.getNativePlace() != null) {
                if (to.getNativePlace().equals(userInfo.getNativePlace())) {
                    num++;
                }
            }
            if (userInfo.getDisposition() != null) {
                if (to.getDisposition().equals(userInfo.getDisposition())) {
                    num++;
                }
            }
            if (userInfo.getNativePlace() != null) {
                if (to.getNativePlace().equals(userInfo.getNativePlace())) {
                    num++;
                }
            }
            if (userInfo.getSchool() != null) {
                if (to.getSchool().equals(userInfo.getSchool())) {
                    num++;
                }
            }
            if (userInfo.getEducation() != null) {
                if (to.getEducation().equals(userInfo.getEducation())) {
                    num++;
                }
            }
            if (userInfo.getCompany() != null) {
                if (to.getCompany().equals(userInfo.getCompany())) {
                    num++;
                }
            }
            if (userInfo.getJob() != null) {
                if (to.getJob().equals(userInfo.getJob())) {
                    num++;
                }
            }
            if (userInfo.getFatherName() != null) {
                if (to.getFatherName().equals(userInfo.getFatherName())) {
                    num++;
                }
            }
            if (userInfo.getMotherName() != null) {
                if (to.getMotherName().equals(userInfo.getMotherName())) {
                    num++;
                }
            }
            if (userInfo.getMarriage() != null) {
                if (to.getMarriage().equals(userInfo.getMarriage())) {
                    num++;
                }
            }
            if (userInfo.getQq() != null) {
                if (to.getQq().equals(userInfo.getQq())) {
                    num++;
                }
            }
            if (userInfo.getEmail() != null) {
                if (to.getEmail().equals(userInfo.getEmail())) {
                    num++;
                }

            }
            if (userInfo.getWeChat() != null) {
                if (to.getWeChat().equals(userInfo.getWeChat())) {
                    num++;
                }
            }
            if (num % 3 == 0) {
                return true;
            }
        }
        return false;
    }
    @Override
    public List<Claim> vouch(double num) throws SerException {
        Boolean bool = true;
        if(bool){
            num = num*0.5;
        }

        ClaimDTO dto = new ClaimDTO();
        List<Claim> claimList = super.findByCis(dto);
        for (Claim claim :claimList){
            claim.setReputation(num);
        }
        return  claimList;
    }

    @Override
    public List<ClaimVO> getClaim(ClaimDTO dto) throws SerException {
        List<ClaimVO> claimVOS = new ArrayList<>();
        String userId = UserUtil.currentUserID();
        dto.getConditions().add(Restrict.eq("user.id", userId));
        List<Claim> claimList = super.findByCis(dto);
        for (Claim claim : claimList) {
            ClaimVO vo = BeanCopy.copyProperties(claim, ClaimVO.class);
            RecommendDTO recommendDTO = new RecommendDTO();
            recommendDTO.getConditions().add(Restrict.eq("recommended.id", userId));
            List<Recommend> list = recommendSer.findByCis(recommendDTO);
            if (!list.isEmpty()) {
                String name = list.get(0).getUser().getUsername();
                vo.setRecommend(name);
            }
            vo.setHeadPath(claim.getUser().getHeadPath());
            vo.setNickname(claim.getUser().getNickname());
            vo.setUsername(claim.getUser().getUsername());
            vo.setNumber(claim.getUser().getNumber());
            vo.setClaimTime(String.valueOf(claim.getCreateTime()));
            claimVOS.add(vo);
        }
        return claimVOS;
    }

    @Override
    public List<ClaimCenterVO> claimList(UserDTO dto) throws SerException {
        dto.getSorts().add("createTime=desc");
        List<ClaimCenterVO> claimCenterVOS = new ArrayList<>();
        dto.getConditions().add(Restrict.ne("userType", UserType.ORDINARY));
        List<User> userList = userSer.findByCis(dto);
        for (User user : userList) {
            ClaimCenterVO vo = BeanCopy.copyProperties(user, ClaimCenterVO.class);
            vo.setUserId(user.getId());
            RecommendDTO recommendDTO = new RecommendDTO();
            recommendDTO.getConditions().add(Restrict.isNotNull("user.id"));
            recommendDTO.getConditions().add(Restrict.eq("recommended.id", user.getId()));
            List<Recommend> list = recommendSer.findByCis(recommendDTO);
            if (!list.isEmpty()) {
                String name = list.get(0).getUser().getUsername();
                vo.setRecommend(name);
            }
            claimCenterVOS.add(vo);
        }
        return claimCenterVOS;
    }

    @Override
    public String message() throws SerException {

        //todo 消息
        String userId = UserUtil.currentUserID();
        return null;

    }

    enum Week{Sun,Mon, Tue, Wed,Thu,Fri,Sat}
    public static void main(String[] args) {
//工作日
        Week[] workDays = {Week.Mon, Week.Tue, Week.Wed, Week.Thu, Week.Fri};
//转换为列表
        List list = Arrays.asList(workDays);
//增加周六也为工作日
        System.out.println(list);
    }
}
