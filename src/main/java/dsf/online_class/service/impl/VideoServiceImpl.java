package dsf.online_class.service.impl;

import dsf.online_class.domain.Video;
import dsf.online_class.domain.VideoBanner;
import dsf.online_class.mapper.VideoMapper;
import dsf.online_class.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Video findDetailById(int video_id) {
        Video video =  videoMapper.findDetailById(video_id);
        return video;
    }

    @Override
    public List<Video> listVideo() {
        return videoMapper.listVideo();
    }

    @Override
    public List<VideoBanner> listVideoBanner() {
        return videoMapper.listVideoBanner();
    }
}
