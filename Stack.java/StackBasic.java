
import java.util.Stack;

public class StackBasic {
    public static boolean validParanthesis(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch == '(' || ch== '{' || ch=='['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()) return false;
                char top=stack.pop();
                if(ch==')' && top!='(') return false;
                if(ch=='}' && top!='{') return false;
                if(ch==']' && top!='[') return false;
            }
        }
        
        //int i=0;
        return stack.isEmpty();
    }
    
    public static void printele(){
        Stack<Integer> st=new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        System.out.println("The top element in the stack is : "+st.peek());
        st.pop();
        System.out.print("Remaining elements in the stack are : "+st);
        // while(!st.isEmpty()){
        //     System.out.print(st.pop()+" ");
        // }
    }
    public static String revString(String str){
        Stack<Character> st=new Stack<>();
        String rev="";
        for(int i=0;i<str.length();i++){
            st.push(str.charAt(i));
        }
        while(!st.isEmpty()){
            rev+=st.pop();
        }
        return rev;
    }
    public static int[] nextGreaterElement(int[] arr){
        Stack<Integer> st=new Stack<>();
        int nge[]=new int[arr.length];
        //int top=0;
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
                
            }
            if(st.isEmpty()) nge[i]=-1;
                else nge[i] =st.peek();
            
            st.push(arr[i]);
        }
        return nge;
    }
    public static void main(String args[]){
        int[] arr={2,4,3,6,8,1};
        int res[] =nextGreaterElement(arr);
        for(int i: res){
            System.out.print(i+", ");
        }
        //System.out.println("Next greater element array is : "+nextGreaterElement(arr));
        // for(int i: nextGreaterElement(nge))
        // String str="HELLO";
        // System.out.println("Reversed String : "+revString(str));
        //printele();
        // String s="({[]})";
        // System.out.println("is the string valid : "+validParanthesis(s));
    }
}
