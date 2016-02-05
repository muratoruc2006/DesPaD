package AST;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import AST.JavaParser.ClassBodyDeclarationContext;
import AST.JavaParser.ClassDeclarationContext;
import AST.JavaParser.CreatedNameContext;
import AST.JavaParser.ExpressionContext;
import AST.JavaParser.FieldDeclarationContext;
import AST.JavaParser.FormalParameterContext;
import AST.JavaParser.GenericMethodDeclarationContext;
import AST.JavaParser.InterfaceDeclarationContext;
import AST.JavaParser.InterfaceMemberDeclarationContext;
import AST.JavaParser.InterfaceMethodDeclarationContext;
import AST.JavaParser.LocalVariableDeclarationContext;
import AST.JavaParser.MethodDeclarationContext;
import AST.JavaParser.TypeDeclarationContext;
import AST.DesignPatternDetection;

/*MyVisitor2 class i MyVisitor class inin buldugu class ve interface leri kullanir. 
 * Boylece internal class lari kullanmamis oluruz.
 * Relations		  : 1. creates_objects_of
 * 						2. overrides_methods_of
 * 						3. calls_method_of
 * 						4. has_the_field_type_of
 * 						5. has_a_method_with_the_return_type_of (related_with_its_method)
 * 						6. has_a_method_that_defines_a_local_variable_with_the_type_of  (related_with_its_method)
 * 						7. has_a_method_that_has_an_input_parameter_with_the_type_of (related_with_its_method)
 * 						8. generic_type_declaration 
 * 						9. has_the_return_type_of */
/*buradaki iliskilerde inner class lari da dahil etmedik, commentli!*/
public class MyVisitor2 extends MyVisitor {
   
   private String  MainClassOrInterface;
   private String  classType;
   private String  CreatedClassName;   
   private String  MethodPattern= "[^=][a-zA-Z]*\\.[a-zA-Z]*\\([a-zA-Z]*\\)";
      
   List<String> SuperClassArray1 = new ArrayList<String>();
   List<String> SuperClassArray2 = new ArrayList<String>();
   
