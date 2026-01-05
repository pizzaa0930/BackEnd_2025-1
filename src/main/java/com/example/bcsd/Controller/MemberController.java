package com.example.bcsd.Controller;

import com.example.bcsd.Service.MemberService;
import com.example.bcsd.dto.MemberCreateRequest;
import com.example.bcsd.dto.MemberLoginRequest;
import com.example.bcsd.dto.MemberUpdateRequest;
import com.example.bcsd.model.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private static final String LOGIN_MEMBER_ID = "LOGIN_MEMBER_ID";

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> findAll() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findMember(id));
    }

    @PostMapping
    public ResponseEntity<Member> create(@RequestBody MemberCreateRequest request) {
        return ResponseEntity.ok(memberService.createMember(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> update(
            @PathVariable Long id,
            @RequestBody MemberUpdateRequest request
    ) {
        return ResponseEntity.ok(memberService.updateMember(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Member> login(
            @RequestBody MemberLoginRequest request,
            HttpSession session
    ) {
        Member member = memberService.login(request);
        session.setAttribute(LOGIN_MEMBER_ID, member.getId());
        return ResponseEntity.ok(member);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.noContent().build();
    }
}
