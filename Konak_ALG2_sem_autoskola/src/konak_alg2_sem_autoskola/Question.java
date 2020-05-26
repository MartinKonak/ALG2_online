package konak_alg2_sem_autoskola;

/**
 * Object type Question
 * @author Martin Koňák
 */
public class Question {
    private String q;
    private String a1;
    private String a2;
    private String a3;
    private boolean b1;
    private boolean b2;
    private boolean b3;
    
    /**
     * Constructor
     * @param q - question
     * @param s1 - first answer
     * @param s2 - second answer
     * @param s3 - third answer
     */
    public Question(String q, String s1, String s2, String s3) {
        this.q = q;
        this.a1 = s1;
        this.a2 = s2;
        this.a3 = s3;
        b1 = getResult(a1);
        b2 = getResult(a2);
        b3 = getResult(a3);
    }
    
    public boolean getResult(String s){
        boolean b = (s.charAt(s.length()-2) == '1');        
        return b;
    }

    public boolean getB1() {
        return b1;
    }

    public boolean getB2() {
        return b2;
    }

    public boolean getB3() {
        return b3;
    }
    
    /**
     * Finds correct answer to a question
     * @return name of right answer
     */
    public String findCorrectAnswer(){
        if (getB1()) {
            return "a";
        }else if(getB2()) {
            return "b";
        }else if(getB3()) {
            return "c";
        }else{
            return "n";
        }
    }
    
    /**
     * Changes answers into right format
     * @param s - String answer
     * @return String
     */
    public String answerToString(String s){
        String[] stmp = s.split(" +");
        StringBuilder sb = new StringBuilder(""); 
        
        for (int i = 0; i < stmp.length-1; i++) {
            sb.append(stmp[i] + " ");            
        }
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n%s\n", q, answerToString(a1), answerToString(a2), answerToString(a3));
    }
    
    //testing method
    /*public static void main(String[] args){
        String[] s = {
            "01) Co smí užít řidič v provozu na pozemních komunikacích?",
            "a: Jen vozidlo, které splňuje technické podmínky stanovené zvláštním předpisem. (1)",
            "b: I vozidlo, které sice nesplňuje technické podmínky, ale majitel vozidla dovolí vozidlo užít nebo jeho užití přikáže. (0)",
            "c: I vozidlo, které splňuje jen některé technické podmínky stanovené zvláštním předpisem, pokud řidič dbá při jízdě zvýšené opatrnosti. (0)"
        };
        Question q = new Question(s[0], s[1], s[2], s[3]);
        System.out.println(s[1].charAt(s[1].length()-2));
        if (q.getB1()) {
            System.out.println("ano");
        }else{
            System.out.println("ne");
        }
        
    }*/
    
}
