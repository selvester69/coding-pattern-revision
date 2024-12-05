
//implementation of Heap using complete binary tree represented in array form.
class Heap{
    private List<Integer> heap;
    public Heap(){
        this.heap = new ArrayList<>();
    }
    public getHeap(){
        //since we do not allow to modify heap we return a copy
        return new ArrayList<Integer>(this.heap);
    }
    public int leftChild(int index){
        return (index*2)+1;
    }
    public int rightChild(int index){
        return (index*2)+2;
    }

    public int parent(int index){
        return (index-1)/2;
    }
    public void swap(int index1,int index2){
        Integer temp = this.heap.get(index1);
        this.heap.set(index1,this.heap.get(index2));
        this.heap.set(index2,temp);
    }
    public void insert(int value){
       // insert the value at the end of tree 
       // after insert check if  the value is greater than any of the parent swap with the parent
       this.heap.add(value);
       int currentIndex = this.heap.size()-1;
       while(currentIndex>0 && this.heap.get(currentIndex)>this.heap.get(this.parent(currentIndex))){
            swap(currentIndex,this.parent(currentIndex));
            currentIndex = this.parent(currentIndex);
       }
    }

    public void sinkDown(int index){
        int maxIndex = index;//assume maxIndex is indexItself
        while(true){
            int leftIndex = leftChild(index); //calc left child
            int rightIndex = rightChile(index); //calc right child
            if(leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)){ //if left is greater assign max to left
                maxIndex = left(index);
            }
            if(rightIndex < heap.size() && heap.get(rightIndex)>heap.get(maxIndex)){ //if right is greater assign max to right
                maxIndex = right(index);
            }
            if(maxIndex!=index){//ifmax is different from assumed max sawp else break the loop
                swap(index,maxIndex);
                index = maxIndex;
            }else {
                return;
            }
        }



    }
    //removes the method at the start of the heap.
    //for max heap the top element is the max element
    public Integer remove(){
        //handle edge cases 
        // to remove element we have to maintain the complete tree and max heap property
        //swap first and last element
        //call sinkdown on heap to adjust the element 
        if(heap.size()==0) return null;
        if(heap.size()==1) return heap.remove(0);
        int maxElement = this.heap.get(0);
        this.heap.set(0, this.heap.remove(this.heap.size()-1));
        sinkDown(0);
        remove maxElement;
    }


    

    

}