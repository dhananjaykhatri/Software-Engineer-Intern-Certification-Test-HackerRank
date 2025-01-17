// java 8

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result { 
/*
 * Complete the 'efficientJanitor' function below.
 * The function is expected to return an INTEGER.
 * The function accepts FLOAT_ARRAY weight as parameter.
 */

public static int efficientJanitor(List<Float> weight) {
    int trips = 0;
    Collections.sort(weight);        
    int index = weight.size()-1;
    int startIdx = 0;
    
    while(index > 0){
        float value = weight.get(index);
        if(value > 1.99f){
            trips++;
        } else if(value <= 1.99f){
            float nextIdxVal = weight.get(startIdx);
            if((nextIdxVal + value) <= 3.0f){
                startIdx++;
            }
            trips++;
        }
        if(startIdx >= index){
            break;
        }
        index--;
    }
    return trips;

}
}

public class Solution {
public static void main(String[] args) throws IOException {
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    int weightCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Float> weight = IntStream.range(0, weightCount).mapToObj(i -> {
        try {
            return bufferedReader.readLine().replaceAll("\\s+$", "");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    })
        .map(String::trim)
        .map(Float::parseFloat)
        .collect(toList());

    int result = Result.efficientJanitor(weight);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
}
}
