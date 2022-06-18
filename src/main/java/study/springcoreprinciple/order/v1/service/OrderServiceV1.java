package study.springcoreprinciple.order.v1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.springcoreprinciple.order.domain.TraceStatus;
import study.springcoreprinciple.order.support.HelloTraceV1;
import study.springcoreprinciple.order.v1.repository.OrderRepositoryV1;

/**
 * Created by peter on 2022/06/18
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV1 {
    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}

