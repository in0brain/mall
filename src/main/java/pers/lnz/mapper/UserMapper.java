package pers.lnz.mapper;

import pers.lnz.entity.User;

import java.util.List;

/**
 * 用户接口类
 */

public interface UserMapper {

    User queryUserByName(String userName);

    User queryUserByEmail(String email);

    List<User> queryUserByAuthority(String authority);

    boolean insertUser(User user);

    boolean deleteUserByName(String userName);

    boolean deleteUserByEmail(String email);

    boolean updatePassword(User user);

    boolean updateEmail(User user);

    boolean updateImg_src(User user);

    boolean updateAuthority(User user);

    List<User> queryMerchantByFuzzyName(String userName);

    List<String> getAllMerchantsName();


}
