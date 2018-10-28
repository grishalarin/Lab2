package implementation.service;

import implementation.repository.DocumentDaoImpl;
import intefaceDao.DocumentDao;
import interfaceService.DocumentService;
import pojo.Document;


public class DocumentServiceImpl implements DocumentService {

    private DocumentDao documentDao = new DocumentDaoImpl();
    //  UserDaoImpl userDao = new UserDaoImpl();

   /* @Override
    public Integer getId(int id) {
        Document document;
        if (id != 0) {
            document = documentDao.getDocumentById(id);
            if (document == null) {
                return -1;
            }
            return document.getDocType();
        }
        return -1;
    }*/

    @Override
    public Integer getDocType(Integer docType) {
        Document document;
        if (docType != 0) {
            document = documentDao.addDocumentType(docType);
            if (document == null) {
                return -1;
            }
            return document.getDocType();
        }
        return -1;
    }

    @Override
    public Document addDocument(Integer docType, String data, String userLogin) {

        Document document = new Document(null, docType, data, userLogin);
        if (documentDao.addDocument(document) == null) {
            documentDao.addDocument(document);
            return document;
        }
        return null;
    }
}
