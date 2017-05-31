package hangman.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("cst438-a8PU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}