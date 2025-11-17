package com.example.bcsd.Service;

import com.example.bcsd.Repository.MemberRepository;
import com.example.bcsd.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        memberRepository.save(member);
        return member;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member updateMember(Member member) {
        Member existing = memberRepository.findById(member.getId());
        if (existing == null) {
            return null;
        }

        existing.setName(member.getName());
        existing.setEmail(member.getEmail());
        existing.setPassword(member.getPassword());

        memberRepository.update(existing);
        return existing;
    }

    public void deleteMember(Long id) {
        memberRepository.delete(id);
    }
}
