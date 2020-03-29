import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

class sak{
  
    public static void main(String[] args) {
       if (args.length == 0){
        System.out.println("\nThis application requires at least one argument. Utilize the \"-Help\" parameter for help:");
        Help.userHelp();     
       }
       else{
            switch(args[0].charAt(0)){

                case '-':
                    if (args[0].equalsIgnoreCase("-HttpRequest")){
                        System.out.println("\nExecuting HttpRequest...");
                        String userURL = args[1];

                        Request req = new Request();
                        boolean parse = false;
                        req.URLreader(parse,userURL);
                        

                    }

                    if (args[0].equalsIgnoreCase("-HttpRequestIndex")){
                        System.out.println("\nExecuting HttpRequestIndex...");
                        String userURL = args[1];

                        RequestIndex req = new RequestIndex(userURL);
                        
                        //req.URLreader(userURL);
                    }

                    if(args[0].equalsIgnoreCase("-Help")){
                        System.out.println("\nExecuting Help...");
                        Help.userHelp();
                    }
                break;

                default:
                    System.out.println("\n"+args[0] +" is not a valid parameter");
                    Help.userHelp();
                   
            }
        
       }
    }

}