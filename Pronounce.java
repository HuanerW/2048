/**
 * Filename: Pronounce.java
 * Name: TODO
 * Login: TODO
 * Date: TODO
 * Sources of Help: TODO
 *
 * Description: TODO
 */

import java.io.*;
import java.util.Scanner;

/**
 * Class header: TODO
 */
public class Pronounce {

    /** DO NOT MODIFY THESE CONSTANTS */
    private static final char[] alphabet = {'a','e','i','o','u','p','k','h',
        'l','m','n','w',' ', '\''};
    private static final char[] vowels = {'a','e','i','o','u'};
    private static final String INPUT_USAGE = "i: convert single word\nf: " +
        "convert file\nq: quit";
    private static final String PROMPT_STR = "Enter a command: ";
    private static final String CONVERT_WORD_PROMPT = "Enter word(s) " +
        "to convert: ";
    private static final String IN_FILE_PROMPT = "Enter the name of the " +
        "file to convert: ";
    private static final String OUT_FILE_PROMPT = "Enter the name of the " +
        "file to dump the converted strings: ";
    private static final String USAGE = "`java Pronounce -h` to print help\n" +
        "`java Pronounce -f [infilename] [outfilename]` to translate file\n" +
        "`java Pronounce` to read and translate user input" ;
    private static final String PADDING = " ";
    private static final String EMPTY = "";
    private static final int PAIR_LENGTH = 2;
    private static final char SPACE_CHAR = ' ';
    private static final char QUOTE_CHAR = '\'';
    private static final char DASH_CHAR = '-';
    private static final char A_CASE = 'a';
    private static final char E_CASE = 'e';
    private static final char I_CASE = 'i';
    private static final char F_CASE = 'f';
    private static final char Q_CASE = 'q';
    private static final char O_CASE = 'o';
    private static final char U_CASE = 'u';
    private static final String AI_CASE = "ai";
    private static final String AE_CASE = "ae";
    private static final String AO_CASE = "ao";
    private static final String AU_CASE = "au";
    private static final String EI_CASE = "ei";
    private static final String EU_CASE = "eu";
    private static final String IU_CASE = "iu";
    private static final String OI_CASE = "oi";
    private static final String OU_CASE = "ou";
    private static final String UI_CASE = "ui";
    private static final String HELP_CASE = "-h";
    private static final String FILE_CASE = "-f";

    /** Declare any constants that you may need here */

    /**
     * Helper function that checks whether a given character is a vowel
     *
     * @param ch Character to check whether it is a vowel
     * @return True if a vowel else false
     */
    protected boolean isVowel(char ch)
    {
        // TODO
        Boolean j=false;

        for(int i=0; i<vowels.length;i++){
      //    Boolean j=false;
          if(ch==vowels[i]){
            j=true;
            break;
          }
          // else{
          //   j=false;
          // //  return j;// remove this
          // }
        }
      return j;
      }

    /**
     * Helper function that checks whether a given character is valid
     *
     * @param ch Character to check whether it is a valid character
     * @return True if it is valid else false
     */
    protected boolean isValidChar(char ch)
    {
        // TODO
        boolean j=false;
        for(int i=0; i<alphabet.length;i++){
          if(ch==alphabet[i]){
            j=true;
            break;
          }
          // }else{
          //   j=false; // remove this
          // }
        }
       return j;
    }

    /**
     * Helper function that checks whether a given string contains only valid
     * character
     *
     * @param str String to check whether it is valid
     * @return True if it contains only valid characters else false
     */
    protected boolean isValidString(String str)
    {
        // TODO
      boolean i=true;

      if(str==null){
        i=false;
        return i;
      }else{
         if(str.equals("")){
           i=true;
           return i;
         }else{

            boolean k=isValidChar(str.charAt((str.length()-1)));
            if(k){
            //  n+=1;
               int a=str.length()-1;
                if(a==0){
                 i= true;//isValidString(str.substring(0,a));
                   //i=true;
                 return i;}
                   else{
                     i=isValidString(str.substring(0,a));

                   }


                      isValidString(str.substring(0,a));
            }else{
               i=false;
               return i;
               //return i;

                 //break;
               }

            }
         }

         return i;

      }

