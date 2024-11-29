package util;

import application.Employee;

public class LinkedList<T> implements LinkedListADT<T> {
    private int count;            /**Number of elements in the list*/
    private LinearNode<T> first;   /**First element of the linkedlist*/
    private LinearNode<T> last;   /**Last element of the linkedlist*/

    /**Create an empty list*/
    public LinkedList() {
        this.count = 0;
        this.first = null;
        this.last = null;
    }

    /**Add elements to the end of the list*/
    @Override
    public void add(T element) {
        LinearNode<T> newNode = new LinearNode<>(element);
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode); /**Link last node to new node*/
            last = newNode;        /**Update last node to new node*/
        }
        count++;
    }

    /**Add an element in a specific spot*/
    @Override
    public void add(T element, int position) {
        LinearNode<T> newNode = new LinearNode<>(element);
        
        if (position == 1) {
            /**Add to the start*/
            newNode.setNext(first);
            first = newNode;
            if (last == null) {
                last = first; /**If the list is empty first=last*/
            }
        } else {     
            
            LinearNode<T> current = first;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.getNext();
            }
            if (current != null) {
                newNode.setNext(current.getNext());
                current.setNext(newNode);
                if (newNode.getNext() == null) {
                    last = newNode; 
                }
            }
        }
        count++;
    }

    /**Remove an employee by employee number*/
    @Override
    public T removeByEmployeeNumber(int employeeNumber) {
        if (isEmpty()) {
            return null;
        }

        LinearNode<T> current = first;
        LinearNode<T> previous = null;

        /**Check the list to find an employee*/
        while (current != null) {
            Employee employee = (Employee) current.getElement(); 
            if (employee.getEmployeeNumber() == employeeNumber) {
                if (previous == null) {
                    first = current.getNext(); /**Remove the first element of the linkedlist*/
                } else {
                    previous.setNext(current.getNext()); /**Remove from the middle or end*/
                }
                if (current.getNext() == null) {
                    last = previous; /**If last element is removed, it updates it*/
                }
                count--;
                return current.getElement();
            }
            previous = current;
            current = current.getNext();
        }
        return null;
    }

    /**Display all elements in the linkedlist*/
    @Override
    public void displayAll() {
        LinearNode<T> current = first;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }

    /**Personalised function, move employee to new course*/
    @Override
    public void moveEmployeeToNewCourse(int employeeNumber, String newCourse) {
        LinearNode<T> current = first;
        while (current != null) {
            Employee employee = (Employee) current.getElement(); 
            if (employee.getEmployeeNumber() == employeeNumber) {
                employee.setTrainingCourse(newCourse);
                System.out.println("Employee " + employeeNumber + " moved to new course: " + newCourse);
                return;
            }
            current = current.getNext();
        }
        System.out.println("Employee not found.");
    }

    /**Return first element*/
    @Override
    public T getFirstElement() {
        return (first != null) ? first.getElement() : null;
    }

   /**Return last element*/
    @Override
    public T getLastElement() {
        return (last != null) ? last.getElement() : null;
    }

    /**Check if the list is empty*/
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**Return size of list*/
    @Override
    public int size() {
        return count;
    }

    /**Checks if the list contains a specified element*/
    @Override
    public boolean contains(T element) {
        LinearNode<T> current = first;
        while (current != null) {
            if (current.getElement().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    
    @Override
    public T getFirst() {
        return (first != null) ? first.getElement() : null;
    }


    @Override
    public T getLast() {
        return (last != null) ? last.getElement() : null;
    }

    
    @Override
    public T getNext(T element) {
        LinearNode<T> current = first;
        while (current != null) {
            if (current.getElement().equals(element)) {
                return (current.getNext() != null) ? current.getNext().getElement() : null;
            }
            current = current.getNext();
        }
        return null;
    }
}
