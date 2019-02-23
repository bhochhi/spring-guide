package com.bhochhi.sse.ssewithweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.time.LocalTime;
import java.util.Date;
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

	private ExecutorService nonBlockingService = Executors.newCachedThreadPool();


	@GetMapping
	public String getHelloWorld(){
		return "hello world";
	}

	@GetMapping("/emitter")
	public SseEmitter streamSseMvc() {
		SseEmitter emitter = new SseEmitter();
		ExecutorService sseMvcExecutor = Executors.newSingleThreadExecutor();
		sseMvcExecutor.execute(() -> {
			try {
				for (int i = 0; i<5; i++) {
					SseEmitter.SseEventBuilder event = SseEmitter.event()
							.data("SSE MVC - " + LocalTime.now().toString())
							.id(String.valueOf(i))
							.name("data");
					emitter.send(event);
					Thread.sleep(1000);
				}
			} catch (Exception ex) {
				emitter.completeWithError(ex);
			}
		});
		return emitter;
	}
	@GetMapping("/emmiter-non-blocking")
	public SseEmitter handleSse() {
		SseEmitter emitter = new SseEmitter();

		nonBlockingService.execute(() -> {
			try {
				emitter.send( "From a Response Body Emitter! @ " + new Date());
				emitter.complete();
			} catch (Exception ex) {
				ex.printStackTrace();
				emitter.completeWithError(ex);
			}
		});

		return emitter;
	}


	@GetMapping("/response-body-emitter")
	public ResponseEntity<ResponseBodyEmitter> handleRbe() {
		ResponseBodyEmitter emitter = new ResponseBodyEmitter();
		nonBlockingService.execute(() -> {
			try {
				emitter.send(
						"/response-body-emitter" + " @ " + new Date(), MediaType.TEXT_PLAIN);
				emitter.complete();
			} catch (Exception ex) {
				emitter.completeWithError(ex);
			}
		});
		return new ResponseEntity(emitter, HttpStatus.OK);
	}

	@GetMapping("/stream-responsebody")
	public ResponseEntity<StreamingResponseBody> responsebodyStream() {
		StreamingResponseBody stream = out -> {
			String msg = "From StreamingResponseBody @ " + new Date();
			out.write(msg.getBytes());
		};
		return new ResponseEntity(stream, HttpStatus.OK);
	}



}
