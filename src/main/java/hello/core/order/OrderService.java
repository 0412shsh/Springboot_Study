package hello.core.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
    // 주문 생성 : 회원 아이디, 상품이름, 상품가격 넘기면 최종 오더 결과를 반환

}
