/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);

	}

	public static void testAddFirst() {
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		lld1.addFirst(1);

		lld1.addLast(2);
		System.out.print(lld1);

	}

	public static void testVisualize() {
		ArrayDeque<String> lld1 = new ArrayDeque<String>();
		lld1.addLast("a");
		System.out.println("\n");
		lld1.printDeque();
		lld1.addLast("b");
		System.out.println("\n");
		lld1.printDeque();
		lld1.addFirst("c");
		System.out.println("\n");
		lld1.printDeque();
		lld1.addLast("d");
		System.out.println("\n");
		lld1.printDeque();
		lld1.addLast("e");
		System.out.println("\n");
		lld1.printDeque();
		lld1.addFirst("f");
		System.out.println("\n");
		lld1.printDeque();
		lld1.addLast("g");
		System.out.println("\n");
		lld1.printDeque();
		lld1.addLast("h");
		System.out.println("\n");
		lld1.printDeque();
		lld1.addLast("Z");
		//lld1.removeFirst();
		System.out.println("\n");
		lld1.printDeque();
		lld1.addLast("E");
		System.out.println("\n");
		lld1.printDeque();
		lld1.addFirst("F");
		System.out.println("\n");
		lld1.printDeque();
		lld1.addLast("G");
		System.out.println("\n");
		lld1.printDeque();
		lld1.addLast("H");
		System.out.println("\n");
		lld1.printDeque();
		lld1.addFirst("T");
		//lld1.removeFirst();
		System.out.println("\n");
		lld1.printDeque();
	}

	public static void testVisualizeLList() {
		LinkedListDeque LList = new LinkedListDeque();
		LList.addFirst(0);
		System.out.println("\n");
		LList.printDeque();
		System.out.println("\n");
		LList.addFirst(1);
		LList.printDeque();
		System.out.println("\n");
		LList.addFirst(2);
		LList.printDeque();
		System.out.println("\n");
		LList.addFirst(3);
		LList.printDeque();
		System.out.println("\n");
		LList.isEmpty();
		LList.isEmpty();
		LList.addFirst(6);
		LList.printDeque();
		System.out.println("\n");
		LList.addFirst(7);
		LList.printDeque();
		System.out.println("\n");
		LList.removeFirst();
		LList.printDeque();
		System.out.println("\n");
		LList.removeFirst();
		LList.printDeque();
		System.out.println("\n");

		LList.addLast(9);
		LList.printDeque();
		System.out.println("\n");
		LList.addLast(10);
		LList.printDeque();
		System.out.println("\n");
		LList.removeLast();
		LList.printDeque();
		System.out.println("\n");
		LList.addLast(11);
		LList.printDeque();
		System.out.println("\n");
	}
	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();

		addRemoveTest();
		//testAddFirst();
		testVisualize();
		testVisualizeLList();
	}
}
