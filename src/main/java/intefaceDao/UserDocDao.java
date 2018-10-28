package intefaceDao;

import pojo.UserDoc;

public interface UserDocDao {
    boolean deleteUserDoc(Integer id);

    pojo.UserDoc getUserDoc(Integer id);

    boolean updateUserDoc(UserDoc userDoc);
}
