package AST;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import AST.JavaParser.ClassDeclarationContext;
import AST.JavaParser.InterfaceDeclarationContext;
import AST.JavaParser.MethodDeclarationContext;
import AST.DesignPatternDetection;

/*MyVisitor class i temel inheritance iliskileri olan sadece extends ve implements iliskilerini bulur. */
/*extends ve implements iliskilerinde inner class lari da dahil ettik, önemli!*/
public class MyVisitor extends MyVisitorBase {
    
   AST.DesignPatternDetection d = new DesignPatternDetection();
   private String  MainClassOrInterface;
   //private String  isAbstract;
   private String  classType; 
   public String includeInnerClasses;
   
   
    
   public static List<String> modifiers = new ArrayList<String>();
   
   public String getTypebyName(String name) {    	
	 	   
	 	   @SuppressWarnings("rawtypes")
	 	   Iterator iterator = d.vertices.iterator();
	 	   String type="";
	        while (iterator.hasNext())
	        {
	            Vertices o = (Vertices) iterator.next();
	            if(o.getName().equals(name)) 
		           {
		        	  type = o.getType();
		           }
	            
	        }
	        return type;
	   }
   
   public Boolean DoesClassExists(String name) {    	
	   Boolean b =false;
	   if (includeInnerClasses !=null && includeInnerClasses.equals("Yes")){	   
	 	   @SuppressWarnings("rawtypes")
	 	   Iterator iterator = d.vertices.iterator();
	 	   b=false;
	 	   while (iterator.hasNext())
	        {
	            Vertices o = (Vertices) iterator.next();
	            if((o != null && o.getName().equals(name) && name.length() >2) 
	            		|| (o != null && name.contains(",")) 
	            		|| (o != null && name.contains(">"))
	            		|| (o != null && name.contains("<"))
	            		|| (o != null && name.contains("!"))
	            		|| (o != null && name.contains(";"))) 
		           {
		        	  b = true;
		           }
	            
	        }	 	  
	 	}
	   else b = true;

	 	   return b;
	   }
	
   public void modifiersSet() {
	    modifiers.clear();
		modifiers.add(new String("public"));
		modifiers.add(new String("private"));
		modifiers.add(new String("static"));
		modifiers.add(new String("native"));
		modifiers.add(new String("abstract"));
		modifiers.add(new String("transient"));
		modifiers.add(new String("protected"));
		modifiers.add(new String("final"));
		modifiers.add(new String("synchronized"));
		modifiers.add(new String("threadsafe"));
  }
   
