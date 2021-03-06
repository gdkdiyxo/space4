package ai.promethean.Output;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import ai.promethean.API.API;
import com.fasterxml.jackson.databind.*;

public class JSONOutput implements Output {

    /**
     * This function takes in a Java object and transcribes it into a JSON file
     * @param o: Java object to write to file
     * @param filePath: The desired location of the output file
     * @param fileIdentifier: A string to append to the file name to denote what type of JSON objects it stores
     */
    public void writeToFile(Object o, String filePath, String fileIdentifier){
        ObjectMapper mapper= new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT);
        try {
            //For now, create a unique file name with the current date
            //Might include file prefix later as an argument
            String fileName= filePath + fileIdentifier+ "-" + new Date()+".json";
            fileName = fileName.replace(" ", "");
            fileName = fileName.replace(":", "");
            mapper.writeValue(new File(fileName), o);
        }catch(IOException io){
            API api= new API();
            api.throwOutputError("Invalid Output File Path: "+ io);
        }
    }

}

