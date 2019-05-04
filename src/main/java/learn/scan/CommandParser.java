package learn.scan;

import com.fasterxml.jackson.databind.ObjectMapper;
import learn.model.Emploee;
import learn.server.Method;

import java.io.IOException;

public class CommandParser {

    ObjectMapper objectMapper = new ObjectMapper();

    public Method getMethod(String command) {
        String methodName = command.split(" ")[0];
        if (methodName.equalsIgnoreCase(Method.GET.toString())) {
            return Method.GET;
        } else if (methodName.equalsIgnoreCase(Method.PUT.toString())) {
            return Method.PUT;
        } else {
            throw new RuntimeException("Wrong method!");
        }
    }

    public String getIdCommand(String command) {
        return command.split(" ")[1];
    }

    public Emploee getEmploeeJson(String command) throws IOException {
        StringBuilder json = new StringBuilder();
        String []split = command.split(" ");
        for (int i = 1; i < split.length; i++) {
            json.append(split[i]);
        }
        return objectMapper.readValue(json.toString(), Emploee.class);
    }
}
