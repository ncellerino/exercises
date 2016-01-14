package codility.lesson99;

public class TreeHeight {

    public static void main(String[] args) {
       // Tree tree33 = new Tree(33, null, null);
        Tree tree20 = new Tree(20, null, null);
        Tree tree21 = new Tree(21, null, null);
        Tree tree1 = new Tree(1, null, null);
        Tree tree10 = new Tree(10, tree1, null);
        Tree tree3 = new Tree(3, tree20, tree21);
        
        Tree tree = new Tree(5, tree3, tree10);
        System.out.println(new TreeHeight().solution(tree));
    }

    public int solution(Tree T) {
        if (T == null) {
             return -1;
         }
         if (T.l == null && T.r == null) {
             return 0;
         }

         return Math.max(getHeight(T.l, 0), getHeight(T.r, 0));
     }

     // recursively get the height of the binary tree
     public int height(Tree t) {
         // tree t is empty
         if (t == null)
             return -1;
         // get the maximum of the height of the left tree and the right tree,
         // and return the value plus 1 because of counting the current node.
         else
             return Math.max(height(t.l) + 1, height(t.r) + 1);
     }
     
     private int getHeight(Tree t, Integer level) {
         if (t.l == null && t.r == null) {
             return 1;
         } else {
             level++;
             if (t.l == null) {
                 level = level + getHeight(t.r, level);
             } else if (t.r == null) {
                 level = level + getHeight(t.l, level);
             }else{
                 level = Math.max(getHeight(t.l, level), getHeight(t.r, level));    
             }           
             return level;
         }
     }
     
     class Tree {
         public int x;
         public Tree l;
         public Tree r;
       }
}


