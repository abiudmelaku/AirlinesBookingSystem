package com.AirlinesLauncher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class EmailServer {
    private static Socket smtpSocket;
    private static PrintWriter out;
    private static BufferedReader in;
    public static void main(String[] args){
        /*
        * Initialization section:
        * Try to open a socket on port 25
        * Try to open input and output streams
        * */
        try{
            smtpSocket =  new Socket("localhost",25);
            in = new BufferedReader (new InputStreamReader(smtpSocket.getInputStream()));
            out = new PrintWriter(smtpSocket.getOutputStream(),true);

        }catch (UnknownHostException e){
            System.err.println("Don't know about host: hostname");
        }catch (IOException e){
            System.err.println("Could'nt get I/O for the connection to : hostname");
        }
        /*
        * If everything has been initialized then we want to write some data -
        * - to the socket we have opened a connection to on port 25
        * */
        if(smtpSocket != null && out != null && in != null){

            try {
                //  Step - 1 : Get a greeting by the server
                String responseLine;
                while ((responseLine = in.readLine()) != null) {
                    System.out.println("com.AirlinesLauncher.Server : " + responseLine);
                    if(responseLine.indexOf("220") != -1){
                        break;
                    }

                }
                // Step - 2 : The client initiates it's dialog by responding with a "HELO" command identifying itself
                out.println("HELO " + InetAddress.getLocalHost().getHostName());
                System.out.println("HELO " + InetAddress.getLocalHost().getHostName());
                while((responseLine = in.readLine()) != null){
                    System.out.println("com.AirlinesLauncher.Server : " + responseLine);
                    if(responseLine.indexOf("250") != -1){
                        break;
                    }
                }
                /*
                * Step - 3 : The client notifies the receiver of the originating email address of the message -
                *  using the command "MAIL FROM "
                * */
                out.println("MAIL From: abiud_melaku@yahoo.com");
                while((responseLine = in.readLine()) != null){
                    System.out.println("com.AirlinesLauncher.Server : " + responseLine);
                    if(responseLine.indexOf("250") != -1){
                        break;
                    }
                }
                /*
                * Step - 4 : The client notifies the receiver of the recipient email address of the message in a -
                * RCPT TO command
                * */
                out.println("RCPT TO: abiudmelaku19988@gmail.com");
                while((responseLine = in.readLine()) != null){
                    System.out.println("com.AirlinesLauncher.Server : " + responseLine );
                    if(responseLine.indexOf("250") != -1){
                        break;
                    }
                }
                /* Step - 5 : Send DATA command */
                out.println("DATA");
                while((responseLine = in.readLine()) != null){
                    System.out.println("com.AirlinesLauncher.Server : " + responseLine);
                    if(responseLine.indexOf("354") != -1){
                        break;
                    }
                }
                /* Step - 6 : Send Email Body */
                out.println("From: abiudmelaku19988@gmail.com");
                out.println("To: abiud_melaku1998@yahoo.com");
                out.println("Subject: Test Email");
                out.println();
                out.println("Subject: TEST EMAIL");// message body
                out.println("This is a test message"); // message body
                out.println("Thanks");
                out.println("Java Network Programming course");  //message body
                out.println();
                out.println(".");
                 while((responseLine = in.readLine()) != null){
                     System.out.println("com.AirlinesLauncher.Server : " + responseLine);
                     if(responseLine.indexOf("250") != -1){
                         break;
                     }

                 }
             /*
             * Step - 7 : Send Quit command
             * */
             out.println("QUIT");
             while((responseLine = in.readLine()) != null){
                 System.out.println("com.AirlinesLauncher.Server : " + responseLine);
                 if(responseLine.indexOf("221") != -1){
                     break;
                 }
             }
             System.out.println("Email successfully sent !!!");
             /*
             * close the outputStream
             * close the inputStream
             * close the socket
             * */
             out.close();
             in.close();
             smtpSocket.close();
            }catch (IOException e){
                System.err.println("Err : " + e);
            }


        }

    }

}