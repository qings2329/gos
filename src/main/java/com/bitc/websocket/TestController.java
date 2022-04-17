package com.bitc.websocket;

import com.bitc.controller.JSPController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private TestServiceImpl testServiceImpl;

    /**
     * 启动页面
     *
     * @return
     */
    @GetMapping("/start")
    public String start() {
        return "index";
    }

    @PostMapping("/pushToWeb")
    public JSPController.Result pushToWeb(@RequestBody String x) {

        testServiceImpl.printTime();
        return new JSPController.Result(200, "success");
    }

}
