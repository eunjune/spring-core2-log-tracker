package com.example.springcore2logtracker.trace.proxy.pureproxy.decorator;

import com.example.springcore2logtracker.trace.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import com.example.springcore2logtracker.trace.proxy.pureproxy.decorator.code.MessageDecorator;
import com.example.springcore2logtracker.trace.proxy.pureproxy.decorator.code.RealComponent;
import com.example.springcore2logtracker.trace.proxy.pureproxy.decorator.code.TimeDecorator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {

    @Test
    public void noDecorator() {
        RealComponent realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    public void decorator1() {
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);

        client.execute();
    }

    @Test
    public void decorator2() {
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);

        client.execute();
    }
}
