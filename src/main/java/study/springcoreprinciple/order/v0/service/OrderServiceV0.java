package study.springcoreprinciple.order.v0.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import study.springcoreprinciple.order.v0.repository.OrderRepositoryV0;

/**
 * Created by peter on 2022/06/18
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV0 {
    private final OrderRepositoryV0 orderRepository;

    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}

