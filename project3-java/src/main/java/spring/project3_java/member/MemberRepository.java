package spring.project3_java.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
