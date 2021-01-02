package dsf.online_class.mapper;

import dsf.online_class.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int save(User user);
    User findByPhone(@Param("phone") String phone);
}
