package interfaceService;

import pojo.Document;

public interface DocumentService {
    // Integer getId(int id);
    Integer getDocType(Integer docType);

    Document addDocument(Integer docType, String data, String userLogin);

}
