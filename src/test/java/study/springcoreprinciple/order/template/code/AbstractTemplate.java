package study.springcoreprinciple.order.template.code;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by peter on 2022/06/26
 */
@Slf4j
public abstract class AbstractTemplate {
    public void execute() {
        long startTime = System.currentTimeMillis();
        // 비지니스 로직 실행
        call();
        // 비지니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    protected abstract void call();
}
