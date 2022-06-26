package study.springcoreprinciple.order.v4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.springcoreprinciple.order.domain.TraceStatus;
import study.springcoreprinciple.order.support.AbstractTemplate;
import study.springcoreprinciple.order.support.LogTrace;
import study.springcoreprinciple.order.v4.repository.OrderRepositoryV4;

/**
 * Created by peter on 2022/06/18
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.execute("OrderService.orderItem()");
    }
}

