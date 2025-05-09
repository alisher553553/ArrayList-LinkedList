package winter352_Assignment2;
//NAME : ALI SHER 
//STUDENT ID : 40255236

//NAME : Olgerta Gjyriqi
//student id : 40251045

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E> {
    private class Node {
        E data;
        Node prev, next;
        Node(E d) { data = d; }
    }

    private Node head, tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public boolean add(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == size) {
            // Insert at end
            add(element);
            return;
        }
        if (index == 0) {
            // Insert at head
            Node newNode = new Node(element);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
            return;
        }
        // Otherwise, find the node at `index`
        Node current = getNode(index);
        Node newNode = new Node(element);
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node current = getNode(index);
        E removedData = current.data;

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else {
            current.prev.next = current.next;
        }
        if (current == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
        } else {
            current.next.prev = current.prev;
        }
        size--;
        return removedData;
    }

    public boolean remove(Object o) {
        Node c = head;
        while (c != null) {
            if (c.data.equals(o)) {
                // Remove node c
                if (c == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else {
                    c.prev.next = c.next;
                }
                if (c == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    c.next.prev = c.prev;
                }
                size--;
                return true;
            }
            c = c.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(", ");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private Node getNode(int index) {
        // Optionally optimize by starting from tail if index > size/2
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

	@Override
	
		// TODO Auto-generated method stub
		public boolean isEmpty() {
	        return size == 0;
	    
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}
}
