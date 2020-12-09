package lesson9.Collection;

public class LinkedString implements Linked {

    Entry last;
    Entry first;
    int size;

    //extends list with new object with string value
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

    //finds element in list by
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

    /*
    this method removes object from list,
    it goes through all list till position in list with number index,
    deletes all links of object and re-saves previous\next links elements
     */
    @Override
    public boolean delete(int index) {
        //check if index not more or less then size
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
            //header last save link to previous element in list
            last = prev;
        } else {
            //copy next element link.prev to link prev current element
            next.prev = prev;
            //delete link current element to next element
            temp.next = null;
        }
        temp.value = null;
        size--;
        return true;
    }

    /*goes through all list and match str with each values in list
    if no matches than Entry temp saves link of next element from last element in list witch is null
    if found matches he saves current int i from loop and send it to method delete(int index)
     */
    @Override
    public boolean delete(String str) {
        //check if str == null
        //if (str == null) {
        if (str == null) {
            Entry temp = first;
            //if value is null
            for (int i = 0; i < size; i++) {
                if (temp.value == null) {
                    delete(i);
                    return true;
                }
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("No matches");
            }
        } else {
            Entry temp = first;
            for (int i = 0; i < size; i++) {
                // if value equal str
                if (temp.value == str) {
                    //delete element from list with i = index
                    delete(i);
                    return true;
                }
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("No matches");
            }
        }
        return false;
    }

    //goes through array and send each element to method add
    @Override
    public boolean addAll(String[] strArr) {
        //check array for empty
        if (strArr.length == 0) {
            return false;
        }
        for (String str : strArr) {
            add(str);
        }
        return true;
    }

    //converts all values of list to String array and sends  it to another method
    @Override
    public boolean addAll(LinkedString strColl) {
        String[] strArr = listToArray(strColl);
        addAll(strArr);
        return false;
    }

    private String[] listToArray(LinkedString strColl) {
        Entry temp = strColl.first;
        String[] strArr = new String[strColl.size];
        for (int i = 0; i < strColl.size; i++) {
            strArr[i] = temp.value;
            temp = temp.next;
        }
        return strArr;
    }

    //delete all links from all elements
    @Override
    public boolean clear() {
        for (Entry temp = first; temp != null; temp = temp.next) {
            Entry next = temp.next;
            temp.value = null;
            temp.next = null;
            temp.prev = null;
        }
        first = null;
        last = null;
        size = 0;
        return true;
    }

    //goes through all list and match string with each elements value
    @Override
    public boolean contains(String str) {
        Entry temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.value == str) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    //goes through all list and delete all 'Space' of each elements value
    @Override
    public boolean trim() {
        Entry temp = first;
        for (int i = 0; i < size; i++) {
            temp.value = temp.value.trim();
            temp = temp.next;
        }
        return true;
    }

    /*compares each element of two lists, if at least one element not matches with other instantly returns false
    if each element matchues with other in lists, then returns true
     */
    @Override
    public boolean compare(LinkedString coll) {
        //check equals sizes of two lists
        if (size < coll.size || size > coll.size) {
            return false;
        } else {
            Entry firstList = first;
            Entry secondList = coll.first;
            for (int i = 0; i < size; i++) {
                if (firstList.value != secondList.value) {
                    return false;
                }
                firstList = firstList.next;
                secondList = secondList.next;
            }
        }
        return true;
    }

    //prints all elements on list
    public void printList() {
        Entry temp = first;
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if (temp == last) {
                System.out.print(temp.value);
            } else {
                System.out.print(temp.value + ", ");
                temp = temp.next;
            }

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