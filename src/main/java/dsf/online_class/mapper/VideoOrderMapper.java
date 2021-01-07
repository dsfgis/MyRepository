package dsf.online_class.mapper;

import dsf.online_class.model.entity.Video;
import dsf.online_class.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;


/**
 * 查询用户是否购买过
 */
public interface VideoOrderMapper {
    VideoOrder findByUserIdAndVideoId(@Param("user_id") int userId, @Param("video_id") int videoId,@Param("state") int state);

    int saveOrder(VideoOrder vidoOrder);
}


