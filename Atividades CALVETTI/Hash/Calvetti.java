import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class Calvetti {
    public static void main(String[] args) throws Exception {
        String mensagem = "Mensagem super segura";

        // Gerar par de chaves RSA
        KeyPairGenerator chaveGen = KeyPairGenerator.getInstance("RSA");
        chaveGen.initialize(2048);
        KeyPair parDeChaves = chaveGen.generateKeyPair();

        PublicKey chavePublica = parDeChaves.getPublic();
        PrivateKey chavePrivada = parDeChaves.getPrivate();

        // Criptografar com chave pública
        Cipher cifra = Cipher.getInstance("RSA");
        cifra.init(Cipher.ENCRYPT_MODE, chavePublica);
        byte[] mensagemCriptografada = cifra.doFinal(mensagem.getBytes());

        // Descriptografar com chave privada
        cifra.init(Cipher.DECRYPT_MODE, chavePrivada);
        byte[] mensagemDescriptografada = cifra.doFinal(mensagemCriptografada);

        System.out.println("Original: " + mensagem);
        System.out.println("Criptografado: " + Base64.getEncoder().encodeToString(mensagemCriptografada));
        System.out.println("Descriptografado: " + new String(mensagemDescriptografada));
    }
}