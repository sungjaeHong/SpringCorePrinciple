package study.springcoreprinciple.order.v1.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.springcoreprinciple.order.domain.TraceStatus;
import study.springcoreprinciple.order.support.HelloTraceV1;
import study.springcoreprinciple.order.v1.service.OrderServiceV1;

/**
 * Created by peter on 2022/06/18
 */

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 trace;


    @GetMapping("/v1/request")
    public String request(String itemId) {
        TraceStatus status = null;
        status = trace.begin("OrderController.request()");
        try {
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
