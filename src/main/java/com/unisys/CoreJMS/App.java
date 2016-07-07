package com.unisys.CoreJMS;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      System.out.println( "Inside Main" );
      new Sender().sendMessage();
      new Receiver().receiveMessage();
    }
}
