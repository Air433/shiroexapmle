package com.renjie.controller;

import com.alibaba.fastjson.JSONObject;
import com.renjie.entity.UserInfo;
import java.util.HashMap;
import java.util.Map;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ouyanggang on 2018/5/18.
 */
@RestController
public class LoginController {

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String ajaxLogin(HttpEntity<UserInfo> httpEntity){
    UserInfo userInfo = httpEntity.getBody();
    JSONObject jsonObject = new JSONObject();
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
    try {
      subject.login(token);
      jsonObject.put("token", subject.getSession().getId());
      jsonObject.put("msg", "登陆成功");
    }catch (IncorrectCredentialsException e){
      jsonObject.put("msg", "密码错误");
    }catch (LockedAccountException e){
      jsonObject.put("msg", "登陆失败，该用户已被冻结");
    }catch (AuthenticationException e){
      jsonObject.put("msg", "该用户不存在");
    }catch (Exception e){
      e.printStackTrace();
    }
    return jsonObject.toJSONString();
  }

  @RequestMapping(value = "/unauth")
  public Object unauth(){
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("code," , "1000000");
    map.put("msg", "未登录");
    return map;
  }

  @RequestMapping(value = "/test")
  public String test(){
    return "测试";
  }
}
