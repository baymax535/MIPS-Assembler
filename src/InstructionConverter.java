//Converts parsed instructions into hexadecimal representation
public class InstructionConverter {

    /**
     * Constructs an instance of the InstructionConverter.
     * Initializes any necessary state or configurations required for conversion.
     */
    public InstructionConverter() {
        // TODO
    }

    /**
     * Converts a parsed MIPS assembly instruction into machine code.
     * 
     * @param instruction A ParsedInstruction object containing the operation and
     *                    operands of the MIPS instruction.
     * @return A string representing the machine code in hexadecimal format.
     */
    public String convertToMachineCode(ParsedInstruction instruction) {
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
    private String convertRType(ParsedInstruction instruction) {
        // TODO
    }

    /**
     * Converts an I-type MIPS instruction to its machine code representation.
     * 
     * @param instruction A ParsedInstruction object specific to an I-type
     *                    instruction.
     * @return A string representing the binary machine code for the I-type
     *         instruction.
     */
    private String convertIType(ParsedInstruction instruction) {
        // TODO
    }

    /**
     * Converts a J-type MIPS instruction to its machine code representation.
     * 
     * @param instruction A ParsedInstruction object specific to a J-type
     *                    instruction.
     * @return A string representing the binary machine code for the J-type
     *         instruction.
     */
    private String convertJType(ParsedInstruction instruction) {
        // TODO
    }

    
}
