public class Block {
    final private int id;
    final private int size;
    private int fragmentation;
    private boolean isAllocated;

    final private int processSize;

    public Block(int id, int size, int processSize) {
        this.id = id;
        this.size = size;
        fragmentation = size;
        isAllocated = false;
        this.processSize = processSize;
    }

    public int getSize() {
        return size;
    }

    public boolean isAllocated() {
        return isAllocated;
    }

    public void setAllocated(boolean allocated, int processSize) {
        if (allocated)
            fragmentation = size - processSize;
        else
            fragmentation = -1;

        isAllocated = allocated;
    }

    public int getFragmentation() {
        return fragmentation;
    }

    public int getId() {
        return id;
    }

    public int getProcessSize() {
        return processSize;
    }
}
