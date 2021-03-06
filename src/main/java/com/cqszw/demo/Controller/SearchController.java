package com.cqszw.demo.Controller;

import com.cqszw.demo.Bean.Meeting;
import com.cqszw.demo.Bean.News;
import com.cqszw.demo.Bean.Paper;
import com.cqszw.demo.Service.MeetingService;
import com.cqszw.demo.Service.NewsService;
import com.cqszw.demo.Service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private MeetingService meetingService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private PaperService paperService;
    @RequestMapping("/search/meeting/{keyword}")
    public  String toSearchMeeting(@PathVariable("keyword")String keyword, Model model){
        if(keyword.length()>100){
            model.addAttribute("msg","搜索内容不可以超过100个字符");
            return "search/meeting";
        }
        List<Meeting> meetings=meetingService.search(keyword);
        //搜索会议返回结果页面
        model.addAttribute("meetings",meetings);
        model.addAttribute("keyword",keyword);
        return  "search/meeting";
    }
    @RequestMapping("/search/news/{keyword}")
    public  String toSearchNews(@PathVariable("keyword")String keyword, Model model){
        if(keyword.length()>100){
            model.addAttribute("msg","搜索内容不可以超过100个字符");
            return "search/meeting";
        }
        List<News>newslist =newsService.search(keyword);
        //搜索会议返回结果页面
        model.addAttribute("newslist",newslist);
        model.addAttribute("keyword",keyword);
        return  "search/news";
    }
    @RequestMapping("/search/paper/{keyword}")
    public  String toSearchPaper(@PathVariable("keyword")String keyword, Model model){
        if(keyword.length()>100){
            model.addAttribute("msg","搜索内容不可以超过100个字符");
            return "search/meeting";
        }
        List<Paper> papers =paperService.search(keyword);
        //搜索会议返回结果页面
        model.addAttribute("papers",papers);
        model.addAttribute("keyword",keyword);
        return  "search/paper";
    }
    @RequestMapping("/visitor/search/meeting/{keyword}")
    public  String toVisitorSearchMeeting(@PathVariable("keyword")String keyword, Model model){
        if(keyword.length()>100){
            model.addAttribute("msg","搜索内容不可以超过100个字符");
            return  "search/visitor/meeting";
        }
        List<Meeting> meetings=meetingService.search(keyword);
        //搜索会议返回结果页面
        model.addAttribute("meetings",meetings);
        model.addAttribute("keyword",keyword);
        return  "search/visitor/meeting";
    }
    @RequestMapping("/visitor/search/news/{keyword}")
    public  String toVistorSearchNews(@PathVariable("keyword")String keyword, Model model){
        if(keyword.length()>100){
            model.addAttribute("msg","搜索内容不可以超过100个字符");
            return  "search/visitor/meeting";
        }
        List<News>newslist =newsService.search(keyword);
        //搜索会议返回结果页面
        model.addAttribute("newslist",newslist);
        model.addAttribute("keyword",keyword);
        return  "search/visitor/news";
    }
    @RequestMapping("/visitor/search/paper/{keyword}")
    public  String toVisitorSearchPaper(@PathVariable("keyword")String keyword, Model model){
        if(keyword.length()>100){
            model.addAttribute("msg","搜索内容不可以超过100个字符");
            return  "search/visitor/meeting";
        }
        List<Paper> papers =paperService.search(keyword);
        //搜索会议返回结果页面
        model.addAttribute("papers",papers);
        model.addAttribute("keyword",keyword);
        return  "search/visitor/paper";
    }
    @GetMapping("/meetings/category/{type}/{keyword}")
    public String meetingType(@PathVariable("type")String type,@PathVariable("keyword") String keyword, Model model) {
        if(keyword.length()>100){
            model.addAttribute("msg","搜索内容不可以超过100个字符");
            return "search/meeting";
        }
        List<Meeting> meetings = meetingService.searchandtype(type,keyword);
        model.addAttribute("meetings",meetings);
        return "search/meeting";
    }
    @GetMapping("/newslist/category/{type}/{keyword}")
    public String newsType(@PathVariable("type")String type,@PathVariable("keyword") String keyword, Model model) {
        if(keyword.length()>100){
            model.addAttribute("msg","搜索内容不可以超过100个字符");
            return "search/meeting";
        }
        List<News> newslist = newsService.searchandtype(type,keyword);
        model.addAttribute("newslist",newslist);
        return "search/news";
    }
    @GetMapping("/papers/category/{type}/{keyword}")
    public String paperType(@PathVariable("type")String type,@PathVariable("keyword") String keyword, Model model) {
        if(keyword.length()>100){
            model.addAttribute("msg","搜索内容不可以超过100个字符");
            return "search/meeting";
        }
        List<Paper> papers = paperService.searchandtype(type,keyword);
        model.addAttribute("papers",papers);
        return "search/paper";
    } @GetMapping("/visitor/meetings/category/{type}/{keyword}")
    public String VmeetingType(@PathVariable("type")String type,@PathVariable("keyword") String keyword, Model model) {
        if(keyword.length()>100){
            model.addAttribute("msg","搜索内容不可以超过100个字符");
            return  "search/visitor/meeting";
        }
        List<Meeting> meetings = meetingService.searchandtype(type,keyword);
        model.addAttribute("meetings",meetings);
        return "search/visitor/meeting";
    }
    @GetMapping("/visitor/newslist/category/{type}/{keyword}")
    public String VnewsType(@PathVariable("type")String type,@PathVariable("keyword") String keyword, Model model) {
        if(keyword.length()>100){
            model.addAttribute("msg","搜索内容不可以超过100个字符");
            return  "search/visitor/meeting";
        }
        List<News> newslist = newsService.searchandtype(type,keyword);
        model.addAttribute("newslist",newslist);
        return "search/visitor/news";
    }
    @GetMapping("/visitor/papers/category/{type}/{keyword}")
    public String VpaperType(@PathVariable("type")String type,@PathVariable("keyword") String keyword, Model model) {
        if(keyword.length()>100){
            model.addAttribute("msg","搜索内容不可以超过100个字符");
            return  "search/visitor/meeting";
        }
        List<Paper> papers = paperService.searchandtype(type,keyword);
        model.addAttribute("papers",papers);
        return "search/visitor/paper";
    }
}
