<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Notification Test Page</title>
</head>
<body>
    <input type="text" id="id"/>
    <button type="button" onclick="login()">로그인</button>
    <div>여기에 알림을 보여주세요</div>
    <div id="noti"></div>
     <script type="text/javaScript">
    function login() {
    	
        const id = document.getElementById('id').value;

        const eventSource = new EventSource(`/notification/subscribe/` + id);
        alert("eventSource 생성");
        
  	  	eventSource.addEventListener("open", function(event) {
	        alert("open 이벤트 발생");
	        
  	  	});//open 이벤트
  	  	
       eventSource.addEventListener("notification", function(event) {
	        //alert("notification 이벤트 발생");//서버에서 보내는 이름으로 이벤트명 준다
	        console.log(event);
            console.log(event.lastEventId + ":" + event.data + ":" + event.origin);
            document.getElementById('noti').innerHTML += "==>"+ event.data +"<br>";
       });
    }
 	</script> 	  	
</body>
</html>
<!-- <script type="text/javaScript">
    function login() {
    	
        const id = document.getElementById('id').value;

        const eventSource = new EventSource(`/notification/subscribe/` + id);
        alert("eventSource 생성");
        
  	  	eventSource.addEventListener("open", function(event) {
	        alert("open 이벤트 발생");
	        
  	  	});//open 이벤트
  	  	
       eventSource.addEventListener("notification", function(event) {
	        alert("notification 이벤트 발생");//서버에서 보내는 이름으로 이벤트명 준다
            console.log(event.data);
            //document.getElementById('noti').innerHTML += "==>"+ event.data +"<br>";
            /*const data = JSON.parse(event.data);

            (async () => {
                // 브라우저 알림
                const showNotification = () => {
                    
                    const notification = new Notification('코드 봐줘', {
                        body: data.content
                    });
                    
                    setTimeout(() => {
                        notification.close();
                    }, 10 * 1000);
                    
                    notification.addEventListener('click', () => {
                        window.open(data.url, '_blank');
                    });
                }

                // 브라우저 알림 허용 권한
                let granted = false;

                if (Notification.permission === 'granted') {
                    granted = true;
                } else if (Notification.permission !== 'denied') {
                    let permission = await Notification.requestPermission();
                    granted = permission === 'granted';
                }

                // 알림 보여주기
                if (granted) {
                    showNotification();
                }
            })();
            */
        });//notification 이벤트

    }
</script>
-->