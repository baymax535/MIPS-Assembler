//Takes single line of MIPS assembly code as input, breaks down into recognizable parts (operation, registers, immediate vlaue, offset/label)
public class InstructionParser {
    /**
    * Constructs an instance of the InstructionParser.
     * This constructor initializes any necessary state or configurations required for parsing.
    */
    public InstructionParser() {
        //TODO
    }

    /**
     * Parses a MIPS assembly instruction into its components.
     * 
     * @param instruction A string representing a single line of MIPS assembly code.
     * @return A ParsedInstruction object containing the separated components of the
     *         instruction.
     * @throws IllegalArgumentException If the instruction format is invalid or
     *                                  unsupported.
     */
    public ParsedInstruction parse(String instruction){
        //TODO
    }

    //Helper
    /**
     * Removes comments from a MIPS assembly instruction.
     * Comments are identified by a '#' character and everything following it is
     * considered a comment.
     * 
     * @param instruction The MIPS assembly instruction potentially containing
     *                    comments.
     * @return The instruction with comments removed.
     */
    public String removeComments(String instruction){
        //TODO
    }

    /**
     * Splits the MIPS assembly instruction into its primary components (mnemonic
     * and operands).
     * 
     * @param instruction The MIPS assembly instruction without comments.
     * @return An array of String where the first element is the mnemonic and the
     *         subsequent elements are the operands.
     */
    public String[] splitComponenets(String instruction){
        //TODO
    }

    /**
     * Validates the components of the MIPS assembly instruction to ensure they meet
     * expected formats and values.
     * 
     * @param components An array of Strings representing the mnemonic and operands
     *                   of the instruction.
     * @return true if the components are valid according to the instruction set
     *         specifications; false otherwise.
     */
    private boolean validateComponents(String[] components){
        //TODO
    }

    // Helper method to extract operands from the instruction component
    private String[] extractOperands(String[] components) {
        // TODO
    }

    //maybe more methods if needed

}
