package spring.project3_java.member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
