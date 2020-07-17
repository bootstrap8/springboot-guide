package com.fit.h2;

import com.fit.common.response.ResponseVo;
import com.fit.common.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-04-25
 */
@Slf4j
//@Component
//@RestController
public class Worker {

    private BlockingQueue<Message> queue = new LinkedBlockingDeque();


    private Thread sender;
    private volatile boolean running = true;
    private AtomicInteger resetCounter = new AtomicInteger(0);


    @PostConstruct
    public void readyGo() {
        new Maker("MakerThread").start();
        sender = new Sender("SenderThread");
        sender.start();
        log.info("Worker start successfully!");
    }

    @RequestMapping(value = "/resetSender", method = RequestMethod.POST)
    public ResponseVo reset() throws InterruptedException {
        log.info("meet reset request");
        sender.interrupt();
        running = false;
        log.info("interrupt Sender Over!");
        Thread.sleep(1000);
        log.info("senderThread isInterrupted:{}, isAlive:{}", sender.isInterrupted(), sender.isAlive());
        log.info("senderThread State: {}", JsonUtil.toJson(sender.getState()));
        if (Thread.State.TERMINATED == sender.getState() && !sender.isAlive()) {
            //heartbeat test
            running = true;
            resetCounter.incrementAndGet();
            sender = new Sender("SenderThread-" + resetCounter.get());
            sender.start();
            log.info("reOpen Sender Thread successfully!");
        }
        log.info("reset Sender : {}", resetCounter.get());
        return ResponseVo.okFrom("Reset Times: " + resetCounter.get());
    }

    @RequestMapping(value = "/stackTrace", method = RequestMethod.POST)
    public ResponseVo<String> stackTrace() {
        log.info("meet stackTrace request");
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            sb.append("线程:" + entry.getKey().getName() + ", State:" + entry.getKey().getState() + "\n");
            for (StackTraceElement element : entry.getValue()) {
                sb.append("\t" + element + "\n");
            }

        }
        return ResponseVo.okFrom(sb.toString());
    }


    @Data
    @AllArgsConstructor
    class Message {
        private Long id;
        private String name;

    }


    class Maker extends Thread {
        public Maker(String name) {
            super(name);
        }

        @Override
        public void run() {
            AtomicLong counter = new AtomicLong(0);
            for (; ; ) {
                counter.incrementAndGet();
                Message msg = new Message(counter.get(), "Message-" + counter.get());
                queue.offer(msg);
                log.info("offer Message : {},  size:{}", msg, queue.size());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Sender extends Thread {
        public Sender(String name) {
            super(name);
        }

        @Override
        public void run() {

            while (running) {
                try {
                    Message msg = queue.poll(1000, TimeUnit.MILLISECONDS);
                    if (msg != null) {
                        log.info("consumer Message : {}", msg);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}
