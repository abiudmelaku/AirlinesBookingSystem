package com.AirlinesLauncher;

import sample.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Streams implements IStreams {
    @Override
    public boolean readAndWriteBoolean(Object o) {
        boolean castedServerResponse = false;
        try {
            ObjectOutputStream write = new ObjectOutputStream(Main.client.getOutputStream());
            write.writeObject(o);
            ObjectInputStream read = new ObjectInputStream(Main.client.getInputStream());
            Object readServerResponse = read.readObject();
           castedServerResponse = (boolean) readServerResponse;

        }catch (IOException e) {
                System.out.println("ERR : "+e);
        } catch (ClassNotFoundException e){
        System.out.println("ERR : "+e);
        }
        return castedServerResponse;
    }

    @Override
    public String readAndWriteString(Object o) {
        String castedServerResponse = "";
        try {
            ObjectOutputStream write = new ObjectOutputStream(Main.client.getOutputStream());
            write.writeObject(o);
            ObjectInputStream read = new ObjectInputStream(Main.client.getInputStream());
            Object readServerResponse = read.readObject();
             castedServerResponse = (String) readServerResponse;

        }catch (IOException e) {
            System.out.println("ERR : "+e);
        } catch (ClassNotFoundException e){
            System.out.println("ERR : "+e);
        }
        return castedServerResponse;

    }


}
