package Creational.Prototype;

public class Document implements Cloneable {
    private String name;
    private String content;

    public Document(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public void setContent(String content) { this.content = content; }
    public String getName() { return name; }
    public String getContent() { return content; }

    public Document clone() {
        return new Document(this.name, this.content);
    }

    public void display() {
        System.out.println("Document: " + name + " | " + content);
    }
}
