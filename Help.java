class Help{
    public static void userHelp(){
        System.out.println("\nCommands:");
        System.out.println("-HttpRequest [URL]");
        System.out.println("-HttpRequestIndex [URL]");
        System.out.println("-Help");
        System.out.println("\n-HttpRequest Examples:");
        System.out.println("java sak -HttpRequest https://web-relaxing.azurewebsites.net/");
        System.out.println("java sak -HttpRequest https://tools.learningcontainer.com/sample-json-file.json");

        System.out.println("\n-HttpRequestIndex Examples:");
        System.out.println("java sak -HttpRequest https://thunderbird-index.azurewebsites.net/w0a6zk195d.json");
    }


}