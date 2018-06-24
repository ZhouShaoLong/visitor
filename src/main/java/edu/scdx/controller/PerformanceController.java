package edu.scdx.controller;

import edu.scdx.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Menfer on 2017/7/27.
 * PerformanceController
 * 演出信息的URL映射
 */
@Controller
@RequestMapping("/performance")
public class PerformanceController {
    @Autowired
    PerformanceService performanceService;

    /**
     * 显示所有演出信息
     * 参数：page 显示页数
     * */
    @RequestMapping("/showAll")
    public String showAll(Model model, int page){
        List list = performanceService.getAll();
        model.addAttribute("list", performanceService.getAll());
        int realPage = page;
        int totalPage = 0;
        if(list.size()<=15){
            totalPage = 1;
        }else if((list.size()%15)==0){
            totalPage = list.size()/15;
        }else {
            totalPage = list.size()/15+1;
        }
        if(page<=1){
            realPage = 1;
        }
        if (page>totalPage){
            realPage = totalPage;
        }
        model.addAttribute("page",realPage);
        model.addAttribute("totalPage",totalPage);
        return "performanceList";
    }
}
