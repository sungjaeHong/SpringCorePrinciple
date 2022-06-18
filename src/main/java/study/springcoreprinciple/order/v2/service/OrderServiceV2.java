package study.springcoreprinciple.order.v2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.springcoreprinciple.order.domain.TraceId;
import study.springcoreprinciple.order.domain.TraceStatus;
import study.springcoreprinciple.order.support.HelloTraceV2;
import study.springcoreprinciple.order.v2.repository.OrderRepositoryV2;

/**
 * Created by peter on 2022/06/18
 */
@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderService.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        } }

}

