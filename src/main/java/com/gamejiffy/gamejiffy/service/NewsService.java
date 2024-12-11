package com.gamejiffy.gamejiffy.service;

import com.gamejiffy.gamejiffy.model.News;
import com.gamejiffy.gamejiffy.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class NewsService {
    @Autowired
    private NewsRepository repository;

    public void saveNews(News news) {
        repository.save(news);
    }
     public List<News> getAllNews() {
        return repository.findAll(); 
    }
}
