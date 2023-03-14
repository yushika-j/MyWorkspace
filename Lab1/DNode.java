public class DNode {
        private Object element;
        private DNode next;
        private DNode previous;

        public DNode() { this(null, null, null); }
          DNode(Object e, DNode n, DNode p) {
          element = e;
          next = n;
          previous = p;
        }
        public void setElement(Object newElem) { element = newElem; }
        public void setNext(DNode node2Add) { next = node2Add; }
        public Object getElement() { return element; }
        public DNode getNext() { return next; }
        public DNode getPrevious() { return previous; }
        public void setPrevious(Object object) {
        }

      
}
