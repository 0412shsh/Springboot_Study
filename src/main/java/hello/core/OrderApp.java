package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        //MemberService memberService = new MemberServiceImpl(null);
       // OrderService orderService = new OrderServiceImpl(null,null);

        Long memberId = 1L; // 회원 아이디 선언
        Member member = new Member(memberId, "memberA", Grade.VIP);// 회원 입력 정보 - 아이디, 이름, 등급
        memberService.join(member); // 회원가입 동작

        //주문 생성
        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order : "+order);
        // System.out.println("order.calculatePrice : "+order.calculatePrice());



    }
}
