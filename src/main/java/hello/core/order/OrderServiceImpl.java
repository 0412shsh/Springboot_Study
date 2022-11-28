package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();  //DAO에서 회원정보를 찾아야 해서 필요
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 고정 할인 정책이 필요함




    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 1. 회원 정보 찾기
        int discountPrice = discountPolicy.discount(member, itemPrice); // 2. 회원이랑, 아이템가격을 통해 할인가격 추출

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
