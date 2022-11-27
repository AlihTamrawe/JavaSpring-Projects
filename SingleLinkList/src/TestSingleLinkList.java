import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSingleLinkList {
	
	
	public SingleLinkList sList ;   
       
       //Add nodes to the list    
     

	@BeforeEach
	void setUp() throws Exception {
		sList= new SingleLinkList(); 
		
//	       sList.addNode(2);    
//	       sList.addNode(3);    
//	       sList.addNode(4);    
	           
	} 

	@Test
	void testforinsert() {
		     
		  assertEquals(sList.addNode(1),1);

	}
	@Test
	void testNotNull() {
        assertNotNull(sList, "good");
		
		     

	}
	 @Test
	    public void testHeadForNull() {
		 assertNull(sList.head, "");
	 }
	    
	    @Test
	    public void testHeadForNode() {
	    	sList.addNode(8);
	         
			 assertNotNull(sList.head, "");

	    }
	    
	    @Test
	    public void testHeadNextVal() {
	    	sList.addNode(5);
	    	sList.addNode(10);
	    	
//	    	assertTrue((sList.head.data==10),"true");
	    }
	    
	    @Test
	    public void testHeadAfterRemove() {
	    	sList.addNode(10);
	        sList.removeFront();
	        assertNull(sList.head,"");
	    }

}
