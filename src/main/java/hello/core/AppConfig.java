package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //생성자 주입 ; 실제 impl 들어가면 MemoryMemberReposioty 관련 메서드를 발견할 수 없음
    @Bean
    public MemberService memberService (){
        return new MemberServiceImpl(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    //생성자 주입
    @Bean
    public OrderService orderService (){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }


    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy(); // 할인정책에 대한 구체 클래스를 교체한다.
    }
}
