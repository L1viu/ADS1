package util;

public interface LinkedListADT<T> {

    /**Adds an element at the end of the list*/
    void add(T element);

    /**Adds an element to a specific position*/
    void add(T element, int position);

   /**Remove element by employee number*/
    T removeByEmployeeNumber(int employeeNumber);

    /**Display all elements in the list*/
    void displayAll();

    /**Personalised function-move employee to a new course*/
    void moveEmployeeToNewCourse(int employeeNumber, String newCourse);

    /**Return first element of the list*/
    T getFirstElement();

   /**Return last element of the list*/
    T getLastElement();

    /**Check if the list is empty*/
    boolean isEmpty();

    /**Return Size of the list*/
    int size();

    /**Check if list includes a specific element*/
    boolean contains(T element);

    /**Return first element of the list*/
    T getFirst();

    /**Return last element of the list*/
    T getLast();

    /**Return the next element of the list*/
    T getNext(T element);
}
