import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
    @author: Frank Martinez
    Swiss Army Knife
    Programming Assignment 5
*/

class Request{
    private static HttpURLConnection connection;
    protected String userURL;
    protected ArrayList<String> urlList= new ArrayList<String>();
    protected StringBuffer webResponseContent;
    protected boolean parse;
 
    public void URLreader(boolean json, String urlInpuString) {
        //variables for reading/parsing text
        userURL = urlInpuString;
        parse = json;
        String line;
        BufferedReader webReader;
        webResponseContent = new StringBuffer();

        try{
            //url
            URL url = new URL(userURL);

            //opens connection between client and server
            connection = (HttpURLConnection) url.openConnection();

            //setting up the request
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(4500);
            connection.setReadTimeout(5000);

            /*
            1xx: processing
            2xx: success
            3xx: redirect user
            4xx: client error
            5xx: server error
            */
            int httpStatus =  connection.getResponseCode();
            
           
            //if connection was established read the content 
            if (httpStatus <300){
               
                webReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = webReader.readLine()) != null){
                    webResponseContent.append(line+"\n");

                }
                webReader.close();

                //parse content or call toString to print content
                if(parse == true){
                    parseJSON(webResponseContent);
                }else{
                    toString();
                }
            }
            else{//otherwise read us the error message
                webReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = webReader.readLine())  != null){
                    webResponseContent.append(line);
                }
                webReader.close();
            }

        }
        catch(MalformedURLException e){
            System.out.println("Malformed URL");
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("\nsuccess!");
            connection.disconnect();
        }
    }
    //using Regular expressions to parse the URL's only from a json format!
    public void parseJSON(StringBuffer jsonContent){
        Pattern regex = Pattern.compile("(http|ftp|https)://([\\w_-]+(?:(?:\\.[\\w_-]+)+))([\\w.,@?^=%&:/~+#-]*[\\w@?^=%&/~+#-])?");
        Matcher matcher = regex.matcher(jsonContent);
        boolean parse = false;
         while (matcher.find()){
            urlList.add(matcher.group());
         } 
         //arraylist of our parsed URL's being executed in urlReader function
         for(String url:urlList){
             URLreader(parse, url);
         }
         
    }

    //printing the content
    public String toString(){
        String commandOutput = "\nURL "+userURL+"\n";
        ArrayList<String> urlContent = new ArrayList<String>();
        String lines = "";
        System.out.print(commandOutput); 

        for(int i =0; i <= webResponseContent.length() - 1 ; ++i)
        {
            if(webResponseContent.charAt(i) != '\n')
            {
                lines =lines+webResponseContent.charAt(i) ;
                urlContent.add(lines);
            }
            else{
                System.out.println(lines);
                lines = "";
                urlContent.add(lines);
            }
        }
        if(!lines.equals("")){
            System.out.println(lines);
            
        }
       return commandOutput; 
    }

}