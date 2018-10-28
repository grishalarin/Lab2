package pojo;

public class UserDoc {

    private Integer idUser;
    private Integer idDoc;

    public UserDoc(Integer idUser, Integer idDoc) {
        this.idUser = idUser;
        this.idDoc = idDoc;
    }

    @Override
    public String toString() {
        return "UserDocDao{" +
                "idUser=" + idUser +
                ", idDoc=" + idDoc +
                '}';
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }
}
