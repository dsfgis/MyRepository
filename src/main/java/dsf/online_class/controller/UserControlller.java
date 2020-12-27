package dsf.online_class.controller;


import dsf.online_class.domain.User;
import dsf.online_class.utils.JsonData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/pub/user")
public class UserControlller {

    @PostMapping("register")
    public JsonData register(@RequestBody Map<String,String> userInfo){
        return null;
    }
}
