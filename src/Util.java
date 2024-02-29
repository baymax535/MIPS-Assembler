import java.util.HashMap;
import java.util.Map;

/**
 * Utility calss for shared functionalities such as formating output, converting
 * numbers between bases
 */
public class Util {
    /**
     * Formats the machine code output, such as ensuring uppercase.
     * 
     * @param machineCode The machine code to format.
     * @return The formatted machine code string.
     */
    public static String formatOutput(String machineCode) {
        return machineCode.toLowerCase();
    }

    public static String registerToBinary(String register) {
        Map<String, Integer> registerMap = new HashMap<>();

        registerMap.put("$at", 1);
        registerMap.put("$v0", 2);
        registerMap.put("$v1", 3);
        registerMap.put("$v2", 4);
        registerMap.put("$v3", 5);
        registerMap.put("$v4", 6);
        registerMap.put("$v5", 7);

        registerMap.put("$k0", 26);
        registerMap.put("$k1", 27);

        registerMap.put("$sp", 29);

        for (int i = 0; i <= 8; i++) {
            if (i < 8) {
                registerMap.put("$t" + i, 8 + i);
            } else {
                registerMap.put("$t" + i, 24);
            }
        }

        for (int i = 0; i <= 7; i++) {
            registerMap.put("$s" + i, 16 + i);
        }

        for (int i = 0; i <= 3; i++) {
            registerMap.put("$a" + i, 4 + i);
        }

        registerMap.put("$zero", 0);

        if (!registerMap.containsKey(register)) {
            throw new IllegalArgumentException("Unsupported register: " + register);
        }

        int number = registerMap.get(register);
        return String.format("%5s", Integer.toBinaryString(number)).replace(' ', '0');
    }

    public static String immediateToBinary(String immediate, int bitLength) {
        int value;
        if (immediate.startsWith("0x")) {
            value = Integer.parseInt(immediate.substring(2), 16);
        } else {
            value = Integer.parseInt(immediate);
        }
        String binaryString = Integer.toBinaryString(0xFFFF & value);
        if (binaryString.length() > bitLength) {
            binaryString = binaryString.substring(binaryString.length() - bitLength);
        } else {
            binaryString = String.format("%" + bitLength + "s", binaryString).replace(' ', '0');
        }
        return binaryString;
    }

    public static String addressToBinary(String address, int bitLength) {
        int value = Integer.parseInt(address);
        String binaryString = Integer.toBinaryString(value);
        if (binaryString.length() > bitLength) {
            binaryString = binaryString.substring(binaryString.length() - bitLength);
        } else {
            binaryString = String.format("%" + bitLength + "s", binaryString).replace(' ', '0');
        }
        return binaryString;
    }

    public static String binaryToHex(String binary) {
        long decimal = Long.parseLong(binary, 2);
        return String.format("%08x", decimal);
    }
}
