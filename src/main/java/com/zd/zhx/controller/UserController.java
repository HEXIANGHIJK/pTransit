package com.zd.zhx.controller;

import com.zd.zhx.pojo.User;
import com.zd.zhx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/check")
    public ResponseEntity<User> checkLogin(HttpServletRequest request){
        /*System.out.println("登陆状态验证");*/
        HttpSession session = request.getSession();

        Object user = session.getAttribute("user");
        if (user==null){
            return ResponseEntity.ok(null);
        }else if (user instanceof User){
            return ResponseEntity.ok((User) user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/temCheck")
    public ResponseEntity<User> checktempUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        try {
            User temporarilyUser = (User) session.getAttribute("temporarilyUser");
            if (temporarilyUser!=null){
                return ResponseEntity.ok(temporarilyUser);
            }
            return ResponseEntity.ok(null);
        }catch (Exception e){
            System.out.println("temporarilyUser is not exist");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request){
        request.getSession().invalidate();
        return ResponseEntity.ok(null);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(HttpServletRequest request,String username,String password){
        HttpSession session = request.getSession();

        User user = userService.findByUsername(username);

        if (user==null)
            return ResponseEntity.ok(new User());
        else if (user.getPassword().equals(password)){
            session.setAttribute("user",user);
            return ResponseEntity.ok(user);
        }else if(!user.getPassword().equals(password)){
            return ResponseEntity.ok(new User());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(HttpServletRequest request,String username,String password){

        User byUsername = userService.findByUsername(username);
        if (byUsername!=null){
            System.out.println("byUsername is found!");
            User nullUser=null;
            return ResponseEntity.ok(nullUser);
        }

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        User returnUser = userService.insertUser(user);
        HttpSession session = request.getSession();
        if (returnUser!=null){
            session.setAttribute("temporarilyUser",user);
            return ResponseEntity.ok(returnUser);
        }
        System.out.println("返回BAD_REQUEST");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
