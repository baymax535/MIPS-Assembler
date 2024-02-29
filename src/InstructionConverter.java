
public class InstructionConverter {
  // private String mnemonic;
  // private String targetRegister;
  // private String sourceRegister2;
  // private String sourceRegister1;

  // /**
  // * Constructs an instance of the InstructionConverter.
  // * Initializes any necessary state or configurations required for conversion.
  // */
  // public InstructionConverter(InstructionParser.ParsedInstruction instruction)
  // {
  // // TODO
  // this.mnemonic = instruction.getMnemonic();
  // this.targetRegister = instruction.getTarget();
  // this.sourceRegister1 = instruction.getSourceRegister1();
  // this.sourceRegister2 = instruction.getSourceRegister2();

  // }

  // /**
  // * Converts a parsed MIPS assembly instruction into machine code.
  // *
  // * @param instruction A ParsedInstruction object containing the operation and
  // * operands of the MIPS instruction.
  // * @return A string representing the machine code in hexadecimal format.
  // */
  public static String convertToMachineCode(String operation, String[] arguments) {
    String machineCode = "";

    switch (operation) {
      case "add":
        machineCode = formatRType("000000", arguments[1], arguments[2], arguments[0], "00000", "100000");
        break;
      case "addiu":
        machineCode = formatIType("001001", arguments[1], arguments[0], arguments[2]);
        break;
      case "and":
        machineCode = formatRType("000000", arguments[1], arguments[2], arguments[0], "00000", "100100");
        break;
      case "andi":
        machineCode = formatIType("001100", arguments[1], arguments[0], arguments[2]);
        break;
      case "beq":
        machineCode = formatIType("000100", arguments[0], arguments[1], arguments[2]);
        break;
      case "bne":
        machineCode = formatIType("000101", arguments[0], arguments[1], arguments[2]);
        break;
      case "j":
        machineCode = formatJType("000010", arguments[0]);
        break;
      case "lui":
        machineCode = formatIType("001111", "00000", arguments[0], arguments[1]);
        break;
      case "lw":
        // machineCode = formatIType("100011", arguments[2], arguments[0],
        // arguments[1]);
        // break;
        String[] lwParts = arguments[1].split("\\("); // Split at the opening parenthesis
        String lwOffset = lwParts[0]; // The offset part
        String lwBaseRegister = lwParts[1].substring(0, lwParts[1].length() - 1); // Remove the closing parenthesis
        machineCode = formatIType("100011", lwBaseRegister, arguments[0], lwOffset);
        break;
      case "or":
        machineCode = formatRType("000000", arguments[1], arguments[2], arguments[0], "00000", "100101");
        break;
      case "ori":
        machineCode = formatIType("001101", arguments[1], arguments[0], arguments[2]);
        break;
      case "slt":
        machineCode = formatRType("000000", arguments[1], arguments[2], arguments[0], "00000", "101010");
        break;
      case "sub":
        machineCode = formatRType("000000", arguments[1], arguments[2], arguments[0], "00000", "100010");
        break;
      case "sw":
        machineCode = formatIType("101011", arguments[2], arguments[0], arguments[1]);
        break;
      case "syscall":
        machineCode = "00000000000000000000000000001100"; // Fixed syscall opcode
        break;
      default:
        System.err.println("Unsupported operation: " + operation);
        break;
    }

    return Util.binaryToHex(machineCode);
  }

  // /**
  // * Converts an R-type MIPS instruction to its machine code representation.
  // *
  // * @param instruction A ParsedInstruction object specific to an R-type
  // * instruction.
  // * @return A string representing the binary machine code for the R-type
  // * instruction.
  // */
  private static String formatRType(String opcode, String rs, String rt, String rd, String shamt, String funct) {
    return opcode + Util.registerToBinary(rs) + Util.registerToBinary(rt) + Util.registerToBinary(rd) + shamt + funct;
  }

  // /**
  // * Converts an I-type MIPS instruction to its machine code representation.
  // *
  // * @param instruction A ParsedInstruction object specific to an I-type
  // * instruction.
  // * @return A string representing the binary machine code for the I-type
  // * instruction.
  // */
  private static String formatIType(String opcode, String rs, String rt, String immediate) {
    return opcode + Util.registerToBinary(rs) + Util.registerToBinary(rt) + Util.immediateToBinary(immediate, 16);
  }

  // /**
  // * Converts a J-type MIPS instruction to its machine code representation.
  // *
  // * @param instruction A ParsedInstruction object specific to a J-type
  // * instruction.
  // * @return A string representing the binary machine code for the J-type
  // * instruction.
  // */
  private static String formatJType(String opcode, String address) {
    String binaryAddress = Util.immediateToBinary(address, 26);
    return opcode + binaryAddress;
  }

}
