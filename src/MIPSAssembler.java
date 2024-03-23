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
			String instruction = args[0];
			InstructionParser parser = new InstructionParser(instruction);
			String operation = parser.getOperation();
			String[] arguments = parser.getArguments();

			String machineCode = InstructionConverter.convertToMachineCode(operation, arguments);

			System.out.println(machineCode);
		} catch (Exception e) {
			System.exit(1);
		}
	}

}
