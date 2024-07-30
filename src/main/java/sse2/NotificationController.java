package sse2;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    
    //최초에 로그인 뷰 생성
    @GetMapping("/start")
    public String start() {
    	return "sse/notification";
    }
    
    //로그인되면 로그인검증과정 거친 후에 알림서비스 받기 위해 서버로 연결(=구독=subscribe)
    //이후로는 해당 사용자에게 알림이 발생하는 대로 자동으로 서버가 사용자에게 알림 push해줌
    @GetMapping(value = "/subscribe/{id}", produces = "text/event-stream;charset=utf-8")
    @ResponseBody
    public SseEmitter subscribe(@PathVariable("id") Long id ) {
    	log.info("컨트롤러 : " + id);
        // Authentication을 UserDto로 업캐스팅
        //UserDto userDto = ClassUtils.getCastInstance(authentication.getPrincipal(), UserDto.class)
        //        .orElseThrow(() -> new ApplicationException(ErrorCode.INTERNAL_SERVER_ERROR,
        //                "Casting to UserDto class failed"));
        
        // 서비스를 통해 생성된 SseEmitter를 반환
        return notificationService.connectNotification(id);
    }
    
  //알림을 생성하는 notificationService.send 메소드 호출하여 1,2번 사용자 2명에게 10개의 알림 생성하도록 함.
  //알림이 생성될 때마다 해당 사용자의 브라우저에 알림내용 push됨
   @GetMapping("/createnotice")
   @ResponseBody
   public void createNotification() throws Exception {
	   for(int i = 1; i <= 10; i++) {
		   Thread.sleep(500);
		   notificationService.send(1L, Long.valueOf(i), "user1 : 알림" + i); 
		   notificationService.send(2L, Long.valueOf(i), "user2 : 알림" + i); 
 	   }
   }
}



