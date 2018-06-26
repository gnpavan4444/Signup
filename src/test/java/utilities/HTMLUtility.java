package utilities;


import setup.PropertyUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

//This class is used for generating customized HTML report.

public class HTMLUtility {
    public static StringBuffer htmlTemplate=new StringBuffer();
    public static StringBuffer individualHTMLTemplate = new StringBuffer();
    static String HTML_END = "</BODY></HTML>";
    static String HTML_START = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"><HTML><HEAD>";
    static String individualReportPath ="C:\\Users\\X085271\\Desktop\\html.html";
    static PropertyUtils propertyUtils = new PropertyUtils();

    //This method is for generating header of the HTML report, where all column headings are displayed
    public static void createHTMLTemplate() throws IOException{
        htmlTemplate.append(HTML_START);
        htmlTemplate.append("<body><h1><center>Test Automation Report<style>h1.groove {border-style:groove;}body{background-color:#F8F8F8;}h1{background-color:#008CBA;color:white;text-align:center;}</style></h1><br/></body>");
        htmlTemplate.append("<style>table, th, td { border: 1px solid blue;</style>");
        htmlTemplate.append("</h2>");
        htmlTemplate.append("</div>");
        htmlTemplate.append("<div>");
        htmlTemplate.append("<h2 style='color:CornflowerBlue'>");
        htmlTemplate.append(
                "<style>table,th,td {border: 1px solid black;border-collapse;text-align: center; border-color: black; border-width: 1px;} </style>");
        htmlTemplate.append(
                "<table id='testcases' cellspacing='0' style='width: 100%' style='font-size: 20px;'> <tr bgcolor='black'>");
        htmlTemplate.append("<div>");
        htmlTemplate.append("<h2 style='color:whitesmoke'>");
        htmlTemplate.append(
                "<style>table,th,td {border: 1px solid black;border-collapse;text-align: center; border-color: #7B68EE; border-width: 1px;} </style>");
        htmlTemplate.append("<table style=\"width:100%\"><tr bgcolor='#008CBA'>" +
                "<tr bgcolor='#008CBA'>" +
                "<th style=\"width:10%;color: white;\">Sl No</th>"+
                "<th style=\"width:60%;color: white;\">Test Case Name</th>" +
                "<th style=\"width:10%;color: white;\">Status</th>" +
                "<th style=\"width:10%;color: white;\">Individual Report</th>" +
                "<th style=\"width:10%;color: white;\">Log File</th>" +
                "<th style=\"width:10%;color: white;\">Execution Time</th>" +
                "</tr>");

        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(propertyUtils.getPropertyValue("consolidatedReportPath"))));

        //write contents of StringBuffer to a file
        bwr.write(htmlTemplate.toString());

        //flush the stream
        bwr.flush();

        //close the stream
        bwr.close();

    }
    //This method is for closing the html report
    public static void closeHTMLReport() throws IOException {
     htmlTemplate.append(HTML_END);
        BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(propertyUtils.getPropertyValue("consolidatedReportPath"))));

        //write contents of StringBuffer to a file
        bwr.write(htmlTemplate.toString());

        //flush the stream
        bwr.flush();

        //close the stream
        bwr.close();

    }

    // This method is for updating test execution status. This method is called from getResult method in the SetUp.
    // Based on the test result status will be updated.
    //It also contains links for report screenshots and log files
    //This is for consolidated html report preparation
    public static void testCaseExecutionStatus(int testCasesCount, String testCaseName, String status,String filePath,File file) throws IOException {
        individualTestCaseReport(filePath+"\\");
        if(status.equalsIgnoreCase("Pass")){
            htmlTemplate.append("<table style=\"width:100%\">" +
                    "<tr bgcolor='DarkSeaGreen' style='color:black'>" +
                    "<th style=\"width:10%\">"+testCasesCount+" </th>"+
                    "<th style=\"width:50%\">"+testCaseName+"</th>" +
                    "<th style=\"width:10%\"><a>"+status+"</a></th>" +
                    "<th style=\"width:10%\"><a href="+filePath+"\\"+"htmlFile.html"+">Report</a></th>" +
                    "<th style=\"width:10%\"><a href="+file+">Logs</a></th>" +
                    "<th style=\"width:10%\">"+new Date()+"</th>" +
                    "</tr>");

        }else if(status.equalsIgnoreCase("Fail")){
            htmlTemplate.append("<table style=\"width:100%\">" +
                    "<tr bgcolor='LightPink' style='color:black'>" +
                    "<th style=\"width:10%\">"+testCasesCount+" </th>"+
                    "<th style=\"width:50%\">"+testCaseName+"</th>" +
                    "<th style=\"width:10%\"><a>"+status+"</a></th>" +
                    "<th style=\"width:10%\"><a href="+filePath+"\\"+"htmlFile.html"+">Report</a></th>" +
                    "<th style=\"width:10%\"><a href="+file+">Logs</a></th>" +
                    "<th style=\"width:10%\">"+new Date()+"</th>" +
                    "</tr>");

        }else{
            htmlTemplate.append("<table style=\"width:100%\">" +
                    "<tr bgcolor='grey' style='color:black'>" +
                    "<th style=\"width:10%\">"+testCasesCount+" </th>"+
                    "<th style=\"width:50%\">"+testCaseName+"</th>" +
                    "<th style=\"width:10%\"><a>"+status+"</a></th>" +
                    "<th style=\"width:10%\"><a href="+filePath+"\\"+"htmlFile.html"+">Report</a></th>" +
                    "<th style=\"width:10%\"><a href="+file+">Logs</a></th>" +
                    "<th style=\"width:10%\">"+new Date()+"</th>" +
                    "</tr>");

        }

    }

    //This method is for individual test case html report generation. Screenshots taken during test runs are appended to html file
    //and this html file will be displayed when tapping on Report link corresponding to the test case
    public static void individualTestCaseReport(String path) throws IOException {
        individualHTMLTemplate.delete(0,individualHTMLTemplate.length());
        File imageDir = new File(path);
        System.out.println("Image directory is"+imageDir);
        for(File file:imageDir.listFiles()){
            String extension = "";

            int i = file.getName().lastIndexOf('.');
            if (i > 0) {

                extension = file.getName().substring(i+1);
            }
            individualHTMLTemplate.append("<html><body>");
            if(extension.equalsIgnoreCase("png")||(extension.equalsIgnoreCase("jpg"))||(extension.equalsIgnoreCase("jpeg"))){
                individualHTMLTemplate.append("<h1><center>"+file.getName().substring(0,file.getName().indexOf('.'))+"</h1>");
                individualHTMLTemplate.append("<center><img src="+file+" alt=\"Problem in displaying test report. Refresh the page.\" width=\"500\" height=\"600\">");
            }
            individualHTMLTemplate.append("</body></html>");
            BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(path+"\\htmlFile.html")));

            //write contents of StringBuffer to a file
            bwr.write(individualHTMLTemplate.toString());
            bwr.flush();

        }

    }


}
