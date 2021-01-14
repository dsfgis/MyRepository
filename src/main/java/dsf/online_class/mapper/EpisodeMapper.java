package dsf.online_class.mapper;

import dsf.online_class.model.entity.Episode;
import org.apache.ibatis.annotations.Param;

public interface EpisodeMapper {
    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);

}
