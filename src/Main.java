import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total memory available (in Bytes) ");
        int size = scanner.nextInt();
        System.out.print("Enter the block size (in Bytes) ");
        int blockSize = scanner.nextInt();
        System.out.print("Enter the number of processes ");
        int processNum = scanner.nextInt();

        Memory memory = new Memory(size, blockSize);

        for (int i = 1; i <= processNum; i++) {
            System.out.print("Enter memory required for process " + i + " (in Bytes) ");
            int processSize = scanner.nextInt();
            memory.allocate(new Process(i, processSize));
        }
        memory.printData();
    }
}