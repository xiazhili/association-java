package com.bjike.ser.addressBook;

import com.bjike.common.exception.SerException;
import com.bjike.dto.addressBook.AddressBookDTO;
import com.bjike.entity.addressBook.AddressBook;
import com.bjike.ser.Ser;
import com.bjike.to.addressBook.AddressBookTO;
import com.bjike.vo.addressBook.AddressBookVO;
import com.bjike.vo.addressBook.SearchVO;
import com.bjike.vo.user.UserVO;

import java.util.List;
import java.util.Map;

/**
 * 通讯录
 *
 * @Author: [chenjunhao]
 * @Date: [2017-08-29 08:51]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface AddressBookSer extends Ser<AddressBook, AddressBookDTO> {
    /**
     * 搜索通讯录
     *
     * @param name
     * @return
     * @throws SerException
     */
    List<SearchVO> search(String name) throws SerException;

    /**
     * 搜索全部
     *
     * @param name
     * @return
     * @throws SerException
     */
    List<SearchVO> find(String name) throws SerException;

    /**
     * 可能认识的人
     *
     * @return
     * @throws SerException
     */
    List<SearchVO>  mayKnow() throws SerException;

    /**
     * 添加通讯录
     *
     * @param to
     * @throws SerException
     */
    void add(AddressBookTO to) throws SerException;

    /**
     * 编辑备注
     *
     * @param bookId
     * @param remark
     * @throws SerException
     */
    void edit(String bookId, String remark) throws SerException;

    /**
     * 删除通讯录
     *
     * @param id
     * @throws SerException
     */
    void delete(String id) throws SerException;

    /**
     * 通讯录列表
     *
     * @param dto
     * @return
     * @throws SerException
     */
    List<AddressBookVO> list(AddressBookDTO dto) throws SerException;
}
