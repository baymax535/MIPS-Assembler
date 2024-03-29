import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MIPSFileProcessor {
    private Map<String, Integer> labelAddresses = new HashMap<>();
    private List<String> textInstructions = new ArrayList<>();
    private List<String> dataInstructions = new ArrayList<>();
    private int textAddress = 0x00400000;
    private int dataAddress = 0x10010000;

    public void processMIPSFile(String inputFile) {
        boolean inTextSection = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals(".data")) {
                    inTextSection = false;
                    continue;
                } else if (line.trim().equals(".text")) {
                    inTextSection = true;
                    continue;
                }

                if (inTextSection) {
                    processTextLine(line.trim());
                } else {
                    processDataLine(line.trim());
                }
            }

            StringBuilder textSection = generateTextSection();
            StringBuilder dataSection = generateDataSection();

            writeOutputFiles(inputFile.replace(".asm", ".text"), textSection.toString());
            writeOutputFiles(inputFile.replace(".asm", ".data"), dataSection.toString());
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }

    private void processTextLine(String line) {
   
        if (line.isEmpty() || line.startsWith("#")) return; // Ignore empty lines and comments
        
        if (line.contains(":")) { // Label handling
            String label = line.substring(0, line.indexOf(':')).trim();
            labelAddresses.put(label, textAddress);
            if (line.length() > line.indexOf(':') + 1) {
                line = line.substring(line.indexOf(':') + 1).trim(); // Continue processing if there's more after the label
            } else {
                return; // Only a label on this line
            }
        }

        // Assuming parseInstruction and convertToMachineCode methods exist and are functional
        InstructionParser parser = new InstructionParser(line);
        String operation = parser.getOperation();
        String[] arguments = parser.getArguments();

        String machineCode = InstructionConverter.convertToMachineCode(operation, arguments);
        textInstructions.add(machineCode);
        textAddress += 4;// Increment text address by 4 bytes (size of one instruction)
    }

    private void processDataLine(String line) {
    		if (line.isEmpty() || line.startsWith("#")) return;
            if (line.contains(".asciiz")) {
                String stringValue = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));
                dataInstructions.add(stringToHexAscii(stringValue));
            }
    }

    private StringBuilder generateTextSection() {
        StringBuilder section = new StringBuilder();
        textInstructions.forEach(instruction -> section.append(instruction).append("\n"));
        return section;
    }

    private StringBuilder generateDataSection() {
        StringBuilder section = new StringBuilder();
        dataInstructions.forEach(instruction -> section.append(instruction).append("\n"));
        return section;
    }

    private void writeOutputFiles(String outputPath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private String stringToHexAscii(String input) {
        StringBuilder output = new StringBuilder();
        for (char c : input.toCharArray()) {
            output.append(String.format("%02x", (int) c));
        }
        output.append("00"); // Null terminator for .asciiz
        return output.toString();
    }
}