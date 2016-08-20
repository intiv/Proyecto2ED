package proyecto2ed;

public abstract class ADTList {
    protected class Node{
        protected Node next,prev;
        protected TreeNode data;
        
        Node(){
            next=prev=null;
            data=null;

        }
        
        Node(TreeNode data){
            this.data=data;
            next=prev=null;

        }
        
        public TreeNode getData(){
            return this.data;
        }
        
        
        
        public Node getNext(){
            return next;
        }
        
        public Node getPrev(){
            return prev;
        }
        
        public void setData(TreeNode data){
            this.data=data;
        }
        

        
        public void setNext(Node next){
            this.next=next;
        }
        
        public void setPrev(Node prev){
            this.prev=prev;
        } 
    }
    
    protected int size;
    protected Node head;
    
    ADTList(){
        head=null;
        size=0;
    }
    
    public int length(){
        return size;
    }
}
