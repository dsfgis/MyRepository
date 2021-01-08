package dsf.online_class.service.impl;

import dsf.online_class.mapper.VideoOrderMapper;
import dsf.online_class.service.VideoOrderService;

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

        return 0;
    }
}
