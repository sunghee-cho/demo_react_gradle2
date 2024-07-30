package sse2;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EmitterRepository {

    // 유저ID를 키로 SseEmitter를 해시맵에 저장할 수 있도록 구현했다.
    private Map<String, SseEmitter> emitterMap = new ConcurrentHashMap<>();//동시성 문제 해결을 위해 ConcurrentHashMap 사용

    public SseEmitter save(Long userId, SseEmitter sseEmitter) {
        emitterMap.put(getKey(userId), sseEmitter);
        log.info("Saved SseEmitter for {}", userId);
        get(userId);
        return sseEmitter;
    }

    public Optional<SseEmitter> get(Long userId) {
        log.info("Get SseEmitter for {}", userId);
        //SseEmitter sseEmitter = emitterMap.get(getKey(userId));
        //System.out.println("===> "+sseEmitter);
        
        return Optional.ofNullable(emitterMap.get(getKey(userId)));
    }

    public void delete(Long userId) {
        emitterMap.remove(getKey(userId));
        log.info("Deleted SseEmitter for {}", userId);
    }

    private String getKey(Long userId) {
        return "Emitter:UID:" + userId;
    }
}
