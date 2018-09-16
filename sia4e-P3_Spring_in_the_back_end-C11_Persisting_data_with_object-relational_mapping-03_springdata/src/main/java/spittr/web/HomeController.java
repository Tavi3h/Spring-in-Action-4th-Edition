package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 声明该类为一个控制器
@Controller
// 将控制器映射到“/”和/homepage
@RequestMapping({ "/", "/homepage" })
public class HomeController {

    // 处理GET请求
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        // 返回的视图名为home
        return "home";
    }
}
