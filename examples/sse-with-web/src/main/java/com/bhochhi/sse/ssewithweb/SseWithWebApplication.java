package com.bhochhi.sse.ssewithweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class SseWithWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SseWithWebApplication.class, args);
	}

}


@RestController
@RequestMapping("/sse")
class SSEController {

	@GetMapping
	public String getHelloWorld(){
		return "hello world";
	}

	@GetMapping("/stream-sse-mvc")
	public SseEmitter streamSseMvc() {
		SseEmitter emitter = new SseEmitter();
		ExecutorService sseMvcExecutor = Executors.newSingleThreadExecutor();
		sseMvcExecutor.execute(() -> {
			try {
				for (int i = 0; true; i++) {
					SseEmitter.SseEventBuilder event = SseEmitter.event()
							.data("SSE MVC - " + LocalTime.now().toString())
							.id(String.valueOf(i))
							.name("sse event - mvc");
					emitter.send(event);
					Thread.sleep(1000);
				}
			} catch (Exception ex) {
				emitter.completeWithError(ex);
			}
		});
		return emitter;
	}

}
