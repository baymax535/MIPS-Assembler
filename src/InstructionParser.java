//Takes single line of MIPS assembly code as input, breaks down into recognizable parts (operation, registers, immediate vlaue, offset/label)
public class InstructionParser {
    
    private String operation;
	private String[] arguments;
	/**
     * Constructs an instance of the InstructionParser.
     * This constructor initializes any necessary state or configurations required
     * for parsing.
     */
	public InstructionParser(String instruction) {
		parseInstruction(instruction);
	}
	
	private void parseInstruction(String instruction) {
		instruction = instruction.split("#")[0].trim();
		
		String[] parts = instruction.split("\\s+", 2);
		operation = parts[0].trim();
		
		if(parts.length > 1) {
			arguments = parts[1].split(",\\s*");
		} else {
			arguments = new String[0];
		}
	}
	
	public String getOperation() {
		return operation;
	}
	
	public String[] getArguments() {
		return arguments;
	}
}
