package dsf.online_class.service;

import dsf.online_class.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserService {
    int save(Map<String,String> userInfo);
    User findByPhone( String phone);
}
