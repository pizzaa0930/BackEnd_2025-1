package com.example.bcsd.Service;

import com.example.bcsd.model.Member;
import com.example.bcsd.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public void createMember(Member member) {
        memberRepository.save(member);
    }

    public void updateMember(Member member) {
        memberRepository.update(member);
    }

    public void deleteMember(Long id) {
        memberRepository.delete(id);
    }
}
