package dsf.online_class.mapper;

import dsf.online_class.domain.Video;
import dsf.online_class.domain.VideoBanner;
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
}

