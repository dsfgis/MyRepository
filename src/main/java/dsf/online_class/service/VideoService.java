package dsf.online_class.service;

import dsf.online_class.domain.Video;
import dsf.online_class.domain.VideoBanner;

import java.util.List;

public interface VideoService {
    List<Video> listVideo();
    List<VideoBanner> listVideoBanner();
}
