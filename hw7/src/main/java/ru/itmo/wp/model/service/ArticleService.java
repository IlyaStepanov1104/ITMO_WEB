package ru.itmo.wp.model.service;

import ru.itmo.wp.model.domain.Article;
import com.google.common.base.Strings;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.repository.ArticleRepository;
import ru.itmo.wp.model.repository.impl.ArticleRepositoryImpl;

import java.util.List;

public class ArticleService {

    private final ArticleRepository articleRepository = new ArticleRepositoryImpl();

    public void validatePost(Article article) throws ValidationException{
        String title = article.getTitle().trim();
        String text = article.getText().trim();
        if (Strings.isNullOrEmpty(title)) {
            throw new ValidationException("No Title");
        }
        if (title.length() > 30) {
            throw new ValidationException("Title can't be longer than 30 characters");
        }
        if (Strings.isNullOrEmpty(text)) {
            throw new ValidationException("No Text");
        }
        if (text.length() > 350) {
            throw new ValidationException("Article can't be longer than 350 characters");
        }
    }

    public void save(Article article) {
        articleRepository.save(article);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
