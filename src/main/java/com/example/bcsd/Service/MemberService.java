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
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member findMember(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("회원을 찾을 수 없습니다. id=" + id)
                );
    }

    @Transactional(readOnly = true)
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Member updateMember(Long id, String name, String password) {
        Member member = findMember(id);
        member.changeName(name);
        member.changePassword(password);
        return member;
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException("회원을 찾을 수 없습니다. email=" + email)
                );
    }
}
