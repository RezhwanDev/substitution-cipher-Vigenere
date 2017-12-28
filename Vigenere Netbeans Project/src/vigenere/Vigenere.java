/**
 * @author Rezhwan Sidiq
 * 22/Nov/2017
 * 6:35
 */
package vigenere;
public class Vigenere {
    char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    void encripyion(String message,String key) {
        
        char[] charmessage = message.toCharArray();
        char[] charkey = key.toCharArray();
        int keylength  = key.length();

        int indexMessage[]=new int[charmessage.length];
        int indexkey[]    =new int[charmessage.length];
        int chipherIndex[]=new int[charmessage.length];
        
        // Message convert to index of alpha
        for (int i = 0; i < charmessage.length; i++) {
            for (int j = 0; j < alpha.length; j++) {
                if (charmessage[i] == alpha[j]) {
                    indexMessage[i] = j;
                }
            }
        }
        
        // Key convert to index of alpha
        for (int i = 0; i < charkey.length; i++) {
            for (int j = 0; j < alpha.length; j++) {
                if (charkey[i] == alpha[j]) {
                    indexkey[i] = j;
                }
            }
        }

        for (int i = 0; i < charmessage.length; i++) {
            indexkey[i] = indexkey[i % keylength];
        }
        
        for (int i = 0; i < chipherIndex.length; i++) {
            chipherIndex[i] = (indexMessage[i] + indexkey[i])%26;
        }
        
        System.out.print("cipher result -->");
          for (int i = 0; i < charmessage.length; i++) {
              System.out.print(alpha[chipherIndex[i]]);
        }    System.out.println("");
              System.out.println("---------------------------------------");
        }

    void decripyion(String message,String key) {
        
        char[] charmessage = message.toCharArray();
        char[] charkey = key.toCharArray();
        int keylength = key.length();
        
        int indexMessage[]=new int[charmessage.length];
        int indexkey[]    =new int[charmessage.length];
        int chipherIndex[]=new int[charmessage.length];

        // Cipher convert to index of alpha
        for (int i = 0; i < charmessage.length; i++) {
            for (int j = 0; j < alpha.length; j++) {
                if (charmessage[i] == alpha[j]) {
                    indexMessage[i] = j;
                }
            }
        }
        
        // Key convert to index of alpha
        for (int i = 0; i < charkey.length; i++) {
            for (int j = 0; j < alpha.length; j++) {
                if (charkey[i] == alpha[j]) {
                    indexkey[i] = j;
                }
            }
        }

        for (int i = 0; i < charmessage.length; i++) {
            indexkey[i] = indexkey[i % keylength];
        }

        for (int i = 0; i < chipherIndex.length; i++) {
            chipherIndex[i] = (indexMessage[i] - indexkey[i]+26)%26;
        }

          System.out.print("cipher result -->");
        for (int i = 0; i < charmessage.length; i++) {
          System.out.print(alpha[chipherIndex[i]]);
         }System.out.println("");
          System.out.println("-----------------------------------------");
    }

    public static void main(String[] args) {
        Vigenere cob = new Vigenere();
        cob.encripyion("rezhwan","abc");
        cob.decripyion("rfbhxcn","abc");
    }
}
/*Output
cipher result -->rfbhxcn
---------------------------------------
cipher result -->rezhwan
-----------------------------------------
*/