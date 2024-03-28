public class MIPSAssembler {
	public static void main(String[] args) {
		// get input MIPS from command line
		// create InstructionParser object and parse
		// Create instructionConverter object and convert
		// output

		if (args.length != 1) {
			System.exit(1);
		}

		try {
//			//Milestone 1
//			String instruction = args[0];
//			InstructionParser parser = new InstructionParser(instruction);
//			String operation = parser.getOperation();
//			String[] arguments = parser.getArguments();
//
//			String machineCode = InstructionConverter.convertToMachineCode(operation, arguments);
//
//			System.out.println(machineCode);
			
			//Milestone 2
			String inputFile = args[0];
	        MIPSFileProcessor fileProcessor = new MIPSFileProcessor();
	        
	        fileProcessor.processMIPSFile(inputFile);
	        
		} catch (Exception e) {
			System.exit(1);
		}
	}

}
