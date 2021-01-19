package dsf.online_class.mapper;

import dsf.online_class.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface VideoOrderMapper {
    /**
     * 查询用户是否购买过
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId,@Param("state") int state);

    /**
     * 保存订单
     * @param vidoOrder
     * @return
     */
    int saveOrder(VideoOrder vidoOrder);

    /**
     * 订单列表
     * @param userId
     * @return
     */
    List<VideoOrder> listOrderByUserID(@Param("user_id") Integer userId);
}


