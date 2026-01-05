package com.example.bcsd.Controller;

import com.example.bcsd.Service.MemberService;
import com.example.bcsd.dto.MemberLoginRequest;
import com.example.bcsd.model.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Member> login(
            @RequestBody MemberLoginRequest request,
            HttpSession session
    ) {
        Member member = memberService.login(request);

        session.setAttribute("LOGIN_MEMBER_ID", member.getId());

        return ResponseEntity.ok(member);
    }
}
