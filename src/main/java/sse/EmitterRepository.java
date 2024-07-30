package sse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EmitterRepository {

    // 유저ID를 키로 SseEmitter를 해시맵에 저장할 수 있도록 구현했다.
    private Map<String, SseEmitter> emitterMap = new HashMap<>();

    public SseEmitter save(String userId, SseEmitter sseEmitter) {
        emitterMap.put(getKey(userId), sseEmitter);
        log.info("Saved SseEmitter for {}", userId);
        return sseEmitter;
    }

    /*public Optional<SseEmitter> get(String userId) {
        log.info("Got SseEmitter for {}", userId);
        return Optional.ofNullable(emitterMap.get(getKey(userId)));
    }
*/
    
    public Map<String, SseEmitter> get(String userId){
        log.info("Got SseEmitter for {}", userId);
        return emitterMap;
    }
    public void deleteById(String userId) {
        emitterMap.remove(getKey(userId));
        log.info("Deleted SseEmitter for {}", userId);
    }

    private String getKey(String userId) {
        return "Emitter:UID:" + userId;
    }
}
