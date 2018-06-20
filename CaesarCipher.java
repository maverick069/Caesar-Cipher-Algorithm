
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public String encrypt(String text, int code){
        int offset=26-code;
        StringBuilder encrp = new StringBuilder();
        int len = text.length(),index, encIndex;
        char encCh,ch;
        for(int i=0;i<len;i++){
            ch = text.charAt(i);
            if(ALPHABETS.indexOf(Character.toUpperCase(ch))>-1){
                index=ALPHABETS.indexOf(Character.toUpperCase(ch));
                if(index<offset){
                    encIndex=26-offset+index;
                }else{
                    encIndex=index-offset;
                }
                encrp.append(chkAndConvToLower(ch, ALPHABETS.charAt(encIndex)));
                
            }else{
                encrp.append(ch);
            }
        }
        return encrp.toString();
    }
    
    private int getOffsetIndex(int offset, int index){
        return index<offset?26-offset+index:index-offset;
    }
    
    public String encryptTwoKeys(String text, int odd, int even){
        int oddOffset=26-odd;
        int evenOffset=26-even;
        StringBuilder encrp = new StringBuilder();
        int len = text.length(),index, encIndex, encOffset;
        char encCh,ch;
        for(int i=0;i<len;i++){
            ch = text.charAt(i);
            if(ALPHABETS.indexOf(Character.toUpperCase(ch))>-1){
                index=ALPHABETS.indexOf(Character.toUpperCase(ch));
                if(i%2==0 || i==0){
                    encOffset=oddOffset;
                }else{
                    encOffset=evenOffset;
                }
                encrp.append(chkAndConvToLower(ch, ALPHABETS.charAt(getOffsetIndex(encOffset, index))));
            }else{
                encrp.append(ch);
            }
        }
        return encrp.toString();
    }
    
    private char chkAndConvToLower(char ch, char encCh){
        return Character.isLowerCase(ch)?Character.toLowerCase(encCh):encCh;
    }
    
    public void testAll(){
        System.out.println(("Cfopq Ibdflk".equals(encrypt("First Legion", 23))));
        System.out.println(("Wzijk Cvxzfe".equals(encrypt("First Legion", 17))));
        
        System.out.println(("Czojq Ivdzle".equals(encryptTwoKeys("First Legion", 23, 17))));
    }

}
