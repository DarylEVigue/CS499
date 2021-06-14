/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validatecredentials;

/**
 *
 * @author daryl.vigue_snhu
 */
//import java.io.File;
import java.security.MessageDigest;
import java.util.Scanner;
public class ValidateCredentials

{
     public static void main(String[] args)

   {
   Scanner readInput = new Scanner(System.in);
 
   int logonAttempts = 0;

   while(true)

    {

     System.out.print("User name?");//get user name

     String userName=readInput.nextLine();

     System.out.print("Password?");//get password

     String original = readInput.nextLine();

     MessageDigest md = MessageDigest.getInstance("MD5");//convert

     md.update(original.getBytes());

     byte[] digest = md.digest();

     StringBuffer sb = new StringBuffer();

        for (byte b : digest)

        {

        sb.append(String.format("%02x", b & 0xff));

        }

    boolean authentication = false;

    Scanner getCredentials = new Scanner(new File("Credentials.txt"));//open credential file

    while(getCredentials.hasNextLine())

        {

        String record = getCredentials.nextLine();

        String columns[] = record.split(" ");
                      
        if(columns[0].trim().equals(userName))//confirm user name

       {

       if(columns[1].trim().equals(sb.toString()))//confirm the correct password

	System.out.println("original:" + original);
	System.out.println("digested:" + sb.toString()); //sb.toString() is what you'll need to compare password strings
       {
                           
       authentication = true;//success

       
       
// write method to parse role text and call correct file



       if(authentication)

       {

        System.out.println("Log out(y/n): ");//log out

        String logOutDecision = readInput.nextLine();

        if(logOutDecision.toLowerCase().charAt(0) == 'y')

        {

        System.out.println("Logged out.");//confirmed logout

        break;

            }

            else

          {

        authentication = false;

        }

        }

        else

       {

          logonAttempts = logonAttempts + 1;

          if(logonAttempts == 3)

       {

       System.out.println("Maximum Invalid Attempts Exceeded, Exiting Program");//authentication failure

        break;

       }

        else

          {

              System.out.println("Please try again.  Enter your correct credentials to logon.");     

          }

       }

    }

   }

}