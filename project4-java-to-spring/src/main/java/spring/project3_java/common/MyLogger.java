package spring.project3_java.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {
    private String uuid;
    private String requestURL;

    public MyLogger() {
        this.uuid = UUID.randomUUID().toString();
    }

    public void log(String message) {

    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[MyLogger.init]" + uuid + " request scope bean create: "+ this);
    }

    @PreDestroy
    public void close(){
        System.out.println("[MyLogger.close]" + uuid + " request scope bean close: "+ this);
    }

    public void setRequestURL(String requestURL) {
    }
}
