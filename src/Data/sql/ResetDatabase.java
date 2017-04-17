package sql;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Snaevar
 * Class for resetting the database to its default contents and configuration
 * as outlined in the .sql file included with this project. Copies the 'init'
 * version over the version being operated on during runtime.
 */

public class ResetDatabase {
        
    private static void resetDatabase() throws IOException {
    
    File init_file = new File("src\\sql\\init\\hotel_init.db");
    File file_to_replace = new File("src\\sql\\hotel.db");

    Files.copy(init_file.toPath(), file_to_replace.toPath(), StandardCopyOption.REPLACE_EXISTING);
    
    }

    public static void main(String[] args) throws IOException {
        resetDatabase();
    }

}
