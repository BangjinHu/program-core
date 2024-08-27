package theory.strings;

public class isValid {
    public static void main(String[] args) {
        String str =  "(())";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String str){
        if (str == null || str.equals("")){
            return false;
        }

        char[] chas = str.toCharArray();

        //检查每个字符串中左括号和右括号是否彼此对称
        //数量相同
//        int Lnum = 0;
//        int Rnum = 0;
//        for (int i = 0; i < chas.length; i++){
//            if (chas[i] == '('){
//                Lnum++;
//            }else if (chas[i] == ')'){
//                Rnum++;
//            }
//
//            if (chas[i] == ')'){
//                Lnum--;
//            }else if (chas[i] == ')'){
//                Rnum--;
//            }
//        }
        int status = 0;
        for (int i = 0; i < chas.length; i++){
            if (chas[i] != ')' && chas[i] != '('){
                return false;
            }

            if (chas[i] == '(' && --status < 0){
                return false;
            }

            if (chas[i] == '('){
                status++;
            }
        }
        return status == 0;
    }

}
