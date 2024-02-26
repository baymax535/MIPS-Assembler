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
    	String result = instruction;
    	int index;
    	for(index = 0;index<result.length();index++) {
    		if (instruction.charAt(index) == '#') {
                break;
            }
    	}
    	result = instruction.substring(0, index);
    	
    	return result;
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
    	String[] parts = instruction.split(" `",3);//Spliting the windows instruction at `
    	if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid number of components in the instruction.");
        }
    	return parts;
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
    	// Validate mnemonic
        if (!isValidMnemonic(components[0])) {
            return false;
        }
        // Validate operands
        
        
        return true;	
    }

    // Helper method to extract operands from the instruction component
    private String[] extractOperands(String[] components) {
        // TODO
    	String[] operands = new String[2];
    	operands[0] = components[1];
    	operands[1] = components[2];
    	return operands;
    }

    //maybe more methods if needed
    
    private boolean isValidMnemonic(String mnemonic) {
        // List of valid mnemonics
        String[] validMnemonics = {
            "add", "addiu", "and", "andi", "beq", "bne", "j", "lui", "lw", "or", "ori", "slt", "sub", "sw", "syscall"
        };

        // Check if the mnemonic is in the list of valid mnemonics
        for (int i = 0; i< validMnemonics.length;i++) {
            if (validMnemonics[i].equals(mnemonic)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidOperandCount(String mnemonic, int operandCount) {
        // Add logic to check if the operand count is valid for the given mnemonic
        // Return true if valid, false otherwise
    	//TODO
        return false;
    }

    private boolean isValidOperand(String operand) {
        // Add logic to check if the operand format is valid
        // Return true if valid, false otherwise
    	//TODO
        return false;
    }

}
