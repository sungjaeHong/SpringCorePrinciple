package study.springcoreprinciple.order.v3.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.springcoreprinciple.order.domain.TraceStatus;
import study.springcoreprinciple.order.support.HelloTraceV1;
import study.springcoreprinciple.order.support.LogTrace;

/**
 * Created by peter on 2022/06/18
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId) { //저장 로직
        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.save()"); //저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
