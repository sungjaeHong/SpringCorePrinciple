package study.springcoreprinciple.order.threadlocal.code;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by peter on 2022/06/18
 */
@Slf4j
@Getter @Setter
public class ThreadLocalService {
    private ThreadLocal<String> nameStore = new ThreadLocal<>();
    public String logic(String name) {
        log.info("저장 name={} -> nameStore={}", name, nameStore.get());
        nameStore.set(name);
        sleep(1000);
        log.info("조회 nameStore={}",nameStore.get());
        return nameStore.get();
    }
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
