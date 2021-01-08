package dsf.online_class.controller;


import dsf.online_class.model.request.VideoOrderRequest;
import dsf.online_class.utils.JsonData;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1/pri/order")

public class VideoOrderController {

    @RequestMapping("save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){

        Integer userId  = (Integer)request.getAttribute("user_id");
        return JsonData.buildSuccess();
    }

}
