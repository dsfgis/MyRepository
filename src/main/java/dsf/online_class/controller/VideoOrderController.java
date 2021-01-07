package dsf.online_class.controller;


import dsf.online_class.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/pri/order")

public class VideoOrderController {

    @RequestMapping("save")
    public JsonData saveOrder(){
        return JsonData.buildError("todo");
    }

}
