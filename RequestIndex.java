/* 
    @author: Frank Martinez
    Swiss Army Knife
    Programming Assignment 5
*/

class RequestIndex extends Request{
    //reuses request class with the exception of the parsing function
    public RequestIndex(String urlIn){
        boolean parse = true;
        super.URLreader(parse,urlIn);
    }

}