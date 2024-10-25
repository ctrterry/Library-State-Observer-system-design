package hwdp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Student_Test {

    @Test
    void myStudentTest(){
       //assertEquals(2,2);
        LibraryBook book = new LibraryBook("Clean Code");
        book.issue();
        // Check if the state transitioned to Borrowed
        assertEquals(Borrowed.getInstance(), book.getState(), "The book should be in Borrowed state after issuing.");
    }  
}