    /**
     * Functions that convert a hawaiian word and returns its pronunciation in
     * words as output. It will call a helper recursive function to convert
     * the words.
     *
     * @param str String to convert into its pronunciation
     * @return String that represents its pronunciation
     */
    public String convert(String str)
    {
      if(str==null){
        return null;
      }else if(str.equals("")){
       return "";
      }else{
          String s=str.toLowerCase();
          if(isValidString(s)==false){
            return str;
          }else{
            String a=convertHelper(s);
            String s1=a.substring(0,1).toUpperCase()+a.substring(1);
            return s1;
        }

      }

    }

    /**
     * Helper recursive function that will convert the words into the correct
     * pronunciation by following the grammar rules.
     *
     * @param str String to convert into its pronunciation
     * @return String that represents its pronunciation
     */
    protected String convertHelper(String str)
    {    //int x=str.length();


        // base case of empty string returns empty string
        if(str.equals("")) // TODO 1: Change this base case condition
        {
            // TODO 2: return something in this base case
            return str;
        }
      //  String str=str.toLowerCase();
        // special pronunciation for vowels
        if(isVowel(str.charAt(0)))
        {
            String pronunciation = EMPTY;

            // two consecutive vowel check,
            // fallback to one vowel for two vowels that aren't a pair
            if(str.length()>1 && isVowel(str.charAt(1)))
            {
                String vowelPair = str.substring(0, PAIR_LENGTH);

                // TODO 3: Fill out cases for paired vowel
                switch(vowelPair)
                {
                    case AI_CASE:
                    case AE_CASE:
                        pronunciation = "eye"; // TODO 3.1
                        break;
                    case AO_CASE:
                    case AU_CASE:
                    case OU_CASE:
                        pronunciation = "ow"; // TODO 3.2
                        break;
                    case EI_CASE:
                        pronunciation = "ay"; // TODO 3.3
                        break;
                    case EU_CASE:
                        pronunciation = "eh-oh"; // TODO 3.4
                        break;
                    case IU_CASE:
                        pronunciation = "ew"; // TODO 3.5
                        break;
                    case OI_CASE:
                        pronunciation = "oy"; // TODO 3.6
                        break;
                    case UI_CASE:
                        pronunciation = "opey"; // TODO 3.7
                        break;
                }

                if(pronunciation.length()!=0)
                {
                    if(str.length()>PAIR_LENGTH &&
                        str.charAt(PAIR_LENGTH)!=SPACE_CHAR &&
                        str.charAt(PAIR_LENGTH)!=QUOTE_CHAR)
                    {
                        pronunciation += DASH_CHAR;
                    }

                  //  String stt=convertHelper()
                  //  System.out.println(stt);
                  //  String ss=str+pronunciation;
                  //  int f=ss.length()-pronunciation.length();
                    return pronunciation+convertHelper(str.substring(2));


                    // TODO 4: Recurse when first is vowel pair

                            }
             }

            char vowel = str.charAt(0);

            // TODO 5: Fill out cases for single vowel
            switch(vowel)
            {
                case A_CASE:
                    pronunciation = "ah"; // TODO 5.1
                    break;
                case E_CASE:
                    pronunciation = "eh"; // TODO 5.2
                    break;
                case I_CASE:
                    pronunciation = "ee"; // TODO 5.3
                    break;
                case O_CASE:
                    pronunciation = "oh"; // TODO 5.4
                    break;
                case U_CASE:
                    pronunciation = "oo"; // TODO 5.5
                    break;
            }

            if(str.length()>1 &&
                str.charAt(1)!=SPACE_CHAR &&
                str.charAt(1)!=QUOTE_CHAR)
            {
                pronunciation += DASH_CHAR;
            }

            // TODO 6: Recurse when first char is a vowel but not vowel group

            return pronunciation+convertHelper(str.substring(1));

              }
              else{


            // TODO 7: Recurse when first char is not a vowel
              return str.charAt(0)+convertHelper(str.substring(1));
      }


           }



