package com.cqszw.demo.Service;


import com.cqszw.demo.Bean.News;
import com.cqszw.demo.Mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsMapper newsMapper;
    public List<News> getAll(){return newsMapper.getAll();}
    public List<News> getNewsByType(String type) {return newsMapper.getNewsByType(type);};
    public News getById(int id){return  newsMapper.getbyid(id);}
    public int insertNews(News news) {
        return  newsMapper.insertNews(news);
    }

    public int updateNews(News news, News will_alter) {
        return  newsMapper.updateNews(news.getTitle(),news.getContent(),news.getType(),will_alter.getId());
    }

    public int deleteNews(int id) {
        return  newsMapper.deleteNews(id);
    }
    public int viewcount(News news){return  newsMapper.viewcount(news.getViewcount(),news.getId());}
    public List<News> search(String keyword){return newsMapper.search(keyword);}
    public List<News> searchandtype(String type,String keyword){return newsMapper.searchadntype(type,keyword);}
}
