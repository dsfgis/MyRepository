package dsf.online_class.service.impl;

import dsf.online_class.Exception.CustomException;
import dsf.online_class.mapper.EpisodeMapper;
import dsf.online_class.mapper.PlayRecordMapper;
import dsf.online_class.mapper.VideoMapper;
import dsf.online_class.mapper.VideoOrderMapper;
import dsf.online_class.model.entity.Episode;
import dsf.online_class.model.entity.PlayRecord;
import dsf.online_class.model.entity.Video;
import dsf.online_class.model.entity.VideoOrder;
import dsf.online_class.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    @Autowired
    private PlayRecordMapper playRecordMapper;

    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private VideoOrderMapper videoOrderMapper;
    @Autowired
    private EpisodeMapper episodeMapper;
    /**
     * 下单
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    @Transactional
    public int save(int userId, int videoId) {

        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId,videoId,1);


        if(null == videoOrder){return 0;}
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
        //return rows;
        //生成播放记录
        if(1==rows){
            Episode episode = episodeMapper.findFirstEpisodeByVideoId((videoId));
            if(null == episode){
                throw new CustomException(-1,"视频没有集信息，请检查");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);
            playRecordMapper.savePlayRecord(playRecord);
        }

        return rows;
    }

    @Override
    public int addPlayRecord(int userId) {
        return 0;
    }

    @Override
    public List<VideoOrder> listOrderByUserID(Integer userId) {
        return videoOrderMapper.listOrderByUserID(userId);
    }
}
