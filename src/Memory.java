import java.util.ArrayList;

public class Memory {
    final private int size;
    final private int blockSize;
    final private int blockNumber;
    private int internalFragmentation = 0;
    final private int externalFragmentation;
    final private ArrayList<Block> blocks;

    public Memory(int size, int blockSize) {
        this.size = size;
        this.blockSize = blockSize;
        this.blockNumber = size / blockSize;
        this.externalFragmentation = size - blockSize * blockNumber;
        this.blocks = new ArrayList<>();
    }

    public void allocate(Process process) {
        int allocatedCounter = 0;
        for (Block value : blocks) {
            if (value.isAllocated()) {
                allocatedCounter++;
            }
        }
        if (allocatedCounter == blockNumber) {
            System.out.println("Number of Blocks available in Memory is " + blockNumber);
            printData();
            System.exit(0);
        }
        Block block = new Block(process.id(), blockSize, process.size());

        block.setAllocated(blockSize >= process.size(), process.size());

        blocks.add(block);
    }

    public int getSize() {
        return size;
    }

    public int getExternalFragmentation() {
        return externalFragmentation;
    }

    public int getInternalFragmentation() {
        return internalFragmentation;
    }

    public void printData() {
        System.out.println("PROCESS      MEMORY REQUIRED      ALLOCATED      INTERNAL FRAGMENTATION");
        for (Block block : blocks) {
            if (block.getFragmentation() != -1)
                internalFragmentation += block.getFragmentation();
            String fragmentation = block.getFragmentation() == -1 ? "----" : String.valueOf(block.getFragmentation());
            String allocate = block.isAllocated() ? "YES" : "NO";
            System.out.println("   " + block.getId() + "               " + block.getProcessSize() + "              " + allocate + "                 " + fragmentation);
        }
        System.out.println("Internal Fragmentation is " + internalFragmentation);
        System.out.println("Total External Fragmentation is " + externalFragmentation);
    }
}
