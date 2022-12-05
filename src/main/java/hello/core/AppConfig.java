package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    //생성자 주입 ; 실제 impl 들어가면 MemoryMemberReposioty 관련 메서드를 발견할 수 없음
    public MemberService memberService (){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    //생성자 주입
    public OrderService orderService (){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }


}
