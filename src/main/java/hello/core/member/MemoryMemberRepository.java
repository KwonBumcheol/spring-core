package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository { // 메모리 회원 저장소

    private static Map<Long, Member> store = new HashMap<>(); // ConcurrentHashMap<>() 권장 - 동시성 처리 성능 우수

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