    /**
     * Read in a file, convert the valid words into hawaiian pronunciation
     * and write it to a new file.
     *
     * @param infilename Filename to read in that contains hawaiian word
     * @param outfilename Filename to write the pronunciation to
     */
    protected void convertFile(String infilename, String outfilename)
    {
        Scanner sc = null;
        PrintWriter pw = null;

        // Try, catch and finally blocks are needed to read and write from file
        try
        {
            // Define a new scanner and print writer
            // TODO 1

            File inputFile = new File(infilename);
            Scanner scanner = new Scanner(inputFile);

             // Open up the output file and create PrintWriter to write it
             File outputFile = new File(outfilename);
             PrintWriter printer = new PrintWriter(outputFile);

            // Continue reading if there is more to read
            // TODO 2
             String line="";
             while(scanner.hasNextLine()) {
             // Read in one line and write to output file
             line = scanner.nextLine();
             String line2=convert(line);
             printer.println(line2);
       }



        }
        catch(Exception e)
        {
            // do nothing
        }
        finally
        {
            // Make sure to close the stream for scanner and print writer
            if(sc!=null)
            {
                sc.close();
            }

            if(pw!=null)
            {
                pw.close();
            }
        }
    }

    /**
     * Get the user input and perform actions such as converting a single
     * word, convert all words from a file based on the input
     */
    protected void readUserInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(INPUT_USAGE);

        // continually loop
        while(true)
        {
            System.out.print(PROMPT_STR);
            char command = (sc.nextLine()+PADDING).charAt(0); // handle empty

            switch(command)
            {
                case I_CASE:
                    System.out.print(CONVERT_WORD_PROMPT);
                    String word = sc.nextLine(); // the user's input
                    System.out.println(convert(word));
                    break;
                case F_CASE:
                    System.out.print(IN_FILE_PROMPT);
                    String infilename = sc.nextLine();
                    System.out.print(OUT_FILE_PROMPT);
                    String outfilename = sc.nextLine();
                    convertFile(infilename, outfilename);
                    break;
                case Q_CASE:
                    sc.close();
                    System.exit(0); // this exits the program "normally"
                default:
                    System.out.println(INPUT_USAGE);
            }
        }
    }

    /**
     * Main function that will read in command line arguments and start the
     * conversion if valid arguments were passed in
     *
     * @param args An array of all the command line arguments passed in
     */
    public static void main(String[] args)
    {
        // TODO
       Scanner in=new Scanner(System.in);
        Pronounce pro=new Pronounce();
        if(args.length!=0){
          if(args[0].equals(HELP_CASE)){
            System.out.println(USAGE);
            return;
          }else if(args[0].equals(FILE_CASE)){
              if(args.length==3){
              pro.convertFile(args[1],args[2]);

              }
            System.out.println(USAGE);
            return;
          }else{
             String sd="";
             for(int i=0; i<args.length;i++){
             sd+=pro.convert(args[i]);

           }System.out.println(sd);
          }
        }else{
          System.out.println("Please enter a Hawaiian word");
          pro.readUserInput();

        }

//Pronounce pro=new Pronounce();
        // String h=in.nextLine();
        // String n=pro.convert(h);
//boolean x=pro.isValidChar('p');
        //  System.out.println(x);
    //  boolean ab=pro.isValidString("aloha");
  //   System.out.println(ab);
      //  String ab="IAM";
      //boolean at=pro.isVowel('A');
    //  System.out.println(at);
        //String aa=ab.toLowerCase();
        //System.out.println(aa);
    //   String n=pro.convertHelper("aoea");
      //
    //  System.out.println(n);
  //  String ab="Jules";
      //System.out.println(ab.substring(0,4));

      // boolean k=pro.isValidChar(ab.charAt((ab.length()-1)));
  //     System.out.println(k);
        //String n=pro.convert("E komo mai");
      //  System.out.println(n);
    }
}
