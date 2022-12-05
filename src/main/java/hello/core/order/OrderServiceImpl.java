package hello.core.order;


import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;


public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;  //DAO에서 회원정보를 찾아야 해서 필요

    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 1. 회원 정보 찾기
        int discountPrice = discountPolicy.discount(member, itemPrice); // 2. 회원이랑, 아이템가격을 통해 할인가격 추출

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
