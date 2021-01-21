package dsf.online_class.service.impl;

import dsf.online_class.config.CacheKeyManager;
import dsf.online_class.model.entity.Video;
import dsf.online_class.model.entity.VideoBanner;
import dsf.online_class.mapper.VideoMapper;
import dsf.online_class.service.VideoService;
import dsf.online_class.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private BaseCache baseCache;
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
        try {
            Object cache = baseCache.getCache().get(CacheKeyManager.INDEX_BANNER_KEY, ()->{
                List<VideoBanner> videoBannerList = videoMapper.listVideoBanner();
                return videoBannerList;
                });
            if(cache instanceof List){
                List<VideoBanner> videoBanners = (List<VideoBanner>)cache;
                return videoBanners;
            }
            return videoMapper.listVideoBanner();
        }
        catch (Exception e ){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findById(int video_id) {
        return videoMapper.findById(video_id);
    }
}
