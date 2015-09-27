package kata.collections.set;

import java.util.*;

public class MyHashSet<T> implements Set<T> {

    private static final Object FILLER_OBJECT = new Object();
    private Map<T, Object> map = new HashMap<T, Object>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object object) {
        return map.containsKey(object);
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return map.keySet().toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return map.keySet().toArray(a);
    }

    @Override
    public boolean add(T element) {
        if(!map.containsKey(element)) {
            map.put(element, FILLER_OBJECT);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object object) {
        if(map.containsKey(object)) {
            map.remove(object);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return map.keySet().containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean isSetChanged = false;
        for(T element : collection) {
            if(!map.containsKey(element)) {
                map.put(element, FILLER_OBJECT);
                isSetChanged = true;
            }
        }
        return isSetChanged;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return map.keySet().retainAll(collection);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean isSetChanged = false;
        for(Object element : collection) {
            if(map.containsKey(element)) {
                map.remove(element);
                isSetChanged = true;
            }
        }
        return isSetChanged;
    }

    @Override
    public void clear() {
        map.clear();
    }
}