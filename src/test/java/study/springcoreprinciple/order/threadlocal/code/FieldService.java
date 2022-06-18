package study.springcoreprinciple.order.threadlocal.code;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by peter on 2022/06/18
 */
@Slf4j
@Getter @Setter
public class FieldService {
    private String nameStore;

    public String logic(String name) {
        log.info("저장 name={} -> nameStore={}", name, nameStore); nameStore = name;
        sleep(1000);
        log.info("조회 nameStore={}",nameStore);
        return nameStore;
    }
    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
