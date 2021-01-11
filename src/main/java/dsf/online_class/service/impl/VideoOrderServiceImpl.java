package dsf.online_class.service.impl;

import dsf.online_class.mapper.VideoMapper;
import dsf.online_class.mapper.VideoOrderMapper;
import dsf.online_class.model.entity.Video;
import dsf.online_class.model.entity.VideoOrder;
import dsf.online_class.service.VideoOrderService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {


    private VideoMapper videoMapper;
    private VideoOrderMapper videoOrderMapper;
    /**
     * 下单
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    public int save(int userId, int videoId) {

        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId,videoId,1);


        if(null!= videoOrder){return 0;}
        Video video = videoMapper.findById(videoId);
        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());
        newVideoOrder.setTotalFree(video.getPrice());
        int rows  = videoOrderMapper.saveOrder(newVideoOrder);
        return rows;
    }
}
