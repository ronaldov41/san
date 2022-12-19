
package com.mycompany.ooad;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


    //Creating Interfaces for my software  
interface Starter{

void WellCome();

}
//Login Interface
interface LoginInfo {

void Login();
void UserHello();
}
//Interface for adding Movies and prices for display the cvs File;
interface MovieInfo {
void AddMovieCSV();


}




class  before_EirVid implements Starter{
String A;float price;int vote_count;
String B,Name;
    
    @Override
public void WellCome(){
System.out.println("Hello budy!!!!, WellCome to -----EirVId_______");
}

}



class EirVid extends before_EirVid implements LoginInfo{
  Scanner S=new Scanner(System.in);
  
    @Override
public void Login(){

    System.out.println("\\\\\\ Process of Creating Account.:)");
System.out.println("Your Email/Username: ");
A=S.nextLine();
System.out.println("Password:");
B=S.nextLine();
}
public void Searching(String i){
 Name=i;   
Random search=new Random();
int a=search.nextInt(2)+1;
      switch (a) {
          case 1:
              price=7.99f;
              vote_count=search.nextInt(8000)+1;
              System.out.println("Your searched movie is= "+Name+"Vote= "+vote_count+"price= "+price);
              break;
          case 2:
              price=6.99f;
              vote_count=search.nextInt(7000)+1;
              System.out.println("Your searched movie is= "+Name+"Vote= "+vote_count+"price= "+price);
              break;
          case 3:
              price=7.99f;
              vote_count=search.nextInt(4000)+1;
              System.out.println("Your searched movie is= "+Name+"Vote= "+vote_count+"price= "+price);
              break;
          default:
              System.out.println("Not found");
              break;
      }
}
  @Override
  public void UserHello()
{
System.out.println("Hey "+this.A+"\n here is the movies and pickup Your Fvrt Movie from Down below.......");
}
}




class AddMovies extends EirVid implements   MovieInfo {
    //After User You Should use Your own file path here..
  String file="D:\\Integrated CA Dataset-20221216\\Integrated CA Dataset-20221216\\New folder\\MoviesDetails.csv";
  BufferedReader reader=null;
     String line="";
    
@Override
public void AddMovieCSV()
{
    //using try catcher for file finding path
      try {
          //I use bufferedreader axcept scanner because it is more efficient
          reader =new BufferedReader(new FileReader(file));
          try {
              while((line=reader.readLine())!=null)
              {
                 
                String [] values=line.split(",");
                //System.out.println("original_language= "+values[0]+",  +title= "+values[7]+",  price"+values[10]);
                 for(String index :values){
               System.out.printf("%-10s",index);
               }
                System.out.println();
              } 
          } catch (IOException ex) {
              ex.printStackTrace();
          }
      
          
      } 
      
      catch (FileNotFoundException e) {
          e.printStackTrace();
      }

}

public void outputMovies()
{
System.out.println("Recommend to users the 5 most rented movies of the past 5 minutes is following:::");
System.out.println("1-Forrest Gump , Vote: 6589 , Price: 7.99 ");
System.out.println("2-The Lion King , Vote: 5789 , Price: 7.99 ");
System.out.println("3-The Shawshank Redemption , Vote: 5150 , Price: 6.99 ");
System.out.println("4-The Silence of the Lambs , Vote: 4600 , Price: 7.99 ");
System.out.println("5-The Godfather , Vote: 4165 , Price: 6.99 ");

}

}
class Payment extends AddMovies
{
    
public void Pay()
{
    Scanner s=new Scanner(System.in);
System.out.println("You want rent a movie then press '1' and not for '0 or other keys':::");
int a=s.nextInt();
if(a==1){
System.out.println("You pay= "+price+" for this Movie::"+Name);
System.out.println("Thanks for payment us...............");
}
else
{
System.out.println("Tnanks for visting our software...");
}


}

}









public class OOAd {
    public static Scanner Finder; 
     public static void readRecord(String SearchingMovie,String filepath)
    {
        boolean found=false;
        //String Movie_Name="";String vote_Count="";String price="";
String original_title="";
String overview="";
String popularity="";
String release_date="";
String runtime="";
String tagline="";
String title="";
String vote_average="";
String vote_count="";
String price="";
    try 
    {
    Finder=new Scanner(new File(filepath));
    Finder.useDelimiter("[,\n]");
    while(Finder.hasNext() && !found)
    {
 original_title=Finder.next();
                              
overview=Finder.next();
popularity=Finder.next();
release_date=Finder.next();
runtime=Finder.next();
tagline=Finder.next();
title=Finder.next();  
vote_average=Finder.next();
vote_count=Finder.next();
price=Finder.next();    
    //Movie_Name=Finder.next();
    //vote_Count=Finder.next("vote_count");
    //price=Finder.next(price);
    if( !original_title.equals(SearchingMovie))
    {
    } else {
        found=true;
        }
    }
    if(found)
   {
  // System.out.println("Movie Name= "+original_title+"Vote= "+vote_count+"Price= "+price);
   System.out.println("original_title"+original_title+ "vote: "+vote_count+"Price"+price);
   }
    else{
    System.out.println("Record is not found");
     
    }
    }
    catch(FileNotFoundException e)
    {
    e.printStackTrace();
    }
    }

    public static void main(String[] args) {
        Payment A=new Payment();
        A.WellCome();
       
        A.Login();
        A.UserHello();
        A.AddMovieCSV();
        A.outputMovies();
        Scanner s=new Scanner(System.in);
        String Filepath="D:\\MoviesDetails.csv";
 System.out.println("//////Enter the name of the movie which you want to rent\\\\\\\\\\");
 String NameOfMovie=s.nextLine();
  A.Searching(NameOfMovie);
  A.Pay();
 
       
    }
   
}
