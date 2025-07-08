import java.time.LocalDate;

public class Message {
    private String sender;
    private String content;
    private LocalDate timestamp;

    public Message(String sender, String content, LocalDate timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String toString(){
        return "[ " + timestamp + " ] " + sender + ": " + content;
    }
}
