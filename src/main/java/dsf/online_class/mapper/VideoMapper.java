package dsf.online_class.mapper;

import dsf.online_class.model.entity.Video;
import dsf.online_class.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {

    /**
     *
     * @return
     */
    List<Video> listVideo();

    /**
     *
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     *
     * @param videoId
     * @return
     */
    Video findDetailById(@Param("video_id") int videoId);
    Video findById(@Param("video_id") int videoId);
}

