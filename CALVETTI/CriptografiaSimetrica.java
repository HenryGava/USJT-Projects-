import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CriptografiaSimetrica {

    public static String criptografar(String texto, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] encryptedBytes = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String descriptografar(String textoCriptografado, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(textoCriptografado));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        try {
            // Gerar chave secreta AES
            SecretKey chaveAES = gerarChaveAES();
            System.out.println("Chave gerada (Base64): " + Base64.getEncoder().encodeToString(chaveAES.getEncoded()));

            // Texto original
            String textoOriginal = "Texto de exemplo para criptografia simétrica.";
            System.out.println("Texto original: " + textoOriginal);

            // Criptografar
            String textoCriptografado = criptografar(textoOriginal, chaveAES);
            System.out.println("Texto criptografado: " + textoCriptografado);

            // Descriptografar
            String textoDescriptografado = descriptografar(textoCriptografado, chaveAES);
            System.out.println("Texto descriptografado: " + textoDescriptografado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SecretKey gerarChaveAES() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // Tamanho da chave
        return keyGen.generateKey();
    }
}