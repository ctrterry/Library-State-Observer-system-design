package hwdp;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class Test2StatePattern {
    @BeforeEach
    public void resetLog() {
        LibraryLogger.getInstance().clearWriteLog();
    }

	@Test
	public void testBookStartsAtOnShelfState() {
		// An example unit test for problem 1
        // Uncomment when ready to work on Problem 2
		LibraryBook book = new LibraryBook("Making a Statement");
		assertTrue(book.getState() == OnShelf.getInstance());
	
	}

	@Test
	public void StateTestE2E() {
		/** 
		 * A end-to-end test designed to show the expected output.
		 * It is not guaranteed to be the highest quality/comprehensive.
		 */

		// /* Uncomment when ready to work on P2
		LibraryBook book = new LibraryBook("Design Patterns");
		book.returnIt();
		book.shelf();
		book.issue();
		book.extend();
		book.extend();
		book.extend();
		book.returnIt();
		book.extend();
		book.issue();
		book.shelf();
		book.extend();

		
		// Tesing My Output -> Found issues -> Pass 

        // String[] actualLogs = LibraryLogger.getInstance().getWrittenLines();
        // System.out.println("\n This is my Current Output");
        //     for (String log : actualLogs) {
        //     	System.out.println(log);
        //     }
		assertArrayEquals(
			new String [] {
				"BadOperationException - Can't use returnIt in OnShelf state",
				"BadOperationException - Can't use shelf in OnShelf state",
				"Leaving State OnShelf for State Borrowed",
				"Leaving State Borrowed for State Borrowed",
				"Leaving State Borrowed for State Borrowed",
				"Leaving State Borrowed for State Borrowed",
				"Leaving State Borrowed for State GotBack",
				"BadOperationException - Can't use extend in GotBack state",
				"BadOperationException - Can't use issue in GotBack state",
				"Leaving State GotBack for State OnShelf",
				"BadOperationException - Can't use extend in OnShelf state"	
			}, 
			LibraryLogger.getInstance().getWrittenLines()
		);
		// */
	}
}
