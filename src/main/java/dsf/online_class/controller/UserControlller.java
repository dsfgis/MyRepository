package dsf.online_class.controller;


import dsf.online_class.domain.User;
import dsf.online_class.service.UserService;
import dsf.online_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "api/v1/pri/user")
public class UserControlller {

    @Autowired
    private UserService userService;
    @PostMapping(value = "register")
    public JsonData register(@RequestBody Map<String,String> userInfo){
        int rows = userService.save(userInfo);
        return rows ==1? JsonData.buildSuccess():JsonData.buildError("注册失败");

    }
}
