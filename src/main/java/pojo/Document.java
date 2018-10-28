package pojo;

public class Document {
    private Integer id;
    private Integer docType;
    private String data;
    private String userLogin;

    public Document(Integer id, Integer docType, String data, String userLogin) {
        this.id = id;
        this.docType = docType;
        this.data = data;
        this.userLogin = userLogin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", docType=" + docType +
                ", data='" + data + '\'' +
                ", userLogin='" + userLogin + '\'' +
                '}';
    }
}


