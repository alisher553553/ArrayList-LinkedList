package winter352_Assignment2;
//NAME : ALI SHER 
//STUDENT ID : 40255236

//NAME : Olgerta Gjyriqi
//student id : 40251045

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] data; 
    private int size; 

    public MyArrayList() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    
    public boolean add(E e) {
        ensureCapacity();
        data[size++] = e;
        return true;
    }

   
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        ensureCapacity();
        // Shift elements to the right
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    
    public void clear() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        @SuppressWarnings("unchecked")
        E removed = (E) data[index];
        // Shift elements to the left
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null; // avoid loitering
        shrinkIfNeeded();
        return removed;
    }

    
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    
    public int size() {
        return size;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    
    private void ensureCapacity() {
        if (size == data.length) {
            // double capacity
            int newCapacity = data.length * 2;
            Object[] newData = new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    
    private void shrinkIfNeeded() {
        if (size < data.length / 4 && data.length > INITIAL_CAPACITY) {
            int newCapacity = data.length / 2; 
            if (newCapacity < INITIAL_CAPACITY) {
                newCapacity = INITIAL_CAPACITY;
            }
            Object[] newData = new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    public E get(int index) {
        throw new UnsupportedOperationException("get(int) not required.");
    }

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
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
	public  List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
		
	}

	
}
