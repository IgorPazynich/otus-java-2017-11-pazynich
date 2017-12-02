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

    private void elemAllocate(int addSize){
        int increace = 0;
        while (nullElemCounter < addSize)
        {
            size *= 2;
            nullElemCounter += size;
            increace ++;
        }
        if (increace > 0){
            myArray = Arrays.copyOf(myArray,size);
        }

    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c==null){
        return false;
        }
        elemAllocate(c.size());
        //myArray =
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public void sort(Comparator<? super T> c) {
        Arrays.sort((T[])myArray,c);
    }

    @Override
    public T get(int index) {
        checkBounds(index);
        return (T) myArray[index];
    }

    private void checkBounds(int index) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException("The index is " + index + " , but the size of MyArrayList instance is " + size);
        }
    }

    @Override
    public T set(int index, T element) {
        checkBounds(index);
        T oldElement = (T)get(index);
        myArray[index] = element;
        return oldElement;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