    //********1**********[extends]****************************************************************************************
    //********1**********[implements]*************************************************************************************
    //Class A [extends] Class B.
    //Class A [implements] Interface A.
    @Override
    public Void visitClassDeclaration(ClassDeclarationContext ctx) {    	
    	classType="Class";
    	MainClassOrInterface = ctx.Identifier().toString();
    	
    	Integer total_children = ctx.getChildCount();
		
    	//If the [extends] or [implements] block occurs... Without modifier name...
    	if (!ctx.children.get(0).getText().equals(modifiers))
    	{	 
    		for (int i = 0; i < total_children; i++) {
    			
    			if (ctx.children.get(i).getText().equals("extends")){
    				if(!ctx.children.get(i+1).getText().contains(",")){
	    				//System.out.println(MainClassOrInterface + " [" + ctx.children.get(i) + "] " +  ctx.children.get(i+1).getText());	    	
	    		    	//SuperClass = ctx.children.get(i+1).getText();	  
    					if (MainClassOrInterface != null)
    						d.dugumler.add(new Nodes(MainClassOrInterface,"extends",ctx.children.get(i+1).getText())); // Add the relation to the list.	    		    	
	    		    	
	    		    	// Class yoksa ekle.(internal)
						if (DoesClassExists(ctx.children.get(i+1).getText()) == false){
							if (getTypebyName(ctx.children.get(i+1).getText()) != "")
	    	    		    	{classType = getTypebyName(ctx.children.get(i+1).getText());}
	    	    		    	else
	    	    		    	{classType = "Class";}
								
							addVertice(0,ctx.children.get(i+1).getText(),classType);
							}
				    	
    				}
    				else if(ctx.children.get(i+1).getText().contains(",")){
    					//Virgullerin sayisini buluyoruz.    					
    					String[] words = ctx.children.get(i+1).getText().split(",");   
    					
    					for (String s: words) {
    						if (MainClassOrInterface != null && s != null)
    							d.dugumler.add(new Nodes(MainClassOrInterface,"extends",s)); // Add the relation to the list.
    					
    						// Class yoksa ekle.
    						if (DoesClassExists(s) == false){
    							if (getTypebyName(s) != "")
    	    	    		    	{classType = getTypebyName(s);}
    	    	    		    	else
    	    	    		    	{classType = "Class";}
    								
    							addVertice(0,s,classType);
    							}
    						
    					}
    				}
    			}
    			
    			if (ctx.children.get(i).getText().equals("implements")){
    				if(!ctx.children.get(i+1).getText().contains(",")){
	    				//System.out.println(MainClassOrInterface + " [" + ctx.children.get(i) + "] " +  ctx.children.get(i+1).getText());	    	
	    		    	//SuperClass = ctx.children.get(i+1).getText();	  
    					if (MainClassOrInterface != null && ctx.children.get(i+1).getText() != null)
    						d.dugumler.add(new Nodes(MainClassOrInterface,"implements",ctx.children.get(i+1).getText())); // Add the relation to the list.
	    		    	
	    		    	// Class yoksa ekle.
						if (DoesClassExists(ctx.children.get(i+1).getText()) == false){
							if (getTypebyName(ctx.children.get(i+1).getText()) != "")
	    	    		    	{classType = getTypebyName(ctx.children.get(i+1).getText());}
	    	    		    	else
	    	    		    	{classType = "Interface";}
								
							addVertice(0,ctx.children.get(i+1).getText(),classType);
							}
	    		    	
    				}
    				else if(ctx.children.get(i+1).getText().contains(",")){
    					//Virgullerin sayisini buluyoruz.     					
    					String[] words = ctx.children.get(i+1).getText().split(",");   
    					
    					for (String s: words) {
    						if (MainClassOrInterface != null && s != null)
    							d.dugumler.add(new Nodes(MainClassOrInterface,"implements",s)); // Add the relation to the list.
    						
    						// Class yoksa ekle.
    						if (DoesClassExists(s) == false){
    							if (getTypebyName(s) != "")
    	    	    		    	{classType = getTypebyName(s);}
    	    	    		    	else
    	    	    		    	{classType = "Interface";}
    								
    							addVertice(0,s,classType);
    							}
    					}
    				}
    			}
    		}    		
    	
    	}//if (!ctx.children.get(0).getText().equals(modifiers))
    	
    	//If the [extends] or [implements] block occurs... With modifier name...
    	else if (ctx.children.get(0).getText().equals(modifiers))
    	{
    		
    		for (int i = 0; i < total_children; i++) {
    			
    			if (ctx.children.get(i).getText().equals("extends")){
    				if(!ctx.children.get(i+1).getText().contains(",")){
	    				//System.out.println(MainClassOrInterface + " [" + ctx.children.get(i) + "] " +  ctx.children.get(i+1).getText());	    	
				    	//SuperClass = ctx.children.get(i+1).getText();	  
    					if (MainClassOrInterface != null && ctx.children.get(i+1).getText() != null)
    						d.dugumler.add(new Nodes(MainClassOrInterface,"extends",ctx.children.get(i+1).getText())); // Add the relation to the list.
				    	
				    	// Class yoksa ekle.
						if (DoesClassExists(ctx.children.get(i+1).getText()) == false){
							if (getTypebyName(ctx.children.get(i+1).getText()) != "")
	    	    		    	{classType = getTypebyName(ctx.children.get(i+1).getText());}
	    	    		    	else
	    	    		    	{classType = "Class";}
								
							addVertice(0,ctx.children.get(i+1).getText(),classType);
							}
						
    				}
    				else if(ctx.children.get(i+1).getText().contains(",")){
    					//Virgullerin sayisini buluyoruz.     					
    					String[] words = ctx.children.get(i+1).getText().split(",");   
    					
    					for (String s: words) {
    						if (MainClassOrInterface != null && s != null)
    							d.dugumler.add(new Nodes(MainClassOrInterface,"extends",s)); // Add the relation to the list.
    						
    						// Class yoksa ekle.
    						if (DoesClassExists(s) == false){
    							if (getTypebyName(s) != "")
    	    	    		    	{classType = getTypebyName(s);}
    	    	    		    	else
    	    	    		    	{classType = "Class";}
    								
    							addVertice(0,s,classType);
    							}
    						
    					}
    				}
    				
    			}
    			
    			if (ctx.children.get(i).getText().equals("implements")){
    				//System.out.println(MainClassOrInterface + " [" + ctx.children.get(i) + "] " +  ctx.children.get(i+1).getText());	    	
			    	//SuperClass = ctx.children.get(i+1).getText();	  
    				if(!ctx.children.get(i+1).getText().contains(",")){
    					if (MainClassOrInterface != null && ctx.children.get(i+1).getText() != null)
    						d.dugumler.add(new Nodes(MainClassOrInterface,"implements",ctx.children.get(i+1).getText()));
    					
    					// Class yoksa ekle.
						if (DoesClassExists(ctx.children.get(i+1).getText()) == false){
							classType = "Interface";
								
							addVertice(0,ctx.children.get(i+1).getText(),classType);
							}

    			    	} // Add the relation to the list.
    				else if(ctx.children.get(i+1).getText().contains(",")){
    					//Virgullerin sayisini buluyoruz.    					
    					String[] words = ctx.children.get(i+1).getText().split(",");   
    					
    					for (String s: words) {           
    						if (MainClassOrInterface != null && s != null)
    							d.dugumler.add(new Nodes(MainClassOrInterface,"implements",s));
    						
    						// Class yoksa ekle.
    						if (DoesClassExists(s) == false){
    							classType = "Interface";
    								
    							addVertice(0,s,classType);
    							}   
    					}    				
    				}    				
    			}
    		}
    	}    		    	

    	return super.visitClassDeclaration(ctx);
    }
    //********1***********************************************************************************************************
    //********1***********************************************************************************************************
    
    
    //********2**********[extends]****************************************************************************************
    //********2***********************************************************************************************************
    //Interface A [extends] Interface B.
    @Override
    public Void visitInterfaceDeclaration(InterfaceDeclarationContext ctx) {      	
    	MainClassOrInterface = ctx.Identifier().toString();
    	classType = "Interface";
    		
    	Integer total_children = ctx.getChildCount();
    	
		if (!ctx.children.get(0).getText().equals(modifiers))
    	{	 
			
			for (int i = 0; i < total_children; i++) {
    			
    			if (ctx.children.get(i).getText().equals("extends")){
    				if(!ctx.children.get(i+1).getText().contains(",")){
	    				//System.out.println(MainClassOrInterface + " [" + ctx.children.get(i) + "] " +  ctx.children.get(i+1).getText());	    	
				    	//SuperClass = ctx.children.get(i+1).getText();	  
    					if (MainClassOrInterface != null && ctx.children.get(i+1).getText() != null)
    						d.dugumler.add(new Nodes(MainClassOrInterface,"extends",ctx.children.get(i+1).getText())); // Add the relation to the list.
				    	
				    	// Class yoksa ekle.
						if (DoesClassExists(ctx.children.get(i+1).getText()) == false){
							if (getTypebyName(ctx.children.get(i+1).getText()) != "")
	    	    		    	{classType = getTypebyName(ctx.children.get(i+1).getText());}
	    	    		    	else
	    	    		    	{classType = "Interface";}
								
							addVertice(0,ctx.children.get(i+1).getText(),classType);
							}
						
    				}
    				else if(ctx.children.get(i+1).getText().contains(",")){
    					//Virgullerin sayisini buluyoruz.    					
    					String[] words = ctx.children.get(i+1).getText().split(",");   
    					
    					for (String s: words) {
    						if (MainClassOrInterface != null && s != null)
    							d.dugumler.add(new Nodes(MainClassOrInterface,"extends",s)); // Add the relation to the list.
    						
    						// Class yoksa ekle.
    						if (DoesClassExists(s) == false){
    							if (getTypebyName(s) != "")
    	    	    		    	{classType = getTypebyName(s);}
    	    	    		    	else
    	    	    		    	{classType = "Interface";}
    								
    							addVertice(0,s,classType);
    							}
    						
    					}
    				}
    			}
    			
    			if (ctx.children.get(i).getText().equals("implements")){
    				if(!ctx.children.get(i+1).getText().contains(",")){
	    				//System.out.println(MainClassOrInterface + " [" + ctx.children.get(i) + "] " +  ctx.children.get(i+1).getText());	    	
				    	//SuperClass = ctx.children.get(i+1).getText();	  
    					if (MainClassOrInterface != null && ctx.children.get(i+1).getText() != null)
    						d.dugumler.add(new Nodes(MainClassOrInterface,"implements",ctx.children.get(i+1).getText())); // Add the relation to the list.
				    	
				    	// Class yoksa ekle.
						if (DoesClassExists(ctx.children.get(i+1).getText()) == false){
							if (getTypebyName(ctx.children.get(i+1).getText()) != "")
	    	    		    	{classType = getTypebyName(ctx.children.get(i+1).getText());}
	    	    		    	else
	    	    		    	{classType = "Class";}
								
							addVertice(0,ctx.children.get(i+1).getText(),classType);
							}
						
    				}
    				else if(ctx.children.get(i+1).getText().contains(",")){
    					//Virgullerin sayisini buluyoruz.    					
    					String[] words = ctx.children.get(i+1).getText().split(",");   
    					
    					for (String s: words) {
    						if (MainClassOrInterface != null && s != null)
    							d.dugumler.add(new Nodes(MainClassOrInterface,"implements",s)); // Add the relation to the list.
    						
    						// Class yoksa ekle.
    						if (DoesClassExists(s) == false){
    							if (getTypebyName(s) != "")
    	    	    		    	{classType = getTypebyName(s);}
    	    	    		    	else
    	    	    		    	{classType = "Class";}
    								
    							addVertice(0,s,classType);
    							}
    					}
    				}
    			}
    		}
    	}
			

		else if (ctx.children.get(0).getText().equals(modifiers))
    	{
			
			for (int i = 0; i < total_children; i++) {
    			
    			if (ctx.children.get(i).getText().equals("extends")){
    				if(!ctx.children.get(i+1).getText().contains(",")){
	    				//System.out.println(MainClassOrInterface + " [" + ctx.children.get(i) + "] " +  ctx.children.get(i+1).getText());	    	
				    	//SuperClass = ctx.children.get(i+1).getText();	  
    					if (MainClassOrInterface != null && ctx.children.get(i+1).getText() != null)
    						d.dugumler.add(new Nodes(MainClassOrInterface,"extends",ctx.children.get(i+1).getText())); // Add the relation to the list.
//
//				    	// Class yoksa ekle.
						if (DoesClassExists(ctx.children.get(i+1).getText()) == false){
							if (getTypebyName(ctx.children.get(i+1).getText()) != "")
	    	    		    	{classType = getTypebyName(ctx.children.get(i+1).getText());}
	    	    		    	else
	    	    		    	{classType = "Interface";}
								
							addVertice(0,ctx.children.get(i+1).getText(),classType);
							}
    				}
    				else if(ctx.children.get(i+1).getText().contains(",")){
    					//Virgullerin sayisini buluyoruz.    					
    					String[] words = ctx.children.get(i+1).getText().split(",");   
    					
    					for (String s: words) {
    						if (MainClassOrInterface != null && s != null)
    							d.dugumler.add(new Nodes(MainClassOrInterface,"extends",s)); // Add the relation to the list.
//
//    						// Class yoksa ekle.
    						if (DoesClassExists(s) == false){
    							if (getTypebyName(s) != "")
    	    	    		    	{classType = getTypebyName(s);}
    	    	    		    	else
    	    	    		    	{classType = "Interface";}
    								
    							addVertice(0,s,classType);
    							}
    					}
    				}
    			}
    			
    			if (ctx.children.get(i).getText().equals("implements")){
    				if(!ctx.children.get(i+1).getText().contains(",")){
	    				//System.out.println(MainClassOrInterface + " [" + ctx.children.get(i) + "] " +  ctx.children.get(i+1).getText());	    	
				    	//SuperClass = ctx.children.get(i+1).getText();	  
    					if (MainClassOrInterface != null && ctx.children.get(i+1).getText() != null)
    						d.dugumler.add(new Nodes(MainClassOrInterface,"implements",ctx.children.get(i+1).getText())); // Add the relation to the list.
				    	
				    	// Class yoksa ekle.
						if (DoesClassExists(ctx.children.get(i+1).getText()) == false){
							if (getTypebyName(ctx.children.get(i+1).getText()) != "")
	    	    		    	{classType = getTypebyName(ctx.children.get(i+1).getText());}
	    	    		    	else
	    	    		    	{classType = "Class";}
								
							addVertice(0,ctx.children.get(i+1).getText(),classType);
							}
    				
    				}
    				else if(ctx.children.get(i+1).getText().contains(",")){
    					//Virgullerin sayisini buluyoruz.    					
    					String[] words = ctx.children.get(i+1).getText().split(",");   
    					
    					for (String s: words) {
    						if (MainClassOrInterface != null && s != null)
    							d.dugumler.add(new Nodes(MainClassOrInterface,"implements",s)); // Add the relation to the list.
    						
    						// Class yoksa ekle.
    						if (DoesClassExists(s) == false){
    							if (getTypebyName(s) != "")
    	    	    		    	{classType = getTypebyName(s);}
    	    	    		    	else
    	    	    		    	{classType = "Class";}
    								
    							addVertice(0,s,classType);
    							}
    					}
    				}
    			}
    		}
		
    	}
    	
    	return super.visitInterfaceDeclaration(ctx);
    }      
    //********2*********************************************************************************************************   
    //********2*********************************************************************************************************
    
    
    @Override
	public Void visitMethodDeclaration(MethodDeclarationContext ctx) {
		
		//Method relation.	
		if (MainClassOrInterface != null && ctx.Identifier().getText() != null)
			d.methods.add(new Nodes(MainClassOrInterface,"",ctx.Identifier().getText())); //Add the relation to the list.

		return super.visitMethodDeclaration(ctx);
	}	
    
}
