import java.security.MessageDigest;

public class funcaoHash {

    public static void main(String[] args) {
        String mensagem = "Athena";
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = sha256.digest(mensagem.getBytes());

            StringBuilder hashHex = new StringBuilder();
            for (byte b : hashBytes) {
                hashHex.append(String.format("%02x", b));
            }

            System.out.println("Mensagem original: " + mensagem);
            System.out.println("Hash SHA-256: " + hashHex.toString());

        } catch (Exception e) {
            System.out.println("Erro ao gerar o hash: " + e.getMessage());
        }
    }
}



