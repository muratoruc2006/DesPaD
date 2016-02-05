package AST;

public class Nodes {
    private String node_1;
    private String relation;
    private String node_2;

    public Nodes(String node_1, String relation, String node_2) {
        this.node_1 = node_1;
        this.relation = relation;
        this.node_2 = node_2;
    }
    
    public String toString() {
    	return this.node_1 +" -> " + this.node_2;
         }
    
    public String getNode1(){
    	return this.node_1;
    }
    
    public String getNode2(){
    	return this.node_2;
    }
    
    public String getRelation(){
    	return this.relation;
    }   
    
//    public void removeNodes(){
//    	
//    }
//    
//    public void removeNode2(){
//    	this.node_2 = null;
//    }
//    
//    public void removeRelation(){
//    	this.relation = null;
//    }  

    
}
