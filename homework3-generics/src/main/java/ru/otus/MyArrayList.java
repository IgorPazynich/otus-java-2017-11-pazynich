package ru.otus;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private Object[] myArray;
    private int size=5;
    private int nullElemCounter = size;
    public MyArrayList() {
        myArray = new Object[size];
    }

    public MyArrayList(Collection<? extends T> c) {
        size = c.size();
        nullElemCounter = 0;
        myArray = new Object[c.size()];
        myArray = (T[])c.toArray();
    }

    public MyArrayList(int size) {
        if (size < 0) throw new IllegalArgumentException("The size of MyArrayList can`t be less then 0");
        this.size = size;
        nullElemCounter = size;
        myArray = new Object[size];
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.size(); i++) {
            s += this.get(i) + " ";
        }
        return s;
    }

    private void elemAllocate(int addSize){
        int increase = 0;
        while (nullElemCounter < addSize)
        {
            nullElemCounter += size;
            size *= 2;
            increase ++;
        }
        if (increase > 0){
            myArray = Arrays.copyOf(myArray,size);
        }
    }

    private void checkBounds(int index) {
        if (index < 0 && index > size()) {
            throw new IndexOutOfBoundsException("The index is " + index + ", but the size of MyArrayList instance is " + size());
        }
    }

    @Override
    public boolean add(T t) {
        elemAllocate(1);
        myArray[size()] = t;
        nullElemCounter--;
        return true;
    }

    @Override
    public void add(int index, T element) {
        checkBounds(index);
        elemAllocate(1);
        System.arraycopy(myArray, index,myArray, index+1, size()-index);
        myArray[index] = element;
        nullElemCounter--;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(size(), c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c == null || c.size() == 0){
            return false;
        }
        elemAllocate(c.size());
        System.arraycopy(myArray, index, myArray, index + c.size(), size() - index);
        System.arraycopy(c.toArray(),0, myArray, index, c.size());
        nullElemCounter-=c.size();
        return true;
    }

    @Override
    public void sort(Comparator<? super T> c) {
       Arrays.sort((T[])myArray,0,size(),c);
    }

    @Override
    public T get(int index) {
        checkBounds(index);
        return (T) myArray[index];
    }

    @Override
    public T set(int index, T element) {
        checkBounds(index);
        T oldElement = (T)get(index);
        myArray[index] = element;
        return oldElement;
    }

    @Override
    public int size() {
        return size-nullElemCounter;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(myArray, size());
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyListItr(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        checkBounds(index);
        return new MyListItr(index);
    }

    private class MyItr implements Iterator<T> {
        int nextElem;
        int lastElem = -1;

        @Override
        public boolean hasNext() {
            return nextElem != size();
        }

        @Override
        public T next() {
            int i = nextElem;
            if (i >= size())
                throw new NoSuchElementException();
            Object[] elementData = Arrays.copyOf(MyArrayList.this.myArray, size());
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            nextElem = i + 1;
            return (T) elementData[lastElem = i];
        }

        public void remove() {
                MyArrayList.this.remove(lastElem);
                nextElem = lastElem;
                lastElem = -1;
        }

    }
    private class MyListItr extends MyItr implements ListIterator<T> {
        public MyListItr(int index) {
            super();
            nextElem = index;
        }

        @Override
        public boolean hasPrevious() {
            return nextElem != 0;
        }

        @Override
        public T previous() {
            int i = nextElem - 1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] elementData = Arrays.copyOf(MyArrayList.this.myArray, size());
            nextElem = i;
            return (T) elementData[lastElem = i];
        }

        @Override
        public int nextIndex() {
            return nextElem;
        }

        @Override
        public int previousIndex() {
            return nextElem - 1;
        }

        @Override
        public void set(T t) {
            if (lastElem < 0)
                throw new IllegalStateException();
            MyArrayList.this.set(lastElem, t);
        }

        @Override
        public void add(T t) {
            int i = nextElem;
            MyArrayList.this.add(i, t);
            nextElem = i + 1;
            lastElem = -1;
        }
    }

    @Override
    public int indexOf(Object o) {
        throw new RuntimeException();
    }

    @Override
    public boolean isEmpty() {
        throw new RuntimeException();
    }

    @Override
    public boolean contains(Object o) {
        throw new RuntimeException();
    }

    @Override
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new RuntimeException();
    }

    @Override
    public boolean remove(Object o) {
        throw new RuntimeException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new RuntimeException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new RuntimeException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new RuntimeException();
    }

    @Override
    public void clear() {
        throw new RuntimeException();
    }

    @Override
    public T remove(int index) {
        throw new RuntimeException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new RuntimeException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new RuntimeException();
    }
}
