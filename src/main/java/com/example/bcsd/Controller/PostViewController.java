package com.example.bcsd.Controller;

import com.example.bcsd.Service.ArticleService;
import com.example.bcsd.Service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostViewController {

    private final ArticleService articleService;
    private final MemberService memberService;

    public PostViewController(ArticleService articleService, MemberService memberService) {
        this.articleService = articleService;
        this.memberService = memberService;
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        model.addAttribute("members", memberService.getAllMembers());
        return "posts";   // templates/posts.html
    }
}
