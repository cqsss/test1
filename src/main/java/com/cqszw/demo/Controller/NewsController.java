package com.cqszw.demo.Controller;

import com.cqszw.demo.Bean.News;
import com.cqszw.demo.Service.NewsService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;
    private News will_alter;
    @GetMapping("/newslist")
    public String list(Model model){
        List<News> newsList=newsService.getAll();
        //查询所有新闻返回列表页面
        model.addAttribute("newslist",newsList);
        return  "news/management";
    }
    @GetMapping("/newslist/category/{type}")
    public String newsType(@PathVariable("type")String type, Model model) {
        List<News> newslist = newsService.getNewsByType(type);
        model.addAttribute("newslist",newslist);
        return "news/management";
    }
    @GetMapping("/news")
    public  String toAddNews(Model model){
        return  "news/add";
    }
    @PostMapping("/news")
    public String addNews(News news,Model model){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String date=df.format(new Date());
        news.setPublishdate(date);
        if(news.getTitle().isEmpty()){
            model.addAttribute("msg","标题不能为空");
            return  "news/add";
        }
        if(news.getTitle().length()>100){
            model.addAttribute("msg","标题不能超过100个字符");
            return  "news/add";
        }
        if(news.getContent().length()>4000){
            model.addAttribute("msg","内容不能超过4000个字符");
            return  "news/add";
        }
        newsService.insertNews(news);
        //最后回到员工列表页面
        return  "redirect:/newslist";
    }

    @GetMapping("/news/{id}")
    public String alter(@PathVariable("id")int id, Model model){

        News news = newsService.getById(id);
        will_alter=news;
        model.addAttribute("news",news);
        return  "news/alter";
    }
    @PutMapping("/news")
    public String update(News news,Model model){
        if(will_alter!=null){
            if(news.getTitle().isEmpty()){
                model.addAttribute("msg","标题不能为空");
                return  "news/alter";
            }
            if(news.getTitle().length()>100){
                model.addAttribute("msg","标题不能超过100个字符");
                return  "news/alter";
            }
            if(news.getContent().length()>4000){
                model.addAttribute("msg","内容不能超过4000个字符");
                return  "news/alter";
            }
            newsService.updateNews(news,will_alter);
        }
        return "redirect:/newslist";
    }
    @DeleteMapping("/news/{id}")
    public String delete(@PathVariable("id")int id) {
        newsService.deleteNews(id);
        return "redirect:/newslist";
    }
}
