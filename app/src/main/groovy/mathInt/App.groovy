/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package mathInt

class App {
    static void addNumToIstack(StringBuilder num, ArrayList<objectStore> istack) {
        if (num.length() > 0) {
            istack.add(new objectStore(num.toInteger(), "num"));
            num.setLength(0)
        }
    }
    static void findOpPosition(StringBuilder num, ArrayList<objectStore> istack){
        //PE MDAS
        Integer number = num.toInteger();
        for(int i=istack.size(); i>=0; i--) {
            if(istack[i]){ // if our operation equals the thing were looing at then add it to the array next

            }

        }
    }

    static void main(String[] args) {
        String Solve = "2 + 4 * 20"//"55 + 4 *( 2 - 3 ) / 4" //"4*3+2"
        StringBuilder num = new StringBuilder()
//        int parenths = 0
        int[] nextopindex = 0;

        ArrayList<objectStore> istack = new ArrayList<objectStore>(10)
        //creating of stack
        for (int i = 0; i < Solve.length(); i++) {
            if (Solve[i].equals("+")) {
                addNumToIstack(num, istack)
                findOpPosition();
                //find correct position in list to add operation
                //add that operation then
                // we move on to see what is next (it should be a number)
                istack.add(new objectStore(null, "+"))
            } else if (Solve[i].equals("-")) {
                addNumToIstack(num, istack)
                istack.add(new objectStore(null, "-"))
            } else if (Solve[i].equals("*")) {
                addNumToIstack(num, istack)
                istack.add(new objectStore(null, "*"))
            } else if (Solve[i].equals("/")) {
                addNumToIstack(num, istack)

                istack.add(new objectStore(null, "/"))
            }

//            else if (Solve[i].equals("(")) {
//                addNumToIstack(num, istack)
////                parenths++; // count the parents to see how deep we are. higher the num deeper we are
//                // store start index in the array
//                istack.add(new objectStore(null, "("))
//            }
//            else if (Solve[i].equals(")")) {
//                addNumToIstack(num, istack)
//                istack.add(new objectStore(null, ")"))
//            }

            else if (!Solve[i].equals(" ")) {
                num.append(Solve[i])

            }
            if(i == Solve.length()-1){
                addNumToIstack(num, istack)
            }

            for (ob in istack) {
                println(ob.value.toString() + " " + ob.type.toString())
            }
            println()
        }
        // stack sorting
        ArrayList<objectStore> sortedIstack = new ArrayList<objectStore>(10)




    }
}

// 55 + 4 *( 2 - 3 )
// limited to + - * / or an integer
//no letters or bullshit first

// were going to need a way to sort what needs to get done first
// keep track of how deep into parenthises we are one or two or more levels and
// we will also need to implment pemdas for base cases not in parenthisis

class objectStore {
    public Integer value
    public String type; // will likley change to enum

    objectStore(Integer value, String type) {
        this.value = value
        this.type = type
    }

}

enum ops{
    PLUS(1), MINUS(2), MULT(3), DIV(4)
}