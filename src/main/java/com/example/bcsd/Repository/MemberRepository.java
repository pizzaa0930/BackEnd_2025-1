package com.example.bcsd.Repository;

import com.example.bcsd.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemberRepository {

    private final List<Member> members = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(0);

    public List<Member> findAll() {
        return members;
    }

    public Member findById(Long id) {
        for (Member m : members) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }

    public Member findByEmail(String email) {
        for (Member m : members) {
            if (m.getEmail().equals(email)) {
                return m;
            }
        }
        return null;
    }

    public void save(Member member) {
        if (member.getId() == null) {
            member.setId(counter.incrementAndGet());
        }
        members.add(member);
    }

    public void update(Member member) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getId().equals(member.getId())) {
                members.set(i, member);
                return;
            }
        }
    }

    public void delete(Long id) {
        Member m = findById(id);
        if (m != null) {
            members.remove(m);
        }
    }
}
