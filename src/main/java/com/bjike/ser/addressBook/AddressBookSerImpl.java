package com.bjike.ser.addressBook;

import com.bjike.common.exception.SerException;
import com.bjike.common.util.UserUtil;
import com.bjike.common.util.bean.BeanCopy;
import com.bjike.dto.Restrict;
import com.bjike.dto.addressBook.AddressBookDTO;
import com.bjike.dto.chat.FriendDTO;
import com.bjike.dto.user.RelationshipDTO;
import com.bjike.dto.user.UserDTO;
import com.bjike.entity.addressBook.AddressBook;
import com.bjike.entity.chat.Friend;
import com.bjike.entity.user.Relationship;
import com.bjike.entity.user.User;
import com.bjike.ser.ServiceImpl;
import com.bjike.ser.chat.FriendSer;
import com.bjike.ser.user.RelationshipSer;
import com.bjike.ser.user.UserSer;
import com.bjike.to.addressBook.AddressBookTO;
import com.bjike.vo.addressBook.AddressBookVO;
import com.bjike.vo.addressBook.SearchVO;
import com.bjike.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 通讯录
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-29 08:51]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class AddressBookSerImpl extends ServiceImpl<AddressBook, AddressBookDTO> implements AddressBookSer {
    @Autowired
    private RelationshipSer relationshipSer;
    @Autowired
    private UserSer userSer;
    @Autowired
    private FriendSer friendSer;

    @Override
    public List<SearchVO> search(String name) throws SerException {
        String userID = UserUtil.currentUserID();
        List<String> users = findName(name);
        if (!users.isEmpty()) {
            String[] userIds = new String[users.size()];
            userIds = users.toArray(userIds);
            Set<String> findIds = new HashSet<>();
            FriendDTO friendDTO = new FriendDTO();
            friendDTO.getConditions().add(Restrict.eq("user.id", userID));
            friendDTO.getConditions().add(Restrict.in("friend.id", userIds));
            List<Friend> friends = friendSer.findByCis(friendDTO);
            for (Friend f : friends) {
                findIds.add(f.getFriend().getId());
            }
            AddressBookDTO addressBookDTO = new AddressBookDTO();
            addressBookDTO.getConditions().add(Restrict.eq("userId", userID));
            addressBookDTO.getConditions().add(Restrict.in("bookId", userIds));
            List<AddressBook> addressBooks = super.findByCis(addressBookDTO);
            for (AddressBook a : addressBooks) {
                findIds.add(a.getBookId());
            }
            FriendDTO friendDTO1 = new FriendDTO();
            friendDTO1.getConditions().add(Restrict.eq("user.id", userID));
            friendDTO1.getConditions().add(Restrict.like("remark", name));
            List<Friend> friends1 = friendSer.findByCis(friendDTO1);
            for (Friend f : friends1) {
                findIds.add(f.getFriend().getId());
            }
            AddressBookDTO addressBookDTO1 = new AddressBookDTO();
            addressBookDTO1.getConditions().add(Restrict.eq("userId", userID));
            addressBookDTO1.getConditions().add(Restrict.like("remark", name));
            List<AddressBook> addressBooks1 = super.findByCis(addressBookDTO1);
            for (AddressBook a : addressBooks1) {
                findIds.add(a.getBookId());
            }
            return findList(userID, findIds);
        }
        return null;
    }

    private List<SearchVO> findList(String id, Set<String> findIds) throws SerException {
        List<SearchVO> vos = new ArrayList<>();
        for (String find : findIds) {
            User findU = userSer.findById(find);
            FriendDTO friendDTO = new FriendDTO();
            friendDTO.getConditions().add(Restrict.eq("user.id", id));
            AddressBookDTO addressBookDTO = new AddressBookDTO();
            addressBookDTO.getConditions().add(Restrict.eq("userId", id));
            addressBookDTO.getConditions().add(Restrict.eq("bookId", find));
            AddressBook addressBook = super.findOne(addressBookDTO);
            String bookRemark = null;
            String friendRemark = null;
            String userName = null;
            if (null != addressBook) {
                bookRemark = addressBook.getRemark();
            } else {
                friendDTO.getConditions().add(Restrict.eq("friend.id", find));
                Friend friend = friendSer.findOne(friendDTO);
                if (null != friend) {
                    friendRemark = friend.getRemark();
                } else {
                    User user = userSer.findById(find);
                    if (null != user) {
                        userName = user.getUsername();
                    }
                }
            }
            if (null != findU) {
                UserVO userVO = BeanCopy.copyProperties(findU, UserVO.class);
                SearchVO vo = new SearchVO();
                if (null != bookRemark) {
                    vo.setUserVO(userVO);
                    vo.setRemark(bookRemark);
                } else if (null != friendRemark) {
                    vo.setUserVO(userVO);
                    vo.setRemark(friendRemark);
                } else {
                    vo.setUserVO(userVO);
                    vo.setRemark(userName);
                }if (null != addressBook) {
                    vo.setBookId(addressBook.getBookId());
                }
                vos.add(vo);
            }
        }
        return vos;
    }

//    private List<User> friends(List<Relationship> list) throws SerException {
//        List<User> users = new ArrayList<>();
//        for (Relationship relationship : list) {
//            User user = userSer.findById(relationship.getFriend().getId());
//            if (null != user) {
//                users.add(user);
//            }
//        }
//        return users;
//    }

    private List<String> findName(String name) throws SerException {
        UserDTO userDTO = new UserDTO();
        userDTO.getConditions().add(Restrict.like("username", name));
        List<User> users = userSer.findByCis(userDTO);
        List<String> list = new ArrayList<>();
        for (User u : users) {
            list.add(u.getId());
        }
        return list;
    }

    @Override
    public List<SearchVO> find(String name) throws SerException {
        User user = UserUtil.currentUser();
        RelationshipDTO dto = new RelationshipDTO();
        dto.getConditions().add(Restrict.eq("user.id", user.getId()));
        List<Relationship> currents = relationshipSer.findByCis(dto);
        List<String> currentIds = currents.stream().map(relationship -> relationship.getFriend().getId()).collect(Collectors.toList());
        List<String> finds = findName(name);
        List<SearchVO> vos = new ArrayList<>();
        for (String id : finds) {
            User u = userSer.findById(id);
            if (id.equals(user.getId())) {
                SearchVO vo = new SearchVO();
                UserVO userVO = BeanCopy.copyProperties(user, UserVO.class);
                vo.setUserVO(userVO);
                vos.add(vo);
            } else if (null != u) {
                SearchVO vo = new SearchVO();
                String num = num(id, currentIds);
                UserVO userVO = BeanCopy.copyProperties(u, UserVO.class);
                vo.setUserVO(userVO);
                vo.setNum(Integer.valueOf(num));
                vos.add(vo);
            }
        }
        return vos;
    }

    private String num(String id, List<String> currentIds) throws SerException {
        RelationshipDTO relationshipDTO = new RelationshipDTO();
        relationshipDTO.getConditions().add(Restrict.eq("user.id", id));
        List<Relationship> relationships = relationshipSer.findByCis(relationshipDTO);
        List<String> findIds = relationships.stream().map(relationship -> relationship.getFriend().getId()).collect(Collectors.toList());
        String num = findIds.stream().filter(s -> currentIds.contains(s)).count() + "";      //查找共同好友数量
        return num;
    }

    @Override
    public List<SearchVO> mayKnow() throws SerException {
        User user = UserUtil.currentUser();
        RelationshipDTO dto = new RelationshipDTO();
        dto.getConditions().add(Restrict.eq("user.id", user.getId()));
        List<Relationship> list = relationshipSer.findByCis(dto);
        List<String> friends = list.stream().map(relationship -> relationship.getFriend().getId()).collect(Collectors.toList());
        List<SearchVO> vos = new ArrayList<>();
        for (String s : friends) {
            RelationshipDTO dto1 = new RelationshipDTO();
            dto1.getConditions().add(Restrict.eq("user.id", s));
            List<Relationship> relationships = relationshipSer.findByCis(dto1);
            for (Relationship r : relationships) {
                if (!friends.contains(r.getFriend().getId())) {
                    User u = userSer.findById(r.getFriend().getId());
                    if (u != null) {
                        String num = num(r.getFriend().getId(), friends);
                        SearchVO vo = new SearchVO();
                        vo.setUserVO(BeanCopy.copyProperties(u, UserVO.class));
                        vo.setNum(Integer.valueOf(num));
                        vos.add(vo);
                    }
                }
            }
        }
        return vos;
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void add(AddressBookTO to) throws SerException {
        String userId = UserUtil.currentUserID();
        AddressBookDTO dto = new AddressBookDTO();
        dto.getConditions().add(Restrict.eq("userId", userId));
        dto.getConditions().add(Restrict.eq("bookId", to.getBookId()));
        AddressBook book = super.findOne(dto);
        if (null != book) {
            throw new SerException("通讯录中已存在该人");
        }
        AddressBook entity = BeanCopy.copyProperties(to, AddressBook.class, true);
        entity.setUserId(userId);
        super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void edit(String bookId, String remark) throws SerException {
        String userId = UserUtil.currentUserID();
        AddressBookDTO dto = new AddressBookDTO();
        dto.getConditions().add(Restrict.eq("userId", userId));
        dto.getConditions().add(Restrict.eq("bookId", bookId));
        AddressBook entity = super.findOne(dto);
        if (null == entity) {
            throw new SerException("没找到该通讯录");
        }
        entity.setRemark(remark);
        entity.setModifyTime(LocalDateTime.now());
        super.update(entity);
    }

    @Override
    @Transactional(rollbackFor = SerException.class)
    public void delete(String id) throws SerException {
        super.remove(id);
    }

    @Override
    public List<AddressBookVO> list(AddressBookDTO dto) throws SerException {
        String userId = UserUtil.currentUserID();
//        String remark = dto.getRemark();
        dto.getSorts().add("remark=asc");
        dto.getConditions().add(Restrict.eq("userId", userId));
        List<AddressBook> list = super.findByCis(dto);
//        if ((null != remark) && (!"".equals(remark))) {
//            list=list.stream().filter(addressBook -> addressBook.getRemark()!=null&& remark.equals(ChineseCharToEn.getFirstLetter(addressBook.getRemark()))).collect(Collectors.toList());
//        }
        List<AddressBookVO> vos = new ArrayList<>();
        for (AddressBook addressBook : list) {
            AddressBookVO vo = BeanCopy.copyProperties(addressBook, AddressBookVO.class);
            vo.setHeadPath(userSer.findById(vo.getBookId()).getHeadPath());
            vos.add(vo);
        }
        return vos;
    }
}
