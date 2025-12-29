package com.example.bcsd.Controller;

import com.example.bcsd.Service.MemberService;
import com.example.bcsd.model.Member;
import com.example.bcsd.dto.MemberCreateRequest;
import com.example.bcsd.dto.MemberUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.findAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.findMember(id));
    }

    @PostMapping
    public ResponseEntity<Member> createMember(
            @RequestBody MemberCreateRequest request
    ) {
        Member saved = memberService.createMember(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(
            @PathVariable Long id,
            @RequestBody MemberUpdateRequest request
    ) {
        Member updated = memberService.updateMember(
                id,
                request.getName(),
                request.getPassword()
        );
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }
}
