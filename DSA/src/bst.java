import java.util.LinkedList;
import java.util.Queue;

class bst {
     public int size = 0;
     public node root;

     class node {
         int data;
         node left, right;

         public node(int item) {
             data = item;
             left = right = null;
         }
     }

     public bst() {
         this.root = null;
         size = 0;
     }

     boolean isEmpty(node root) {
         if (root == null)
             return true;
         return false;
     }

     public node insert(node root, int key) {

         if (root == null)
             return new node(key);

         if (root.data == key)
             return root;

         if (key < root.data)
             root.left = insert(root.left, key);
         else
             root.right = insert(root.right, key);
         return root;
     }

     public void insert(int item) {
         root = insert(root, item);
         size++;
     }

     int cnt = 0, maxi = -10;

     public void inorder(node root) {
         if (root == null) {
             return;
         }
         inorder(root.left);
         System.out.print(root.data+' ');
         inorder(root.right);
     }
     void  preorder(node root) {
         if(root==null){
             return;
         }
        System.out.println(root.data);
         preorder(root.left);
         preorder(root.right);
     }

     public void postorder(node root) {
         if (root == null) {
             return;
         }
         postorder(root.left);
         postorder(root.right);
         System.out.print(root.data + " ");
     }

     public boolean search(node root, int item) {
         if (root == null) {
             return false;
         } else if (root.data == item) {
             return true;
         } else if (item > root.data) {
             search(root.right, item);
         } else search(root.left, item);
         return false;
     }

     node findMin(node r) {
         if (r == null) {
             return null;
         } else if (r.left == null) {
             return r;
         } else {
             return findMin(r.left);
         }
     }

     node findMax(node r) {
         if (r == null) {
             return null;
         } else if (r.right == null) {
             return r;
         } else {
             return findMax(r.right);
         }
     }

     node remove(node r, int key) {
         if (r == null) {
             return r;
         }

         if (key < r.data)
             r.left = remove(r.left, key);
         else if (key > r.data)
             r.right = remove(r.right, key);
         else {
             if (r.left == null && r.right == null) // leaf node
             {
                 r = null;
             } else if (r.left != null && r.right == null) // one child on the left
             {
                 r.data = r.left.data;
                 r.left = null;
             } else if (r.left == null && r.right != null) // one child on the left
             {
                 r.data = r.right.data;
                 r.right = null;
             } else {
                 node max = findMax(r.left);
                 r.data = max.data;
                 r.left = remove(r.left, max.data);
             }
         }
         size--;
         return r;
     }

     int getSize() {
         return size;
     }

    public int bfs(node root) {
         Queue<node> queue = new LinkedList<>();
         if (root != null) {
             queue.add(root);
         }
         int level=0;
         while (!queue.isEmpty()) {
             int levelLength = queue.size();
             System.out.print("Level "+level+": ");
             for (int i = 0; i < levelLength; i++)
             {
                 node curr = queue.remove();
                 System.out.print(curr.data + " ");
                 if (curr.left != null) {
                     queue.add(curr.left);
                 }
                 if (curr.right != null) {
                     queue.add(curr.right);
                 }
             }
             System.out.println();
             level++;
         }
         return level;
     }



 }