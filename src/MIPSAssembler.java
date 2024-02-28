import java.util.Scanner;

public class MIPSAssembler {
	public static void main(String[] args) {
		//get input MIPS from command line
		//create InstructionParser object and parse
		//Create instructionConverter object and convert
		//output

	if(args.length == 0){
		System.out.println("Please provide a MIPS assembly instruction as an argument");
		return;
	}
	
	String mipsInstruction = args[0];

	InstructionParser parser = new InstructionParser();
	ParsedInstruction parsedInstruction = parser.parse(mipsInstruction);

	InstructionConverter converter = new InstructionConverter();
	String machineCode = converter.convertToMachineCode(parsedInstruction);

	String formattedMachineCode = Util.formatOutput(machineCode);

	System.out.println("Machine Code: " + formattedMachineCode);
	}

}
