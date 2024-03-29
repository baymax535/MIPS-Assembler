public class MIPSAssembler {
	public static void main(String[] args) {
		// get input MIPS from command line
		// create InstructionParser object and parse
		// Create instructionConverter object and convert
		// output

		if (args.length != 1) {
		    System.err.println("Usage: java -jar MIPSAssembler.jar <inputFile.asm>");
			System.exit(1);
		}
		//Milestone 1
//		try {
//			String instruction = args[0];
//			InstructionParser parser = new InstructionParser(instruction);
//			String operation = parser.getOperation();
//			String[] arguments = parser.getArguments();
//
//			String machineCode = InstructionConverter.convertToMachineCode(operation, arguments);
//
//			System.out.println(machineCode);
//	        
//		} catch (Exception e) {
//			System.exit(1);
//		}
		//Milestone 2
		try {
		    String inputFile = args[0];
		    MIPSFileProcessor fileProcessor = new MIPSFileProcessor();
		    fileProcessor.processMIPSFile(inputFile);
		} catch (Exception e) {
		    System.err.println("An error occurred during file processing: " + e.getMessage());
		    e.printStackTrace(); // Consider whether to include this based on your error handling strategy
		    System.exit(1);
		}
	}

}
