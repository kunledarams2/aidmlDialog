# aidmlDialog
### What is this repository for? 
A library that show dialog contain current time and date when click on floating action button

### How do I get set up? ###
1. Add the JitPack repository to your build file 


   Add it in your root build.gradle at the end of repositories:
   
    
        allprojects {
   
		       repositories {
    
		    	...
		   	maven { url 'https://jitpack.io' }
       
	       	}
    
	     }
  
  
2.Add the dependency


    dependencies  {
   
	        implementation 'com.github.kunledarams2:aidmlDialog:1.0.5'
          
          }
  
3. Make sure the layout parent of your activity/fragment is ConstraintLayout

4. In the onCreate() method add:

        Installation(this).initInstallation(frame)
 
 where is the id of your ConstraintLayout
 

 
