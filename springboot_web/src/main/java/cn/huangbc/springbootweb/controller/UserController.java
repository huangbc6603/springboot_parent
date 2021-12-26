package cn.huangbc.springbootweb.controller;

import cn.huangbc.springbootweb.bean.User;
import cn.huangbc.springbootweb.result.CodeMsg;
import cn.huangbc.springbootweb.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangbc
 * @version 1.0
 * @date 2021/12/21 8:31
 */
@Validated
@RestController
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    @ApiOperation("添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "李四"),
            @ApiImplicitParam(name = "address", value = "用户地址", defaultValue = "深圳", required = true)
    })
    public Map addUser(String username, @RequestParam(required = true) String address) {
        Map<Object, Object> map = new HashMap<>();
        map.put(username,address);
        return map;
    }

    @GetMapping("/{id}/{username}")
    @ApiOperation("根据id查询用户的接口")
//    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "99", required = true)
    @ResponseBody
    public Result<CodeMsg> getUserById(@Min (value = 2)@RequestParam Integer id,
                                       @Length(min = 2, max = 10 ,message = "长度必须在2-10之间") @RequestParam String username) {
        Map<Object, Object> map = new HashMap<>();
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        System.out.println(user);
        map.put("a","b");
        System.out.println(Result.success(CodeMsg.SUCCESS).toString());
        return Result.success(CodeMsg.SUCCESS);
//        return map;
    }

    @PutMapping("/{user}")
    @ApiOperation("查询用户的接口")
    @ResponseBody
    public Result<Map> updateUserById(@Validated @RequestBody User user) {
        System.out.println(user);
        return Result.fail(CodeMsg.SERVER_ERROR);
//        return user;
    }
}

