public class File {
    private String name;
    private String content;
    private Integer qtt;

    public File(String name) {
        this.name = name;
        this.content = "";
        this.qtt = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getQtt() {
        return qtt;
    }

    public void setQtt(Integer qtt) {
        this.qtt = qtt;
    }

    public void incrementalQtt() {
        this.qtt++;
    }
}
