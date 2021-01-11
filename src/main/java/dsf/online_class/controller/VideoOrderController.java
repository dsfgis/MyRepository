package dsf.online_class.controller;


import dsf.online_class.model.request.VideoOrderRequest;
import dsf.online_class.service.VideoOrderService;
import dsf.online_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1/pri/order")

public class VideoOrderController {

    @Autowired
    private  VideoOrderService videoOrderService;
    @RequestMapping("save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){

        Integer userId  = (Integer)request.getAttribute("user_id");
        int rows = videoOrderService.save(userId,videoOrderRequest.getVideoId());
        return 0==rows? JsonData.buildError("下单失败"):JsonData.buildSuccess("下单成功");
    }

}
