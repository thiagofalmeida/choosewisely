package com.tfalmd.theroadsofar.finale.choosewisely.model;

/**
 * Created by tfalmd on 26/06/15.
 */
public class Message {
    private int id;
    private String message;
    private String author;
    private String image;

    public Message(int id, String message, String author, String image) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.image = image;
    }

    public Message() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
