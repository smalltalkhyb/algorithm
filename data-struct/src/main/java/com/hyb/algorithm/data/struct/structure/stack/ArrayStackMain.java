package com.hyb.algorithm.data.struct.structure.stack;

public class ArrayStackMain {
    public static void main(String[] args) {


        ArrayStack<Integer> arrayStack=new ArrayStack<>();


        for(int i=0;i<10;i++){
            arrayStack.push(i);
        }

        arrayStack.pop();

        System.out.println(arrayStack);

        System.out.println(new ArrayStackMain().isValid("()[]{}"));

        System.out.println(new ArrayStackMain().isValid("()[{]{}"));
    }



    public boolean isValid(String s){
        ArrayStack<Character> stack=new ArrayStack<>();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(c=='('||c=='['||c=='{'){
                stack.push(c);
                continue;
            }

            if(stack.isEmpty()){
                return  false;
            }

            char topChar=stack.pop();

            if(c==')'&&topChar!='('){
                return false;
            }

            if(c==']'&&topChar!='['){
                return  false;
            }

            if(c=='}'&&topChar!='{'){
                return  false;
            }
        }

        return  stack.isEmpty();
    }

}
