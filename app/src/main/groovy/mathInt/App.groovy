/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package mathInt

class App {

    static void main(String[] args) {
        String Solve = "2 + 4 * 20 - 3"//"55 + 4 *( 2 - 3 ) / 4" //"4*3+2"
        StringBuilder num = new StringBuilder()

        ExpressionTree et = new ExpressionTree()
        et.createTree(Solve)
        et.printTree()
    }
}


class Node {
    public Integer value
    public String type; // will likley change to enum
    public Node left, right;

    Node(Integer value, String type) {
        this.value = value
        this.type = type
    }

}


class ExpressionTree {
    Node Root = null;
    String Solve

    ExpressionTree(String Solve) {
        this.Solve = Solve
    }

    void printTree(){
        BTreePrinter.printNode(Root)
    }

    Node createTree(String Solve) {
        Node root
        if (!Solve.trim().isNumber()) {
            println(Solve)

            int opIndex = splitExp(Solve);
            root = new Node(null, Solve[opIndex])
            if(this.Root == null){
                this.Root = root
            }
            root.left = createTree(Solve.substring(0,opIndex-1))
            root.right = createTree(Solve.substring(opIndex+1,Solve.size()))
        }
        else{
            root = new Node(Solve.trim().toInteger(), "num")
        }
        return root

    }


    int splitExp(String Solve) {
        int finOpPos = 0

        for (int i = 0; i < Solve.length(); i++) {
            if (Solve[i].equals("+") || Solve[i].equals("-")) {
                finOpPos = i


            } else if (Solve[i].equals("*") || Solve[i].equals("/")) {

                if (!Solve[finOpPos].equals("+") && !Solve[finOpPos].equals("-")) {
                    finOpPos = i
                }
            }
        }
        return finOpPos
    }
}



