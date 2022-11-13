package com.example.springcore2logtracker.app.v3;

import com.example.springcore2logtracker.trace.TraceId;
import com.example.springcore2logtracker.trace.TraceStatus;
import com.example.springcore2logtracker.trace.hellotrace.HelloTraceV2;
import com.example.springcore2logtracker.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.request()");

            if(itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }

            sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }



    }

    private void sleep(int millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
