package lesson9.Collection;

public class LinkedString implements Linked {

    Entry last;
    Entry first;
    int size;

    @Override
    public boolean add(String str) {
        //add element to end of list
        //create new Entry with link of last element is list
        Entry temp = last;
        //create new Entry. Prev link is Entry temp, and next link is null
        Entry newEntry = new Entry(temp, str, null);
        //header last took link of new Entry in which link to next element is null
        last = newEntry;
        //if temp link is null than it`s first element is list, header first copy link newEntry
        if (temp == null) {
            first = newEntry;
        } else {
            //it`s not first element so link temp.next copy link newEntry
            temp.next = newEntry;
        }
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {
        if (index >= size || index < 0) {
            return "Null pointer exception";
        }
        //create copy header first and loop through list to index position and save temp link temp.next
        Entry temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        //return string of current link temp
        return temp.value;
    }

    @Override
    public boolean delete (int index) {
        //check if index not more ol less then size
        if (index >= size || index < 0) {
            System.out.println("Null pointer exception");
        }
        //create new Entry who will save link to founded element in list
        Entry temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        //saving links to prev\next elements in list
        Entry next = temp.next;
        Entry prev = temp.prev;
        //one <-> two <-> three
        //if link to prev element is null than it`s first element in list
        if (prev == null) {
            //header first save link to next element
            first = next;
        } else {
            //copy previous element`s link.next to link next current element
            prev.next = next;
            //delete link current element to prev element
            temp.prev = null;
        }

        //if link to next element is null than it`s last element in list
        if (next == null) {
            //header last save link to previous element is list
            last = prev;
        } else {
            //copy next element link.prev to link prev current element
            next.prev = prev;
            //delete link current element to next element
            temp.next = null;
        }
        size--;
        return true;
    }

    @Override
    public boolean delete(String str) {

        return false;
    }

    public void printList() {
        Entry temp = first;
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
        System.out.print("]\n");
    }

    public int getSize() {
        return size;
    }

    private static class Entry {
        String value;
        Entry next;
        Entry prev;

        public Entry(Entry prev, String value, Entry next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }
}