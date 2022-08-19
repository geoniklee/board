package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j //로깅을 위한 어노테이션
public class ArticleController {

    @Autowired//스프링 부트가 미리 만들어놓은 객체를 가져다가 자동 연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createString(ArticleForm form){
        //System.out.println(form.toString()); -> 로깅기능으로 대체
        log.info(form.toString());

        //1. DTO를 entity로 변환!
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());

        //2. Repository에게 entity를 DB안에 저장하게 함.
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getID();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id="+id);
        //1.id로 데이터를 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //2.가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);
        //3.보여줄 페이지를 설정

        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        //1. 모든 Article을 가져온다!
        List<Article> articleEntityList=articleRepository.findAll();

        //2. 가져온 Article 묶음을 뷰로 전달
        model.addAttribute("articleList",articleEntityList);

        //3. 뷰 페이지를 설정
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        //수정할 데이터를 가져와야함.
        Article articleEntity = articleRepository.findById(id).orElse(null);

        //모델에 데이터 등록
        model.addAttribute("article", articleEntity);

        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form){
        log.info(form.toString());
        //1. DTO를 엔티티로 변환
        Article articleEntity=form.toEntity();
        log.info(articleEntity.toString());

        //2. 엔티티를 DB로 저장한다.
        Article target = articleRepository.findById(articleEntity.getID()).orElse(null);
        //2-1: DB에서 기존 데이터를 갖고온다.
        if (target != null){
            articleRepository.save(articleEntity);
        }


        //2-2

        //3.수정 결과 페이지로 리다이렉트한다.


        return "redirect:/articles/" + articleEntity.getID();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제요청이 들어왔습니다!");

        //1. 삭제 대상을 가져온다.
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());

        //2. 대상을 삭제한다.
        if (target != null){
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg","delete complete");
        }

        //3. 결과 페이지로 리다이렉트한다.
        return "redirect:/articles";
    }
}
