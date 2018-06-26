
package ssig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileReader {
    private List<String> words;
    private Scanner s;
    
    public FileReader() {
//        File file = new File("words.txt");

       InputStream stream = FileReader.class.getResourceAsStream("words.txt");
        try {
            this.s = new Scanner(stream);
            readWordsToArray();
            this.s.close();
        } catch (Exception ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void readWordsToArray() {
        this.words = new ArrayList<>();
        
        while(this.s.hasNextLine()) {
            this.words.add(s.nextLine());
        }  
    }
    
    public String getRandomWord() {
        Random r = new Random();
        int ran = r.nextInt(this.words.size());
        
        return this.words.get(ran);
    }
}
