package dsf.online_class.service.impl;

import dsf.online_class.domain.User;
import dsf.online_class.mapper.UserMapper;
import dsf.online_class.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int save(Map<String, String> userInfo) {
        return 0;
    }

    @Override
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }
}
