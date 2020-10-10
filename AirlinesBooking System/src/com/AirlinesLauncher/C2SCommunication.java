package com.AirlinesLauncher;

import DatabaseAccess.DataAccess;
import DatabaseAccess.IDataAccess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

 public class C2SCommunication implements Runnable  {
     Socket serverNode;
     public C2SCommunication(Socket serverNode){
         this.serverNode = serverNode;
     }


     @Override
     public void run() {
         while (true){
             try {
                 ObjectInputStream  objectInputStream = new ObjectInputStream(serverNode.getInputStream());
                 Object readClinetRequest = objectInputStream.readObject();
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(serverNode.getOutputStream());
                 try {
                     boolean serverResponse = (boolean) readClinetRequest;
                     objectOutputStream.writeObject(serverResponse);
                     System.out.println(serverResponse);
                 } catch (ClassCastException e) {
                     String serverResponseDA = (String) readClinetRequest;
                     objectOutputStream.writeObject(serverResponseDA);
                     System.out.println(serverResponseDA);
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             } catch (ClassNotFoundException e) {
                 e.printStackTrace();
             }


         }


     }
 }
