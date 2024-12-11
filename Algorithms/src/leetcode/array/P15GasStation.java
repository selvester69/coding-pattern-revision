package leetcode.array;

public class P15GasStation {
    public static void main(String[] args) {
        //System.out.println(P15GasStation.canCompleteCircuit(new int[] { 1, 2, 3, 4, 5
        //}, new int[] { 3, 4, 5, 1, 2 }));
        //System.out.println(P15GasStation.canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 }));
        System.out.println(P15GasStation.canCompleteCircuit(new int[] { 5, 1, 2, 3, 4 }, new int[] { 4, 4, 1, 5, 1 }));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int fuel = 0;
            boolean isValid = true;
            for (int j = 0; j < gas.length; j++) {
                int start = (j + i) % gas.length;
                fuel = fuel + gas[start] - cost[start];
                if (fuel < 0) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return i;
            }
        }
        return -1;
    }

}
