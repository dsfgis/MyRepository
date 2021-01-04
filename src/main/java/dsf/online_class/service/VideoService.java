package dsf.online_class.service;

import dsf.online_class.model.entity.Video;
import dsf.online_class.model.entity.VideoBanner;

import java.util.List;

public interface VideoService {
    List<Video> listVideo();
    List<VideoBanner> listVideoBanner();
    Video findDetailById (int video_id);
}
