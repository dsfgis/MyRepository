package dsf.online_class.mapper;

import dsf.online_class.model.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int save(User user);
    User findByPhone(@Param("phone") String phone);

    User findByPhoneAndPwd(@Param("phone") String phone,@Param("pwd") String pwd);
}
