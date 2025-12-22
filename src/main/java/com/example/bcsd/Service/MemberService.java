package com.example.bcsd.Service;

import com.example.bcsd.Repository.MemberRepository;
import com.example.bcsd.model.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(String name, String email, String password) {
        Member member = new Member(name, email, password);
        memberRepository.save(member);
        return member;
    }

    public Member findMember(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Member updateMember(Long id, String name, String email, String password) {
        Member member = memberRepository.findById(id);
        if (member == null) {
            throw new RuntimeException("회원을 찾을 수 없습니다. id=" + id);
        }
        member.setName(name);
        member.setEmail(email);
        member.setPassword(password);
        return memberRepository.update(member);
    }

    public void deleteMember(Long id) {
        memberRepository.delete(id);
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
