package study.springcoreprinciple.order.v2.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.springcoreprinciple.order.domain.TraceId;
import study.springcoreprinciple.order.domain.TraceStatus;
import study.springcoreprinciple.order.support.HelloTraceV2;

/**
 * Created by peter on 2022/06/18
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderRepository.save()"); //저장 로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
