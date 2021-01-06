package dsf.online_class.service;

import dsf.online_class.model.entity.User;

import java.util.Map;

public interface UserService {
    int save(Map<String,String> userInfo);
    User findByPhone( String phone);

    String findByPhoneAndPwd(String phone, String pwd);

    User findById(Integer userid);
}
