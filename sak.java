import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;
import java.text.DecimalFormat;
/* 
    @author: Frank Martinez
    Swiss Army Knife
    Programming Assignment 5
*/
class sak{
  
    public static void main(String[] args) {
        //Trunicate ellapsed time to 4th place
        DecimalFormat formatter = new DecimalFormat("#.####");
        formatter.setRoundingMode(RoundingMode.DOWN);

        //invalid arguments
       if (args.length == 0){
        System.out.println("\nThis application requires at least one argument. Utilize the \"-Help\" parameter for help:");
        Help.userHelp();     
       }
       else{
           //process "-" commands
            switch(args[0].charAt(0)){

                case '-':
                    //httpRequest
                    if (args[0].equalsIgnoreCase("-HttpRequest")){
                        System.out.println("\nExecuting HttpRequest...");
                        //start timer
                        long startTime = System.nanoTime();

                        //execute http request
                        String userURL = args[1];
                        Request req = new Request();
                        boolean parse = false;

                        //end timer
                        req.URLreader(parse,userURL);
                        long endTime = System.nanoTime();
                        double duration = (endTime-startTime)/1000000000.0 ;

                        //ellapsed time
                        System.out.print("Ellapsed time: "+ formatter.format(duration)+ " seconds");
                    }
                    //HttpRequestIndex
                    if (args[0].equalsIgnoreCase("-HttpRequestIndex")){
                        System.out.println("\nExecuting HttpRequestIndex...");
                        //start timer
                        long startTime = System.nanoTime();

                        //execute http request index
                        String userURL = args[1];
                        RequestIndex req = new RequestIndex(userURL);

                        //end timer
                        long endTime = System.nanoTime();
                        double duration = (endTime-startTime)/1000000000.0 ;

                        //ellapsed time
                        System.out.print("Ellapsed time: "+ formatter.format(duration)+ " seconds");
                        //Average time
                        System.out.print("\nAverage time: "+ formatter.format(duration/4)+ " seconds");
                    }
                    //Help
                    if(args[0].equalsIgnoreCase("-Help")){
                        System.out.println("\nExecuting Help...");
                        Help.userHelp();
                    }
                break;

                //invalid arguments processed here
                default:
                    System.out.println("\n"+args[0] +" is not a valid parameter");
                    Help.userHelp();
                   
            }
        
       }
    }

}