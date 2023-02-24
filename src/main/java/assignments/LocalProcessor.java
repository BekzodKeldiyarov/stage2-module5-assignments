package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private static List<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap, Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        LocalProcessor.stringArrayList = new LinkedList<>(stringList);
        for (String s : LocalProcessor.stringArrayList) {
            if (s != null) {
                System.out.println(s.hashCode());
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : LocalProcessor.stringArrayList) {
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }
        stringBuilder.append(processorVersion);
        processorName = stringBuilder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(processorVersion);
        try {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                stringBuilder.append(informationScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (informationScanner != null) {
                informationScanner.close();
            }
        }


        processorName = stringBuilder.toString();

    }
}
