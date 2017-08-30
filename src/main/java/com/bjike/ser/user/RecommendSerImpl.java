package com.bjike.ser.user;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.UserUtil;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.dto.Restrict;
import com.bjike.dto.user.RecommendDTO;
import com.bjike.entity.user.Recommend;
import com.bjike.entity.user.User;
import com.bjike.ser.ServiceImpl;
import com.bjike.to.user.RecommendTO;
import com.bjike.vo.recommend.RecommendVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: [liguiqin]
 * @Date: [2017-08-23 14:20]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class RecommendSerImpl extends ServiceImpl<Recommend, RecommendDTO> implements RecommendSer {


    @Override
    public String add(RecommendTO to) throws SerException {
        Recommend recommend = BeanCopy.copyProperties(to, Recommend.class);
        User user = UserUtil.currentUser();
        recommend.setUser(user);
        super.save(recommend);
        String code = "IKE-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        recommend.setInviteCode(code);
        return code;

    }

    @Override
    public List<RecommendVO> myRecommends(RecommendDTO dto) throws SerException {
        String userId = UserUtil.currentUserID();
        dto.getConditions().add(Restrict.eq("user.id", userId));
        dto.getConditions().add(Restrict.isNotNull("user.id"));
        List<Recommend> recommends = super.findByCis(dto);
        List<RecommendVO> recommendVOS = new ArrayList<>();
        for (Recommend recommend : recommends) {
            RecommendVO vo = new RecommendVO();
            vo.setNickname(recommend.getRealName());
            vo.setInviteCode(recommend.getRecommended().getHeadPath());
        }
        return recommendVOS;
    }

    @Override
    public Boolean validate(String code) throws SerException {

        return null != findByInviteCode(code);
    }

    @Override
    public Recommend findByInviteCode(String code) throws SerException {
        RecommendDTO dto = new RecommendDTO();
        dto.getConditions().add(Restrict.eq("inviteCode", code));
        return super.findOne(dto);
    }
}
