package study.springcoreprinciple.order.v4.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.springcoreprinciple.order.domain.TraceStatus;
import study.springcoreprinciple.order.support.AbstractTemplate;
import study.springcoreprinciple.order.support.LogTrace;

/**
 * Created by peter on 2022/06/18
 */
@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) { //저장 로직
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생!");
                }
                sleep(1000);
                return null;
            }
        };
        template.execute("OrderRepository.save()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
