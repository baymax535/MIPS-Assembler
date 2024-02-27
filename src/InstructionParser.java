//Takes single line of MIPS assembly code as input, breaks down into recognizable parts (operation, registers, immediate vlaue, offset/label)
public class InstructionParser {
    /**
     * Constructs an instance of the InstructionParser.
     * This constructor initializes any necessary state or configurations required
     * for parsing.
     */
    public InstructionParser() {
        // TODO
    }

    public class ParsedInstruction {
        private String mnemonic;
        private String targetRegister;
        private String sourceRegister1;
        private String sourceRegister2;

        ParsedInstruction(String mnemonic, String targetRegister, String sourceRegister1, String sourceRegister2) {
            this.mnemonic = mnemonic;
            this.targetRegister = targetRegister;
            this.sourceRegister1 = sourceRegister1;
            this.sourceRegister2 = sourceRegister2;
        }

        public String getMnemonic() {
            return mnemonic;
        }

        public String getTarget() {
            return targetRegister;
        }

        public String getSourceRegister1() {
            return sourceRegister1;
        }

        public String getSourceRegister2() {
            return sourceRegister2;
        }
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
    public ParsedInstruction parse(String instruction) {
        instruction = removeComments(instruction);
        String[] arr = splitComponents(instruction);
        boolean isValid = validateComponents(arr);
        ParsedInstruction ans = null;
        if (isValid) {

        } else
            return ans;

        return ans;
    }

    // Helper
    /**
     * Removes comments from a MIPS assembly instruction.
     * Comments are identified by a '#' character and everything following it is
     * considered a comment.
     * 
     * @param instruction The MIPS assembly instruction potentially containing
     *                    comments.
     * @return The instruction with comments removed.
     */
    public String removeComments(String instruction) {
        // TODO
        String result = instruction;
        int index;
        for (index = 0; index < result.length(); index++) {
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

    public String[] splitComponents(String instruction) {
        // TODO
        String[] parts = instruction.split(" `", 3);// Spliting the windows instruction at `
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
    private boolean validateComponents(String[] components) {
        // TODO
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
        if (components[2].contains(", ")) {
            operands = components[2].split(", ", 2);
        }
        return operands;
    }

    // maybe more methods if needed

    private boolean isValidMnemonic(String mnemonic) {
        // List of valid mnemonics
        String[] validMnemonics = {
                "add", "addiu", "and", "andi", "beq", "bne", "j", "lui", "lw", "or", "ori", "slt", "sub", "sw",
                "syscall"
        };

        // Check if the mnemonic is in the list of valid mnemonics
        for (int i = 0; i < validMnemonics.length; i++) {
            if (validMnemonics[i].equals(mnemonic)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidOperandCount(String mnemonic, int operandCount) {

        if (mnemonic.equals("add")) {
            System.out.println("add please");
        }

        else if (mnemonic.equals("addiu")) {
            System.out.println("addiu please");
        }

        else if (mnemonic.equals("and")) {
            System.out.println("and please");
        }

        else if (mnemonic.equals("andi")) {
            System.out.println("andi please");
        }

        else if (mnemonic.equals("beq")) {
            System.out.println("beq please");
        }

        else if (mnemonic.equals("bne")) {
            System.out.println("bne please");
        }

        else if (mnemonic.equals("j")) {
            System.out.println("j please");
        }

        else if (mnemonic.equals("lui")) {
            System.out.println("lui please");
        }

        else if (mnemonic.equals("lw")) {
            System.out.println("lw please");
        }

        else if (mnemonic.equals("or")) {
            System.out.println("or please");
        }

        else if (mnemonic.equals("ori")) {
            System.out.println("ori please");
        }

        else if (mnemonic.equals("slt")) {
            System.out.println("slt please");
        }

        else if (mnemonic.equals("sub")) {
            System.out.println("sub please");
        }

        else if (mnemonic.equals("sw")) {
            System.out.println("sw please");
        }

        else if (mnemonic.equals("syscall")) {
            System.out.println("syscall please");
        }

        else
            return false;
        return true;
    }

    private boolean isValidOperand(String[] operand) {
        // Add logic to check if the operand format is valid
        // Return true if valid, false otherwise
        // TODO
        return false;
    }
}
