import java.util.Scanner;

public class MIPSAssembler {
	public static void main(String[] args) {
		//get input MIPS from command line
		//create InstructionParser object and parse
		//Create instructionConverter object and convert
		//output
		
		Scanner stdIn = new Scanner(System.in);
		
		String AssemblyInstruction = stdIn.nextLine();
		String[] parts = AssemblyInstruction.split(" `",3);
		
		String mnemonic = parts[0];
		String targetRegister = parts[1];
		String sourceRegister = parts[2];
		if(parts[2].contains("#")) {
			String copy = "";
			for(int i = 0; i < parts[2].length() && !parts[2].substring(i, + 1).equals("#"); i++) {
				copy = copy + parts[2].substring(i, i + 1);
			}
		}
		System.out.println("^"+mnemonic+"^"+targetRegister+"^"+sourceRegister+"^");
		
		stdIn.close();
		
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
		
		else {
		    System.out.println("Unknown mnemonic");
		}

		
	}

}
