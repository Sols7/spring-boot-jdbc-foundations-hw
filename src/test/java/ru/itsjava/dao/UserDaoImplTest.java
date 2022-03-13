package ru.itsjava.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@Import(UserDaoImpl.class)
public class UserDaoImplTest {
    private static final String DEFAULT_NAME = "newU";
    private static final int DEFAULT_AGE = 50;
    private static final long FIRST_ID = 1L;
    private static final long NEW_ID = 3L;

    @Autowired
    private UserDao userDao;

    @Test
    public void shouldHaveCorrectCount() {
        int actualUserCount = userDao.count();

        assertEquals(2, actualUserCount);
    }

    @Test
    public void shouldHaveCorrectInsert() {
        User expectedUser = new User(NEW_ID, DEFAULT_NAME, DEFAULT_AGE);
        userDao.insert(expectedUser);
        User actualUser = userDao.findById(NEW_ID);

        assertEquals(actualUser, expectedUser);
    }

    @Test
    public void shouldHaveCorrectUpdate() {
        User expectedUser = new User(FIRST_ID, DEFAULT_NAME, DEFAULT_AGE);
        userDao.update(expectedUser);
        User actualUser = userDao.findById(FIRST_ID);

        assertEquals(actualUser, expectedUser);
    }

    @Test
    public void shouldHaveCorrectDelete(){
        User deletedUser = userDao.findById(FIRST_ID);
        userDao.delete(deletedUser);

        assertEquals(userDao.count(), 1);
    }
}
