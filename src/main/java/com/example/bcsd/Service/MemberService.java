package com.example.bcsd.Service;

import com.example.bcsd.Repository.MemberRepository;
import com.example.bcsd.Repository.ArticleRepository;
import com.example.bcsd.model.Member;
import com.example.bcsd.Exception.MemberNotFoundException;
import com.example.bcsd.Exception.EmailConflictException;
import com.example.bcsd.Exception.InvalidInputException;
import com.example.bcsd.Exception.MemberDeleteException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    public MemberService(MemberRepository memberRepository, ArticleRepository articleRepository) {
        this.memberRepository = memberRepository;
        this.articleRepository = articleRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        try {
            return memberRepository.findById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new MemberNotFoundException(id);
        }
    }

    @Transactional
    public void createMember(Member member) {
        if (member == null || member.getName() == null || member.getEmail() == null) {
            throw new InvalidInputException("null값이 존재합니다");
        }
        memberRepository.save(member);
    }

    @Transactional
    public void updateMember(Member member) {
        if (member == null || member.getId() == null || member.getEmail() == null) {
            throw new InvalidInputException("null값이 존재합니다");
        }
        List<Member> all = memberRepository.findAll();
        boolean conflict = all.stream()
                .anyMatch(m -> !Objects.equals(m.getId(), member.getId())
                        && Objects.equals(m.getEmail(), member.getEmail()));
        if (conflict) {
            throw new EmailConflictException(member.getEmail());
        }
        memberRepository.update(member);
    }

    @Transactional
    public void deleteMember(Long id) {
        List<?> articles = articleRepository.findByBoardId(id);
        if (!articles.isEmpty()) {
            throw new MemberDeleteException(id);
        }
        memberRepository.delete(id);
    }
}
