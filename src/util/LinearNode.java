package util;

public class LinearNode<T> {
    private T element;  /**Data held by the node*/
    private LinearNode<T> next;  /**Next node in the list*/

    /**Create empty node*/
    public LinearNode() {
        this.element = null;
        this.next = null;
    }

  /**Create node with given element*/
    public LinearNode(T element) {
        this.element = element;
        this.next = null;
    }

    /**Getters + Setters*/
    public T getElement() {
        return element; 
    }

    public void setElement(T element) {
        this.element = element;  
    }

    public LinearNode<T> getNext() {
        return next;  
    }

    public void setNext(LinearNode<T> next) {
        this.next = next;  
    }
}
