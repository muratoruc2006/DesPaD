package AST;


public class Vertices {    

	private Integer id;
    private String verticeName;
    private String type;
    
    public Vertices(Integer id_,String verticeName_,String type_) {   
    	this.id = id_;
        this.verticeName = verticeName_;
        this.type = type_;
    }
      
    public void setName(String s) {
		this.verticeName= s;
	}
    
    public String getName() {
		return verticeName;
	}
    
    public String getType() {
		return type;
	}
    
    public void SetId(Integer id__) {
    	this.id = id__;
	}
    
    public Integer getId() {
		return id;
	}
    
    
    
}
