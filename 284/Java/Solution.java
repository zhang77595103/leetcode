// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    boolean hasPeek = false;
    Iterator<Integer> iterator;
    int peekElement;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!hasPeek){
            peekElement = iterator.next();
            hasPeek = true;
            return peekElement;
        }
        else{
            return peekElement;
        }
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(!hasPeek){
            return iterator.next();
        }
        else{
            hasPeek = false;
            return peekElement;
        }
    }

    @Override
    public boolean hasNext() {
        if(hasPeek){
            return true;
        }
        else{
            return iterator.hasNext();
        }
    }
}
