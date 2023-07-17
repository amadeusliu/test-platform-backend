package cn.edu.tju.controller;

import cn.edu.tju.domain.ResponseData;
import cn.edu.tju.domain.UserInfo;
import cn.edu.tju.mapper.UserMapper;
import cn.edu.tju.service.UserService;
import cn.edu.tju.utils.ResponseBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userLogin")
    public ResponseData userLogin(@RequestBody UserInfo userInfo){
        int count = userService.selectUser(userInfo.getUsername(), userInfo.getPassword());

        Map<String, Object> responseMap = new HashMap<>();

        if(count == 0){
            ResponseData responseData = ResponseBuilderUtil.buildFailResponse(responseMap);
            return responseData;
        }
        else {
            responseMap.put("data", userInfo.getUsername());
            ResponseData responseData = ResponseBuilderUtil.buildSuccessResponse(responseMap);
            return responseData;
        }

    }

    @PostMapping("/addUser")
    ResponseData addUser(@RequestBody UserInfo userInfo){
        int count = userService.addUser(userInfo.getUsername(), userInfo.getPassword());
        ResponseData responseData;
        if(count > 0){
            responseData = ResponseBuilderUtil.buildSuccessResponse(count);
        } else {
            responseData = ResponseBuilderUtil.buildFailResponse(count);
        }
        return responseData;
    }

    @RequestMapping("/getUserList")
    ResponseData getUserList(){
        List<UserInfo> userList = userService.getUserList();
        for(int i = 0; i < userList.size(); i ++){
            userList.get(i).setId(i + 1);
        }
        ResponseData responseData = ResponseBuilderUtil.buildSuccessResponse(userList);
        return responseData;
    }

    @RequestMapping("/deleteUser/{username}")
    ResponseData deleteUser(@PathVariable("username")String username){
        int count = userService.deleteUser(username);
        ResponseData responseData = ResponseBuilderUtil.buildSuccessResponse(count);
        return responseData;
    }


}
