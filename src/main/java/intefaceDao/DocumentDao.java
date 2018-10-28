package intefaceDao;

import pojo.Document;

public interface DocumentDao {
    Document addDocument(Document document);

    boolean deleteDocument(Integer id);

    Document getDocumentByLogin(String login);

    Document getDocumentByType(Integer idType);

    Document addDocumentType(Integer docType);

    boolean updateDocument(Document document);
}
