package com.example.bcsd.Service;

import com.example.bcsd.model.Member;
import com.example.bcsd.Repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void createMember(Member member) {
        memberRepository.save(member);
    }
    @Transactional
    public void updateMember(Member member) {
        memberRepository.update(member);
    }
    @Transactional
    public void deleteMember(Long id) {
        memberRepository.delete(id);
    }
}
