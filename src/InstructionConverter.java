public class InstructionConverter {
	private String mnemonic;
	private String targetRegister;
	private String sourceRegister2;
	private String sourceRegister1;

	/**
     * Constructs an instance of the InstructionConverter.
     * Initializes any necessary state or configurations required for conversion.
     */
    public InstructionConverter(InstructionParser.ParsedInstruction instruction) {
    	this.mnemonic = instruction.getMnemonic();
    	this.targetRegister = instruction.getTarget();
    	this.sourceRegister1 = instruction.getSourceRegister1();
    	this.sourceRegister2 = instruction.getSourceRegister2();
    	
    }

    /**
     * Converts a parsed MIPS assembly instruction into machine code.
     * 
     * @param instruction A ParsedInstruction object containing the operation and
     *                    operands of the MIPS instruction.
     * @return A string representing the machine code in hexadecimal format.
     */
    public String convertToMachineCode(InstructionParser.ParsedInstruction instruction) {

        return null;
        // TODO
    	
    	
    	
    }

    /**
     * Converts an R-type MIPS instruction to its machine code representation.
     *
     * @param instruction A ParsedInstruction object specific to an R-type
     *                    instruction.
     * @return A string representing the binary machine code for the R-type
     *         instruction.
     */
    private String String (InstructionParser.ParsedInstruction instruction) {
        StringBuilder RmachineCode = new StringBuilder();
        RmachineCode.append("000000");
        switch (instruction.getMnemonic()) {
            case "add":
                RmachineCode.append("100000");
                appendRegisterValues(RmachineCode, instruction);
                break;

            case "sub":
                RmachineCode.append("100010");
                appendRegisterValues(RmachineCode, instruction);
                break;

            case "and":
            RmachineCode.append("100100");
            appendRegisterValues(RmachineCode, instruction);
            break;

            case "or":
                RmachineCode.append("100101");
                appendRegisterValues(RmachineCode, instruction);
                break;

            case "slt":
                RmachineCode.append("101010");
                appendRegisterValues(RmachineCode, instruction);
                break;

            case "syscall":
                RmachineCode.append("001100");
                appendRegisterValues(RmachineCode, instruction);
                break;
        }

        return RmachineCode.toString().toLowerCase().substring(2);

    }
    private void appendRegisterValues(StringBuilder RmachineCode, InstructionParser.ParsedInstruction instruction) {
        int rs = Integer.parseInt(sourceRegister1);
        int rd = Integer.parseInt(targetRegister);
        int rt = Integer.parseInt(sourceRegister2);
        RmachineCode.append(String.format("%05X", (rs << 21) | (rt << 16) | (rd << 11)));
    }



    /**
     * Converts an I-type MIPS instruction to its machine code representation.
     * 
     * @param instruction A ParsedInstruction object specific to an I-type
     *                    instruction.
     * @return A string representing the binary machine code for the I-type
     *         instruction.
     */
    private String convertIType(InstructionParser.ParsedInstruction instruction) {
        String rs = instruction.getSourceRegister1();
        String rt = instruction.getSourceRegister2();
        String immediate = "0000000000000000";

        String machineCode = "";
        String hexImmediate = String.format("%04X", immediate);

        switch (mnemonic) {
            case "lw":
            case "sw":
                int baseAddress = Integer.parseInt(sourceRegister1);

                int offset = 42;

                int finalAddress = baseAddress + offset;

                String hexAddress = String.format("%04X", finalAddress);

                machineCode = "001000" + rt + rs + hexAddress;
                break;

            case "lui":
                machineCode = "001111" + rt + "00000" + hexImmediate;
                break;

            case "addi":
                machineCode = "0010000" + rt + rs + hexImmediate;
                break;

            case "ori":
                machineCode = "001101" + rt + rs + hexImmediate;
                break;

            case "beq":
                machineCode = "000100" + rt + rs + hexImmediate;
                break;

            case "bne":
                machineCode = "00010" + rt + rs + hexImmediate;
                break;

                //Must finnish the JUMP instruction
//            case"j":
//                machineCode = "000010" + INSTCT_INDEX

            default:
                // Handle unsupported instructions (e.g., return null or throw exception)
                break;
        }

        return machineCode;

    }

    /**
     * Converts a J-type MIPS instruction to its machine code representation.
     * 
     * @param instruction A ParsedInstruction object specific to a J-type
     *                    instruction.
     * @return A string representing the binary machine code for the J-type
     *         instruction.
     */
    private String convertJType(InstructionParser.ParsedInstruction instruction) {
		return null;
        // TODO


}

    
}
