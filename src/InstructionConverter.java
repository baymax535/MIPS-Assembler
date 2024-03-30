import java.util.Map;

public class InstructionConverter {
  /**
   * Converts a parsed MIPS assembly instruction into machine code.
   *
   * @param instruction A ParsedInstruction object containing the operation and
   * operands of the MIPS instruction.
   * @return A string representing the machine code in hexadecimal format.
   */
  public static String convertToMachineCode(String operation, String[] arguments, Map<String, Integer> labelAddresses,int currentAddress) {

    String machineCode = "";

    switch (operation) {
      case "add":
        machineCode = formatRType("000000", arguments[1], arguments[2], arguments[0], "00000", "100000");
        break;
      case "addiu":
    	    machineCode = formatIType("001001", arguments[1], arguments[0], Integer.parseInt(arguments[2]));
          break;
      case "and":
        machineCode = formatRType("000000", arguments[1], arguments[2], arguments[0], "00000", "100100");
        break;
      case "andi":
    	    int immediateValue;
    	    if (arguments[2].startsWith("0x")) {
    	        immediateValue = Integer.parseInt(arguments[2].substring(2), 16);
    	    } else {
    	        immediateValue = Integer.parseInt(arguments[2]);
    	    }
    	    machineCode = formatIType("001100", arguments[1], arguments[0], immediateValue);
    	    break;
      case "beq":
    	    String rs = arguments[0];
    	    String rt = arguments[1];
    	    String label = arguments[2];
    	    int targetAddress = labelAddresses.getOrDefault(label, 0);
    	    int offset = (targetAddress - currentAddress-4) / 4;
    	    machineCode = formatIType("000100", rs, rt, offset);
    	    break;

    	case "bne":
    	    rs = arguments[0];
    	    rt = arguments[1];
    	    label = arguments[2];
    	    targetAddress = labelAddresses.getOrDefault(label, 0);
    	    offset = (targetAddress - currentAddress-4) / 4;
    	    machineCode = formatIType("000101", rs, rt, offset);
    	    break;
    	case "j":
    		label = arguments[0];
    	    targetAddress = labelAddresses.getOrDefault(label, 0);
    	    machineCode = formatJType("000010", targetAddress >>> 2);
    	    break;
      case "lui":
    	    machineCode = formatIType("001111", "$zero", arguments[0], Integer.parseInt(arguments[1]));
    	    break;
      case "lw":
    	  	String[] lwParts = arguments[1].split("\\(");
    	    String lwOffset = lwParts[0].trim();
    	    String lwBaseRegister = lwParts[1].substring(0, lwParts[1].length() - 1).trim();
    	    machineCode = formatIType("100011", lwBaseRegister, arguments[0], Integer.parseInt(lwOffset));
    	    break;
      case "or":
        machineCode = formatRType("000000", arguments[1], arguments[2], arguments[0], "00000", "100101");
        break;
      case "ori":
    	    machineCode = formatIType("001101", arguments[1], arguments[0], Integer.parseInt(arguments[2]));
        break;
      case "slt":
        machineCode = formatRType("000000", arguments[1], arguments[2], arguments[0], "00000", "101010");
        break;
      case "sub":
        machineCode = formatRType("000000", arguments[1], arguments[2], arguments[0], "00000", "100010");
        break;
      case "sw":
    	  	String[] swParts = arguments[1].split("\\(");
    	    String swOffset = swParts[0].trim();
    	    String swBaseRegister = swParts[1].substring(0, swParts[1].length() - 1).trim();
    	    machineCode = formatIType("101011", swBaseRegister, arguments[0], Integer.parseInt(swOffset));
    	    break;
      case "syscall":
    	machineCode = "000000" + "00000" + "00000" + "00000" + "00000" + "001100";
    	break;
      case "move":
    	    machineCode = formatRType("000000", arguments[1], "$zero", arguments[0], "00000", "100001");
    	    break;
      case "li":
    	  	String immediate = arguments[1];
    	    String register = arguments[0];
    	    if (immediate.matches("-?\\d+")) { // Numeric immediate
    	        machineCode = formatIType("001001", "$zero", register, Integer.parseInt(immediate));
    	    } else { // Label or symbolic immediate value
    	        targetAddress = labelAddresses.getOrDefault(immediate, 0);
    	        int upperImmediate = targetAddress >>> 16;
    	        int lowerImmediate = targetAddress & 0xFFFF;
    	        if (upperImmediate != 0) {
    	            machineCode = formatIType("001111", "$zero", register, upperImmediate) + "\n";
    	        }
    	        machineCode += formatIType("001101", register, register, lowerImmediate);
    	    }
    	    break;
      case "la":
    	  register = arguments[0];
    	    label = arguments[1];
    	    targetAddress = labelAddresses.getOrDefault(label, 0);
    	    int upperImmediate = targetAddress >>> 16;
    	    int lowerImmediate = targetAddress & 0xFFFF;
    	    machineCode = formatIType("001111", "$zero", register, upperImmediate) + "\n" +
    	                  formatIType("001101", register, register, lowerImmediate);
    	    break;
      case "blt":
    	    rs = arguments[0];
    	    rt = arguments[1];
    	    String offsets = arguments[2];
    	    machineCode = formatRType("000000", rs, rt, "$at", "00000", "101010") + "\n" +
    	            formatIType("000101", "$at", "$zero", Integer.parseInt(offsets));
    	    break;
      default:
          throw new IllegalArgumentException("Unsupported operation: " + operation);
      }

    return Util.binaryToHex(machineCode);
    }

   /**
   * Converts an R-type MIPS instruction to its machine code representation.
   *
   * @param instruction A ParsedInstruction object specific to an R-type
   * instruction.
   * @return A string representing the binary machine code for the R-type
   * instruction.
   */
  private static String formatRType(String opcode, String rs, String rt, String rd, String shamt, String funct) {
	    return opcode + Util.registerToBinary(rs) + Util.registerToBinary(rt) + Util.registerToBinary(rd) + shamt + funct;
	}

   /**
   * Converts an I-type MIPS instruction to its machine code representation.
   *
   * @param instruction A ParsedInstruction object specific to an I-type
   * instruction.
   * @return A string representing the binary machine code for the I-type
   * instruction.
   */
  private static String formatIType(String opcode, String rs, String rt, int immediate) {
	    return opcode + Util.registerToBinary(rs) + Util.registerToBinary(rt) + Util.immediateToBinary(immediate, 16);
	}

   /**
   * Converts a J-type MIPS instruction to its machine code representation.
   *
   * @param instruction A ParsedInstruction object specific to a J-type
   * instruction.
   * @return A string representing the binary machine code for the J-type
   * instruction.
   */
  private static String formatJType(String opcode, int address) {
	    String binaryAddress = Util.immediateToBinary(address, 26);
	    return opcode + binaryAddress;
	}

}
