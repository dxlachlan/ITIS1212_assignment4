//Daniel L. Campbell
//ITIS1212-001 


import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;
import java.awt.Image;


// resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  public static void main(String[] args) 
  {
    String fileName = FileChooser.pickAFile();
    Picture pictObj = new Picture(fileName);
    pictObj.explore();
  }
  
  
  public void decreaseRedForEach()
  {
    Pixel[] pixelArray = this.getPixels();
    int value = 0;
    
    //loop through all the pixels in the array
    for (Pixel pixelObj : pixelArray)
    {
      //get the red value
      value = pixelObj.getRed();
      
      //decrease the red value by 50% (1/2)
      value = (int)(value * 0.5);
      
      //set the red value of the current pixel to the new value
      pixelObj.setRed(value);
    }
  }
  
  public void decreaseRed()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;
    
    //loop through all the pixels in the array
    while (index < pixelArray.length)
    {
      
      //get the current pixel
      pixel = pixelArray[index];
      
      //get the value 
      value = pixel.getRed();
      
      //decrease the red value by 50% (1/2)
      value = (int)(value*0.5);
      
      //set the red value of the current pixel to the new value
      pixel.setRed(value);
      
      //increment the index
      index = index + 1;
      
    }
  }
  
  /* method to increase the amount of red by 30%
   * 
   */
  public void increaseRed()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;
    
    //loop through all the pixels
    while (index < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[index];
      
      //get the value 
      value = pixel.getRed();
      
      //change the value to 1.3 times of what it was
      value = (int)(value*1.3);
      
      //set the red value to 1.3 times of what it was
      pixel.setRed(value);
      
      //increment the index
      index++;
    }
  }
  
  /* method to clear the blue from the picture (set 
   * the blue to 0 for all pixels
   */
  public void clearBlue()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int index = 0;
    
    //loop through all the pixels
    while (index < pixelArray.length)
    {
      //get the current pixel
      pixel = pixelArray[index];
      
      //set the blue on the pixel to 0
      pixel.setBlue(0);
      
      //increment index
      index++;
    }
  }
  
  
  public void decreaseBlue(double increment)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;
    
    //first if statement If increment < 0.0
    if (increment < 0.0)
    {
      
      System.out.println("Error: Parameter less than zero.");
      return;
      
    }
    //second if statement If increment > 1.0
    if (increment > 1.0)
    {
      System.out.println("Error: Parameter greater than one.");
      return;
      
    }
    
    //loop through all the pixels
    while (index < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[index];
      
      //get the value 
      value = pixel.getBlue();
      
      
      //change the value to 1.3 times of what it was
      value = (int)(value*increment);
      
      //set the red value to 1.3 times of what it was
      pixel.setBlue(value);
      
      //print statement to test if the rest of code is executing
      //System.out.println(value);
      
      
      //increment the index
      index++;
      
    }
  }
  
  
  public void modifyGreen(double increment, double portion)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;
    
    //first if statement If increment < 0.0
    if (increment < 0.0)
    {
      
      System.out.println("Error: Parameter less than zero.");
      return;
      
    }
    //second if statement IfPortion > 1.0
    if (increment > 2.0)
    {
      System.out.println("Error: Parameter greater than one.");
      return;
      
    }
    
    if (portion < 0.0)
    {
      
      System.out.println("Error: Portion less than zero.");
      return;
      
    }
    //second if statement ifPortion > 2.0
    if (portion > 1.0)
    {
      System.out.println("Error: Portion greater than one.");
      return;
      
    }
    
    //loop through all the pixels
    while (index < pixelArray.length*portion)
    {
      // get the current pixel
      pixel = pixelArray[index];
      
      //get the value 
      value = pixel.getGreen();
      
      
      //change the value to 1.3 times of what it was
      value = (int)(value*increment);
      
      //set the red value to 1.3 times of what it was
      pixel.setGreen(value);
      
      //print statement to test if the rest of code is executing
      //System.out.println(value);
      
      
      //increment the index
      index++;
      
    }
  }
  
  public void modifyRed(double increment, double portionOne, double portionTwo)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;
    
    //first if statement If increment < 0.0
    if (increment < 0.0)
    {
      
      System.out.println("Error: Parameter less than zero.");
      return;
      
    }
    //second if statement IfPortion > 2.0
    if (increment > 2.0)
    {
      System.out.println("Error: Parameter greater than two.");
      return;
      
    }
    
    if (portionOne < 0.0)
    {
      
      System.out.println("Error: PortionOne less than zero.");
      return;
      
    }
    //second if statement ifPortion > 1.0
    if (portionOne > 1.0)
    {
      System.out.println("Error: PortionOne greater than one.");
      return;
      
    }
    
    // first if statement ifPortionTwo 
    if (portionTwo < 0.0)
    {
      
      System.out.println("Error: PortionTwo less than zero.");
      return;
      
    }
    //second if statement ifPortionTwo > 1.0
    if (portionTwo > 1.0)
    {
      System.out.println("Error: PortionTwo greater than one.");
      return;
      
    }
    
    // portion error trap
    if (portionOne > portionTwo)
    {
      System.out.println("Error: First portion comes after second portion.");
      return;
      
    }
    
    //loop through all the pixels
    while (index < pixelArray.length*portionTwo)
    {
      // get the current pixel
      pixel = pixelArray[index];
      
      //get the value 
      value = pixel.getRed();
      
      
      //change the value to 1.3 times of what it was
      value = (int)(value*increment);
      
      //set the red value to 1.3 times of what it was
      pixel.setRed(value);
      
      //print statement to test if the rest of code is executing
      //System.out.println(value);
      
      
      //increment the index
      index++;
      
    }
    
    value = 0;
    index = 0;
    
    while (index < (pixelArray.length*portionOne))
    {
      // get the current pixel
      pixel = pixelArray[index];
      
      //get the value 
      value = pixel.getRed();
      
      
      //change the value to 1.3 times of what it was
      value = (int)(value/increment);
      
      //set the red value to 1.3 times of what it was
      pixel.setRed(value);
      
      //print statement to test if the rest of code is executing
      //System.out.println(value);
      
      
      //increment the index
      index++;
      
    }
  }
  
  /**
   * Method to decrease the green in the picture by 30%
   */
  public void decreaseGreen()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    
    //loop through all the pixels in the array
    while (i < pixelArray.length)
    {
      //get the current pixel
      pixel = pixelArray[i];
      
      //get the value
      value = pixel.getGreen();
      
      //set the green value to 70% of what it was 
      pixel.setGreen((int) (value * 0.7));
      
      //increment the index
      i++;
    }
  }
  
  /*
   * method to decrease the blue in the picture by 30%
   */
  public void decreaseBlue()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    
    //loop through all the pixels in the array
    while (i < pixelArray.length)
    {
      //get the current pixel
      pixel = pixelArray[i];
      
      //get the value
      value = pixel.getBlue();
      
      //set the blue value to 70% of original value
      pixel.setBlue((int) (value * 0.7));
    }
  }
  
  /**
   * Method to make a picture look like it was taken at sunset 
   * by reducing the blue and green to make it look more red
   */
  public void makeSunset2()
  {
    decreaseGreen();
    decreaseBlue();
  }
  
  /**
   * Method to change the color of each pixel in the picture
   * object by passed in amounts.
   * @param redAmount the amount ot change the red value
   * @param greenAmount the amount to change the green value
   * @param blueAmount the amount to chang the blue value
   */
  public void changeColors(double redAmount, double greenAmount, double blueAmount)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    
    //loop through all the pixels
    while(i < pixelArray.length)
    {
      //get the current pixel
      pixel = pixelArray[i];
      
      //change the red value
      value = pixel.getRed();
      pixel.setRed((int) (redAmount * value));
      
      //change the green value
      value = pixel.getGreen();
      pixel.setGreen((int) (greenAmount * value));
      
      //change the blue value
      value = pixel.getBlue();
      pixel.setBlue((int) (blueAmount * value));
      
      //increment i
      i++;
    }
  }
  
  
  
  
  /**
   * Method to lighten the colors in the picture
   */
  public void lighten()
  {
    Pixel[] pixelArray = this.getPixels();
    Color color = null;
    Pixel pixel = null;
    //loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      //get the current pixel
      pixel = pixelArray[i];
      //get the current color
      color = pixel.getColor();
      //get a lighter color
      color = color.brighter();
      //set the pixel color to the lighter color
      pixel.setColor(color);
    }
  }
  
  /**
   * Method to negate the picture
   */
  public void negate()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int redValue, blueValue, greenValue = 0;
    
    //loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      //get the current pixel
      pixel = pixelArray[i];
      
      //get the current red, green, and blue values
      redValue = pixel.getRed();
      greenValue = pixel.getGreen();
      blueValue = pixel.getBlue();
      
      //set the pixels color to the new color
      pixel.setColor(new Color(255 - redValue, 255 - greenValue, 255 - blueValue));
    }
    
  }
  
  public void fade()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++) {
      //get the current pixel
      pixel = pixelArray[i];
      
      //get, modify and then set the values
      pixel.setRed((int)(pixel.getRed()*0.8));
      pixel.setGreen((int)(pixel.getGreen()*0.8));
      pixel.setBlue((int)(pixel.getBlue()*0.8));
      
      
      
    }
    
  }
  
  
  
  public void averageWithTarget(Picture target){ 
    //get the pixel arrays for this image and the other image
    Pixel[] pixelArray = this.getPixels();
    Pixel[] targetArray = target.getPixels();
    
    
    //get pixel objects to store each pixel in as we go through the arrays
    Pixel pixel1 = null;
    Pixel pixel2 = null;
    
    
    //temp variables for each color component
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    
    
    
    // test the make sure target picture is the exach same size as this picture
    if (this.getWidth() != target.getWidth() || this.getHeight() != target.getHeight()){
      //target is not the same size, give error and return
      System.out.println("Error! Target image size is not the same as source image.");
      return;
    }
    
    //loop through to get all the pixels for target image
    for (int i = 0; i < targetArray.length; i++)
    {
      //get the current pixel
      pixel2 = pixelArray[i];
      pixel1 = targetArray[i];
      
      //get and average two value arrays and reset to target
      pixel2.setRed((int)((pixel1.getRed()+pixel2.getRed()/2)));
      pixel2.setGreen((int)((pixel1.getGreen()+pixel2.getGreen())/2));
      pixel2.setBlue((int)((pixel1.getBlue()+pixel2.getBlue())/2));
      
    }
  }
  
  //Assignment 3 - 1st Tint Method
  //Tints image green
  public void threeTintOne()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++) {
      //get the current pixel
      pixel = pixelArray[i];
      
      //get, modify and then set the values
      pixel.setRed((int)(pixel.getRed()*0.4));
      pixel.setGreen((int)(pixel.getGreen()*1.5));
      pixel.setBlue((int)(pixel.getBlue()*0.4));
      
      
    }
    
  }
  
  
  //Assignment 3 - 2nd Tint Method
  //Reverses Green Tint and Doubles Red and Blue to Obnoxious Purpleish Tint
  public void threeTintTwo()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++) {
      //get the current pixel
      pixel = pixelArray[i];
      
      //reverse green effect
      pixel.setRed((int)(pixel.getRed()/0.4));
      pixel.setGreen((int)(pixel.getGreen()/1.5));
      pixel.setBlue((int)(pixel.getBlue()/0.4));
      
      //set new tint
      pixel.setRed((int)(pixel.getRed()*2.5));
      pixel.setGreen((int)(pixel.getGreen()*1.0));
      pixel.setBlue((int)(pixel.getBlue()*2.5));
      
      
      
      
    }
    
  }
  
  
  
  
  //Assignment 3 - 3rd Tint Method
  //Reverses Obnoxious Purpleish Tint & Change to Obnoxious Yellow
  public void threeTintThree()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++) {
      //get the current pixel
      pixel = pixelArray[i];
      
      //reverse green effect
      pixel.setRed((int)(pixel.getRed()/2.5));
      pixel.setGreen((int)(pixel.getGreen()*1.0));
      pixel.setBlue((int)(pixel.getBlue()/2.5));
      
      //set new tint
      pixel.setRed((int)(pixel.getRed()*2.5));
      pixel.setGreen((int)(pixel.getGreen()*2.5));
      pixel.setBlue((int)(pixel.getBlue()*1.0)); 
      
    }
    
  }
  
  //Assignment 3 - 3rd Tint Method
  //Reverses Obnoxious Purpleish Tint & Change to Obnoxious Yellow
  public void threeTintFour()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++) {
      //get the current pixel
      pixel = pixelArray[i];
      
      //reverse green effect
      pixel.setRed((int)(pixel.getRed()/2.5));
      pixel.setGreen((int)(pixel.getGreen()/2.5));
      pixel.setBlue((int)(pixel.getBlue()/1.0));
      
    }
    
  }
  
  //Assignment 3 Part 3
  
  public void averagePixelsHorizontally() {
    // To get you started, these are the local variables you will need for this method     
    Pixel[] pixelArray = this.getPixels();     
    Pixel pixel = null;     
    Pixel prev_pixel = null;     
    Pixel next_pixel = null;     
    
    int index = 0;     
    int red;     
    int green;     
    int blue;               
    
    while (index < pixelArray.length) {
      if (index == 0) {
        //special case - first pixel, no prev_pixel to average
        //System.out.println("special case, first pixel");
        
        pixel = pixelArray[index];
        next_pixel = pixelArray[index + 1];
        
        // red pixel averaging          
        red = (pixel.getRed() + next_pixel.getRed())/2;          
        pixel.setRed(red);           
        
        // green pixel averaging          
        green = (pixel.getGreen() + next_pixel.getGreen())/2;          
        pixel.setGreen(green);           
        
        // blue pixel averaging          
        blue = (pixel.getBlue() + next_pixel.getBlue())/2;          
        pixel.setBlue(blue);
        
      } else if (index == pixelArray.length - 1) {
        // special case -  last pixel, no next_pixel to average
        //System.out.println("special case, last pixel");
        
        // standard case  
        prev_pixel = pixelArray[index - 1];
        pixel = pixelArray[index];
        
        // red pixel averaging          
        red = (prev_pixel.getRed() + pixel.getRed())/2;          
        pixel.setRed(red);           
        
        // green pixel averaging          
        green = (prev_pixel.getGreen() + pixel.getGreen())/2;          
        pixel.setGreen(green);           
        
        // blue pixel averaging          
        blue = (prev_pixel.getBlue() + pixel.getBlue())/2;          
        pixel.setBlue(blue);
        
        
        
        // TODO: put code here to average last pixel (index) with second-last pixel (index Ð 1)
      } else {
        
        // standard case  
        prev_pixel = pixelArray[index - 1];
        pixel = pixelArray[index];
        next_pixel = pixelArray[index + 1];
        
        // red pixel averaging          
        red = (prev_pixel.getRed() + pixel.getRed() + next_pixel.getRed())/3;          
        pixel.setRed(red);           
        
        // green pixel averaging          
        green = (prev_pixel.getGreen() + pixel.getGreen() + next_pixel.getGreen())/3;          
        pixel.setGreen(green);           
        
        // blue pixel averaging          
        blue = (prev_pixel.getBlue() + pixel.getBlue() + next_pixel.getBlue())/3;          
        pixel.setBlue(blue);
        
      } // end else
      
      index++;
      
    } // end while
    
  }// end method 
  
  
  //Assignment3Part2
  public void purpStripeTest (int beg, int fin, double increase, double decrease){
    Pixel[] pixelArray = this.getPixels();
    
    int rVal;
    int gVal;
    int bVal;
    
    for ( int i = ((pixelArray.length/8)*beg); i < ((pixelArray.length/8)*fin); i++){
      
      
      Pixel pixel = pixelArray[i];
      
      //get the value
      rVal = pixel.getRed();
      gVal = pixel.getGreen();
      bVal = pixel.getBlue();
      
      //set to purple
      pixel.setBlue((int) (bVal * increase));
      pixel.setRed((int) (rVal * increase));
      pixel.setGreen((int) (gVal * decrease));
      
      
    }
    
  }
  
  
  
  
  public void cyanStripeTest (int beg, int fin, double increase, double decrease){
    Pixel[] pixelArray = this.getPixels();
    
    int rVal;
    int gVal;
    int bVal;
    
    for ( int i = ((pixelArray.length/8)*beg); i < ((pixelArray.length/8)*fin); i++){
      
      
      Pixel pixel = pixelArray[i];
      
      //get the value
      rVal = pixel.getRed();
      gVal = pixel.getGreen();
      bVal = pixel.getBlue();
      
      //set to purple
      pixel.setBlue((int) (bVal * increase));
      pixel.setRed((int) (rVal * decrease));
      pixel.setGreen((int) (gVal * increase));
      
      
    }
    
  }
  
  
  
  public void yellStripeTest (int beg, int fin, double increase, double decrease){
    Pixel[] pixelArray = this.getPixels();
    
    int rVal;
    int gVal;
    int bVal;
    
    for ( int i = ((pixelArray.length/8)*beg); i < ((pixelArray.length/8)*fin); i++){
      
      
      Pixel pixel = pixelArray[i];
      
      //get the value
      rVal = pixel.getRed();
      gVal = pixel.getGreen();
      bVal = pixel.getBlue();
      
      //set to purple
      pixel.setBlue((int) (bVal * decrease));
      pixel.setRed((int) (rVal * increase));
      pixel.setGreen((int) (gVal * increase));
      
      
    }
    
  }
  
  
  
  /* Method to lighten the colors in the picture
   */
  public void lighten2(){
    Color color = null;
    Pixel pixel = null;
    
    //loop through the columns (x direction)
    for (int x = 0; x < getWidth(); x++)
    {
      //loop through the rows (y direction)
      for (int y = 0; y < getHeight(); y++)
      {
        // get the pixel at the x and y location
        pixel = getPixel(x,y);
        
        //get the current color
        color = pixel.getColor();
        
        //get a lighter color
        color = color.brighter();
        
        //set the pixel color to the lighter color
        pixel.setColor(color);
      }
    }
  }
  
  /**
   * Method to mirror around a vertical line in the middle
   * of the picture based on the width
   */
  public void mirrorVertical()
  {
    int width = this.getWidth();
    int mirrorPoint = width / 2;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    //loop through all the rows
    for (int y = 0; y < getHeight(); y++)
    {
      //loop from 0 to the middle (mirror point)
      for (int x = 0; x < mirrorPoint; x++)
      {
        leftPixel = getPixel(x, y);
        rightPixel = getPixel(width - 1 - x, y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /**
   * Method to mirror around a horizontal line in the middle 
   * based on the height. It copies the top mirrored to the bottom
   */
  
  public void mirrorHorizontal()
  { 
    int height = this.getHeight();
    int mirrorPoint = height / 2;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    //loop through the columns
    for (int x = 0; x < getWidth(); x++)
    {
      //loop from 0 to just before the mirror point
      for (int y = 0; y < mirrorPoint; y++)
      {
        topPixel = getPixel(x,y);
        bottomPixel = getPixel(x,height - 1 - y);
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }
  
  
  /*
   * Method to mirror part of the temple picture around a vertical
   * line at a mirror point
   */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    //loop through all the rows
    for (int y = 27; y < 97; y++)
    {
      //loop from 1 to just before the mirror point
      for (int x = 13; x < mirrorPoint; x++)
      {
        leftPixel = getPixel(x, y);
        rightPixel = getPixel(mirrorPoint + (mirrorPoint - x), y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /**
   * Method to copy the picture of katie to the
   * upper left corner of the current picture
   */
  public void copyKatie()
  {
    String sourceFile = FileChooser.pickAFile();
    Picture sourcePicture = new Picture(sourceFile);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    //loop through the columns
    for (int sourceX = 0, targetX = 0; sourceX < sourcePicture.getWidth(); sourceX++, targetX++){
      
      //loop through all the rows
      for (int sourceY = 0, targetY = 0; sourceY < sourcePicture.getHeight(); sourceY++, targetY++){
        
        //set the target pixel color to the source pixel color
        sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
        targetPixel = this.getPixel(targetX, targetY);
        targetPixel.setColor(sourcePixel.getColor());     
      }    
    }   
  }
  
  
  //Method to copy Katies Face
  public void copyKatiesFace(){
    String sourceFile = ("/Users/danielcampbell/Desktop/ITIS_1212/mediasources/KatieFancy.jpg");
    Picture sourcePicture = new Picture(sourceFile);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    //loop through all the columns
    for (int sourceX = 70, targetX = 100; sourceX < 135; sourceX++, targetX++){
      //loop through the rows
      for (int sourceY = 3, targetY = 100; sourceY < 80; sourceY++, targetY++){
        
        //set the target pixel color to the source pixel color
        sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());     
      }
    }   
  }
  
  
  /*
   * Method that will copy all of the passed source picture into
   * the current picture object starting witht he left corner
   * give by xStart. It will put the sourcePicture at 5 pixels
   * from the bottom of this picture
   * @Param sourcePicture the picture object to copy
   * @Param xStart the x position to start the copy in the target
   */
  
  public void copyPictureTo(Picture sourcePicture, int xStart){
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    //looop through the columns
    for (int sourceX = 0, targetX = xStart; sourceX < sourcePicture.getWidth();
         sourceX++, targetX++){
           
           //loop through the rows
           for (int sourceY = 0, 
                targetY = this.getHeight() - sourcePicture.getHeight() - 5;
                sourceY < sourcePicture.getHeight();
                sourceY++, targetY++){
                  
                  sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
                  targetPixel = this.getPixel(targetX, targetY);
                  targetPixel.setColor(sourcePixel.getColor());
                }
         }
  }
  
  /*
   * Method to copy two flowers in a pattern to the bottom
   * (5 pixels from bottom) of the current picture
   */
  public void copyFlowersBetter()
  {
    //create the flower pictures
    Picture flower1Picture =
      new Picture(FileChooser.pickAFile());
    Picture flower2Picture = 
      new Picture(FileChooser.pickAFile());
    
    //copy the first flower picture to near the bottom left corner of the canvas
    this.copyPictureTo(flower1Picture,0);
    
    /*copy the flower2 picture starting with
     * x = 100 in the canvas
     */
    
    this.copyPictureTo(flower2Picture, 100);
    
    //copy the flower1 negated to x = 200 in the cavas
    flower1Picture.negate();
    this.copyPictureTo(flower1Picture, 200);
    
    /* clear the blue in the flower 2 picture
     * and add at x = 300 in the cavas
     */
    flower2Picture.clearBlue();
    this.copyPictureTo(flower2Picture, 300);
    
    //copy the negated flower 1 to x=400
    this.copyPictureTo(flower1Picture, 400);
    
    
  }
  
  
  
  
  /**
   * Method to blend two sisters together onto the current picture
   * 
   */
  
  public void blendPictures()
  {
    //create the sister pictures
    Picture katiePicture = 
      new Picture(FileChooser.pickAFile());
    Picture jennyPicture = 
      new Picture(FileChooser.pickAFile());
    
    //declare the source and target pixel variables
    Pixel katiePixel = null;
    Pixel jennyPixel = null;
    Pixel targetPixel = null;
    
    /* declare the target x and source x since we will need the values after the for loop
     */
    
    int sourceX = 0;
    int targetX = 0;
    
    //copy the first 150 pixels of katie to the canvas
    for (;sourceX < 150; sourceX++, targetX++)
    {
      for (int sourceY=0, targetY=0;
           sourceY < katiePicture.getHeight();
           sourceY++, targetY++)
      {
        katiePixel = katiePicture.getPixel(sourceX, sourceY);
        targetPixel = this.getPixel(targetX, targetY);
        targetPixel.setColor(katiePixel.getColor());
      }
    }
    
    /* 
     * copy 50% of katie and 50% of jenny till
     * the end of katies width
     */
    for(; sourceX<katiePicture.getWidth(); sourceX++, targetX++)
    {
      for (int sourceY=0, targetY=0; sourceY < katiePicture.getHeight();
           sourceY++, targetY++)
      {
        katiePixel = katiePicture.getPixel(sourceX, sourceY);
        jennyPixel = jennyPicture.getPixel(sourceX - 150, sourceY);
        targetPixel = this.getPixel(targetX, targetY);
        targetPixel.setColor(
                             new Color((int) (katiePixel.getRed() * 0.5 +
                                              jennyPixel.getRed() * 0.5),
                                       (int) (katiePixel.getGreen() * 0.5 + 
                                              jennyPixel.getGreen() * 0.5),
                                       (int) (katiePixel.getBlue() * 0.5 + 
                                              jennyPixel.getBlue() * 0.5)));
      }
    }
    
    //copy the rest of jenny
    sourceX = sourceX - 150;
    for (; sourceX < jennyPicture.getWidth(); sourceX++, targetX++)
    {
      for (int sourceY = 0, targetY = 0;
           sourceY < jennyPicture.getHeight();
           sourceY++, targetY++)
      {
        jennyPixel = jennyPicture.getPixel(sourceX, sourceY);
        targetPixel = this.getPixel(targetX, targetY);
        targetPixel.setColor(jennyPixel.getColor());
        
      }
    }
  }
  
  
  //method to copy the picture of katie but rotate her
  // 90 degrees to the left on the current picture
  
  public void copyKatieLeftRotation()
  {
    String sourceFile = FileChooser.pickAFile();
    Picture sourcePicture = new Picture(sourceFile);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    //loop through the columns
    for (int sourceX = 0;
         sourceX < sourcePicture.getWidth();
         sourceX++)
    {
      //loop throught the rows
      for (int sourceY = 0;
           sourceY < sourcePicture.getHeight();
           sourceY++)
      {
        //set the target pixel color to the source pixel color
        sourcePixel = sourcePicture.getPixel(sourceX, sourceY);
        targetPixel = this.getPixel(sourceY, sourcePicture.getWidth() - 1 - sourceX);
        targetPixel.setColor(sourcePixel.getColor());         
        
      }
    } 
  }
  
  
  /**
   * Method to copy a flower but scale to 2x normal size
   * onto the current picture
   */
  
  public void copyFlowerLarger()
  {
    Picture flowerPicture = new Picture(FileChooser.pickAFile());
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    //loop through the columns
    for (double sourceX = 0, targetX = 0;
         sourceX < flowerPicture.getWidth();
         sourceX = sourceX + 0.5, targetX++)
    {
      //loop throught the rows
      for (double sourceY=0, targetY =0;
           sourceX < flowerPicture.getWidth();
           sourceX = sourceX + 0.5, targetX++)
      {
        sourcePixel = 
          flowerPicture.getPixel((int) sourceX, (int) sourceY);
        targetPixel = this.getPixel((int) targetX, (int) targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
  
  
  
  //Same size method
  private boolean isSameSize(Picture source){
    if (source.getWidth() == this.getWidth()){
      if (source.getHeight() == this.getHeight()){
        
        return true;
      }
      
    }
    return false;
  }//end is samesize
  
  
  /* 
   * copy pixel method
   */
  
  private void copyPixel(Picture srcPic, int srcX, int srcY, Picture destPic, int destX, int destY){
    
    //initialize pixels
    Pixel sourcePixel = null;
    Pixel destPixel = null;    
    
    
    
    
    //set the target pixel color to the source pixel color
    sourcePixel = srcPic.getPixel(srcX, srcY);
    destPixel = this.getPixel(destX, destY);
    destPixel.setColor(sourcePixel.getColor());        
  }
  
  public void addPic( Picture newPic, int xPos, int yPos)
  {
    if (newPic.getWidth() > this.getWidth() || newPic.getHeight() > this.getHeight()) {
      System.out.println("Error! The passed in picture is larger than this picture");
      return;
    }
    int newWidth = newPic.getWidth();
    int newHeight = newPic.getHeight();
    for (int x = 0; x<newWidth; x++) {
      for (int y = 0; y < newHeight; y++) {
        if ( ((x+xPos) < getWidth()) && (( y+yPos) < getHeight()))
        {
          
          copyPixel(newPic, x, y, this,x+xPos,y+yPos);
        }
      }
    }
  }
  
  public void crop(int xPos, int yPos, int width, int height)
  {
    for (int x=0; x<this.getWidth();x++){
      for (int y = 0; y< this.getHeight(); y++){
        
        if ( x > xPos+width || x < xPos || y > yPos+height || y < yPos) {
          
          Pixel pixel = null;
          pixel = getPixel(x,y);
          pixel.getRed();
          pixel.setRed(255);
          pixel.getBlue();
          pixel.setBlue(255);
          pixel.getGreen();
          pixel.setGreen(255);
          
        }
      }
    }
  }
  
  
  
  
  /* The target img is the pic object this method is called on. method copies the pixels from the source pict passed in to ...
   */
  
  public void simpleCopyFromSource(Picture source){
    
    //check that both source nad target images are the same size.
    
    if (!this.isSameSize(source)) {
      System.out.println("error! the source and target images are not the same size.");
      return;
      
    }
    
    //iterate through the rows and columns of the source, copying each pixel to the target(this).
    
    for (int x=0; x<this.getWidth();x++){
      for (int y = 0; y< this.getHeight(); y++){
        copyPixel(source, x, y, this, x, y);
        
      }
      
    }
    
  }
  
  
  
  /* 
   * Method to turn the brown in a picture
   * into red
   */
  
  public void turnBrownIntoRed(){
    
    Color brown = new Color(42,25,15);
    Pixel[] pixels = this.getPixels();
    Pixel pixel = null;
    
    //loop through the pixels
    for (int i=0; i<pixels.length; i++)
    {
      //get the current pixel
      pixel = pixels[i];
      
      //check if in distance to brown and if so double the red
      if (pixel.colorDistance(brown) < 50.0)
        pixel.setColor(new Color((int)(pixel.getRed()*2.0), pixel.getGreen(), pixel.getBlue()));
      
      
    }
    
  }
  
  
  public void turnBrownIntoRedInRectangle(){
    Color brown = new Color(42,25,15);
    Pixel pixel = null;
    
    //loop through the x values
    for (int x=63; x<125; x++)
    {
      for (int y=6; y<76; y++)
      {
        //get the current pixel
        pixel = this.getPixel(x,y);
        
        //check if in dist to brown and if so double the red
        
        if (pixel.colorDistance(brown) < 50.0)
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                   pixel.getGreen(),
                                   pixel.getBlue()));
        
        
      }
      
    }
    
  }
  
  //Program 35 from the book
  //Color Replacement with passing in the range
  
  public void turnBrownToRedInRectangle(int startX, int endX,
                                        int startY, int endY,
                                        double distance)
  {
    Color brown = new Color(42,25,15);
    Pixel pixel = null;
    
    //loop through the x values
    for (int x=startX; x < endX; x++)
    {
      for (int y=startY; y < endY; y++)
      {
        
        //get the current pixel
        pixel = this.getPixel(x,y);
        
        /*
         * Check if in distance to brown is less than
         * the passed distance and if so double the red
         */
        
        if (pixel.colorDistance(brown) < distance)
          pixel.setColor(new Color((int) (pixel.getRed()*2.0),
                                   pixel.getGreen(),
                                   pixel.getBlue()));      
      }
      
    }
    
  }
  
  //Program 36: Remove Red Eye
  
  public void removeRedEye(int startX, int startY, int endX, int endY, Color newColor)
  {
    Pixel pixel = null;
    /* loop through the pixels in the rectangel defined by the startX, startY, and endX and endY 
     */
    for(int x = startX; x < endX; x++)
    {
      for(int y = startY; y < endY; y++)
      {
        pixel = getPixel(x,y);
        
        //if the color is near red then change it
        if (pixel.colorDistance(Color.red) < 167)
          pixel.setColor(newColor);       
      }   
    }
  }
  
  //program 37: edge detection
  
  public void edgeDetection(double amount){
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    double topAverage = 0.0;
    double bottomAverage = 0.0;
    int endY = this.getHeight() - 1;
    /* loop through y values from 0 to height - 1
     * (since compare to below pixels) */
    for (int y = 0; y < endY; y++){
      // loop through the x values from 0 to width
      for (int x = 0; x < this.getWidth(); x++){
        
        //get the top and bottom pixels
        topPixel = this.getPixel(x,y);
        bottomPixel = this.getPixel(x,y+1);
        
        //get the color averages for the two pixels
        topAverage = topPixel.getAverage();
        bottomAverage = bottomPixel.getAverage();
        
        /* check if the absolute value of the difference
         * is less than the amount */
        if (Math.abs(topAverage - bottomAverage) < amount){
          topPixel.setColor(Color.WHITE);
          
          //else set the color to black
        } else {
          topPixel.setColor(Color.BLACK);
        }
      }
    }
  }
  
  
  //Program 39
  //Posterizing a Picture
  
  public void posterize(){
    Pixel pixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    
    //loop through all the pixels
    for (int x = 0; x < this.getWidth(); x++){
      for (int y = 0; y < this.getHeight(); y++){
        
        //get the current pixel and colors
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();
        
        //check for red range and change color
        if (redValue < 64)
          redValue = 31;
        else if (redValue < 128)
          redValue = 95;
        else if (redValue < 192)
          redValue = 159;
        else
          redValue = 223;
        
        //check for green range
        if (greenValue < 64)
          greenValue = 31;
        else if (greenValue < 128)
          greenValue = 95;
        else if (greenValue < 192)
          greenValue = 159;
        else
          greenValue = 223;
        
        //check for blue range
        if (blueValue < 64)
          blueValue = 31;
        else if (blueValue < 128)
          blueValue = 95;
        else if (blueValue < 192)
          blueValue = 159;
        else
          blueValue = 223;
        
        //set the colors
        pixel.setRed(redValue);
        pixel.setGreen(greenValue);
        pixel.getBlue(blueValue);
        
        
      }
      
      
    }
    
    
  }
  // Program 40 : Posterize By Levels
  
  public void posterize(int numLevels)
  {
    Pixel pixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int increment = (int)(256.0 / numLevels);
    int bottomValue, topValue, middleValue = 0;
    
    //loop through the pixels
    for (int x = 0; x < this.getWidth(); x++){
      for (int y = 0; y < this.getHeight(); y++){
        
        //get the current pixel and colors
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();
        
        //loop through the number of levels
        for (int i = 0; i < numLevels; i++)
        {
          //compute the bottom, top, and middle values
          bottomValue = i * increment;
          topValue = (i + 1) * increment;
          middleValue = (int) ((bottomValue + topValue - 1) / 2.0);
          
          /* check if current values are in current range and
           * if so set them to the middle values
           */
          if (bottomValue <= redValue &&
              redValue < topValue)
            pixel.setRed(middleValue);
          if (bottomValue <= greenValue &&
              greenValue < topValue)
            pixel.setGreen(middleValue);
          if (bottomValue <= blueValue &&
              blueValue < topValue)
            pixel.setBlue(middleValue);
        }
      }
    }
  }
  
  
  
  
  //Program 41: Highlight Extremes   
  public void highLightAndDark(double amount, Color replacementColor){
    Pixel pixel = null;
    
    //loop through all the pixel in the x direction 
    for (int x = 0; x < getWidth(); x++){
      
      //loop through all the pixel in the Y direction 
      for (int y = 0; y < getHeight(); y++){
        
        /// get the current pixel 
        pixel = getPixel(x,y);
        
        /// if the distance from white and black is less 
        // than the passed amount use the replace color instead
        if (pixel.colorDistance(Color.white) < amount || 
            pixel.colorDistance(Color.black) < amount) {
          pixel.setColor(replacementColor);
        }
      }
    }
  }
  
  
//Program 42: A Simple Blur
  public void blur(int numPixels)
  {
    Pixel pixel = null;
    Pixel samplePixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int count = 0;
    
    // loop through the pixels
    for (int x = 0; x < this.getWidth(); x++) {
      for (int y=0; y < this.getHeight(); y++) {
        
        //get the current pixel
        pixel = this.getPixel(x,y);
        
        //reset the count and red, green, and blues 
        count = 0;
        redValue = greenValue = blueValue = 0;
        
        /** loop through pixel numpixel before x 
          * to numPixels after x
          * */
        for (int xSample = x - numPixels;
             xSample <= x + numPixels;
             xSample++){
               for (int ySample = y - numPixels;
                    ySample <= y + numPixels;
                    ySample++){
                      ///Check that we are in the range of acceptable pixels
                      if (xSample >= 0 && xSample < this.getWidth() &&
                          ySample >= 0 && ySample < this.getHeight()){
                        samplePixel = this.getPixel(xSample, ySample);
                        redValue = redValue + samplePixel.getRed();
                        greenValue = greenValue + samplePixel.getGreen();
                        blueValue = blueValue + samplePixel.getBlue();
                        count = count + 1;
                      }
                    }
             }
             // use average color of surrounding pixls
             Color newColor = new Color(redValue / count,
                                        greenValue /count,
                                        blueValue /count);
             pixel.setColor(newColor);
      }
    }
  }
  
  //Program 43: Subtract the background and replace it with a new one
  public void swapBackground(Picture oldBackground, Picture newBackground)
  {
    Pixel currPixel = null;
    Pixel oldPixel = null;
    Pixel newPixel = null;
    
    // loop through the columns 
    for (int x=0; x<getWidth(); x++)
    {
      
      //loop through the rows 
      for (int y=0; y<getHeight(); y++)
      {
        /// get the current pixel and old Pixel and old bakground pixel
        currPixel = this.getPixel(x,y);
        oldPixel = oldBackground.getPixel(x,y);
        /**
         * if the distance between the current pixel color
         * and the old background pixel color is less
         * than the 15 than swamp in the few background pixels.
         * */
        if (currPixel.colorDistance(oldPixel.getColor()) < 15.0)
        {
          newPixel = newBackground.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  //Program 44: Better Swap Background
  public void swapBackground(Picture oldBackground,
                             Picture newBackground,
                             double threshold)
  {
    Pixel currPixel = null;
    Pixel oldPixel = null;
    Pixel newPixel = null;
    
    //// loop through the columns 
    for (int x=0; x<getWidth(); x++)
    {
      
      //loop through the rows 
      for (int y=0; y<getHeight(); y++)
      {
        /// get the current pixel and old Pixel and old bakground pixel
        currPixel = this.getPixel(x,y);
        oldPixel = oldBackground.getPixel(x,y);
        
        /**
         * if the distance between the current pixel color
         * and the old background pixel color is less
         * than the 15 than swamp in the few background pixels.
         * */
        if (currPixel.colorDistance(oldPixel.getColor())
              < threshold)
          
        {
          newPixel = newBackground.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  //Program 45: Chromakey: Replace all blue with the new background
  public void chromakey(Picture newBg)
  {
    Pixel currPixel = null;
    Pixel newPixel = null;
    
    //loop through the columns 
    for (int x=0; x<getWidth(); x++)
    {
      
      ///loop through rows 
      for (int y=0; y<getHeight(); y++)
      {
        //get the current pixel 
        currPixel = this.getPixel(x,y);
        
        /** 
         * if the current pixel is mostly blue
         * (blue value is greater than red and green 
         * combined), then use new background color
         * */
        if ( currPixel.getRed() + currPixel.getGreen() < currPixel.getBlue())
        {
          newPixel = newBg.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  //Progrm 46: Chromakey, Shorter
  public void chromakeyBlue(Picture newBg)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel currPixel = null;
    Pixel newPixel = null;
    
    //loop through the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      //get the current pixel
      currPixel = pixelArray[i];
      
      /** 
       * if the current pixel is mostly blue
       * (blue value is greater than red and green 
       * combined), then use new background color
       * */
      if ( currPixel.getRed() + currPixel.getGreen() < currPixel.getBlue())
      {
        newPixel = newBg.getPixel(currPixel.getX(),
                                  currPixel.getY());
        currPixel.setColor(newPixel.getColor());
      }
    }
  }
  
  public void blurArea(int startX,int startY, int endX, int endY, int level) {
    //Conditional check to verify points exist and do not conflict
    if (!(((startX<= endX && startX >= 0) && endX < this.getWidth()) && 
          ((startY <= endY && startY >= 0) && endY < this.getHeight()))){
      System.out.println("Input error, incorrect points.");
      return;
    }
    
    //Main loop to blackout the image
    for(int x = startX; x <= endX; x++){
      for(int y = startY; y <= endY; y++){
        blurPixel(x,y,level);
      }
    }
  }
  
  /*
   * Colorful Edge Detection
   */
  
  public void colorfulEdgeDetection(double amount, double level){
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    double topAverage = 0.0;
    double bottomAverage = 0.0;
    int endY = this.getHeight() - 1;
    
    /* 
     * loop through the y-values from 0 to height - 1
     * (since compare to below pixel) */
    for (int y = 0; y < endY; y++){
      
      //loop through the x values from 0 to width
      for (int x = 0; x < this.getWidth(); x++){
        
        //get the top and bottom pixels
        topPixel = this.getPixel(x,y);
        bottomPixel = this.getPixel(x, y+1);
        
        //get the color averages for the two pixels
        topAverage = topPixel.getAverage();
        bottomAverage = bottomPixel.getAverage();
        
        /*
         * check if the absolute value of the difference is less than the amount
         */
        
        if ((Math.abs(topAverage - bottomAverage) < amount) && ( topAverage > level) )
          topPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void verticalShutters(){
    Pixel pixel = null;
    int shutterSpace = 10;
    
    for (int y = 0; y < getHeight(); y++){
      
      for (int x=0; x < getWidth(); x++){
        
        if ((x/shutterSpace)%2 == 0){
          pixel = getPixel(x,y);
          pixel.setColor(new Color(0,0,0));
        }
        
      }
    }
  }
  
  public void horizontalShutters(){
    Pixel pixel = null;
    int shutterSpace = 10;
    
    for (int y = 0; y < getHeight(); y++){
      
      for (int x=0; x < getWidth(); x++){
        
        if ((y/shutterSpace)%2 == 0){
          pixel = getPixel(x,y);
          pixel.setColor(new Color(0,0,0));
        } 
        else
        {
          //make pixels brighter
          pixel = getPixel(x,y);
          pixel.setColor(pixel.getColor().brighter());
        }
      }
    }
  }
  
  public void checkerboard()
  {
    horizontalShutters();
    verticalShutters(); }
  
  //Fades a picture by 20%
  public void fadeNum(int num){
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++){
      //get the current pixel
      pixel = pixelArray[i];
      
      // get, modify and then set the values
      pixel.setRed((int)(pixel.getRed()*0.8));
      pixel.setGreen((int)(pixel.getGreen()*0.8));
      pixel.setBlue((int)(pixel.getBlue()*0.8));
    } 
  }
  
  /*
   * Blurs the passed in (x,y) pixel by averaging the colors of the surrounding pixels
   * size is how far out to go, so if size is 2, we will blur based on two columns to the
   * left, two to the right, two rows above and two below, in a square
   */
  private void blurPixel(int x, int y, int size) {
    Pixel tempPixel = null;
    Pixel pixel = null;
    
    int sumR = 0;
    int sumG = 0;
    int sumB = 0;
    int divisor = 0;
    
    //iterate over the size x size pixels in this area to add up the RGBs
    for (int subx = x-size; subx < x+size + 1; subx++) {
      for (int suby = y-size; suby < y+size + 1; suby++) {
        //check if this pixel is in the range of this image
        if (((subx >= 0 && subx < this.getWidth()) && (suby >= 0 && suby < this.getWidth()))){
          //in range, so get this pixel, add it's colors to the running average
          tempPixel = this.getPixel(subx, suby);
          sumR += tempPixel.getRed();
          sumG += tempPixel.getGreen();
          sumB += tempPixel.getBlue();
          // increase divisor
          divisor += 1;
        }
      }
    }
    // done adding up all the colors from surrounding pixels so
    // get this pixel and then set it's color to the average RGBs
    // making sure to divide by the divisor (num colors added in)
    pixel = this.getPixel(x,y);
    pixel.setRed((int) (sumR/divisor));
    pixel.setGreen((int) (sumG/divisor));
    pixel.setBlue((int) (sumB/divisor));
  }
  
  
  public void crop(int xPos, int yPos, int width, int height, Picture newPic)
  {
    if ( width <= newPic.getWidth() && height <= newPic.getHeight()){
      
      for (int x=0; x<this.getWidth();x++){
        for (int y = 0; y< this.getHeight(); y++){
          
          if ( x < xPos+width && x > xPos && y < yPos+height && y > yPos) {
            
            if (x+xPos < newPic.getWidth() && y + yPos < newPic.getHeight()){
              
              copyPixel(newPic, width, height , this,xPos,yPos);
              
            }
          }
        }
      }
    }
  }
  
  
  public void scaleDown(){
    Picture img = new Picture(FileChooser.pickAFile());
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    //lloop through the columns
    for (int sourceX = 0, targetX = 0;
         sourceX < img.getWidth();
         sourceX+=2, targetX++)
    {
      //loop through the rows
      for (int sourceY=0, targetY=0;
           sourceY < img.getHeight();
           sourceY+=2, targetY++)
      {
        sourcePixel = img.getPixel(sourceX, sourceY);
        targetPixel = this.getPixel(targetX, targetY);
        targetPixel.setColor(sourcePixel.getColor());
        
        
        
        
        
      }
    }
  }
  
  //Copies pixels from one image, the parameter, to another, the object
  public void copyPixelsFromTarget(Picture target){
    //get pixel arrays for this image and the other image
    Pixel[] pixelArray = this.getPixels();
    Pixel[] targetArray = target.getPixels();
    
    //get pixel objects to store each pixel in as we go through the arrays
    Pixel pixel1 = null;
    Pixel pixel2 = null;
    
    //temp variables for each color component
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    
    //test to make sure that the target picture is the exact same size as this picture
    if (this.getWidth() != target.getWidth() || this.getHeight() != target.getHeight()) {
      //target is not the same size, give error and return
      System.out.println("Error! Target image size is not the same as source image.");
      return;
    }
    
    for (int i=0; i < targetArray.length; i++){
      pixel1 = targetArray[i];
      pixel2 = pixelArray[i];
      
      redValue = pixel1.getRed();
      greenValue = pixel1.getGreen();
      blueValue = pixel1.getBlue();
      
      pixel2.setColor(new Color(redValue, greenValue, blueValue));
    }
  }
  
  //Blacks out specified region
  public void blackOut(int startX,int startY,int endX,int endY) {
    Pixel pixel = null;
    
    //Conditional check to verify points exist and do not conflict
    if (!(((startX<= endX && startX >= 0) && endX < this.getWidth()) && 
          ((startY <= endY && startY >= 0) && endY < this.getHeight()))){
      System.out.println("Input error, incorrect points.");
      return;
    }
    
    //Main loop to blackout the image
    for(int x = startX; x <= endX; x++){
      for(int y = startY; y <= endY; y++){
        pixel = getPixel(x,y);
        pixel.setColor(Color.black);
      }
    }
  }
  
  
  /**************************************************
    * Assignment 4 Methods - 11/10/14
    *************************************************/
  
    
  
  public Picture shrink(int factor)
  {
    Picture img = new Picture(this);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    if(factor == 2 || factor == 3 || factor ==4){
      
      //move through the columns
      for (int sourceX= 0, targetX=0;
           sourceX < img.getWidth();
           sourceX+=factor, targetX++)
      {
        //move through the rows
        for (int sourceY=0, targetY=0;
             sourceY < img.getHeight();
             sourceY+=factor, targetY++)
        {
          sourcePixel = this.getPixel(sourceX, sourceY);
          targetPixel = img.getPixel(targetX, targetY);
          targetPixel.setColor(sourcePixel.getColor());
        }
      }
      
    } else {
      
      System.out.println("Error: Invalid Factor Parameter!");
      
    }
    
    
    /* prep to return
     * the modified image
     * refactored by the 
     * appropriate amount
     */
    
    //check the bounds
    //get the width of the img object, adjusted by the factored amount
    int w =  img.getWidth()/factor;
    System.out.println(w);
    
    //get the height of the 
    int h = img.getHeight()/factor;
    System.out.println(h);
    
    Picture finaliza = new Picture(w, h);
    finaliza.copyPicture(img);
    return finaliza;
  }
  
  
  
  public void reveal(Picture underPic, double division_height){
    
    Pixel pixel = null;
    
    if (!this.isSameSize(underPic)) {
      System.out.println("Error!: Images are not the same size!");
      return;
      
    } else {
      
      //check the percentage passed in as division_height
      if(division_height >= 0.0 && division_height <= 1.0){
        
        //Follows the changes in the division_height parameter to move the divLine
        int divLine = (int)((this.getHeight()) * (division_height));
        
        /*
         * If division_height is a valid parameter than
         * execute the code block below this comment
         */
        
        //Loop through the Rows
        for(int w = 0; w < this.getWidth(); w++)
        {
          //Loop through the Columns
          for (int h = 0; h < divLine + 1; h++)
          {
            /*
             * Alter Pixels to Set divLine marker color
             */
            
            //if on the divLine
            if (h == divLine)
            {
              //set pixels on divLine to black
              pixel = this.getPixel(w,h);
              pixel.setColor(new Color(0,0,0));
              
            } else {
              
              //at current location copy run copyPixel method
              copyPixel(underPic,w,h,this,w,h);
              
            }
          }
        }
        
        
      } else {
        //If division_height is invalid - Print Error and Return
        System.out.println("ERROR! : Invalid Division Height");
        return;
      }  
    }
  }
  
  
  //Assignment4 - Part 3
  public void checkerboard(int width, Color color){
    //initialize pixel variable
    Pixel pixel = null;
    
    /*
     * Check the width precondition
     * if it is less than 1/2 the image width run
     * else - print error statement and return
     *
     */
    
    if(width < this.getWidth()/2){
      
      //move across the rows & columns
      for (int w = 0; w < getWidth(); w++)
        for (int h = 0; h < getHeight(); h++)
      {
        //at current (x,y)pos get pixel
        pixel = this.getPixel(w,h);
        
        //Even Aggregate - Check Location
        if ((w/width)%2 == 0 && (h/width)%2 == 0){
          
          //set pixel color in even rows
          pixel.setColor(color);
        }
        
        //Odd Aggregate - Check Location
        else if ((w/width)%2 != 0 && (h/width)%2 != 0){
          
          //set pixels in odd rows
          pixel.setColor(color);
        }
      }
    } else {
      
      //If the width parameter is too large - print this statement
      System.out.println("Error!: Width parameter is distastefully large! \nEnter a Width parameter less than half the image size!"); 
    }
  }
  
  //Assignment 4 - Part 4 (Alpha Checkerboard)
  public void checkerboard(int width, int alpha){
    //initialize pixel variable
    Pixel pixel = null;
    
    /*
     * Check the alpha parameter
     * parameter range is 0 ~ 255
     *
     */
    
    if(alpha >= 0 && alpha <= 255){
      
      /*
       * Check the width precondition
       * if it is less than 1/2 the image width run
       * else - print error statement and return
       *
       */
      
      if(width < this.getWidth()/2){
        
        //move across the rows & columns
        for (int w = 0; w < getWidth(); w++)
          for (int h = 0; h < getHeight(); h++)
        {
          //at current (x,y)pos get pixel
          pixel = this.getPixel(w,h);
          
          //Even Aggregate - Check Location
          if ((w/width)%2 == 0 && (h/width)%2 == 0){
            
            //set pixel color in even rows
            pixel.setAlpha(alpha);
          }
          
          //Odd Aggregate - Check Location
          else if ((w/width)%2 != 0 && (h/width)%2 != 0){
            
            //set pixels in odd rows
            pixel.setAlpha(alpha);
          }
        }
      } else {
        
        //If the width parameter is too large - print this statement
        System.out.println("Error!: Width parameter is distastefully large! \nEnter a Width parameter less than half the image size!"); 
      }
      
    } else {
      
      System.out.println("Error!: Alpha parameter is outside of the acceptable range!");
      
    }
  }
  
  
  public void checkerboard(int width, Picture pic){
    
      
      //initialize variables
      Pixel pixel = null;
      Pixel pixel2 = null;
      int rVal = 0;
      int gVal = 0;
      int bVal = 0;
    
    
    /*
     * Check to see if the images are the same size
     */
    
    if (!this.isSameSize(pic)) {
      System.out.println("Error!: Images are not the same size!");
      return;
      
    } else {
    
      
      //move across horizontally
      for (int w = 0; w < getWidth(); w++)
      {
        //move across vertically
        for (int h = 0; h < getHeight(); h++)
        {
          //check the odd&even aggregates
          if (((w/width)%2 == 0 && (h/width)%2 == 0) || 
              ((w/width)%2 == 1 && (h/width)%2 == 1))
          {
            //get current pixel location
            pixel = pic.getPixel(w,h);
            
            //get pixel values
            rVal = pixel.getRed();
            gVal = pixel.getGreen();
            bVal = pixel.getBlue();
            
            //assign new values
            pixel2 = this.getPixel(w,h);
            pixel2.setRed(rVal);
            pixel2.setGreen(gVal);
            pixel2.setBlue(bVal);
            
          }
        }
      } 
    }    
  }
}

//End Assignment 4




// this is the end of class Picture, put all new methods before this
