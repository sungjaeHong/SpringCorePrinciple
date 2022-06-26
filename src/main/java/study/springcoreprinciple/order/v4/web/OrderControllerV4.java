package study.springcoreprinciple.order.v4.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.springcoreprinciple.order.domain.TraceStatus;
import study.springcoreprinciple.order.support.AbstractTemplate;
import study.springcoreprinciple.order.support.LogTrace;
import study.springcoreprinciple.order.v4.service.OrderServiceV4;

/**
 * Created by peter on 2022/06/18
 */

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;


    @GetMapping("/v4/request")
    public String request(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };
        return template.execute("OrderController.request()");
    }
}
