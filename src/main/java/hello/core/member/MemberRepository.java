package hello.core.member;

public interface MemberRepository {

    void save(Member member); //Member 정보를 가지고 저장

    Member findById(Long memberId); //회원의 아이디로 회원을 찾는 기능




}
