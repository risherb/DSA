class Solution {
    public boolean parseBoolExpr(String expression) {
                Stack<Character> operations = new Stack<>();
        Stack<Character> vals = new Stack<>();
        boolean res = false;
        for(char c : expression.toCharArray()){
            switch(c){
                case '&','|','!' -> operations.push(c);
                case '(' -> {
                    vals.push('#');
                }
                case ')' -> {
                    char x =  vals.pop(), op = operations.pop();
                    boolean temp = false;
                    if(x == 't') temp = true;
                    if (op == '!') temp = !temp;
                    while((x = vals.pop()) != '#'){
                        if(x == 'f'){
                            temp = evaluate(op, temp, false);
                        }else
                            temp = evaluate(op, temp, true);
                    }
                    if(temp) vals.push('t');
                    else vals.push('f');
                    res = temp;
                }
                case 't','f' -> vals.push(c);
            }
        }
        return res;
    }
    boolean evaluate(char op, boolean res , boolean condition){
        return switch (op) {
            case '&' -> res & condition;
            case '|' -> res | condition;
            default -> !res;
        };
    }
}

    

