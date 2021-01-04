package dsf.online_class.service.impl;

import dsf.online_class.model.entity.User;
import dsf.online_class.mapper.UserMapper;
import dsf.online_class.service.UserService;
import dsf.online_class.utils.CommonUtils;
import dsf.online_class.utils.JWTUtils;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int save(Map<String, String> userInfo) {

        User user = parseToUser(userInfo);
        if(user != null){
           return userMapper.save(user);
        }
        else {
            return -1;
        }
    }

    @Override
    public User findByPhone(String phone) {

        return userMapper.findByPhone(phone);
    }

    private User parseToUser(Map<String,String> userInfo){
        User user =new User();
        if(userInfo.containsKey("phone") && userInfo.containsKey("name") && userInfo.containsKey("pwd")){

            user.setName(userInfo.get("name"));
            user.setPhone(userInfo.get("phone"));
            user.setPwd(CommonUtils.MD5(userInfo.get("pwd")) );
            user.setHeadImg(userInfo.get("headImg"));
            user.setCreateTime(new Date());

        }
        else {
            return null;
        }
        return user;
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findByPhoneAndPwd(phone,CommonUtils.MD5(pwd));
        if(null != user){
            return JWTUtils.geneJsonWebToken(user);
        } else  {
            return null;
        }
    }
}
