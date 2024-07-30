package sse2;


import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {
    private final static Long DEFAULT_TIMEOUT = 3600000L;//1시간 60*60*1000
    private final static String NOTIFICATION_NAME = "notification";

    private final EmitterRepository emitterRepository;

    public SseEmitter connectNotification(Long userId) {
        // 새로운 SseEmitter를 만든다
        SseEmitter sseEmitter = new SseEmitter(DEFAULT_TIMEOUT);

        // 유저 ID로 SseEmitter를 저장한다.
        emitterRepository.save(userId, sseEmitter);

        // 세션이 종료될 경우 저장한 SseEmitter를 삭제한다.
        sseEmitter.onCompletion(() -> emitterRepository.delete(userId));
        sseEmitter.onTimeout(() -> emitterRepository.delete(userId));

        // 503 Service Unavailable 오류가 발생하지 않도록 첫 데이터를 보낸다.
        try {
            sseEmitter.send(SseEmitter.event().id(String.valueOf(userId)).name(NOTIFICATION_NAME).data("Connection completed"));
        } catch (IOException exception) {
            //throw new ApplicationException(ErrorCode.NOTIFICATION_CONNECTION_ERROR);
        	System.out.println("ErrorCode.NOTIFICATION_CONNECTION_ERROR발생");
        }
        return sseEmitter;
    }
    //사용자id, 알림이벤트아이디, 알림내용을 전달받아 sse로 클라이언트에 push
    public void send(Long userId, Long notificationId, String notification) {
        // 유저 ID로 SseEmitter를 찾아 이벤트를 발생 시킨다.
    	/*Optional.ifPresentOrElse(존재시실행할컬백함수, else일때실행할컴백함수) - 현재 else 이면 () -> log.info("No emitter found") 를 실핸한다*/
        emitterRepository.get(userId).ifPresentOrElse(sseEmitter -> {
            try {
                sseEmitter.send(SseEmitter.event().id(notificationId.toString()).name(NOTIFICATION_NAME).data(notification));
            } catch (IOException exception) {
        // IOException이 발생하면 저장된 SseEmitter를 삭제하고 예외를 발생시킨다.
                emitterRepository.delete(userId);
                //throw new ApplicationException(ErrorCode.NOTIFICATION_CONNECTION_ERROR);
                System.out.println("ErrorCode.NOTIFICATION_CONNECTION_ERROR발생");
            }
        }, () -> System.out.println("No emitter found"));
    }
}