package spring.project3_java.lifecycle;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect(){
        System.out.println("NetworkClient.connect" + url);
    }

    public void call(String message){
        System.out.println("message = " + message);
    }

    public void disconnect(){
        System.out.println("NetworkClient.disconnect");
    }
}