   public void addVertice(Integer id,String name,String type)
   {   
	   if(getTypebyName(name) == ""){
		   d.vertices.add(new Vertices(id,name,type));
		   }     		  
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
   
   public static List<String> modifiers = new ArrayList<String>();
   
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
	
   //Superclass i bulmak icin...
   public Void visitClassDeclaration(ClassDeclarationContext ctx) {    	
   		MainClassOrInterface = ctx.Identifier().toString();   		
   		SuperClassArray1.clear();
   		
   		Integer total_children = ctx.getChildCount();
   		if (!ctx.children.get(0).getText().equals(modifiers))
    	{	 
    		for (int i = 0; i < total_children; i++) {    			
    			if (ctx.children.get(i).getText().equals("extends")){
    				if(!ctx.children.get(i+1).getText().contains(",")){	    				    	
	    				SuperClassArray1.add(ctx.children.get(i+1).getText());
	    		    	}
	    			else if(ctx.children.get(i+1).getText().contains(",")){
						//Virgullerin sayisini buluyoruz.    					
						String[] words = ctx.children.get(i+1).getText().split(",");   
						
						for (String s: words) {
							SuperClassArray1.add(s);
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
	    				SuperClassArray1.add(ctx.children.get(i+1).getText());
	    			}    			
	    			else if(ctx.children.get(i+1).getText().contains(",")){
						//Virgullerin sayisini buluyoruz.    					
						String[] words = ctx.children.get(i+1).getText().split(",");   
						
						for (String s: words) {
							SuperClassArray1.add(s);
						}
	    			}
    			}
    		}
    	}
   		
   		return super.visitClassDeclaration(ctx);
   }
   
   //Superclass i bulmak icin...
   @Override
   public Void visitInterfaceDeclaration(InterfaceDeclarationContext ctx) {      	
	   	MainClassOrInterface = ctx.Identifier().toString();
	   	SuperClassArray2.clear();
	   	
	   	Integer total_children = ctx.getChildCount();
    	
		if (!ctx.children.get(0).getText().equals(modifiers))
    	{	 
			
			for (int i = 0; i < total_children; i++) {
				if (ctx.children.get(i).getText().equals("extends")){    	
					if(!ctx.children.get(i+1).getText().contains(",")){	    			
	    				SuperClassArray2.add(ctx.children.get(i+1).getText());
	    			}				
					else if(ctx.children.get(i+1).getText().contains(",")){
						//Virgullerin sayisini buluyoruz.    					
						String[] words = ctx.children.get(i+1).getText().split(",");   
						
						for (String s: words) {
							SuperClassArray2.add(s);
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
	    				SuperClassArray2.add(ctx.children.get(i+1).getText());
	    			}				
					else if(ctx.children.get(i+1).getText().contains(",")){
						//Virgullerin sayisini buluyoruz.    					
						String[] words = ctx.children.get(i+1).getText().split(",");   
						
						for (String s: words) {
							SuperClassArray2.add(s);
						}
	    			}
				}
			}
    	}
		return super.visitInterfaceDeclaration(ctx);
   }
	   	
	   	   
    //*********************creates_objects_of****************************************************************************
    //*******************************************************************************************************************
    //Class A [creates objects of] Class B.
    @Override
    public Void visitCreatedName(CreatedNameContext ctx) {
    	//System.out.println(MainClassOrInterface + " [creates objects of] " + ctx.getText()); 
    	CreatedClassName=null;
    	CreatedClassName=ctx.getText();
    	
    	if (MainClassOrInterface != null && ctx.getText() != null){
    		d.dugumler.add(new Nodes(MainClassOrInterface,"creates_objects_of",ctx.getText())); //Add the relation to the list.
    	
    	// Class yoksa ekle.(internal)
//		if (DoesClassExists(ctx.getText()) == false){
//			if (getTypebyName(ctx.getText()) != "")
//		    	{classType = getTypebyName(ctx.getText());}
//		    	else
//		    	{classType = "Class";}
//				
//			addVertice(0,ctx.getText(),classType);
//			}
    	}
    	
    	return super.visitCreatedName(ctx);
    }
    //*******************************************************************************************************************
    //*******************************************************************************************************************
     
    
    //**********************overrides_methods_of*************************************************************************
    //**********************has_the_return_type_of*************************************************************************
    //*******************************************************************************************************************
    //Class A [overrides methods of] Class B.
    @Override
    public Void visitClassBodyDeclaration(ClassBodyDeclarationContext ctx) {    	
    	   	
    	if((ctx.getText().contains("@Override") && !(SuperClassArray1.isEmpty())) || (ctx.getText().contains("super") && !(SuperClassArray1.isEmpty())))
    	{    		    		
    		for(String sclass : SuperClassArray1)
    		{
    			//System.out.println(MainClassOrInterface+ " [overrides  methods of] " + SuperClass);
    			if (MainClassOrInterface != null && sclass != null){
    				d.dugumler.add(new Nodes(MainClassOrInterface,"overrides_methods_of",sclass)); //Add the relation to the list.
        		
    	    	// Class yoksa ekle.(internal)
//    			if (DoesClassExists(sclass) == false){
//    				if (getTypebyName(sclass) != "")
//    			    	{classType = getTypebyName(sclass);}
//    			    	else
//    			    	{classType = "Class";}
//    					
//    				addVertice(0,sclass,classType);
//    				}
    			}
    		}
    	}
    	
    	if((ctx.getText().contains("@Override") && !(SuperClassArray2.isEmpty())) || (ctx.getText().contains("super") && !(SuperClassArray2.isEmpty())))
    	{    		    		
    		for(String sclass : SuperClassArray2)
    		{
    			//System.out.println(MainClassOrInterface+ " [overrides  methods of] " + SuperClass);
    			if (MainClassOrInterface != null && sclass != null){
    				d.dugumler.add(new Nodes(MainClassOrInterface,"overrides_methods_of",sclass)); //Add the relation to the list.
    			
    	    	// Class yoksa ekle.(internal)
//    			if (DoesClassExists(sclass) == false){
//    				if (getTypebyName(sclass) != "")
//    			    	{classType = getTypebyName(sclass);}
//    			    	else
//    			    	{classType = "Class";}
//    					
//    				addVertice(0,sclass,classType);
//    				}
    			}
    		}
    	}

    	//Class A [has_the_return_type_of] Class B. Complex relation.Could be better coded.:(
    	for (int k = 0; k < ctx.getChildCount(); k++) {	
    		
	    	if(ctx.children.get(k).getText().contains("return")){

	    		for (int i = 0; i < ctx.children.get(k).getChildCount(); i++) {
	    			
	    			if(ctx.children.get(k).getChild(i).getText().contains("return")){
	    				
	    				for (int j = 0; j < ctx.children.get(k).getChild(i).getChildCount(); j++) {
	    					
	    					if(ctx.children.get(k).getChild(i).getChild(j).getText().contains("return")){
	    						
	    						for (int m = 0; m < ctx.children.get(k).getChild(i).getChild(j).getChildCount(); m++) {
	    	    					
	    	    					if(ctx.children.get(k).getChild(i).getChild(j).getChild(m).getText().contains("return")){
	    												
			    						
					for (int h = 0; h < ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChildCount(); h++) {	
						
						if(ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getText().contains("return")){
						
						for (int g = 0; g < ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChildCount(); g++) {
							
							if(ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChild(g).getText().contains("return")){

							for (int t = 0; t < ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChild(g).getChildCount(); t++) {
								//System.out.println("murat"+ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChild(g).getChild(t).getText());
								if(ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChild(g).getChildCount()>t+1 && ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChild(g).getChild(t).getText().equals("return")){
	
				    				if(ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChild(g).getChild(t+1).getText().contains("new")){
				    					if (MainClassOrInterface != null && ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChild(g).getChild(t+2).getText() != null)
				    	    				d.dugumler.add(new Nodes(MainClassOrInterface,"has_the_return_type_of",ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChild(g).getChild(t+2).getText())); //Add the relation to the list.
				    					
				    	    	    	// Class yoksa ekle.(internal)
//				    	    			if (DoesClassExists(ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChild(g).getChild(t+2).getText()) == false){
//				    	    				if (getTypebyName(ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChild(g).getChild(t+2).getText()) != "")
//				    	    			    	{classType = getTypebyName(ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChild(g).getChild(t+2).getText());}
//				    	    			    	else
//				    	    			    	{classType = "Class";}
//				    	    					
//				    	    				addVertice(0,ctx.children.get(k).getChild(i).getChild(j).getChild(m).getChild(h).getChild(g).getChild(t+2).getText(),classType);
//				    	    				}
				    				}
				    				else {
				    					if (MainClassOrInterface != null && CreatedClassName != null){
				    	    				d.dugumler.add(new Nodes(MainClassOrInterface,"has_the_return_type_of",CreatedClassName)); //Add the relation to the list.    	    		    				
				    	    	    	
				    					// Class yoksa ekle.(internal)
//				    	    			if (DoesClassExists(CreatedClassName) == false){
//				    	    				if (getTypebyName(CreatedClassName) != "")
//				    	    			    	{classType = getTypebyName(CreatedClassName);}
//				    	    			    	else
//				    	    			    	{classType = "Class";}
//				    	    					
//				    	    				addVertice(0,CreatedClassName,classType);
//				    	    				}
				    					}
				    				}
			    				}
							}
						}
	    				
					}
	    	    					}
	    						}
	    					}
	    				}
	    			}
				}
	    	}
	    }
	    	} //if(ctx.children.get(k) 	    	
    	}//for (int k = 0;
    	
    	return super.visitClassBodyDeclaration(ctx);
    }
    //*******************************************************************************************************************
    //*******************************************************************************************************************
    
    //*****************************calls_method_of***********************************************************************
    //*******************************************************************************************************************    
    //Class A [calls_method_of] Class B.
    @Override
    public Void visitExpression(ExpressionContext ctx) {
    		
    	boolean matches = Pattern.matches(MethodPattern, ctx.getText());
    	String name =""; 
    	int dot = -1;
    	
    	if (matches)
    	{
    		Pattern pattern = Pattern.compile(MethodPattern);
    		Matcher matcher = pattern.matcher(ctx.getText());
			
    		dot = ctx.getText().indexOf(".");
    		
    		while(matcher.find()) 
    		{
	    		name = ctx.getText().substring(matcher.start(), dot);
    		}
    		
            //System.out.println(MainClassOrInterface +" [has a method that calls a method of] "+ name );
    		if (MainClassOrInterface != null && name != null){
    			d.dugumler.add(new Nodes(MainClassOrInterface,"calls_method_of",name)); //Add the relation to the list.
    		
				// Class yoksa ekle.(internal)
//    			if (DoesClassExists(name) == false){
//    				if (getTypebyName(name) != "")
//    			    	{classType = getTypebyName(name);}
//    			    	else
//    			    	{classType = "Class";}
//    					
//    				addVertice(0,name,classType);
//    				}
    		}
    		
    		if (getTypebyName(CreatedClassName) != "")
			{
	            //System.out.println(MainClassOrInterface +" [has a method that calls a method of] "+ CreatedClassName );
    			if (MainClassOrInterface != null && CreatedClassName != null){
    				d.dugumler.add(new Nodes(MainClassOrInterface,"calls_method_of",CreatedClassName)); //Add the relation to the list.
    			
    				// Class yoksa ekle.(internal)
//        			if (DoesClassExists(CreatedClassName) == false){
//        				if (getTypebyName(CreatedClassName) != "")
//        			    	{classType = getTypebyName(CreatedClassName);}
//        			    	else
//        			    	{classType = "Class";}
//        					
//        				addVertice(0,CreatedClassName,classType);
//        				}
    			}
	            
	    		CreatedClassName = null;
			}
    	}
     	    	
    	return super.visitExpression(ctx);
    }
    //*******************************************************************************************************************
    //*******************************************************************************************************************  
    
    //***********************has_the_field_type_of***********************************************************************
    //*******************************************************************************************************************
    //Class A [has the field type of] Class B.
    @Override
    public Void visitFieldDeclaration(FieldDeclarationContext ctx) {
    	//System.out.println(MainClassOrInterface + " [has the field type of] " + ctx.type().getText()); //+"__C");    	
    	if (MainClassOrInterface != null && ctx.type().getText() != null){
    		d.dugumler.add(new Nodes(MainClassOrInterface,"has_the_field_type_of",ctx.type().getText())); //Add the relation to the list.
    	
			// Class yoksa ekle.(internal)
//			if (DoesClassExists(ctx.type().getText()) == false){
//				if (getTypebyName(ctx.type().getText()) != "")
//			    	{classType = getTypebyName(ctx.type().getText());}
//			    	else
//			    	{classType = "Class";}
//					
//				addVertice(0,ctx.type().getText(),classType);
//			}
    	}
    	
    	return super.visitFieldDeclaration(ctx);
    }
    //*******************************************************************************************************************
    //*******************************************************************************************************************
    
    
    //**************************related_with_its_method******************************************************************        
    //****************************has_a_method_with_the_return_type_of***************************************************
    //*******************************************************************************************************************
	//Class A [has a method with the return type of] Class B.
    @Override
	public Void visitInterfaceMethodDeclaration(InterfaceMethodDeclarationContext ctx) {
		// void degilse bir return type'i var demektir.
		if (!ctx.children.get(0).getText().equals("void"))
		{
			//Method relation.	
			if (MainClassOrInterface != null && ctx.type().getText() != null){
				d.dugumler.add(new Nodes(MainClassOrInterface,"related_with_its_method",ctx.type().getText())); //Add the relation to the list.
				d.dugumler.add(new Nodes(MainClassOrInterface,"has_a_method_with_the_return_type_of",ctx.type().getText())); //Add the relation to the list.			
			
				// Class yoksa ekle.(internal)
//				if (DoesClassExists(ctx.type().getText()) == false){
//					if (getTypebyName(ctx.type().getText()) != "")
//				    	{classType = getTypebyName(ctx.type().getText());}
//				    	else
//				    	{classType = "Class";}
//						
//					addVertice(0,ctx.type().getText(),classType);
//				}
			}
    	}
		
		return super.visitInterfaceMethodDeclaration(ctx);
    }
    //Fazla olabilir.
    @Override
    public Void visitInterfaceMemberDeclaration(InterfaceMemberDeclarationContext ctx) {
    	//System.out.println(MainClassOrInterface + " [has the field type of] " + ctx.type().getText()); //+"__C");    	
    	if (MainClassOrInterface != null && ctx.children.get(0).getChild(0).getText() != null){
    		if(!ctx.children.get(0).getChild(0).getText().equals("void"))
    			d.dugumler.add(new Nodes(MainClassOrInterface,"has_a_method_with_the_return_type_of",ctx.children.get(0).getChild(0).getText())); //Add the relation to the list.
    	
			// Class yoksa ekle.(internal)
//			if (DoesClassExists(ctx.children.get(0).getChild(0).getText()) == false){
//				if (getTypebyName(ctx.children.get(0).getChild(0).getText()) != "")
//			    	{classType = getTypebyName(ctx.children.get(0).getChild(0).getText());}
//			    	else
//			    	{classType = "Class";}
//					
//				addVertice(0,ctx.children.get(0).getChild(0).getText(),classType);
//			}
    	}
    	
    	return super.visitInterfaceMemberDeclaration(ctx);
    }
    
	@Override
	public Void visitMethodDeclaration(MethodDeclarationContext ctx) {
		
		// void degilse bir return type'i var demektir.
		if (!ctx.children.get(0).getText().equals("void"))
		{
			//Method relation.	
			if (MainClassOrInterface != null && ctx.type().getText() != null){
				d.dugumler.add(new Nodes(MainClassOrInterface,"related_with_its_method",ctx.type().getText())); //Add the relation to the list.
				d.dugumler.add(new Nodes(MainClassOrInterface,"has_a_method_with_the_return_type_of",ctx.type().getText())); //Add the relation to the list.			
			
				// Class yoksa ekle.(internal)
//				if (DoesClassExists(ctx.type().getText()) == false){
//					if (getTypebyName(ctx.type().getText()) != "")
//				    	{classType = getTypebyName(ctx.type().getText());}
//				    	else
//				    	{classType = "Class";}
//						
//					addVertice(0,ctx.type().getText(),classType);
//				}
			}
    	}
		
		//methodlar ayni isimliyse o zaman override method iliskisi vardır demektir.
		for (Nodes nodes : d.methods) {
			if(MainClassOrInterface != null && !nodes.getNode2().equals(MainClassOrInterface)){
				if(nodes.getNode2().equals(ctx.Identifier().getText())){
					if (MainClassOrInterface != null && nodes.getNode1() != null){
						d.dugumler.add(new Nodes(MainClassOrInterface,"overrides_methods_of",nodes.getNode1())); //Add the relation to the list.
						
						// Class yoksa ekle.(internal)
//						if (DoesClassExists(nodes.getNode1()) == false){
//							if (getTypebyName(nodes.getNode1()) != "")
//						    	{classType = getTypebyName(nodes.getNode1());}
//						    	else
//						    	{classType = "Class";}
//								
//							addVertice(0,nodes.getNode1(),classType);
//						}
						
						break;
					}				
				}
			}
		}
		
		return super.visitMethodDeclaration(ctx);
	}	
	//*******************************************************************************************************************
	//*******************************************************************************************************************
	
	//**************************related_with_its_method******************************************************************		
	//************************has_a_method_that_has_an_input_parameter_with_the_type_of**********************************
	//Class A [has a method that has an input parameter with the type of] Class B.
	@Override
	public Void visitFormalParameter(FormalParameterContext ctx) {						
		//System.out.println(MainClassOrInterface+ " [has a method that has an input parameter with the type of] " + ctx.type().getText()); //+"__C");
		if (MainClassOrInterface != null && ctx.type().getText() != null){
			d.dugumler.add(new Nodes(MainClassOrInterface,"related_with_its_method",ctx.type().getText())); //Add the relation to the list.
			d.dugumler.add(new Nodes(MainClassOrInterface,"has_a_method_that_has_an_input_parameter_with_the_type_of",ctx.type().getText())); //Add the relation to the list.
		
			// Class yoksa ekle.(internal)
//			if (DoesClassExists(ctx.type().getText()) == false){
//				if (getTypebyName(ctx.type().getText()) != "")
//			    	{classType = getTypebyName(ctx.type().getText());}
//			    	else
//			    	{classType = "Class";}
//					
//				addVertice(0,ctx.type().getText(),classType);
//			}		
		}
		
		return super.visitFormalParameter(ctx);
	}
	//*******************************************************************************************************************
	//*******************************************************************************************************************	
	
	//**************************related_with_its_method******************************************************************
	//**************************has_a_method_that_defines_a_local_variable_with_the_type_of******************************
	//Class A [has_a_method_that_defines_a_local_variable_with_the_type_of] Class B.
	@Override
	public Void visitLocalVariableDeclaration(LocalVariableDeclarationContext ctx) {
	    //System.out.println(MainClassOrInterface + " [has a method that defines a local variable with the type of] " + ctx.type().getText()); //+"__C");
		if (MainClassOrInterface != null && ctx.type().getText() != null){
			d.dugumler.add(new Nodes(MainClassOrInterface,"related_with_its_method",ctx.type().getText())); //Add the relation to the list.
	    //d.dugumler.add(new Nodes(MainClassOrInterface,"has_a_method_that_defines_a_local_variable_with_the_type_of",ctx.type().getText()));
		
			// Class yoksa ekle.(internal)
//			if (DoesClassExists(ctx.type().getText()) == false){
//				if (getTypebyName(ctx.type().getText()) != "")
//			    	{classType = getTypebyName(ctx.type().getText());}
//			    	else
//			    	{classType = "Class";}
//					
//				addVertice(0,ctx.type().getText(),classType);
//			}
		}
		
		return super.visitLocalVariableDeclaration(ctx);
	}
   	//*******************************************************************************************************************
	//*******************************************************************************************************************	
	
	//**************************generic_type_declaration*****************************************************************
	//*******************************************************************************************************************	
	//Class A [uses ... in a generic type declaration] Class B
	@Override
	public Void visitTypeDeclaration (TypeDeclarationContext ctx) {

	   //If the class uses a generic type
		if (ctx.getChildCount()>1)/*2 Onceden 1 idi bir incele*/
		{ 
		   if (ctx.children.get(1).getChildCount()>2)/*2 �nceden 1 idi bir incele*/
		   {
			  if ((ctx.children.get(1).getChild(2).getChildCount()>2))
			  {
		 		   if (
		 				   (ctx.children.get(1).getChild(2).getChild(0).getText().equals("<")) && 
		 				   (ctx.children.get(1).getChild(2).getChild(1).getText().contains("extends")) &&
		 				   (ctx.children.get(1).getChild(2).getChild(2).getText().equals(">"))
		 			)
		 		  {	 			 
 			 
		 			  if (MainClassOrInterface != null && ctx.children.get(1).getChild(2).getChild(1).getChild(2).getText() != null){
		 				  d.dugumler.add(new Nodes(MainClassOrInterface,"generic_type_declaration",ctx.children.get(1).getChild(2).getChild(1).getChild(2).getText())); //Add the relation to the list.
		 			  
		 					// Class yoksa ekle.(internal)
//		 					if (DoesClassExists(ctx.children.get(1).getChild(2).getChild(1).getChild(2).getText()) == false){
//		 						if (getTypebyName(ctx.children.get(1).getChild(2).getChild(1).getChild(2).getText()) != "")
//		 					    	{classType = getTypebyName(ctx.children.get(1).getChild(2).getChild(1).getChild(2).getText());}
//		 					    	else
//		 					    	{classType = "Class";}
//		 							
//		 						addVertice(0,ctx.children.get(1).getChild(2).getChild(1).getChild(2).getText(),classType);
//		 					}
		 			  }
		 			  
		 		  }
			  }
		   }
		}

	 return super.visitTypeDeclaration(ctx);
	}
   	//*******************************************************************************************************************
	//*******************************************************************************************************************	
}
