package study.springcoreprinciple.order.v2.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.springcoreprinciple.order.domain.TraceStatus;
import study.springcoreprinciple.order.support.HelloTraceV2;
import study.springcoreprinciple.order.v2.service.OrderServiceV2;

/**
 * Created by peter on 2022/06/18
 */

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;


    @GetMapping("/v2/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
