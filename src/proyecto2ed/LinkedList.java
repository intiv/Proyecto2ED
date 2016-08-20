package proyecto2ed;

public class LinkedList extends ADTList{
    LinkedList() {
        head = null;
        size = 0;
    }

    public int indexOf(TreeNode data) {
        if (data == null||size==0) {
            return -1;
        }
        Node tmp = (Node) head;
        if (tmp.getData() == data) {
            return 0;
        } else {
            int index = 1;
            while ((tmp = (Node) tmp.getNext()) != null) {
                if (tmp.getData() == data) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public TreeNode get(int ind) {
        if (ind < 0 || ind >= size) {
            return null;
        }
        Node tmp = (Node) head;
        for (int i = 0; i < ind; i++) {
            tmp = (Node) tmp.getNext();
        }
        return tmp.getData();
    }

    public boolean insert(TreeNode data,int ind){
        if(ind<0||ind>size)
            return false;
        if(indexOf(data)!=-1)
            return false;
        Node nouveau=new Node(data);
        if(head==null)
            head=nouveau;
        else{
            if(ind==0){
                head.setPrev(nouveau);
                nouveau.setNext(head);
                head=nouveau;
            }else if(ind>0&&ind<size){
                Node tmp=(Node) head;
                for(int i=1;i<ind;i++)
                    tmp=(Node) tmp.getNext();
                nouveau.setPrev(tmp);
                nouveau.setNext(tmp.getNext());
                tmp.getNext().setPrev(nouveau);
                tmp.setNext(nouveau);
            }else{
                Node tmp=(Node) head;
                for (int i = 1; i < ind; i++)
                    tmp=(Node) tmp.getNext();
                tmp.setNext(nouveau);
                nouveau.setPrev(tmp);
            }
        }
        size++;
        return true;
    }
    
    public void reset(){
        int it=this.size;
        for (int i = 0; i < it; i++) {
            this.remove(i);
        }
        size=0;
        head=null;
    }
    
    public boolean remove(int ind){
        if(ind<0||ind>=size){
            return false;
        }
        Node tmp;
        if(ind==0){
            if(size>1){
                tmp=(Node) head.getNext();
                tmp.setPrev(null);
                head.setNext(null);
                head=tmp;
            }else{
                head.setNext(null);
                head=null;
            }
        }else if(ind==size-1){
            tmp=(Node) head;
            for(int i=0;i<ind-1;i++)
                tmp=(Node) tmp.getNext();
            Node delVal=(Node) tmp.getNext();
            tmp.setNext(null);
            delVal.setPrev(null);
        }else{
            tmp=(Node) head;
            for(int i=0;i<ind-1;i++)
                tmp=(Node) tmp.getNext();
            Node delVal=(Node) tmp.getNext();
            tmp.setNext(delVal.getNext());
            delVal.getNext().setPrev(tmp);
            delVal.setNext(null);
            delVal.setPrev(null);
        }
        size--;
        return true;
    }
}
