package com.example.bcsd.Service;

import com.example.bcsd.Repository.MemberRepository;
import com.example.bcsd.dto.MemberCreateRequest;
import com.example.bcsd.dto.MemberLoginRequest;
import com.example.bcsd.dto.MemberUpdateRequest;
import com.example.bcsd.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Member findMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }

    public Member createMember(MemberCreateRequest request) {
        Member member = new Member(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, MemberUpdateRequest request) {
        Member member = findMember(id);
        member.changeName(request.getName());
        member.changePassword(request.getPassword());
        return member;
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public Member login(MemberLoginRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));

        if (!member.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return member;
    }

    public Member login(String email, String password) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));

        if (!member.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return member;
    }
}
