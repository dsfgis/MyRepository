package dsf.online_class.service.impl;

import dsf.online_class.mapper.VideoOrderMapper;
import dsf.online_class.model.entity.VideoOrder;
import dsf.online_class.service.VideoOrderService;
import org.springframework.stereotype.Service;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {


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
        
        return 0;
    }
}
