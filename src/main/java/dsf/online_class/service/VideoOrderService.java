package dsf.online_class.service;

import dsf.online_class.model.entity.VideoOrder;

import java.util.List;

public interface VideoOrderService {
    int save(int userId,int videoId);
    int addPlayRecord(int userId);

    List<VideoOrder> listOrderByUserID(Integer userId);
}
