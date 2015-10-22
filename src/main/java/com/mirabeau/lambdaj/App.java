package com.mirabeau.lambdaj;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class App implements RequestHandler<List<String>, String> {

    public String handleRequest(List<String> input, Context context) {
        context.getLogger().log("Input: " + input.toString());

        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(input);
        } catch (IOException e) {
            context.getLogger().log("error could not serialize java ArrayList bytes");
        }

        String output = byteArrayOutputStream.toString();

        return output;
    }
}
