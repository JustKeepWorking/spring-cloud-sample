package com.github.nduyhai.logsink;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class LogSinkApplication {

  private static final Logger LOG = LoggerFactory.getLogger(LogSinkApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(LogSinkApplication.class, args);
  }

  @StreamListener(Sink.INPUT)
  public void loggerSink(String date) {
    LOG.info("Received: {}", date);
  }
}
