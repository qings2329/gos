package com.bitc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JSPController {


    // http://localhost:8080/result.jsp/ in
    // but http://localhost:8080/result.jsp not in
    // why?
    @RequestMapping("/{jspName}.jsp")
    public String visitJspx(@PathVariable("jspName") String jspName) {

        return jspName;
    }

//    @RequestMapping("/{test}")
//    public String test(@PathVariable("test") String jspName) {
//
//        return jspName;
//    }

    @RequestMapping("/test/{test}")
    public String test2(@PathVariable("test") String jspName) {

        return jspName;
    }

    @ResponseBody
    @RequestMapping("/hello")
    public Result hello() {
        Result ret = new Result(0, "success");
        return ret;
    }






















    public static class Result {

        public Result(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        int code;
        String msg;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        // get set 不能少，否则无法序列化
        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

}
